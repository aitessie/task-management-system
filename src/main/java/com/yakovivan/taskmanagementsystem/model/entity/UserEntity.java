package com.yakovivan.taskmanagementsystem.model.entity;

import com.yakovivan.taskmanagementsystem.model.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Сущность пользователя.
 */
@Entity
@Table(name = "tms_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tms_user_id_generator")
    @SequenceGenerator(name = "tms_user_id_generator", sequenceName = "tms_user_id_seq", allocationSize = 1)
    @Column(name = "tms_user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private UserRole role;


    public UserEntity(String name, String password, UserRole role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
