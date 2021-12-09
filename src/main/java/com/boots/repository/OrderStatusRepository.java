package com.boots.repository;

import com.boots.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer>, JpaSpecificationExecutor<OrderStatus> {

    OrderStatus findByOrderId(Integer orderId);


}