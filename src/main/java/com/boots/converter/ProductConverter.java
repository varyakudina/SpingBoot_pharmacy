package com.boots.converter;

import com.boots.dto.ProductDTO;
import com.boots.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product fromProductDTOToProduct(ProductDTO productDTO) {
        Product product= new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setDosage(productDTO.getDosage());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setStoreId(productDTO.getStoreId());
        return product;
    }

    public ProductDTO fromProductToProductDTO(Product product) {
        return ProductDTO.builder()
                .Id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .dosage(product.getDosage())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .storeId(product.getStoreId())
                .build();
    }
}
