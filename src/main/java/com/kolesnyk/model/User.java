package com.kolesnyk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String username;

    @Email
    private String email;

    @NotBlank
    private String phone;

    @NotNull
    private int balance;

    @NotNull
    private boolean enabled;

}
