package br.com.app.fpa.controller.carros;

import br.com.app.fpa.domain.exceptions.CarrosException;
import br.com.app.fpa.domain.model.Carros;
import br.com.app.fpa.domain.service.CarrosService;
import br.com.app.fpa.util.UriUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/carros")
@Tag(name = "Carros", description = "ENDPOINTS para operações relacionadas a carros")
public class CarrosController {

    private final CarrosService carrosService;

    public CarrosController(CarrosService carrosService) {
        this.carrosService = carrosService;
    }

    @Operation(summary = "Consultar um carro por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Carros> getCarroById(@PathVariable Long id) throws CarrosException {
        Carros carro = carrosService.findById(id);
        return ResponseEntity.ok(carro);
    }

    @GetMapping
    public Page<Carros> getAllCarros(@ParameterObject Pageable pageable) {
        return carrosService.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarroById(@PathVariable Long id) {
        carrosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carros> updateCarro(@PathVariable Long id,
                                              @RequestBody Carros carro) {
        carro.setId(id);
        Carros updatedCarro = carrosService.update(carro);
        return ResponseEntity.ok(updatedCarro);
    }

    @PostMapping
    public ResponseEntity<Carros> createCarro(@RequestBody Carros carro) {
        Carros createdCarro = carrosService.save(carro);
        URI uri = UriUtils.construirUriComId(createdCarro.getId());
        return ResponseEntity.created(uri).body(createdCarro);
    }

}