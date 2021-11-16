package co.com.sergio.bk.gestor.vuelos.service;

import co.com.sergio.bk.gestor.vuelos.entity.Ruta;
import co.com.sergio.bk.gestor.vuelos.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @project bk-gestor-vuelos
 * @Author Sergio Abelardo Rodríguez Vásquez
 * @Email ingsergiorodriguezv@gmail.com
 * @Date 4/11/2021 13:56
 **/
@Service
public class RutaServiceImpl implements RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Ruta> findAll() {
        return rutaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Ruta> findAll(Pageable pageable) {
        return rutaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Ruta> findById(int id) {
        return rutaRepository.findById(id);
    }

    @Override
    @Transactional()
    public Ruta save(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    @Override
    @Transactional()
    public void deleteById(int id) {
        rutaRepository.deleteById(id);
    }

    @Override
    public List<Ruta> getRuta() {
        return rutaRepository.getRuta();
    }
}
