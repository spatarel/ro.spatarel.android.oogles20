package ro.spatarel.android.oogles20;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * <p>Class grouping together the methods managing the pixel processing pipeline stage.</p>
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
public class OOGLES20PixelProcessing {
    
    OOGLES20PixelProcessing() {
        // There is nothing here.
    }
    
    /**
     * <p>If enabled, blend the computed fragment color values with the values in the color buffers.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glEnable} with argument {@link OpenGLES20#GL_BLEND}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, blend the computed fragment color values with the values in the color buffers.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #setBlendingFunction
     */
    public void enableBlending() {
        OOGLES20.backEnd.glEnable(OpenGLES20.GL_BLEND);
    }
    
    /**
     * <p>Specify the equation used for both the RGB blend equation and the Alpha blend equation.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glBlendEquation}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>The blend equations determine how a new pixel (the "source" color) is combined with a pixel already in the
     * framebuffer (the "destination" color). This function sets both the RGB blend equation and the alpha blend
     * equation to a single equation.</p>
     * 
     * <p>These equations use the source and destination blend factors specified by either {@link #setBlendingFunction}
     * or {@link #setBlendingFunctionSeparately}. See {@link #setBlendingFunction} or {@link
     * #setBlendingFunctionSeparately} for a description of the various blend factors.</p>
     * 
     * <p>In the equations that follow, source and destination color components are referred to as <i>(R<sub>s</sub>,
     * G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>, B<sub>d</sub>,
     * A<sub>d</sub>)</i>, respectively. The result color is referred to as <i>(R<sub>r</sub>, G<sub>r</sub>,
     * B<sub>r</sub>, A<sub>r</sub>)</i>. The source and destination blend factors are denoted <i>(s<sub>R</sub>,
     * s<sub>G</sub>, s<sub>B</sub>, s<sub>A</sub>)</i> and <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>,
     * d<sub>A</sub>)</i>, respectively. For these equations all color components are understood to have values in the
     * range {@code [0, 1]}.</p>
     * 
     * <table border="1">
     *   <tr>
     *     <th>{@code equation}</th>
     *     <th>RGB Components</th>
     *     <th>Alpha Component</th>
     *   </tr>
     *   <tr>
     *     <td>{@link OOBlendingEquation#ADD}</td>
     *     <td>
     *         <i>R<sub>r</sub> = R<sub>s</sub>s<sub>R</sub> + R<sub>d</sub>d<sub>R</sub></i><br/>
     *         <i>G<sub>r</sub> = G<sub>s</sub>s<sub>G</sub> + G<sub>d</sub>d<sub>G</sub></i><br/>
     *         <i>B<sub>r</sub> = B<sub>s</sub>s<sub>B</sub> + B<sub>d</sub>d<sub>B</sub></i>
     *     </td>
     *     <td>
     *         <i>A<sub>r</sub> = A<sub>s</sub>s<sub>A</sub> + A<sub>d</sub>d<sub>A</sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>{@link OOBlendingEquation#SUBTRACT}</td>
     *     <td>
     *         <i>R<sub>r</sub> = R<sub>s</sub>s<sub>R</sub> - R<sub>d</sub>d<sub>R</sub></i><br/>
     *         <i>G<sub>r</sub> = G<sub>s</sub>s<sub>G</sub> - G<sub>d</sub>d<sub>G</sub></i><br/>
     *         <i>B<sub>r</sub> = B<sub>s</sub>s<sub>B</sub> - B<sub>d</sub>d<sub>B</sub></i>
     *     </td>
     *     <td>
     *         <i>A<sub>r</sub> = A<sub>s</sub>s<sub>A</sub> - A<sub>d</sub>d<sub>A</sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>{@link OOBlendingEquation#REVERSE_SUBTRACT}</td>
     *     <td>
     *         <i>R<sub>r</sub> = R<sub>d</sub>d<sub>R</sub> - R<sub>s</sub>s<sub>R</sub></i><br/>
     *         <i>G<sub>r</sub> = G<sub>d</sub>d<sub>G</sub> - G<sub>s</sub>s<sub>G</sub></i><br/>
     *         <i>B<sub>r</sub> = B<sub>d</sub>d<sub>B</sub> - B<sub>s</sub>s<sub>B</sub></i>
     *     </td>
     *     <td>
     *         <i>A<sub>r</sub> = A<sub>d</sub>d<sub>A</sub> - A<sub>s</sub>s<sub>A</sub></i>
     *     </td>
     *   </tr>
     * </table>
     * 
     * <p>The results of these equations are clamped to the range {@code [0, 1]}.</p>
     * 
     * <p>The {@link OOBlendingEquation#ADD} equation is useful for antialiasing and transparency, among other things.
     * </p>
     * 
     * <p>Initially, both the RGB blend equation and the alpha blend equation are set to {@link OOBlendingEquation#ADD}.
     * </p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param equation Specifies how source and destination colors are combined.
     * 
     * @see #getBlendingRGBEquation
     * @see #getBlendingAlphaEquation
     * @see #setBlendingColor
     * @see #setBlendingEquationSeparately
     * @see #setBlendingFunction
     * @see #setBlendingFunctionSeparately
     */
    public void setBlendingEquation(OOBlendingEquation equation) {
        OOGLES20.backEnd.glBlendEquation(equation.getGLConstant());
    }
    
