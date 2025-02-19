package com.fast.food.request.domain.ports.repositories;


import com.fast.food.request.domain.Demand;

import java.util.List;

public interface DemandRepositoryPort {

    Long save(Demand demand);
    List<Demand> findAll();
    Demand findDemandStatus(Long number);
}
