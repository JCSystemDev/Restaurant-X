package cl.awakelab.spring7.model.domain.dto;
import lombok.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoDTO {
    private int id;
    private int mesaId;
    private int camareroId;
    private Date fecha;
    private float total;
}
