package com.fast.food.request.domain.dtos;

import com.fast.food.request.infra.adapters.constants.CategoryEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {
    private String nameProduct;
    private String description;
    private BigDecimal price;
    private CategoryEnum category;
}
