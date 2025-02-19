package com.fast.food.request.infra.adapters.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CLIENT")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idClient;

    @NotNull
    @Column
    private String nameClient;

    @NotNull
    @Column(unique = true)
    private String cpfClient;

    @NotNull
    @Column
    private String emailClient;
}
