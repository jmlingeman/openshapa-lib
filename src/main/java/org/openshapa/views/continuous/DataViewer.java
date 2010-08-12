package org.openshapa.views.continuous;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JDialog;

import org.openshapa.models.id.Identifier;

import org.openshapa.views.component.DefaultTrackPainter;
import org.openshapa.views.component.TrackPainter;


/**
 * DataViewer interface.
 */
public interface DataViewer {

    /**
     * Sets the identifier used to identify this data viewer.
     *
     * @param id Identifier to use.
     */
    void setIdentifier(Identifier id);

    /**
     * @return Identifier used to identify this data viewer.
     */
    Identifier getIdentifier();

    /**
     * Retrieve the duration of the underlying data stream.
     *
     * @return The duration in milliseconds.
     */
    long getDuration();

    /**
     * Retrieve the start time offset of the underlying data stream.
     *
     * @return Start time offset in milliseconds.
     */
    long getOffset();

    /**
     * Set the start time offset of the underlying data stream.
     *
     * @param offset Start time offset in milliseconds.
     */
    void setOffset(final long offset);

    /**
     * Get the display window.
     *
     * @return A JDialog that will be displayed.
     */
    JDialog getParentJDialog();

    /**
     * Sets the data feed for this viewer.
     *
     * @param dataFeed The new data feed for this viewer.
     */
    void setDataFeed(final File dataFeed);

    /**
     * @return The data feed being used by this viewer.
     */
    File getDataFeed();

    /**
     * Sets the parent data controller for this data viewer.
     *
     * @param dataController The parent controller.
     */
    void setParentController(final DataController dataController);

    /**
     * @return Frames per second.
     */
    float getFrameRate();

    /**
     * @return The current position within the data feed in milliseconds.
     * @throws Exception If an error occurs.
     */
    long getCurrentTime() throws Exception;

    /**
     * Plays the continous data stream at a regular 1x normal speed.
     */
    void play();

    /**
     * Stops the playback of the continous data stream.
     */
    void stop();

    /**
     * Is this data viewer currently playing.
     */
    boolean isPlaying();

    /**
     * Set the playback speed.
     *
     * @param rate Positive implies forwards, while negative implies reverse.
     */
    void setPlaybackSpeed(float rate);

    /**
     * Set the playback position to an absolute value.
     *
     * @param position The absolute millisecond playback position.
     */
    void seekTo(long position);

    /**
     * @return Custom track painter implementation. Must not return null.
     * Plugins that do not have a custom track painter implementation should
     * return {@link DefaultTrackPainter}.
     */
    TrackPainter getTrackPainter();

    /**
     * Read settings from the given input stream.
     *
     * @param is Input stream to load from.
     */
    void loadSettings(InputStream is);

    /**
     * Write settings to the given output stream.
     *
     * @param os Output stream to write to.
     */
    void storeSettings(OutputStream os);

    /**
     * Adds the given ViewerStateListener to the collection of listeners who
     * are interested in changes made to the project.
     * @param vsl The ViewerStateListener to add.
     */
    void addViewerStateListener(ViewerStateListener vsl);

    /**
     * Removes the given ViewerStateListener from the collection of listeners.
     * @param vsl The listener to remove.
     */
    void removeViewerStateListener(ViewerStateListener vsl);

    /**
     * Used to query the data viewer for custom actions.
     *
     * @return custom actions handler.
     * @see CustomActionsAdapter
     */
    CustomActions getCustomActions();

}
