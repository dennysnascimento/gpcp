package br.com.app.fpa.domain.exceptions;

import br.com.app.fpa.domain.enums.MensagensErroEnum;

public class TipoPessoaException extends RegraNegocioException {
    public TipoPessoaException(MensagensErroEnum mensagensErroEnum) {
        super(mensagensErroEnum);
    }
}