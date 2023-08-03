package cl.awakelab.spring7.model.domain.service;

import cl.awakelab.spring7.model.domain.dto.MesaDTO;
import cl.awakelab.spring7.model.persistence.mapper.MesaMapper;
import cl.awakelab.spring7.model.persistence.repository.MesaRepository;
import cl.awakelab.spring7.web.service.MesaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaServiceImpl implements MesaService {
    private final MesaRepository repository;
    private final MesaMapper mapper;

    public MesaServiceImpl(MesaRepository repository, MesaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public Optional<List<MesaDTO>> findAll() {
        return Optional.of(mapper.toMesas(repository.findAll()));
    }
    @Override
    public Optional<MesaDTO> findById(int id) {
        return repository.findById(id).map(mapper::toMesa);
    }

    @Override
    public Optional<MesaDTO> create(MesaDTO mesaDTO)
    {
        return Optional.of(
                mapper.toMesa(
                        repository.save(
                                mapper.toMesaDTO(mesaDTO)
                        )
                ));
    }
    @Override
    public Optional<MesaDTO> update(MesaDTO mesaDTO) {
        if (repository.existsById(mesaDTO.getId())){
            return Optional.of(
                    mapper.toMesa(
                            repository.save(
                                    mapper.toMesaDTO(mesaDTO)
                            )
                    ));
        }
        return Optional.of(new MesaDTO());
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