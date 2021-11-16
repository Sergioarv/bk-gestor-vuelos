package co.com.sergio.bk.gestor.vuelos.repository;

import co.com.sergio.bk.gestor.vuelos.entity.Ruta;
import co.com.sergio.bk.gestor.vuelos.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 4/11/2021 13:54
 **/
@Repository
public interface RutaRepository extends JpaRepository<Ruta, Integer> {

    @Query(value = "select * from ruta;", nativeQuery = true)
    public List<Ruta> getRuta();
}
