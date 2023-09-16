package com.example.racoonello.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.UUID;

@Entity
public class BoardColumn {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Schema(required = true)
    private UUID id;

    @Column(nullable = false)
    @NotBlank
    private String title;

    @Column(nullable = false)
    @NotNull
    @Min(0)
    @Max(32767)
    private Short position;

    @CreationTimestamp
    @Schema(required = true)
    private Instant createdAt;

    @UpdateTimestamp
    @Schema(required = true)
    private Instant updatedAt;

    protected BoardColumn() {
    }

    public BoardColumn(final String title, final Short position) {
        this.title = title;
        this.position = position;
    }
}
