package co.com.sergio.bk.gestor.vuelos.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 4/11/2021 14:06
 **/
@Entity
@Table(name = "vuelo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vuelo implements Serializable {

    private static final long serialVersioUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVuelo;

    @Column(name = "Fecha_Vuelo")
    @DateTimeFormat(pattern = "%Y-%m-%d")
    private Date fecha_vuelo;

    @OneToOne
    @JoinColumn(name = "Ruta_idRuta")
    private Ruta Ruta_idRuta;

    @ManyToOne
    @JoinColumn(name = "Aerolinea_idAerolinea")
    private Aerolinea Aerolinea_idAerolinea;

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Date getFecha_vuelo() {
        return fecha_vuelo;
    }

    public void setFecha_vuelo(Date fecha_vuelo) {
        this.fecha_vuelo = fecha_vuelo;
    }

    public Aerolinea getAerolinea_idAerolinea() {
        return Aerolinea_idAerolinea;
    }

    public void setAerolinea_idAerolinea(Aerolinea aerolinea_idAerolinea) {
        Aerolinea_idAerolinea = aerolinea_idAerolinea;
    }

    public Ruta getRuta_idRuta() {
        return Ruta_idRuta;
    }

    public void setRuta_idRuta(Ruta ruta_idRuta) {
        Ruta_idRuta = ruta_idRuta;
    }
}
