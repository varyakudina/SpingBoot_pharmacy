package com.boots.converter;

import com.boots.dto.StoreDTO;
import com.boots.entity.Store;
import org.springframework.stereotype.Component;


@Component
public class StoreConverter {

    public Store fromStoreDTOToStore(StoreDTO storeDTO) {
        Store store = new Store();
        store.setStore_id(storeDTO.getStore_id());
        store.setAddress(storeDTO.getAddress());
        store.setNumber(storeDTO.getNumber());
        return store;
    }

    public StoreDTO fromStoreToStoreDTO(Store store) {
        return StoreDTO.builder()
                .store_id(store.getStore_id())
                .address(store.getAddress())
                .number(store.getNumber())
                .build();
    }
}
