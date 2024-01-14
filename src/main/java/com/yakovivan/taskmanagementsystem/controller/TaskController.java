package com.yakovivan.taskmanagementsystem.controller;

import com.yakovivan.taskmanagementsystem.criteria.TaskSearchParam;
import com.yakovivan.taskmanagementsystem.model.dto.PageDto;
import com.yakovivan.taskmanagementsystem.model.TaskFilterColumnName;
import com.yakovivan.taskmanagementsystem.model.TaskSortColumnName;
import com.yakovivan.taskmanagementsystem.model.dto.TaskCreateDto;
import com.yakovivan.taskmanagementsystem.model.dto.TaskDto;
import com.yakovivan.taskmanagementsystem.model.dto.TaskUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    //http://localhost:8085/swagger-ui/index.html путь к сваггеру

    private final TaskService service;

    /**
     * Создание задачи.
     *
     * @param dto dto для создания задачи
     */
    @PostMapping
    @Operation(summary = "Создание задачи")
    @ApiResponses({@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "500")})
    public void createTask(@Valid @RequestBody TaskCreateDto dto) {
        service.createTask(dto);
    }

    /**
     * Обновление полей задачи.
     *
     * @param dto dto для обновления задачи
     */
    @PutMapping
    @Operation(summary = "Обновление полей задачи")
    @ApiResponses({@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "500")})
    public void updateTask(@Valid @RequestBody TaskUpdateDto dto) {
        service.updateTask(dto);
    }

    /**
     * Удаление задачи по ID.
     *
     * @param id ID задачи в БД
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление задачи по ID")
    @ApiResponses({@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "500")})
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
    @Operation(summary = "Получение списка задач постранично с сортировкой и фильтрацией по одному полю")
    @ApiResponses({@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "500")})
    public PageDto<TaskDto> getTasksSortedByColumnWithFilter(
            @RequestParam(required = false, defaultValue = "TITLE") TaskSortColumnName taskSortColumnName,
            @RequestParam(required = false, defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) TaskFilterColumnName taskFilterColumnName,
            @RequestParam(required = false) String searchParam) {

        return service.getTasksSortedByColumn(
                taskSortColumnName, direction, pageNumber, pageSize, taskFilterColumnName, searchParam);
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
    @PostMapping("/search")
    @Operation(summary = "Получение списка задач постранично с сортировкой и фильтрацией по нескольким полям")
    @ApiResponses({@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "500")})
    public PageDto<TaskDto> getTasksWithFilter(
            @RequestParam(required = false, defaultValue = "TITLE") TaskSortColumnName taskSortColumnName,
            @RequestParam(required = false, defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestBody(required = false) TaskSearchParam taskSearchParam) {

        taskSearchParam.handleIncorrectData(taskSearchParam.getCreateDttmStart(),taskSearchParam.getCreateDttmEnd());
        taskSearchParam.handleIncorrectData(taskSearchParam.getUpdateDttmStart(),taskSearchParam.getUpdateDttmEnd());
        taskSearchParam.handleIncorrectData(taskSearchParam.getCompleteDttmStart(),taskSearchParam.getCompleteDttmEnd());

        return service.getTasksFilteredAndSorted(
                taskSortColumnName, direction, pageNumber, pageSize, taskSearchParam);
    }
}
