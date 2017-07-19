package com.gitghub.thiagogarbazza.exemplos.validatexmlbyxsd;

public class DomException extends RuntimeException {

    public DomException(final String mensagem, final Throwable throwable) {
        super(mensagem, throwable);
    }
}
