package com.alquiler.carros.alquilercarroscrud.data;

import com.alquiler.carros.alquilercarroscrud.models.CarroAlquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroAlquilerRepository extends JpaRepository<CarroAlquiler, Long> {
}
