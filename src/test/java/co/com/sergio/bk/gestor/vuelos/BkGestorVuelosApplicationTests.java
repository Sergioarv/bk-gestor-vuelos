package co.com.sergio.bk.gestor.vuelos;

import co.com.sergio.bk.gestor.vuelos.controller.AerolineaController;
import co.com.sergio.bk.gestor.vuelos.controller.RutaController;
import co.com.sergio.bk.gestor.vuelos.controller.VueloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BkGestorVuelosApplicationTests {

	@Autowired
	private AerolineaController aerolineaController;

	@Autowired
	private VueloController vueloController;

	@Autowired
	private RutaController rutaController;

	@Test
	void contextLoads() {
		assertThat(aerolineaController).isNotNull();
	}

	@Test
	void vueloController(){
		assertThat(vueloController).isNotNull();
	}

	@Test
	void aerolineaController(){
		assertThat(aerolineaController).isNotNull();
	}

	@Test
	void rutaController(){
		assertThat(rutaController).isNotNull();
	}

}