    /**
     * <p>Set the RGB blend equation and the alpha blend equation separately.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glBlendEquationSeparate}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>The blend equations determines how a new pixel (the "source" color) is combined with a pixel already in the
     * framebuffer (the "destination" color). This function specifies one blend equation for the RGB-color components
     * and one blend equation for the alpha component.</p>
     * 
     * <p>These equations use the source and destination blend factors specified by either {@link #setBlendingFunction}
     * or {@link #setBlendingFunctionSeparately}. See {@link #setBlendingFunction} or {@link
     * #setBlendingFunctionSeparately} for a description of the various blend factors.</p>
     * 
     * <p>In the equations that follow, source and destination color components are referred to as <i>(R<sub>s</sub>,
     * G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>, B<sub>d</sub>,
     * A<sub>d</sub>)</i>, respectively. The result color is referred to as <i>(R<sub>r</sub>, G<sub>r</sub>,
     * B<sub>r</sub>, A<sub>r</sub>)</i>. The source and destination blend factors are denoted <i>(s<sub>R</sub>,
     * s<sub>G</sub>, s<sub>B</sub>, s<sub>A</sub>)</i> and <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>,
     * d<sub>A</sub>)</i>, respectively. For these equations all color components are understood to have values in the
     * range {@code [0, 1]}.</p>
     * 
     * <table border="1">
     *   <tr>
     *     <th>{@code equation}</th>
     *     <th>RGB Components</th>
     *     <th>Alpha Component</th>
     *   </tr>
     *   <tr>
     *     <td>{@link OOBlendingEquation#ADD}</td>
     *     <td>
     *         <i>R<sub>r</sub> = R<sub>s</sub>s<sub>R</sub> + R<sub>d</sub>d<sub>R</sub></i><br/>
     *         <i>G<sub>r</sub> = G<sub>s</sub>s<sub>G</sub> + G<sub>d</sub>d<sub>G</sub></i><br/>
     *         <i>B<sub>r</sub> = B<sub>s</sub>s<sub>B</sub> + B<sub>d</sub>d<sub>B</sub></i>
     *     </td>
     *     <td>
     *         <i>A<sub>r</sub> = A<sub>s</sub>s<sub>A</sub> + A<sub>d</sub>d<sub>A</sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>{@link OOBlendingEquation#SUBTRACT}</td>
     *     <td>
     *         <i>R<sub>r</sub> = R<sub>s</sub>s<sub>R</sub> - R<sub>d</sub>d<sub>R</sub></i><br/>
     *         <i>G<sub>r</sub> = G<sub>s</sub>s<sub>G</sub> - G<sub>d</sub>d<sub>G</sub></i><br/>
     *         <i>B<sub>r</sub> = B<sub>s</sub>s<sub>B</sub> - B<sub>d</sub>d<sub>B</sub></i>
     *     </td>
     *     <td>
     *         <i>A<sub>r</sub> = A<sub>s</sub>s<sub>A</sub> - A<sub>d</sub>d<sub>A</sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>{@link OOBlendingEquation#REVERSE_SUBTRACT}</td>
     *     <td>
     *         <i>R<sub>r</sub> = R<sub>d</sub>d<sub>R</sub> - R<sub>s</sub>s<sub>R</sub></i><br/>
     *         <i>G<sub>r</sub> = G<sub>d</sub>d<sub>G</sub> - G<sub>s</sub>s<sub>G</sub></i><br/>
     *         <i>B<sub>r</sub> = B<sub>d</sub>d<sub>B</sub> - B<sub>s</sub>s<sub>B</sub></i>
     *     </td>
     *     <td>
     *         <i>A<sub>r</sub> = A<sub>d</sub>d<sub>A</sub> - A<sub>s</sub>s<sub>A</sub></i>
     *     </td>
     *   </tr>
     * </table>
     * 
     * <p>The results of these equations are clamped to the range {@code [0, 1]}.</p>
     * 
     * <p>The {@link OOBlendingEquation#ADD} equation is useful for antialiasing and transparency, among other things.
     * </p>
     * 
     * <p>Initially, both the RGB blend equation and the alpha blend equation are set to {@link OOBlendingEquation#ADD}.
     * </p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2006 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param RGBEquation specifies the RGB blend equation, how the red, green and blue components of the source and
     * destination colors are combined.
     * @param alphaEquation specifies the alpha blend equation, how the alpha component of the source and destination
     * colors are combined.
     * 
     * @see #getBlendingRGBEquation
     * @see #getBlendingAlphaEquation
     * @see #setBlendingColor
     * @see #setBlendingEquation
     * @see #setBlendingFunction
     * @see #setBlendingFunctionSeparately
     */
    public void setBlendingEquationSeparately(OOBlendingEquation RGBEquation, OOBlendingEquation alphaEquation) {
        OOGLES20.backEnd.glBlendEquationSeparate(RGBEquation.getGLConstant(), alphaEquation.getGLConstant());
    }
    
