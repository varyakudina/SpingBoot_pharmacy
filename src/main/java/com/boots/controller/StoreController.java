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

    @GetMapping("/findStoreById")
    public StoreDTO findByStore_id(@RequestParam Integer Id) {
        log.info("Handling find by store_id request: " + Id);
        return storeService.findById(Id);
    }

    @DeleteMapping("/deleteStore/{Id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Integer Id) {
        log.info("Handling delete store request: " + Id);
        storeService.deleteStore(Id);
        return ResponseEntity.ok().build();
    }
}
