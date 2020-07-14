package co.com.telematica.monitoreo.service;

import co.com.telematica.monitoreo.database.model.Trafico;
import co.com.telematica.monitoreo.database.repository.TraficoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraficoService {
    @Autowired
    TraficoRepository traficoRepository;

    public List<Trafico> getTrafico() {
        return this.traficoRepository.findAll();
    }

    public Trafico guardarRegistro(Trafico trafico) {
        return this.traficoRepository.save(trafico);
    }
}
