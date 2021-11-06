package co.com.sergio.bk.gestor.vuelos.controller;

import co.com.sergio.bk.gestor.vuelos.entity.Aerolinea;
import co.com.sergio.bk.gestor.vuelos.entity.Ruta;
import co.com.sergio.bk.gestor.vuelos.service.RutaService;
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
 * @Date 4/11/2021 13:37
 **/
@RestController
@RequestMapping("/ruta")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @GetMapping
    public ResponseEntity<?> getRutas(){
        List<Ruta> data = null;
        HttpStatus status = null;

        data = (List<Ruta>) rutaService.findAll();
        if(data != null){
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(data, status);
    }
}
