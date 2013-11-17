package ro.spatarel.android.oogles20;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * <p>Class grouping together the methods managing the fragment processing pipeline stage.</p>
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
public class OOGLES20FragmentProcessing {
    
    OOGLES20FragmentProcessing() {
        // There is nothing here.
    }
    
    /**
     * <p>If enabled, discard fragments that are outside the scissor rectangle.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glEnable} with argument {@link OpenGLES20#GL_SCISSOR_TEST}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, discard fragments that are outside the scissor rectangle.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #setScissorBox
     */
    public void enableScissorTest() {
        OOGLES20.backEnd.glEnable(OpenGLES20.GL_SCISSOR_TEST);
    }
    
    /**
     * <p>Define the scissor box.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glScissor}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@code #setScissorBox} defines a rectangle, called the scissor box, in window coordinates. The first two
     * arguments, {@code x} and {@code y}, specify the lower left corner of the box. {@code width} and {@code height}
     * specify the width and height of the box.</p>
     * 
     * <p>To enable and disable the scissor test, call {@link #enableScissorTest} and {@link #disableScissorTest}. The
     * test is initially disabled. While the test is enabled, only pixels that lie within the scissor box can be
     * modified by drawing commands. Window coordinates have integer values at the shared corners of frame buffer
     * pixels. {@code setScissorBox(0, 0, 1, 1)} allows modification of only the lower left pixel in the window and
     * {@code setScissorBox(0, 0, 0, 0)} doesn't allow modification of any pixels in the window.</p>
     * 
     * <p>When the scissor test is disabled, it is as though the scissor box includes the entire window.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_VALUE} is generated if either {@code width} or {@code height} is negative.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param x Specify the lower left corner of the scissor box. Initially {@code (0, 0)}.
     * @param y Specify the lower left corner of the scissor box. Initially {@code (0, 0)}.
     * @param width Specify the width and height of the scissor box. When a GL context is first attached to a window,
     * {@code width} and {@code height} are set to the dimensions of that window.
     * @param height Specify the width and height of the scissor box. When a GL context is first attached to a window,
     * {@code width} and {@code height} are set to the dimensions of that window.
     * 
     * @see #getScissorBox
     * @see #isScissorTestEnabled
     * @see #enableScissorTest
     * @see OOGLES20PrimitiveProcessing#setViewport
     */
    public void setScissorBox(int x, int y, int width, int height) {
        OOGLES20.backEnd.glScissor(x, y, width, height);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setScissorBox(scissorBox.x, scissorBox.y, scissorBox.width, scissorBox.height);}.</p>
     * 
     * @param scissorBox Specify the lower left corner, the width and the height of the scissor box.
     * 
     * @see #setScissorBox
     */
    public void setScissorBox(OORegion scissorBox) {
        this.setScissorBox(scissorBox.x, scissorBox.y, scissorBox.width, scissorBox.height);
    }
    
    /**
     * <p>If enabled, discard fragments that are outside the scissor rectangle.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDisable} with argument {@link OpenGLES20#GL_SCISSOR_TEST}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, discard fragments that are outside the scissor rectangle.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #setScissorBox
     */
    public void disableScissorTest() {
        OOGLES20.backEnd.glDisable(OpenGLES20.GL_SCISSOR_TEST);
    }
    
    /**
     * <p>If enabled, compute a temporary coverage value where each bit is determined by the alpha value at the
     * corresponding sample location.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glEnable} with argument {@link OpenGLES20#GL_SAMPLE_ALPHA_TO_COVERAGE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, compute a temporary coverage value where each bit is determined by the alpha value at the
     * corresponding sample location. The temporary coverage value is then ANDed with the fragment coverage value.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    public void enableSampleAlphaToCoverage() {
        OOGLES20.backEnd.glEnable(OpenGLES20.GL_SAMPLE_ALPHA_TO_COVERAGE);
    }
    
    /**
     * <p>If enabled, compute a temporary coverage value where each bit is determined by the alpha value at the
     * corresponding sample location.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDisable} with argument {@link OpenGLES20#GL_SAMPLE_ALPHA_TO_COVERAGE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, compute a temporary coverage value where each bit is determined by the alpha value at the
     * corresponding sample location. The temporary coverage value is then ANDed with the fragment coverage value.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    public void disableSampleAlphaToCoverage() {
        OOGLES20.backEnd.glDisable(OpenGLES20.GL_SAMPLE_ALPHA_TO_COVERAGE);
    }
    
    /**
     * <p>If enabled, the fragment's coverage is ANDed with the temporary coverage value.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glEnable} with argument {@link OpenGLES20#GL_SAMPLE_COVERAGE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, the fragment's coverage is ANDed with the temporary coverage value. If {@link
     * OpenGLES20#GL_SAMPLE_COVERAGE_INVERT} is set to {@code true}, invert the coverage value.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #setSampleCoverage
     */
    public void enableSampleCoverage() {
        OOGLES20.backEnd.glEnable(OpenGLES20.GL_SAMPLE_COVERAGE);
    }
    
    /**
     * <p>Specify multisample coverage parameters.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glSampleCoverage}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Multisampling samples a pixel multiple times at various implementation-dependent subpixel locations to
     * generate antialiasing effects. Multisampling transparently antialiases points, lines and polygons if it is
     * enabled.</p>
     * 
     * <p>{@code value} is used in constructing a temporary mask used in determining which samples will be used in
     * resolving the final fragment color. This mask is bitwise-anded with the coverage mask generated from the
     * multisampling computation. If the {@code inverted} flag is set, the temporary mask is inverted (all bits flipped)
     * and then the bitwise-and is computed.</p>
     * 
     * <p>If an implementation does not have any multisample buffers available or multisampling is disabled,
     * rasterization occurs with only a single sample computing a pixel's final RGB color.</p>
     * 
     * <p>Provided an implementation supports multisample buffers and multisampling is enabled, then a pixel's final
     * color is generated by combining several samples per pixel. Each sample contains color, depth and stencil
     * information, allowing those operations to be performed on each sample.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param value Specify a single floating-point sample coverage value. The value is clamped to the range {@code
     * [0, 1]}. The initial value is {@code 1.0}.
     * @param inverted Specify a single boolean value representing if the coverage masks should be inverted. The initial
     * value is {@code false}.
     * 
     * @see #getSampleCoverageValue
     * @see #isSampleCoverageInverted
     * @see #isSampleAlphaToCoverageEnabled
     * @see #isSampleCoverageEnabled
     * @see #enableSampleAlphaToCoverage
     * @see #enableSampleCoverage
     */
    public void setSampleCoverage(float value, boolean inverted) {
        OOGLES20.backEnd.glSampleCoverage(value, inverted);
    }
    
