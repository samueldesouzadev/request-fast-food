package com.fast.food.request.domain.mapper;

import com.fast.food.request.domain.Product;
import com.fast.food.request.domain.dtos.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    List<ProductDTO> mapList(List<Product> productList);
    List<Product> mapDTOList(List<ProductDTO> productList);
    ProductDTO map(Product product);
    Product map(ProductDTO productDTO);
}
