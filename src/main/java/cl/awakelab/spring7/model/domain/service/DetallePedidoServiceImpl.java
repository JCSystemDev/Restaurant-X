package cl.awakelab.spring7.model.domain.service;
import cl.awakelab.spring7.model.domain.dto.DetallePedidoDTO;
import cl.awakelab.spring7.model.persistence.key.DetallePedidoKey;
import cl.awakelab.spring7.model.persistence.mapper.DetallePedidoMapper;
import cl.awakelab.spring7.web.service.DetallePedidoService;
import cl.awakelab.spring7.model.persistence.repository.DetallePedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    private final DetallePedidoRepository repository;
    private final DetallePedidoMapper mapper;

    public DetallePedidoServiceImpl(DetallePedidoRepository repository, DetallePedidoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<DetallePedidoDTO>> findAll() {
        return Optional.of(mapper.toDetallePedidos(repository.findAll()));
    }
    @Override
    public Optional<DetallePedidoDTO> findById(int id) {
        return repository.findById(id).map(mapper::toDetallePedido);
    }


}