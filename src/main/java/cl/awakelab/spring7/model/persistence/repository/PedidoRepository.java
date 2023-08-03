package cl.awakelab.spring7.model.persistence.repository;
import cl.awakelab.spring7.model.persistence.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
}