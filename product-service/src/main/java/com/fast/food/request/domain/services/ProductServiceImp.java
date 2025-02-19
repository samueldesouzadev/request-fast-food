package com.fast.food.request.domain.services;

import com.fast.food.request.domain.dtos.ProductDTO;
import com.fast.food.request.domain.mapper.ProductMapper;
import com.fast.food.request.domain.ports.interfaces.ProductServicePort;
import com.fast.food.request.domain.ports.repositories.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductServicePort {

    private final ProductRepositoryPort productRepository;


    public ProductServiceImp(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void save(ProductDTO productDTO) {
        productRepository.save(ProductMapper.INSTANCE.map(productDTO));
    }

    @Override
    public List<ProductDTO> findByCategory(String category) {
        return ProductMapper.INSTANCE.mapList(productRepository.findByCategory(category));
    }

    @Override
    public ProductDTO findByName(String nameProduct) {
        return ProductMapper.INSTANCE.map(productRepository.findByName(nameProduct));
    }

    @Override
    public void edit(ProductDTO productDTO) {
        productRepository.edit(ProductMapper.INSTANCE.map(productDTO));
    }

    @Override
    public void delete(String nameProduct) {
        productRepository.delete(nameProduct);
    }
}
