package br.com.ibm.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibm.api.dto.ClienteDTO;
import br.com.ibm.api.dto.ExtratoDTO;
import br.com.ibm.api.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
@Validated
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/{id}")
	@Operation(summary = "Obter dados do cliente pelo ID.", tags = "Cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida"),
            @ApiResponse(responseCode = "404", description = "Quando não for encontrado"),
            @ApiResponse(responseCode = "400", description = "Ocorreu um erro ao processar"),
            @ApiResponse(responseCode = "500", description = "Quando ocorrer erro do servidor") 
    })
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
    	ClienteDTO obj = this.service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/clientes")
    @Operation(summary = "Obter todos clientes cadastrado na base de dados.", tags = "Cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida"),
            @ApiResponse(responseCode = "404", description = "Quando não for encontrado"),
            @ApiResponse(responseCode = "400", description = "Ocorreu um erro ao processar"),
            @ApiResponse(responseCode = "500", description = "Quando ocorrer erro do servidor") 
    })
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<ClienteDTO> objs = this.service.all();
        return ResponseEntity.ok().body(objs);
    }

    @PostMapping("/")
    @Validated
    @Operation(summary = "Criar um novo cliente na base de dados.", tags = "Cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida"),
            @ApiResponse(responseCode = "404", description = "Quando não for encontrado"),
            @ApiResponse(responseCode = "400", description = "Ocorreu um erro ao processar"),
            @ApiResponse(responseCode = "500", description = "Quando ocorrer erro do servidor") 
    })
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO obj) {
    	  var response = this.service.criar(obj);
          return ResponseEntity.ok().body(response);
    }
    
    @PutMapping("/{id}")
    @Validated
    @Operation(summary = "Realiza operação de creditar e debitar do saldo do cliente", tags = "Cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida"),
            @ApiResponse(responseCode = "404", description = "Quando não for encontrado"),
            @ApiResponse(responseCode = "400", description = "Ocorreu um erro ao processar"),
            @ApiResponse(responseCode = "500", description = "Quando ocorrer erro do servidor") 
    })
    public ResponseEntity<ClienteDTO> creditarDebitar(@Valid @RequestBody ExtratoDTO obj, @PathVariable Long id) {
        obj.setIdCliente(id);
        var response = this.service.creditarDebitar(obj);
        return ResponseEntity.ok().body(response);
    }

}
