package co.com.sergio.bk.gestor.vuelos.service;

import co.com.sergio.bk.gestor.vuelos.entity.Aerolinea;
import co.com.sergio.bk.gestor.vuelos.repository.AerolineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 4/11/2021 10:34
 **/
@Service
public class AerolineaServiceImpl implements AerolineaService {

    @Autowired
    private AerolineaRepository aerolineaRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aerolinea> findAll() {
        return aerolineaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Aerolinea> findAll(Pageable pageable) {
        return aerolineaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Aerolinea> findById(int id) {
        return aerolineaRepository.findById(id);
    }

    @Override
    @Transactional
    public Aerolinea save(Aerolinea aerolinea) {
        return aerolineaRepository.save(aerolinea);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
    aerolineaRepository.deleteById(id);
    }
}
