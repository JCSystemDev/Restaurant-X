package cl.awakelab.spring7.model.persistence.mapper;
import cl.awakelab.spring7.model.domain.dto.PedidoDTO;
import cl.awakelab.spring7.model.persistence.entity.Pedido;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring")
public interface PedidoMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "mesaId", target = "mesaId"),
            @Mapping(source = "camareroId", target = "camareroId"),
            @Mapping(source = "fecha", target = "fecha"),
            @Mapping(source = "total", target = "total"),
    })

    PedidoDTO toPedido(Pedido pedido);
    List<PedidoDTO> toPedidos(List<Pedido> pedidoList);
    @InheritInverseConfiguration
    Pedido toPedidoDTO(PedidoDTO pedidoDTO);
}
