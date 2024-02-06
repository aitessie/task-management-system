package com.yakovivan.taskmanagementsystem.controller;

import com.yakovivan.taskmanagementsystem.model.dto.UserCreateDto;
import com.yakovivan.taskmanagementsystem.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для пользователя.
 */
@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    /**
     * Создание пользователя.
     *
     * @param dto dto для создания пользователя
     */
    @PostMapping()
    public void createUser(@Valid @RequestBody UserCreateDto dto) {
        service.createUser(dto);
    }
}
