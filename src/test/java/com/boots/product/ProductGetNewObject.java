package com.boots.product;

import com.boots.dto.ProductDTO;



public class ProductGetNewObject {
    public static ProductDTO getProduct() {
        return new ProductDTO(1,"acc" , "price = 20", 10,20,15,3);
    }
}