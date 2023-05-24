package com.alquiler.carros.alquilercarroscrud.data;

import com.alquiler.carros.alquilercarroscrud.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    @Query("SELECT u FROM Carro u WHERE u.marca = ?1 ")
    List<Carro> buscarCarroPorMarca(String marca);

}
