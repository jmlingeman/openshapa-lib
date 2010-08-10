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
     * @return The icon for representing this plugin. This can return null if
     *         this plugin has no icon representing its type.
     */
    ImageIcon getTypeIcon();

    /**
     *<p>
     * A classifier string is a string representing the class of your plugin as
     * part of some namespace. An example of such a string could be
     * "companyfoo.video", which a person could interpret as "a plugin by
     * company foo which handles video". OpenSHAPA will not attempt to
     * interpret the string.
     *</p>
     *<p>
     * This classifier is used to group plugins with the same or similar
     * capabilities together. This grouping is used to select a backup or
     * alternative plugin (with the same classifier and file type handling) in
     * the case where the plugin used to visualize some data is not installed.
     *</p>
     *<p>
     * The classifier string cannot be null or the empty string.
     *</p>
     * @return Classifier string.
     */
    String getClassifier();

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
