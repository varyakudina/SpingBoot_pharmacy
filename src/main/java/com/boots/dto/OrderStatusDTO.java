package com.boots.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
public class OrderStatusDTO extends RepresentationModel<OrderStatusDTO> {

    private String checkoutData;
    private Integer orderId;
    private String deliveryData;

}