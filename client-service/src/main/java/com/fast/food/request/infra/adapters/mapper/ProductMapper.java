package com.fast.food.request.infra.adapters.mapper;

import com.fast.food.request.domain.Product;
import com.fast.food.request.infra.adapters.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    List<Product> mapProductEntityList(List<ProductEntity> productEntities);
    List<ProductEntity> mapProductList(List<Product> productList);
    Product map(ProductEntity productEntity);
    ProductEntity map(Product product);

    default Product mapOption(Optional<ProductEntity> productEntity){
        return productEntity.map(INSTANCE::map).orElse(null);
    }
}
