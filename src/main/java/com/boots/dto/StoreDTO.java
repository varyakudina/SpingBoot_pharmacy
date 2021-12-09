package com.boots.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreDTO {

    private Integer store_id;
    private String address;
    private Integer number;
}
