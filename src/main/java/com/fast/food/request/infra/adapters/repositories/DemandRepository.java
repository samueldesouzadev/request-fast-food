package com.fast.food.request.infra.adapters.repositories;

import com.fast.food.request.domain.Demand;
import com.fast.food.request.domain.ports.repositories.DemandRepositoryPort;
import com.fast.food.request.infra.adapters.mapper.DemandMapper;
import com.fast.food.request.infra.adapters.repositories.jpa.DemandJPARepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemandRepository implements DemandRepositoryPort {

    private final DemandJPARepository demandJPARepository;

    public DemandRepository(DemandJPARepository demandJPARepository) {
        this.demandJPARepository = demandJPARepository;
    }

    @Override
    public void save(Demand demand) {
        demandJPARepository.save(DemandMapper.INSTANCE.map(demand));
    }

    @Override
    public List<Demand> findAll() {
        return DemandMapper.INSTANCE.mapList(demandJPARepository.findAll());
    }

}
