package com.fast.food.request.domain.ports.interfaces;


import com.fast.food.request.domain.dtos.ProductDTO;


public interface ProductServicePort {
    void save(ProductDTO productDTO);
}
