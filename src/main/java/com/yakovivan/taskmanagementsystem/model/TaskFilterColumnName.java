package com.yakovivan.taskmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskFilterColumnName {

    TITLE("title"),
    DESCRIPTION("description"),
    STATUS("status"),
    PRIORITY("priority"),
    AUTHOR("author"),
    ASSIGNEE("assignee");

    private final String columnName;
}
