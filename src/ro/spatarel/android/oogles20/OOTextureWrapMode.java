package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible texture wrap modes.</p>
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
public enum OOTextureWrapMode {
    /**
     * <p>Clamps texture coordinates at all mipmap levels such that the texture filter never samples outside the texture
     * image. The color returned when clamping is derived only from texels at the edge of the texture image.</p>
     * 
     * <p>Texture coordinates are clamped to the range [<i>min</i>, <i>max</i>]. The minimum value is defined as
     * </i>min = <sup>1</sup>&frasl;<sub>2N</sub></i> where <i>N</i> is the size of the texture image in the direction
     * of clamping. The maximum value is defined as <i>max = 1 - min</i> so that clamping is always symmetric about the
     * {@code [0, 1]} mapped range of a texture coordinate.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_CLAMP_TO_EDGE} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    CLAMP_TO_EDGE(OpenGLES20.GL_CLAMP_TO_EDGE),
    
    /**
     * <p>First mirrors the texture coordinate, where mirroring a value <i>f</i> computes</p>
     * 
     * <p><i>mirror(f) = f - &lfloor;f&rfloor;</i>, if <i>&lfloor;f&rfloor;</i> is even<br/>
     * <i>mirror(f) = 1 - (f - &lfloor;f&rfloor;)</i>, if <i>&lfloor;f&rfloor;</i> is odd</p>
     * 
     * <p>The mirrored coordinate is then clamped as described for wrap mode {@link #CLAMP_TO_EDGE}.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_MIRRORED_REPEAT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    MIRRORED_REPEAT(OpenGLES20.GL_MIRRORED_REPEAT),
    
    /**
     * <p>Ignores the integer part of texture coordinates, using only the fractional part. (For a number <i>f</i>, the
     * fractional part is <i>f - &lfloor;f&rfloor;</i>, regardless of the sign of <i>f</i>; recall that the
     * <i>&lfloor;&rfloor;</i> function truncates towards &infin;.)
     * 
     * <p>{@link #REPEAT} is the default behavior for all texture coordinates.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_REPEAT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    REPEAT(OpenGLES20.GL_REPEAT);
    
    private final int glConstant;
    
    static OOTextureWrapMode valueOf(int value) {
        for (OOTextureWrapMode someValue : OOTextureWrapMode.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    OOTextureWrapMode(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
