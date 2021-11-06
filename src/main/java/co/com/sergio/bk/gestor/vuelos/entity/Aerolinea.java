package co.com.sergio.bk.gestor.vuelos.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 4/11/2021 10:02
 **/
@Entity
@Table(name = "aerolinea")
public class Aerolinea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAerolinea")
    private int id_aerolinea;

    @Column(length = 45)
    private String nombreAerolinea;

    public int getId_aerolinea() {
        return id_aerolinea;
    }

    public void setId_aerolinea(int id_aerolinea) {
        this.id_aerolinea = id_aerolinea;
    }

    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }
}
