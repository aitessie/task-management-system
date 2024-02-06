package com.yakovivan.taskmanagementsystem.model.dto;

import com.yakovivan.taskmanagementsystem.model.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dto для пользователя.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserCreateDto {

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotNull
    private UserRole role;
}
