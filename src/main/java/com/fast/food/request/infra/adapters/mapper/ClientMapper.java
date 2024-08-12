package com.fast.food.request.infra.adapters.mapper;

import com.fast.food.request.domain.Client;
import com.fast.food.request.infra.adapters.entities.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    List<Client> mapList(List<ClientEntity> clientEntityList);
    Client map(ClientEntity clientEntity);
    ClientEntity map(Client client);

    default Client mapOption(Optional<ClientEntity> clientEntity){
        return clientEntity.map(INSTANCE::map).orElse(null);
    }

}
