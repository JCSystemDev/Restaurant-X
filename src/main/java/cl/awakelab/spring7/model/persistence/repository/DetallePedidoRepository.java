package cl.awakelab.spring7.model.persistence.repository;
import cl.awakelab.spring7.model.persistence.entity.DetallePedido;
import cl.awakelab.spring7.model.persistence.key.DetallePedidoKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {
}
