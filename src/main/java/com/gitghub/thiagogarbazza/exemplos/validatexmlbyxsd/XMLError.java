package com.gitghub.thiagogarbazza.exemplos.validatexmlbyxsd;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class XMLError {

    private final String key;

    private final String message;

    public XMLError(String key, String message) {
        this.key = key;
        this.message = message;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("key", key)
                .append("message", message)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        XMLError that = (XMLError) o;

        return new EqualsBuilder()
                .append(this.key, that.key)
                .append(this.message, that.message)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(key)
                .append(message)
                .toHashCode();
    }
}
