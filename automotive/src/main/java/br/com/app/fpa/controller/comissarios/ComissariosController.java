package br.com.app.fpa.controller.comissarios;

import br.com.app.fpa.domain.exceptions.ComissariosException;
import br.com.app.fpa.domain.model.Comissarios;
import br.com.app.fpa.domain.service.ComissariosService;
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
@RequestMapping("/api/comissarios")
@Tag(name = "Comissários", description = "ENDPOINTS para operações relacionadas a comissários")
public class ComissariosController {

    private final ComissariosService comissariosService;

    public ComissariosController(ComissariosService comissariosService) {
        this.comissariosService = comissariosService;
    }

    @Operation(summary = "Consultar um comissário por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Comissarios> getComissarioById(@PathVariable Long id) throws ComissariosException {
        Comissarios comissario = comissariosService.findById(id);
        return ResponseEntity.ok(comissario);
    }

    @GetMapping
    public Page<Comissarios> getAllComissarios(@ParameterObject Pageable pageable) {
        return comissariosService.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComissarioById(@PathVariable Long id) {
        comissariosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comissarios> updateComissario(@PathVariable Long id,
                                                        @RequestBody Comissarios comissario) {
        comissario.setId(id);
        Comissarios updatedComissario = comissariosService.update(comissario);
        return ResponseEntity.ok(updatedComissario);
    }

    @PostMapping
    public ResponseEntity<Comissarios> createComissarios(@RequestBody Comissarios categoria) {
        Comissarios createdComissarios = comissariosService.save(categoria);
        URI uri = UriUtils.construirUriComId(createdComissarios.getId());
        return ResponseEntity.created(uri).body(createdComissarios);
    }

}
