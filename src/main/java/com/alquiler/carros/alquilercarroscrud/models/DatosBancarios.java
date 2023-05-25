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
@Table(name = "datos_bancarios", uniqueConstraints = {@UniqueConstraint(columnNames = {"numeroTarjeta","fechaVencimiento","cv"})})
public class DatosBancarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entidad_financiera")
    private String entidadFinanciera;
    @Column(name = "numero_tarjeta", unique = true)
    private String numeroTarjeta;
    @Column(name = "fecha_vencimiento")
    private String fechaVencimiento;
    private String cv;
    @Column(name = "nombre_propietario")
    private String nombrePropietario;
    @Column(name = "documento_propietario")
    private String documentoPropietario;
    @Column(name = "tel_propietario")
    private String telPropietario;
    private String direccion;
    private String zip;

}
