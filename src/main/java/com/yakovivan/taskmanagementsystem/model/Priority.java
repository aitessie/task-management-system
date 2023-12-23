package com.yakovivan.taskmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Приоритеты задач.
 */
@AllArgsConstructor
@Getter
public enum Priority {
    HIGH("Высокий"),
    MIDDLE("Средний"),
    LOW("Низкий");

    private final String ruValue;
}
