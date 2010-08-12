package org.openshapa.views.continuous;

import javax.swing.AbstractButton;


/**
 * Convenience class with default implementation of unsupported custom actions.
 */
public class CustomActionsAdapter implements CustomActions {

    @Override public AbstractButton getActionButton1() {
        return null;
    }

    @Override public AbstractButton getActionButton2() {
        return null;
    }

    @Override public AbstractButton getActionButton3() {
        return null;
    }

}
