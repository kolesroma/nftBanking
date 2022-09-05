package com.kolesnyk.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "batch")
@Data
public class Batch {
    @Id
    @GeneratedValue
    private int id;

    private int priority;

    private String comment;

    private Date createdAt;

    private Date updatedAt;
}
