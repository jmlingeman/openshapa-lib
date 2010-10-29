package org.openshapa.models.component;

/**
 * Represents a contiguous subset of the OpenSHAPA time line that play back and navigation of data tracks will be restricted to.
 * <code>Region</code> objects represent a snapshot of the region state and are immutable like {@link java.lang.String}s.
 * <p>
 * For thread safety, any code that works with regions should retrieve a reference to a <code>Region</code> object <b>once</b>
 * and make all subsequent calls for the current task through the <b>same</b> object, e.g.:
 * <p>
 * <code>
 *     final Region region = regionController.getRegion();
 *     final long duration = region.getRegionEnd() - region.getRegionStart() + 1;
 *     assert duration == region.getRegionDuration();
 * </code>
 * <p>
 * @see Viewport
 */
public interface RegionState {
    static final String NAME = RegionState.class.getName();
    
	/**
	 * Returns the start time of the play back region (inclusive).
	 * 
	 * @return time in milliseconds
	 */
    long getRegionStart();

    /**
     * Returns the end time of the play back region (inclusive).
     * 
     * @return time in milliseconds
     */
	long getRegionEnd();
	
	/**
	 * Returns the duration of the play back region.
	 * @return duration of the playback region, i.e. <code>getRegionEnd() - getRegionStart() + 1</code>
	 */
	long getRegionDuration();
}
