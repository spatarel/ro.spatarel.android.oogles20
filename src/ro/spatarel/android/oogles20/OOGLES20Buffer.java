package ro.spatarel.android.oogles20;

import java.nio.Buffer;
import java.nio.IntBuffer;

/**
 * <p>Class grouping together the methods managing the {@link OpenGLES20#GL_ARRAY_BUFFER} or {@link
 * OpenGLES20#GL_ELEMENT_ARRAY_BUFFER} targets.</p>
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
public class OOGLES20Buffer {
    
    private final OOBufferType type;
    
    OOGLES20Buffer(OOBufferType type) {
        this.type = type;
    }
    
    /**
     * <p>Bind a named buffer object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glBindBuffer}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #bind} lets you create or use a named buffer object. Calling {@link #bind} on {@link
     * OOGLES20#arrayBuffer} or {@link OOGLES20#elementArrayBuffer} target and {@code buffer} set to the name of the new
     * buffer object binds the buffer object name to the target. When a buffer object is bound to a target, the previous
     * binding for that target is automatically broken.</p>
     * 
     * <p>There is no default buffer object for each buffer object target. Instead, {@code buffer} set to {@code null}
     * effectively unbinds any buffer object previously bound and restores client memory usage for that buffer object
     * target. Buffer object names and the corresponding buffer object contents are local to the shared object space of
     * the current GL rendering context.</p>
     * 
     * <p>You may use {@link OOBuffer#OOBuffer} to generate a set of new buffer object names.
     * 
     * <p>The state of a buffer object immediately after it is first bound is a zero-sized memory buffer with {@link
     * OOBufferUsage#STATIC_DRAW} usage.
     * 
     * <p>While a non-{@code null} buffer object name is bound, GL operations on the target to which it is bound affect
     * the bound buffer object and queries of the target to which it is bound return state from the bound buffer object.
     * While buffer object name {@code null} is bound, as in the initial state, attempts to modify or query state on the
     * target to which it is bound generates an {@link OOError#INVALID_OPERATION} error.</p>
     * 
     * <p>When vertex array pointer state is changed by a call to {@link OOAttribute#setBuffer}, the current
     * buffer object binding ({@link #getBindedBuffer}) is copied into the corresponding client state for the vertex
     * attrib array being changed, one of the indexed {@link OOAttribute#getArrayBufferBinding}. While a
     * non-{@code null} buffer object is bound to the {@link OOGLES20#arrayBuffer} target, calls to methods that
     * reference client-side memory should not be issued, calls to methods that reference an offset within the buffer
     * object measured in basic machine units should be used instead.</p>
     * 
     * <p>While a non-{@code null} buffer object is bound to the {@link OOGLES20#elementArrayBuffer} target, only calls
     * to {@link OOGLES20Framebuffer#drawElements} should be issued.</p>
     * 
     * <p>A buffer object binding created with {@link #bind} remains active until a different buffer object name is
     * bound to the same target or until the bound buffer object is deleted with {@link OOBuffer#finalize}.</p>
     * 
     * <p>Once created, a named buffer object may be re-bound to any target as often as needed. However, the GL
     * implementation may make choices about how to optimize the storage of a buffer object based on its initial binding
     * target.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2005 Addison-Wesley. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param buffer Specifies the name of a buffer object.
     */
    public void bind(OOBuffer buffer) {
        if (buffer == null) {
            OOGLES20.backEnd.glBindBuffer(this.type.getGLConstant(), 0);
        } else {
            OOGLES20.backEnd.glBindBuffer(this.type.getGLConstant(), buffer.getHandle());
        }
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code bind(null);}.</p>
     * 
     * @see #bind
     */
    public void unbind() {
        this.bind(null);
    }
    
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(1);
    
    /**
     * <p>Returns the name of the buffer object currently bound to the target.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_ARRAY_BUFFER_BINDING} or
     * {@link OpenGLES20#GL_ELEMENT_ARRAY_BUFFER_BINDING}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the name of the buffer object currently bound to the target. If no buffer object is bound to the
     * target, {@code null} is returned. The initial value is {@code null}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The name of the buffer object currently bound to the target.
     * 
     * @see #bind
     */
    public OOBuffer getBindedBuffer() {
        if (this.type == OOBufferType.ARRAY_BUFFER) {
            OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_ARRAY_BUFFER_BINDING, OOGLES20Buffer.intBuffer);
        } else { // this.type == OOBufferType.ELEMENT_ARRAY_BUFFER
            OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_ELEMENT_ARRAY_BUFFER_BINDING, OOGLES20Buffer.intBuffer);
        }
        return OOBuffer.getBuffer(OOGLES20Buffer.intBuffer.get(0));
    }
    
    /**
     * <p>Create and initialize a buffer object's data store.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glBufferData}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setData} creates a new data store for the buffer object currently bound to target. Any pre-existing
     * data store is deleted. The new data store is created with the specified {@code size} in bytes and {@code usage}.
     * If {@code data} is not {@code null}, the data store is initialized with data from this pointer.</p>
     * 
     * <p>{@code usage} is a hint to the GL implementation as to how a buffer object's data store will be accessed. This
     * enables the GL implementation to make more intelligent decisions that may significantly impact buffer object
     * performance. It does not, however, constrain the actual usage of the data store. {@code usage} can be broken down
     * into two parts: first, the frequency of access (modification and usage) and second, the nature of that access.
     * The frequency of access may be one of these:</p>
     * 
     * <dl>
     *     <dt>STREAM</dt>
     *         <dd>The data store contents will be modified once and used at most a few times.</dd>
     *     <dt>STATIC</dt>
     *         <dd>The data store contents will be modified once and used many times.</dd>
     *     <dt>DYNAMIC</dt>
     *         <dd>The data store contents will be modified repeatedly and used many times.</dd>
     * </dl>
     * 
     * <p>The nature of access must be:</p>
     * 
     * <dl>
     *     <dt>DRAW</dt>
     *         <dd>The data store contents are modified by the application and used as the source for GL drawing and
     *         image specification commands.</dd>
     * </dl></p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If {@code data} is {@code null}, a data store of the specified size is still created, but its contents remain
     * uninitialized and thus undefined.</p>
     * 
     * <p>Clients must align data elements consistent with the requirements of the client platform, with an additional
     * base-level requirement that an offset within a buffer to a datum comprising <i>N</i> be a multiple of <i>N</i>.
     * </p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if target is not GL_ARRAY_BUFFER or GL_ELEMENT_ARRAY_BUFFER. -->
     *     <!-- GL_INVALID_ENUM is generated if usage is not GL_STREAM_DRAW, GL_STATIC_DRAW or GL_DYNAMIC_DRAW. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code size} is negative.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the reserved buffer object name {@code null} is bound
     *     to the target.</li>
     *     <li>{@link OOError#OUT_OF_MEMORY} is generated if the GL is unable to create a data store with the specified
     *     {@code size}.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2005 Addison-Wesley. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param size Specifies the size in bytes of the buffer object's new data store.
     * @param data Specifies a pointer to data that will be copied into the data store for initialization or {@code
     * null} if no data is to be copied.
     * @param usage Specifies the expected usage pattern of the data store.
     * 
     * @see #bind
     * @see #setSubData
     * @see #getSize
     * @see #getUsage
     */
    public void setData(int size, Buffer data, OOBufferUsage usage) {
        OOGLES20.backEnd.glBufferData(this.type.getGLConstant(), size, data, usage.getGLConstant());
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setData(OOGLES20.getBufferElementarySize(data) * data.capacity(), data, usage);}.</p>
     * 
     * @param data Specifies a pointer to data that will be copied into the data store for initialization or {@code
     * null} if no data is to be copied.
     * @param usage Specifies the expected usage pattern of the data store.
     * 
     * @see #setData
     * @see OOGLES20#getBufferElementarySize
     * @see Buffer#capacity
     */
    public void setData(Buffer data, OOBufferUsage usage) {
        this.setData(OOGLES20.getBufferElementarySize(data) * data.capacity(), data, usage);
    }
    
    /**
     * <p>Update a subset of a buffer object's data store.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glBufferSubData}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setSubData} redefines some or all of the data store for the buffer object currently bound to the
     * target. Data starting at byte offset {@code offset} and extending for {@code size} bytes is copied to the data
     * store from the memory pointed to by {@code data}. An error is thrown if {@code offset} and {@code size} together
     * define a range beyond the bounds of the buffer object's data store.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>When replacing the entire data store, consider using {@link #setSubData} rather than completely recreating the
     * data store with {@link #setData}. This avoids the cost of reallocating the data store.</p>
     * 
     * <p>Consider using multiple buffer objects to avoid stalling the rendering pipeline during data store updates. If
     * any rendering in the pipeline makes reference to data in the buffer object being updated by {@link #setSubData},
     * especially from the specific region being updated, that rendering must drain from the pipeline before the data
     * store can be updated.</p>
     * 
     * <p>Clients must align data elements consistent with the requirements of the client platform, with an additional
     * base-level requirement that an offset within a buffer to a datum comprising <i>N</i> be a multiple of <i>N</i>.
     * </p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if target is not GL_ARRAY_BUFFER or GL_ELEMENT_ARRAY_BUFFER. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code offset} or {@code size} is negative or if together
     *     they define a region of memory that extends beyond the buffer object's allocated data store.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the reserved buffer object name {@code null} is bound
     *     to the target.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2005 Addison-Wesley. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param offset Specifies the offset into the buffer object's data store where data replacement will begin,
     * measured in bytes.
     * @param size Specifies the size in bytes of the data store region being replaced.
     * @param data Specifies a pointer to the new data that will be copied into the data store.
     * 
     * @see #bind
     * @see #setData
     */
    public void setSubData(int offset, int size, Buffer data) {
        OOGLES20.backEnd.glBufferSubData(this.type.getGLConstant(), offset, size, data);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setSubData(offset, OOGLES20.getBufferElementarySize(data) * data.capacity(), data);}.</p>
     * 
     * @param offset Specifies the offset into the buffer object's data store where data replacement will begin,
     * measured in bytes.
     * @param data Specifies a pointer to the new data that will be copied into the data store.
     * 
     * @see #setSubData
     * @see OOGLES20#getBufferElementarySize
     * @see Buffer#capacity
     */
    public void setSubData(int offset, Buffer data) {
        this.setSubData(offset, OOGLES20.getBufferElementarySize(data) * data.capacity(), data);
    }
    
    /**
     * <p>Returns the size of the buffer object, measured in bytes.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetBufferParameteriv} with argument {@link OpenGLES20#GL_BUFFER_SIZE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the size of the buffer object, measured in bytes. The initial value is 0.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the reserved buffer object name {@code null} is bound
     *     to target.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2005 Addison-Wesley. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The size of the buffer object, measured in bytes.
     * 
     * @see #bind
     * @see #setData
     */
    public int getSize() {
        OOGLES20.backEnd.glGetBufferParameteriv(this.type.getGLConstant(), OpenGLES20.GL_BUFFER_SIZE,
                OOGLES20Buffer.intBuffer);
        return intBuffer.get(0);
    }
    
    /**
     * <p>Returns the buffer object's usage pattern.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetBufferParameteriv} with argument {@link OpenGLES20#GL_BUFFER_USAGE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the buffer object's usage pattern. The initial value is {@link OOBufferUsage#STATIC_DRAW}.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the reserved buffer object name {@code null} is bound
     *     to target.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2005 Addison-Wesley. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The size of the buffer object, measured in bytes.
     * 
     * @see #bind
     * @see #setData
     */
    public OOBufferUsage getUsage() {
        OOGLES20.backEnd.glGetBufferParameteriv(this.type.getGLConstant(), OpenGLES20.GL_BUFFER_USAGE,
                OOGLES20Buffer.intBuffer);
        return OOBufferUsage.valueOf(intBuffer.get(0));
    }
}
