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
public class ProductDto {
    @NotNull
    private int id;

    @NotBlank
    private String description;

    @NotBlank
    private String shortName;

    @NotNull
    private int price;

    @NotBlank
    private String fullName;

    @NotBlank
    private String upc;
}
