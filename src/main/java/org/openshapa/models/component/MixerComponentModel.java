package org.openshapa.models.component;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public interface MixerComponentModel {
	MixerModel getMixerModel();
    
    /**
     * @see PropertyChangeSupport#addPropertyChangeListener(PropertyChangeListener)
     */
    void addPropertyChangeListener(final PropertyChangeListener listener);

    /**
     * @see PropertyChangeSupport#removePropertyChangeListener(PropertyChangeListener)
     */
    void removePropertyChangeListener(final PropertyChangeListener listener);
}
