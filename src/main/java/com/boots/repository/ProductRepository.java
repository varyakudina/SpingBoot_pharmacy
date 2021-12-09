package com.boots.repository;

import com.boots.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.awt.*;

public interface ProductRepository extends JpaRepository<Product,Integer>, JpaSpecificationExecutor<Product> {

    Product findByProduct_id(Integer product_id);

}
