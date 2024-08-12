package com.fast.food.request.infra.adapters.repositories;

import com.fast.food.request.domain.Client;
import com.fast.food.request.domain.ports.repositories.ClientRepositoryPort;
import com.fast.food.request.infra.adapters.mapper.ClientMapper;
import com.fast.food.request.infra.adapters.repositories.jpa.ClientJPARepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientRepository implements ClientRepositoryPort {

    private final ClientJPARepository clientJPARepository;

    public ClientRepository(ClientJPARepository clientJPARepository) {
        this.clientJPARepository = clientJPARepository;
    }

    @Override
    public List<Client> findAll() {
        return ClientMapper.INSTANCE.mapList(clientJPARepository.findAll());
    }

    @Override
    public void save(Client client) {
        clientJPARepository.save(ClientMapper.INSTANCE.map(client));
    }

    @Override
    public Client findByCpf(String cpfClient) {
        return ClientMapper.INSTANCE.mapOption(clientJPARepository.findByCpf(cpfClient));
    }

}
