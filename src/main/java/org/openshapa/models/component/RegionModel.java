package org.openshapa.models.component;

public interface RegionModel extends MixerComponentModel {
	/**
	 * Returns the current play back region.
	 * 
	 * @return current play back region
	 */
	RegionState getRegion();
	
	/**
	 * Resets the play back region to the entire data track.
	 */
	void resetPlaybackRegion();
	
	/**
	 * Sets the play back region.
	 * 
	 * @param regionStart start time of the region in milliseconds, inclusive. Must be <= regionEnd.
	 * @param regionEnd end time of the region in milliseconds, inclusive. Must be >= regionStart.
	 */
    void setPlaybackRegion(final long regionStart, final long regionEnd);

    /**
     * Moves the start marker for the play back region, while keeping the end marker in the same position.
     * 
     * @param regionStart new start time of the region in milliseconds, inclusive. Must be <= {@link RegionState#getRegionEnd()}.
     */
    void setPlaybackRegionStart(final long regionStart);

    /**
     * Moves the end marker for the play back region, while keeping the start marker in the same position.
     * 
     * @param regionEnd new end time of the region in milliseconds, inclusive. Must be >= {@link RegionState#getRegionStart()}.
     */
    void setPlaybackRegionEnd(final long regionEnd);
}
