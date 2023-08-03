package cl.awakelab.spring7.model.persistence.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name="camarero")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Camarero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private int id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Edad")
    private int edad;
    @Column(name = "Fecha_Inicio")
    private Date fechaInicio;
}
