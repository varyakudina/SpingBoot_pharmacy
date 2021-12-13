package com.boots.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer Id;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "payment_type")
    private Enum paymentType;
}
