package com.gitghub.thiagogarbazza.exemplos.validatexmlbyxsd;

import org.junit.Before;

import java.util.Locale;

import static com.gitghub.thiagogarbazza.exemplos.validatexmlbyxsd.DomErrorHandler.ERRO_KEY;
import static java.text.MessageFormat.format;
import static java.util.Arrays.asList;

public class DomValidatorErrosLocale_fr_FR_Test extends AbstractDomValidatorErrorsForLocale {

    @Override
    protected XMLTest xmlIsInvalid() {
        return new XMLTest("students-invalid.xml", asList(new XMLError(ERRO_KEY, "cvc-complex-type.2.4.a : Contenu non valide trouvé à partir de l'élément 'novocrd'. L'une des valeurs '{firstname}' est attendue.")));
    }

    @Before
    public void setUP() {
        Locale.setDefault(Locale.FRANCE);
        System.out.println(format("Default locale {0}.", Locale.getDefault()));
    }
}
