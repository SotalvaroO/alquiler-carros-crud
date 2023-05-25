package com.alquiler.carros.alquilercarroscrud.data;

import com.alquiler.carros.alquilercarroscrud.models.SolicitudAlquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudAlquilerRepository extends JpaRepository<SolicitudAlquiler, Long> {

}
