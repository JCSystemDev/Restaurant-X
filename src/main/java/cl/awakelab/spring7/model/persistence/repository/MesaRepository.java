package cl.awakelab.spring7.model.persistence.repository;
import cl.awakelab.spring7.model.persistence.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa,Integer> {
}