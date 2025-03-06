package br.com.app.fpa.domain.exceptions;

import br.com.app.fpa.domain.enums.MensagensErroEnum;

public class CarrosException extends RegraNegocioException {

    public CarrosException(MensagensErroEnum mensagensErroEnum) {
        super(mensagensErroEnum);
    }

}