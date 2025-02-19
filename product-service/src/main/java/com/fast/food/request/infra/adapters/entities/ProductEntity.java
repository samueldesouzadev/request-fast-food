package com.fast.food.request.infra.adapters.entities;

import com.fast.food.request.infra.adapters.constants.CategoryEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idProduct;

    @NotNull
    @Column(unique = true)
    private String nameProduct;

    @NotNull
    @Column
    private String description;

    @NotNull
    @Column
    private BigDecimal price;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

}
