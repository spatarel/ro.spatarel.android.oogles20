package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible texture image targets.</p>
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
public enum OOTextureImageTarget {
    /**
     * <p>Referred by a {@code sampler2D} in a shader.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_TEXTURE_2D} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    TEXTURE_2D(OpenGLES20.GL_TEXTURE_2D),
    
    /**
     * <p>When a cube map sampler is used in a shader, the <i>(s, t, r)</i> texture coordinates are treated as a
     * direction vector <i>(r<sub>x</sub>, r<sub>y</sub>, r<sub>z</sub>)</i> emanating from the center of a cube.</p>
     * 
     * <p>Major Axis Direction: <i>+r<sub>x</sub></i><br/>
     * <i>s<sub>c</sub> = -r<sub>z</sub></i><br/>
     * <i>t<sub>c</sub> = -r<sub>y</sub></i><br/>
     * <i>m<sub>a</sub> = r<sub>x</sub></i>.</p>
     * 
     * <p>Using the <i>s<sub>c</sub></i>, <i>t<sub>c</sub> and <i>m<sub>a</sub></i> determined by the major axis
     * direction, an updated <i>(s, t)</i> is calculated as follows:</p>
     * 
     * <p><i>s = <sup>1</sup> / <sub>2</sub> (<sup>s<sub>c</sub></sup> / <sub>|m<sub>a</sub>| + 1</sub>)</i><br/>
     * <i>t = <sup>1</sup> / <sub>2</sub> (<sup>t<sub>c</sub></sup> / <sub>|m<sub>a</sub>| + 1</sub>)</i></p>
     * 
     * <p>This new <i>(s, t)</i> is used to find a texture value in the determined face’s two-dimensional texture image.
     * </p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_TEXTURE_CUBE_MAP_POSITIVE_X} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    TEXTURE_CUBE_MAP_POSITIVE_X(OpenGLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_X),
    
    /**
     * <p>When a cube map sampler is used in a shader, the <i>(s, t, r)</i> texture coordinates are treated as a
     * direction vector <i>(r<sub>x</sub>, r<sub>y</sub>, r<sub>z</sub>)</i> emanating from the center of a cube.</p>
     * 
     * <p>Major Axis Direction: <i>-r<sub>x</sub></i><br/>
     * <i>s<sub>c</sub> = r<sub>z</sub></i><br/>
     * <i>t<sub>c</sub> = -r<sub>y</sub></i><br/>
     * <i>m<sub>a</sub> = r<sub>x</sub></i>.</p>
     * 
     * <p>Using the <i>s<sub>c</sub></i>, <i>t<sub>c</sub> and <i>m<sub>a</sub></i> determined by the major axis
     * direction, an updated <i>(s, t)</i> is calculated as follows:</p>
     * 
     * <p><i>s = <sup>1</sup> / <sub>2</sub> (<sup>s<sub>c</sub></sup> / <sub>|m<sub>a</sub>| + 1</sub>)</i><br/>
     * <i>t = <sup>1</sup> / <sub>2</sub> (<sup>t<sub>c</sub></sup> / <sub>|m<sub>a</sub>| + 1</sub>)</i></p>
     * 
     * <p>This new <i>(s, t)</i> is used to find a texture value in the determined face’s two-dimensional texture image.
     * </p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_TEXTURE_CUBE_MAP_NEGATIVE_X} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    TEXTURE_CUBE_MAP_NEGATIVE_X(OpenGLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_X),
    
    /**
     * <p>When a cube map sampler is used in a shader, the <i>(s, t, r)</i> texture coordinates are treated as a
     * direction vector <i>(r<sub>x</sub>, r<sub>y</sub>, r<sub>z</sub>)</i> emanating from the center of a cube.</p>
     * 
     * <p>Major Axis Direction: <i>+r<sub>y</sub></i><br/>
     * <i>s<sub>c</sub> = r<sub>x</sub></i><br/>
     * <i>t<sub>c</sub> = r<sub>z</sub></i><br/>
     * <i>m<sub>a</sub> = r<sub>y</sub></i>.</p>
     * 
     * <p>Using the <i>s<sub>c</sub></i>, <i>t<sub>c</sub> and <i>m<sub>a</sub></i> determined by the major axis
     * direction, an updated <i>(s, t)</i> is calculated as follows:</p>
     * 
     * <p><i>s = <sup>1</sup> / <sub>2</sub> (<sup>s<sub>c</sub></sup> / <sub>|m<sub>a</sub>| + 1</sub>)</i><br/>
     * <i>t = <sup>1</sup> / <sub>2</sub> (<sup>t<sub>c</sub></sup> / <sub>|m<sub>a</sub>| + 1</sub>)</i></p>
     * 
     * <p>This new <i>(s, t)</i> is used to find a texture value in the determined face’s two-dimensional texture image.
     * </p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_TEXTURE_CUBE_MAP_POSITIVE_Y} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    TEXTURE_CUBE_MAP_POSITIVE_Y(OpenGLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_Y),
    
    /**
     * <p>When a cube map sampler is used in a shader, the <i>(s, t, r)</i> texture coordinates are treated as a
     * direction vector <i>(r<sub>x</sub>, r<sub>y</sub>, r<sub>z</sub>)</i> emanating from the center of a cube.</p>
     * 
     * <p>Major Axis Direction: <i>-r<sub>y</sub></i><br/>
     * <i>s<sub>c</sub> = r<sub>x</sub></i><br/>
     * <i>t<sub>c</sub> = -r<sub>z</sub></i><br/>
     * <i>m<sub>a</sub> = r<sub>y</sub></i>.</p>
     * 
     * <p>Using the <i>s<sub>c</sub></i>, <i>t<sub>c</sub> and <i>m<sub>a</sub></i> determined by the major axis
     * direction, an updated <i>(s, t)</i> is calculated as follows:</p>
     * 
     * <p><i>s = <sup>1</sup> / <sub>2</sub> (<sup>s<sub>c</sub></sup> / <sub>|m<sub>a</sub>| + 1</sub>)</i><br/>
     * <i>t = <sup>1</sup> / <sub>2</sub> (<sup>t<sub>c</sub></sup> / <sub>|m<sub>a</sub>| + 1</sub>)</i></p>
     * 
     * <p>This new <i>(s, t)</i> is used to find a texture value in the determined face’s two-dimensional texture image.
     * </p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_TEXTURE_CUBE_MAP_NEGATIVE_Y} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    TEXTURE_CUBE_MAP_NEGATIVE_Y(OpenGLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y),
    
    /**
     * <p>When a cube map sampler is used in a shader, the <i>(s, t, r)</i> texture coordinates are treated as a
     * direction vector <i>(r<sub>x</sub>, r<sub>y</sub>, r<sub>z</sub>)</i> emanating from the center of a cube.</p>
     * 
     * <p>Major Axis Direction: <i>+r<sub>z</sub></i><br/>
     * <i>s<sub>c</sub> = r<sub>x</sub></i><br/>
     * <i>t<sub>c</sub> = -r<sub>y</sub></i><br/>
     * <i>m<sub>a</sub> = r<sub>z</sub></i>.</p>
     * 
     * <p>Using the <i>s<sub>c</sub></i>, <i>t<sub>c</sub> and <i>m<sub>a</sub></i> determined by the major axis
     * direction, an updated <i>(s, t)</i> is calculated as follows:</p>
     * 
     * <p><i>s = <sup>1</sup> / <sub>2</sub> (<sup>s<sub>c</sub></sup> / <sub>|m<sub>a</sub>| + 1</sub>)</i><br/>
     * <i>t = <sup>1</sup> / <sub>2</sub> (<sup>t<sub>c</sub></sup> / <sub>|m<sub>a</sub>| + 1</sub>)</i></p>
     * 
     * <p>This new <i>(s, t)</i> is used to find a texture value in the determined face’s two-dimensional texture image.
     * </p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_TEXTURE_CUBE_MAP_POSITIVE_Z} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    TEXTURE_CUBE_MAP_POSITIVE_Z(OpenGLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_Z),
    
    /**
     * <p>When a cube map sampler is used in a shader, the <i>(s, t, r)</i> texture coordinates are treated as a
     * direction vector <i>(r<sub>x</sub>, r<sub>y</sub>, r<sub>z</sub>)</i> emanating from the center of a cube.</p>
     * 
     * <p>Major Axis Direction: <i>-r<sub>z</sub></i><br/>
     * <i>s<sub>c</sub> = -r<sub>x</sub></i><br/>
     * <i>t<sub>c</sub> = -r<sub>y</sub></i><br/>
     * <i>m<sub>a</sub> = r<sub>z</sub></i>.</p>
     * 
     * <p>Using the <i>s<sub>c</sub></i>, <i>t<sub>c</sub> and <i>m<sub>a</sub></i> determined by the major axis
     * direction, an updated <i>(s, t)</i> is calculated as follows:</p>
     * 
     * <p><i>s = <sup>1</sup> / <sub>2</sub> (<sup>s<sub>c</sub></sup> / <sub>|m<sub>a</sub>| + 1</sub>)</i><br/>
     * <i>t = <sup>1</sup> / <sub>2</sub> (<sup>t<sub>c</sub></sup> / <sub>|m<sub>a</sub>| + 1</sub>)</i></p>
     * 
     * <p>This new <i>(s, t)</i> is used to find a texture value in the determined face’s two-dimensional texture image.
     * </p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_TEXTURE_CUBE_MAP_NEGATIVE_Z} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    TEXTURE_CUBE_MAP_NEGATIVE_Z(OpenGLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z);
    
    private final int glConstant;
    
    OOTextureImageTarget(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