    /**
     * <p>Specify pixel arithmetic.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glBlendFunc}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Pixels can be drawn using a function that blends the incoming (source) RGBA values with the RGBA values that
     * are already in the frame buffer (the destination values). Blending is initially disabled. Use 
     * {@link #enableBlending} and {@link #disableBlending} to enable and disable blending.</p>
     * 
     * <p>{@link #setBlendingFunction} defines the operation of blending when it is enabled. {@code source} specifies
     * which method is used to scale the source color components. {@code destination} specifies which method is used to
     * scale the destination color components. The possible methods are described in the following table. Each method
     * defines four scale factors, one each for red, green, blue and alpha. In the table and in subsequent equations,
     * source and destination color components are referred to as <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>,
     * A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>, B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified
     * by {@link #setBlendingColor} is referred to as <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>,
     * A<sub>c</sub>)</i>. They are understood to have integer values between <i>0</i> and <i>(k<sub>R</sub>,
     * k<sub>G</sub>, k<sub>B</sub>, k<sub>A</sub>)</i>, where <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and
     * <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>, m<sub>A</sub>)</i> is the number of red, green, blue and alpha
     * bitplanes.</p>
     * 
     * <p>Source and destination scale factors are referred to as <i>(s<sub>R</sub>, s<sub>G</sub>, s<sub>B</sub>,
     * s<sub>A</sub>)</i> and <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)</i>. The scale factors
     * described in the table, denoted <i>(f<sub>R</sub>, f<sub>G</sub>, f<sub>B</sub>, f<sub>A</sub>)</i>, represent
     * either source or destination factors. All scale factors have range {@code [0, 1]}.</p>
     * 
     * <table border="1">
     *   <tr>
     *     <th>Parameter</th>
     *     <th><i>(f<sub>R</sub>, f<sub>G</sub>, f<sub>B</sub>, f<sub>A</sub>)</i></th>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ZERO}<br/>
     *         {@link OOBlendingDestinationFunction#ZERO}
     *     </td>
     *     <td>
     *         <i>(0, 0, 0, 0)</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ONE}<br/>
     *         {@link OOBlendingDestinationFunction#ONE}
     *     </td>
     *     <td>
     *         <i>(1, 1, 1, 1)</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#SOURCE_COLOR}<br/>
     *         {@link OOBlendingDestinationFunction#SOURCE_COLOR}
     *     </td>
     *     <td>
     *         <i>(<sup>R<sub>s</sub></sup>&frasl;<sub>k<sub>R</sub></sub>,
     *         <sup>G<sub>s</sub></sup>&frasl;<sub>k<sub>G</sub></sub>,
     *         <sup>B<sub>s</sub></sup>&frasl;<sub>k<sub>B</sub></sub>,
     *         <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ONE_MINUS_SOURCE_COLOR}<br/>
     *         {@link OOBlendingDestinationFunction#ONE_MINUS_SOURCE_COLOR}
     *     </td>
     *     <td>
     *         <i>(1, 1, 1, 1) - (<sup>R<sub>s</sub></sup>&frasl;<sub>k<sub>R</sub></sub>,
     *         <sup>G<sub>s</sub></sup>&frasl;<sub>k<sub>G</sub></sub>,
     *         <sup>B<sub>s</sub></sup>&frasl;<sub>k<sub>B</sub></sub>,
     *         <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#DESTINATION_COLOR}<br/>
     *         {@link OOBlendingDestinationFunction#DESTINATION_COLOR}
     *     </td>
     *     <td>
     *         <i>(<sup>R<sub>d</sub></sup>&frasl;<sub>k<sub>R</sub></sub>,
     *         <sup>G<sub>d</sub></sup>&frasl;<sub>k<sub>G</sub></sub>,
     *         <sup>B<sub>d</sub></sup>&frasl;<sub>k<sub>B</sub></sub>,
     *         <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ONE_MINUS_DESTINATION_COLOR}<br/>
     *         {@link OOBlendingDestinationFunction#ONE_MINUS_DESTINATION_COLOR}
     *     </td>
     *     <td>
     *         <i>(1, 1, 1, 1) - (<sup>R<sub>d</sub></sup>&frasl;<sub>k<sub>R</sub></sub>,
     *         <sup>G<sub>d</sub></sup>&frasl;<sub>k<sub>G</sub></sub>,
     *         <sup>B<sub>d</sub></sup>&frasl;<sub>k<sub>B</sub></sub>,
     *         <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#SOURCE_ALPHA}<br/>
     *         {@link OOBlendingDestinationFunction#SOURCE_ALPHA}
     *     </td>
     *     <td>
     *         <i>(<sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ONE_MINUS_SOURCE_ALPHA}<br/>
     *         {@link OOBlendingDestinationFunction#ONE_MINUS_SOURCE_ALPHA}
     *     </td>
     *     <td>
     *         <i>(1, 1, 1, 1) - (<sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#DESTINATION_ALPHA}<br/>
     *         {@link OOBlendingDestinationFunction#DESTINATION_ALPHA}
     *     </td>
     *     <td>
     *         <i>(<sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ONE_MINUS_DESTINATION_ALPHA}<br/>
     *         {@link OOBlendingDestinationFunction#ONE_MINUS_DESTINATION_ALPHA}
     *     </td>
     *     <td>
     *         <i>(1, 1, 1, 1) - (<sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#CONSTANT_COLOR}<br/>
     *         {@link OOBlendingDestinationFunction#CONSTANT_COLOR}
     *     </td>
     *     <td>
     *         <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ONE_MINUS_CONSTANT_COLOR}<br/>
     *         {@link OOBlendingDestinationFunction#ONE_MINUS_CONSTANT_COLOR}
     *     </td>
     *     <td>
     *         <i>(1, 1, 1, 1) - (R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#CONSTANT_ALPHA}<br/>
     *         {@link OOBlendingDestinationFunction#CONSTANT_ALPHA}
     *     </td>
     *     <td>
     *         <i>(A<sub>c</sub>, A<sub>c</sub>, A<sub>c</sub>, A<sub>c</sub>)</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ONE_MINUS_CONSTANT_ALPHA}<br/>
     *         {@link OOBlendingDestinationFunction#ONE_MINUS_CONSTANT_ALPHA}
     *     </td>
     *     <td>
     *         <i>(1, 1, 1, 1) - (A<sub>c</sub>, A<sub>c</sub>, A<sub>c</sub>, A<sub>c</sub>)</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#SOURCE_ALPHA_SATURATE}<br/>
     *     </td>
     *     <td>
     *         <i>(i, i, i, 1)</i>
     *     </td>
     *   </tr>
     * </table>
     * 
     * <p>In the table,
     * <i>i = <sup>min(A<sub>s</sub>, k<sub>A</sub> - A<sub>d</sub>)</sup>&frasl;<sub>k<sub>A</sub></sub></i>.</p>
     * 
     * <p>To determine the blended RGBA values of a pixel, the system uses one of the equations set by
     * {@link #setBlendingEquation} or {@link #setBlendingEquationSeparately}.</p>
     * 
     * <p>Blending arithmetic is not exactly specified, because blending operates with imprecise integer color values.
     * However, a blend factor that should be equal to {@code 1} is guaranteed not to modify its multiplicand and a
     * blend factor equal to {@code 0} reduces its multiplicand to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Incoming (source) alpha is correctly thought of as a material opacity, ranging from {@code 1.0}
     * (<i>K<sub>A</sub></i>), representing complete opacity, to {@code 0.0} ({@code 0}), representing complete
     * transparency.</p>
     * 
     * <p>Transparency is best implemented using blend function ({@link OOBlendingSourceFunction#SOURCE_ALPHA}, {@link
     * OOBlendingDestinationFunction#ONE_MINUS_SOURCE_ALPHA}) with primitives sorted from farthest to nearest. Note that
     * this transparency calculation does not require the presence of alpha bitplanes in the frame buffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param source Specifies how the red, green, blue and alpha source blending factors are computed. The initial
     * value is {@link OOBlendingSourceFunction#ONE}.
     * @param destination Specifies how the red, green, blue and alpha destination blending factors are computed. The
     * initial value is {@link OOBlendingDestinationFunction#ZERO}.
     * 
     * @see #getBlendingSourceRGBFunction
     * @see #getBlendingSourceAlphaFunction
     * @see #getBlendingDestinationRGBFunction
     * @see #getBlendingDestinationAlphaFunction
     * @see #isBlendingEnabled
     * @see #setBlendingColor
     * @see #setBlendingEquation
     * @see #setBlendingEquationSeparately
     * @see #setBlendingFunctionSeparately
     * @see OOGLES20Framebuffer#clear
     * @see #enableBlending
     * @see OOGLES20FragmentProcessing#setStencilFunction
     */
    public void setBlendingFunction(OOBlendingSourceFunction source, OOBlendingDestinationFunction destination) {
        OOGLES20.backEnd.glBlendFunc(source.getGLConstant(), destination.getGLConstant());
    }
    
