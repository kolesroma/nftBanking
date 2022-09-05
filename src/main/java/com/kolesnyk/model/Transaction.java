package com.kolesnyk.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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

    //    @ManyToOne
    private int userId;

    private Date createdAt;

    private Date updatedAt;
}
