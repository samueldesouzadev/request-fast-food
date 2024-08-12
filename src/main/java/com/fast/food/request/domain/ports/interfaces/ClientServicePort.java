package com.fast.food.request.domain.ports.interfaces;


import com.fast.food.request.domain.dtos.ClientDTO;

import java.util.List;

public interface ClientServicePort {

    List<ClientDTO> findAll();
    void save(ClientDTO clientDTO);
    ClientDTO findByCpf(String cpfClient);
}
