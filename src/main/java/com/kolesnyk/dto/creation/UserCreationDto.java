package com.kolesnyk.dto.creation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreationDto {
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
