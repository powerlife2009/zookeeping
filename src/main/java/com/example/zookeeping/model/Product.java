package com.example.zookeeping.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int amount;

    @Enumerated(EnumType.STRING)
    private ProductUnit productUnit;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

}