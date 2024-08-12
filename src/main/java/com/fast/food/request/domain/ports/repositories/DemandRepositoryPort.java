package com.fast.food.request.domain.ports.repositories;


import com.fast.food.request.domain.Demand;

import java.util.List;

public interface DemandRepositoryPort {

    void save(Demand demand);
    List<Demand> findAll();
}
