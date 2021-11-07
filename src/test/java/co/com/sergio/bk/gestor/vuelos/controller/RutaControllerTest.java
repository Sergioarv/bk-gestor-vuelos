package co.com.sergio.bk.gestor.vuelos.controller;

import co.com.sergio.bk.gestor.vuelos.entity.Ruta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 7/11/2021 11:15
 **/
@SpringBootTest
@Transactional
class RutaControllerTest {

    @Autowired
    private RutaController rutaController;

    private ResponseEntity<Ruta> result;
    private ResponseEntity<List<Ruta>> resultList;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Obtener lista de Rutas")
    void getRutas() {

        resultList = (ResponseEntity<List<Ruta>>) rutaController.getRutas();

        Assertions.assertEquals(5, resultList.getBody().size());
    }
}