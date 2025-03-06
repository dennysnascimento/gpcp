package br.com.app.fpa.controller.modalidades;

import br.com.app.fpa.domain.exceptions.ModalidaeException;
import br.com.app.fpa.domain.model.Modalidades;
import br.com.app.fpa.domain.service.ModalidadesService;
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
@RequestMapping("/api/modalidades")
@Tag(name = "Modalidades", description = "ENDPOINTS para operações relacionadas a modalidades")
public class ModalidadesController {

    private final ModalidadesService modalidadesService;

    public ModalidadesController(ModalidadesService modalidadesService) {
        this.modalidadesService = modalidadesService;
    }

    @Operation(summary = "Consultar uma modalidade por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Modalidades> getModalidadeById(@PathVariable Long id) throws ModalidaeException {
        Modalidades modalidade = modalidadesService.findById(id);
        return ResponseEntity.ok(modalidade);
    }

    @GetMapping
    public Page<Modalidades> getAllModalidades(@ParameterObject Pageable pageable) {
        return modalidadesService.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModalidadeById(@PathVariable Long id) {
        modalidadesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modalidades> updateModalidade(@PathVariable Long id,
                                                        @RequestBody Modalidades modalidade) {
        modalidade.setId(id);
        Modalidades updatedModalidade = modalidadesService.update(modalidade);
        return ResponseEntity.ok(updatedModalidade);
    }

    @PostMapping
    public ResponseEntity<Modalidades> createModalidades(@RequestBody Modalidades modalidade) {
        Modalidades createdModalidades = modalidadesService.save(modalidade);
        URI uri = UriUtils.construirUriComId(createdModalidades.getId());
        return ResponseEntity.created(uri).body(createdModalidades);
    }

}
