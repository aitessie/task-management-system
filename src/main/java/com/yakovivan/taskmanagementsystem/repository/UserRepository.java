package com.yakovivan.taskmanagementsystem.repository;

import com.yakovivan.taskmanagementsystem.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий для общения с таблицей пользователей.
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByName (String name);
}
