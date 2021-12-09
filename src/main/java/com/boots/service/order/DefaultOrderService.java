package com.boots.service.order;

import com.boots.dto.OrderDTO;
import com.boots.entity.Order;
import com.boots.exception.ValidationException;
import com.boots.repository.OrderRepository;
import com.boots.converter.OrderConverter;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultOrderService implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) throws ValidationException {
        validateOrderDto(orderDTO);
        Order savedOrder = orderRepository.save(orderConverter.fromOrderDTOToOrder(orderDTO));
        return orderConverter.fromOrderToOrderDTO(savedOrder);
    }

    private void validateOrderDto(OrderDTO orderDTO) throws ValidationException {
        if (isNull(orderDTO)) {
            throw new ValidationException("Object order is null");
        }
        if (isNull(orderDTO.getOrder_id())) {
            throw new ValidationException("Order)id is empty");
        }
    }

    @Override
    public void deleteOrder(Integer order_id) {
        orderRepository.deleteById(order_id);
    }

    @Override
    public OrderDTO findByUserId(Integer user_id) {
        Order order = orderRepository.findByUserId(user_id);
        return orderConverter.fromOrderToOrderDTO(order);
    }

    @Override
    public List<OrderDTO> findAllOrder() {
        return orderRepository.findAll()
                .stream()
                .map(orderConverter::fromOrderToOrderDTO)
                .collect(Collectors.toList());
    }
}
