package com.fast.food.request.infra.adapters.constants;


public enum DemandStatusEnum {

    RECEIVED("Recebido"),
    IN_PREPARATION("Em preparação"),
    READY("Pronto"),
    COMPLETED("Finalizado");

    public final String status;

    DemandStatusEnum(String value) {
        status = value;
    }

    public String getName(){
        return this.status;
    }

}
