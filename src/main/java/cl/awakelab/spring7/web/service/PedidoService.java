package cl.awakelab.spring7.web.service;
import cl.awakelab.spring7.model.domain.dto.PedidoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PedidoService {
    Optional<List<PedidoDTO>> findAll();
    Optional <PedidoDTO> findById(int id);
    Optional<PedidoDTO> create(PedidoDTO pedidoDTO);
    Optional<PedidoDTO> update (PedidoDTO pedidoDTO);
    boolean delete(int id);

}
