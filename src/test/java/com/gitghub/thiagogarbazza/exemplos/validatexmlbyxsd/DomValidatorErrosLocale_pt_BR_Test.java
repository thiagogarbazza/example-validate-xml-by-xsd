package com.gitghub.thiagogarbazza.exemplos.validatexmlbyxsd;

import org.junit.Before;

import java.util.Locale;

import static com.gitghub.thiagogarbazza.exemplos.validatexmlbyxsd.DomErrorHandler.ERRO_KEY;
import static java.text.MessageFormat.format;
import static java.util.Arrays.asList;

public class DomValidatorErrosLocale_pt_BR_Test extends AbstractDomValidatorErrorsForLocale {

    @Override
    protected XMLTest xmlIsInvalid() {
        return new XMLTest("students-invalid.xml", asList(new XMLError(ERRO_KEY, "cvc-complex-type.2.4.a: Foi detectado um conteúdo inválido começando com o elemento 'novocrd'. Era esperado um dos '{firstname}'.")));
    }

    @Before
    public void setUP() {
        Locale.setDefault(new Locale("pt", "BR"));
        System.out.println(format("Default locale {0}.", Locale.getDefault()));
    }
}
