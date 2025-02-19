package com.fast.food.request.domain;

import com.fast.food.request.infra.adapters.constants.CategoryEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {
    private Long idProduct;
    private String nameProduct;
    private String description;
    private BigDecimal price;
    private CategoryEnum category;
}
