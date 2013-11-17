package ro.spatarel.android.oogles20;

import java.nio.IntBuffer;

/**
 * <p>Class grouping together the methods managing the {@link OpenGLES20#GL_RENDERBUFFER} target.</p>
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
public class OOGLES20Renderbuffer {
    
    OOGLES20Renderbuffer() {
        // There is nothing here.
    }
    
    /**
     * <p>Bind a named renderbuffer object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glBindRenderbuffer}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>A renderbuffer is a data storage object containing a single image of a renderable internal format. A
     * renderbuffer's image may be attached to a framebuffer object to use as a destination for rendering and as a
     * source for reading.</p>
     * 
     * <p>{@link #bind} lets you create or use a named renderbuffer object. Calling {@link #bind} with {@code
     * renderbuffer} set to the name of the new renderbuffer object binds the renderbuffer object name. When a
     * renderbuffer object is bound, the previous binding is automatically broken.</p>
     * 
     * <p>Renderbuffer object name {@code null} is reserved, but there is no default renderbuffer object. Instead,
     * {@code renderbuffer} set to {@code null} effectively unbinds any renderbuffer object previously bound.
     * Renderbuffer object names and the corresponding renderbuffer object contents are local to the shared object space
     * of the current GL rendering context.</p>
     * 
     * <p>You may use {@link OORenderbuffer#OORenderbuffer} to generate a set of new renderbuffer object names.</p>
     * 
     * <p>The state of a renderbuffer object immediately after it is first bound is a zero-sized memory buffer with
     * format {@link OORenderbufferFormat#RGBA4} and zero-sized red, green, blue, alpha, depth and stencil pixel
     * depths.</p>
     * 
     * <p>While a non-{@code null} renderbuffer object name is bound, GL operations affect the bound renderbuffer
     * object and queries return state from the bound renderbuffer object. While renderbuffer object name {@code null}
     * is bound, as in the initial state, attempts to modify or query state generates an {@link
     * OOError#INVALID_OPERATION} error.</p>
     * 
     * <p>A renderbuffer object binding created with {@link #bind} remains active until a different renderbuffer object
     * name is bound or until the bound renderbuffer object is deleted with {@link OORenderbuffer#finalize}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param renderbuffer Specifies the name of a renderbuffer object.
     * 
     * @see #getBindedRenderbuffer
     * @see OORenderbuffer#finalize
     * @see OOGLES20FramebufferAttachment#attachRenderbuffer
     * @see OORenderbuffer#OORenderbuffer
     * @see #setStorage
     */
    public void bind(OORenderbuffer renderbuffer) {
        if (renderbuffer == null) {
            OOGLES20.backEnd.glBindRenderbuffer(OpenGLES20.GL_RENDERBUFFER, 0);
        } else {
            OOGLES20.backEnd.glBindRenderbuffer(OpenGLES20.GL_RENDERBUFFER, renderbuffer.getHandle());
        }
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code bind(null)}.</p>
     * 
     * @see #bind
     */
    public void unbind() {
        this.bind(null);
    }
    
    /**
     * <p>Create and initialize a renderbuffer object's data store.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glRenderbufferStorage}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setStorage} establishes the data storage, format and dimensions of a renderbuffer object's image. Any
     * existing data store for the renderbuffer is deleted and the contents of the new data store are undefined.</p>
     * 
     * <p>An implementation may vary its allocation of internal component resolution based on any {@link #setStorage}
     * parameter, but the allocation and chosen internal format must not be a function of any other state and cannot be
     * changed once they are established. The actual resolution in bits of each component of the allocated image can be
     * queried with {@link #getColorRedBits}, {@link #getColorGreenBits}, {@link #getColorBlueBits},
     * {@link #getColorAlphaBits}, {@link #getDepthBits}, {@link #getStencilBits}.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if target is not GL_RENDERBUFFER. -->
     *     <!-- GL_INVALID_ENUM is generated if internalformat is not an accepted format. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code width} or {@code height} is less than zero or
     *     greater than {OOGLES20Implementation#getMaximumRenderbufferSize}.</li>
     *     <li>{@link OOError#OUT_OF_MEMORY} is generated if the implementation is unable to create a data store with
     *     the requested {@code width} and {@code height}.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the reserved renderbuffer object name {@code null} is
     *     bound.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param internalFormat Specifies the color-renderable, depth-renderable or stencil-renderable format of the
     * renderbuffer.
     * @param width Specifies the width of the renderbuffer in pixels.
     * @param height Specifies the height of the renderbuffer in pixels.
     * 
     * @see #bind
     * @see OORenderbuffer#finalize
     * @see OOGLES20FramebufferAttachment#attachRenderbuffer
     * @see OORenderbuffer#OORenderbuffer
     */
    public void setStorage(OORenderbufferFormat internalFormat, int width, int height) {
        OOGLES20.backEnd.glRenderbufferStorage(OpenGLES20.GL_RENDERBUFFER, internalFormat.getGLConstant(), width,
                height);
    }
    
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(1);
    
    /**
     * <p>Returns the name of the currently bound renderbuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_RENDERBUFFER_BINDING}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the name of the currently bound renderbuffer. The initial value is {@code null}, indicating no
     * renderbuffer is bound.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The name of the currently bound renderbuffer.
     * 
     * @see #bind
     */
    public OORenderbuffer getBindedRenderbuffer() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_RENDERBUFFER_BINDING, OOGLES20Renderbuffer.intBuffer);
        return OORenderbuffer.getRenderbuffer(OOGLES20Renderbuffer.intBuffer.get(0));
    }
    
    /**
     * <p>Returns the width in pixels of the image of the currently bound renderbuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetRenderbufferParameteriv} with argument {@link
     * OpenGLES20#GL_RENDERBUFFER_WIDTH}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the width in pixels of the image of the currently bound renderbuffer. The initial value is {@code 0}.
     * </p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The width in pixels of the image of the currently bound renderbuffer.
     */
    public int getWidth() {
        OOGLES20.backEnd.glGetRenderbufferParameteriv(OpenGLES20.GL_RENDERBUFFER, OpenGLES20.GL_RENDERBUFFER_WIDTH,
                OOGLES20Renderbuffer.intBuffer);
        return OOGLES20Renderbuffer.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the height in pixels of the image of the currently bound renderbuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetRenderbufferParameteriv} with argument {@link
     * OpenGLES20#GL_RENDERBUFFER_HEIGHT}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the height in pixels of the image of the currently bound renderbuffer. The initial value is {@code 0}.
     * </p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The height in pixels of the image of the currently bound renderbuffer.
     */
    public int getHeight() {
        OOGLES20.backEnd.glGetRenderbufferParameteriv(OpenGLES20.GL_RENDERBUFFER, OpenGLES20.GL_RENDERBUFFER_HEIGHT,
                OOGLES20Renderbuffer.intBuffer);
        return OOGLES20Renderbuffer.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the internal format of the image of the currently bound renderbuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetRenderbufferParameteriv} with argument {@link
     * OpenGLES20#GL_RENDERBUFFER_INTERNAL_FORMAT}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the internal format of the image of the currently bound renderbuffer. The initial value is {@link
     * OORenderbufferFormat#RGBA4}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The internal format of the image of the currently bound renderbuffer.
     */
    public OORenderbufferFormat getInternalFormat() {
        OOGLES20.backEnd.glGetRenderbufferParameteriv(OpenGLES20.GL_RENDERBUFFER,
                OpenGLES20.GL_RENDERBUFFER_INTERNAL_FORMAT, OOGLES20Renderbuffer.intBuffer);
        return OORenderbufferFormat.valueOf(OOGLES20Renderbuffer.intBuffer.get(0));
    }
    
    /**
     * <p>Returns the resolution in bits for the red component of the image of the currently bound renderbuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetRenderbufferParameteriv} with argument {@link
     * OpenGLES20#GL_RENDERBUFFER_RED_SIZE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the resolution in bits for the red component of the image of the currently bound renderbuffer. The
     * initial value is {@code 0}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The resolution in bits for the red component of the image of the currently bound renderbuffer.
     */
    public int getColorRedBits() {
        OOGLES20.backEnd.glGetRenderbufferParameteriv(OpenGLES20.GL_RENDERBUFFER, OpenGLES20.GL_RENDERBUFFER_RED_SIZE,
                OOGLES20Renderbuffer.intBuffer);
        return OOGLES20Renderbuffer.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the resolution in bits for the green component of the image of the currently bound renderbuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetRenderbufferParameteriv} with argument {@link
     * OpenGLES20#GL_RENDERBUFFER_GREEN_SIZE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the resolution in bits for the green component of the image of the currently bound renderbuffer. The
     * initial value is {@code 0}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The resolution in bits for the green component of the image of the currently bound renderbuffer.
     */
    public int getColorGreenBits() {
        OOGLES20.backEnd.glGetRenderbufferParameteriv(OpenGLES20.GL_RENDERBUFFER, OpenGLES20.GL_RENDERBUFFER_GREEN_SIZE,
                OOGLES20Renderbuffer.intBuffer);
        return OOGLES20Renderbuffer.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the resolution in bits for the blue component of the image of the currently bound renderbuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetRenderbufferParameteriv} with argument {@link
     * OpenGLES20#GL_RENDERBUFFER_BLUE_SIZE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the resolution in bits for the blue component of the image of the currently bound renderbuffer. The
     * initial value is {@code 0}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The resolution in bits for the blue component of the image of the currently bound renderbuffer.
     */
    public int getColorBlueBits() {
        OOGLES20.backEnd.glGetRenderbufferParameteriv(OpenGLES20.GL_RENDERBUFFER, OpenGLES20.GL_RENDERBUFFER_BLUE_SIZE,
                OOGLES20Renderbuffer.intBuffer);
        return OOGLES20Renderbuffer.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the resolution in bits for the alpha component of the image of the currently bound renderbuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetRenderbufferParameteriv} with argument {@link
     * OpenGLES20#GL_RENDERBUFFER_ALPHA_SIZE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the resolution in bits for the alpha component of the image of the currently bound renderbuffer. The
     * initial value is {@code 0}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The resolution in bits for the alpha component of the image of the currently bound renderbuffer.
     */
    public int getColorAlphaBits() {
        OOGLES20.backEnd.glGetRenderbufferParameteriv(OpenGLES20.GL_RENDERBUFFER, OpenGLES20.GL_RENDERBUFFER_ALPHA_SIZE,
                OOGLES20Renderbuffer.intBuffer);
        return OOGLES20Renderbuffer.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the resolution in bits for the depth component of the image of the currently bound renderbuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetRenderbufferParameteriv} with argument {@link
     * OpenGLES20#GL_RENDERBUFFER_DEPTH_SIZE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the resolution in bits for the depth component of the image of the currently bound renderbuffer. The
     * initial value is {@code 0}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The resolution in bits for the depth component of the image of the currently bound renderbuffer.
     */
    public int getDepthBits() {
        OOGLES20.backEnd.glGetRenderbufferParameteriv(OpenGLES20.GL_RENDERBUFFER, OpenGLES20.GL_RENDERBUFFER_DEPTH_SIZE,
                OOGLES20Renderbuffer.intBuffer);
        return OOGLES20Renderbuffer.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the resolution in bits for the stencil component of the image of the currently bound renderbuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetRenderbufferParameteriv} with argument {@link
     * OpenGLES20#GL_RENDERBUFFER_STENCIL_SIZE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the resolution in bits for the stencil component of the image of the currently bound renderbuffer. The
     * initial value is {@code 0}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The resolution in bits for the stencil component of the image of the currently bound renderbuffer.
     */
    public int getStencilBits() {
        OOGLES20.backEnd.glGetRenderbufferParameteriv(OpenGLES20.GL_RENDERBUFFER,
                OpenGLES20.GL_RENDERBUFFER_STENCIL_SIZE, OOGLES20Renderbuffer.intBuffer);
        return OOGLES20Renderbuffer.intBuffer.get(0);
    }
}
