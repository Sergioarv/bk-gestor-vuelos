package co.com.sergio.bk.gestor.vuelos.service;

import co.com.sergio.bk.gestor.vuelos.entity.Ruta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 4/11/2021 13:55
 **/
public interface RutaService {

    public Iterable<Ruta> findAll();

    public Page<Ruta> findAll(Pageable pageable);

    public Optional<Ruta> findById(int id);

    public Ruta save(Ruta ruta);

    public void deleteById(int id);
}
