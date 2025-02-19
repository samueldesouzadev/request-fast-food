package com.fast.food.request.infra.adapters.repositories.jpa;

import com.fast.food.request.infra.adapters.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductJPARepository extends JpaRepository<ProductEntity, UUID> {

    @Query(value = "SELECT * FROM PRODUCT AS P WHERE P.CATEGORY = ?1", nativeQuery = true)
    List<ProductEntity> findByCategory(String category);

    @Query(value = "SELECT * FROM PRODUCT AS P WHERE P.NAME_PRODUCT = ?1", nativeQuery = true)
    Optional<ProductEntity> findByNameProduct(String nameProduct);
}
