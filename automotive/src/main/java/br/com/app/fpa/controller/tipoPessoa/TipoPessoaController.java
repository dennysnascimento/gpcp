package br.com.app.fpa.controller.tipoPessoa;

import br.com.app.fpa.domain.exceptions.TipoPessoaException;
import br.com.app.fpa.domain.model.TipoPessoa;
import br.com.app.fpa.domain.service.TipoPessoaService;
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
@RequestMapping("/api/tipoPessoa")
@Tag(name = "Tipo Pessoa", description = "ENDPOINTS para operações relacionadas ao tipo da pessoa")
public class TipoPessoaController {

    private final TipoPessoaService tipoPessoaService;

    public TipoPessoaController(TipoPessoaService tipoPessoaService) {
        this.tipoPessoaService = tipoPessoaService;
    }

    @Operation(summary = "Consultar um tipo de pessoa por ID")
    @GetMapping("/{id}")
    public ResponseEntity<TipoPessoa> getTipoPessoaById(@PathVariable Long id) throws TipoPessoaException {
        TipoPessoa tipoPessoa = tipoPessoaService.findById(id);
        return ResponseEntity.ok(tipoPessoa);

    }

    @GetMapping
    public Page<TipoPessoa> getAllTipoPessoa(@ParameterObject Pageable pageable) {
        return tipoPessoaService.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoPessoaById(@PathVariable Long id) {
        tipoPessoaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPessoa> updateTipoPessoa(@PathVariable Long id,
                                                       @RequestBody TipoPessoa tPessoa) {
        tPessoa.setId(id);
        TipoPessoa updatedTipoPessoa = tipoPessoaService.update(tPessoa);
        return ResponseEntity.ok(updatedTipoPessoa);
    }

    @PostMapping
    public ResponseEntity<TipoPessoa> createTipoPessoa(@RequestBody TipoPessoa tPessoa) {
        TipoPessoa createdTipoPessoa = tipoPessoaService.save(tPessoa);
        URI uri = UriUtils.construirUriComId(createdTipoPessoa.getId());
        return ResponseEntity.created(uri).body(createdTipoPessoa);
    }

}