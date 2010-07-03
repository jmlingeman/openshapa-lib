package org.openshapa.views.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JComponent;

import org.openshapa.models.component.TrackModel;
import org.openshapa.models.component.ViewableModel;


/**
 * This class is used to paint a track and its information.
 */
public abstract class TrackPainter extends JComponent {

    /** Fill colour of a carriage in the unselected/normal state */
    protected static final Color DEFAULT_NORMAL_CARRIAGE_COLOR = new Color(169,
            218, 248);

    /** Outline colour of a carriage in the unselected/normal state */
    protected static final Color DEFAULT_NORMAL_OUTLINE_COLOR = new Color(129,
            167, 188);

    /** Fill colour of a carriage in the selected state */
    protected static final Color DEFAULT_SELECTED_CARRIAGE_COLOR = new Color(
            138, 223, 162);

    /** Outline colour of a carriage in the selected state */
    protected static final Color DEFAULT_SELECTED_OUTLINE_COLOR = new Color(105,
            186, 128);

    /** Color schemes. */
    /** Normal carriage color. */
    protected Color normalCarriageColor;

    /** Normal carriage outline color. */
    protected Color normalOutlineColor;

    /** Selected carriage color. */
    protected Color selectedCarriageColor;

    /** Selected carriage outline color. */
    protected Color selectedOutlineColor;

    /** Painted region of the carriage */
    protected Polygon carriagePolygon;

    /** Model containing information specific to the track painter. */
    protected TrackModel trackModel;

    /** Model containing information about visibility parameters. */
    protected ViewableModel viewableModel;

    /**
     * Creates a new TrackPainter.
     */
    public TrackPainter() {
        super();

        normalCarriageColor = DEFAULT_NORMAL_CARRIAGE_COLOR;
        normalOutlineColor = DEFAULT_NORMAL_OUTLINE_COLOR;
        selectedCarriageColor = DEFAULT_SELECTED_CARRIAGE_COLOR;
        selectedOutlineColor = DEFAULT_SELECTED_OUTLINE_COLOR;
    }

    /**
     * Set the track model.
     *
     * @param model The new track model to use.
     */
    public final void setTrackModel(final TrackModel model) {
        trackModel = model;
        repaint();
    }

    /**
     * Set the viewable model.
     *
     * @param newModel The new viewable model to use.
     */
    public final void setViewableModel(final ViewableModel newModel) {
        viewableModel = newModel;
        repaint();
    }

    /**
     * @return The polygon representing the carriage.
     */
    public final Polygon getCarriagePolygon() {
        return carriagePolygon;
    }

    @Override public final boolean isOpaque() {
        return true;
    }

    /**
     * Computes the pixel x-coordinate for a given time.
     *
     * @param time Time in milliseconds.
     */
    protected final int computePixelXCoord(final long time) {
        final double ratio = viewableModel.getIntervalWidth()
            / viewableModel.getIntervalTime();

        return (int) Math.ceil ((time * ratio)
                - (viewableModel.getZoomWindowStart() * ratio));
    }

    @Override protected final void paintComponent(final Graphics g) {
        Graphics g2 = g.create();

        Dimension size = getSize();

        // Paints the background
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0, 0, size.width, size.height);

        // If there is an error with track information, don't paint the carriage
        if (trackModel.isErroneous()) {
            g2.setColor(Color.red);

            FontMetrics fm = g2.getFontMetrics();
            String errorMessage =
                "Track timing information could not be calculated.";
            int width = fm.stringWidth(errorMessage);
            g2.drawString(errorMessage, (size.width / 2) - (width / 2),
                (size.height / 2) - (fm.getAscent() / 2));

            return;
        }

        final int carriageHeight = (int) (size.getHeight() * 7D / 10D);
        final int carriageYOffset = (int) (size.getHeight() * 2D / 10D);

        // Calculate carriage start and end pixel positions
        final int startXPos = computePixelXCoord(trackModel.getOffset());

        final int endXPos = computePixelXCoord(trackModel.getDuration()
                + trackModel.getOffset());

        // The carriage
        carriagePolygon = new Polygon();

        // Top left corner
        carriagePolygon.addPoint(startXPos, carriageYOffset);

        // Top right corner
        carriagePolygon.addPoint(endXPos, carriageYOffset);

        // Bottom right corner
        carriagePolygon.addPoint(endXPos, carriageYOffset + carriageHeight);

        // Bottom left corner
        carriagePolygon.addPoint(startXPos, carriageYOffset + carriageHeight);

        // Paint the carriage
        if (trackModel.isSelected()) {
            g2.setColor(selectedCarriageColor);
        } else {
            g2.setColor(normalCarriageColor);
        }

        g2.fillPolygon(carriagePolygon);

        // Paint the carriage outlines
        if (trackModel.isSelected()) {
            g2.setColor(selectedOutlineColor);
        } else {
            g2.setColor(normalOutlineColor);
        }

        g2.drawPolygon(carriagePolygon);

        // Paint custom information, if any.
        {
            Graphics g3 = g.create();
            paintCustom(g3);
            g3.dispose();
        }

        if (trackModel.getBookmark() < 0) {
            return;
        }

        // Paint the bookmark marker
        final int bookmarkXPos = computePixelXCoord(trackModel.getOffset()
                + trackModel.getBookmark());

        g2.drawLine(bookmarkXPos, carriageYOffset, bookmarkXPos,
            carriageYOffset + carriageHeight);

        // Paint the bookmark diamond

        Polygon bookmarkDiamond = new Polygon();

        // Top of diamond
        bookmarkDiamond.addPoint(bookmarkXPos, carriageYOffset - 10);

        // Right tip of diamond
        bookmarkDiamond.addPoint(bookmarkXPos + 5, carriageYOffset - 5);

        // Bottom of diamond
        bookmarkDiamond.addPoint(bookmarkXPos, carriageYOffset);

        // Left tip of diamond
        bookmarkDiamond.addPoint(bookmarkXPos - 5, carriageYOffset - 5);

        if (trackModel.isSelected()) {
            g2.setColor(selectedCarriageColor);
            g2.fillPolygon(bookmarkDiamond);
            g2.setColor(selectedOutlineColor);
            g2.drawPolygon(bookmarkDiamond);
        } else {
            g2.setColor(normalCarriageColor);
            g2.fillPolygon(bookmarkDiamond);
            g2.setColor(normalOutlineColor);
            g2.drawPolygon(bookmarkDiamond);
        }

        g2.dispose();

    }

    /**
     * Additional painting over the track painter.
     *
     * @param g Graphics object.
     */
    protected abstract void paintCustom(final Graphics g);

}
