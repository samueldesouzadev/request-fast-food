package com.fast.food.request.domain.services;

import com.fast.food.request.domain.Client;
import com.fast.food.request.domain.dtos.ClientDTO;
import com.fast.food.request.domain.mapper.ClientMapper;
import com.fast.food.request.domain.ports.interfaces.ClientServicePort;
import com.fast.food.request.domain.ports.repositories.ClientRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements ClientServicePort {

    private final ClientRepositoryPort clientRepositoryPort;

    public ClientServiceImp(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public List<ClientDTO> findAll() {
        List<Client> clientList = this.clientRepositoryPort.findAll();
        return ClientMapper.INSTANCE.mapList(clientList);
    }

    @Override
    public void save(ClientDTO clientDTO) {
        this.clientRepositoryPort.save(ClientMapper.INSTANCE.map(clientDTO));
    }

    @Override
    public ClientDTO findByCpf(String cpf) {
        return ClientMapper.INSTANCE.map(clientRepositoryPort.findByCpf(cpf));
    }

}
