package com.yakovivan.taskmanagementsystem.service;

import com.yakovivan.taskmanagementsystem.model.dto.CommentCreateDto;
import com.yakovivan.taskmanagementsystem.model.entity.CommentEntity;
import com.yakovivan.taskmanagementsystem.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Сервис, содержащий бизнес-логику по работе с комментариями.
 */
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TaskService taskService;

    /**
     * Создание комментария.
     *
     * @param dto dto для создания комментария
     */
    public void createComment(CommentCreateDto dto) {
        commentRepository.save(new CommentEntity(taskService.getTaskEntityById(dto.getTaskId()), dto.getComment(),
                LocalDateTime.now(), ""));
    }

    /**
     * Удаление комментария по ID.
     *
     * @param id ID комментария в БД
     */
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
