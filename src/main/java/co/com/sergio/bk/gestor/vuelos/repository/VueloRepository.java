package co.com.sergio.bk.gestor.vuelos.repository;

import co.com.sergio.bk.gestor.vuelos.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 4/11/2021 14:12
 **/
@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {

    @Query(value = "select * from Vuelo v where v.Fecha_Vuelo = DATE_FORMAT(:fecha, \"%Y-%m-%d\")", nativeQuery = true)
    public List<Vuelo> findByFecha(Date fecha);

    @Query(value = "select * from Vuelo v where v.Ruta_idRuta = :idRuta", nativeQuery = true)
    public List<Vuelo> findByRuta(String idRuta);
}
