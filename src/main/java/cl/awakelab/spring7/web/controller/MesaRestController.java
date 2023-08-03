package cl.awakelab.spring7.web.controller;
import cl.awakelab.spring7.model.domain.dto.MesaDTO;
import cl.awakelab.spring7.web.service.MesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mesas")
public class MesaRestController {
    private final MesaService service;
    public MesaRestController(MesaService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MesaDTO>>findAll(){
        return service.findAll()
                .map(MesaDTO -> new ResponseEntity<>(MesaDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaDTO> findById(@PathVariable int id){
        return service.findById(id)
                .map(mesaDTO -> new ResponseEntity<>(mesaDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<MesaDTO> create(@RequestBody MesaDTO mesaDTO){
        return service.create(mesaDTO)
                .map(t-> new ResponseEntity<>(t, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
    }

    @PatchMapping("/update")
    public ResponseEntity<MesaDTO> update(@RequestBody MesaDTO mesaDTO){
        return service.update(mesaDTO)
                .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id){
        return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.OK);
    }

}