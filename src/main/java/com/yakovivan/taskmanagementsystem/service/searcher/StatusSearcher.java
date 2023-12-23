package com.yakovivan.taskmanagementsystem.service.searcher;

import com.yakovivan.taskmanagementsystem.model.TaskFilterColumnName;
import com.yakovivan.taskmanagementsystem.model.entity.TaskEntity;
import com.yakovivan.taskmanagementsystem.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Сервис для поиска по статусу.
 */
@Service
public class StatusSearcher extends BaseSearcher {

    public StatusSearcher(TaskRepository taskRepository) {
        super(taskRepository);
    }

    @Override
    public Page<TaskEntity> search(String searchParam, Pageable page) {
        return taskRepository.findByStatusContains(searchParam, page);
    }

    @Override
    public TaskFilterColumnName getColumnName() {
        return TaskFilterColumnName.STATUS;
    }
}
