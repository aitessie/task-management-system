package com.yakovivan.taskmanagementsystem.criteria;

import com.yakovivan.taskmanagementsystem.model.Priority;
import com.yakovivan.taskmanagementsystem.model.Status;
import com.yakovivan.taskmanagementsystem.model.entity.TaskEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class TaskSpecificationUtil {

    public static Specification<TaskEntity> titleContains(String titleValue) {
        if (titleValue == null) {
            return null;
        }
        return (taskEntity, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(taskEntity.get("title"), "%" + titleValue + "%");
    }

    public static Specification<TaskEntity> descriptionContains(String descriptionValue) {
        if (descriptionValue == null) {
            return null;
        }
        return (taskEntity, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(taskEntity.get("description"), "%" + descriptionValue + "%");
    }

    public static Specification<TaskEntity> statusContains(Status statusValue) {
        if (statusValue == null) {
            return null;
        }
        return (taskEntity, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(taskEntity.get("status"), statusValue);
    }

    public static Specification<TaskEntity> priorityContains(Priority priorityValue) {
        if (priorityValue == null) {
            return null;
        }
        return (taskEntity, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(taskEntity.get("priority"), priorityValue);
    }

    public static Specification<TaskEntity> authorContains(String authorValue) {
        if (authorValue == null) {
            return null;
        }
        return (taskEntity, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(taskEntity.get("author"), "%" + authorValue + "%");
    }

    public static Specification<TaskEntity> assigneeContains(String assigneeValue) {
        if (assigneeValue == null) {
            return null;
        }
        return (taskEntity, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(taskEntity.get("assignee"), "%" + assigneeValue + "%");
    }

    public static Specification<TaskEntity> isAssigneeNull(Boolean hasAssignee) {
        if (hasAssignee == null) {
            return null;
        } else if (hasAssignee) {
            return (taskEntity, criteriaQuery, criteriaBuilder) ->
                    criteriaBuilder.isNotNull((taskEntity.get("assignee")));
        } else {
            return (taskEntity, criteriaQuery, criteriaBuilder) ->
                    criteriaBuilder.isNull((taskEntity.get("assignee")));
        }
    }

    public static Specification<TaskEntity> createDttmStartGreaterThan(LocalDateTime createDttmStart) {
        if (createDttmStart == null) {
            return null;
        }
        return (taskEntity, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThan(taskEntity.get("createDttm"), createDttmStart);
    }

    public static Specification<TaskEntity> createDttmEndLessThan(LocalDateTime createDttmEnd) {
        if (createDttmEnd == null) {
            return null;
        }
        return (taskEntity, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThan(taskEntity.get("createDttm"), createDttmEnd);
    }

    public static Specification<TaskEntity> updateDttmStartGreaterThan(LocalDateTime updateDttmStart) {
        if (updateDttmStart == null) {
            return null;
        }
        return (taskEntity, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThan(taskEntity.get("updateDttm"), updateDttmStart);
    }

    public static Specification<TaskEntity> updateDttmEndLessThan(LocalDateTime updateDttmEnd) {
        if (updateDttmEnd == null) {
            return null;
        }
        return (taskEntity, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThan(taskEntity.get("updateDttm"), updateDttmEnd);
    }

    public static Specification<TaskEntity> completeDttmStartGreaterThan(LocalDateTime completeDttmStart) {
        if (completeDttmStart == null) {
            return null;
        }
        return (taskEntity, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThan(taskEntity.get("completeDttm"), completeDttmStart);
    }

    public static Specification<TaskEntity> completeDttmEndLessThan(LocalDateTime completeDttmEnd) {
        if (completeDttmEnd == null) {
            return null;
        }
        return (taskEntity, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThan(taskEntity.get("completeDttm"), completeDttmEnd);
    }
}
