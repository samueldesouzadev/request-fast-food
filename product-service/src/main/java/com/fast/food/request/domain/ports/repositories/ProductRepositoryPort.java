package com.fast.food.request.domain.ports.repositories;


import com.fast.food.request.domain.Product;

import java.util.List;

public interface ProductRepositoryPort {

    void save(Product product);
    List<Product> findByCategory(String category);
    Product findByName(String nameProduct);
    void edit(Product product);
    void delete(String nameProduct);
}
