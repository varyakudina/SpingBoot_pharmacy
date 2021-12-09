package com.boots.controller;

import com.boots.config.assembler.ProductAssembler;
import com.boots.dto.ProductDTO;
import com.boots.entity.Product;
import com.boots.exception.ValidationException;
import com.boots.service.product.ProductService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;

@RestController
@RequestMapping("/product")
@Log

public class ProductController {

    private PagedResourcesAssembler<Product> pagedResourcesAssembler;
    private ProductAssembler productAssembler;

    @Autowired
    ProductService productService;

    public ProductController() {
        this.pagedResourcesAssembler = pagedResourcesAssembler;
        this.productAssembler = productAssembler;
    }

    @PostMapping("/save")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) throws ValidationException {
        log.info("Handling save product: " + productDTO);
        return productService.saveProduct(productDTO);
    }

    @GetMapping(value = "/filter")
    public ResponseEntity<PagedModel<ProductDTO>> filterAll(@RequestParam(required = false)
                                                                        Integer minDosage, Integer maxDosage,
                                                            Integer minPrice, Integer maxPrice,Integer minQuantity, Integer maxQuantity,
                                                            String search,
                                                            Integer page, Integer size, String sort,
                                                          @PageableDefault(sort = {"price"}, direction = Sort.Direction.ASC) Pageable defaultPageable) throws ValidationException{

        final Page<Product> products = productService.filterAll(minDosage, maxDosage, minPrice, maxPrice, minQuantity, maxQuantity, search, page, size, sort, defaultPageable);
        PagedModel<ProductDTO> dto = pagedResourcesAssembler.toModel(products, productAssembler);
        return !products.isEmpty()
                ? ResponseEntity.ok(dto)
                : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<PagedModel<ProductDTO>> findAllProduct(@PageableDefault(sort = {"price"}, direction = Sort.Direction.ASC) Pageable defaultPageable) {
        final Page<Product> products = productService.findAllProduct(defaultPageable);

        PagedModel<ProductDTO> productDTOS = pagedResourcesAssembler.toModel(products, productAssembler);
        return !products.isEmpty()
                ? ResponseEntity.ok(productDTOS)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/findProductByProductId")
    public ProductDTO findByProduct_id(@RequestParam Integer productId) {
        log.info("Handling find by product_id request: " + productId);
        return productService.findByProduct_id(productId);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer productId) {
        log.info("Handling delete product request: " + productId);
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
