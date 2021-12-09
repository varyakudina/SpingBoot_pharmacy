package com.boots.converter;

import com.boots.dto.OrderStatusDTO;
import com.boots.entity.OrderStatus;

public class OrderStatusConverter {
    public OrderStatus fromOrderStatusDTOToOrderStatus(OrderStatusDTO orderStatusDTO) {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderId(orderStatusDTO.getOrderId());
        orderStatus.setDeliveryData(orderStatusDTO.getDeliveryData());
        orderStatus.setCheckoutData(orderStatusDTO.getCheckoutData());
        return orderStatus;
    }

    public OrderStatusDTO fromOrderStatusToOrderStatusDTO(OrderStatus orderStatus) {
        return OrderStatusDTO.builder()
                .orderId(orderStatus.getOrderId())
                .deliveryData(orderStatus.getDeliveryData())
                .checkoutData(orderStatus.getCheckoutData())
                .build();
    }
}