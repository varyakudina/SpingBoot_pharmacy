package com.boots.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreDTO {

    private Integer Id;
    private String address;
    private Integer number;
}
