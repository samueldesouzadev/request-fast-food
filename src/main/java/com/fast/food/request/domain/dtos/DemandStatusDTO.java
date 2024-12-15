package com.fast.food.request.domain.dtos;

import com.fast.food.request.infra.adapters.constants.PaymentStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemandStatusDTO {
    private Long demandNumber;
    private PaymentStatusEnum statusPayment;
}
