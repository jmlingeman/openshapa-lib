package org.openshapa.models.component;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.openshapa.models.id.Identifier;


/**
 * This model provides data feed information used to render a carriage on the
 * tracks interface.
 */
public final class TrackModel {

    /** Enumeration for defining track state. */
    public static enum TrackState {

        /** Track is in the normal state. */
        NORMAL,

        /** Track is in the selected state. */
        SELECTED,

        /** Track is in the snapped state. */
        SNAPPED
    }

    /** Track identifier. */
    private Identifier id;

    /** The duration of the track in milliseconds */
    private long duration;

    /** The offset of the track in milliseconds */
    private long offset;

    /** Track bookmark location in milliseconds */
    private long bookmark;

    /** Is there an error with track information */
    private boolean erroneous;

    /** Absolute media path for this track. */
    private String mediaPath;

    /** Name of this track */
    private String trackName;

    /** State of the track */
    private TrackState state;

    /** Is the track's movement locked */
    private boolean locked;

    /** Used to enable support for property change events. */
    private PropertyChangeSupport change;

    /**
     * Creates a new track model.
     */
    public TrackModel() {
        change = new PropertyChangeSupport(this);
    }

    /**
     * Copy constructor.
     *
     * @param other Model to copy from.
     */
    protected TrackModel(final TrackModel other) {
        change = new PropertyChangeSupport(this);
        duration = other.duration;
        offset = other.offset;
        bookmark = other.bookmark;
        erroneous = other.erroneous;
        mediaPath = other.mediaPath;
        trackName = other.trackName;
        state = other.state;
        locked = other.locked;
        id = other.id;
    }

    /**
     * @see PropertyChangeSupport#addPropertyChangeListener(PropertyChangeListener)
     */
    public void addPropertyChangeListener(
        final PropertyChangeListener listener) {
        change.addPropertyChangeListener(listener);
    }

    /**
     * @see PropertyChangeSupport#addPropertyChangeListener(String, PropertyChangeListener)
     */
    public void addPropertyChangeListener(final String property,
        final PropertyChangeListener listener) {
        change.addPropertyChangeListener(property, listener);
    }

    /**
     * @see PropertyChangeSupport#removePropertyChangeListener(PropertyChangeListener)
     */
    public void removePropertyChangeListener(
        final PropertyChangeListener listener) {
        change.removePropertyChangeListener(listener);
    }

    /**
     * @see PropertyChangeSupport#removePropertyChangeListener(String, PropertyChangeListener)
     */
    public void removePropertyChangeListener(final String property,
        final PropertyChangeListener listener) {
        change.removePropertyChangeListener(property, listener);
    }

    /**
     * @return is the track locked.
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * @param locked lock state to set.
     */
    public void setLocked(final boolean locked) {
        boolean old = this.locked;
        this.locked = locked;
        change.firePropertyChange("locked", old, locked);
    }

    /**
     * @return The duration of the track in milliseconds
     */
    public long getDuration() {
        return duration;
    }

    /**
     * Set the duration of the track in milliseconds
     *
     * @param duration the new duration.
     */
    public void setDuration(final long duration) {
        long old = this.duration;
        this.duration = duration;
        change.firePropertyChange("duration", old, duration);
    }

    /**
     * @return The offset of the track in milliseconds
     */
    public long getOffset() {
        return offset;
    }

    /**
     * Set the offset of the track in milliseconds
     *
     * @param offset the new offset.
     */
    public void setOffset(final long offset) {
        long old = this.offset;
        this.offset = offset;
        change.firePropertyChange("offset", old, offset);
    }

    /**
     * @return absolute media path.
     */
    public String getMediaPath() {
        return mediaPath;
    }

    /**
     * Sets the absolute media path that this track represents.
     *
     * @param path absolute media path.
     */
    public void setMediaPath(final String path) {
        String old = this.mediaPath;
        mediaPath = path;
        change.firePropertyChange("mediaPath", old, path);
    }

    /**
     * @return Is there an error with track information
     */
    public boolean isErroneous() {
        return erroneous;
    }

