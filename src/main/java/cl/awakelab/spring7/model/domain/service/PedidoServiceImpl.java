package cl.awakelab.spring7.model.domain.service;

import cl.awakelab.spring7.model.domain.dto.PedidoDTO;
import cl.awakelab.spring7.model.persistence.mapper.PedidoMapper;
import cl.awakelab.spring7.model.persistence.repository.PedidoRepository;
import cl.awakelab.spring7.web.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository repository;
    private final PedidoMapper mapper;

    public PedidoServiceImpl(PedidoRepository repository, PedidoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public Optional<List<PedidoDTO>> findAll() {
        return Optional.of(mapper.toPedidos(repository.findAll()));
    }
    @Override
    public Optional<PedidoDTO> findById(int id) {
        return repository.findById(id).map(mapper::toPedido);
    }

    @Override
    public Optional<PedidoDTO> create(PedidoDTO pedidoDTO)
    {
        return Optional.of(
                mapper.toPedido(
                        repository.save(
                                mapper.toPedidoDTO(pedidoDTO)
                        )
                ));
    }
    @Override
    public Optional<PedidoDTO> update(PedidoDTO pedidoDTO) {
        if (repository.existsById(pedidoDTO.getId())){
            return Optional.of(
                    mapper.toPedido(
                            repository.save(
                                    mapper.toPedidoDTO(pedidoDTO)
                            )
                    ));
        }
        return Optional.of(new PedidoDTO());
    }
    @Override
    public boolean delete(int id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}