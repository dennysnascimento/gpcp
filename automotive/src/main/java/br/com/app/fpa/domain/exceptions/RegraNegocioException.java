package br.com.app.fpa.domain.exceptions;


import br.com.app.fpa.domain.enums.MensagensErroEnum;
import lombok.Getter;

import java.io.Serial;


@Getter
public class RegraNegocioException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    private final MensagensErroEnum erroEnum;

    public RegraNegocioException(MensagensErroEnum erroEnum) {
        this.erroEnum = erroEnum;
    }

}
