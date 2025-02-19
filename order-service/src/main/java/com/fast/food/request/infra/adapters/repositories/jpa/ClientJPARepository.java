package com.fast.food.request.infra.adapters.repositories.jpa;

import com.fast.food.request.infra.adapters.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientJPARepository extends JpaRepository<ClientEntity, UUID> {

    @Query(value = "SELECT * FROM CLIENT", nativeQuery = true)
    List<ClientEntity> findAll();


    @Query(value = "SELECT * FROM CLIENT AS C WHERE C.CPF_CLIENT = ?1", nativeQuery = true)
    Optional<ClientEntity> findByCpf(String cpfClient);
}
