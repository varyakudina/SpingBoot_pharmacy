package com.boots.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
public class ProductDTO extends RepresentationModel<ProductDTO> {

    private Integer product_id;
    private String name;
    private String description;
    private Integer dosage;
    private Integer price;
    private Integer quantity;
    private Integer store_id;
}