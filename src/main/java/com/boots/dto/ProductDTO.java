package com.boots.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@AllArgsConstructor
public class ProductDTO extends RepresentationModel<ProductDTO> {

    private Integer Id;
    private String name;
    private String description;
    private Integer dosage;
    private Integer price;
    private Integer quantity;
    private Integer storeId;
}