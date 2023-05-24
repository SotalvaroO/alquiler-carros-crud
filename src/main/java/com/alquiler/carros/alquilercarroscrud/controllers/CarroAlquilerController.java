package com.alquiler.carros.alquilercarroscrud.controllers;

import com.alquiler.carros.alquilercarroscrud.models.Carro;
import com.alquiler.carros.alquilercarroscrud.models.CarroAlquiler;
import com.alquiler.carros.alquilercarroscrud.services.CarroAlquilerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "carro-alquiler")
public class CarroAlquilerController {

    private final CarroAlquilerService carroAlquilerService;

    public CarroAlquilerController(CarroAlquilerService carroAlquilerService) {
        this.carroAlquilerService = carroAlquilerService;
    }

    @PostMapping
    public ResponseEntity crearCarroAlquiler(@RequestBody CarroAlquiler carroAlquiler) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carroAlquilerService.crearCarroAlquilerWithCarro(carroAlquiler));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CarroAlquiler> obtenerCarroAlquilerPorId(@PathVariable("id") Long id){
        CarroAlquiler carroAlquiler = carroAlquilerService.obtenerCarroAlquilerPorId(id);
        if (carroAlquiler == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carroAlquiler);
    }

    @GetMapping
    public ResponseEntity<List<CarroAlquiler>> obtenerCarrosAlquiler(
            @RequestParam(defaultValue = "0") Integer pageNro,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return ResponseEntity.ok(carroAlquilerService.obtenerCarrosAlquiler(pageNro, pageSize, sortBy));
    }

}
