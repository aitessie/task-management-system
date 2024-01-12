package com.yakovivan.taskmanagementsystem.model.dto;

import com.yakovivan.taskmanagementsystem.model.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dto для создания задачи.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskCreateDto {

    @NotBlank
    private String title;

    private String description;

    @NotNull
    private Priority priority;

    private String assignee;
}
