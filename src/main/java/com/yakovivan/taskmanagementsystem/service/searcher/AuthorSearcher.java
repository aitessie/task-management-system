package com.yakovivan.taskmanagementsystem.service.searcher;

import com.yakovivan.taskmanagementsystem.model.TaskFilterColumnName;
import com.yakovivan.taskmanagementsystem.model.entity.TaskEntity;
import com.yakovivan.taskmanagementsystem.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Сервис для поиска по автору.
 */
@Service
public class AuthorSearcher extends BaseSearcher {

    public AuthorSearcher(TaskRepository taskRepository) {
        super(taskRepository);
    }

    @Override
    public Page<TaskEntity> search(String searchParam, Pageable page) {
        return taskRepository.findByAuthorContains(searchParam, page);
    }

    @Override
    public TaskFilterColumnName getColumnName() {
        return TaskFilterColumnName.AUTHOR;
    }

}
