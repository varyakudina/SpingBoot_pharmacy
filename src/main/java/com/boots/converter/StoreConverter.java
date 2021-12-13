package com.boots.converter;

import com.boots.dto.StoreDTO;
import com.boots.entity.Store;
import org.springframework.stereotype.Component;


@Component
public class StoreConverter {

    public Store fromStoreDTOToStore(StoreDTO storeDTO) {
        Store store = new Store();
        store.setId(storeDTO.getId());
        store.setAddress(storeDTO.getAddress());
        store.setNumber(storeDTO.getNumber());
        return store;
    }

    public StoreDTO fromStoreToStoreDTO(Store store) {
        return StoreDTO.builder()
                .Id(store.getId())
                .address(store.getAddress())
                .number(store.getNumber())
                .build();
    }
}