    /**
     * <p>If enabled, the fragment's coverage is ANDed with the temporary coverage value.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDisable} with argument {@link OpenGLES20#GL_SAMPLE_COVERAGE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, the fragment's coverage is ANDed with the temporary coverage value. If {@link
     * OpenGLES20#GL_SAMPLE_COVERAGE_INVERT} is set to {@code true}, invert the coverage value.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #setSampleCoverage
     */
    public void disableSampleCoverage() {
        OOGLES20.backEnd.glDisable(OpenGLES20.GL_SAMPLE_COVERAGE);
    }
    
    /**
     * <p>If enabled, do stencil testing and update the stencil buffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glEnable} with argument {@link OpenGLES20#GL_STENCIL_TEST}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, do stencil testing and update the stencil buffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #setStencilFunction
     * @see #setStencilAction
     */
    public void enableStencilTest() {
        OOGLES20.backEnd.glEnable(OpenGLES20.GL_STENCIL_TEST);
    }
    
    /**
     * <p>Set front and back function and reference value for stencil testing.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glStencilFunc}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Stenciling, like depth-buffering, enables and disables drawing on a per-pixel basis. Stencil planes are first
     * drawn into using GL drawing primitives, then geometry and images are rendered using the stencil planes to mask
     * out portions of the screen. Stenciling is typically used in multipass rendering algorithms to achieve special
     * effects, such as decals, outlining and constructive solid geometry rendering.</p>
     * 
     * <p>The stencil test conditionally eliminates a pixel based on the outcome of a comparison between the reference
     * value and the value in the stencil buffer. To enable and disable the test, call {@link #enableStencilTest} and
     * {@link #disableStencilTest}. To specify actions based on the outcome of the stencil test, call {@link
     * #setStencilAction} or {@link #setStencilActionSeparately}.</p>
     * 
     * <p>There can be two separate sets of {@code function}, {@code referenceValue} and {@code mask} parameters; one
     * affects back-facing polygons and the other affects front-facing polygons as well as other non-polygon
     * primitives. {@link #setStencilFunction} sets both front and back stencil state to the same values. Use {@link
     * #setStencilFunctionSeparately} to set front and back stencil state to different values.</p>
     * 
     * <p>{@code function} is an enum constant that determines the stencil comparison function. It accepts one of eight
     * values, shown in the following list. {@code referenceValue} is an integer reference value that is used in the
     * stencil comparison. It is clamped to the range {@code [0, 2^n - 1]}, where {@code n} is the number of bitplanes
     * in the stencil buffer. {@code mask} is bitwise ANDed with both the reference value and the stored stencil value,
     * with the ANDed values participating in the comparison.</p>
     * 
     * <p>If {@code stencil} represents the value stored in the corresponding stencil buffer location, the following
     * list shows the effect of each comparison function that can be specified by {@code function}. Only if the
     * comparison succeeds is the pixel passed through to the next stage in the rasterization process (see {@link
     * #setStencilAction}). All tests treat {@code stencil} values as unsigned integers in the range {@code
     * [0, 2^n - 1]}, where {@code n} is the number of bitplanes in the stencil buffer.</p>
     * 
     * <p>The following values are accepted by {@code function}:</p>
     * 
     * <dl>
     *     <dt>{@link OOStencilTestFunction#NEVER}</dt>
     *         <dd>Always fails.</dd>
     *     <dt>{@link OOStencilTestFunction#LESS}</dt>
     *         <dd>Passes if {@code (referenceValue & mask) < (stencil & mask)}.</dd>
     *     <dt>{@link OOStencilTestFunction#LESS_OR_EQUAL}</dt>
     *         <dd>Passes if {@code (referenceValue & mask) <= (stencil & mask)}.</dd>
     *     <dt>{@link OOStencilTestFunction#GREATER}</dt>
     *         <dd>Passes if {@code (referenceValue & mask) > (stencil & mask)}.</dd>
     *     <dt>{@link OOStencilTestFunction#GREATER_OR_EQUAL}</dt>
     *         <dd>Passes if {@code (referenceValue & mask) >= (stencil & mask)}.</dd>
     *     <dt>{@link OOStencilTestFunction#EQUAL}</dt>
     *         <dd>Passes if {@code (referenceValue & mask) == (stencil & mask)}.</dd>
     *     <dt>{@link OOStencilTestFunction#NOT_EQUAL}</dt>
     *         <dd>Passes if {@code (referenceValue & mask) != (stencil & mask)}.</dd>
     *     <dt>{@link OOStencilTestFunction#ALWAYS}</dt>
     *         <dd>Always passes.</dd>
     * </dl>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Initially, the stencil test is disabled. If there is no stencil buffer, no stencil modification can occur and
     * it is as if the stencil test always passes.</p>
     * 
     * {@link #setStencilFunction} is the same as calling {@link #setStencilFunctionSeparately} with {@code face} set to
     * {@link OOPrimitiveOrientation#FRONT_AND_BACK}.
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param function Specifies the test function. The initial value is {@code OOStencilFunction#ALWAYS}.
     * @param referenceValue Specifies the reference value for the stencil test. {@code referenceValue} is clamped to
     * the range {@code [0, 2^n - 1]}, where {@code n} is the number of bitplanes in the stencil buffer. The initial
     * value is {@code 0}.
     * @param mask Specifies a mask that is ANDed with both the reference value and the stored stencil value when the
     * test is done. The initial value is all {@code 1}'s.
     * 
     * @see #getFrontStencilFunction
     * @see #getFrontStencilMask
     * @see #getFrontStencilReferenceValue
     * @see #getBackStencilFunction
     * @see #getBackStencilMask
     * @see #getBackStencilReferenceValue
     * @see OOGLES20Implementation#getStencilBits
     * @see #isStencilTestEnabled
     * @see OOGLES20PixelProcessing#setBlendingFunction
     * @see #setDepthTestFunction
     * @see #enableStencilTest
     * @see #setStencilFunctionSeparately
     * @see OOGLES20PixelProcessing#setStencilBufferWriteMask
     * @see OOGLES20PixelProcessing#setStencilBufferWriteMaskSeparately
     * @see #setStencilAction
     * @see #setStencilActionSeparately
     */
    public void setStencilFunction(OOStencilTestFunction function, int referenceValue, int mask) {
        OOGLES20.backEnd.glStencilFunc(function.getGLConstant(), referenceValue, mask);
    }
    
