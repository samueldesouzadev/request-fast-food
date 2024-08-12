package com.fast.food.request.domain.dtos;

import com.fast.food.request.infra.adapters.constants.DemandStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private Long demandNumber;
    private DemandStatusEnum demandStatus;
    private ClientDTO clientDTO;
    private List<ProductDTO> productDTOList;
}
