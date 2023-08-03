package cl.awakelab.spring7.model.domain.dto;
import cl.awakelab.spring7.model.persistence.key.DetallePedidoKey;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetallePedidoDTO {
    private DetallePedidoKey id;
    private int cantidad;
    private float subtotal;

}
