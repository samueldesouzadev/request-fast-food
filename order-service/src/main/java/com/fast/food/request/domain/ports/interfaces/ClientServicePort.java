package com.fast.food.request.domain.ports.interfaces;


import com.fast.food.request.domain.dtos.ClientDTO;


public interface ClientServicePort {
    void save(ClientDTO clientDTO) throws Exception;
}
