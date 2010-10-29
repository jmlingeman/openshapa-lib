package org.openshapa.models.component;

public interface NeedleModel extends MixerComponentModel {
	public static String NAME = NeedleModel.class.getName();
	
    /**
     * Returns the current temporal position of the needle.
     * 
     * @return needle position in milliseconds
     */
	long getCurrentTime();

	/**
	 * Sets the current temporal position of the needle.
	 * 
	 * @param currentTime
	 */
    void setCurrentTime(final long currentTime);
}
