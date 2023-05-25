package com.alquiler.carros.alquilercarroscrud.controllers;

import com.alquiler.carros.alquilercarroscrud.models.Cliente;
import com.alquiler.carros.alquilercarroscrud.models.Login;
import com.alquiler.carros.alquilercarroscrud.models.Token;
import com.alquiler.carros.alquilercarroscrud.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping(value = "sign-up")
    private ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente clienteACrear = clienteService.registrarCliente(cliente);
        if (clienteACrear == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return  ResponseEntity.status(HttpStatus.CREATED).body(clienteACrear);
    }
    @PostMapping(value = "login")
    private ResponseEntity login(@RequestBody Login login){
        Token token = clienteService.login(login);
        if (token == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(token);
    }
}
