package br.com.app.fpa.controller.promotores;

import br.com.app.fpa.domain.exceptions.PromotoresException;
import br.com.app.fpa.domain.model.Promotores;
import br.com.app.fpa.domain.service.PromotoresService;
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
@RequestMapping("/api/promotores")
@Tag(name = "Promotores", description = "ENDPOINTS para operações relacionadas aos promotores")
public class PromotoresController {


    private final PromotoresService promotoresService;

    public PromotoresController(PromotoresService promotoresService) {
        this.promotoresService = promotoresService;
    }

    @Operation(summary = "Consultar um promotor por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Promotores> getPromotorById(@PathVariable Long id) throws PromotoresException {
        Promotores promotor = promotoresService.findById(id);
        return ResponseEntity.ok(promotor);

    }

    @GetMapping
    public Page<Promotores> getAllPromotores(@ParameterObject Pageable pageable) {
        return promotoresService.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromotorById(@PathVariable Long id) {
        promotoresService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promotores> updatePromotor(@PathVariable Long id,
                                                     @RequestBody Promotores promotor) {
        promotor.setId(id);
        Promotores updatedPromotor = promotoresService.update(promotor);
        return ResponseEntity.ok(updatedPromotor);
    }

    @PostMapping
    public ResponseEntity<Promotores> createPromotores(@RequestBody Promotores promotor) {
        Promotores createdPromotores = promotoresService.save(promotor);
        URI uri = UriUtils.construirUriComId(createdPromotores.getId());
        return ResponseEntity.created(uri).body(createdPromotores);
    }

}