    /**
     * <p>Specify pixel arithmetic for RGB and alpha components separately.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glBlendFuncSeparate}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Pixels can be drawn using a function that blends the incoming (source) RGBA values with the RGBA values that
     * are already in the frame buffer (the destination values). Blending is initially disabled. Use 
     * {@link #enableBlending} and {@link #disableBlending} to enable and disable blending.</p>
     * 
     * <p>{@link #setBlendingFunctionSeparately} defines the operation of blending when it is enabled. {@code sourceRGB}
     * specifies which method is used to scale the source RGB-color components. {@code destinationRGB} specifies which
     * method is used to scale the destination RGB-color components. Likewise, {@code sourceAlpha} specifies which
     * method is used to scale the source alpha color component and {@code destinationAlpha} specifies which method is
     * used to scale the destination alpha component. The possible methods are described in the following table. Each
     * method defines four scale factors, one each for red, green, blue and alpha.</p>
     * 
     * <p>In the table and in subsequent equations, source and destination color components are referred to as
     * <i>(R<sub>s</sub>, G<sub>s</sub>, B<sub>s</sub>, A<sub>s</sub>)</i> and <i>(R<sub>d</sub>, G<sub>d</sub>,
     * B<sub>d</sub>, A<sub>d</sub>)</i>. The color specified by {@link #setBlendingColor} is referred to as
     * <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>, A<sub>c</sub>)</i>. They are understood to have integer values
     * between {@code 0} and <i>(k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>, k<sub>R</sub>)</i>, where
     * <i>k<sub>c</sub> = 2<sup>m<sub>c</sub></sup> - 1</i> and <i>(m<sub>R</sub>, m<sub>G</sub>, m<sub>B</sub>,
     * m<sub>A</sub>)</i> is the number of red, green, blue and alpha bitplanes.</p>
     * 
     * <p>Source and destination scale factors are referred to as <i>(s<sub>R</sub>, s<sub>G</sub>, s<sub>B</sub>,
     * s<sub>A</sub>)</i> and <i>(d<sub>R</sub>, d<sub>G</sub>, d<sub>B</sub>, d<sub>A</sub>)</i>. All scale factors
     * have range {@code [0, 1]}.</p>
     * 
     * <table border="1">
     *   <tr>
     *     <th>Parameter</th>
     *     <th>RGB Factor</th>
     *     <th>Alpha Factor</th>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ZERO}<br/>
     *         {@link OOBlendingDestinationFunction#ZERO}
     *     </td>
     *     <td>
     *         <i>(0, 0, 0)</i>
     *     </td>
     *     <td>
     *         <i>0</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ONE}<br/>
     *         {@link OOBlendingDestinationFunction#ONE}
     *     </td>
     *     <td>
     *         <i>(1, 1, 1)</i>
     *     </td>
     *     <td>
     *         <i>1</i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#SOURCE_COLOR}<br/>
     *         {@link OOBlendingDestinationFunction#SOURCE_COLOR}
     *     </td>
     *     <td>
     *         <i>(<sup>R<sub>s</sub></sup>&frasl;<sub>k<sub>R</sub></sub>,
     *         <sup>G<sub>s</sub></sup>&frasl;<sub>k<sub>G</sub></sub>,
     *         <sup>B<sub>s</sub></sup>&frasl;<sub>k<sub>B</sub></sub>)</i>
     *     </td>
     *     <td>
     *         <i><sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ONE_MINUS_SOURCE_COLOR}<br/>
     *         {@link OOBlendingDestinationFunction#ONE_MINUS_SOURCE_COLOR}
     *     </td>
     *     <td>
     *         <i>(1, 1, 1) - (<sup>R<sub>s</sub></sup>&frasl;<sub>k<sub>R</sub></sub>,
     *         <sup>G<sub>s</sub></sup>&frasl;<sub>k<sub>G</sub></sub>,
     *         <sup>B<sub>s</sub></sup>&frasl;<sub>k<sub>B</sub></sub>)</i>
     *     </td>
     *     <td>
     *         <i>1 - <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#DESTINATION_COLOR}<br/>
     *         {@link OOBlendingDestinationFunction#DESTINATION_COLOR}
     *     </td>
     *     <td>
     *         <i>(<sup>R<sub>d</sub></sup>&frasl;<sub>k<sub>R</sub></sub>,
     *         <sup>G<sub>d</sub></sup>&frasl;<sub>k<sub>G</sub></sub>,
     *         <sup>B<sub>d</sub></sup>&frasl;<sub>k<sub>B</sub></sub>)</i>
     *     </td>
     *     <td>
     *         <i><sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ONE_MINUS_DESTINATION_COLOR}<br/>
     *         {@link OOBlendingDestinationFunction#ONE_MINUS_DESTINATION_COLOR}
     *     </td>
     *     <td>
     *         <i>(1, 1, 1) - (<sup>R<sub>d</sub></sup>&frasl;<sub>k<sub>R</sub></sub>,
     *         <sup>G<sub>d</sub></sup>&frasl;<sub>k<sub>G</sub></sub>,
     *         <sup>B<sub>d</sub></sup>&frasl;<sub>k<sub>B</sub></sub>)</i>
     *     </td>
     *     <td>
     *         <i>1 - <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#SOURCE_ALPHA}<br/>
     *         {@link OOBlendingDestinationFunction#SOURCE_ALPHA}
     *     </td>
     *     <td>
     *         <i>(<sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>
     *     </td>
     *     <td>
     *         <i><sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ONE_MINUS_SOURCE_ALPHA}<br/>
     *         {@link OOBlendingDestinationFunction#ONE_MINUS_SOURCE_ALPHA}
     *     </td>
     *     <td>
     *         <i>(1, 1, 1) - (<sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>
     *     </td>
     *     <td>
     *         <i>1 - <sup>A<sub>s</sub></sup>&frasl;<sub>k<sub>A</sub></sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#DESTINATION_ALPHA}<br/>
     *         {@link OOBlendingDestinationFunction#DESTINATION_ALPHA}
     *     </td>
     *     <td>
     *         <i>(<sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>
     *     </td>
     *     <td>
     *         <i><sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ONE_MINUS_DESTINATION_ALPHA}<br/>
     *         {@link OOBlendingDestinationFunction#ONE_MINUS_DESTINATION_ALPHA}
     *     </td>
     *     <td>
     *         <i>(1, 1, 1) - (<sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>,
     *         <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub>)</i>
     *     </td>
     *     <td>
     *         <i>1 - <sup>A<sub>d</sub></sup>&frasl;<sub>k<sub>A</sub></sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#CONSTANT_COLOR}<br/>
     *         {@link OOBlendingDestinationFunction#CONSTANT_COLOR}
     *     </td>
     *     <td>
     *         <i>(R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>)</i>
     *     </td>
     *     <td>
     *         <i>A<sub>c</sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ONE_MINUS_CONSTANT_COLOR}<br/>
     *         {@link OOBlendingDestinationFunction#ONE_MINUS_CONSTANT_COLOR}
     *     </td>
     *     <td>
     *         <i>(1, 1, 1) - (R<sub>c</sub>, G<sub>c</sub>, B<sub>c</sub>)</i>
     *     </td>
     *     <td>
     *         <i>1 - A<sub>c</sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#CONSTANT_ALPHA}<br/>
     *         {@link OOBlendingDestinationFunction#CONSTANT_ALPHA}
     *     </td>
     *     <td>
     *         <i>(A<sub>c</sub>, A<sub>c</sub>, A<sub>c</sub>)</i>
     *     </td>
     *     <td>
     *         <i>A<sub>c</sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#ONE_MINUS_CONSTANT_ALPHA}<br/>
     *         {@link OOBlendingDestinationFunction#ONE_MINUS_CONSTANT_ALPHA}
     *     </td>
     *     <td>
     *         <i>(1, 1, 1) - (A<sub>c</sub>, A<sub>c</sub>, A<sub>c</sub>)</i>
     *     </td>
     *     <td>
     *         <i>1 - A<sub>c</sub></i>
     *     </td>
     *   </tr>
     *   <tr>
     *     <td>
     *         {@link OOBlendingSourceFunction#SOURCE_ALPHA_SATURATE}<br/>
     *     </td>
     *     <td>
     *         <i>(i, i, i)</i>
     *     </td>
     *     <td>
     *         <i>1</i>
     *     </td>
     *   </tr>
     * </table>
     * 
     * <p>In the table, <i>i = min(A<sub>s</sub>, 1 - A<sub>d</sub>)</i>.</p>
     * 
     * <p>To determine the blended RGBA values of a pixel, the system uses one of the equations set by
     * {@link #setBlendingEquation} or {@link #setBlendingEquationSeparately}.</p>
     * 
     * <p>Despite the apparent precision of the above equations, blending arithmetic is not exactly specified, because
     * blending operates with imprecise integer color values. However, a blend factor that should be equal to {@code 1}
     * is guaranteed not to modify its multiplicand and a blend factor equal to {@code 0} reduces its multiplicand to
     * {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Incoming (source) alpha is correctly thought of as a material opacity, ranging from {@code 1.0}
     * (<i>K<sub>A</sub></i>), representing complete opacity, to {@code 0.0} ({@code 0}), representing complete
     * transparency.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param sourceRGB Specifies how the red, green and blue blending factors are computed. The initial value is
     * {@link OOBlendingSourceFunction#ONE}.
     * @param destinationRGB Specifies how the red, green and blue destination blending factors are computed. The
     * initial value is {@link OOBlendingDestinationFunction#ZERO}.
     * @param sourceAlpha Specified how the alpha source blending factor is computed. The initial value is {@link
     * OOBlendingSourceFunction#ONE}.
     * @param destinationAlpha Specified how the alpha destination blending factor is computed. The initial value is
     * {@link OOBlendingDestinationFunction#ZERO}.
     * 
     * @see #getBlendingSourceRGBFunction
     * @see #getBlendingSourceAlphaFunction
     * @see #getBlendingDestinationRGBFunction
     * @see #getBlendingDestinationAlphaFunction
     * @see #isBlendingEnabled
     * @see #setBlendingColor
     * @see #setBlendingEquation
     * @see #setBlendingEquationSeparately
     * @see #setBlendingFunction
     * @see OOGLES20Framebuffer#clear
     * @see #enableBlending
     * @see OOGLES20FragmentProcessing#setStencilFunction
     */
    public void setBlendingFunctionSeparately(OOBlendingSourceFunction sourceRGB,
            OOBlendingDestinationFunction destinationRGB, OOBlendingSourceFunction sourceAlpha,
            OOBlendingDestinationFunction destinationAlpha) {
        OOGLES20.backEnd.glBlendFuncSeparate(sourceRGB.getGLConstant(), destinationRGB.getGLConstant(),
                sourceAlpha.getGLConstant(), destinationAlpha.getGLConstant());
    }
    
