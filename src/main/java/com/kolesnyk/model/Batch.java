package com.kolesnyk.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "batch")
@Data
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int priority;

    private String comment;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
