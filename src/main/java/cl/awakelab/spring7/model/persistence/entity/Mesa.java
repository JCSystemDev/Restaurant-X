package cl.awakelab.spring7.model.persistence.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="mesa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private int id;
    @Column(name = "Numero")
    private int numero;
    @Column(name = "Capacidad")
    private int capacidad;
    @Column(name = "Ubicacion")
    private String ubicacion;
}
