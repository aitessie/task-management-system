package com.yakovivan.taskmanagementsystem.model.dto;

import com.yakovivan.taskmanagementsystem.model.Priority;
import com.yakovivan.taskmanagementsystem.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDto {

    private Long id;

    private LocalDateTime createDttm;

    private LocalDateTime updateDttm;

    private LocalDateTime completeDttm;

    private String title;

    private String description;

    private Status status;

    private Priority priority;

    private String author;

    private String assignee;

    private List<CommentDto> comments;
}
