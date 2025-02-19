package com.fast.food.request.application.adapters.controller;

import com.fast.food.request.domain.dtos.ProductDTO;
import com.fast.food.request.domain.ports.interfaces.ProductServicePort;
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
@RequestMapping("/product")
@Tag(name = "Product")
public class ProductController {

    private final ProductServicePort productServicePort;

    public ProductController(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @Operation(summary = "Salva um novo produto na base de dados", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto Salvo com sucesso"),
            @ApiResponse(responseCode = "422", description = "Requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar dados"),
    })
    @PostMapping("/save")
    public ResponseEntity<String> saveClient(@RequestBody ProductDTO productDTO){
        productServicePort.save(productDTO);
        return ResponseEntity.ok("Produto salvo com sucesso");
    }


    @Operation(summary = "Busca produto na base de dados por categoria", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/find/by/{category}")
    public ResponseEntity<List<ProductDTO>> findByCpf(@PathVariable String category){
        return ResponseEntity.ok(productServicePort.findByCategory(category));
    }


    @Operation(summary = "Edita produto na base de dados", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados editados com sucesso"),
            @ApiResponse(responseCode = "422", description = "Requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao editar dados"),
    })
    @PutMapping("/edit")
    public ResponseEntity<String> findByCpf(@RequestBody ProductDTO productDTO){
        productServicePort.edit(productDTO);
        return ResponseEntity.ok("Produto editado com sucesso");
    }

    @Operation(summary = "Deleta um produto na base de dados", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar dados"),
    })
    @DeleteMapping("/delete/{nameProduct}")
    public ResponseEntity<String> deleteClient(@PathVariable String nameProduct){
        productServicePort.delete(nameProduct);
        return ResponseEntity.ok("Produto deletado com sucesso");
    }
}
