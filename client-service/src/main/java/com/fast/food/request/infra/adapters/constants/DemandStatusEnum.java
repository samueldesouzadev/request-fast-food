package com.fast.food.request.infra.adapters.constants;


import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum DemandStatusEnum {

    RECEIVED("Recebido",1),
    IN_PREPARATION("Em preparação", 2),
    READY("Pronto", 3),
    COMPLETED("Finalizado", 4);

    public final String status;
    @Getter
    public final int order;

    DemandStatusEnum(String value, int order) {
        status = value;
        this.order = order;
    }

    public String getName(){
        return this.status;
    }

    public static final Map<DemandStatusEnum, Integer> orderMap = new HashMap<>();

    static {
        for (DemandStatusEnum status : DemandStatusEnum.values()) {
            orderMap.put(status, status.getOrder());
        }
    }

}
