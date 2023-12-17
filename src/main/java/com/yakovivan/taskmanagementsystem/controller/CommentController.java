package com.yakovivan.taskmanagementsystem.controller;

import com.yakovivan.taskmanagementsystem.model.dto.CommentCreateDto;
import com.yakovivan.taskmanagementsystem.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService service;

    @PostMapping
    public void createComment(@Valid @RequestBody CommentCreateDto dto) {
        service.createComment(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        service.deleteComment(id);
    }
}
