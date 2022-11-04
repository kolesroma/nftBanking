package com.kolesnyk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "batch")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BatchEntity {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String comment;

    @NotNull
    private int priority;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime updatedAt;

    @NotNull
    private boolean status;
}
