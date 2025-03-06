package br.com.app.fpa.openapi;


import lombok.Getter;

@Getter
public enum SpringDocsConfigEnum {

    CARROS("Carros", "API de serviços FPA",
            "br.com.app.fpa.controller.carros"),

    CATEGORIA("Categoria", "API de serviços FPA",
            "br.com.app.fpa.controller.categoria"),

    COMISSARIOS("Comissários", "API de serviços FPA",
            "br.com.app.fpa.controller.comissarios"),

    MODALIDADES("Modalidades", "API de serviços FPA",
            "br.com.app.fpa.controller.modalidades"),

    PILOTOS("Pilotos", "API de serviços FPA",
            "br.com.app.fpa.controller.pilotos"),

    PROMOTORES("Promotores", "API de serviços FPA",
            "br.com.app.fpa.controller.promotores"),

    TIPO_COMISSARIO("Tipo Comissário", "API de serviços FPA",
            "br.com.app.fpa.controller.tipoComissario"),

    INTEGRACOES("Integrações", "Serviços de Integrações",
            "br.com.app.fpa.controller.integracoes"),

    TIPO_PESSOA("Tipo Pessoa", "API de serviços FPA",
            "br.com.app.fpa.controller.tipoPessoa");


    private final String titulo;
    private final String descricao;
    private final String packageToScan;
    private final String[] packagesToExclude;

    SpringDocsConfigEnum(String titulo,
                         String descricao,
                         String packageToScan,
                         String... packagesToExclude) {

        this.titulo = titulo;
        this.descricao = descricao;
        this.packageToScan = packageToScan;
        this.packagesToExclude = packagesToExclude;
    }

}