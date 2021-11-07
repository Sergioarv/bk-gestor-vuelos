package co.com.sergio.bk.gestor.vuelos.controller;

import co.com.sergio.bk.gestor.vuelos.entity.Aerolinea;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 7/11/2021 11:18
 **/
@SpringBootTest
@Transactional
class AerolineaControllerTest {

    @Autowired
    private AerolineaController aerolineaController;

    private ResponseEntity<Aerolinea> result;
    private ResponseEntity<Iterable<?>> resultList;

    @BeforeEach
    void setUp() {
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setId_aerolinea(1);
        aerolinea.setNombreAerolinea("Pruebas Air");
    }

    @Test
    @DisplayName("Obtener lista de Aerolineas")
    void getAerolinea() {

        resultList = aerolineaController.getAerolinea();

        Assertions.assertEquals(1, Lists.newArrayList(resultList).size());
    }
}