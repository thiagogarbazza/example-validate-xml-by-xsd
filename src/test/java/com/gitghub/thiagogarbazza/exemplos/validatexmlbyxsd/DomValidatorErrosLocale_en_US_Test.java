package com.gitghub.thiagogarbazza.exemplos.validatexmlbyxsd;

import org.junit.Before;

import java.util.Locale;

import static com.gitghub.thiagogarbazza.exemplos.validatexmlbyxsd.DomErrorHandler.ERRO_KEY;
import static java.text.MessageFormat.format;
import static java.util.Arrays.asList;

public class DomValidatorErrosLocale_en_US_Test extends AbstractDomValidatorErrorsForLocale {

    @Override
    protected XMLTest xmlIsInvalid() {
        return new XMLTest("students-invalid.xml", asList(new XMLError(ERRO_KEY, "cvc-complex-type.2.4.a: Invalid content was found starting with element 'novocrd'. One of '{firstname}' is expected.")));
    }

    @Before
    public void setUP() {
        Locale.setDefault(Locale.US);
        System.out.println(format("Default locale {0}.", Locale.getDefault()));
    }
}
