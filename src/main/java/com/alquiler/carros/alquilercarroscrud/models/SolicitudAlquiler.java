package com.alquiler.carros.alquilercarroscrud.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "solicitudes_alquiler")
public class SolicitudAlquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "detalle_pago_id")
    private DetallePago detallePago;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "carro_alquiler_id")
    private CarroAlquiler carroAlquiler;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Enumerated(EnumType.STRING)
    private EstadoSolicitud estadoSolicitud;
    @Column(name = "fecha_recogida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecogida;
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;
    private String direccion;
}
