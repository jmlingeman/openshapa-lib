package org.openshapa.views.continuous;

import javax.swing.ImageIcon;
import javax.swing.filechooser.FileFilter;


/**
 * Plugin interface - specifies the methods an OpenSHAPA plugin must implement.
 */
public interface Plugin {

    /**
     * @return A new instance of the plugins data viewer.
     */
    DataViewer getNewDataViewer(java.awt.Frame parent, boolean modal);

    /**
     * @return The filter to use when looking for files that the plugins data
     *         viewer supports.
     */
    FileFilter getFileFilter();

    /**
     * @return The icon for representing this plugin. This can return {@code null} if
     *         this plugin has no icon representing its type.
     */
    ImageIcon getTypeIcon();

    /**
     * @return True if the first custom action is supported. False otherwise.
     */
    boolean isActionSupported1();

    /**
     * @return True if the second custom action is supported. False otherwise.
     */
    boolean isActionSupported2();

    /**
     * @return True if the third custom action is supported. False otherwise.
     */
    boolean isActionSupported3();
}
