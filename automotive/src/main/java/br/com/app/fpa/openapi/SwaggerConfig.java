package br.com.app.fpa.openapi;

import br.com.app.fpa.FpaAppApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Value("${project.version}")
    private String version;

    @Bean
    GroupedOpenApi groupOpenApiCarros() {
        return criarGroupOpenApi(SpringDocsConfigEnum.CARROS);
    }

    @Bean
    GroupedOpenApi groupOpenApiCategoria() {
        return criarGroupOpenApi(SpringDocsConfigEnum.CATEGORIA);
    }

    @Bean
    GroupedOpenApi groupOpenApiComissarios() {
        return criarGroupOpenApi(SpringDocsConfigEnum.COMISSARIOS);
    }

    @Bean
    GroupedOpenApi groupOpenApiIntegracoes() {
        return criarGroupOpenApi(SpringDocsConfigEnum.INTEGRACOES);
    }

    @Bean
    GroupedOpenApi groupOpenApiModalidades() {
        return criarGroupOpenApi(SpringDocsConfigEnum.MODALIDADES);
    }

    @Bean
    GroupedOpenApi groupOpenApiPilotos() {
        return criarGroupOpenApi(SpringDocsConfigEnum.PILOTOS);
    }

    @Bean
    GroupedOpenApi groupOpenApiPromotores() {
        return criarGroupOpenApi(SpringDocsConfigEnum.PROMOTORES);
    }

    @Bean
    GroupedOpenApi groupOpenApiTipoComissario() {
        return criarGroupOpenApi(SpringDocsConfigEnum.TIPO_COMISSARIO);
    }

    @Bean
    GroupedOpenApi groupOpenApiTipoPessoa() {
        return criarGroupOpenApi(SpringDocsConfigEnum.TIPO_PESSOA);
    }

    private String getVersaoString() {
        return "v" + version + "__" + FpaAppApplication.dataSistema;
    }

    private GroupedOpenApi criarGroupOpenApi(SpringDocsConfigEnum springDocsConfigEnum) {
        return GroupedOpenApi.builder()
                .group(springDocsConfigEnum.name())
                .packagesToScan(springDocsConfigEnum.getPackageToScan())
                .packagesToExclude(springDocsConfigEnum.getPackagesToExclude())
                .addOpenApiCustomizer(openApi ->
                        openApi.info(new Info()
                                .title(springDocsConfigEnum.getTitulo())
                                .description(springDocsConfigEnum.getDescricao())
                                .version(getVersaoString())))
                .build();
    }

}