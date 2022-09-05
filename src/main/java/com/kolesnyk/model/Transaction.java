package com.kolesnyk.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue
    private int id;

    private int amount;

//    @ManyToOne
    private int productId;

    //status in transaction and batch
    //todo
    //fix entity
    //migrations for structure
    //DTO

    //    @ManyToOne
    private int userId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
