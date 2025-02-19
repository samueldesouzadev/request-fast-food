package com.fast.food.request.domain.mapper;

import com.fast.food.request.domain.Client;
import com.fast.food.request.domain.Demand;
import com.fast.food.request.domain.Product;
import com.fast.food.request.domain.dtos.ClientDTO;
import com.fast.food.request.domain.dtos.DemandDTO;
import com.fast.food.request.domain.dtos.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DemandMapper {

    DemandMapper INSTANCE = Mappers.getMapper(DemandMapper.class);

    List<DemandDTO> mapList(List<Demand> demandList);
    DemandDTO map(Demand demand);
    Demand map(DemandDTO demandDTO);
    ClientDTO map(Client client);
    ProductDTO map(Product product);

}
