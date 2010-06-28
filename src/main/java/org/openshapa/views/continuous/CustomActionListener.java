package org.openshapa.views.continuous;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


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

    /**
     * @return The icon for representing the first action button. Return
     *          {@code null} if this action has no icon.
     */
    ImageIcon getActionButtonIcon1();

    /**
     * @return The icon for representing the second action button. Return
     *          {@code null} if this action has no icon.
     */
    ImageIcon getActionButtonIcon2();

    /**
     * @return The icon for representing the third action button. Return
     *          {@code null} if this action has no icon.
     */
    ImageIcon getActionButtonIcon3();

}
