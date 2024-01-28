package com.yakovivan.taskmanagementsystem.config;

import com.yakovivan.taskmanagementsystem.model.UserRole;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class TaskManagementSystemConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//                User.builder()
//                        .username("user")
//                        .password(passwordEncoder().encode("user"))
//                        .roles(UserRole.USER.name())
//                        .build(),
//                User.builder()
//                        .username("admin")
//                        .password(passwordEncoder().encode("admin"))
//                        .roles(UserRole.ADMIN.name())
//                        .build()
//        );
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserService()
//        );
//    }


    @Bean
    protected SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/task").permitAll()
                        .requestMatchers(HttpMethod.GET).hasAnyRole(UserRole.USER.name(),UserRole.ADMIN.name())
                        .requestMatchers(HttpMethod.POST).hasAnyRole(UserRole.USER.name(),UserRole.ADMIN.name())
                        .requestMatchers(HttpMethod.PUT).hasAnyRole(UserRole.USER.name(),UserRole.ADMIN.name())
                        .requestMatchers(HttpMethod.DELETE).hasAnyRole(UserRole.ADMIN.name())
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
//                .formLogin((f4orm) -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout(LogoutConfigurer::permitAll)
        ;

        return http.build();
    }
}
