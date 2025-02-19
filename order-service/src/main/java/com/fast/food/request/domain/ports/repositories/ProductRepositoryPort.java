package com.fast.food.request.domain.ports.repositories;


import com.fast.food.request.domain.Product;

import java.util.List;

public interface ProductRepositoryPort {
    Product findByName(String nameProduct);
}
