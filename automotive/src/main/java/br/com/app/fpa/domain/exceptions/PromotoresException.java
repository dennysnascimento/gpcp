package br.com.app.fpa.domain.exceptions;

import br.com.app.fpa.domain.enums.MensagensErroEnum;

public class PromotoresException extends RegraNegocioException {
    public PromotoresException(MensagensErroEnum mensagensErroEnum) {
        super(mensagensErroEnum);
    }
}