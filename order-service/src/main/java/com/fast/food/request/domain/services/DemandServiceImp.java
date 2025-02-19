package com.fast.food.request.domain.services;

import com.fast.food.request.domain.Client;
import com.fast.food.request.domain.Demand;
import com.fast.food.request.domain.Product;
import com.fast.food.request.domain.dtos.DemandDTO;
import com.fast.food.request.domain.dtos.DemandStatusDTO;
import com.fast.food.request.domain.dtos.OrderDTO;
import com.fast.food.request.domain.mapper.OrderMapper;
import com.fast.food.request.domain.ports.interfaces.DemandServicePort;
import com.fast.food.request.domain.ports.repositories.ClientRepositoryPort;
import com.fast.food.request.domain.ports.repositories.DemandRepositoryPort;
import com.fast.food.request.domain.ports.repositories.ProductRepositoryPort;
import com.fast.food.request.infra.adapters.constants.DemandStatusEnum;
import com.fast.food.request.infra.adapters.constants.PaymentStatusEnum;
import jakarta.persistence.EntityNotFoundException;
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
    public Long save(DemandDTO demandDTO) {

        Client client = clientRepositoryPort.findByCpf(demandDTO.getCpfClient());
        if (client == null) {
            throw new EntityNotFoundException("Client not found for CPF: " + demandDTO.getCpfClient());
        }

        List<Product> productList = new ArrayList<>();
        for (String productDTO : demandDTO.getNameProductList()) {
            Product product = productRepositoryPort.findByName(productDTO);
            if (product != null) {
                productList.add(product);
            } else {
                throw new EntityNotFoundException("Product not found: " + productDTO);
            }
        }

        Demand demand = new Demand();
        demand.setDemandStatus(DemandStatusEnum.RECEIVED);
        demand.setClient(client);
        demand.setProducts(productList);
        demand.setPaymentStatus(PaymentStatusEnum.NOT_PAY);
        return demandRepositoryPort.save(demand);
    }

    @Override
    public List<OrderDTO> findAll() {
        return OrderMapper.INSTANCE.mapList(demandRepositoryPort.findAll());
    }

    @Override
    public DemandStatusDTO findDemandByNumberDemand(Long numberDemand) {
        return OrderMapper.INSTANCE.mapStatus(demandRepositoryPort.findDemandStatus(numberDemand));
    }

    @Override
    public void updateStatus(DemandStatusEnum statusOrder, Long idOrder){
        Demand demand = demandRepositoryPort.findDemandStatus(idOrder);
        demand.setDemandStatus(statusOrder);
        demandRepositoryPort.save(demand);
    }
}
