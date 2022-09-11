package com.kolesnyk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreationDto {
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
