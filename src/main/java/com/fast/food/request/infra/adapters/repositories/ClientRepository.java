package com.fast.food.request.infra.adapters.repositories;

import com.fast.food.request.domain.Client;
import com.fast.food.request.domain.ports.repositories.ClientRepositoryPort;
import com.fast.food.request.infra.adapters.mapper.ClientMapper;
import com.fast.food.request.infra.adapters.repositories.jpa.ClientJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Slf4j
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
        if(validateCpf(client.getCpfClient())){
            clientJPARepository.save(ClientMapper.INSTANCE.map(client));
        }else {
            log.error("CPF DO CLIENTE INVALIDO");
            throw new IllegalArgumentException("CPF INVALIDO");
        }
    }

    @Override
    public Client findByCpf(String cpfClient) {
        return ClientMapper.INSTANCE.mapOption(clientJPARepository.findByCpf(cpfClient));
    }

    private boolean validateCpf(String cpf) {
        String url = "https://zrx1wo4nma.execute-api.us-east-2.amazonaws.com/prod/autenticacaoCPF";

        try {
            String requestBody = String.format("{\"queryStringParameters\": {\"cpf\": \"%s\"}}", cpf);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body().contains("CPF válido");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
