package br.com.app.fpa.controller.tipoComissario;

import br.com.app.fpa.domain.exceptions.TipoComissarioException;
import br.com.app.fpa.domain.model.TipoComissario;
import br.com.app.fpa.domain.service.TipoComissarioService;
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
@RequestMapping("/api/tiposComissario")
@Tag(name = "Tipos Comissários", description = "ENDPOINTS para operações relacionadas aos tipos de comissários")
public class TipoComissarioController {


    private final TipoComissarioService tipoComissarioService;

    public TipoComissarioController(TipoComissarioService tipoComissarioService) {
        this.tipoComissarioService = tipoComissarioService;
    }

    @Operation(summary = "Consultar um tipo de comissário por ID")
    @GetMapping("/{id}")
    public ResponseEntity<TipoComissario> getTipoComissarioById(@PathVariable Long id) throws TipoComissarioException {
        TipoComissario tipoComissario = tipoComissarioService.findById(id);
            return ResponseEntity.ok(tipoComissario);
    }

    @GetMapping
    public Page<TipoComissario> getAllTipoComissarios(@ParameterObject Pageable pageable) {
        return tipoComissarioService.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoComissarioById(@PathVariable Long id) {
        tipoComissarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoComissario> updateTipoComissario(@PathVariable Long id,
                                                               @RequestBody TipoComissario tipoComissario) {
        tipoComissario.setId(id);
        TipoComissario updatedTipoComissario = tipoComissarioService.update(tipoComissario);
        return ResponseEntity.ok(updatedTipoComissario);
    }

    @PostMapping
    public ResponseEntity<TipoComissario> createTipoComissario(@RequestBody TipoComissario promotor) {
        TipoComissario createdTipoComissario = tipoComissarioService.save(promotor);
        URI uri = UriUtils.construirUriComId(createdTipoComissario.getId());
        return ResponseEntity.created(uri).body(createdTipoComissario);
    }

}
