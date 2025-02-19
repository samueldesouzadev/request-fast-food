package com.fast.food.request.domain.mapper;

import com.fast.food.request.domain.Client;
import com.fast.food.request.domain.dtos.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    List<ClientDTO> mapList(List<Client> clientList);
    ClientDTO map(Client client);
    Client map(ClientDTO clientDTO);
}
