package br.com.app.fpa.domain.exceptions;

import br.com.app.fpa.domain.enums.MensagensErroEnum;

public class PilotosException extends RegraNegocioException {
    public PilotosException(MensagensErroEnum mensagensErroEnum) {
        super(mensagensErroEnum);
    }
}