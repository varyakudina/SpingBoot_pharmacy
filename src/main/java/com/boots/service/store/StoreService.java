package com.boots.service.store;

import com.boots.dto.StoreDTO;
import com.boots.dto.UserDTO;
import com.boots.exception.ValidationException;

import java.util.List;
public interface StoreService {

    StoreDTO saveStore(StoreDTO storeDTO) throws ValidationException;

    void deleteStore(Integer store_id);

    StoreDTO findByStore_id(Integer store_id);

    List<StoreDTO> findAll();
}
