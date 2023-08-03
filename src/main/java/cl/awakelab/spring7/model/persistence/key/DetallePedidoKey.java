package cl.awakelab.spring7.model.persistence.key;
import java.io.Serializable;
import jakarta.persistence.*;

@Embeddable
public class DetallePedidoKey implements Serializable {
    @Column(name = "Pedido_ID")
    private int pedidoId;

    @Column(name = "Plato_ID")
    private int platoId;
}
