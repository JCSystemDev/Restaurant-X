package cl.awakelab.spring7.model.persistence.entity;
import cl.awakelab.spring7.model.persistence.key.DetallePedidoKey;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "detalle_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetallePedido {
    @EmbeddedId
    private DetallePedidoKey id;
    @Column(name = "Cantidad")
    private int cantidad;
    @Column(name = "Subtotal")
    private float subtotal;
}
