package br.com.app.fpa.domain.exceptions;

import br.com.app.fpa.domain.enums.MensagensErroEnum;

public class CategoriaException extends RegraNegocioException {
    public CategoriaException(MensagensErroEnum mensagensErroEnum) {
        super(mensagensErroEnum);
    }
}