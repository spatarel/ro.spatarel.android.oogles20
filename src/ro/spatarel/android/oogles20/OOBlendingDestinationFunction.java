package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible blending destination functions.</p>
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
public enum OOBlendingDestinationFunction {
    /**
     * <p><i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>) = (0, 0, 0, 0)</i>.</p>
     * 
     * <p>Destination scale factors are referred to as <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)
     * </i>. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <p>In the above equation, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link OOGLES20PixelProcessing#setBlendingColor} is
     * referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have
     * integer values between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_ZERO} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    ZERO(OpenGLES20.GL_ZERO),
    
    /**
     * <p><i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>) = (1, 1, 1, 1)</i>.</p>
     * 
     * <p>Destination scale factors are referred to as <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)
     * </i>. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <p>In the above equation, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link OOGLES20PixelProcessing#setBlendingColor} is
     * referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have
     * integer values between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_ONE} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    ONE(OpenGLES20.GL_ONE),
    
    /**
     * <p><i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>) =
     * (<sup>R<sub>s</sub></sup>&frasl;<sub>k<sub>R</sub></sub>,
     * <sup>G<sub>s</sub></sup>&frasl;<sub>k<sub>G</sub></sub>,
     * <sup>B<sub>s</sub></sup>&frasl;<sub>k<sub>B</sub></sub>,
     * <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>.</p>
     * 
     * <p>Destination scale factors are referred to as <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)
     * </i>. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <p>In the above equation, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link OOGLES20PixelProcessing#setBlendingColor} is
     * referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have
     * integer values between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_SRC_COLOR} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    SOURCE_COLOR(OpenGLES20.GL_SRC_COLOR),
    
    /**
     * <p><i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>) = (1, 1, 1, 1) -
     * (<sup>R<sub>s</sub></sup>&frasl;<sub>k<sub>R</sub></sub>,
     * <sup>G<sub>s</sub></sup>&frasl;<sub>k<sub>G</sub></sub>,
     * <sup>B<sub>s</sub></sup>&frasl;<sub>k<sub>B</sub></sub>,
     * <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>.</p>
     * 
     * <p>Destination scale factors are referred to as <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)
     * </i>. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <p>In the above equation, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link OOGLES20PixelProcessing#setBlendingColor} is
     * referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have
     * integer values between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_ONE_MINUS_SRC_COLOR} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    ONE_MINUS_SOURCE_COLOR(OpenGLES20.GL_ONE_MINUS_SRC_COLOR),
    
    /**
     * <p><i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>) =
     * (<sup>R<sub>d</sub></sup>&frasl;<sub>k<sub>R</sub></sub>,
     * <sup>G<sub>d</sub></sup>&frasl;<sub>k<sub>G</sub></sub>,
     * <sup>B<sub>d</sub></sup>&frasl;<sub>k<sub>B</sub></sub>,
     * <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>.</p>
     * 
     * <p>Destination scale factors are referred to as <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)
     * </i>. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <p>In the above equation, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link OOGLES20PixelProcessing#setBlendingColor} is
     * referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have
     * integer values between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_DST_COLOR} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    DESTINATION_COLOR(OpenGLES20.GL_DST_COLOR),
    
    /**
     * <p><i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>) = (1, 1, 1, 1) -
     * (<sup>R<sub>d</sub></sup>&frasl;<sub>k<sub>R</sub></sub>,
     * <sup>G<sub>d</sub></sup>&frasl;<sub>k<sub>G</sub></sub>,
     * <sup>B<sub>d</sub></sup>&frasl;<sub>k<sub>B</sub></sub>,
     * <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>.</p>
     * 
     * <p>Destination scale factors are referred to as <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)
     * </i>. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <p>In the above equation, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link OOGLES20PixelProcessing#setBlendingColor} is
     * referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have
     * integer values between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_ONE_MINUS_DST_COLOR} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    ONE_MINUS_DESTINATION_COLOR(OpenGLES20.GL_ONE_MINUS_DST_COLOR),
    
    /**
     * <p><i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>) =
     * (<sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     * <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     * <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     * <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>.</p>
     * 
     * <p>Destination scale factors are referred to as <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)
     * </i>. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <p>In the above equation, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link OOGLES20PixelProcessing#setBlendingColor} is
     * referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have
     * integer values between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_SRC_ALPHA} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    SOURCE_ALPHA(OpenGLES20.GL_SRC_ALPHA),
    
    /**
     * <p><i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>) = (1, 1, 1, 1) -
     * (<sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     * <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     * <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     * <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>.</p>
     * 
     * <p>Destination scale factors are referred to as <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)
     * </i>. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <p>In the above equation, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link OOGLES20PixelProcessing#setBlendingColor} is
     * referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have
     * integer values between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_SRC_ALPHA} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    ONE_MINUS_SOURCE_ALPHA(OpenGLES20.GL_ONE_MINUS_SRC_ALPHA),
    
    /**
     * <p><i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>) =
     * (<sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     * <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     * <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     * <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>.</p>
     * 
     * <p>Destination scale factors are referred to as <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)
     * </i>. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <p>In the above equation, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link OOGLES20PixelProcessing#setBlendingColor} is
     * referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have
     * integer values between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_DST_ALPHA} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    DESTINATION_ALPHA(OpenGLES20.GL_DST_ALPHA),
    
    /**
     * <p><i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>) = (1, 1, 1, 1) -
     * (<sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     * <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     * <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     * <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>.</p>
     * 
     * <p>Destination scale factors are referred to as <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)
     * </i>. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <p>In the above equation, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link OOGLES20PixelProcessing#setBlendingColor} is
     * referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have
     * integer values between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_ONE_MINUS_DST_ALPHA} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    ONE_MINUS_DESTINATION_ALPHA(OpenGLES20.GL_ONE_MINUS_DST_ALPHA),
    
    /**
     * <p><i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>) =
     * (R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>.</p>
     * 
     * <p>Destination scale factors are referred to as <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)
     * </i>. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <p>In the above equation, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link OOGLES20PixelProcessing#setBlendingColor} is
     * referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have
     * integer values between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_CONSTANT_COLOR} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    CONSTANT_COLOR(OpenGLES20.GL_CONSTANT_COLOR),
    
    /**
     * <p><i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>) = (1, 1, 1, 1) -
     * (R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>.</p>
     * 
     * <p>Destination scale factors are referred to as <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)
     * </i>. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <p>In the above equation, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link OOGLES20PixelProcessing#setBlendingColor} is
     * referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have
     * integer values between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_ONE_MINUS_CONSTANT_COLOR} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    ONE_MINUS_CONSTANT_COLOR(OpenGLES20.GL_ONE_MINUS_CONSTANT_COLOR),
    
    /**
     * <p><i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>) =
     * (A<sub>c</sub>, A<sub>c</sub>, A<sub>c</sub>, A<sub>c</sub>)</i>.</p>
     * 
     * <p>Destination scale factors are referred to as <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)
     * </i>. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <p>In the above equation, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link OOGLES20PixelProcessing#setBlendingColor} is
     * referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have
     * integer values between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_CONSTANT_ALPHA} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    CONSTANT_ALPHA(OpenGLES20.GL_CONSTANT_ALPHA),
    
    /**
     * <p><i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>) = (1, 1, 1, 1) -
     * (A<sub>c</sub>, A<sub>c</sub>, A<sub>c</sub>, A<sub>c</sub>)</i>.</p>
     * 
     * <p>Destination scale factors are referred to as <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)
     * </i>. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <p>In the above equation, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link OOGLES20PixelProcessing#setBlendingColor} is
     * referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have
     * integer values between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_ONE_MINUS_CONSTANT_ALPHA} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    ONE_MINUS_CONSTANT_ALPHA(OpenGLES20.GL_ONE_MINUS_CONSTANT_ALPHA);
    
    private final int glConstant;
    
    static OOBlendingDestinationFunction valueOf(int value) {
        for (OOBlendingDestinationFunction someValue : OOBlendingDestinationFunction.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    OOBlendingDestinationFunction(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
