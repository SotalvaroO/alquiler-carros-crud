package com.alquiler.carros.alquilercarroscrud.data;

import com.alquiler.carros.alquilercarroscrud.models.DatosBancarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatosBancariosRepository extends JpaRepository<DatosBancarios, Long> {
}
