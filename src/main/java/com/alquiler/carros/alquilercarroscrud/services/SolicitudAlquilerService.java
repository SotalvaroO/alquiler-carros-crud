package com.alquiler.carros.alquilercarroscrud.services;

import com.alquiler.carros.alquilercarroscrud.data.CarroAlquilerRepository;
import com.alquiler.carros.alquilercarroscrud.data.ClienteRepository;
import com.alquiler.carros.alquilercarroscrud.data.SolicitudAlquilerRepository;
import com.alquiler.carros.alquilercarroscrud.models.*;
import org.springframework.stereotype.Service;

@Service
public class SolicitudAlquilerService {

    private final SolicitudAlquilerRepository solicitudAlquilerRepository;
    private final CarroAlquilerRepository carroAlquilerRepository;
    private final ClienteRepository clienteRepository;

    public SolicitudAlquilerService(SolicitudAlquilerRepository solicitudAlquilerRepository, CarroAlquilerRepository carroAlquilerRepository, ClienteRepository clienteRepository) {
        this.solicitudAlquilerRepository = solicitudAlquilerRepository;
        this.carroAlquilerRepository = carroAlquilerRepository;
        this.clienteRepository = clienteRepository;
    }

    public SolicitudAlquiler crearSolicitudAlquiler(SolicitudAlquiler solicitudAlquiler){
        CarroAlquiler carroAlquiler = carroAlquilerRepository.findById(solicitudAlquiler.getCarroAlquiler().getId()).orElse(null);
        Cliente cliente = clienteRepository.findById(solicitudAlquiler.getCliente().getId()).orElse(null);
        solicitudAlquiler.setCarroAlquiler(carroAlquiler);
        solicitudAlquiler.setCliente(cliente);
        solicitudAlquiler.setEstadoSolicitud(EstadoSolicitud.APROBADA);

        carroAlquiler.setStatus(CarroAlquilerStatus.ALQUILADO);

        carroAlquilerRepository.save(carroAlquiler);

        return solicitudAlquilerRepository.save(solicitudAlquiler);
    }
}
