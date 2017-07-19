package com.gitghub.thiagogarbazza.exemplos.validatexmlbyxsd;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public abstract class AbstractDomValidatorErrorsForLocale {

    protected abstract XMLTest xmlIsInvalid();

    Collection<XMLError> xmlErros;

    private InputStream xml;

    private InputStream xsd;

    @Before
    public void before() {
        xsd = getResource("students.xsd");
        xml = null;
        xmlErros = null;
    }

    @Test
    public void validateXMLIsInvalid() {
        XMLTest xmlTest = xmlIsInvalid();
        xml = getResource(xmlTest.fileName);
        xmlErros = DomValidator.validate(xsd, xml);

        assertThat(xmlTest.errosExpected, is(xmlErros));
    }

    protected class XMLTest {

        protected Collection<XMLError> errosExpected;

        protected String fileName;

        public XMLTest(String fileName, Collection<XMLError> errosExpected) {
            this.fileName = fileName;
            this.errosExpected = errosExpected;
        }
    }

    protected static InputStream getResource(String name) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
    }
}
