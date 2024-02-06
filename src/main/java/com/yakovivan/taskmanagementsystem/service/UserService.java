package com.yakovivan.taskmanagementsystem.service;

import com.yakovivan.taskmanagementsystem.config.MyUserDetails;
import com.yakovivan.taskmanagementsystem.model.dto.UserCreateDto;
import com.yakovivan.taskmanagementsystem.model.entity.UserEntity;
import com.yakovivan.taskmanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Сервис для обработки бизнес логики связанной с пользователями.
 */
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = repository.findByName(username);
        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }

    /**
     * Создание пользователя.
     *
     * @param dto dto для создания пользователя
     */
    public void createUser(UserCreateDto dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        repository.save(new UserEntity(dto.getName(),dto.getPassword(),dto.getRole()));
    }
}
