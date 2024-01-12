package com.yakovivan.taskmanagementsystem.controller;

import com.yakovivan.taskmanagementsystem.model.dto.CommentCreateDto;
import com.yakovivan.taskmanagementsystem.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Создание комментария")
    @ApiResponses({@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "500")})
    public void createComment(@Valid @RequestBody CommentCreateDto dto) {
        service.createComment(dto);
    }

    /**
     * Удаление комментария.
     *
     * @param id ID комментария в БД
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление комментария")
    @ApiResponses({@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "500")})
    public void deleteComment(@PathVariable Long id) {
        service.deleteComment(id);
    }
}