    /**
     * Set track information error state.
     *
     * @param erroneous true if erroneous, false otherwise.
     */
    public void setErroneous(final boolean erroneous) {
        boolean old = this.erroneous;
        this.erroneous = erroneous;
        change.firePropertyChange("erroneous", old, erroneous);
    }

    /**
     * @return bookmark position in milliseconds.
     */
    public long getBookmark() {
        return bookmark;
    }

    /**
     * Set a snap bookmark position.
     *
     * @param bookmark new bookmark position in milliseconds
     */
    public void setBookmark(final long bookmark) {
        long old = this.bookmark;
        this.bookmark = bookmark;
        change.firePropertyChange("bookmark", old, bookmark);
    }

    /**
     * @return the trackName
     */
    public String getTrackName() {
        return trackName;
    }

    /**
     * Set the track name.
     *
     * @param trackName the new track name
     */
    public void setTrackName(final String trackName) {
        String old = this.trackName;
        this.trackName = trackName;
        change.firePropertyChange("trackName", old, trackName);
    }

    /**
     * @return selected state
     */
    public boolean isSelected() {
        return state == TrackState.SELECTED;
    }

    /**
     * Set the selected state.
     *
     * @param selected true if selected, false otherwise.
     */
    public void setSelected(final boolean selected) {
        boolean old = isSelected();

        if (selected) {
            state = TrackState.SELECTED;
        } else {
            state = TrackState.NORMAL;
        }

        change.firePropertyChange("selected", old, selected);
    }

    /**
     * Set the state of the track.
     *
     * @param state new state to use.
     */
    public void setState(final TrackState state) {
        TrackState old = this.state;
        this.state = state;
        change.firePropertyChange("state", old, state);
    }

    /**
     * @return Current track state.
     */
    public TrackState getState() {
        return state;
    }

    /**
     * @param id Identifier to use.
     */
    public void setId(final Identifier id) {
        this.id = id;
    }

    /**
     * @return ID of the track.
     */
    public Identifier getId() {
        return id;
    }

    /**
     * @return A copy of the track model but with a new ID.
     */
    public TrackModel copy() {
        return new TrackModel(this);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + (int) (bookmark ^ (bookmark >>> 32));
        result = (prime * result) + (int) (duration ^ (duration >>> 32));
        result = (prime * result) + (erroneous ? 1231 : 1237);
        result = (prime * result) + (locked ? 1231 : 1237);
        result = (prime * result) + (int) (offset ^ (offset >>> 32));
        result = (prime * result) + ((state == null) ? 0 : state.hashCode());
        result = (prime * result)
            + ((mediaPath == null) ? 0 : mediaPath.hashCode());
        result = (prime * result)
            + ((trackName == null) ? 0 : trackName.hashCode());

        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        TrackModel other = (TrackModel) obj;

        if (bookmark != other.bookmark) {
            return false;
        }

        if (duration != other.duration) {
            return false;
        }

        if (erroneous != other.erroneous) {
            return false;
        }

        if (locked != other.locked) {
            return false;
        }

        if (offset != other.offset) {
            return false;
        }

        if (state == null) {

            if (other.state != null) {
                return false;
            }
        } else if (!state.equals(other.state)) {
            return false;
        }

        if (mediaPath == null) {

            if (other.mediaPath != null) {
                return false;
            }
        } else if (!mediaPath.equals(other.mediaPath)) {
            return false;
        }

        if (trackName == null) {

            if (other.trackName != null) {
                return false;
            }
        } else if (!trackName.equals(other.trackName)) {
            return false;
        }

        return true;
    }

    @Override public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TrackModel [bookmark=");
        builder.append(bookmark);
        builder.append(", duration=");
        builder.append(duration);
        builder.append(", erroneous=");
        builder.append(erroneous);
        builder.append(", locked=");
        builder.append(locked);
        builder.append(", offset=");
        builder.append(offset);
        builder.append(", state=");
        builder.append(state);
        builder.append(", trackId=");
        builder.append(mediaPath);
        builder.append(", trackName=");
        builder.append(trackName);
        builder.append("]");

        return builder.toString();
    }
}
