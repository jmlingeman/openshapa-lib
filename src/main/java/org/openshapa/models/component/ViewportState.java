package org.openshapa.models.component;

/**
 * Defines constraints of the tracks view. The properties of this object are immutable like with {@link java.lang.String} objects.
 * <p>
 * For thread safety, any code that works with viewports should retrieve a reference to a <code>Viewport</code> object <b>once</b>
 * and make all subsequent calls for the current task through the <b>same</b> object, e.g.:
 * <p>
 * <code>
 *     final ViewportState viewport = controller.getViewport();
 *     final long viewStart = viewport.getViewStart();
 *     final long viewEnd = viewport.getViewEnd();
 *     final long timestamp = ...
 *     final boolean isTimeInViewport = viewStart <= timestamp && timestamp <= viewEnd; 
 * </code>
 * <p>
 * Viewports may change on another thread, therefore you should <b>NOT</b> write code in the following way:
 * <p>
 * <code>
 *     final long viewStart = controller.getViewport().getViewStart(); // THIS IS WRONG!!!
 *     final long viewEnd = controller.getViewport().getViewEnd();     // THIS IS WRONG!!!
 *     final long timestamp = ...
 *     final boolean isTimeInViewport = viewStart <= timestamp && timestamp <= viewEnd(); 
 * </code>
 */
public interface ViewportState {
    static final String NAME = ViewportState.class.getName();

    /**
     * @return Maximum valid timestamp in milliseconds. Inclusive.
     */
    long getMaxEnd();

    /**
     * @return View window start in milliseconds. Inclusive.
     */
    long getViewStart();

    /**
     * @return View window end in milliseconds. Inclusive. This may be greater
     * than {@link #getMaxEnd()}.
     */
    long getViewEnd();

    /**
     * @return Pixel width of the viewport.
     */
    double getViewWidth();

    /**
     * @return Viewport duration in milliseconds. Always >= 1.
     */
    long getViewDuration();

    /**
     * @return Milliseconds per pixel resolution. Returns {@link Double#NaN}
     * if {@link ViewportState#getViewWidth()} is zero.
     */
    double getResolution();

    /**
     * @return Zoom level in between 0 (zoomed all the way out) and 1
     *  (zoomed all the way in) inclusive.
     */
    double getZoomLevel();

    /**
     * Computes the pixel x-coordinate offset for a given time.
     *
     * @param time Time in milliseconds.
     * @return the pixel x-coordinate offset for a given time, where 0 corresponds to {@link #getViewStart()}
     */
    double computePixelXOffset(long time);

    boolean isTimeInViewport(long time);

    /**
     * Computes a time from the pixel x-coordinate offset. Not absolute time.
     *
     * @param offset
     * @return 0 based offset from {@link #getViewStart()}
     * @throw {@link IllegalArgumentException} if offset is not in the viewport
     */
    long computeTimeFromXOffset(double offset);

    boolean isOffsetInViewport(double offset);

    /**
     * @return whether the entire track (from time 0 until {@link #getMaxEnd()}) is visible in the current viewport
     */
    boolean isEntireTrackVisible();
}