    /**
     * <p>Set the blend color.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glBlendColor}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>The {@link #getBlendingColor} may be used to calculate the source and destination blending factors. The color
     * components are clamped to the range {@code [0, 1]} before being stored. See {@link #setBlendingFunction} for a
     * complete description of the blending operations. Initially the {@link #getBlendingColor} is set to
     * {@code (0, 0, 0, 0)}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param red Specifies the red component of the blend color.
     * @param green Specifies the green component of the blend color.
     * @param blue Specifies the blue component of the blend color.
     * @param alpha Specifies the alpha component of the blend color.
     * 
     * @see #getBlendingColor
     * @see #setBlendingEquation
     * @see #setBlendingFunction
     */
    public void setBlendingColor(float red, float green, float blue, float alpha) {
        OOGLES20.backEnd.glBlendColor(red, green, blue, alpha);
    }
    
    /**
     * <p>If enabled, blend the computed fragment color values with the values in the color buffers.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDisable} with argument {@link OpenGLES20#GL_BLEND}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, blend the computed fragment color values with the values in the color buffers.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #setBlendingFunction
     */
    public void disableBlending() {
        OOGLES20.backEnd.glDisable(OpenGLES20.GL_BLEND);
    }
    
    /**
     * <p>If enabled, dither color components or indices before they are written to the color buffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glEnable} with argument {@link OpenGLES20#GL_DITHER}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, dither color components or indices before they are written to the color buffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    public void enableDithering() {
        OOGLES20.backEnd.glEnable(OpenGLES20.GL_DITHER);
    }
    
    /**
     * <p>If enabled, dither color components or indices before they are written to the color buffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDisable} with argument {@link OpenGLES20#GL_DITHER}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, dither color components or indices before they are written to the color buffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    public void disableDithering() {
        OOGLES20.backEnd.glDisable(OpenGLES20.GL_DITHER);
    }
    
    /**
     * <p>Enable and disable writing of frame buffer color components.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glColorMask}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setColorBufferWriteMask} specifies whether the individual color components in the frame buffer can or
     * cannot be written. If {@code red} is {@code false}, for example, no change is made to the red component of any
     * pixel in any of the color buffers, regardless of the drawing operation attempted.</p>
     * 
     * <p>Changes to individual bits of components cannot be controlled. Rather, changes are either enabled or disabled
     * for entire color components.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param red Specify whether the red component can or cannot be written into the frame buffer. The initial value is
     * {@code true}, indicating that the color component can be written.
     * @param green Specify whether the green component can or cannot be written into the frame buffer. The initial
     * value is {@code true}, indicating that the color component can be written.
     * @param blue Specify whether the blue component can or cannot be written into the frame buffer. The initial value
     * is {@code true}, indicating that the color component can be written.
     * @param alpha Specify whether the alpha component can or cannot be written into the frame buffer. The initial
     * value is {@code true}, indicating that the color component can be written.
     * 
     * @see #getColorBufferWriteMask
     * @see OOGLES20Framebuffer#clear
     * @see #setDepthBufferWriteMask
     * @see #setStencilBufferWriteMask
     */
    public void setColorBufferWriteMask(boolean red, boolean green, boolean blue, boolean alpha) {
        OOGLES20.backEnd.glColorMask(red, green, blue, alpha);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setColorBufferWriteMask(mask.red, mask.green, mask.blue, mask.alpha);}.</p>
     * 
     * @param mask Specify which component can or cannot be written into the frame buffer. The initial value is
     * {@code (true, true, true, true)}, indicating that the color components can be written.
     * 
     * @see #setColorBufferWriteMask
     */
    public void setColorBufferWriteMask(OOColorBufferWriteMask mask) {
        this.setColorBufferWriteMask(mask.red, mask.green, mask.blue, mask.alpha);
    }
    
