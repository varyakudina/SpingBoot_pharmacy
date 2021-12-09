package com.boots.converter;

import com.boots.dto.OrderDTO;
import com.boots.entity.Order;

public class OrderConverter {
    public Order fromOrderDTOToOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrder_id(orderDTO.getOrder_id());
        order.setDelivery_address(orderDTO.getDelivery_address());
        order.setUser_id(orderDTO.getUser_id());
        order.setPayment_type(orderDTO.getPayment_type());
        return order;
    }

    public OrderDTO fromOrderToOrderDTO(Order order) {
        return OrderDTO.builder()
                .order_id(order.getOrder_id())
                .delivery_address(order.getDelivery_address())
                .user_id(order.getUser_id())
                .payment_type(order.getPayment_type())
                .build();
    }
}
