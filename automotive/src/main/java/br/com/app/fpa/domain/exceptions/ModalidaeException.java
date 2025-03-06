package br.com.app.fpa.domain.exceptions;

import br.com.app.fpa.domain.enums.MensagensErroEnum;

public class ModalidaeException extends RegraNegocioException {
    public ModalidaeException(MensagensErroEnum mensagensErroEnum) {
        super(mensagensErroEnum);
    }
}