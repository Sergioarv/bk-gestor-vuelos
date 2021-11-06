package co.com.sergio.bk.gestor.vuelos.service;

import co.com.sergio.bk.gestor.vuelos.entity.Vuelo;
import co.com.sergio.bk.gestor.vuelos.repository.VueloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 6/11/2021 15:25
 **/
class VueloServiceImplTest {

    @Mock
    private VueloRepository vueloRepository;
    @InjectMocks
    private VueloService vueloService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findAll() {
/*        Mockito.when(vueloRepository.findAll()).thenReturn(Arrays.asList());
        List<?> listResult = (List<?>) vueloService.findAll();
        assertEquals(3, listResult.size());*/
    }

    @Test
    void save() {
    }

    @Test
    void deleteVuelo() {
    }

    @Test
    void findByFecha() {
    }

    @Test
    void findByRuta() {
    }

    @Test
    void updateVuelo() {
    }
}