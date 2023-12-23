package com.yakovivan.taskmanagementsystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Dto для страницы.
 *
 * @param <T> тип данных, которыц содержится в таблице
 */
@AllArgsConstructor
@Setter
@Getter
public class PageDto<T> {

    private List<T> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalPages;
    private Long totalElements;
}
