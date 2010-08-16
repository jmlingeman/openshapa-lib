/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openshapa.models.db;

/**
 * Holds a value as a string, and offset / onset as millisecond timestamps.
 * Relates to a DataCell.
 */
public final class SimpleCell {

    String value;

    long offset;

    long onset;

    public SimpleCell(final String newVal, final long newOnset,
            final long newOffset) {
        value = newVal;
        onset = newOnset;
        offset = newOffset;
    }

    public long getOffset() {
        return offset;
    }

    public long getOnset() {
        return onset;
    }

    public String getValue() {
        return value;
    }


}
