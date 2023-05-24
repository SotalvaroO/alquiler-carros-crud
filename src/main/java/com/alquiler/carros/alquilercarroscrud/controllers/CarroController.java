package com.alquiler.carros.alquilercarroscrud.controllers;

import com.alquiler.carros.alquilercarroscrud.models.Carro;
import com.alquiler.carros.alquilercarroscrud.services.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "carro")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public ResponseEntity<List<Carro>> obtenerCarros(
            @RequestParam(defaultValue = "0") Integer pageNro,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return ResponseEntity.ok(carroService.getCarros(pageNro, pageSize, sortBy));
    }

    @PostMapping
    public ResponseEntity<Carro> crearCarro(@RequestBody Carro carro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carroService.crearCarro(carro));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Carro> actualizarCarro(@PathVariable("id") Long id, @RequestBody Carro carro) {
        Carro carroActualizar = carroService.actualizarCarro(id, carro);
        if (carroActualizar == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carroActualizar);
    }
}
