package ro.spatarel.android.oogles20;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/**
 * <p>Class grouping together the methods managing the {@link OpenGLES20#GL_FRAMEBUFFER} target.</p>
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
public class OOGLES20Framebuffer {
    
    OOGLES20Framebuffer() {
        // There is nothing here.
    }
    
    /**
     * <p>Wrapper for the {@link OpenGLES20#GL_COLOR_ATTACHMENT0} target.</p>
     */
    public final OOGLES20FramebufferAttachment color =
            new OOGLES20FramebufferAttachment(OOFramebufferAttachmentPoint.COLOR);
    
    /**
     * <p>Wrapper for the {@link OpenGLES20#GL_DEPTH_ATTACHMENT} target.</p>
     */
    public final OOGLES20FramebufferAttachment depth =
            new OOGLES20FramebufferAttachment(OOFramebufferAttachmentPoint.DEPTH);
    
    /**
     * <p>Wrapper for the {@link OpenGLES20#GL_STENCIL_ATTACHMENT} target.</p>
     */
    public final OOGLES20FramebufferAttachment stencil =
            new OOGLES20FramebufferAttachment(OOFramebufferAttachmentPoint.STENCIL);
    
    /**
     * <p>Bind a named framebuffer object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glBindFramebuffer}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #bind} lets you create or use a named framebuffer object. Calling {@link #bind} with {@code
     * framebuffer} set to the name of the new framebuffer object binds the framebuffer object name. When a framebuffer
     * object is bound, the previous binding is automatically broken.</p>
     * 
     * <p>Framebuffer object names are unsigned integers. The value {@code null} is reserved to represent the default
     * framebuffer provided by the windowing system. Framebuffer object names and the corresponding framebuffer object
     * contents are local to the shared object space of the current GL rendering context.</p>
     * 
     * <p>You may use {@code OOFramebuffer#OOFramebuffer} to generate a new framebuffer object name.</p>
     * 
     * <p>The state of a framebuffer object immediately after it is first bound is three attachment points
     * ({@link #color}, {@link #depth} and {@link #stencil}) each with {@link OOFramebufferAttachmentObjectType#NONE}
     * as the object type.</p>
     * 
     * <p>While a non-{@code null} framebuffer object name is bound, GL operations affect the bound framebuffer object,
     * and queries of framebuffer details such as {@link OOGLES20Implementation#getDepthBits} return state from the
     * bound framebuffer object. While framebuffer object name {@code null} is bound, as in the initial state, attempts
     * to modify or query state generates an {@link OOError#INVALID_OPERATION} error.</p>
     * 
     * <p>While a non-{@code null} framebuffer object name is bound, all rendering to the framebuffer (with {@link
     * #drawArrays} and {@link #drawElements}) and reading from the framebuffer (with {@link #readPixels}, {@link
     * #copyToTextureImage2D} or {@link #copyToTextureSubImage2D}) use the images attached to the application-created
     * framebuffer object rather than the default window-system-provided framebuffer.</p>
     * 
     * <p>Application created framebuffer objects differ from the default window-system-provided framebuffer in a few
     * important ways. First, they have modifiable attachment points for a color buffer, a depth buffer and a stencil
     * buffer to which framebuffer attachable images may be attached and detached. Second, the size and format of the
     * attached images are controlled entirely within the GL and are not affected by window-system events, such as pixel
     * format selection, window resizes and display mode changes. Third, when rendering to or reading from an
     * application created framebuffer object, the pixel ownership test always succeeds (i.e. they own all their
     * pixels). Fourth, there are no visible color buffer bitplanes, only a single "off-screen" color image attachment,
     * so there is no sense of front and back buffers or swapping. Finally, there is no multisample buffer, so the value
     * of the implementation-dependent state variables {@link OOGLES20Implementation#getMultisampleCoverageMaskSize} and
     * {@link OOGLES20Implementation#getMultisampleBuffersCount} are both {@code 0} for application created framebuffer
     * objects.</p>
     * 
     * A framebuffer object binding created with {@link #bind} remains active until a different framebuffer object name
     * is bound or until the bound framebuffer object is deleted with {@link OOFramebuffer#finalize}.
     * 
     * <h5>Notes</h5>
     * 
     * <p>Queries of implementation-dependent pixel depths and related state are derived from the currently bound
     * framebuffer object. These include {@link OOGLES20Implementation#getColorRedBits},
     * {@link OOGLES20Implementation#getColorGreenBits}, {@link OOGLES20Implementation#getColorBlueBits},
     * {@link OOGLES20Implementation#getColorAlphaBits}, {@link OOGLES20Implementation#getDepthBits},
     * {@link OOGLES20Implementation#getStencilBits}, {@link OOGLES20Implementation#getPreferredPixelDataType},
     * {@link OOGLES20Implementation#getPreferredPixelFormat},
     * {@link OOGLES20Implementation#getMultisampleCoverageMaskSize},
     * {@link OOGLES20Implementation#getMultisampleBuffersCount}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param framebuffer Specifies the name of a framebuffer object.
     * 
     * @see #getBindedFramebuffer
     * @see OOFramebuffer#finalize
     * @see OOGLES20FramebufferAttachment#attachRenderbuffer
     * @see OOGLES20FramebufferAttachment#attachTextureImage2D
     * @see OOFramebuffer#OOFramebuffer
     * 
     */
    public void bind(OOFramebuffer framebuffer) {
        if (framebuffer == null) {
            OOGLES20.backEnd.glBindFramebuffer(OpenGLES20.GL_FRAMEBUFFER, 0);
        } else {
            OOGLES20.backEnd.glBindFramebuffer(OpenGLES20.GL_FRAMEBUFFER, framebuffer.getHandle());
        }
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code bind(null);}.</p>
     * 
     * @see #bind
     */
    public void bindDefault() {
        this.bind(null);
    }
    
    /**
     * <p>Return the framebuffer completeness status of a framebuffer object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glCheckFramebufferStatus}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #checkStatus} returns a symbolic constant that identifies whether or not the currently bound
     * framebuffer is framebuffer complete and if not, which of the rules of framebuffer completeness is violated.</p>
     * 
     * <p>If the framebuffer is complete, then {@link OOFramebufferState#COMPLETE} is returned. If the framebuffer is
     * not complete, the return values are as follows:</p>
     * 
     * <dl>
     *     <dt>{@link OOFramebufferState#INCOMPLETE_ATTACHMENT}</dt>
     *         <dd><p>Not all framebuffer attachment points are framebuffer attachment complete. This means that at
     *         least one attachment point with a renderbuffer or texture attached has its attached object no longer in
     *         existence or has an attached image with a width or height of zero or the color attachment point has a
     *         non-color-renderable image attached or the depth attachment point has a non-depth-renderable image
     *         attached or the stencil attachment point has a non-stencil-renderable image attached.</p>
     *         <p>Color-renderable formats include {@link OORenderbufferFormat#RGBA4}, {@link
     *         OORenderbufferFormat#RGB5_A1} and {@link OORenderbufferFormat#RGB565}. {@link
     *         OORenderbufferFormat#DEPTH_COMPONENT16} is the only depth-renderable format. {@link
     *         OORenderbufferFormat#STENCIL_INDEX8} is the only stencil-renderable format.</p></dd>
     *     <dt>{@link OOFramebufferState#INCOMPLETE_DIMENSIONS}</dt>
     *         <dd>Not all attached images have the same width and height.</dd>
     *     <dt>{@link OOFramebufferState#INCOMPLETE_MISSING_ATTACHMENT}</dt>
     *         <dd>No images are attached to the framebuffer.</dd>
     *     <dt>{@link OOFramebufferState#UNSUPPORTED}</dt>
     *         <dd>The combination of internal formats of the attached images violates an implementation-dependent set
     *         of restrictions.</dd>
     * </dl>
     * 
     * <p>If the currently bound framebuffer is not framebuffer complete, then it is an error to attempt to use the
     * framebuffer for writing or reading. This means that rendering commands ({@link #clear}, {@link #drawArrays} and
     * {@link #drawElements}) as well as commands that read the framebuffer ({@link #readPixels}, {@link
     * #copyToTextureImage2D} and {@link #copyToTextureSubImage2D}) will generate the error {@link
     * OOError#INVALID_FRAMEBUFFER_OPERATION} if called while the framebuffer is not framebuffer complete.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>It is strongly advised, thought not required, that an application call {@link #checkStatus()} to see if the
     * framebuffer is complete prior to rendering. This is because some implementations may not support rendering to
     * particular combinations of internal formats. In this case, {@link OOFramebufferState#UNSUPPORTED} is returned.
     * </p>
     * 
     * <p>The default window-system-provided framebuffer is always framebuffer complete and thus {@link
     * OOFramebufferState#COMPLETE} is returned when {@link #getBindedFramebuffer} is {@code 0}.</p>
     * 
     * <p>Additionally, if an error occurs, {@code 0} is returned.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The framebuffer completeness status of a framebuffer object.
     * 
     * @see OOGLES20Renderbuffer#bind
     * @see #copyToTextureImage2D
     * @see #copyToTextureSubImage2D
     * @see #drawArrays
     * @see #drawElements
     * @see #readPixels
     * @see OOGLES20Renderbuffer#setStorage
     */
    public OOFramebufferState checkStatus() {
        return OOFramebufferState.valueOf(OOGLES20.backEnd.glCheckFramebufferStatus(OpenGLES20.GL_FRAMEBUFFER));
    }
    
    /**
     * <p>Specify clear values for the color buffers.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glClearColor}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setColorClearValue} specifies the red, green, blue and alpha values used by {@link #clear} to clear
     * the color buffers. Values specified by {@link #setColorClearValue} are clamped to the range {@code [0, 1]}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param red Specify the red component used when the color buffers are cleared. The initial value is {@code 0}.
     * @param green Specify the green component used when the color buffers are cleared. The initial value is {@code 0}.
     * @param blue Specify the blue component used when the color buffers are cleared. The initial value is {@code 0}.
     * @param alpha Specify the alpha component used when the color buffers are cleared. The initial value is {@code 0}.
     * 
     * @see #getColorClearValue
     * @see #clear
     */
    public void setColorClearValue(float red, float green, float blue, float alpha) {
        OOGLES20.backEnd.glClearColor(red, green, blue, alpha);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setColorClearValue(color.red, color.green, color.blue, color.alpha);}.</p>
     * 
     * @param color Specify the color used when the color buffers are cleared. The initial value is
     * {@code (0, 0, 0, 0)}.
     * 
     * @see #setColorClearValue
     */
    public void setColorClearValue(OOColor color) {
        this.setColorClearValue(color.red, color.green, color.blue, color.alpha);
    }
    
    /**
     * <p>Specify the clear value for the depth buffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glClearDepthf}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setDepthClearValue} specifies the depth value used by {@link #clear} to clear the depth buffer. Values
     * specified by {@link #setDepthClearValue} are clamped to the range {@code [0, 1]}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param depth Specifies the depth value used when the depth buffer is cleared. The initial value is {@code 1}.
     * 
     * @see #getDepthClearValue
     * @see #clear
     */
    public void setDepthClearValue(float depth) {
        OOGLES20.backEnd.glClearDepthf(depth);
    }
    
    /**
     * <p>Specify the clear value for the stencil buffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glClearStencil}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setStencilClearValue} specifies the index used by {@link #clear} to clear the stencil buffer. {@code
     * stencil} is masked with {@code 2^m - 1}, where <i>m</i> is the number of bits in the stencil buffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param stencil Specifies the index used when the stencil buffer is cleared. The initial value is {@code 0}.
     * 
     * @see #getStencilClearValue
     * @see OOGLES20Implementation#getStencilBits
     * 
     * @see #clear
     * @see OOGLES20FragmentProcessing#setStencilFunction
     * @see OOGLES20FragmentProcessing#setStencilFunctionSeparately
     * @see OOGLES20PixelProcessing#setStencilBufferWriteMask
     * @see OOGLES20PixelProcessing#setStencilBufferWriteMaskSeparately
     * @see OOGLES20FragmentProcessing#setStencilAction
     * @see OOGLES20FragmentProcessing#setStencilActionSeparately
     */
    public void setStencilClearValue(int stencil) {
        OOGLES20.backEnd.glClearStencil(stencil);
    }
    
    /**
     * <p>Clear buffers to preset values.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glClear}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #clear} sets the bitplane area of the window to values previously selected by {@link
     * #setColorClearValue}, {@link #setDepthClearValue} and {@link #setStencilClearValue}.</p>
     * 
     * <p>The pixel ownership test, the scissor test, dithering and the buffer writemasks affect the operation of
     * {@link #clear}. The scissor box bounds the cleared region. Blend function, stenciling, fragment shading and
     * depth-buffering are ignored by {@link #clear}.</p>
     * 
     * <p>{@link #clear} takes three {@code boolean} arguments that indicate which buffer is to be cleared.</p>
     * 
     * <p>The values are as follows:</p>
     * 
     * <dl>
     *     <dt>{@link OOFramebufferBuffer#COLOR}</dt>
     *         <dd>Indicates the buffers currently enabled for color writing.</dd>
     *     <dt>{@link OOFramebufferBuffer#DEPTH}</dt>
     *         <dd>Indicates the depth buffer.</dd>
     *     <dt>{@link OOFramebufferBuffer#STENCIL}</dt>
     *         <dd>Indicates the stencil buffer.</dd>
     * </dl>
     * 
     * <p>The value to which each buffer is cleared depends on the setting of the clear value for that buffer.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If a buffer is not present, then a {@link #clear} directed at that buffer has no effect.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param colorBuffer Indicates if the color buffer should be cleared or not.
     * @param depthBuffer Indicates if the depth buffer should be cleared or not.
     * @param stencilBuffer Indicates if the stencil buffer should be cleared or not.
     * 
     * @see #getDepthClearValue
     * @see #getColorClearValue
     * @see #getStencilClearValue
     * @see #setColorClearValue
     * @see #setDepthClearValue
     * @see #setStencilClearValue
     * @see OOGLES20PixelProcessing#setColorBufferWriteMask
     * @see OOGLES20PixelProcessing#setDepthBufferWriteMask
     * @see OOGLES20FragmentProcessing#setScissorBox
     * @see OOGLES20PixelProcessing#setStencilBufferWriteMask
     */
    public void clear(boolean colorBuffer, boolean depthBuffer, boolean stencilBuffer) {
        int mask = 0;
        if (colorBuffer) {
            mask |= OOFramebufferBuffer.COLOR.getGLConstant();
        }
        if (depthBuffer) {
            mask |= OOFramebufferBuffer.DEPTH.getGLConstant();
        }
        if (stencilBuffer) {
            mask |= OOFramebufferBuffer.STENCIL.getGLConstant();
        }
        OOGLES20.backEnd.glClear(mask);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code clear(buffer == OOFramebufferLayer.COLOR, buffer == OOFramebufferLayer.DEPTH,
     * buffer == OOFramebufferLayer.STENCIL);}.</p>
     * 
     * @param buffer The buffer to be cleared.
     * 
     * @see #clear
     */
    public void clear(OOFramebufferBuffer buffer) {
        this.clear(buffer == OOFramebufferBuffer.COLOR, buffer == OOFramebufferBuffer.DEPTH,
                buffer == OOFramebufferBuffer.STENCIL);
    }
    
    /**
     * <p>Render primitives from array data.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDrawArrays}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #drawArrays} specifies multiple geometric primitives with very few subroutine calls. Instead of calling
     * a GL procedure to pass each individual vertex attribute, you can use {@link OOAttribute#setBuffer} to
     * prespecify separate arrays of vertices, normals and colors and use them to construct a sequence of primitives
     * with a single call to {@link #drawArrays}.</p>
     * 
     * <p>When {@link #drawArrays} is called, it uses {@code count} sequential elements from each enabled array to
     * construct a sequence of geometric primitives, beginning with element {@code first}. {@code mode} specifies what
     * kind of primitives are constructed and how the array elements construct those primitives.</p>
     * 
     * <p>To enable and disable a generic vertex attribute array, call {@link OOAttribute#enableArray} and {@link
     * OOAttribute#disableArray}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the current program object, as set by {@link OOGLES20#useProgram}, is invalid, rendering results are
     * undefined. However, no error is generated for this case.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if mode is not an accepted value. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if count is negative.</li>
     *     <li>{@link OOError#INVALID_FRAMEBUFFER_OPERATION} is generated if the currently bound framebuffer is not
     *     framebuffer complete (i.e. the return value from {@link #checkStatus} is not {@link
     *     OOFramebufferState#COMPLETE}).</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param mode Specifies what kind of primitives to render.
     * @param first Specifies the starting index in the enabled arrays.
     * @param count Specifies the number of indices to be rendered.
     * 
     * @see #checkStatus
     * @see OOAttribute#disableArray
     * @see #drawElements
     * @see OOAttribute#enableArray
     * @see OOGLES20#useProgram
     * @see OOAttribute#setBuffer
     */
    public void drawArrays(OODrawPrimitive mode, int first, int count) {
        OOGLES20.backEnd.glDrawArrays(mode.getGLConstant(), first, count);
    }
    
    /**
     * <p>Render primitives from array data.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDrawElements}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #drawElements} specifies multiple geometric primitives with very few subroutine calls. Instead of
     * calling a GL function to pass each vertex attribute, you can use {@link OOAttribute#setBuffer} to
     * prespecify separate arrays of vertex attributes and use them to construct a sequence of primitives with a single
     * call to {@link #drawElements}.</p>
     * 
     * <p>When {@link #drawElements} is called, it uses {@code count} sequential elements from an enabled array,
     * starting at {@code buffer} to construct a sequence of geometric primitives. {@code mode} specifies what kind of
     * primitives are constructed and how the array elements construct these primitives. If more than one array is
     * enabled, each is used.</p>
     * 
     * <p>To enable and disable a generic vertex attribute array, call {@link OOAttribute#enableArray} and {@link
     * OOAttribute#disableArray}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the current program object, as set by {@link OOGLES20#useProgram}, is invalid, rendering results are
     * undefined. However, no error is generated for this case.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if mode is not an accepted value. -->
     *     <!-- GL_INVALID_ENUM is generated if type is not GL_UNSIGNED_BYTE or GL_UNSIGNED_SHORT. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if count is negative.</li>
     *     <li>{@link OOError#INVALID_FRAMEBUFFER_OPERATION} is generated if the currently bound framebuffer is not
     *     framebuffer complete (i.e. the return value from {@link #checkStatus} is not {@link
     *     OOFramebufferState#COMPLETE}).</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param mode Specifies what kind of primitives to render.
     * @param count Specifies the number of elements to be rendered.
     * @param buffer Specifies a pointer to the location where the indices are stored.
     * 
     * @see #checkStatus
     * @see OOAttribute#disableArray
     * @see #drawArrays
     * @see OOAttribute#enableArray
     * @see OOGLES20#useProgram
     * @see OOAttribute#setBuffer
     */
    public void drawElements(OODrawPrimitive mode, int count, ByteBuffer buffer) {
        OOGLES20.backEnd.glDrawElements(mode.getGLConstant(), count, OpenGLES20.GL_UNSIGNED_BYTE, buffer);
    }
    
    /**
     * <p>Render primitives from array data.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDrawElements}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #drawElements} specifies multiple geometric primitives with very few subroutine calls. Instead of
     * calling a GL function to pass each vertex attribute, you can use {@link OOAttribute#setBuffer} to
     * prespecify separate arrays of vertex attributes and use them to construct a sequence of primitives with a single
     * call to {@link #drawElements}.</p>
     * 
     * <p>When {@link #drawElements} is called, it uses {@code count} sequential elements from an enabled array,
     * starting at {@code buffer} to construct a sequence of geometric primitives. {@code mode} specifies what kind of
     * primitives are constructed and how the array elements construct these primitives. If more than one array is
     * enabled, each is used.</p>
     * 
     * <p>To enable and disable a generic vertex attribute array, call {@link OOAttribute#enableArray} and {@link
     * OOAttribute#disableArray}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the current program object, as set by {@link OOGLES20#useProgram}, is invalid, rendering results are
     * undefined. However, no error is generated for this case.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if mode is not an accepted value. -->
     *     <!-- GL_INVALID_ENUM is generated if type is not GL_UNSIGNED_BYTE or GL_UNSIGNED_SHORT. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if count is negative.</li>
     *     <li>{@link OOError#INVALID_FRAMEBUFFER_OPERATION} is generated if the currently bound framebuffer is not
     *     framebuffer complete (i.e. the return value from {@link #checkStatus} is not {@link
     *     OOFramebufferState#COMPLETE}).</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param mode Specifies what kind of primitives to render.
     * @param count Specifies the number of elements to be rendered.
     * @param buffer Specifies a pointer to the location where the indices are stored.
     * 
     * @see #checkStatus
     * @see OOAttribute#disableArray
     * @see #drawArrays
     * @see OOAttribute#enableArray
     * @see OOGLES20#useProgram
     * @see OOAttribute#setBuffer
     */
    public void drawElements(OODrawPrimitive mode, int count, ShortBuffer buffer) {
        OOGLES20.backEnd.glDrawElements(mode.getGLConstant(), count, OpenGLES20.GL_UNSIGNED_SHORT, buffer);
    }
    
    /**
     * <p>Render primitives from array data.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDrawElements}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #drawElements} specifies multiple geometric primitives with very few subroutine calls. Instead of
     * calling a GL function to pass each vertex attribute, you can use {@link OOAttribute#setBuffer} to
     * prespecify separate arrays of vertex attributes and use them to construct a sequence of primitives with a single
     * call to {@link #drawElements}.</p>
     * 
     * <p>When {@link #drawElements} is called, it uses {@code count} sequential elements from an enabled array,
     * starting at {@code offset} to construct a sequence of geometric primitives. {@code mode} specifies what kind of
     * primitives are constructed and how the array elements construct these primitives. If more than one array is
     * enabled, each is used.</p>
     * 
     * <p>To enable and disable a generic vertex attribute array, call {@link OOAttribute#enableArray} and {@link
     * OOAttribute#disableArray}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the current program object, as set by {@link OOGLES20#useProgram}, is invalid, rendering results are
     * undefined. However, no error is generated for this case.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if mode is not an accepted value. -->
     *     <!-- GL_INVALID_ENUM is generated if type is not GL_UNSIGNED_BYTE or GL_UNSIGNED_SHORT. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if count is negative.</li>
     *     <li>{@link OOError#INVALID_FRAMEBUFFER_OPERATION} is generated if the currently bound framebuffer is not
     *     framebuffer complete (i.e. the return value from {@link #checkStatus} is not {@link
     *     OOFramebufferState#COMPLETE}).</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param mode Specifies what kind of primitives to render.
     * @param count Specifies the number of elements to be rendered.
     * @param type Specifies the type of the values in {@link OOGLES20#elementArrayBuffer}.
     * @param offset Specifies an offset in the {@link OOGLES20#elementArrayBuffer} buffer where the indices are stored.
     * 
     * @see #checkStatus
     * @see OOAttribute#disableArray
     * @see #drawArrays
     * @see OOAttribute#enableArray
     * @see OOGLES20#useProgram
     * @see OOAttribute#setBuffer
     */
    public void drawElements(OODrawPrimitive mode, int count, OOBufferDataType type, int offset) {
        OOGLES20.backEnd.glDrawElements(mode.getGLConstant(), count, type.getGLConstant(), offset);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code drawElements(mode, count, OOGLES20.createByteBuffer(buffer, offset));}.</p>
     * 
     * @param mode Specifies what kind of primitives to render.
     * @param count Specifies the number of elements to be rendered.
     * @param buffer Specifies an array where the indices are stored.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #drawElements
     */
    public void drawElements(OODrawPrimitive mode, int count, byte[] buffer, int offset) {
        this.drawElements(mode, count, OOGLES20.createByteBuffer(buffer, offset));
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code drawElements(mode, count, OOGLES20.createShortBuffer(buffer, offset));}.</p>
     * 
     * @param mode Specifies what kind of primitives to render.
     * @param count Specifies the number of elements to be rendered.
     * @param buffer Specifies an array where the indices are stored.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #drawElements
     */
    public void drawElements(OODrawPrimitive mode, int count, short[] buffer, int offset) {
        this.drawElements(mode, count, OOGLES20.createShortBuffer(buffer, offset));
    }
    
    /**
     * <p>Read a block of pixels from the frame buffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glReadPixels}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #readPixels} returns pixel data from the frame buffer, starting with the pixel whose lower left corner
     * is at location (<i>x</i>, <i>y</i>), into client memory starting at location {@code pixels}. The {@link
     * OOGLES20#getPixelPackAlignment} parameter, set with the {@link OOGLES20#setPixelAlignment} command, affects the
     * processing of the pixel data before it is placed into client memory.</p>
     * 
     * <p>{@link #readPixels} returns values from each pixel with lower left corner at (<i>x + i</i>, <i>y + j</i>) for
     * <i>0 <= i < width</i> and <i>0 <= j < height</i>. This pixel is said to be the <i>i</i>th pixel in the <i>j</i>th
     * row. Pixels are returned in row order from the lowest to the highest row, left to right in each row.</p>
     * 
     * <p>{@code format} specifies the format for the returned pixel values.</p>
     * 
     * <p>RGBA color components are read from the color buffer. Each color component is converted to floating point such
     * that zero intensity maps to {@code 0.0} and full intensity maps to {@code 1.0}.</p>
     * 
     * <p>Unneeded data is then discarded. For example, {@link OOPixelFormat#ALPHA} discards the red, green and blue
     * components, while {@link OOPixelFormat#RGB} discards only the alpha component. The final values are clamped to
     * the range <@code [0, 1]>.</p>
     * 
     * <p>Finally, the components are converted to the proper format, as specified by {@code type}. When type is {@link
     * OOPixelDataType#UNSIGNED_BYTE}, each component is multiplied by {@code 2^8 - 1}. When {@code type} is
     * {@link OOPixelDataType#UNSIGNED_SHORT_5_6_5}, {@link OOPixelDataType#UNSIGNED_SHORT_4_4_4_4} or {@link
     * OOPixelDataType#UNSIGNED_SHORT_5_5_5_1}, each component is multiplied by {@code 2^N - 1}, where <i>N</i> is the
     * number of bits in the bitfield.</p>
     * 
     * <p>Return values are placed in memory as follows. If {@code format} is {@link OOPixelFormat#ALPHA}, a single
     * value is returned and the data for the <i>i</i>th pixel in the <i>j</i>th row is placed in location
     * <i>(j)width + i</i>. {@link OOPixelFormat#RGB} returns three values and {@link OOPixelFormat#RGBA} returns four
     * values for each pixel, with all values corresponding to a single pixel occupying contiguous space in {@code
     * pixels}. Storage parameter {@link OOGLES20#getPixelPackAlignment}, set by {@link OOGLES20#setPixelAlignment},
     * affects the way that data is written into memory. See {@link OOGLES20#setPixelAlignment} for a description.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the currently bound framebuffer is not the default framebuffer object, color components are read from the
     * color image attached to the {@link #color} attachment point.</p>
     * 
     * <p>Only two {@code format}/{@code type} parameter pairs are accepted. {@link OOPixelFormat#RGBA}/{@link
     * OOPixelDataType#UNSIGNED_BYTE} is always accepted and the other acceptable pair can be discovered by querying
     * {@link OOGLES20Implementation#getPreferredPixelFormat} and {@link
     * OOGLES20Implementation#getPreferredPixelDataType}.</p>
     * 
     * <p>Values for pixels that lie outside the window connected to the current GL context are undefined.</p>
     * 
     * <p>If an error is generated, no change is made to the contents of {@code pixels}.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if format or type is not an accepted value. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if either width or height is negative.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if type is {@link OOPixelDataType#UNSIGNED_SHORT_5_6_5}
     *     and format is not {@link OOPixelFormat#RGB}.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if type is {@link OOPixelDataType#UNSIGNED_SHORT_4_4_4_4}
     *     or {@link OOPixelDataType#UNSIGNED_SHORT_5_5_5_1} and format is not {@link OOPixelFormat#RGBA}.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if format and type are neither {@link OOPixelFormat#RGBA}
     *     and {@link OOPixelDataType#UNSIGNED_BYTE}, respectively, nor the format/type pair returned by querying
     *     {@link OOGLES20Implementation#getPreferredPixelFormat} and {@link
     *     OOGLES20Implementation#getPreferredPixelDataType}.</li>
     *     <li>{@link OOError#INVALID_FRAMEBUFFER_OPERATION} is generated if the currently bound framebuffer is not
     *     framebuffer complete (i.e. the return value from {@link #checkStatus} is not {@link
     *     OOFramebufferState#COMPLETE}).</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param x Specify the window coordinates of the first pixel that is read from the frame buffer. This location is
     * the lower left corner of a rectangular block of pixels.
     * @param y Specify the window coordinates of the first pixel that is read from the frame buffer. This location is
     * the lower left corner of a rectangular block of pixels.
     * @param width Specify the dimensions of the pixel rectangle. {@code width} and {@code height} of one correspond to
     * a single pixel.
     * @param height Specify the dimensions of the pixel rectangle. {@code width} and {@code height} of one correspond
     * to a single pixel.
     * @param format Specifies the format of the pixel data.
     * @param type Specifies the data type of the pixel data.
     * @param pixels Returns the pixel data.
     * 
     * @see OOGLES20Implementation#getPreferredPixelFormat
     * @see OOGLES20Implementation#getPreferredPixelDataType
     * @see OOGLES20#getPixelPackAlignment
     * @see #checkStatus
     * @see OOGLES20#setPixelAlignment
     */
    public void readPixels(int x, int y, int width, int height, OOPixelFormat format, OOPixelDataType type,
            Buffer pixels) {
        OOGLES20.backEnd.glReadPixels(x, y, width, height, format.getGLConstant(), type.getGLConstant(), pixels);
    }
    
    /**
     * <p>Copy pixels into a 2D texture image.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glCopyTexImage2D}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Texturing maps a portion of a specified texture image onto each graphical primitive for which texturing is
     * active. Texturing is active when the current fragment shader or vertex shader makes use of built-in texture
     * lookup functions.</p>
     * 
     * <p>{@link #copyToTextureImage2D} defines a two-dimensional texture image or cube-map texture image with pixels
     * from the current framebuffer (rather than from client memory, as is the case for {@link
     * OOGLES20TextureImage#setImage2D}).</p>
     * 
     * <p>The screen-aligned pixel rectangle with lower left corner at {@code (x, y)} and with a width of {@code width}
     * and a height of {@code height} defines the texture array at the mipmap level specified by {@code level}.
     * {@code format} specifies the internal format of the texture array.</p>
     * 
     * <p>The pixels in the rectangle are processed exactly as if {@link #readPixels} had been called with
     * {@code format} set to {@link OOTexelFormat#RGBA}, but the process stops just after conversion of RGBA values.
     * Subsequent processing is identical to that described for {@link OOGLES20TextureImage#setImage2D}, beginning with
     * the clamping of the R, G, B and A values to the range {@code [0, 1]} and then conversion to the texture's
     * internal format for storage in the texel array.</p>
     * 
     * <p>The components required for {@code format} must be a subset of those present in the framebuffer's format. For
     * example, a {@link OOTexelFormat#RGBA} framebuffer can be used to supply components for any {@code format}.
     * However, a {@link OOTexelFormat#RGB} framebuffer can only be used to supply components for {@link
     * OOTexelFormat#RGB} or {@link OOTexelFormat#LUMINANCE} base internal format textures, not {@link
     * OOTexelFormat#ALPHA}, {@link OOTexelFormat#LUMINANCE_ALPHA} or {@link OOTexelFormat#RGBA} textures.</p>
     * 
     * <p>Pixel ordering is such that lower <i>x</i> and <i>y</i> screen coordinates correspond to lower <i>s</i> and
     * <i>t</i> texture coordinates.</p>
     * 
     * <p>If any of the pixels within the specified rectangle are outside the framebuffer associated with the current
     * rendering context, then the values obtained for those pixels are undefined.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>A GL implementation may choose to store the texture array at any internal resolution it chooses.</p>
     * 
     * <p>An image with height or width of {@code 0} indicates a {@code null} texture.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if target is not GL_TEXTURE_2D, GL_TEXTURE_CUBE_MAP_POSITIVE_X,
     *     GL_TEXTURE_CUBE_MAP_NEGATIVE_X, GL_TEXTURE_CUBE_MAP_POSITIVE_Y, GL_TEXTURE_CUBE_MAP_NEGATIVE_Y,
     *     GL_TEXTURE_CUBE_MAP_POSITIVE_Z or GL_TEXTURE_CUBE_MAP_NEGATIVE_Z. -->
     *     <li>{@link OOError#INVALID_ENUM} is generated if {@code format} is not an accepted format.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code target} is one of the six cube map 2D image targets
     *     and the width and height parameters are not equal.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code level} is less than {@code 0}.</li>
     *     <li>{@link OOError#INVALID_VALUE} may be generated if {@code level} is greater than
     *     <i>log<sub>2</sub>max</i>, where <i>max</i> is the returned value of {@link
     *     OOGLES20Implementation#getMaximumTextureDimension} when the target is {@link OOGLES20TextureUnit#tex2D} or
     *     {@link OOGLES20Implementation#getMaximumCubeMapTextureDimension} when target is {@link
     *     OOGLES20TextureUnit#texCubeMap}.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code width} or {@code height} is less than {@code 0} or
     *     greater than {@link OOGLES20Implementation#getMaximumTextureDimension} when target is {@link
     *     OOGLES20TextureUnit#tex2D} or {@link OOGLES20Implementation#getMaximumCubeMapTextureDimension} when target is
     *     {@link OOGLES20TextureUnit#texCubeMap}.</li>
     *     <!-- GL_INVALID_VALUE is generated if border is not 0. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the currently bound framebuffer's format does not
     *     contain a superset of the components required by the base format of {@code format}.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the currently bound framebuffer is not framebuffer
     *     complete (i.e. the return value from {@link #checkStatus} is not {@link OOFramebufferState#COMPLETE}).</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param textureImage Specifies the destination texture image.
     * @param level Specifies the level-of-detail number. Level {@code 0} is the base image level. Level <i>n</i> is the
     * <i>n</i>th mipmap reduction image.
     * @param format Specifies the internal format of the texture.
     * @param x Specify the window coordinates of the lower left corner of the rectangular region of pixels to be
     * copied.
     * @param y Specify the window coordinates of the lower left corner of the rectangular region of pixels to be
     * copied.
     * @param width Specifies the width of the texture image. All implementations support 2D texture images that are at
     * least 64 texels wide and cube-mapped texture images that are at least 16 texels wide.
     * @param height Specifies the height of the texture image. All implementations support 2D texture images that are
     * at least 64 texels high and cube-mapped texture images that are at least 16 texels high.
     * 
     * @see OOGLES20Implementation#getMaximumTextureDimension
     * @see OOGLES20Implementation#getMaximumCubeMapTextureDimension
     * @see #checkStatus
     * @see OOGLES20TextureImage#setCompressedImage2D
     * @see OOGLES20TextureImage#setCompressedSubImage2D
     * @see #copyToTextureSubImage2D
     * @see OOGLES20TextureImage#setImage2D
     * @see OOGLES20TextureImage#setSubImage2D
     */
    public void copyToTextureImage2D(OOGLES20TextureImage textureImage, int level, OOTexelFormat format, int x, int y,
            int width, int height) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + textureImage.getTextureUnit());
        OOGLES20.backEnd.glCopyTexImage2D(textureImage.getTarget().getGLConstant(), level, format.getGLConstant(), x, y,
                width, height, 0);
    }
    
    /**
     * <p>Copy a two-dimensional texture subimage.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glCopyTexSubImage2D}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Texturing maps a portion of a specified texture image onto each graphical primitive for which texturing is
     * active. Texturing is active when the current fragment shader or vertex shader makes use of built-in texture
     * lookup functions.</p>
     * 
     * <p>{@link #copyToTextureSubImage2D} replaces a rectangular portion of a two-dimensional texture image or cube-map
     * texture image with pixels from the current framebuffer (rather than from client memory, as is the case for {@link
     * OOGLES20TextureImage#setSubImage2D}).</p>
     * 
     * <p>The screen-aligned pixel rectangle with lower left corner at <i>(x, y)</i> and with width {@code width} and
     * height {@code height} replaces the portion of the texture array with x indices {@code xOffset} through
     * <i>xOffset + width - 1</i>, inclusive and y indices {@code yOffset} through <i>yOffset + height - 1</i>,
     * inclusive, at the mipmap level specified by {@code level}.</p>
     * 
     * <p>The pixels in the rectangle are processed exactly as if {@link #readPixels} had been called with format set to
     * {@link OOTexelFormat#RGBA}, but the process stops just after conversion of RGBA values. Subsequent processing is
     * identical to that described for {@link OOGLES20TextureImage#setSubImage2D}, beginning with the clamping of the R,
     * G, B and A values to the range {@code [0, 1]} and then conversion to the texture's internal format for storage in
     * the texel array.</p>
     * 
     * <p>The destination rectangle in the texture array may not include any texels outside the texture array as it was
     * originally specified. It is not an error to specify a subtexture with zero width or height, but such a
     * specification has no effect.</p>
     * 
     * <p>If any of the pixels within the specified rectangle are outside the framebuffer associated with the current
     * rendering context, then the values obtained for those pixels are undefined.</p>
     * 
     * <p>No change is made to the <i>format</i>, <i>width</i> or <i>height</i> parameters of the specified texture
     * array or to texel values outside the specified subregion.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if target is not GL_TEXTURE_2D, GL_TEXTURE_CUBE_MAP_POSITIVE_X,
     *     GL_TEXTURE_CUBE_MAP_NEGATIVE_X, GL_TEXTURE_CUBE_MAP_POSITIVE_Y, GL_TEXTURE_CUBE_MAP_NEGATIVE_Y,
     *     GL_TEXTURE_CUBE_MAP_POSITIVE_Z or GL_TEXTURE_CUBE_MAP_NEGATIVE_Z. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code level} is less than {@code 0}.</li>
     *     <li>{@link OOError#INVALID_VALUE} may be generated if <i>level > log<sub>2</sub>(max)</i>, where <i>max</i>
     *     is the returned value of {@link OOGLES20Implementation#getMaximumTextureDimension}.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if <i>xOffset < 0</i>, <i>(xOffset + width) > w</i>,
     *     <i>yOffset < 0</i> or <i>(yOffset + height) > h</i>, where <i>w</i> is the width and <i>h</i> is the height
     *     of the texture image being modified.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code width} or {@code height} is less than
     *     {@code 0}.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the texture array has not been defined by a previous
     *     {@link OOGLES20TextureImage#setImage2D} or {@link #copyToTextureImage2D} operation.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the currently bound framebuffer's format does not
     *     contain a superset of the components required by the texture's base internal format.</li>
     *     <li>{@link OOError#INVALID_FRAMEBUFFER_OPERATION} is generated if the currently bound framebuffer is not
     *     framebuffer complete (i.e. the return value from {@link #checkStatus} is not {@link
     *     OOFramebufferState#COMPLETE}).</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param textureImage Specifies the destination texture image.
     * @param level Specifies the level-of-detail number. Level {@code 0} is the base image level. Level <i>n</i> is the
     * <i>n</i>th mipmap reduction image.
     * @param xOffset Specifies a texel offset in the x direction within the texture array.
     * @param yOffset Specifies a texel offset in the y direction within the texture array.
     * @param x Specify the window coordinates of the lower left corner of the rectangular region of pixels to be
     * copied.
     * @param y Specify the window coordinates of the lower left corner of the rectangular region of pixels to be
     * copied.
     * @param width Specifies the width of the texture subimage.
     * @param height Specifies the height of the texture subimage.
     * 
     * @see OOGLES20Implementation#getMaximumTextureDimension
     * @see OOGLES20Implementation#getMaximumCubeMapTextureDimension
     * @see #checkStatus
     * @see #copyToTextureImage2D
     * @see OOGLES20TextureImage#setImage2D
     * @see OOGLES20TextureImage#setSubImage2D
     */
    public void copyToTextureSubImage2D(OOGLES20TextureImage textureImage, int level, int xOffset, int yOffset, int x,
            int y, int width, int height) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + textureImage.getTextureUnit());
        OOGLES20.backEnd.glCopyTexSubImage2D(textureImage.getTarget().getGLConstant(), level, xOffset, yOffset, x, y,
                width, height);
    }
    
    private static FloatBuffer floatBuffer = OOGLES20.createFloatBuffer(4);
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(1);
    
    /**
     * <p>Returns the name of the currently bound framebuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_FRAMEBUFFER_BINDING}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the name of the currently bound framebuffer. The initial value is {@code 0}, indicating the default
     * framebuffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The name of the currently bound framebuffer.
     * 
     * @see #bind
     */
    public OOFramebuffer getBindedFramebuffer() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_FRAMEBUFFER_BINDING, OOGLES20Framebuffer.intBuffer);
        return OOFramebuffer.getFramebuffer(OOGLES20Framebuffer.intBuffer.get(0));
    }
    
    /**
     * <p>Returns the color used to clear the color buffers.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetFloatv} with argument {@link OpenGLES20#GL_COLOR_CLEAR_VALUE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the color used to clear the color buffers. Integer values, if requested, are linearly mapped from the
     * internal floating-point representation such that {@code 1.0} returns the most positive representable integer
     * value and {@code -1.0} returns the most negative representable integer value. The initial value is {@code
     * (0, 0, 0, 0)}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The color used to clear the color buffers.
     * 
     * @see #setColorClearValue
     */
    public OOColor getColorClearValue() {
        OOGLES20.backEnd.glGetFloatv(OpenGLES20.GL_COLOR_CLEAR_VALUE, OOGLES20Framebuffer.floatBuffer);
        return new OOColor(
                OOGLES20Framebuffer.floatBuffer.get(0),
                OOGLES20Framebuffer.floatBuffer.get(1),
                OOGLES20Framebuffer.floatBuffer.get(2),
                OOGLES20Framebuffer.floatBuffer.get(3));
    }
    
    /**
     * <p>Returns the value that is used to clear the depth buffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetFloatv} with argument {@link OpenGLES20#GL_DEPTH_CLEAR_VALUE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the value that is used to clear the depth buffer. Integer values, if requested, are linearly mapped
     * from the internal floating-point representation such that {@code 1.0} returns the most positive representable
     * integer value and {@code -1.0} returns the most negative representable integer value. The initial value is
     * {@code 1}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The color used to clear the color buffers.
     * 
     * @see #setDepthClearValue
     */
    public float getDepthClearValue() {
        OOGLES20.backEnd.glGetFloatv(OpenGLES20.GL_DEPTH_CLEAR_VALUE, OOGLES20Framebuffer.floatBuffer);
        return OOGLES20Framebuffer.floatBuffer.get(0);
    }
    
    /**
     * <p>Returns the index to which the stencil bitplanes are cleared.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_CLEAR_VALUE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the index to which the stencil bitplanes are cleared. The initial value is {@code 0}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The color used to clear the color buffers.
     * 
     * @see #setStencilClearValue
     */
    public int getStencilClearValue() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_CLEAR_VALUE, OOGLES20Framebuffer.intBuffer);
        return OOGLES20Framebuffer.intBuffer.get(0);
    }
}
