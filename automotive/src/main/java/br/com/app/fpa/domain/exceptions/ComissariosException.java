package br.com.app.fpa.domain.exceptions;

import br.com.app.fpa.domain.enums.MensagensErroEnum;

public class ComissariosException extends RegraNegocioException {
    public ComissariosException(MensagensErroEnum mensagensErroEnum) {
        super(mensagensErroEnum);
    }
}