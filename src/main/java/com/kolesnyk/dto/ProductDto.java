package com.kolesnyk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private int id;

    private String description;

    private String shortName;

    private int price;

    private String fullName;

    private String upc;
}
