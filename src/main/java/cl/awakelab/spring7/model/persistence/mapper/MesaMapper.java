package cl.awakelab.spring7.model.persistence.mapper;
import cl.awakelab.spring7.model.domain.dto.MesaDTO;
import cl.awakelab.spring7.model.persistence.entity.Mesa;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MesaMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "numero", target = "numero"),
            @Mapping(source = "capacidad", target = "capacidad"),
            @Mapping(source = "ubicacion", target = "ubicacion"),
    })
    MesaDTO toMesa(Mesa mesa);
    List<MesaDTO> toMesas(List<Mesa> mesaList);

    @InheritInverseConfiguration
    Mesa toMesaDTO(MesaDTO mesaDTO);

}
