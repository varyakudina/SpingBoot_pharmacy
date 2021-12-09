package com.boots.controller;

import com.boots.config.assembler.OrderStatusAssembler;
import com.boots.dto.OrderStatusDTO;
import com.boots.entity.OrderStatus;
import com.boots.exception.ValidationException;
import com.boots.service.orderStatus.OrderStatusService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
@RequestMapping("/orderStatus")
@Log
public class OrderStatusController {

    private PagedResourcesAssembler<OrderStatus> pagedResourcesAssembler;
    private OrderStatusAssembler orderStatusesAssembler;

    @Autowired
    OrderStatusService orderStatusService;

    public OrderStatusController() {
        this.pagedResourcesAssembler = pagedResourcesAssembler;
        this.orderStatusesAssembler = orderStatusesAssembler;
    }

    @PostMapping("/saveOrderStatus")
    public OrderStatusDTO saveOrderStatus(@RequestBody OrderStatusDTO orderStatusDTO) throws ValidationException {
        log.info("Handling save order status: " + orderStatusDTO);
        return orderStatusService.saveOrderStatus(orderStatusDTO);
    }

    @GetMapping(value = "/filter")
    public ResponseEntity<PagedModel<OrderStatusDTO>> filterAll(@RequestParam(required = false)
                                                                            Integer minCheckData, Integer maxCheckData, Integer minDelivData, Integer maxDelivData,
                                                                String search,
                                                                Integer page, Integer size, String sort,
                                                            @PageableDefault(sort = {"delivData"}, direction = Sort.Direction.ASC) Pageable defaultPageable) throws ValidationException{

        final Page<OrderStatus> orderStatuses = orderStatusService.filterAll(minCheckData, maxCheckData, minDelivData, maxDelivData, search, page, size, sort, defaultPageable);
        PagedModel<OrderStatusDTO> dto = pagedResourcesAssembler.toModel(orderStatuses, orderStatusesAssembler);
        return !orderStatuses.isEmpty()
                ? ResponseEntity.ok(dto)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<PagedModel<OrderStatusDTO>> findAllOrderStatus(@PageableDefault(sort = {"delivData"}, direction = Sort.Direction.ASC) Pageable defaultPageable) {
        final Page<OrderStatus> orderStatuses = orderStatusService.findAllOrderStatus(defaultPageable);

        PagedModel<OrderStatusDTO> productDTOS = pagedResourcesAssembler.toModel(orderStatuses, orderStatusesAssembler);
        return !orderStatuses.isEmpty()
                ? ResponseEntity.ok(productDTOS)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/findOrderStatusByOrderId")
    public OrderStatusDTO findByOrderId(@RequestParam Integer orderId) {
        log.info("Handling find by orderId request: " + orderId);
        return orderStatusService.findByOrderId(orderId);
    }

    @DeleteMapping("/deleteOrderStatus/{orderId}")
    public ResponseEntity<Void> deleteOrderStatus(@PathVariable Integer orderId) {
        log.info("Handling delete order request: " + orderId);
        orderStatusService.deleteOrderStatus(orderId);
        return ResponseEntity.ok().build();
    }
}
