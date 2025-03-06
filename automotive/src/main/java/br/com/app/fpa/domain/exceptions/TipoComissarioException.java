package br.com.app.fpa.domain.exceptions;

import br.com.app.fpa.domain.enums.MensagensErroEnum;

public class TipoComissarioException extends RegraNegocioException {
    public TipoComissarioException(MensagensErroEnum mensagensErroEnum) {
        super(mensagensErroEnum);
    }
}