package com.yakovivan.taskmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    TO_DO("В ожидании"),
    IN_PROGRESS("В процессе"),
    COMPLETE("Завершено");

    private final String ruValue;
}
