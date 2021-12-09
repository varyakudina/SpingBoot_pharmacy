package com.boots.controller;

import com.boots.dto.OrderDTO;
import com.boots.exception.ValidationException;
import com.boots.service.order.OrderService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
@RequestMapping("/order")
@Log
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public OrderDTO saveOrder(@RequestBody OrderDTO orderDTO) throws ValidationException {
        log.info("Handling save order: " + orderDTO);
        return orderService.saveOrder(orderDTO);
    }

    @GetMapping("/findAllOrder")
    public List<OrderDTO> findAllOrder() {
        log.info("Handling find all order request");
        return orderService.findAllOrder();
    }

    @GetMapping("/findOrderByUser_id")
    public OrderDTO findByUser_id(@RequestParam Integer user_id) {
        log.info("Handling find by user_id request: " + user_id);
        return orderService.findByUserId(user_id);
    }

    @DeleteMapping("/deleteOrder/{order_id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer order_id) {
        log.info("Handling delete order request: " + order_id);
        orderService.deleteOrder(order_id);
        return ResponseEntity.ok().build();
    }
}
