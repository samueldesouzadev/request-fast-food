package com.fast.food.request.domain.ports.interfaces;


import com.fast.food.request.domain.dtos.DemandDTO;
import com.fast.food.request.domain.dtos.DemandStatusDTO;
import com.fast.food.request.domain.dtos.OrderDTO;
import com.fast.food.request.infra.adapters.constants.DemandStatusEnum;
import com.fast.food.request.infra.adapters.constants.PaymentStatusEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DemandServicePort {
    Long save(DemandDTO demandDTO) throws JsonProcessingException;
    List<OrderDTO> findAll();
    DemandStatusDTO findDemandByNumberDemand(Long numberDemand);
    void updateStatus(DemandStatusEnum statusOrder, Long idOrder);
}
