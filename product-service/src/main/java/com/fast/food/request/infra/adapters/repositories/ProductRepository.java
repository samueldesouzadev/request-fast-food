package com.fast.food.request.infra.adapters.repositories;

import com.fast.food.request.domain.Product;
import com.fast.food.request.domain.ports.repositories.ProductRepositoryPort;
import com.fast.food.request.infra.adapters.entities.ProductEntity;
import com.fast.food.request.infra.adapters.mapper.ProductMapper;
import com.fast.food.request.infra.adapters.repositories.jpa.ProductJPARepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository implements ProductRepositoryPort {

    private final ProductJPARepository productJPARepository;

    public ProductRepository(ProductJPARepository productJPARepository) {
        this.productJPARepository = productJPARepository;
    }

    @Override
    public void save(Product product) {
        productJPARepository.save(ProductMapper.INSTANCE.map(product));
    }

    @Override
    public List<Product> findByCategory(String category) {
        return ProductMapper.INSTANCE.mapProductEntityList(productJPARepository.findByCategory(category));
    }

    @Override
    public void edit(Product product) {
        ProductEntity productEntity = findByNameEntity(product.getNameProduct());
        productEntity.setCategory(product.getCategory());
        productEntity.setPrice(product.getPrice());
        productEntity.setDescription(product.getDescription());

        productJPARepository.save(productEntity);
    }

    @Override
    public void delete(String nameProduct) {
        ProductEntity productEntity = findByNameEntity(nameProduct);
        productJPARepository.delete(productEntity);
    }

    @Override
    public Product findByName(String name) {
        Optional<ProductEntity> optionalProductEntity = productJPARepository.findByNameProduct(name);
        return ProductMapper.INSTANCE.map(optionalProductEntity.orElse(null));
    }

    private ProductEntity findByNameEntity(String name) {
        Optional<ProductEntity> optionalProductEntity = productJPARepository.findByNameProduct(name);
        return optionalProductEntity.orElse(null);
    }

}
