package com.boots.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {

    private Integer order_id;
    private String delivery_address;
    private Integer user_id;
    private Enum payment_type;
}
