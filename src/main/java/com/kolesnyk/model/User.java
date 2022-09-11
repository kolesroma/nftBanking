package com.kolesnyk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @NotBlank
    private String username;

    private String email;

    @NotNull
    @NotBlank
    private String phone;

    @NotNull
    @NotBlank
    private int balance;

    @NotNull
    private boolean enabled;

}
