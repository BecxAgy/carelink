package com.ws.carelink.shared.exception;

import com.ws.carelink.shared.internacionalization.Messages;

public class ObjetoNaoEncontradoException extends BusinessException {
    private static final long serialVersionUID = 1L;

    public ObjetoNaoEncontradoException() {
        super(Messages.get("objeto-nao-encontrado"));
    }
    
}
