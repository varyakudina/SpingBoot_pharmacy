package com.boots.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;

    @Column
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column
    private String description;

    @Column
    private Integer dosage;

    @Column
    private Integer price;

    @Column
    private Integer quantity;

    @Column
    private Integer store_id;
}
