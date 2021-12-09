package com.boots.service.order;

import com.boots.dto.OrderDTO;
import com.boots.exception.ValidationException;

import java.util.List;
public interface OrderService {

    OrderDTO saveOrder(OrderDTO orderDTO) throws ValidationException;

    void deleteOrder(Integer order_id);

    OrderDTO findByUserId(Integer user_id);

    List<OrderDTO> findAllOrder();
}
