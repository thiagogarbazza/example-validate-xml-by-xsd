package com.gitghub.thiagogarbazza.exemplos.validatexmlbyxsd;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.InputStream;
import java.util.Collection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DomValidatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
    public void findXSD() {
        assertNotNull(xsd);
        assertNull(xml);
        assertNull(xmlErros);
    }

    @Test
    public void validateNotInforationXML() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Please information XML stream.");

        DomValidator.validate(xsd, null);
    }

    @Test
    public void validateNotInforationXSD() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Please information XSD stream.");

        DomValidator.validate(null, null);
    }

    @Test
    public void validateXMLIsValid() {
        xml = getResource("students-valid.xml");
        xmlErros = DomValidator.validate(xsd, xml);

        assertTrue(xmlErros.isEmpty());
    }

    protected static InputStream getResource(String name) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
    }
}
