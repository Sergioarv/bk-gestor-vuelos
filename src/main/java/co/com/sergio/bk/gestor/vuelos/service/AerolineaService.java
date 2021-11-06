package co.com.sergio.bk.gestor.vuelos.service;

import co.com.sergio.bk.gestor.vuelos.entity.Aerolinea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 4/11/2021 10:28
 **/
public interface AerolineaService {

    public Iterable<Aerolinea> findAll();

    public Page<Aerolinea> findAll(Pageable pageable);

    public Optional<Aerolinea> findById(int id);

    public Aerolinea save(Aerolinea aerolinea);

    public void deleteById(int id);

}
