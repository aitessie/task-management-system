package com.yakovivan.taskmanagementsystem.service;

import com.yakovivan.taskmanagementsystem.criteria.TaskSearchParam;
import com.yakovivan.taskmanagementsystem.exception.TaskManagementSystemException;
import com.yakovivan.taskmanagementsystem.model.dto.PageDto;
import com.yakovivan.taskmanagementsystem.model.Status;
import com.yakovivan.taskmanagementsystem.model.TaskFilterColumnName;
import com.yakovivan.taskmanagementsystem.model.TaskSortColumnName;
import com.yakovivan.taskmanagementsystem.model.dto.TaskCreateDto;
import com.yakovivan.taskmanagementsystem.model.dto.TaskDto;
import com.yakovivan.taskmanagementsystem.model.dto.TaskUpdateDto;
import com.yakovivan.taskmanagementsystem.model.entity.TaskEntity;
import com.yakovivan.taskmanagementsystem.repository.TaskRepository;
import com.yakovivan.taskmanagementsystem.service.searcher.BaseSearcher;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.yakovivan.taskmanagementsystem.criteria.TaskSpecificationUtil.*;
import static com.yakovivan.taskmanagementsystem.criteria.TaskSpecificationUtil.titleContains;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 * Сервис для обработки бизнес логики связанной с задачами.
 */
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final Map<TaskFilterColumnName, BaseSearcher> searchers;

    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper, List<BaseSearcher> searcherList) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.searchers = searcherList.stream()
                .collect(Collectors.toMap(BaseSearcher::getColumnName, searcher -> searcher));
    }

    /**
     * Создание задачи.
     *
     * @param dto dto для создания задачи
     */
    public void createTask(TaskCreateDto dto) {
        taskRepository.save(new TaskEntity(dto.getTitle(), dto.getDescription(), Status.TO_DO, dto.getPriority(),
                "", dto.getAssignee(), LocalDateTime.now(), LocalDateTime.now(), null));
    }

    /**
     * Обновление полей задачи.
     *
     * @param dto dto для обновления задачи
     */
    public void updateTask(TaskUpdateDto dto) {
        TaskEntity taskEntity = getTaskEntityById(dto.getId());

        taskEntity.setTitle(dto.getTitle());
        taskEntity.setDescription(dto.getDescription());
        taskEntity.setStatus(dto.getStatus());
        taskEntity.setPriority(dto.getPriority());
        taskEntity.setAssignee(dto.getAssignee());
        taskEntity.setUpdateDttm(LocalDateTime.now());

        if (taskEntity.getStatus().equals(Status.COMPLETE)) {
            taskEntity.setCompleteDttm(LocalDateTime.now());
        }

        taskRepository.save(taskEntity);
    }

    /**
     * Удаление задачи по ID.
     *
     * @param id ID задачи в БД
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    TaskEntity getTaskEntityById(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow(() ->
                new TaskManagementSystemException(String.format("Not found task with id=%d", taskId)));
    }

    /**
     * Получение списка задач постранично и с сортировкой.
     *
     * @param taskSortColumnName   название столбца по которому производиться сортировка
     * @param direction            направление сортировки
     * @param pageNumber           номер запрашиваемой страницы
     * @param pageSize             количество задач на одной странице
     * @param taskFilterColumnName столбец для фильтрации
     * @param searchParam          ключевое слово поиска
     * @return {@link PageDto} содержащая задачи и информацию о пагинации
     */
    public PageDto<TaskDto> getTasksSortedByColumn(TaskSortColumnName taskSortColumnName, Sort.Direction direction,
                                                   Integer pageNumber, Integer pageSize,
                                                   TaskFilterColumnName taskFilterColumnName, String searchParam) {

        Pageable page = PageRequest.of(pageNumber, pageSize,
                Sort.by(direction, taskSortColumnName.getFieldName()));

        Page<TaskEntity> pageDb = searchers.get(taskFilterColumnName).search(searchParam, page);

        List<TaskDto> content = pageDb.getContent().stream()
                .map(taskEntity -> modelMapper.map(taskEntity, TaskDto.class)).toList();

        return new PageDto<>(content, pageDb.getPageable().getPageNumber(), pageDb.getPageable().getPageSize(),
                pageDb.getTotalPages(), pageDb.getTotalElements());
    }

    /**
     * Получение списка задач постранично с сортировкой и фильтрацией по нескольким полям.
     *
     * @param taskSortColumnName название столбца по которому производиться сортировка
     * @param direction          направление сортировки
     * @param pageNumber         номер запрашиваемой страницы
     * @param pageSize           количество задач на одной странице
     * @param taskSearchParam    параметры фильтрации
     * @return {@link PageDto} содержащая задачи и информацию о пагинации
     */
    public PageDto<TaskDto> getTasksFilteredAndSorted(TaskSortColumnName taskSortColumnName, Sort.Direction direction,
                                                      Integer pageNumber, Integer pageSize,
                                                      TaskSearchParam taskSearchParam) {

        Pageable page = PageRequest.of(pageNumber, pageSize,
                Sort.by(direction, taskSortColumnName.getFieldName()));

        Page<TaskEntity> pageDb;


        if (taskSearchParam == null) {
            pageDb = taskRepository.findAll(page);
        } else {
            pageDb = taskRepository.findAll(where(
                            titleContains(taskSearchParam.getTitle()))
                            .and(descriptionContains(taskSearchParam.getDescription()))
                            .and(statusContains(taskSearchParam.getStatus()))
                            .and(priorityContains(taskSearchParam.getPriority()))
                            .and(authorContains(taskSearchParam.getAuthor()))
                            .and(assigneeContains(taskSearchParam.getAssignee()))
                            .and(createDttmStartGreaterThan(taskSearchParam.getCreateDttmStart()))
                            .and(createDttmEndLessThan(taskSearchParam.getCreateDttmEnd()))
                            .and(updateDttmStartGreaterThan(taskSearchParam.getUpdateDttmStart()))
                            .and(updateDttmEndLessThan(taskSearchParam.getUpdateDttmEnd()))
                            .and(completeDttmStartGreaterThan(taskSearchParam.getCompleteDttmStart()))
                            .and(completeDttmEndLessThan(taskSearchParam.getCompleteDttmEnd()))
                            .and(isAssigneeNull(taskSearchParam.getHasAssignee())), page);
        }

        List<TaskDto> content = pageDb.getContent().stream()
                .map(taskEntity -> modelMapper.map(taskEntity, TaskDto.class)).toList();

        return new PageDto<>(content, pageDb.getPageable().getPageNumber(), pageDb.getPageable().getPageSize(),
                pageDb.getTotalPages(), pageDb.getTotalElements());
    }
}
