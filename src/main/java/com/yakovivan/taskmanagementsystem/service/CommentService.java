package com.yakovivan.taskmanagementsystem.service;

import com.yakovivan.taskmanagementsystem.model.dto.CommentCreateDto;
import com.yakovivan.taskmanagementsystem.model.entity.CommentEntity;
import com.yakovivan.taskmanagementsystem.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TaskService taskService;

    public void createComment(CommentCreateDto dto) {
        commentRepository.save(new CommentEntity(taskService.getTaskEntityById(dto.getTaskId()), dto.getComment(),
                LocalDateTime.now(), ""));
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
