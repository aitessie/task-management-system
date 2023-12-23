package com.yakovivan.taskmanagementsystem.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Сущность комментария.
 */
@Entity
@Table(name = "comment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_generator")
    @SequenceGenerator(name = "comment_id_generator", sequenceName = "comment_id_seq", allocationSize = 1)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity taskEntity;

    @Column(name = "comment")
    private String comment;

    @Column(name = "create_dttm")
    private LocalDateTime createDttm;

    @Column(name = "author")
    private String author;

    public CommentEntity(TaskEntity taskEntity, String comment, LocalDateTime createDttm, String author) {
        this.taskEntity = taskEntity;
        this.comment = comment;
        this.createDttm = createDttm;
        this.author = author;
    }
}
