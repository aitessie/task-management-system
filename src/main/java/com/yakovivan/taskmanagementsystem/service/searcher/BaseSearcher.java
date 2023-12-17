package com.yakovivan.taskmanagementsystem.service.searcher;

import com.yakovivan.taskmanagementsystem.model.TaskFilterColumnName;
import com.yakovivan.taskmanagementsystem.model.entity.TaskEntity;
import com.yakovivan.taskmanagementsystem.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public abstract class BaseSearcher {

    protected final TaskRepository taskRepository;

    public abstract Page<TaskEntity> search(String searchParam, Pageable page);

    public abstract TaskFilterColumnName getColumnName();
}
