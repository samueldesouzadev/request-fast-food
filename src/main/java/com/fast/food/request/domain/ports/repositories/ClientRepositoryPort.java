package com.fast.food.request.domain.ports.repositories;


import com.fast.food.request.domain.Client;

import java.util.List;

public interface ClientRepositoryPort {
    List<Client> findAll();
    void save(Client client) throws Exception;
    Client findByCpf(String cpfClient);
}
