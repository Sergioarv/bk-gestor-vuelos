package co.com.sergio.bk.gestor.vuelos.repository;

import co.com.sergio.bk.gestor.vuelos.entity.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 4/11/2021 10:16
 **/
@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Integer> {

}