    /**
     * <p>Set front and/or back function and reference value for stencil testing.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glStencilFuncSeparate}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Stenciling, like depth-buffering, enables and disables drawing on a per-pixel basis. You draw into the stencil
     * planes using GL drawing primitives, then render geometry and images, using the stencil planes to mask out
     * portions of the screen. Stenciling is typically used in multipass rendering algorithms to achieve special
     * effects, such as decals, outlining and constructive solid geometry rendering.
     * 
     * <p>The stencil test conditionally eliminates a pixel based on the outcome of a comparison between the reference
     * value and the value in the stencil buffer. To enable and disable the test, call {@link #enableStencilTest} and
     * {@link #disableStencilTest}. To specify actions based on the outcome of the stencil test, call {@link
     * #setStencilAction} or {@link #setStencilActionSeparately}.</p>
     * 
     * <p>There can be two separate sets of {@code function}, {@code referenceValue} and {@code mask} parameters; one
     * affects back-facing polygons and the other affects front-facing polygons as well as other non-polygon
     * primitives. {@link #setStencilFunction} sets both front and back stencil state to the same values, as if {@link
     * #setStencilFunctionSeparately} were called with face set to {@link OOPrimitiveOrientation#FRONT_AND_BACK}.</p>
     * 
     * <p>{@code function} is an enum constant that determines the stencil comparison function. It accepts one of eight
     * values, shown in the following list. {@code referenceValue} is an integer reference value that is used in the
     * stencil comparison. It is clamped to the range {@code [0, 2^n - 1]}, where {@code n} is the number of bitplanes
     * in the stencil buffer. {@code mask} is bitwise ANDed with both the reference value and the stored stencil value,
     * with the ANDed values participating in the comparison.</p>
     * 
     * <p>If {@code stencil} represents the value stored in the corresponding stencil buffer location, the following
     * list shows the effect of each comparison function that can be specified by {@code function}. Only if the
     * comparison succeeds is the pixel passed through to the next stage in the rasterization process (see {@link
     * #setStencilAction}). All tests treat {@code stencil} values as unsigned integers in the range {@code
     * [0, 2^n - 1]}, where {@code n} is the number of bitplanes in the stencil buffer.</p>
     * 
     * <p>The following values are accepted by {@code function}:</p>
     * 
     * <dl>
     *     <dt>{@link OOStencilTestFunction#NEVER}</dt>
     *         <dd>Always fails.</dd>
     *     <dt>{@link OOStencilTestFunction#LESS}</dt>
     *         <dd>Passes if {@code (referenceValue & mask) < (stencil & mask)}.</dd>
     *     <dt>{@link OOStencilTestFunction#LESS_OR_EQUAL}</dt>
     *         <dd>Passes if {@code (referenceValue & mask) <= (stencil & mask)}.</dd>
     *     <dt>{@link OOStencilTestFunction#GREATER}</dt>
     *         <dd>Passes if {@code (referenceValue & mask) > (stencil & mask)}.</dd>
     *     <dt>{@link OOStencilTestFunction#GREATER_OR_EQUAL}</dt>
     *         <dd>Passes if {@code (referenceValue & mask) >= (stencil & mask)}.</dd>
     *     <dt>{@link OOStencilTestFunction#EQUAL}</dt>
     *         <dd>Passes if {@code (referenceValue & mask) == (stencil & mask)}.</dd>
     *     <dt>{@link OOStencilTestFunction#NOT_EQUAL}</dt>
     *         <dd>Passes if {@code (referenceValue & mask) != (stencil & mask)}.</dd>
     *     <dt>{@link OOStencilTestFunction#ALWAYS}</dt>
     *         <dd>Always passes.</dd>
     * </dl>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Initially, the stencil test is disabled. If there is no stencil buffer, no stencil modification can occur and
     * it is as if the stencil test always passes.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2006 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param face Specifies whether front and/or back stencil state is updated.
     * @param function Specifies the test function. The initial value is {@code OOStencilFunction#ALWAYS}.
     * @param referenceValue Specifies the reference value for the stencil test. {@code referenceValue} is clamped to
     * the range {@code [0, 2^n - 1]}, where {@code n} is the number of bitplanes in the stencil buffer. The initial
     * value is {@code 0}.
     * @param mask Specifies a mask that is ANDed with both the reference value and the stored stencil value when the
     * test is done. The initial value is all {@code 1}'s.
     * 
     * @see #getFrontStencilFunction
     * @see #getFrontStencilMask
     * @see #getFrontStencilReferenceValue
     * @see #getBackStencilFunction
     * @see #getBackStencilMask
     * @see #getBackStencilReferenceValue
     * @see OOGLES20Implementation#getStencilBits
     * @see #isStencilTestEnabled
     * @see OOGLES20PixelProcessing#setBlendingFunction
     * @see #setDepthTestFunction
     * @see #enableStencilTest
     * @see #setStencilFunction
     * @see OOGLES20PixelProcessing#setStencilBufferWriteMask
     * @see OOGLES20PixelProcessing#setStencilBufferWriteMaskSeparately
     * @see #setStencilAction
     * @see #setStencilActionSeparately
     */
    public void setStencilFunctionSeparately(OOPrimitiveOrientation face, OOStencilTestFunction function,
            int referenceValue, int mask) {
        OOGLES20.backEnd.glStencilFuncSeparate(face.getGLConstant(), function.getGLConstant(), referenceValue, mask);
    }
    
