package co.com.sergio.bk.gestor.vuelos.service;

import co.com.sergio.bk.gestor.vuelos.entity.Vuelo;
import co.com.sergio.bk.gestor.vuelos.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 4/11/2021 14:15
 **/
@Service
public class VueloServiceImpl implements VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Vuelo> findAll() {
        return vueloRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Vuelo> findAll(Pageable pageable) {
        return vueloRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Vuelo> findById(int id) {
        return vueloRepository.findById(id);
    }

    @Override
    @Transactional
    public Vuelo save(Vuelo vuelo) {
        if (vuelo.getIdVuelo() == 0) {
            return null;
        }

        return vueloRepository.save(vuelo);
    }

    @Override
    @Transactional
    public Vuelo deleteVuelo(Vuelo vuelo) {
        Vuelo aux = vueloRepository.findById(vuelo.getIdVuelo()).orElse(null);
        vueloRepository.deleteById(vuelo.getIdVuelo());
        return aux;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vuelo> findByFecha(Date fecha) {
        return vueloRepository.findByFecha(fecha);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vuelo> filterVuelos(Date fecha, String idRuta, String conector) {

        List<Vuelo> listResult = null;
        if (fecha != null && idRuta != null) {
            if (conector != null) {
                System.out.println("Funciono");
                switch (conector) {
                    case "AND":
                        listResult = vueloRepository.findByFechaAndRuta(fecha, idRuta);
                        break;
                    case "OR":
                        listResult = vueloRepository.findByFechaOrRuta(fecha, idRuta);
                        break;
                }
            } else {
                System.out.println("Error de datos");
                return listResult;
            }
        }else if(fecha != null){
            listResult = vueloRepository.findByFecha(fecha);
        } else if(idRuta != null){
            listResult = vueloRepository.findByRuta(idRuta);
        } else {
            listResult = vueloRepository.findAll();
        }

        return listResult;
    }

    @Override
    public List<Vuelo> findByFechaAndRuta(Date fecha, String idRuta) {
        return vueloRepository.findByFechaAndRuta(fecha, idRuta);
    }

    @Override
    public List<Vuelo> findByFechaOrRuta(Date fecha, String idRuta) {
        return vueloRepository.findByFechaOrRuta(fecha, idRuta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vuelo> findByRuta(String idRuta) {
        return vueloRepository.findByRuta(idRuta);
    }

    @Override
    @Transactional
    public Vuelo updateVuelo(Vuelo vuelo) {

        Vuelo aux = vueloRepository.findById(vuelo.getIdVuelo()).orElse(null);
        if (aux == null) {
            return aux;
        }
        return vueloRepository.save(vuelo);
    }
}
