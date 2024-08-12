package com.fast.food.request.infra.adapters.mapper;

import com.fast.food.request.domain.Client;
import com.fast.food.request.domain.Demand;
import com.fast.food.request.infra.adapters.entities.ClientEntity;
import com.fast.food.request.infra.adapters.entities.DemandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DemandMapper {

    DemandMapper INSTANCE = Mappers.getMapper(DemandMapper.class);

    List<Demand> mapList(List<DemandEntity> demandEntities);
    Demand map(DemandEntity demandEntity);
    DemandEntity map(Demand demand);
    ClientEntity map(Client client);

    default Demand mapOption(Optional<DemandEntity> demandEntity){
        return demandEntity.map(INSTANCE::map).orElse(null);
    }
}
