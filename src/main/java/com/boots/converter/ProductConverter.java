package com.boots.converter;

import com.boots.dto.ProductDTO;
import com.boots.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product fromProductDTOToProduct(ProductDTO productDTO) {
        Product product= new Product();
        product.setProduct_id(productDTO.getProduct_id());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setDosage(productDTO.getDosage());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setStore_id(productDTO.getStore_id());
        return product;
    }

    public ProductDTO fromProductToProductDTO(Product product) {
        return ProductDTO.builder()
                .product_id(product.getProduct_id())
                .name(product.getName())
                .description(product.getDescription())
                .dosage(product.getDosage())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .store_id(product.getStore_id())
                .build();
    }
}
