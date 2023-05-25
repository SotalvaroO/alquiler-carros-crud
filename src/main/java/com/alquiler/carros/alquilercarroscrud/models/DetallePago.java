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
@Table(name = "detalle_pagos")
public class DetallePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago")
    private MetodoPago metodoPago;
    @ManyToOne(optional = true)
    @JoinColumn(name = "datos_bancarios_id")
    private DatosBancarios datosBancarios;
}
