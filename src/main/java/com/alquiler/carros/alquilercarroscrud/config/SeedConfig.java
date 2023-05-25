package com.alquiler.carros.alquilercarroscrud.config;

import com.alquiler.carros.alquilercarroscrud.data.CarroAlquilerRepository;
import com.alquiler.carros.alquilercarroscrud.data.CarroRepository;
import com.alquiler.carros.alquilercarroscrud.data.ClienteRepository;
import com.alquiler.carros.alquilercarroscrud.data.SolicitudAlquilerRepository;
import com.alquiler.carros.alquilercarroscrud.models.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class SeedConfig {

    private final CarroRepository carroRepository;
    private final CarroAlquilerRepository carroAlquilerRepository;
    private final ClienteRepository clienteRepository;
    private final SolicitudAlquilerRepository solicitudAlquilerRepository;

    public SeedConfig(CarroRepository carroRepository, CarroAlquilerRepository carroAlquilerRepository, ClienteRepository clienteRepository, SolicitudAlquilerRepository solicitudAlquilerRepository) {
        this.carroRepository = carroRepository;
        this.carroAlquilerRepository = carroAlquilerRepository;
        this.clienteRepository = clienteRepository;
        this.solicitudAlquilerRepository = solicitudAlquilerRepository;
    }

    @Bean
    public void seedDataBase() {
        Carro carro1 = new Carro(null, "mercedez", "AMG", "https://media.ed.edmunds-media.com/mercedes-benz/amg-gt/2019/oem/2019_mercedes-benz_amg-gt_sedan_63-s_fq_oem_1_1600.jpg", 5);
        Carro carro2 = new Carro(null, "Toyota", "TXL", "https://media.toyota-gib.com/web-imgs/models/land-cruiser-prado/kdj150-gkfey/web/kdj150-gkfey-G1.jpg", 7);
        Carro carro3 = new Carro(null, "Toyota", "4Runner", "https://mysterio.yahoo.com/mysterio/api/E072A0DA3D2CE21ECFC660DB4AB68F1A0BB668D31354FC9F9886B96D4131D24F/autoblog/resizefill_w1200_h720;quality_85;format_webp;cc_31536000;/https://o.aolcdn.com/images/dims3/GLOB/legacy_thumbnail/800x450/format/jpg/quality/85/https://s.aolcdn.com/os/ab/_cms/2021/03/30133147/2021-Toyota-4Runner-Trail-Edition-front-three-quarter-closer.jpg", 7);
        Carro carro4 = new Carro(null, "Renault", "Logan", "https://autolab.com.co/wp-content/uploads/2022/03/Renault-Logan.jpg", 5);
        Carro carro5 = new Carro(null, "Chevrolet", "Camaro", "https://hips.hearstapps.com/hmg-prod/images/2019-chevrolet-camaro-2-0t-1le-6mt-99leadgallery-1539790972.jpg?crop=0.816xw:1.00xh;0.0928xw,0&resize=640:*", 5);


        CarroAlquiler carroAlquiler1 = new CarroAlquiler(null, "ABC123", "2017", "rojo", CarroAlquilerStatus.DISPONIBLE, carro1);
        CarroAlquiler carroAlquiler2 = new CarroAlquiler(null, "ABC124", "2017", "azul", CarroAlquilerStatus.DISPONIBLE, carro1);
        CarroAlquiler carroAlquiler3 = new CarroAlquiler(null, "ABC125", "2017", "blanco", CarroAlquilerStatus.DISPONIBLE, carro1);

        CarroAlquiler carroAlquiler4 = new CarroAlquiler(null, "ABC126", "2017", "rojo", CarroAlquilerStatus.DISPONIBLE, carro2);
        CarroAlquiler carroAlquiler5 = new CarroAlquiler(null, "ABC127", "2017", "azul", CarroAlquilerStatus.DISPONIBLE, carro2);
        CarroAlquiler carroAlquiler6 = new CarroAlquiler(null, "ABC128", "2017", "blanco", CarroAlquilerStatus.DISPONIBLE, carro2);

        CarroAlquiler carroAlquiler7 = new CarroAlquiler(null, "ABC129", "2017", "rojo", CarroAlquilerStatus.DISPONIBLE, carro3);
        CarroAlquiler carroAlquiler8 = new CarroAlquiler(null, "ABC113", "2017", "azul", CarroAlquilerStatus.DISPONIBLE, carro3);
        CarroAlquiler carroAlquiler9 = new CarroAlquiler(null, "ABC143", "2017", "blanco", CarroAlquilerStatus.DISPONIBLE, carro3);

        CarroAlquiler carroAlquiler10 = new CarroAlquiler(null, "ABC643", "2017", "rojo", CarroAlquilerStatus.DISPONIBLE, carro4);
        CarroAlquiler carroAlquiler11 = new CarroAlquiler(null, "ABC743", "2017", "azul", CarroAlquilerStatus.DISPONIBLE, carro4);
        CarroAlquiler carroAlquiler12 = new CarroAlquiler(null, "ABC843", "2017", "blanco", CarroAlquilerStatus.DISPONIBLE, carro4);


        carroAlquilerRepository.saveAll(Arrays.asList(carroAlquiler1, carroAlquiler2, carroAlquiler3, carroAlquiler4, carroAlquiler5, carroAlquiler6, carroAlquiler7, carroAlquiler8, carroAlquiler9, carroAlquiler10, carroAlquiler11, carroAlquiler12));

        Cliente cliente = new Cliente(null, "diegotest", "1234", "3000000000", TipoDocumento.CC, "10201928374", "Diego", "Mesa", Genero.Masculino, "asdasda");
        clienteRepository.save(cliente);

        CarroAlquiler carroSolicitud = carroAlquilerRepository.findById(1l).orElse(null);
        Cliente clienteSolicitud = clienteRepository.findById(1l).orElse(null);

        SolicitudAlquiler solicitudAlquiler = new SolicitudAlquiler(null,new Date(),
                new DetallePago(null,MetodoPago.TARJETA,
                        new DatosBancarios(
                                null,"MasterCard",
                                "34034034034003",
                                "09/26",
                                "514",
                                "Diego Mesa Ospina",
                                "123213123",
                                "3000000000","Bello","051010"))
        ,carroSolicitud,clienteSolicitud,EstadoSolicitud.APROBADA,new Date(),new Date(),"El poblado");
        solicitudAlquilerRepository.save(solicitudAlquiler);

    }

}
