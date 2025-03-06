package br.com.app.fpa.controller.integracoes;

import br.com.app.fpa.domain.response.CepResponse;
import br.com.app.fpa.integracoes.CepClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cep")
@Tag(name = "CepController", description = "Controller para operações de CEP usando FeignClient")
public class CepController {

    @Autowired
    private CepClient cepClient;

    @Operation(summary = "Buscar CEP", description = "Busca os dados completos do CEP informado")
    @GetMapping("/{cep}")
    public ResponseEntity<CepResponse> buscarCep(@PathVariable String cep) {
        CepResponse cepResponse = cepClient.getCepCompleto(cep);
        return ResponseEntity.ok(cepResponse);
    }
}
