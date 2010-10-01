package org.openshapa.plugins;

/**
 * Enumeration of predefined names for {@link Filter}.
 */
public enum FilterNames {

    VIDEO("Video files"), AUDIO("Audio files");

    private String name;

    FilterNames(final String name) {
        this.name = name;
    }

    public String getFilterName() {
        return name;
    }

}
