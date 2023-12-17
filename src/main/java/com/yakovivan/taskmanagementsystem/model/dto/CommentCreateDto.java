package com.yakovivan.taskmanagementsystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentCreateDto {

    private Long taskId;

    private String comment;
}
