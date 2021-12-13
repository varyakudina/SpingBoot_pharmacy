package com.boots.converter;

import com.boots.dto.OrderDTO;
import com.boots.entity.Order;

public class OrderConverter {
    public Order fromOrderDTOToOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setDeliveryAddress(orderDTO.getDeliveryAddress());
        order.setUserId(orderDTO.getUserId());
        order.setPaymentType(orderDTO.getPaymentType());
        return order;
    }

    public OrderDTO fromOrderToOrderDTO(Order order) {
        return OrderDTO.builder()
                .Id(order.getId())
                .deliveryAddress(order.getDeliveryAddress())
                .userId(order.getUserId())
                .paymentType(order.getPaymentType())
                .build();
    }
}
