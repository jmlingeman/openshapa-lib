package org.openshapa.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Properties;

import org.openshapa.plugins.DataViewer;


/**
 * Utility methods for {@link DataViewer}s.
 */
public final class DataViewerUtils {

    /**
     * Store the DataViewer's default settings that need to be serialized in the
     * given OutputStream.
     *
     * @param dv
     * @param os
     * @throws IOException
     */
    public static void storeDefaults(final DataViewer dv, final OutputStream os)
        throws IOException {

        if ((dv == null) || (os == null)) {
            throw new NullPointerException();
        }

        Properties props = new Properties();
        props.setProperty("offset", Long.toString(dv.getOffset()));
        props.store(os, null);
    }

    /**
     * Load and restore the DataViewer's default serialized settings from the
     * given InputStream. Assumes that the offset was stored using the
     * {@link #storeDefaults(DataViewer, OutputStream)} method. This method's
     * behaviour is undefined otherwise.
     *
     * @param dv
     * @param is
     * @throws IOException
     */
    public static void loadDefaults(final DataViewer dv, final InputStream is)
        throws IOException {

        if ((dv == null) || (is == null)) {
            throw new NullPointerException();
        }

        Properties props = new Properties();
        props.load(is);

        String property = props.getProperty("offset");

        if ((property != null) && !"".equals(property)) {
            dv.setOffset(Long.parseLong(property));
        }
    }

}
