package com.yakovivan.taskmanagementsystem.repository;

import com.yakovivan.taskmanagementsystem.model.entity.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для общения с таблицей задач.
 */
@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long>, JpaSpecificationExecutor<TaskEntity> {

    Page<TaskEntity> findByTitleContains(String title, Pageable page);

    Page<TaskEntity> findByDescriptionContains(String description, Pageable page);

    Page<TaskEntity> findByStatusContains(String status, Pageable page);

    Page<TaskEntity> findByPriorityContains(String priority, Pageable page);

    Page<TaskEntity> findByAuthorContains(String author, Pageable page);

    Page<TaskEntity> findByAssigneeContains(String assignee, Pageable page);
}
