package cl.awakelab.spring7.model.persistence.repository;
import cl.awakelab.spring7.model.persistence.entity.Camarero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamareroRepository extends JpaRepository<Camarero,Integer> {
}
