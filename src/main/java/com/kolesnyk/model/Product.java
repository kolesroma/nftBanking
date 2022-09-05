package com.kolesnyk.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue
    private int id;

    private String upc;

    private String shortName;

    private String longName;

    private String description;

    private int price;
}
