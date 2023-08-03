package cl.awakelab.spring7.model.persistence.mapper;
import cl.awakelab.spring7.model.domain.dto.DetallePedidoDTO;
import cl.awakelab.spring7.model.persistence.entity.DetallePedido;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring")
public interface DetallePedidoMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "cantidad", target = "cantidad"),
            @Mapping(source = "subtotal", target = "subtotal"),
    })
    DetallePedidoDTO toDetallePedido(DetallePedido detallePedido);
    List<DetallePedidoDTO> toDetallePedidos(List<DetallePedido> detallePedidoList);
    @InheritInverseConfiguration
    DetallePedido toDetallePedidoDTO (DetallePedidoDTO detallePedidoDTO);

}
