package com.alquiler.carros.alquilercarroscrud.controllers;

import com.alquiler.carros.alquilercarroscrud.models.SolicitudAlquiler;
import com.alquiler.carros.alquilercarroscrud.services.SolicitudAlquilerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "solicitud-alquiler")
public class SolicitudAlquilerController {
    private final SolicitudAlquilerService solicitudAlquilerService;

    public SolicitudAlquilerController(SolicitudAlquilerService solicitudAlquilerService) {
        this.solicitudAlquilerService = solicitudAlquilerService;
    }

    @PostMapping
    public ResponseEntity crearSolicitudAlquiler(@RequestBody SolicitudAlquiler solicitudAlquiler){
        return ResponseEntity.ok(solicitudAlquilerService.crearSolicitudAlquiler(solicitudAlquiler));
    }
}
