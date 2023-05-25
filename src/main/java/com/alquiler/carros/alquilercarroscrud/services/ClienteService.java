package com.alquiler.carros.alquilercarroscrud.services;

import com.alquiler.carros.alquilercarroscrud.TokenStorage;
import com.alquiler.carros.alquilercarroscrud.data.ClienteRepository;
import com.alquiler.carros.alquilercarroscrud.models.Cliente;
import com.alquiler.carros.alquilercarroscrud.models.Login;
import com.alquiler.carros.alquilercarroscrud.models.Token;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente registrarCliente(Cliente cliente){
        Cliente clienteDB = clienteRepository.findClienteByDocumento(cliente.getDocumento());
        if (clienteDB != null){
            return null;
        }
        return clienteRepository.save(cliente);
    }

    public Token login(Login login){
        if (clienteRepository.existsByUsernameAndPassword(login.getUsername(), login.getPassword())){
            TokenStorage.generateToken();
            return new Token(TokenStorage.TOKEN);
        }
        return null;
    }
}
