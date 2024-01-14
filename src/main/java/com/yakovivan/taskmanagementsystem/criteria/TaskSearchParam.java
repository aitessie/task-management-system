package com.yakovivan.taskmanagementsystem.criteria;

import com.yakovivan.taskmanagementsystem.exception.TaskManagementSystemException;
import com.yakovivan.taskmanagementsystem.model.Priority;
import com.yakovivan.taskmanagementsystem.model.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TaskSearchParam{

    private String title;

    private String description;

    private Status status;

    private Priority priority;

    private String author;

    private Boolean hasAssignee;

    private String assignee;

    private LocalDateTime createDttmStart;
    private LocalDateTime createDttmEnd;

    private LocalDateTime updateDttmStart;
    private LocalDateTime updateDttmEnd;

    private LocalDateTime completeDttmStart;
    private LocalDateTime completeDttmEnd;

    public void handleIncorrectData(LocalDateTime DttmStart, LocalDateTime DttmEnd){
        if (DttmStart != null && DttmEnd != null && DttmStart.isAfter(DttmEnd)) {
            throw new TaskManagementSystemException(String
                    .format("Incorrect dates. Start date =%s > End date = %s", DttmStart, DttmEnd));
        }
    }
}
