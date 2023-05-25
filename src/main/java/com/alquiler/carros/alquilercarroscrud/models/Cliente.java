package com.alquiler.carros.alquilercarroscrud.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String telefono;
    @Column(name = "tipo_documento")
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;
    @Column(unique = true)
    private String documento;
    private String nombre;
    private String apellido;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @Column(name = "licencia_url")
    private String licenciaUrl;
}
