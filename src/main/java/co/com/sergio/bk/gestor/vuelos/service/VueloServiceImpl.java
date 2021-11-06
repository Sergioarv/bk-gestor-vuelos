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
        if(vuelo.getIdVuelo() == 0 ){
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
    public List<Vuelo> findByFecha(Date fecha){
        return vueloRepository.findByFecha(fecha);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vuelo> findByRuta(String idRuta){
        return vueloRepository.findByRuta(idRuta);
    }

    @Override
    @Transactional
    public Vuelo updateVuelo(Vuelo vuelo) {

        Vuelo aux = vueloRepository.findById(vuelo.getIdVuelo()).orElse(null);
        if(aux == null){
            return aux;
        }
        return vueloRepository.save(vuelo);
    }
}
