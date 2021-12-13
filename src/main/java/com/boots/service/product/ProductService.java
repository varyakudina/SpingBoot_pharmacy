package com.boots.service.product;

import com.boots.dto.ProductDTO;
import com.boots.entity.Product;
import com.boots.exception.ValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    ProductDTO saveProduct(ProductDTO productDTO) throws ValidationException;

    void deleteProduct(Integer Id);

    ProductDTO findById(Integer Id);

    Page<Product> filterAll(Integer minDosage, Integer maxDosage, Integer minPrice, Integer maxPrice,Integer minQuantity, Integer maxQuantity, String description, Integer page, Integer size, String sort, Pageable defaultPageable);

    Page<Product> findAllProduct(Pageable defaultPageable);

    void update(ProductDTO productDTO);
}
