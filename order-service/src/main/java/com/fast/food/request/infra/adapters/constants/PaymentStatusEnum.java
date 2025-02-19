package com.fast.food.request.infra.adapters.constants;


public enum PaymentStatusEnum {

    PAID("Pago"),
    NOT_PAY("Não Pago");

    public final String status;

    PaymentStatusEnum(String value) {
        status = value;
    }

    public String getName(){
        return this.status;
    }

}
