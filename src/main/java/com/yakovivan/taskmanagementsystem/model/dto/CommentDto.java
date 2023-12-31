package com.yakovivan.taskmanagementsystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Dto для комментария.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentDto {

    private Long id;

    private Long taskId;

    private String comment;

    private LocalDateTime createDttm;

    private String author;
}
