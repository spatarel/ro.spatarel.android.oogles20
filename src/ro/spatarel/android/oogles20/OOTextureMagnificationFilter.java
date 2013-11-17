package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible texture magnification filters.</p>
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
public enum OOTextureMagnificationFilter {
    /**
     * <p>Returns the value of the texture element that is nearest (in Manhattan distance) to the center of the pixel
     * being textured.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_NEAREST} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    NEAREST(OpenGLES20.GL_NEAREST),
    
    /**
     * <p>Returns the weighted average of the four texture elements that are closest to the center of the pixel being
     * textured.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_LINEAR} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    LINEAR(OpenGLES20.GL_LINEAR);
    
    private final int glConstant;
    
    static OOTextureMagnificationFilter valueOf(int value) {
        for (OOTextureMagnificationFilter someValue : OOTextureMagnificationFilter.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    OOTextureMagnificationFilter(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
