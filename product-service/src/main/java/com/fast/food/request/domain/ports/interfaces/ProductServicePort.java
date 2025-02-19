package com.fast.food.request.domain.ports.interfaces;


import com.fast.food.request.domain.dtos.ProductDTO;

import java.util.List;

public interface ProductServicePort {
    void save(ProductDTO productDTO);
    List<ProductDTO> findByCategory(String category);
    ProductDTO findByName(String productName);
    void edit(ProductDTO productDTO);
    void delete(String nameProduct);
}
