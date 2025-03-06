package br.com.app.fpa.domain.enums;

import lombok.Getter;


@Getter
public enum MensagensErroEnum {
    ID_NOT_FOUND("ID não encontrado.");

    private final String mensagem;

    MensagensErroEnum(String mensagem) {
        this.mensagem = mensagem;
    }

}