package cl.awakelab.spring7.model.persistence.repository;
import cl.awakelab.spring7.model.persistence.entity.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatoRepository extends JpaRepository<Plato,Integer> {
}
