package com.gitghub.thiagogarbazza.exemplos.validatexmlbyxsd.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class IOUtils {

    public static void closeQuietly(InputStream input) {
        closeQuietly((Closeable) input);
    }

    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ioe) {
            // ignore
        }
    }
}
