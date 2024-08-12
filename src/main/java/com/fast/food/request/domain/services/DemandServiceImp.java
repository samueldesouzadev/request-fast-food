package com.fast.food.request.domain.services;

import com.fast.food.request.domain.Client;
import com.fast.food.request.domain.Demand;
import com.fast.food.request.domain.Product;
import com.fast.food.request.domain.dtos.DemandDTO;
import com.fast.food.request.domain.dtos.OrderDTO;
import com.fast.food.request.domain.mapper.OrderMapper;
import com.fast.food.request.domain.ports.interfaces.DemandServicePort;
import com.fast.food.request.domain.ports.repositories.ClientRepositoryPort;
import com.fast.food.request.domain.ports.repositories.DemandRepositoryPort;
import com.fast.food.request.domain.ports.repositories.ProductRepositoryPort;
import com.fast.food.request.infra.adapters.constants.DemandStatusEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemandServiceImp implements DemandServicePort {

    private final DemandRepositoryPort demandRepositoryPort;
    private final ClientRepositoryPort clientRepositoryPort;
    private final ProductRepositoryPort productRepositoryPort;

    public DemandServiceImp(DemandRepositoryPort demandRepositoryPort, ClientRepositoryPort clientRepositoryPort, ProductRepositoryPort productRepositoryPort) {
        this.demandRepositoryPort = demandRepositoryPort;
        this.clientRepositoryPort = clientRepositoryPort;
        this.productRepositoryPort = productRepositoryPort;
    }


    @Override
    public void save(DemandDTO demandDTO) {
        Client client = clientRepositoryPort.findByCpf(demandDTO.getCpfClient());
        List<Product> productDTOList = new ArrayList<>();
        for (String nameProduct: demandDTO.getNameProductList()){
            productDTOList.add(productRepositoryPort.findByName(nameProduct));
        }
        Demand demand = new Demand();
        demand.setDemandStatus(DemandStatusEnum.RECEIVED);
        demand.setClient(client);
        demand.setProducts(productDTOList);
        demandRepositoryPort.save(demand);
    }

    @Override
    public List<OrderDTO> findAll() {
        return OrderMapper.INSTANCE.mapList(demandRepositoryPort.findAll());
    }
}
