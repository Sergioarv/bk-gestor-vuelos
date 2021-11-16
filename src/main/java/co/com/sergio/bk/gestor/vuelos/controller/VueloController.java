package co.com.sergio.bk.gestor.vuelos.controller;

import co.com.sergio.bk.gestor.vuelos.entity.Vuelo;
import co.com.sergio.bk.gestor.vuelos.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 4/11/2021 14:17
 **/
@RestController
@RequestMapping("/vuelo")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
public class VueloController {

    @Autowired
    private VueloService vueloService;

    /**
     * Método para obtener los vuelos existentes en DB
     *
     * @Author Sergio Abelardo Rodríguez Vásquez
     * @Email ingsergiorodriguezv@gmail.com
     * @Date 4/11/2021 15:10
     *
     * @Param []
     * @return ResponseEntity, lista de vuelos
     *
    **/
    @GetMapping
    public ResponseEntity<?> getVuelos(){
        List<Vuelo> data = null;
        HttpStatus status = null;

        data = (List<Vuelo>) vueloService.findAll();
        if(data != null){
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(data, status);
    }

    /**
     * Método para obtener un vuelo por su Id
     *
     * @Author Sergio Abelardo Rodríguez Vásquez
     * @Email ingsergiorodriguezv@gmail.com
     * @Date 4/11/2021 15:12
     *
     * @Param [id], id del vuelo a buscar
     * @return ResponseEntity, Vuelo encontrado por id
     *
    **/
    @GetMapping("/{id}")
    public ResponseEntity<?> getVueloById(@PathVariable (value = "id") int id){
        Optional<Vuelo> data = null;
        HttpStatus status = null;

        data = vueloService.findById(id);
        if(data != null){
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(data, status);
    }

    /**
     * Método para obtener la lista de vuelos por fecha
     *
     * @Author Sergio Abelardo Rodríguez Vásquez
     * @Email ingsergiorodriguezv@gmail.com
     * @Date 5/11/2021 10:50
     *
     * @Param [fecha], fecha de los vuelos a buscar
     * @return ResponseEntity, lista de veulos encontrados en la fecha
     *
    **/
    @GetMapping("/FechaVuelo")
    public ResponseEntity<?> getVueloByDate(@RequestParam("fechaVuelo") @DateTimeFormat(pattern="yyyy-MM-dd") Date fecha){
        List<Vuelo> data = null;
        HttpStatus status = null;

        data = vueloService.findByFecha(fecha);
        if(data != null){
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(data, status);
    }

    /**
     * Método encargado de filtrar segun los parametros de busqueda
     *
     * @Author Sergio Abelardo Rodríguez Vásquez
     * @Email ingsergiorodriguezv@gmail.com
     * @Date 13/11/2021 17:51
     *
     * @Param [fecha, idRuta, conector] parametos permitidos como busqueda
     * @return
     *
    **/
    @GetMapping("/filterVuelos")
    public ResponseEntity<?> filterVuelos(@RequestParam(value = "fechaVuelo", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fecha,
                                          @RequestParam(value = "idRuta", required = false) String idRuta,
                                          @RequestParam(value = "conector", required = false) String conector){
        List<Vuelo> data = null;
        HttpStatus status = null;

        data = vueloService.filterVuelos(fecha, idRuta, conector);
        if(data != null){
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(data, status);
    }

    /**
     * Método para obtener la lista de vuelos por ruta
     *
     * @Author Sergio Abelardo Rodríguez Vásquez
     * @Email ingsergiorodriguezv@gmail.com
     * @Date 5/11/2021 10:50
     *
     * @Param [fecha], fecha de los vuelos a buscar
     * @return ResponseEntity, lista de veulos encontrados en la fecha
     *
     **/
    @GetMapping("/Ruta")
    public ResponseEntity<?> getVueloByRuta(@RequestParam String idRuta){
        List<Vuelo> data = null;
        HttpStatus status = null;

        data = vueloService.findByRuta(idRuta);

        if(data != null){
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(data, status);
    }

    /**
     * Método para guardar un nuevo Vuelo
     *
     * @Author Sergio Abelardo Rodríguez Vásquez
     * @Email ingsergiorodriguezv@gmail.com
     * @Date 5/11/2021 11:05
     *
     * @Param [vuelo], Entidad vuelo a guardar
     * @return ResponseEntity, retorna el vuelo guardardo
     *
    **/
    @PostMapping
    public ResponseEntity<?> saveVuelo(@RequestBody Vuelo vuelo){
        Vuelo data = null;
        HttpStatus status = null;

        data = vueloService.save(vuelo);
        if(data != null){
            status = HttpStatus.CREATED;
        }else{
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(data, status);
    }

    /**
     * Método para actualizar un Vuelo
     *
     * @Author Sergio Abelardo Rodríguez Vásquez
     * @Email ingsergiorodriguezv@gmail.com
     * @Date 5/11/2021 11:05
     *
     * @Param [vuelo], Entidad vuelo a actualizar
     * @return ResponseEntity, retorna el vuelo actualizado
     *
     **/
    @PutMapping
    public ResponseEntity<?> updateVuelo(@RequestBody Vuelo vuelo){
        Vuelo data = null;
        HttpStatus status = null;

        data = vueloService.updateVuelo(vuelo);
        if(data != null){
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(data, status);
    }

    /**
     * Método para eliminar un Vuelo
     *
     * @Author Sergio Abelardo Rodríguez Vásquez
     * @Email ingsergiorodriguezv@gmail.com
     * @Date 5/11/2021 11:05
     *
     * @Param [vuelo], Entidad vuelo a actualizar
     * @return ResponseEntity, retorna el vuelo actualizado
     *
     **/
    @DeleteMapping
    public ResponseEntity<?> deleteVuelo(@RequestBody Vuelo vuelo){
        Vuelo data = null;
        HttpStatus status = null;

        data = vueloService.deleteVuelo(vuelo);
        if(data != null){
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(data, status);
    }
}
