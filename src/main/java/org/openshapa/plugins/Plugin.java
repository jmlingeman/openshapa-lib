package org.openshapa.plugins;

import javax.swing.ImageIcon;


/**
 * Plugin interface - specifies the methods an OpenSHAPA plugin must implement.
 */
public interface Plugin {

    /**
     * @return A new instance of the plugins data viewer.
     */
    DataViewer getNewDataViewer(java.awt.Frame parent, boolean modal);

    /**
     * @return The data viewer class.
     */
    Class<? extends DataViewer> getViewerClass();

    /**
     * @return The icon for representing this plugin. This can return null if
     *         this plugin has no icon representing its type.
     */
    ImageIcon getTypeIcon();

    /**
     * @return Plugin name.
     */
    String getPluginName();

    /**
     *<p>A classifier string is a string representing the class of your plugin
     * as part of some namespace. An example of such a string could be
     * "companyfoo.video", which a person could interpret as "a plugin by
     * company foo which handles video". OpenSHAPA will not attempt to
     * interpret the string.</p>
     *<p>This classifier is used to group plugins with the same or similar
     * capabilities together. This grouping is used to select a backup or
     * alternative plugin (with the same classifier and file type handling) in
     * the case where the plugin used to visualize some data is not installed.
     *</p>
     *<p>The classifier string cannot be null or the empty string.</p>
     * @return Classifier string.
     */
    String getClassifier();

    /**
     * @return The various _groups_ of files that this plugin supports. As an
     * example, a plugin might be able to open both video and audio files.
     * The plugin should then return two filters: one for video files, another
     * for audio files.
     */
    Filter[] getFilters();
}
