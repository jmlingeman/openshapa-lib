package org.openshapa.views.continuous;

import java.awt.event.ActionEvent;


/**
 * Custom action button listener interface.
 */
public interface CustomActionListener {

    /**
     * Notify listener of action events on the first custom action button.
     * @param event The event to handle.
     */
    void handleActionButtonEvent1(ActionEvent event);

    /**
     * Notify listener of action events on the second custom action button.
     * @param event The event to handle.
     */

    void handleActionButtonEvent2(ActionEvent event);

    /**
     * Notify listener of action events on the third custom action button.
     * @param event The event to handle.
     */
    void handleActionButtonEvent3(ActionEvent event);

}
