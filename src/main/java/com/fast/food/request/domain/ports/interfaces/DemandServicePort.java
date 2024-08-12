package com.fast.food.request.domain.ports.interfaces;


import com.fast.food.request.domain.dtos.DemandDTO;
import com.fast.food.request.domain.dtos.OrderDTO;

import java.util.List;

public interface DemandServicePort {
    void save(DemandDTO demandDTO);
    List<OrderDTO> findAll();
}
