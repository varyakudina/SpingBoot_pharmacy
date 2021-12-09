package com.boots.service.orderStatus;

import com.boots.dto.OrderStatusDTO;
import com.boots.entity.OrderStatus;
import com.boots.exception.ValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderStatusService {

    OrderStatusDTO saveOrderStatus(OrderStatusDTO orderStatusDTO) throws ValidationException;

    void deleteOrderStatus(Integer orderId);

    OrderStatusDTO findByOrderId(Integer orderId);

    Page<OrderStatus> filterAll(Integer minCheckData, Integer maxCheckData, Integer minDelivData, Integer maxDelivData, String description, Integer page, Integer size, String sort, Pageable defaultPageable);

    Page<OrderStatus> findAllOrderStatus(Pageable defaultPageable);
}
