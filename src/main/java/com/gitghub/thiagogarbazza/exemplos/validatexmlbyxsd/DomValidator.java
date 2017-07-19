package com.gitghub.thiagogarbazza.exemplos.validatexmlbyxsd;

import org.apache.commons.lang3.Validate;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import static com.gitghub.thiagogarbazza.exemplos.validatexmlbyxsd.utils.IOUtils.closeQuietly;

public final class DomValidator {

    private DomValidator() {}

    public static Collection<XMLError> validate(InputStream xsd, InputStream xml) {
        Validate.notNull(xsd, "Please information XSD stream.");
        Validate.notNull(xml, "Please information XML stream.");

        DomErrorHandler errorHandler = new DomErrorHandler();

        Document document = documentFactory(xml);

        Validator validator = validateFactory(xsd);
        validator.setErrorHandler(errorHandler);

        try {
            validator.validate(new DOMSource(document));

            return errorHandler.getErros();
        } catch (IOException | SAXException e) {
            throw new DomException("Fail to validate XML file.", e);
        }
    }

    private static Document documentFactory(InputStream xml) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(false);
            documentBuilderFactory.setNamespaceAware(true);
            documentBuilderFactory.setIgnoringComments(true);

            DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();

            return db.parse(xml);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new DomException("Fail to read XML file.", e);
        } finally {
            closeQuietly(xml);
        }
    }

    private static Validator validateFactory(InputStream xsd) {

        try {
            Source source = new StreamSource(xsd);

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            Schema schema = null;
            schema = factory.newSchema(source);
            Validator validator = schema.newValidator();

            return validator;
        } catch (SAXException e) {
            throw new DomException("Fail to create validation XML by XSD.", e);
        }
    }
}
