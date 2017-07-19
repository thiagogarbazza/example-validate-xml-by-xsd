package com.gitghub.thiagogarbazza.exemplos.validatexmlbyxsd;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.Collection;

class DomErrorHandler implements ErrorHandler {

    static final String ERRO_KEY = "xml.sintaxe";

    final Collection<XMLError> erros;

    public DomErrorHandler() {
        erros = new ArrayList<>();
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        erros.add(new XMLError(ERRO_KEY, e.getMessage()));
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        erros.add(new XMLError(ERRO_KEY, e.getMessage()));
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        erros.add(new XMLError(ERRO_KEY, e.getMessage()));
    }

    public Collection<XMLError> getErros() {
        return erros;
    }
}
