package org.gstreamer.swing;

import java.awt.Dimension;

import com.apple.eawt.CocoaComponent;
import com.sun.jna.Pointer;

public class OSXVideoComponent extends CocoaComponent {
	public OSXVideoComponent(final Pointer nsview) {
		assert nsview != null;
		this.nsview = nsview;
	}

	private final Pointer nsview;
	private Dimension preferredSize = new Dimension(2, 2);
	
	@Override
	public int createNSView() {
		return (int) createNSViewLong();
	}

	@Override
	public long createNSViewLong() {
		return Pointer.nativeValue(nsview);
	}

	@Override
	public Dimension getMaximumSize() {
		return new Dimension(Short.MAX_VALUE, Short.MAX_VALUE);
	}

	@Override
	public Dimension getMinimumSize() {
		return new Dimension(2, 2); // minimum size recommended by Apple
	}

	@Override
	public Dimension getPreferredSize() {
		return preferredSize;
	}
	
	@Override
	public void setPreferredSize(Dimension preferredSize) {
		this.preferredSize = preferredSize;
	}
}
