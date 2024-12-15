package com.fast.food.request.application.adapters.controller;

import com.fast.food.request.domain.dtos.DemandDTO;
import com.fast.food.request.domain.dtos.DemandStatusDTO;
import com.fast.food.request.domain.dtos.OrderDTO;
import com.fast.food.request.domain.ports.interfaces.DemandServicePort;
import com.fast.food.request.infra.adapters.constants.DemandStatusEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
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
@RequestMapping("/demand")
@Tag(name = "Demand")
public class DemandController {

    private final DemandServicePort demandServicePort;

    public DemandController(DemandServicePort demandServicePort) {
        this.demandServicePort = demandServicePort;
    }

    @Operation(summary = "Cria uma nova demanda", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto Salvo com sucesso"),
            @ApiResponse(responseCode = "422", description = "Requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar dados"),
    })
    @PostMapping("/create")
    public ResponseEntity<String> saveDemand(@RequestBody DemandDTO demandDTO) throws JsonProcessingException {
        long numberDemand = demandServicePort.save(demandDTO);
        return ResponseEntity.ok("Pedido criado, NUMERO DO PEDIDO: " + numberDemand);
    }

    @Operation(summary = "Consulta todos pedidos na base de dados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta de pedido realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao consultar dados"),
    })
    @GetMapping("/order/findAll")
    public ResponseEntity<List<OrderDTO>> findAll(){
        return ResponseEntity.ok(demandServicePort.findAll());
    }

    @Operation(summary = "Consulta status do pedidos na base de dados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta status do pedido realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao consultar dados"),
    })
    @GetMapping("/order/find/demand/status/{demandNumber}")
    public ResponseEntity<DemandStatusDTO> findDemandStatus(@RequestParam("demandNumber") Long demandNumber){
        return ResponseEntity.ok(demandServicePort.findDemandByNumberDemand(demandNumber));
    }


    @Operation(summary = "Atualiza status do pedido", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Status atualizado com sucesso!"),
            @ApiResponse(responseCode = "422", description = "Requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar dados"),
    })
    @PutMapping("/order/update/{statusOrder}/{idOrder}")
    public void updateStatus(@RequestParam("statusOrder") DemandStatusEnum statusOrder, @RequestParam("idOrder") Long idOrder){
        demandServicePort.updateStatus(statusOrder, idOrder);
    }
}
