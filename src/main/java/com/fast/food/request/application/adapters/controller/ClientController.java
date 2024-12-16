package com.fast.food.request.application.adapters.controller;

import com.fast.food.request.domain.dtos.ClientDTO;
import com.fast.food.request.domain.ports.interfaces.ClientServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/client")
@Tag(name = "Client")
public class ClientController {

    private final ClientServicePort clientServicePort;

    public ClientController(ClientServicePort clientServicePort) {
        this.clientServicePort = clientServicePort;
    }

    @Operation(summary = "Busca todos cliente cadastrados na base de dados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/find/all")
    public ResponseEntity<List<ClientDTO>> listAllClient(){
            return ResponseEntity.ok(clientServicePort.findAll());

    }

    @Operation(summary = "Salva um novo cliente na base de dados", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente Salvo com sucesso!"),
            @ApiResponse(responseCode = "422", description = "Requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar dados"),
    })
    @PostMapping("/save")
    public ResponseEntity<String> saveClient(@RequestBody ClientDTO clientDTO){
        try {
            clientServicePort.save(clientDTO);
            return ResponseEntity.ok("Cliente salvo com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao salvar Cliente - ERRO: " + e.getMessage());
        }
    }


    @Operation(summary = "Busca cliente na base de dados por CPF", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/find/by/{cpf}")
    public ResponseEntity<ClientDTO> findByCpf(@PathVariable String cpf){
        return ResponseEntity.ok(clientServicePort.findByCpf(cpf));
    }

}
