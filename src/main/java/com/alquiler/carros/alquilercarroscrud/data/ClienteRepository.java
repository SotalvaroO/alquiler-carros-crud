package com.alquiler.carros.alquilercarroscrud.data;

import com.alquiler.carros.alquilercarroscrud.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.documento = ?1")
    Cliente findClienteByDocumento(String documento);

    boolean existsByUsernameAndPassword(String username, String password);

}
