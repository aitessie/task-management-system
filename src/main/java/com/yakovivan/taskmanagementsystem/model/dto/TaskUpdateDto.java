package com.yakovivan.taskmanagementsystem.model.dto;

import com.yakovivan.taskmanagementsystem.model.Priority;
import com.yakovivan.taskmanagementsystem.model.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dto для обновления задачи.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskUpdateDto {

    @NotNull
    private Long id;

    @NotNull
    private String title;

    private String description;

    @NotNull
    private Priority priority;

    @NotNull
    private Status status;

    private String assignee;
}