    /**
     * <p>If enabled, do stencil testing and update the stencil buffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDisable} with argument {@link OpenGLES20#GL_STENCIL_TEST}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, do stencil testing and update the stencil buffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #setStencilFunction
     * @see #setStencilAction
     */
    public void disableStencilTest() {
        OOGLES20.backEnd.glDisable(OpenGLES20.GL_STENCIL_TEST);
    }
    
    /**
     * <p>If enabled, do depth comparisons and update the depth buffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glEnable} with argument {@link OpenGLES20#GL_DEPTH_TEST}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, do depth comparisons and update the depth buffer. Note that even if the depth buffer exists and
     * the depth mask is non-zero, the depth buffer is not updated if the depth test is disabled.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #setDepthTestFunction
     * @see OOGLES20PrimitiveProcessing#setDepthRange
     */
    public void enableDepthTest() {
        OOGLES20.backEnd.glEnable(OpenGLES20.GL_DEPTH_TEST);
    }
    
    /**
     * <p>Specify the value used for depth buffer comparisons.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDepthFunc}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setDepthTestFunction} specifies the function used to compare each incoming pixel depth value with the
     * depth value present in the depth buffer. The comparison is performed only if depth testing is enabled. (See
     * {@link #enableDepthTest} and {@link #disableDepthTest}.)</p>
     * 
     * <p>{@code function} specifies the conditions under which the pixel will be drawn. The comparison functions are as
     * follows:</p>
     * 
     * <dl>
     *     <dt>{@link OODepthTestFunction#NEVER}</dt>
     *         <dd>Never passes.</dd>
     *     <dt>{@link OODepthTestFunction#LESS}</dt>
     *         <dd>Passes if the incoming depth value is less than the stored depth value.</dd>
     *     <dt>{@link OODepthTestFunction#EQUAL}</dt>
     *         <dd>Passes if the incoming depth value is equal to the stored depth value.</dd>
     *     <dt>{@link OODepthTestFunction#LESS_OR_EQUAL}</dt>
     *         <dd>Passes if the incoming depth value is less than or equal to the stored depth value.</dd>
     *     <dt>{@link OODepthTestFunction#GREATER}</dt>
     *         <dd>Passes if the incoming depth value is greater than the stored depth value.</dd>
     *     <dt>{@link OODepthTestFunction#NOT_EQUAL}</dt>
     *         <dd>Passes if the incoming depth value is not equal to the stored depth value.</dd>
     *     <dt>{@link OODepthTestFunction#GREATER_OR_EQUAL}</dt>
     *         <dd>Passes if the incoming depth value is greater than or equal to the stored depth value.</dd>
     *     <dt>{@link OODepthTestFunction#ALWAYS}</dt>
     *         <dd>Always passes.</dd>
     * </dl>
     * 
     * <p>The initial value of {@code function} is {@link OODepthTestFunction#LESS}. Initially, depth testing is
     * disabled. If depth testing is disabled or no depth buffer exists, it is as if the depth test always passes.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Even if the depth buffer exists and the depth mask is non-zero, the depth buffer is not updated if the depth
     * test is disabled.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param function Specifies the depth comparison function. The initial value is {@link OODepthTestFunction#LESS}.
     * 
     * @see OOGLES20PrimitiveProcessing#setDepthRange
     * @see #enableDepthTest
     * @see #isDepthTestEnabled
     * @see #disableDepthTest
     * @see OOGLES20Rasterization#setPolygonOffset
     */
    public void setDepthTestFunction(OODepthTestFunction function) {
        OOGLES20.backEnd.glDepthFunc(function.getGLConstant());
    }
    
    /**
     * <p>If enabled, do depth comparisons and update the depth buffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDisable} with argument {@link OpenGLES20#GL_DEPTH_TEST}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, do depth comparisons and update the depth buffer. Note that even if the depth buffer exists and
     * the depth mask is non-zero, the depth buffer is not updated if the depth test is disabled.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #setDepthTestFunction
     * @see OOGLES20PrimitiveProcessing#setDepthRange
     */
    public void disableDepthTest() {
        OOGLES20.backEnd.glDisable(OpenGLES20.GL_DEPTH_TEST);
    }
    
