package cl.awakelab.spring7.web.service;
import cl.awakelab.spring7.model.domain.dto.MesaDTO;

import java.util.List;
import java.util.Optional;
public interface MesaService {
    Optional<List<MesaDTO>> findAll();
    Optional <MesaDTO> findById(int id);
    Optional<MesaDTO> create(MesaDTO mesaDTO);
    Optional<MesaDTO> update (MesaDTO mesaDTO);
    boolean delete(int id);
}
