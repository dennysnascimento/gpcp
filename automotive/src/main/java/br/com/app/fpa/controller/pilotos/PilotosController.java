package br.com.app.fpa.controller.pilotos;

import br.com.app.fpa.domain.exceptions.PilotosException;
import br.com.app.fpa.domain.model.Pilotos;
import br.com.app.fpa.domain.service.PilotosService;
import br.com.app.fpa.util.UriUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/pilotos")
@Tag(name = "Pilotos", description = "ENDPOINTS para operações relacionadas aos pilotos")
public class PilotosController {

    private final PilotosService pilotosService;

    public PilotosController(PilotosService pilotosService) {
        this.pilotosService = pilotosService;
    }

    @Operation(summary = "Consultar um piloto por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Pilotos> getPilotoById(@PathVariable Long id) throws PilotosException {
        Pilotos piloto = pilotosService.findById(id);
        return ResponseEntity.ok(piloto);

    }

    @GetMapping
    public Page<Pilotos> getAllPilotos(@ParameterObject Pageable pageable) {
        return pilotosService.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePilotoById(@PathVariable Long id) {
        pilotosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pilotos> updatePiloto(@PathVariable Long id,
                                                @RequestBody Pilotos piloto) {
        piloto.setId(id);
        Pilotos updatedPiloto = pilotosService.update(piloto);
        return ResponseEntity.ok(updatedPiloto);
    }

    @PostMapping
    public ResponseEntity<Pilotos> createPilotos(@RequestBody Pilotos piloto) {
        Pilotos createdPilotos = pilotosService.save(piloto);
        URI uri = UriUtils.construirUriComId(createdPilotos.getId());
        return ResponseEntity.created(uri).body(createdPilotos);
    }

}