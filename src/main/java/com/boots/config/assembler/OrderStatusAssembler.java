package com.boots.config.assembler;

import com.boots.controller.OrderStatusController;
import com.boots.dto.OrderStatusDTO;
import com.boots.entity.OrderStatus;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class OrderStatusAssembler extends RepresentationModelAssemblerSupport<OrderStatus, OrderStatusDTO> {


    public OrderStatusAssembler() {
        super(OrderStatusController.class, OrderStatusDTO.class);
    }

    @Override
    public CollectionModel<OrderStatusDTO> toCollectionModel(Iterable<? extends OrderStatus> entity)
    {
        CollectionModel<OrderStatusDTO> orderStatusDTOS = super.toCollectionModel(entity);

        orderStatusDTOS.add(linkTo(methodOn(OrderStatusController.class).findAllOrderStatus(Pageable.unpaged())).withSelfRel());

        return orderStatusDTOS;
    }

    @Override
    public OrderStatusDTO toModel(OrderStatus orderStatus) {
        OrderStatusDTO orderStatusDTO = instantiateModel(orderStatus);

        orderStatusDTO.add(linkTo(
                methodOn(OrderStatusController.class)
                        .findByOrderId(orderStatus.getOrderId()))
                .withSelfRel());
        orderStatusDTO.setOrderId(orderStatus.getOrderId());
        orderStatusDTO.setCheckoutData(orderStatus.getCheckoutData());
        orderStatusDTO.setDeliveryData(orderStatus.getDeliveryData());
        return orderStatusDTO;
    }
}