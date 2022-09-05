package com.kolesnyk.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue
    private int id;

    private String username;

    private String email;

    private String phone;

    private int balance;

    private boolean enabled;

}
