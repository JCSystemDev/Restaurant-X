package cl.awakelab.spring7.web.controller;
import cl.awakelab.spring7.model.domain.dto.CamareroDTO;
import cl.awakelab.spring7.web.service.CamareroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/camareros")
public class CamareroRestController {
    private final CamareroService service;
    public CamareroRestController(CamareroService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CamareroDTO>>findAll(){
        return service.findAll()
                .map(CamareroDTO -> new ResponseEntity<>(CamareroDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CamareroDTO> findById(@PathVariable int id){
        return service.findById(id)
                .map(camareroDTO -> new ResponseEntity<>(camareroDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<CamareroDTO> create(@RequestBody CamareroDTO camareroDTO){
        return service.create(camareroDTO)
                .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
    }

    @PatchMapping("/update")
    public ResponseEntity<CamareroDTO> update(@RequestBody CamareroDTO camareroDTO){
        return service.update(camareroDTO)
                .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id){
        return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.OK);
    }

}