    /**
     * <p>Set front and back stencil test actions.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glStencilOp}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Stenciling, like depth-buffering, enables and disables drawing on a per-pixel basis. You draw into the stencil
     * planes using GL drawing primitives, then render geometry and images, using the stencil planes to mask out
     * portions of the screen. Stenciling is typically used in multipass rendering algorithms to achieve special
     * effects, such as decals, outlining and constructive solid geometry rendering.</p>
     * 
     * <p>The stencil test conditionally eliminates a pixel based on the outcome of a comparison between the value in
     * the stencil buffer and a reference value. To enable and disable the test, call {@link #enableStencilTest} and
     * {@link #disableStencilTest}; to control it, call {@link #setStencilFunction} or {@link
     * #setStencilFunctionSeparately}.</p>
     * 
     * <p>There can be two separate sets of {@code stencilTestFails}, {@code depthTestFails} and {@code bothTestsPass}
     * parameters; one affects back-facing polygons and the other affects front-facing polygons as well as other
     * non-polygon primitives. {@link #setStencilAction} sets both front and back stencil state to the same values. Use
     * {@link #setStencilActionSeparately} to set front and back stencil state to different values.</p>
     * 
     * <p>{@link #setStencilAction} takes three arguments that indicate what happens to the stored stencil value while
     * stenciling is enabled. If the stencil test fails, no change is made to the pixel's color or depth buffers and
     * {@code stencilTestFails} specifies what happens to the stencil buffer contents. The following eight actions are
     * possible.</p>
     * 
     * <dl>
     *     <dt>{@link OOStencilAction#KEEP}</dt>
     *         <dd>Keeps the current value.</dd>
     *     <dt>{@link OOStencilAction#ZERO}</dt>
     *         <dd>Sets the stencil buffer value to 0.</dd>
     *     <dt>{@link OOStencilAction#REPLACE}</dt>
     *         <dd>Sets the stencil buffer value to {@code referenceValue}, as specified by {@link
     *         #setStencilFunction}.</dd>
     *     <dt>{@link OOStencilAction#INCREMENT}</dt>
     *         <dd>Increments the current stencil buffer value. Clamps to the maximum representable unsigned value.</dd>
     *     <dt>{@link OOStencilAction#INCREMENT_WRAP}</dt>
     *         <dd>Increments the current stencil buffer value. Wraps stencil buffer value to zero when incrementing the
     *         maximum representable unsigned value.</dd>
     *     <dt>{@link OOStencilAction#DECREMENT}</dt>
     *         <dd>Decrements the current stencil buffer value. Clamps to {@code 0}.</dd>
     *     <dt>{@link OOStencilAction#DECREMENT_WRAP}</dt>
     *         <dd>Decrements the current stencil buffer value. Wraps stencil buffer value to the maximum representable
     *         unsigned value when decrementing a stencil buffer value of zero.</dd>
     *     <dt>{@link OOStencilAction#INVERT}</dt>
     *         <dd>Bitwise inverts the current stencil buffer value.</dd>
     * </dl>
     * 
     * <p>Stencil buffer values are treated as unsigned integers. When incremented and decremented, values are clamped
     * to {@code 0} and {@code 2^n - 1}, where <i>n</i> is the value returned by querying {@link
     * OOGLES20Implementation#getStencilBits}.</p>
     * 
     * <p>The other two arguments to {@link #setStencilAction} specify stencil buffer actions that depend on whether
     * subsequent depth buffer tests succeed ({@code bothTestsPass}) or fail ({@code depthTestFails}) (see {@link
     * #setDepthTestFunction}). Note that {@code depthTestFails} is ignored when there is no depth buffer or when the
     * depth buffer is not enabled. In these cases, {@code stencilTestFails} and {@code bothTestsPass} specify stencil
     * action when the stencil test fails and passes, respectively.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Initially the stencil test is disabled. If there is no stencil buffer, no stencil modification can occur and
     * it is as if the stencil tests always pass, regardless of any call to {@link #setStencilAction}.</p>
     * 
     * <p>{@link #setStencilAction} is the same as calling {@link #setStencilActionSeparately} with {@code face} set to
     * {@link OOPrimitiveOrientation#FRONT_AND_BACK}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param stencilTestFails Specifies the action to take when the stencil test fails. The initial value is {@link
     * OOStencilAction#KEEP}.
     * @param depthTestFails Specifies the stencil action when the stencil test passes, but the depth test fails. The
     * initial value is {@link OOStencilAction#KEEP}.
     * @param bothTestsPass Specifies the stencil action when both the stencil test and the depth test pass or when the
     * stencil test passes and either there is no depth buffer or depth testing is not enabled. The initial value is
     * {@link OOStencilAction#KEEP}.
     * 
     * @see #getFrontStencilFailAction
     * @see #getFrontStencilPassDepthPassAction
     * @see #getFrontStencilPassDepthFailAction
     * @see #getBackStencilFailAction
     * @see #getBackStencilPassDepthPassAction
     * @see #getBackStencilPassDepthFailAction
     * @see OOGLES20Implementation#getStencilBits
     * @see #isStencilTestEnabled
     * @see OOGLES20PixelProcessing#setBlendingFunction
     * @see #setDepthTestFunction
     * @see #enableStencilTest
     * @see #setStencilFunction
     * @see #setStencilFunctionSeparately
     * @see OOGLES20PixelProcessing#setStencilBufferWriteMask
     * @see OOGLES20PixelProcessing#setStencilBufferWriteMaskSeparately
     * @see #setStencilActionSeparately
     */
    public void setStencilAction(OOStencilAction stencilTestFails, OOStencilAction depthTestFails,
            OOStencilAction bothTestsPass) {
        OOGLES20.backEnd.glStencilOp(stencilTestFails.getGLConstant(), depthTestFails.getGLConstant(),
                bothTestsPass.getGLConstant());
    }
    
