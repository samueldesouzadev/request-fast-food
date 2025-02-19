package com.fast.food.request.domain.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DemandDTO {
    private String cpfClient;
    private List<String> nameProductList;
}
