package br.com.app.fpa.integracoes;

import br.com.app.fpa.domain.response.CepResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cepClient", url = "https://viacep.com.br/ws")
@Tag(name = "Cep", description = "Operações relacionadas ao CEP")
public interface CepClient {

    @Operation(summary = "Obter dados completos do CEP",
            description = "Retorna os dados completos do CEP fornecido")
    @GetMapping("/{cep}/json/")
    CepResponse getCepCompleto(@PathVariable("cep") String cep);

}