    /**
     * <p>Enable or disable writing into the depth buffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDepthMask}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setDepthBufferWriteMask} specifies whether the depth buffer is enabled for writing. If {@code enabled}
     * is {@code false}, depth buffer writing is disabled. Otherwise, it is enabled. Initially, depth buffer writing is
     * enabled.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param enabled Specifies whether the depth buffer is enabled for writing. If flag is {@code false}, depth buffer
     * writing is disabled. Otherwise, it is enabled. Initially, depth buffer writing is enabled.
     * 
     * @see #getDepthBufferWriteMask
     * @see #setColorBufferWriteMask
     * @see OOGLES20FragmentProcessing#setDepthTestFunction
     * @see OOGLES20PrimitiveProcessing#setDepthRange
     * @see #setStencilBufferWriteMask
     */
    public void setDepthBufferWriteMask(boolean enabled) {
        OOGLES20.backEnd.glDepthMask(enabled);
    }
    
    /**
     * <p>Control the front and back writing of individual bits in the stencil planes.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glStencilMask}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setStencilBufferWriteMask} controls the writing of individual bits in the stencil planes. The least
     * significant <i>n</i> bits of {@code writeMask}, where <i>n</i> is the number of bits in the stencil buffer,
     * specify a mask. Where a {@code 1} appears in the mask, it's possible to write to the corresponding bit in the
     * stencil buffer. Where a {@code 0} appears, the corresponding bit is write-protected. Initially, all bits are
     * enabled for writing.</p>
     * 
     * <p>There can be two separate {@code writeMask} writemasks; one affects back-facing polygons and the other
     * affects front-facing polygons as well as other non-polygon primitives. {@link #setStencilBufferWriteMask} sets
     * both front and back stencil writemasks to the same values. Use {@link #setStencilBufferWriteMaskSeparately} to
     * set front and back stencil writemasks to different values.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>{@link #setStencilBufferWriteMask} is the same as calling {@link #setStencilBufferWriteMaskSeparately} with
     * face set to {@link OOPrimitiveOrientation#FRONT_AND_BACK}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param writeMask Specifies a bit mask to enable and disable writing of individual bits in the stencil planes.
     * Initially, the mask is all {@code 1}'s.
     * 
     * @see #getFrontStencilBufferWriteMask
     * @see #getBackStencilBufferWriteMask
     * @see OOGLES20Implementation#getStencilBits
     * @see #setColorBufferWriteMask
     * @see #setDepthBufferWriteMask
     * @see OOGLES20FragmentProcessing#setStencilFunction
     * @see OOGLES20FragmentProcessing#setStencilFunctionSeparately
     * @see #setStencilBufferWriteMaskSeparately
     * @see OOGLES20FragmentProcessing#setStencilAction
     * @see OOGLES20FragmentProcessing#setStencilActionSeparately
     */
    public void setStencilBufferWriteMask(int writeMask) {
        OOGLES20.backEnd.glStencilMask(writeMask);
    }
    
