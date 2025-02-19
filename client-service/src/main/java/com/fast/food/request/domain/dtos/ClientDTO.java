package com.fast.food.request.domain.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ClientDTO implements Serializable {
    private String nameClient;
    private String cpfClient;
    private String emailClient;
}
