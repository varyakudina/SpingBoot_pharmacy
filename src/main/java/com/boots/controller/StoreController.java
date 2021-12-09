package com.boots.controller;


import com.boots.dto.StoreDTO;
import com.boots.exception.ValidationException;
import com.boots.service.store.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/store")
@Log
public class StoreController {

    @Autowired
    StoreService storeService;

    @PostMapping("/saveStore")
    public StoreDTO saveStore(@RequestBody StoreDTO storeDTO) throws ValidationException {
        log.info("Handling save store: " + storeDTO);
        return storeService.saveStore(storeDTO);
    }

    @GetMapping("/findAllStore")
    public List<StoreDTO> findAllStore() {
        log.info("Handling find all store request");
        return storeService.findAll();
    }

    @GetMapping("/findStoreByStore_id")
    public StoreDTO findByStore_id(@RequestParam Integer store_id) {
        log.info("Handling find by store_id request: " + store_id);
        return storeService.findByStore_id(store_id);
    }

    @DeleteMapping("/deleteStore/{store_id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Integer store_id) {
        log.info("Handling delete store request: " + store_id);
        storeService.deleteStore(store_id);
        return ResponseEntity.ok().build();
    }
}