    /**
     * <p>Control the front and/or back writing of individual bits in the stencil planes.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glStencilMaskSeparate}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setStencilBufferWriteMaskSeparately} controls the writing of individual bits in the stencil planes.
     * The least significant <i>n</i> bits of {@code writeMask}, where <i>n</i> is the number of bits in the stencil
     * buffer, specify a mask. Where a {@code 1} appears in the mask, it's possible to write to the corresponding bit in
     * the stencil buffer. Where a {@code 0} appears, the corresponding bit is write-protected. Initially, all bits are
     * enabled for writing.</p>
     * 
     * <p>There can be two separate {@code writeMask} writemasks; one affects back-facing polygons and the other
     * affects front-facing polygons as well as other non-polygon primitives. {@link #setStencilBufferWriteMask} sets
     * both front and back stencil writemasks to the same values, as if {@link #setStencilBufferWriteMaskSeparately}
     * were called with face set to {@link OOPrimitiveOrientation#FRONT_AND_BACK}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2006 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param face Specifies whether the front and/or back stencil writemask is updated.
     * @param writeMask Specifies a bit mask to enable and disable writing of individual bits in the stencil planes.
     * Initially, the mask is all {@code 1}'s.
     * 
     * @see #getFrontStencilBufferWriteMask
     * @see #getBackStencilBufferWriteMask
     * @see OOGLES20Implementation#getStencilBits
     */
    public void setStencilBufferWriteMaskSeparately(OOPrimitiveOrientation face, int writeMask) {
        OOGLES20.backEnd.glStencilMaskSeparate(face.getGLConstant(), writeMask);
    }
    
    private static ByteBuffer byteBuffer = OOGLES20.createByteBuffer(4);
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(4);
    private static FloatBuffer floatBuffer = OOGLES20.createFloatBuffer(4);
    
    /**
     * <p>Returns whether a capability is enabled.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glIsEnabled} with argument {@link OpenGLES20#GL_BLEND}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, blend the computed fragment color values with the values in the color buffers.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return Whether a capability is enabled.
     * 
     * @see #setBlendingFunction
     */
    public boolean isBlendingEnabled() {
        return OOGLES20.backEnd.glIsEnabled(OpenGLES20.GL_BLEND);
    }
    
