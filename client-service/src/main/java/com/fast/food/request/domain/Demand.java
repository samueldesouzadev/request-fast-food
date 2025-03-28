package com.fast.food.request.domain;

import com.fast.food.request.infra.adapters.constants.DemandStatusEnum;
import com.fast.food.request.infra.adapters.constants.PaymentStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Demand {
    private Client client;
    private List<Product> products;
    private DemandStatusEnum demandStatus;
    private PaymentStatusEnum paymentStatus;
    private Long demandNumber;
}
