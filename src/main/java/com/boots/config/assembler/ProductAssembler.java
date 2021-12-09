package com.boots.config.assembler;

import com.boots.controller.ProductController;
import com.boots.dto.ProductDTO;
import com.boots.entity.Product;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ProductAssembler extends RepresentationModelAssemblerSupport<Product, ProductDTO> {


    public ProductAssembler() {
        super(ProductController.class, ProductDTO.class);
    }
    @Override
    public CollectionModel<ProductDTO> toCollectionModel(Iterable<? extends Product> entity)
    {
        CollectionModel<ProductDTO> productDTOS = super.toCollectionModel(entity);

        productDTOS.add(linkTo(methodOn(ProductController.class).findAllProduct(Pageable.unpaged())).withSelfRel());

        return productDTOS;
    }

    @Override
    public ProductDTO toModel(Product product) {
        ProductDTO productDTO = instantiateModel(product);

        productDTO.add(linkTo(
                methodOn(ProductController.class)
                        .findByProduct_id(product.getProduct_id()))
                .withSelfRel());
        productDTO.setProduct_id(product.getProduct_id());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setDosage(product.getDosage());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setStore_id(product.getProduct_id());
        return productDTO;
    }
}













