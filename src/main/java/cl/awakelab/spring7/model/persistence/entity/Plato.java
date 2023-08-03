package cl.awakelab.spring7.model.persistence.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="plato")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private int id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Precio")
    private float precio;
    @Column (name = "Categoria")
    private String categoria;
}