    /**
     * <p>Returns an enum constant indicating whether the RGB blend equation is {@link OOBlendingEquation#ADD}, {@link
     * OOBlendingEquation#SUBTRACT} or {@link OOBlendingEquation#REVERSE_SUBTRACT}.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_BLEND_EQUATION_RGB}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an enum constant indicating whether the RGB blend equation is {@link OOBlendingEquation#ADD}, {@link
     * OOBlendingEquation#SUBTRACT} or {@link OOBlendingEquation#REVERSE_SUBTRACT}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return An enum constant indicating whether the RGB blend equation is {@link OOBlendingEquation#ADD}, {@link
     * OOBlendingEquation#SUBTRACT} or {@link OOBlendingEquation#REVERSE_SUBTRACT}.
     * 
     * @see #setBlendingEquationSeparately
     */
    public OOBlendingEquation getBlendingRGBEquation() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_BLEND_EQUATION_RGB, OOGLES20PixelProcessing.intBuffer);
        return OOBlendingEquation.valueOf(OOGLES20PixelProcessing.intBuffer.get(0));
    }
    
    /**
     * <p>Returns an enum constant indicating whether the Alpha blend equation is {@link OOBlendingEquation#ADD}, {@link
     * OOBlendingEquation#SUBTRACT} or {@link OOBlendingEquation#REVERSE_SUBTRACT}.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_BLEND_EQUATION_ALPHA}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an enum constant indicating whether the Alpha blend equation is {@link OOBlendingEquation#ADD}, {@link
     * OOBlendingEquation#SUBTRACT} or {@link OOBlendingEquation#REVERSE_SUBTRACT}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return An enum constant indicating whether the Alpha blend equation is {@link OOBlendingEquation#ADD}, {@link
     * OOBlendingEquation#SUBTRACT} or {@link OOBlendingEquation#REVERSE_SUBTRACT}.
     * 
     * @see #setBlendingEquationSeparately
     */
    public OOBlendingEquation getBlendingAlphaEquation() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_BLEND_EQUATION_ALPHA, OOGLES20PixelProcessing.intBuffer);
        return OOBlendingEquation.valueOf(OOGLES20PixelProcessing.intBuffer.get(0));
    }
    
    /**
     * <p>Returns the enum constant identifying the RGB source blend function.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_BLEND_SRC_RGB}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the enum constant identifying the RGB source blend function. The initial value is {@link
     * OOBlendingSourceFunction#ONE}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The enum constant identifying the RGB source blend function.
     * 
     * @see #setBlendingFunction
     * @see #setBlendingFunctionSeparately
     */
    public OOBlendingSourceFunction getBlendingSourceRGBFunction() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_BLEND_SRC_RGB, OOGLES20PixelProcessing.intBuffer);
        return OOBlendingSourceFunction.valueOf(OOGLES20PixelProcessing.intBuffer.get(0));
    }
    
    /**
     * <p>Returns the enum constant identifying the alpha source blend function.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_BLEND_SRC_ALPHA}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the enum constant identifying the alpha source blend function. The initial value is {@link
     * OOBlendingSourceFunction#ONE}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The enum constant identifying the alpha source blend function.
     * 
     * @see #setBlendingFunction
     * @see #setBlendingFunctionSeparately
     */
    public OOBlendingSourceFunction getBlendingSourceAlphaFunction() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_BLEND_SRC_ALPHA, OOGLES20PixelProcessing.intBuffer);
        return OOBlendingSourceFunction.valueOf(OOGLES20PixelProcessing.intBuffer.get(0));
    }
    
    /**
     * <p>Returns the enum constant identifying the RGB destination blend function.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_BLEND_DST_RGB}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the enum constant identifying the RGB destination blend function. The initial value is {@link
     * OOBlendingDestinationFunction#ZERO}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The enum constant identifying the RGB destination blend function.
     * 
     * @see #setBlendingFunction
     * @see #setBlendingFunctionSeparately
     */
    public OOBlendingDestinationFunction getBlendingDestinationRGBFunction() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_BLEND_DST_RGB, OOGLES20PixelProcessing.intBuffer);
        return OOBlendingDestinationFunction.valueOf(OOGLES20PixelProcessing.intBuffer.get(0));
    }
    
    /**
     * <p>Returns the enum constant identifying the alpha destination blend function.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_BLEND_DST_ALPHA}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the enum constant identifying the alpha destination blend function. The initial value is {@link
     * OOBlendingDestinationFunction#ZERO}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The enum constant identifying the alpha destination blend function.
     * 
     * @see #setBlendingFunction
     * @see #setBlendingFunctionSeparately
     */
    public OOBlendingDestinationFunction getBlendingDestinationAlphaFunction() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_BLEND_DST_ALPHA, OOGLES20PixelProcessing.intBuffer);
        return OOBlendingDestinationFunction.valueOf(OOGLES20PixelProcessing.intBuffer.get(0));
    }
    
    /**
     * <p>Returns a {@link OOColor}: the red, green, blue and alpha values which are the components of the blend color.
     * </p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetFloatv} with argument {@link OpenGLES20#GL_BLEND_COLOR}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a {@link OOColor}: the red, green, blue and alpha values which are the components of the blend color.
     * </p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A {@link OOColor}: the red, green, blue and alpha values which are the components of the blend color.
     * 
     * @see #setBlendingColor
     */
    public OOColor getBlendingColor() {
        OOGLES20.backEnd.glGetFloatv(OpenGLES20.GL_BLEND_COLOR, OOGLES20PixelProcessing.floatBuffer);
        return new OOColor(
                OOGLES20PixelProcessing.floatBuffer.get(0),
                OOGLES20PixelProcessing.floatBuffer.get(1),
                OOGLES20PixelProcessing.floatBuffer.get(2),
                OOGLES20PixelProcessing.floatBuffer.get(3));
    }
    
    /**
     * <p>Returns whether a capability is enabled.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glIsEnabled} with argument {@link OpenGLES20#GL_DITHER}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, dither color components or indices before they are written to the color buffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return Whether a capability is enabled.
     */
    public boolean isDitheringEnabled() {
        return OOGLES20.backEnd.glIsEnabled(OpenGLES20.GL_DITHER);
    }
    
    /**
     * <p>Returns a {@link OOColorBufferWriteMask}: the red, green, blue and alpha write enables for the color buffers.
     * </p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetBooleanv} with argument {@link OpenGLES20#GL_COLOR_WRITEMASK}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a {@link OOColorBufferWriteMask}: the red, green, blue and alpha write enables for the color buffers.
     * The initial value is {@code (true, true, true, true)}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A {@link OOColorBufferWriteMask}: the red, green, blue and alpha write enables for the color buffers.
     * 
     * @see #setColorBufferWriteMask
     */
    public OOColorBufferWriteMask getColorBufferWriteMask() {
        OOGLES20.backEnd.glGetBooleanv(OpenGLES20.GL_COLOR_WRITEMASK, OOGLES20PixelProcessing.byteBuffer.asIntBuffer());
        return new OOColorBufferWriteMask(
                OOGLES20PixelProcessing.byteBuffer.get(0) != 0,
                OOGLES20PixelProcessing.byteBuffer.get(1) != 0,
                OOGLES20PixelProcessing.byteBuffer.get(2) != 0,
                OOGLES20PixelProcessing.byteBuffer.get(3) != 0);
    }
    
    /**
     * <p>Returns a boolean value indicating if the depth buffer is enabled for writing.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetBooleanv} with argument {@link OpenGLES20#GL_DEPTH_WRITEMASK}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a boolean value indicating if the depth buffer is enabled for writing. The initial value is {@code
     * true}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A boolean value indicating if the depth buffer is enabled for writing.
     * 
     * @see #setDepthBufferWriteMask
     */
    public boolean getDepthBufferWriteMask() {
        OOGLES20.backEnd.glGetBooleanv(OpenGLES20.GL_DEPTH_WRITEMASK, OOGLES20PixelProcessing.byteBuffer.asIntBuffer());
        return OOGLES20PixelProcessing.byteBuffer.get(0) != 0;
    }
    
    /**
     * <p>Returns the mask that controls writing of the stencil bitplanes for front-facing polygons and non-polygons.
     * </p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_WRITEMASK}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the mask that controls writing of the stencil bitplanes for front-facing polygons and non-polygons.
     * The initial value is all {@code 1}'s.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The mask that controls writing of the stencil bitplanes for front-facing polygons and non-polygons.
     * 
     * @see #setStencilBufferWriteMask
     * @see #setStencilBufferWriteMaskSeparately
     */
    public int getFrontStencilBufferWriteMask() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_WRITEMASK, OOGLES20PixelProcessing.intBuffer);
        return OOGLES20PixelProcessing.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the mask that controls writing of the stencil bitplanes for back-facing polygons.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_BACK_WRITEMASK}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the mask that controls writing of the stencil bitplanes for back-facing polygons. The initial value is
     * all {@code 1}'s.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The mask that controls writing of the stencil bitplanes for back-facing polygons.
     * 
     * @see #setStencilBufferWriteMaskSeparately
     */
    public int getBackStencilBufferWriteMask() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_BACK_WRITEMASK, OOGLES20PixelProcessing.intBuffer);
        return OOGLES20PixelProcessing.intBuffer.get(0);
    }
}
