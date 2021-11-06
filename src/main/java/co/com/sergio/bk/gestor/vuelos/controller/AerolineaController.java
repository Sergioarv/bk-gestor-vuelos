package co.com.sergio.bk.gestor.vuelos.controller;

import co.com.sergio.bk.gestor.vuelos.entity.Aerolinea;
import co.com.sergio.bk.gestor.vuelos.service.AerolineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 4/11/2021 10:40
 **/
@RestController
@RequestMapping("/aerolinea")
public class AerolineaController {

    @Autowired
    private AerolineaService aerolineaService;

    /**
     *
     * Método para obtener las aerolineas existentes
     *
     * @Author Sergio Abelardo Rodríguez Vásquez
     * @Email ingsergiorodriguezv@gmail.com
     * @Date 4/11/2021 11:48
     *
     * @Param []
     * @return Lista de Aerolineas
     *
    **/
    @GetMapping
    public ResponseEntity<Iterable<?>> getAerolinea(){
        List<Aerolinea> data = null;
        HttpStatus status = null;

        data = (List<Aerolinea>) aerolineaService.findAll();
        if(data != null){
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(data, status);
    }
}
