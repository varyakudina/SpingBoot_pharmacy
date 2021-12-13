package com.boots.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {

    private Integer Id;
    private String deliveryAddress;
    private Integer userId;
    private Enum paymentType;
}
