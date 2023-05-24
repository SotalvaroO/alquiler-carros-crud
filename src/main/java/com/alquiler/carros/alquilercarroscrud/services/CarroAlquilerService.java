package com.alquiler.carros.alquilercarroscrud.services;

import com.alquiler.carros.alquilercarroscrud.data.CarroAlquilerRepository;
import com.alquiler.carros.alquilercarroscrud.data.CarroRepository;
import com.alquiler.carros.alquilercarroscrud.models.Carro;
import com.alquiler.carros.alquilercarroscrud.models.CarroAlquiler;
import com.alquiler.carros.alquilercarroscrud.models.CarroAlquilerStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroAlquilerService {

    private final CarroAlquilerRepository carroAlquilerRepository;
    private final CarroRepository carroRepository;

    public CarroAlquilerService(CarroAlquilerRepository carroAlquilerRepository, CarroRepository carroRepository) {
        this.carroAlquilerRepository = carroAlquilerRepository;
        this.carroRepository = carroRepository;
    }

    public CarroAlquiler crearCarroAlquilerWithCarro(CarroAlquiler carroAlquiler) {
        if (carroAlquiler.getCarro().getId() != null) {
            Carro carro = carroRepository.findById(carroAlquiler.getCarro().getId()).orElse(null);
            long s = carro.getId();
            carroAlquiler.setCarro(carro);
        }
        carroAlquiler.setStatus(CarroAlquilerStatus.DISPONIBLE);
        return carroAlquilerRepository.save(carroAlquiler);
    }

    public CarroAlquiler establecerCarroAlquierAlquilado(Long carroAlquilerId) {
        CarroAlquiler carroAlquiler = carroAlquilerRepository.findById(carroAlquilerId).orElse(null);
        if (carroAlquiler != null) {
            carroAlquiler.setStatus(CarroAlquilerStatus.ALQUILADO);
            return carroAlquilerRepository.save(carroAlquiler);
        }
        return null;
    }

    public List<CarroAlquiler> obtenerCarrosAlquiler(Integer pageNro, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNro, pageSize, Sort.by(sortBy));
        Page<CarroAlquiler> pagedResult = carroAlquilerRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        }
        return new ArrayList<>();
    }

    public CarroAlquiler obtenerCarroAlquilerPorId(Long id) {
        CarroAlquiler carroAlquiler = carroAlquilerRepository.findById(id).orElse(null);
        if (carroAlquiler == null) {
            return null;
        }
        return carroAlquiler;
    }
}
