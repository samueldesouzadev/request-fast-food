package com.fast.food.request.infra.adapters.entities;

import com.fast.food.request.infra.adapters.constants.DemandStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "DEMAND")
public class DemandEntity {

    @Id
    @NotNull
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long demandNumber;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_CLIENT", nullable = false)
    private ClientEntity client;

    @NotNull
    @OneToMany
    @JoinTable(
            name="TB_DEMAND_PRODUCTS",
            joinColumns = @JoinColumn( name="demandNumber"),
            inverseJoinColumns = @JoinColumn( name="idProduct")
    )
    private List<ProductEntity> products;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    private DemandStatusEnum demandStatus;
}
