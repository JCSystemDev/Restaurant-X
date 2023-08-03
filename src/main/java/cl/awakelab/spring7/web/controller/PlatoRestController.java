package cl.awakelab.spring7.web.controller;
import cl.awakelab.spring7.model.domain.dto.PlatoDTO;
import cl.awakelab.spring7.web.service.PlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/platos")
public class PlatoRestController {
    private final PlatoService service;
    public PlatoRestController(PlatoService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PlatoDTO>>findAll(){
        return service.findAll()
                .map(PlatoDTO -> new ResponseEntity<>(PlatoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatoDTO> findById(@PathVariable int id){
        return service.findById(id)
                .map(platoDTO -> new ResponseEntity<>(platoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<PlatoDTO> create(@RequestBody PlatoDTO platoDTO){
        return service.create(platoDTO)
                .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
    }

    @PatchMapping("/update")
    public ResponseEntity<PlatoDTO> update(@RequestBody PlatoDTO platoDTO){
        return service.update(platoDTO)
                .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id){
        return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.OK);
    }
}
