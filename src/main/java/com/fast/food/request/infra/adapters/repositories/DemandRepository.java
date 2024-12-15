package com.fast.food.request.infra.adapters.repositories;

import com.fast.food.request.domain.Demand;
import com.fast.food.request.domain.ports.repositories.DemandRepositoryPort;
import com.fast.food.request.infra.adapters.constants.DemandStatusEnum;
import com.fast.food.request.infra.adapters.entities.DemandEntity;
import com.fast.food.request.infra.adapters.mapper.DemandMapper;
import com.fast.food.request.infra.adapters.repositories.jpa.DemandJPARepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class DemandRepository implements DemandRepositoryPort {

    private final DemandJPARepository demandJPARepository;

    public DemandRepository(DemandJPARepository demandJPARepository) {
        this.demandJPARepository = demandJPARepository;
    }

    @Override
    public Long save(Demand demand) {
        return demandJPARepository.save(DemandMapper.INSTANCE.map(demand)).getDemandNumber();
    }

    @Override
    public List<Demand> findAll() {
        List<DemandEntity> listDemand = demandJPARepository.findDemandEntitiesByNotComplete();
        listDemand.sort(Comparator.comparingInt(demand -> DemandStatusEnum.orderMap.get(demand.getDemandStatus())));
        return DemandMapper.INSTANCE.mapList(listDemand);
    }

    @Override
    public Demand findDemandStatus(Long number) {
        Optional<DemandEntity> demand = demandJPARepository.findByDemandNumber(number);
        return DemandMapper.INSTANCE.mapOption(demand);
    }

}
