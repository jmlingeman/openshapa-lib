package org.openshapa.models.component;

public interface ViewportModel extends MixerComponentModel {
    /**
     * @return A snapshot of the viewport's current state.
     */
    ViewportState getViewport();

    /**
     * @param maxEnd
     * @param resetViewportWindow 
     */
    void setViewportMaxEnd(long maxEnd, boolean resetViewportWindow);

    /**
     *
     * @param start
     * @param end
     */
    void setViewportWindow(long start, long end);

    /**
     * Resizes the viewport by adding or removing pixels while maintaining the
     * viewport's existing resolution.
     *
     * @param start Time in milliseconds.
     * @param width
     */
    void resizeViewport(long start, double width);

    /**
     *
     * @param start
     * @param end
     * @param maxEnd
     * @param width
     */
    void setViewport(long start, long end, long maxEnd, double width);

    /**
     *
     * @param zoomLevel Between 0 and 1.0 inclusive.
     * @param centerTime Time to center around, or -1 if centering is not
     * required.
     */
    void setViewportZoom(double zoomLevel, long centerTime);
    
    void resetViewport();
}
