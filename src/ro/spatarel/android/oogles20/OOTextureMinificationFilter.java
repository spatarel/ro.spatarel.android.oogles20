package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible texture minification filters.</p>
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
public enum OOTextureMinificationFilter {
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
    LINEAR(OpenGLES20.GL_LINEAR),
    
    /**
     * <p>Chooses the mipmap that most closely matches the size of the pixel being textured and uses the {@link
     * OOTextureMinificationFilter#NEAREST} criterion (the texture element nearest to the center of the pixel) to
     * produce a texture value.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_NEAREST_MIPMAP_NEAREST} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    NEAREST_MIPMAP_NEAREST(OpenGLES20.GL_NEAREST_MIPMAP_NEAREST),
    
    /**
     * <p>Chooses the mipmap that most closely matches the size of the pixel being textured and uses the {@link
     * OOTextureMinificationFilter#LINEAR} criterion (a weighted average of the four texture elements that are closest
     * to the center of the pixel) to produce a texture value.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_LINEAR_MIPMAP_NEAREST} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    LINEAR_MIPMAP_NEAREST(OpenGLES20.GL_LINEAR_MIPMAP_NEAREST),
    
    /**
     * <p>Chooses the two mipmaps that most closely match the size of the pixel being textured and uses the {@link
     * OOTextureMinificationFilter#NEAREST} criterion (the texture element nearest to the center of the pixel) to
     * produce a texture value from each mipmap. The final texture value is a weighted average of those two values.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_NEAREST_MIPMAP_LINEAR} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    NEAREST_MIPMAP_LINEAR(OpenGLES20.GL_NEAREST_MIPMAP_LINEAR),
    
    /**
     * <p>Chooses the two mipmaps that most closely match the size of the pixel being textured and uses the {@link
     * OOTextureMinificationFilter#LINEAR} criterion (a weighted average of the four texture elements that are closest
     * to the center of the pixel) to produce a texture value from each mipmap. The final texture value is a weighted
     * average of those two values.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_LINEAR_MIPMAP_LINEAR} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    LINEAR_MIPMAP_LINEAR(OpenGLES20.GL_LINEAR_MIPMAP_LINEAR);
    
    private final int glConstant;
    
    static OOTextureMinificationFilter valueOf(int value) {
        for (OOTextureMinificationFilter someValue : OOTextureMinificationFilter.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    OOTextureMinificationFilter(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
