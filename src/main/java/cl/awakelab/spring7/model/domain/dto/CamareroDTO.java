package cl.awakelab.spring7.model.domain.dto;
import lombok.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CamareroDTO {
    private int id;
    private String nombre;
    private int edad;
    private Date fechaInicio;
}
