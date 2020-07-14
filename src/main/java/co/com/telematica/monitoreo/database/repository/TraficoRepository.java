package co.com.telematica.monitoreo.database.repository;

import co.com.telematica.monitoreo.database.model.Trafico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TraficoRepository extends JpaRepository<Trafico, Integer>  {
}
