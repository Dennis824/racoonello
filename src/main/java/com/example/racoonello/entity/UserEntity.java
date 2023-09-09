package com.example.racoonello.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    private Long id;

    @NotEmpty(message = "Username can not be empty")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "Password can not be empty")
    @Column(name = "password")
    private String password;

    @NotEmpty(message = "FirstName can not be empty")
    @Column(name = "firstName")
    private String firstName;

    @NotEmpty(message = "LastName can not be empty")
    @Column(name = "lastName")
    private String lastName;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @ToString.Include(name = "password")
    private String maskPassword() {
        return "********";
    }
}