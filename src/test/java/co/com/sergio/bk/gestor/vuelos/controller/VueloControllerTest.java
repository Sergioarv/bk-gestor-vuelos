package co.com.sergio.bk.gestor.vuelos.controller;

import co.com.sergio.bk.gestor.vuelos.entity.Aerolinea;
import co.com.sergio.bk.gestor.vuelos.entity.Ciudad;
import co.com.sergio.bk.gestor.vuelos.entity.Ruta;
import co.com.sergio.bk.gestor.vuelos.entity.Vuelo;
import co.com.sergio.bk.gestor.vuelos.service.VueloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 7/11/2021 9:26
 **/
@SpringBootTest
@Transactional
class VueloControllerTest {

    @Autowired
    private VueloService vueloService;
    @Autowired
    private VueloController vueloController = new VueloController();

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fecha;
    @DateTimeFormat(pattern = "%Y-%m-%d")
    private Date newFecha;
    private ResponseEntity<Vuelo> result;
    private ResponseEntity<List<Vuelo>> resultList;
    private Vuelo vuelo;

    @BeforeEach
    void setUp() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        fecha = formato.parse("2021-11-04");
        newFecha = formato.parse("2021-08-12");

        Ciudad origen = new Ciudad();
        origen.setIdCiudades(1);
        origen.setNombreCiudad("MEDELLIN");

        Ciudad destino = new Ciudad();
        origen.setIdCiudades(6);
        origen.setNombreCiudad("PEREIRA");

        Ruta ruta = new Ruta();
        ruta.setIdRuta(1);
        ruta.setOrigen(origen);
        ruta.setDestino(destino);

        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setId_aerolinea(2);
        aerolinea.setNombreAerolinea("Quindio Air");

        vuelo = new Vuelo();
        vuelo.setFecha_vuelo(newFecha);
        vuelo.setRuta_idRuta(ruta);
        vuelo.setAerolinea_idAerolinea(aerolinea);
    }

    @Test
    @DisplayName("Obtener lista de Vuelos")
    void getVuelos() {

        resultList = (ResponseEntity<List<Vuelo>>) vueloController.getVuelos();

        Assertions.assertEquals(5, resultList.getBody().size());
        Assertions.assertNotNull(resultList);
    }

    @Test
    @DisplayName("Buscar Vuelo por Id")
    void getVueloById() {

        result = (ResponseEntity<Vuelo>) vueloController.getVueloById(1);

        Assertions.assertNotNull(result);
    }

    @Test
    @DisplayName("Buscar Vuelo por Fecha")
    void getVueloByDate() {

        resultList = (ResponseEntity<List<Vuelo>>) vueloController.getVueloByDate(fecha);

        Assertions.assertEquals(2, resultList.getBody().size());
        Assertions.assertEquals(3, resultList.getBody().get(1).getIdVuelo());

    }

    @Test
    @DisplayName("Buscar Vuelo por Ruta")
    void getVueloByRuta() {

        resultList = (ResponseEntity<List<Vuelo>>) vueloController.getVueloByRuta("2");

        Assertions.assertEquals(HttpStatus.OK,resultList.getStatusCode());
    }

    @Test
    @Transactional
    @DisplayName("Guardar vuelo")
    void saveVuelo() {

        result = (ResponseEntity<Vuelo>) vueloController.saveVuelo(vuelo);

        Assertions.assertNotNull(result);
    }

    @Test
    @Transactional
    @DisplayName("Actualizar vuelo")
    void updateVuelo() {

        vuelo.setFecha_vuelo(fecha);

        result = (ResponseEntity<Vuelo>) vueloController.updateVuelo(vuelo);

        Assertions.assertNotNull(result);
    }
}