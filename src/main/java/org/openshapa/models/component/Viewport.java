package org.openshapa.models.component;

/**
 * Defines constraints of the tracks view.
 */
public interface Viewport {

    static final String NAME = "viewport";

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
     * if {@link Viewport#getViewWidth()} is zero.
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
     * @return the pixel x-coordinate offset for a given time.
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

}
