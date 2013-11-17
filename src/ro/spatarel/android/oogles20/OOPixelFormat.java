package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible pixel formats.</p>
 * 
 * <h5>Copyright</h5>
 * 
 * <p><i>OOGLES20 - an Object Oriented wrapper for the Open Graphics Library for Embedded Systems 2.0</i><br/>
 * Copyright &copy; 2013 Dan-Constantin Sp&#x103;t&#x103;rel</p>
 * 
 * <p>This program is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, version 3.</p>
 * 
 * <p>This program is distributed in the hope that it will be useful, but <b>without any warranty</b>; without even the
 * implied warranty of <b>merchantability</b> or <b>fitness for a particular purpose</b>. See the GNU Lesser General
 * Public License for more details.</p>
 * 
 * <p>You should have received a copy of the GNU Lesser General Public License along with this program. If not, see
 * <a href="http://www.gnu.org/licenses/lgpl-3.0.html">http://www.gnu.org/licenses/</a>.</p>
 * 
 * @author Dan-Constantin Sp&#x103;t&#x103;rel
 */
public enum OOPixelFormat {
    /**
     * <p>The pixels contain only the alpha component.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_ALPHA} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    ALPHA(OpenGLES20.GL_ALPHA),
    
    /**
     * <p>The pixels contain the red, green and blue components.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_RGB} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    RGB(OpenGLES20.GL_RGB),
    
    /**
     * <p>The pixels contain the red, green, blue and alpha components.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_RGBA} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    RGBA(OpenGLES20.GL_RGBA);
    
    private final int glConstant;
    
    static OOPixelFormat valueOf(int value) {
        for (OOPixelFormat someValue : OOPixelFormat.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    OOPixelFormat(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
