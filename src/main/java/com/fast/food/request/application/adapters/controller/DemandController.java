package com.fast.food.request.application.adapters.controller;

import com.fast.food.request.domain.dtos.DemandDTO;
import com.fast.food.request.domain.dtos.OrderDTO;
import com.fast.food.request.domain.ports.interfaces.DemandServicePort;
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

    @Operation(summary = "Salva nova demanda", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto Salvo com sucesso"),
            @ApiResponse(responseCode = "422", description = "Requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar dados"),
    })
    @PostMapping("/create")
    public ResponseEntity<String> saveDemand(@RequestBody DemandDTO demandDTO){
        demandServicePort.save(demandDTO);
        return ResponseEntity.ok("Demanda salva com sucesso");
    }

    @Operation(summary = "Consulta todos pedidos na base de dados", method = "POST")
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
}
