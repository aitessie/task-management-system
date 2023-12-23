package com.yakovivan.taskmanagementsystem.service.searcher;

import com.yakovivan.taskmanagementsystem.model.TaskFilterColumnName;
import com.yakovivan.taskmanagementsystem.model.entity.TaskEntity;
import com.yakovivan.taskmanagementsystem.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Сервис для поиска по столбцу.
 */
@RequiredArgsConstructor
public abstract class BaseSearcher {

    protected final TaskRepository taskRepository;

    /**
     * Поиск задач по столбцу.
     *
     * @param searchParam значение столбца по которому нужно найти задачи
     * @param page        страница с задачами
     * @return {@link Page}, содержащая задачи и информацию о пагинации
     */
    public abstract Page<TaskEntity> search(String searchParam, Pageable page);

    /**
     * Получение названия столбца.
     *
     * @return {@link TaskFilterColumnName}
     */
    public abstract TaskFilterColumnName getColumnName();
}
