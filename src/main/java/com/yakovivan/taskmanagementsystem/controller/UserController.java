package com.yakovivan.taskmanagementsystem.controller;

import com.yakovivan.taskmanagementsystem.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
@AllArgsConstructor
public class UserController {

    private TaskService service;
}