    /**
     * <p>Set front and/or back stencil test actions.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glStencilOpSeparate}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Stenciling, like depth-buffering, enables and disables drawing on a per-pixel basis. You draw into the stencil
     * planes using GL drawing primitives, then render geometry and images, using the stencil planes to mask out
     * portions of the screen. Stenciling is typically used in multipass rendering algorithms to achieve special
     * effects, such as decals, outlining and constructive solid geometry rendering.</p>
     * 
     * <p>The stencil test conditionally eliminates a pixel based on the outcome of a comparison between the value in
     * the stencil buffer and a reference value. To enable and disable the test, call {@link #enableStencilTest} and
     * {@link #disableStencilTest}; to control it, call {@link #setStencilFunction} or {@link
     * #setStencilFunctionSeparately}.</p>
     * 
     * <p>There can be two separate sets of {@code stencilTestFails}, {@code depthTestFails} and {@code bothTestsPass}
     * parameters; one affects back-facing polygons and the other affects front-facing polygons as well as other
     * non-polygon primitives. {@link #setStencilAction} sets both front and back stencil state to the same values, as
     * if {@link #setStencilActionSeparately} were called with face set to {@link
     * OOPrimitiveOrientation#FRONT_AND_BACK}.</p>
     * 
     * <p>{@link #setStencilActionSeparately} takes three arguments that indicate what happens to the stored stencil
     * value while stenciling is enabled. If the stencil test fails, no change is made to the pixel's color or depth
     * buffers and {@code stencilTestFails} specifies what happens to the stencil buffer contents. The following eight
     * actions are possible.</p>
     * 
     * <dl>
     *     <dt>{@link OOStencilAction#KEEP}</dt>
     *         <dd>Keeps the current value.</dd>
     *     <dt>{@link OOStencilAction#ZERO}</dt>
     *         <dd>Sets the stencil buffer value to 0.</dd>
     *     <dt>{@link OOStencilAction#REPLACE}</dt>
     *         <dd>Sets the stencil buffer value to {@code referenceValue}, as specified by {@link
     *         #setStencilFunction}.</dd>
     *     <dt>{@link OOStencilAction#INCREMENT}</dt>
     *         <dd>Increments the current stencil buffer value. Clamps to the maximum representable unsigned value.</dd>
     *     <dt>{@link OOStencilAction#INCREMENT_WRAP}</dt>
     *         <dd>Increments the current stencil buffer value. Wraps stencil buffer value to zero when incrementing the
     *         maximum representable unsigned value.</dd>
     *     <dt>{@link OOStencilAction#DECREMENT}</dt>
     *         <dd>Decrements the current stencil buffer value. Clamps to {@code 0}.</dd>
     *     <dt>{@link OOStencilAction#DECREMENT_WRAP}</dt>
     *         <dd>Decrements the current stencil buffer value. Wraps stencil buffer value to the maximum representable
     *         unsigned value when decrementing a stencil buffer value of zero.</dd>
     *     <dt>{@link OOStencilAction#INVERT}</dt>
     *         <dd>Bitwise inverts the current stencil buffer value.</dd>
     * </dl>
     * 
     * <p>Stencil buffer values are treated as unsigned integers. When incremented and decremented, values are clamped
     * to {@code 0} and {@code 2^n - 1}, where <i>n</i> is the value returned by querying {@link
     * OOGLES20Implementation#getStencilBits}.</p>
     * 
     * <p>The other two arguments to {@link #setStencilActionSeparately} specify stencil buffer actions that depend on
     * whether subsequent depth buffer tests succeed ({@code bothTestsPass}) or fail ({@code depthTestFails}) (see
     * {@link #setDepthTestFunction}). Note that {@code depthTestFails} is ignored when there is no depth buffer or
     * when the depth buffer is not enabled. In these cases, {@code stencilTestFails} and {@code bothTestsPass} specify
     * stencil action when the stencil test fails and passes, respectively.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Initially the stencil test is disabled. If there is no stencil buffer, no stencil modification can occur and
     * it is as if the stencil test always passes.</p>
     * 
     * <p>{@link #setStencilAction} is the
     * same as calling {@link #setStencilActionSeparately} with {@code face} set to {@link
     * OOPrimitiveOrientation#FRONT_AND_BACK}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2006 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param face Specifies whether front and/or back stencil state is updated.
     * @param stencilTestFails Specifies the action to take when the stencil test fails. The initial value is {@link
     * OOStencilAction#KEEP}.
     * @param depthTestFails Specifies the stencil action when the stencil test passes, but the depth test fails. The
     * initial value is {@link OOStencilAction#KEEP}.
     * @param bothTestsPass Specifies the stencil action when both the stencil test and the depth test pass or when the
     * stencil test passes and either there is no depth buffer or depth testing is not enabled. The initial value is
     * {@link OOStencilAction#KEEP}.
     * 
     * @see #getFrontStencilFailAction
     * @see #getFrontStencilPassDepthPassAction
     * @see #getFrontStencilPassDepthFailAction
     * @see #getBackStencilFailAction
     * @see #getBackStencilPassDepthPassAction
     * @see #getBackStencilPassDepthFailAction
     * @see OOGLES20Implementation#getStencilBits
     * @see #isStencilTestEnabled
     * @see OOGLES20PixelProcessing#setBlendingFunction
     * @see #setDepthTestFunction
     * @see #enableStencilTest
     * @see #setStencilFunction
     * @see #setStencilFunctionSeparately
     * @see OOGLES20PixelProcessing#setStencilBufferWriteMask
     * @see OOGLES20PixelProcessing#setStencilBufferWriteMaskSeparately
     * @see #setStencilAction
     */
    public void setStencilActionSeparately(OOPrimitiveOrientation face, OOStencilAction stencilTestFails,
            OOStencilAction depthTestFails, OOStencilAction bothTestsPass) {
        OOGLES20.backEnd.glStencilOpSeparate(face.getGLConstant(), stencilTestFails.getGLConstant(),
                depthTestFails.getGLConstant(), bothTestsPass.getGLConstant());
    }
    
    private static ByteBuffer byteBuffer = OOGLES20.createByteBuffer(4);
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(4);
    private static FloatBuffer floatBuffer = OOGLES20.createFloatBuffer(1);
    
    /**
     * <p>Returns whether a capability is enabled.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glIsEnabled} with argument {@link OpenGLES20#GL_SCISSOR_TEST}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, discard fragments that are outside the scissor rectangle.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return Whether a capability is enabled.
     * 
     * @see #setScissorBox
     */
    public boolean isScissorTestEnabled() {
        return OOGLES20.backEnd.glIsEnabled(OpenGLES20.GL_SCISSOR_TEST);
    }
    
