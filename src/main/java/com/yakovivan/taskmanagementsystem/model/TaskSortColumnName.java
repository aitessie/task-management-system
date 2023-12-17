package com.yakovivan.taskmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskSortColumnName {

    TITLE("title"),
    DESCRIPTION("description"),
    STATUS("status"),
    PRIORITY("priority"),
    AUTHOR("author"),
    ASSIGNEE("assignee"),
    CREATE_DTTM("createDttm"),
    UPDATE_DTTM("updateDttm"),
    COMPLETE_DTTM("completeDttm");

    private final String fieldName;
}
