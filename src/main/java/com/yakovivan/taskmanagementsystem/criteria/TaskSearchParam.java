package com.yakovivan.taskmanagementsystem.criteria;

import com.yakovivan.taskmanagementsystem.model.Priority;
import com.yakovivan.taskmanagementsystem.model.Status;

import java.time.LocalDateTime;

public class TaskSearchParam {

    private String title;

    private String description;

    private Status status;

    private Priority priority;

    private String author;

    private String assignee;

    private LocalDateTime createDttmStart;
    private LocalDateTime createDttmEnd;

    private LocalDateTime updateDttmStart;
    private LocalDateTime updateDttmEnd;

    private LocalDateTime completeDttmStart;
    private LocalDateTime completeDttmEnd;
}
