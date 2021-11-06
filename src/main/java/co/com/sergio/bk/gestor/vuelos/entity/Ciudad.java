package co.com.sergio.bk.gestor.vuelos.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 4/11/2021 13:40
 **/
@Entity
@Table(name = "ciudades")
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCiudades;
    private String nombreCiudad;

    public int getIdCiudades() {
        return idCiudades;
    }

    public void setIdCiudades(int idCiudades) {
        this.idCiudades = idCiudades;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
}
