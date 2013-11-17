package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible pixel data types.</p>
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
public enum OOPixelDataType {
    /**
     * Each component is stored in a {@code byte}.
     * 
     * <p>Reference to the {@link OpenGLES20#GL_UNSIGNED_BYTE} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    UNSIGNED_BYTE(OpenGLES20.GL_UNSIGNED_BYTE),
    
    /**
     * <p>Components are packed with the first component in the most significant bits of the bitfield and successive
     * component occupying progressively less significant locations. The most significant bit of each component is
     * packed in the most significant bit location of its location in the bitfield.</p>
     * 
     * <p>
     * <pre>15 14 13 12 11 10  9  8  7  6  5  4  3  2  1  0
     *   1st comp.  |       2nd       |      3rd</pre></p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_UNSIGNED_SHORT_5_6_5} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    UNSIGNED_SHORT_5_6_5(OpenGLES20.GL_UNSIGNED_SHORT_5_6_5),
    
    /**
     * <p>Components are packed with the first component in the most significant bits of the bitfield and successive
     * component occupying progressively less significant locations. The most significant bit of each component is
     * packed in the most significant bit location of its location in the bitfield.</p>
     * 
     * <p>
     * <pre>15 14 13 12 11 10  9  8  7  6  5  4  3  2  1  0
     * 1st comp. |    2nd    |    3rd    |    4th</pre></p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_UNSIGNED_SHORT_4_4_4_4} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    UNSIGNED_SHORT_4_4_4_4(OpenGLES20.GL_UNSIGNED_SHORT_4_4_4_4),
    
    /**
     * <p>Components are packed with the first component in the most significant bits of the bitfield and successive
     * component occupying progressively less significant locations. The most significant bit of each component is
     * packed in the most significant bit location of its location in the bitfield.</p>
     * 
     * <p>
     * <pre>15 14 13 12 11 10  9  8  7  6  5  4  3  2  1  0
     *   1st comp.  |      2nd     |      3rd     |4th</pre></p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_UNSIGNED_SHORT_5_5_5_1} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    UNSIGNED_SHORT_5_5_5_1(OpenGLES20.GL_UNSIGNED_SHORT_5_5_5_1);
    
    private final int glConstant;
    
    static OOPixelDataType valueOf(int value) {
        for (OOPixelDataType someValue : OOPixelDataType.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    OOPixelDataType(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
