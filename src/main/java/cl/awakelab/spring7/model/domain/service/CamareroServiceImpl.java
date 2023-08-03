package cl.awakelab.spring7.model.domain.service;

import cl.awakelab.spring7.model.domain.dto.CamareroDTO;
import cl.awakelab.spring7.model.persistence.mapper.CamareroMapper;
import cl.awakelab.spring7.model.persistence.repository.CamareroRepository;
import cl.awakelab.spring7.web.service.CamareroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamareroServiceImpl implements CamareroService {
    private final CamareroRepository repository;
    private final CamareroMapper mapper;

    public CamareroServiceImpl(CamareroRepository repository, CamareroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public Optional<List<CamareroDTO>> findAll() {
        return Optional.of(mapper.toCamareros(repository.findAll()));
    }
    @Override
    public Optional<CamareroDTO> findById(int id) {
        return repository.findById(id).map(mapper::toCamarero);
    }

    @Override
    public Optional<CamareroDTO> create(CamareroDTO camareroDTO)
    {
        return Optional.of(
                mapper.toCamarero(
                        repository.save(
                                mapper.toCamareroDTO(camareroDTO)
                        )
                ));
    }
    @Override
    public Optional<CamareroDTO> update(CamareroDTO camareroDTO) {
        if (repository.existsById(camareroDTO.getId())){
            return Optional.of(
                    mapper.toCamarero(
                            repository.save(
                                    mapper.toCamareroDTO(camareroDTO)
                            )
                    ));
        }
        return Optional.of(new CamareroDTO());
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