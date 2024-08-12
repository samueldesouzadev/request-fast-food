package com.fast.food.request.infra.adapters.repositories.jpa;

import com.fast.food.request.infra.adapters.entities.DemandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DemandJPARepository extends JpaRepository<DemandEntity, UUID> {

    @Query(value = "SELECT * FROM DEMAND", nativeQuery = true)
    List<DemandEntity> findByAll();

    @Query(value = "SELECT * FROM DEMAND AS D WHERE D.DEMAND_NUMBER = ?1", nativeQuery = true)
    Optional<DemandEntity> findByDemandNumber(Long demandNumber);

    @Query(value = "SELECT * FROM DEMAND AS D WHERE D.DEMAND_STATUS IN ('RECEIVED', 'IN_PREPARATION', 'READY')", nativeQuery = true)
    List<DemandEntity> findDemandEntitiesByNotDemandStatus();
}
