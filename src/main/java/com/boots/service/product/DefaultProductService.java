package com.boots.service.product;

import com.boots.dto.ProductDTO;
import com.boots.entity.Product;
import com.boots.exception.ValidationException;
import com.boots.repository.ProductRepository;
import com.boots.converter.ProductConverter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import static com.boots.specification.ProductSpecification.*;
import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;


    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) throws ValidationException {
        validateProductDto(productDTO);
        Product savedProduct = productRepository.save(productConverter.fromProductDTOToProduct(productDTO));
        return productConverter.fromProductToProductDTO(savedProduct);
    }

    private void validateProductDto(ProductDTO productDTO) throws ValidationException {
        if (isNull(productDTO)) {
            throw new ValidationException("Object product is null");
        }
        if (isNull(productDTO.getProduct_id())){
            throw new ValidationException("Product_id is empty");
        }
    }

    public void update (ProductDTO productDTO) {
            productRepository.save(this.productConverter.fromProductDTOToProduct(productDTO));
    }

    public Page<Product> filterAll(Integer minDosage, Integer maxDosage, Integer minPrice, Integer maxPrice,Integer minQuantity, Integer maxQuantity, String description, Integer page, Integer size, String sort, Pageable defaultPageable) {
        Specification<Product> specification = Specification.where(minDosage != null || maxDosage != null ? dosageC(minDosage, maxDosage) : null)
                .and(minPrice != null || maxPrice != null ? priceC(minPrice, maxPrice) : null)
                .and(minQuantity != null || maxQuantity != null ? quantityC(minQuantity, maxQuantity) : null)
                .and(description == null ? null : descriptionC(description));
        Pageable pageable;
        if (page == null || size == null || sort == null) {
            pageable = defaultPageable;
        } else {
            pageable = PageRequest.of(page, size, defaultPageable.getSort());
        }
        return  productRepository.findAll(specification, pageable);
    }

    @Override
    public void deleteProduct(Integer product_id) {
        productRepository.deleteById(product_id);
    }

    @Override
    public ProductDTO findByProduct_id(Integer product_id) {
        Product product = productRepository.findByProduct_id(product_id);
        if (product != null) {
            return productConverter.fromProductToProductDTO(product);
        }
        return null;
    }

    @Override
    public Page<Product> findAllProduct(Pageable defaultPageable) {
        return productRepository.findAll(defaultPageable);
    }


}

