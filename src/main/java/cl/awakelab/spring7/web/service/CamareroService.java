package cl.awakelab.spring7.web.service;
import cl.awakelab.spring7.model.domain.dto.CamareroDTO;

import java.util.List;
import java.util.Optional;

public interface CamareroService {
    Optional<List<CamareroDTO>> findAll();
    Optional <CamareroDTO> findById(int id);
    Optional<CamareroDTO> create(CamareroDTO camareroDTO);
    Optional<CamareroDTO> update (CamareroDTO camareroDTO);
    boolean delete(int id);
}
