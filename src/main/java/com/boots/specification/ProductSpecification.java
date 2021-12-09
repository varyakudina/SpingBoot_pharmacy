package com.boots.specification;

import com.boots.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    public static Specification<Product> dosageC(Integer minDosage, Integer maxDosage) {
        if(minDosage == null) minDosage = 0;
        if(maxDosage == null) maxDosage = Integer.MAX_VALUE;
        Integer finalMinDosage = minDosage;
        Integer finalMaxDosage = maxDosage;
        return ((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("dosage"), finalMinDosage, finalMaxDosage));
    }

    public static Specification<Product> priceC(Integer minPrice, Integer maxPrice) {
        if(minPrice == null) minPrice = 0;
        if(maxPrice == null) maxPrice = Integer.MAX_VALUE;
        Integer finalMinPrice = minPrice;
        Integer finalMaxPrice = maxPrice;
        return ((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("price"), finalMinPrice, finalMaxPrice));
    }

    public static Specification<Product> quantityC(Integer minQuantity, Integer maxQuantity) {
        if(minQuantity == null) minQuantity = 0;
        if(maxQuantity == null) maxQuantity = Integer.MAX_VALUE;
        Integer finalMinQuantity = minQuantity;
        Integer finalMaxQuantity = maxQuantity;
        return ((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("quantity"), finalMinQuantity, finalMaxQuantity));
    }

    public static Specification<Product> descriptionC(String search) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("description"), search);
    }
}
