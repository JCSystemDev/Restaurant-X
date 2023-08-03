package cl.awakelab.spring7.model.domain.dto;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MesaDTO {
    private int id;
    private int numero;
    private int capacidad;
    private String ubicacion;
}
