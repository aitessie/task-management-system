package com.yakovivan.taskmanagementsystem.repository;

import com.yakovivan.taskmanagementsystem.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для общения с таблицей комментариев.
 */
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}
