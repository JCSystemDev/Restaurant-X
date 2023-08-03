package cl.awakelab.spring7.web.service;
import cl.awakelab.spring7.model.domain.dto.DetallePedidoDTO;
import java.util.List;
import java.util.Optional;

public interface DetallePedidoService {
    Optional<List<DetallePedidoDTO>> findAll();
    Optional <DetallePedidoDTO> findById(int id);
}
