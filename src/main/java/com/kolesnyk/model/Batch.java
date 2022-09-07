package com.kolesnyk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "batch")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Batch {
    @Id
    @GeneratedValue
    private int id;

    private int priority;

    private String comment;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean status;
}
