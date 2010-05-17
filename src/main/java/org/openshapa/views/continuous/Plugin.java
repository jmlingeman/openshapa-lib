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
    DataViewer getNewDataViewer();

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
     * @return The icon for representing the first action button. Return
     *          {@code null} if this action has no icon.
     */
    ImageIcon getActionButtonIcon1();

    /**
     * @return The icon for representing the second action button. Return
     *          {@code null} if this action has no icon.
     */
    ImageIcon getActionButtonIcon2();

    /**
     * @return The icon for representing the third action button. Return
     *          {@code null} if this action has no icon.
     */
    ImageIcon getActionButtonIcon3();

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
