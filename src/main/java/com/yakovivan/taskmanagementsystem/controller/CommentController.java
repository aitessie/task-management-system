package com.yakovivan.taskmanagementsystem.controller;

import com.yakovivan.taskmanagementsystem.model.dto.CommentCreateDto;
import com.yakovivan.taskmanagementsystem.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для комментария.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService service;

    /**
     * Создание комментария.
     *
     * @param dto dto для создания комментария
     */
    @PostMapping
    public void createComment(@Valid @RequestBody CommentCreateDto dto) {
        service.createComment(dto);
    }

    /**
     * Удаление комментария.
     *
     * @param id ID комментария в БД
     */
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        service.deleteComment(id);
    }
}
