package com.boots.service.orderStatus;

import com.boots.dto.OrderStatusDTO;
import com.boots.entity.OrderStatus;
import com.boots.exception.ValidationException;
import com.boots.repository.OrderStatusRepository;
import com.boots.converter.OrderStatusConverter;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.stream.Collectors;

import static com.boots.specification.OrderStatusSpecification.*;
import static java.util.Objects.isNull;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultOrderStatusService implements OrderStatusService {

    private final OrderStatusRepository orderStatusRepository;
    private final OrderStatusConverter orderStatusConverter;

    @Override
    public OrderStatusDTO saveOrderStatus(OrderStatusDTO orderStatusDTO) throws ValidationException {
        validateOrderStatusDto(orderStatusDTO);
        OrderStatus savedOrderStatus = orderStatusRepository.save(orderStatusConverter.fromOrderStatusDTOToOrderStatus(orderStatusDTO));
        return orderStatusConverter.fromOrderStatusToOrderStatusDTO(savedOrderStatus);
    }

    private void validateOrderStatusDto(OrderStatusDTO orderStatusDTO) throws ValidationException {
        if (isNull(orderStatusDTO)) {
            throw new ValidationException("Object orderStatus is null");
        }
        if (isNull(orderStatusDTO.getOrderId())) {
            throw new ValidationException("OrderStatus id is empty");
        }
    }

    public Page<OrderStatus> filterAll(Integer minCheckData, Integer maxCheckData, Integer minDelivData, Integer maxDelivData, String description, Integer page, Integer size, String sort, Pageable defaultPageable) {
        Specification<OrderStatus> specification = Specification.where(minCheckData != null || maxCheckData != null ? checkDataC(minCheckData, maxCheckData) : null)
                .and(minDelivData != null || maxDelivData != null ? deliveryDAtaC(minDelivData, maxDelivData) : null)
                .and(description == null ? null : descriptionA(description));
        Pageable pageable;
        if (page == null || size == null || sort == null) {
            pageable = defaultPageable;
        } else {
            pageable = PageRequest.of(page, size, defaultPageable.getSort());
        }
        return  orderStatusRepository.findAll(specification, pageable);
    }

    @Override
    public void deleteOrderStatus(Integer orderId) {
        orderStatusRepository.deleteById(orderId);
    }

    @Override
    public OrderStatusDTO findByOrderId(Integer orderId) {
        OrderStatus orderStatus = orderStatusRepository.findByOrderId(orderId);
        return orderStatusConverter.fromOrderStatusToOrderStatusDTO(orderStatus);
    }

    @Override
    public Page<OrderStatus> findAllOrderStatus(Pageable defaultPageable) {
        return orderStatusRepository.findAll(defaultPageable);
    }
}
