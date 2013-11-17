package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible blending equations.</p>
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
public enum OOBlendingEquation {
    /**
     * <p><i>R<sub>r</sub> = R<sub>s</sub>s<sub>R</sub> + R<sub>d</sub>d<sub>R</sub></i><br/>
     * <i>G<sub>r</sub> = G<sub>s</sub>s<sub>G</sub> + G<sub>d</sub>d<sub>G</sub></i><br/>
     * <i>B<sub>r</sub> = B<sub>s</sub>s<sub>B</sub> + B<sub>d</sub>d<sub>B</sub></i><br/>
     * <i>A<sub>r</sub> = A<sub>s</sub>s<sub>A</sub> + A<sub>d</sub>d<sub>A</sub></i>.</p>
     * 
     * <p>In the equations above, source and destination color components are referred to as <i>(R<sub>s</sub>,
     * G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>, B<sub>d</sub>,
     * A<sub>d</sub>)</i>, respectively. The result color is referred to as <i>(R<sub>r</sub>, G<sub>r</sub>,
     * B<sub>r</sub>, A<sub>r</sub>)</i>. The source and destination blend factors are denoted <i>(s<sub>R</sub>,
     * s<sub>G</sub>, s<sub>B</sub>, s<sub>A</sub>)</i> and <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>,
     * d<sub>A</sub>)</i>, respectively. For these equations all color components are understood to have values in the
     * range {@code [0, 1]}.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FUNC_ADD} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    ADD(OpenGLES20.GL_FUNC_ADD),
    
    /**
     * <p><i>R<sub>r</sub> = R<sub>s</sub>s<sub>R</sub> - R<sub>d</sub>d<sub>R</sub></i><br/>
     * <i>G<sub>r</sub> = G<sub>s</sub>s<sub>G</sub> - G<sub>d</sub>d<sub>G</sub></i><br/>
     * <i>B<sub>r</sub> = B<sub>s</sub>s<sub>B</sub> - B<sub>d</sub>d<sub>B</sub></i><br/>
     * <i>A<sub>r</sub> = A<sub>s</sub>s<sub>A</sub> - A<sub>d</sub>d<sub>A</sub></i>.</p>
     * 
     * <p>In the equations above, source and destination color components are referred to as <i>(R<sub>s</sub>,
     * G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>, B<sub>d</sub>,
     * A<sub>d</sub>)</i>, respectively. The result color is referred to as <i>(R<sub>r</sub>, G<sub>r</sub>,
     * B<sub>r</sub>, A<sub>r</sub>)</i>. The source and destination blend factors are denoted <i>(s<sub>R</sub>,
     * s<sub>G</sub>, s<sub>B</sub>, s<sub>A</sub>)</i> and <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>,
     * d<sub>A</sub>)</i>, respectively. For these equations all color components are understood to have values in the
     * range {@code [0, 1]}.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FUNC_SUBTRACT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    SUBTRACT(OpenGLES20.GL_FUNC_SUBTRACT),
    
    /**
     * <p><i>R<sub>r</sub> = R<sub>d</sub>d<sub>R</sub> - R<sub>s</sub>s<sub>R</sub></i><br/>
     * <i>G<sub>r</sub> = G<sub>d</sub>d<sub>G</sub> - G<sub>s</sub>s<sub>G</sub></i><br/>
     * <i>B<sub>r</sub> = B<sub>d</sub>d<sub>B</sub> - B<sub>s</sub>s<sub>B</sub></i><br/>
     * <i>A<sub>r</sub> = A<sub>d</sub>d<sub>A</sub> - A<sub>s</sub>s<sub>A</sub></i>.</p>
     * 
     * <p>In the equations above, source and destination color components are referred to as <i>(R<sub>s</sub>,
     * G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>, B<sub>d</sub>,
     * A<sub>d</sub>)</i>, respectively. The result color is referred to as <i>(R<sub>r</sub>, G<sub>r</sub>,
     * B<sub>r</sub>, A<sub>r</sub>)</i>. The source and destination blend factors are denoted <i>(s<sub>R</sub>,
     * s<sub>G</sub>, s<sub>B</sub>, s<sub>A</sub>)</i> and <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>,
     * d<sub>A</sub>)</i>, respectively. For these equations all color components are understood to have values in the
     * range {@code [0, 1]}.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FUNC_REVERSE_SUBTRACT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    REVERSE_SUBTRACT(OpenGLES20.GL_FUNC_REVERSE_SUBTRACT);
    
    private final int glConstant;
    
    static OOBlendingEquation valueOf(int value) {
        for (OOBlendingEquation someValue : OOBlendingEquation.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    OOBlendingEquation(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
