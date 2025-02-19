package com.fast.food.request.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Client {
    private Long idClient;
    private String nameClient;
    private String cpfClient;
    private String emailClient;
    private List<Demand> demandList;
}
