package com.yakovivan.taskmanagementsystem.model.dto;

import com.yakovivan.taskmanagementsystem.model.Priority;
import com.yakovivan.taskmanagementsystem.model.Status;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private Long id;

    @NotBlank
    private String title;

    private String description;

    @NotNull
    private Priority priority;

    @NotNull
    private Status status;

    private String assignee;
}
