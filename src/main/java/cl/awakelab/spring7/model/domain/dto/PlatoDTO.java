package cl.awakelab.spring7.model.domain.dto;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlatoDTO {
    private int id;
    private String nombre;
    private String descripcion;
    private float precio;
    private String categoria;
}
