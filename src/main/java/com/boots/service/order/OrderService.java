package com.boots.service.order;

import com.boots.dto.OrderDTO;
import com.boots.exception.ValidationException;

import java.util.List;
public interface OrderService {

    OrderDTO saveOrder(OrderDTO orderDTO) throws ValidationException;

    void deleteOrder(Integer Id);

    OrderDTO findByUserId(Integer userId);

    List<OrderDTO> findAllOrder();
}
