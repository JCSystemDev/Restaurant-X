package cl.awakelab.spring7.web.controller;
import cl.awakelab.spring7.model.domain.dto.PedidoDTO;
import cl.awakelab.spring7.web.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRestController {
    private final PedidoService service;
    public PedidoRestController(PedidoService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>>findAll(){
        return service.findAll()
                .map(PedidoDTO -> new ResponseEntity<>(PedidoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable int id){
        return service.findById(id)
                .map(pedidoDTO -> new ResponseEntity<>(pedidoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/create")
    public ResponseEntity<PedidoDTO> create(@RequestBody PedidoDTO pedidoDTO){
        return service.create(pedidoDTO)
                .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
    }

    @PatchMapping("/update")
    public ResponseEntity<PedidoDTO> update(@RequestBody PedidoDTO pedidoDTO){
        return service.update(pedidoDTO)
                .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id){
        return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.OK);
    }

}