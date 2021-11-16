package co.com.sergio.bk.gestor.vuelos.service;

import co.com.sergio.bk.gestor.vuelos.entity.Vuelo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 4/11/2021 14:13
 **/
public interface VueloService{

    public Iterable<Vuelo> findAll();

    public Page<Vuelo> findAll(Pageable pageable);

    public Optional<Vuelo> findById(int id);

    public Vuelo save(Vuelo vuelo);

    public Vuelo deleteVuelo(Vuelo vuelo);

    List<Vuelo> findByFecha(Date Fecha);

    List<Vuelo> filterVuelos(Date fecha, String idRuta, String conector);

    List<Vuelo> findByFechaAndRuta(Date fecha, String idRuta);

    List<Vuelo> findByFechaOrRuta(Date fecha, String idRuta);

    List<Vuelo> findByRuta(String idRuta);

    public Vuelo updateVuelo(Vuelo vuelo);
}
