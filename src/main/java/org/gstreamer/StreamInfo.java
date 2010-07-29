/*
 * Copyright (c) 2009 Andres Colubri
 * Copyright (c) 2008 Wayne Meissner
 *
 * This file is part of gstreamer-java.
 *
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License version 3 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * version 3 for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * version 3 along with this work.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.gstreamer;

import org.gstreamer.lowlevel.NativeObject;

import com.sun.jna.Pointer;

/**
 * Object containing specific meta information such as width/height/framerate of
 * video streams or samplerate/number of channels of audio. Each stream info object
 * has the following properties:
 * "object" (GstObject) (the decoder source pad usually)
 * "type" (enum) (if this is an audio/video/subtitle stream)
 * "decoder" (string) (name of decoder used to decode this stream)
 * "mute" (boolean) (to mute or unmute this stream)
 * "caps" (GstCaps) (caps of the decoded stream)
 * "language-code" (string) (ISO-639 language code for this stream, mostly used for audio/subtitle streams)
 * "codec" (string) (format this stream was encoded in)
 */
public class StreamInfo extends GObject {
    /**
     * For internal gstreamer-java use only
     *
     * @param init initialization data
     */
    public StreamInfo(Initializer init) {
        super(init);
        throw new IllegalArgumentException("Cannot instantiate this class");
    }

    public StreamInfo(Pointer ptr, boolean needRef, boolean ownsHandle) {
        super(initializer(ptr, needRef, ownsHandle));
        
        System.out.println("*** StreamInfo properties:");
        System.out.println("object=" + get("object") + ", " + get("object").getClass());
        System.out.println("object=>" + getObject());
        System.out.println("type=" + get("type") + ", " + get("type").getClass());
        System.out.println("decoder=" + get("decoder") + ", " + ((get("decoder") != null) ? get("decoder").getClass() : null));
        System.out.println("mute=" + get("mute") + ", " + ((get("mute") != null) ? get("mute").getClass() : null));
        System.out.println("language-code=" + get("language-code") + ", " + ((get("language-code") != null) ? get("language-code").getClass() : null));
        System.out.println("codec=" + get("codec") + ", " + ((get("codec") != null) ? get("codec").getClass() : null));
//        System.out.println("caps=" + get("caps") + ", " + ((get("caps") != null) ? get("caps").getClass() : null));
        System.out.println("***********");
    }

    /** Source Pad or object of the stream */
    public GstObject getObject() {
        Object object = get("object");
        assert object == null || object instanceof GstObject;
        return object instanceof GstObject ? (GstObject) object : null;
    }

    public String getDecoder() {
    	String str = (String) get("decoder");
    	return str != null ? str : "";
    }
    
    public boolean getMute() {
        return (Boolean) get("mute");
    }

    public Caps getCaps() {
        Pointer ptr = (Pointer) get("caps");
        return NativeObject.objectFor(ptr, Caps.class, true);
    }

    public String getLanguageCode() {
        String str = (String) get("language-code");
        return str != null ? str : "";
    }

    public String getCodec() {
    	String str = (String) get("codec");
        return str != null ? str : "";
    }
}
