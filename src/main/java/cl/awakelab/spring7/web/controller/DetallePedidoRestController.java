package cl.awakelab.spring7.web.controller;

import cl.awakelab.spring7.model.domain.dto.DetallePedidoDTO;
import cl.awakelab.spring7.web.service.DetallePedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/detallepedidos")
public class DetallePedidoRestController {
    private final DetallePedidoService service;
    public DetallePedidoRestController(DetallePedidoService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DetallePedidoDTO>> findAll(){
        return service.findAll()
                .map(DetallePedidoDTO -> new ResponseEntity<>(DetallePedidoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> findById(@PathVariable int id){
        return service.findById(id)
                .map(detallePedidoDTO -> new ResponseEntity<>(detallePedidoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
