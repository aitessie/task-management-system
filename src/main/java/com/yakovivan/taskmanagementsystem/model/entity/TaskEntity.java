package com.yakovivan.taskmanagementsystem.model.entity;

import com.yakovivan.taskmanagementsystem.model.Priority;
import com.yakovivan.taskmanagementsystem.model.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


/**
 * Сущность задачи.
 */
@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_generator")
    @SequenceGenerator(name = "task_id_generator", sequenceName = "task_id_seq", allocationSize = 1)
    @Column(name = "task_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name = "author")
    private String author;

    @Column(name = "assignee")
    private String assignee;

    @Column(name = "create_dttm")
    private LocalDateTime createDttm;

    @Column(name = "update_dttm")
    private LocalDateTime updateDttm;

    @Column(name = "complete_dttm")
    private LocalDateTime completeDttm;

    @OneToMany(mappedBy = "taskEntity")
    private List<CommentEntity> comments;

    public TaskEntity(String title, String description, Status status, Priority priority, String author,
                      String assignee, LocalDateTime createDttm, LocalDateTime updateDttm,
                      LocalDateTime completeDttm) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.author = author;
        this.assignee = assignee;
        this.createDttm = createDttm;
        this.updateDttm = updateDttm;
        this.completeDttm = completeDttm;
    }
}
