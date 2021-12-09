package com.boots.specification;

import com.boots.entity.OrderStatus;
import com.boots.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class OrderStatusSpecification {
    public static Specification<OrderStatus> checkDataC(Integer minCheckData, Integer maxCheckData) {
        if(minCheckData == null) minCheckData = 0;
        if(maxCheckData == null) maxCheckData = Integer.MAX_VALUE;
        Integer finalMinCheckData = minCheckData;
        Integer finalMaxCheckData = maxCheckData;
        return ((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("dosage"), finalMinCheckData, finalMaxCheckData));
    }
    public static Specification<OrderStatus> deliveryDAtaC(Integer minDelivData, Integer maxDelivData) {
        if(minDelivData == null) minDelivData = 0;
        if(maxDelivData == null) maxDelivData = Integer.MAX_VALUE;
        Integer finalMinDelivData = minDelivData;
        Integer finalMaxDelivData = maxDelivData;
        return ((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("dosage"), finalMinDelivData, finalMaxDelivData));
    }
    public static Specification<OrderStatus> descriptionA(String search) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("description"), search);
    }
}
