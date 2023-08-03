package cl.awakelab.spring7.model.persistence.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name="pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private int id;
    @Column(name = "Mesa_ID")
    private int mesaId;
    @Column(name = "Camarero_ID")
    private int camareroId;
    @Column(name = "Fecha")
    private Date fecha;
    @Column(name = "Total")
    private float total;
}
