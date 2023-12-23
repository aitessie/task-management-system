package com.yakovivan.taskmanagementsystem.controller;

import com.yakovivan.taskmanagementsystem.model.dto.PageDto;
import com.yakovivan.taskmanagementsystem.model.TaskFilterColumnName;
import com.yakovivan.taskmanagementsystem.model.TaskSortColumnName;
import com.yakovivan.taskmanagementsystem.model.dto.TaskCreateDto;
import com.yakovivan.taskmanagementsystem.model.dto.TaskDto;
import com.yakovivan.taskmanagementsystem.model.dto.TaskUpdateDto;
import jakarta.validation.Valid;
import com.yakovivan.taskmanagementsystem.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для задачи.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskService service;

    /**
     * Создание задачи.
     *
     * @param dto dto для создания задачи
     */
    @PostMapping
    public void createTask(@Valid @RequestBody TaskCreateDto dto) {
        service.createTask(dto);
    }

    /**
     * Обновление полей задачи.
     *
     * @param dto dto для обновления задачи
     */
    @PutMapping
    public void updateTask(@Valid @RequestBody TaskUpdateDto dto) {
        service.updateTask(dto);
    }

    /**
     * Удаление задачи по ID.
     *
     * @param id ID задачи в БД
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
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
    @GetMapping()
    public PageDto<TaskDto> getTasksSortedByColumnWithFilter(@RequestParam(required = false, defaultValue = "TITLE") TaskSortColumnName taskSortColumnName,
                                                             @RequestParam(required = false, defaultValue = "ASC") Sort.Direction direction,
                                                             @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                             @RequestParam(required = false) TaskFilterColumnName taskFilterColumnName,
                                                             @RequestParam(required = false) String searchParam) {

        return service.getTasksSortedByColumn(taskSortColumnName, direction, pageNumber, pageSize, taskFilterColumnName, searchParam);
    }
}
