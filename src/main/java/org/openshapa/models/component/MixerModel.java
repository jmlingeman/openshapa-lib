package org.openshapa.models.component;

public interface MixerModel extends MixerComponentModel {
	/**
	 * @return model object for the current viewport
	 */
	ViewportModel getViewportModel();
	
	/**
	 * @return model object for the play back region boundaries
	 */
	RegionModel getRegionModel();

	/**
	 * @return model object for the play back needle
	 */
	NeedleModel getNeedleModel();
}