    /**
     * <p>Returns a {@link OORegion}: the {@code x} and {@code y} window coordinates of the scissor box and its {@code
     * width} and {@code height}.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_SCISSOR_BOX}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a {@link OORegion}: the {@code x} and {@code y} window coordinates of the scissor box and its {@code
     * width} and {@code height}. Initially the {@code x} and {@code y} window coordinates are both {@code 0} and the
     * {@code width} and {@code height} are set to the size of the window.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A {@link OORegion}: the {@code x} and {@code y} window coordinates of the scissor box and its {@code
     * width} and {@code height}.
     * 
     * @see #setScissorBox
     */
    public OORegion getScissorBox() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_SCISSOR_BOX, OOGLES20FragmentProcessing.intBuffer);
        return new OORegion(
                OOGLES20FragmentProcessing.intBuffer.get(0),
                OOGLES20FragmentProcessing.intBuffer.get(1),
                OOGLES20FragmentProcessing.intBuffer.get(2),
                OOGLES20FragmentProcessing.intBuffer.get(3));
    }
    
    /**
     * <p>Returns whether a capability is enabled.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glIsEnabled} with argument {@link OpenGLES20#GL_SAMPLE_ALPHA_TO_COVERAGE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, compute a temporary coverage value where each bit is determined by the alpha value at the
     * corresponding sample location. The temporary coverage value is then ANDed with the fragment coverage value.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return Whether a capability is enabled.
     */
    public boolean isSampleAlphaToCoverageEnabled() {
        return OOGLES20.backEnd.glIsEnabled(OpenGLES20.GL_SAMPLE_ALPHA_TO_COVERAGE);
    }
    
    /**
     * <p>Returns whether a capability is enabled.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glIsEnabled} with argument {@link OpenGLES20#GL_SAMPLE_COVERAGE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, the fragment's coverage is ANDed with the temporary coverage value. If {@link
     * OpenGLES20#GL_SAMPLE_COVERAGE_INVERT} is set to {@code true}, invert the coverage value.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return Whether a capability is enabled.
     * 
     * @see #setSampleCoverage
     */
    public boolean isSampleCoverageEnabled() {
        return OOGLES20.backEnd.glIsEnabled(OpenGLES20.GL_SAMPLE_COVERAGE);
    }
    
    /**
     * <p>Returns a single positive floating-point value indicating the current sample coverage value.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetFloatv} with argument {@link OpenGLES20#GL_SAMPLE_COVERAGE_VALUE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a single positive floating-point value indicating the current sample coverage value.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A single positive floating-point value indicating the current sample coverage value.
     * 
     * @see #setSampleCoverage
     */
    public float getSampleCoverageValue() {
        OOGLES20.backEnd.glGetFloatv(OpenGLES20.GL_SAMPLE_COVERAGE_VALUE, OOGLES20FragmentProcessing.floatBuffer);
        return OOGLES20FragmentProcessing.floatBuffer.get(0);
    }
    
    /**
     * <p>Returns a boolean value indicating if the temporary coverage value should be inverted.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetBooleanv} with argument {@link OpenGLES20#GL_SAMPLE_COVERAGE_INVERT}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a boolean value indicating if the temporary coverage value should be inverted.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A boolean value indicating if the temporary coverage value should be inverted.
     * 
     * @see #setSampleCoverage
     */
    public boolean isSampleCoverageInverted() {
        OOGLES20.backEnd.glGetBooleanv(OpenGLES20.GL_SAMPLE_COVERAGE_INVERT,
                OOGLES20FragmentProcessing.byteBuffer.asIntBuffer());
        return OOGLES20FragmentProcessing.byteBuffer.get(0) != 0;
    }
    
    /**
     * <p>Returns whether a capability is enabled.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glIsEnabled} with argument {@link OpenGLES20#GL_STENCIL_TEST}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, do stencil testing and update the stencil buffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return Whether a capability is enabled.
     * 
     * @see #setStencilFunction
     * @see #setStencilAction
     */
    public boolean isStencilTestEnabled() {
        return OOGLES20.backEnd.glIsEnabled(OpenGLES20.GL_STENCIL_TEST);
    }
    
    /**
     * <p>Returns an enum constant indicating what function is used to compare the stencil reference value with the
     * stencil buffer value for front-facing polygons and non-polygons.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_FUNC}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an enum constant indicating what function is used to compare the stencil reference value with the
     * stencil buffer value for front-facing polygons and non-polygons. The initial value is {@link
     * OOStencilTestFunction#ALWAYS}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return An enum constant indicating what function is used to compare the stencil reference value with the
     * stencil buffer value for front-facing polygons and non-polygons.
     * 
     * @see #setStencilFunction
     * @see #setStencilFunctionSeparately
     */
    public OOStencilTestFunction getFrontStencilFunction() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_FUNC, OOGLES20FragmentProcessing.intBuffer);
        return OOStencilTestFunction.valueOf(OOGLES20FragmentProcessing.intBuffer.get(0));
    }
    
    /**
     * <p>Returns the reference value that is compared with the contents of the stencil buffer for front-facing polygons
     * and non-polygons.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_REF}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the reference value that is compared with the contents of the stencil buffer for front-facing polygons
     * and non-polygons. The initial value is {@code 0}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The reference value that is compared with the contents of the stencil buffer for front-facing polygons
     * and non-polygons.
     * 
     * @see #setStencilFunction
     * @see #setStencilFunctionSeparately
     */
    public int getFrontStencilReferenceValue() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_REF, OOGLES20FragmentProcessing.intBuffer);
        return OOGLES20FragmentProcessing.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the mask that is used to mask both the stencil reference value and the stencil buffer value before
     * they are compared for front-facing polygons and non-polygons.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_VALUE_MASK}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the mask that is used to mask both the stencil reference value and the stencil buffer value before
     * they are compared for front-facing polygons and non-polygons. The initial value is all {@code 1}'s.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The mask that is used to mask both the stencil reference value and the stencil buffer value before they
     * are compared for front-facing polygons and non-polygons.
     * 
     * @see #setStencilFunction
     * @see #setStencilFunctionSeparately
     */
    public int getFrontStencilMask() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_VALUE_MASK, OOGLES20FragmentProcessing.intBuffer);
        return OOGLES20FragmentProcessing.intBuffer.get(0);
    }
    
    /**
     * <p>Returns an enum constant indicating what function is used for back-facing polygons to compare the stencil
     * reference value with the stencil buffer value.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_BACK_FUNC}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an enum constant indicating what function is used for back-facing polygons to compare the stencil
     * reference value with the stencil buffer value. The initial value is {@link OOStencilTestFunction#ALWAYS}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return An enum constant indicating what function is used for back-facing polygons to compare the stencil
     * reference value with the stencil buffer value.
     * 
     * @see #setStencilFunctionSeparately
     */
    public OOStencilTestFunction getBackStencilFunction() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_BACK_FUNC, OOGLES20FragmentProcessing.intBuffer);
        return OOStencilTestFunction.valueOf(OOGLES20FragmentProcessing.intBuffer.get(0));
    }
    
    /**
     * <p>Returns the reference value that is compared with the contents of the stencil buffer for back-facing polygons.
     * </p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_BACK_REF}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the reference value that is compared with the contents of the stencil buffer for back-facing polygons.
     * The initial value is {@code 0}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The reference value that is compared with the contents of the stencil buffer for back-facing polygons.
     * 
     * @see #setStencilFunctionSeparately
     */
    public int getBackStencilReferenceValue() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_BACK_REF, OOGLES20FragmentProcessing.intBuffer);
        return OOGLES20FragmentProcessing.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the mask that is used for back-facing polygons to mask both the stencil reference value and the
     * stencil buffer value before they are compared.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_BACK_VALUE_MASK}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the mask that is used for back-facing polygons to mask both the stencil reference value and the
     * stencil buffer value before they are compared. The initial value is all {@code 1}'s.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The mask that is used for back-facing polygons to mask both the stencil reference value and the stencil
     * buffer value before they are compared.
     * 
     * @see #setStencilFunctionSeparately
     */
    public int getBackStencilMask() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_BACK_VALUE_MASK, OOGLES20FragmentProcessing.intBuffer);
        return OOGLES20FragmentProcessing.intBuffer.get(0);
    }
    
    /**
     * <p>Returns whether a capability is enabled.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glIsEnabled} with argument {@link OpenGLES20#GL_DEPTH_TEST}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, do depth comparisons and update the depth buffer. Note that even if the depth buffer exists and
     * the depth mask is non-zero, the depth buffer is not updated if the depth test is disabled.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return Whether a capability is enabled.
     * 
     * @see #setDepthTestFunction
     * @see OOGLES20PrimitiveProcessing#setDepthRange
     */
    public boolean isDepthTestEnabled() {
        return OOGLES20.backEnd.glIsEnabled(OpenGLES20.GL_DEPTH_TEST);
    }
    
    /**
     * <p>Returns the enum constant that indicates the depth comparison function.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_DEPTH_FUNC}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the enum constant that indicates the depth comparison function. The initial value is {@link
     * OODepthTestFunction#LESS}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The enum constant that indicates the depth comparison function.
     * 
     * @see #setDepthTestFunction
     */
    public OODepthTestFunction getDepthTestFunction() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_DEPTH_FUNC, OOGLES20FragmentProcessing.intBuffer);
        return OODepthTestFunction.valueOf(OOGLES20FragmentProcessing.intBuffer.get(0));
    }
    
    /**
     * <p>Returns an enum constant indicating what action is taken when the stencil test fails for front-facing polygons
     * and non-polygons.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_FAIL}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an enum constant indicating what action is taken when the stencil test fails for front-facing polygons
     * and non-polygons. The initial value is {@link OOStencilAction#KEEP}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return An enum constant indicating what action is taken when the stencil test fails for front-facing polygons
     * and non-polygons.
     * 
     * @see #setStencilAction
     * @see #setStencilActionSeparately
     */
    public OOStencilAction getFrontStencilFailAction() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_FAIL, OOGLES20FragmentProcessing.intBuffer);
        return OOStencilAction.valueOf(OOGLES20FragmentProcessing.intBuffer.get(0));
    }
    
    /**
     * <p>Returns an enum constant indicating what action is taken when the stencil test passes, but the depth test
     * fails for front-facing polygons and non-polygons.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_PASS_DEPTH_FAIL}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an enum constant indicating what action is taken when the stencil test passes, but the depth test
     * fails for front-facing polygons and non-polygons. The initial value is {@link OOStencilAction#KEEP}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return An enum constant indicating what action is taken when the stencil test passes, but the depth test fails
     * for front-facing polygons and non-polygons.
     * 
     * @see #setStencilAction
     * @see #setStencilActionSeparately
     */
    public OOStencilAction getFrontStencilPassDepthFailAction() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_PASS_DEPTH_FAIL, OOGLES20FragmentProcessing.intBuffer);
        return OOStencilAction.valueOf(OOGLES20FragmentProcessing.intBuffer.get(0));
    }
    
    /**
     * <p>Returns an enum constant indicating what action is taken when the stencil test passes and the depth test
     * passes for front-facing polygons and non-polygons.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_PASS_DEPTH_PASS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an enum constant indicating what action is taken when the stencil test passes and the depth test
     * passes for front-facing polygons and non-polygons. The initial value is {@link OOStencilAction#KEEP}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return An enum constant indicating what action is taken when the stencil test passes and the depth test passes
     * for front-facing polygons and non-polygons.
     * 
     * @see #setStencilAction
     * @see #setStencilActionSeparately
     */
    public OOStencilAction getFrontStencilPassDepthPassAction() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_PASS_DEPTH_PASS, OOGLES20FragmentProcessing.intBuffer);
        return OOStencilAction.valueOf(OOGLES20FragmentProcessing.intBuffer.get(0));
    }
    
    /**
     * <p>Returns an enum constant indicating what action is taken for back-facing polygons when the stencil test fails.
     * </p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_BACK_FAIL}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an enum constant indicating what action is taken for back-facing polygons when the stencil test fails.
     * The initial value is {@link OOStencilAction#KEEP}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return An enum constant indicating what action is taken for back-facing polygons when the stencil test fails.
     * 
     * @see #setStencilActionSeparately
     */
    public OOStencilAction getBackStencilFailAction() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_BACK_FAIL, OOGLES20FragmentProcessing.intBuffer);
        return OOStencilAction.valueOf(OOGLES20FragmentProcessing.intBuffer.get(0));
    }
    
    /**
     * <p>Returns an enum constant indicating what action is taken for back-facing polygons when the stencil test
     * passes, but the depth test fails.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_BACK_PASS_DEPTH_FAIL}.
     * </p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an enum constant indicating what action is taken for back-facing polygons when the stencil test
     * passes, but the depth test fails. The initial value is {@link OOStencilAction#KEEP}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return An enum constant indicating what action is taken for back-facing polygons when the stencil test passes,
     * but the depth test fails.
     * 
     * @see #setStencilActionSeparately
     */
    public OOStencilAction getBackStencilPassDepthFailAction() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_BACK_PASS_DEPTH_FAIL,
                OOGLES20FragmentProcessing.intBuffer);
        return OOStencilAction.valueOf(OOGLES20FragmentProcessing.intBuffer.get(0));
    }
    
    /**
     * <p>Returns an enum constant indicating what action is taken for back-facing polygons when the stencil test passes
     * and the depth test passes.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_BACK_PASS_DEPTH_PASS}.
     * </p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an enum constant indicating what action is taken for back-facing polygons when the stencil test passes
     * and the depth test passes. The initial value is {@link OOStencilAction#KEEP}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return An enum constant indicating what action is taken for back-facing polygons when the stencil test passes
     * and the depth test passes.
     * 
     * @see #setStencilActionSeparately
     */
    public OOStencilAction getBackStencilPassDepthPassAction() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_BACK_PASS_DEPTH_PASS,
                OOGLES20FragmentProcessing.intBuffer);
        return OOStencilAction.valueOf(OOGLES20FragmentProcessing.intBuffer.get(0));
    }
}
