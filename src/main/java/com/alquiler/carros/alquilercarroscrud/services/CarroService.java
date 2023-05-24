package com.alquiler.carros.alquilercarroscrud.services;

import com.alquiler.carros.alquilercarroscrud.data.CarroRepository;
import com.alquiler.carros.alquilercarroscrud.models.Carro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<Carro> getCarros(Integer pageNro, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNro, pageSize, Sort.by(sortBy));
        Page<Carro> pagedResult = carroRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        }
        return new ArrayList<>();
    }

    public Carro crearCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public Carro actualizarCarro(Long carroId, Carro carro) {
        Carro carroDb = carroRepository.findById(carroId).orElse(null);
        if (carroDb == null){
            return null;
        }
        carroDb.setId(carroId);
        carroDb.setMarca(carro.getMarca());
        carroDb.setSerie(carro.getSerie());
        carroDb.setImage(carro.getImage());
        carroDb.setCapacidad(carro.getCapacidad());

        return carroRepository.save(carroDb);
    }
}
