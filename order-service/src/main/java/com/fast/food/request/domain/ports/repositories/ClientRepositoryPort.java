package com.fast.food.request.domain.ports.repositories;


import com.fast.food.request.domain.Client;

import java.util.List;

public interface ClientRepositoryPort {
    Client findByCpf(String cpfClient);
}
