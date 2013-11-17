package ro.spatarel.android.oogles20;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * <p>Class modeling the vertex attributes.</p>
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
public class OOAttribute {
    
    private int handle;
    
    OOAttribute(int handle) {
        this.handle = handle;
    }
    
    int getHandle() {
        return this.handle;
    }
    
    /**
     * <p>Enable a generic vertex attribute array.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glEnableVertexAttribArray}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link OOAttribute#enableArray} enables the generic vertex attribute array. {@link
     * OOAttribute#disableArray} disables the generic vertex attribute array. By default, all client-side
     * capabilities are disabled, including all generic vertex attribute arrays. If enabled, the values in the generic
     * vertex attribute array will be accessed and used for rendering when calls are made to vertex array commands such
     * as {@link OOGLES20Framebuffer#drawArrays} or {@link OOGLES20Framebuffer#drawElements}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see OOGLES20Implementation#getMaximumAttributeVectors
     * @see #isArrayEnabled
     * @see OOGLES20Framebuffer#drawArrays
     * @see OOGLES20Framebuffer#drawElements
     * @see OOAttribute#setForAll1f
     * @see OOAttribute#setForAll2f
     * @see OOAttribute#setForAll3f
     * @see OOAttribute#setForAll4f
     * @see OOAttribute#setBuffer
     * @see OOAttribute#setBuffer1fv
     * @see OOAttribute#setBuffer2fv
     * @see OOAttribute#setBuffer3fv
     * @see OOAttribute#setBuffer4fv
     */
    public void enableArray() {
        OOGLES20.backEnd.glEnableVertexAttribArray(this.handle);
    }
    
    /**
     * <p>Disable a generic vertex attribute array.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDisableVertexAttribArray}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link OOAttribute#enableArray} enables the generic vertex attribute array. {@link
     * OOAttribute#disableArray} disables the generic vertex attribute array. By default, all client-side
     * capabilities are disabled, including all generic vertex attribute arrays. If enabled, the values in the generic
     * vertex attribute array will be accessed and used for rendering when calls are made to vertex array commands such
     * as {@link OOGLES20Framebuffer#drawArrays} or {@link OOGLES20Framebuffer#drawElements}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see OOGLES20Implementation#getMaximumAttributeVectors
     * @see #isArrayEnabled
     * @see OOGLES20Framebuffer#drawArrays
     * @see OOGLES20Framebuffer#drawElements
     * @see OOAttribute#setForAll1f
     * @see OOAttribute#setForAll2f
     * @see OOAttribute#setForAll3f
     * @see OOAttribute#setForAll4f
     * @see OOAttribute#setBuffer
     * @see OOAttribute#setBuffer1fv
     * @see OOAttribute#setBuffer2fv
     * @see OOAttribute#setBuffer3fv
     * @see OOAttribute#setBuffer4fv
     */
    public void disableArray() {
        OOGLES20.backEnd.glDisableVertexAttribArray(this.handle);
    }
    
    /**
     * <p>Specify the universal value of the generic vertex attribute.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glVertexAttrib1f}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Specify the first component of the universal value of the generic vertex attribute. The second and third
     * components will be set to {@code 0} and the fourth component will be set to {@code 1}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param x The first component of the universal value.
     */
    public void setForAll1f(float x) {
        OOGLES20.backEnd.glVertexAttrib1f(this.handle, x);
    }
    
    /**
     * <p>Specify the universal value of the generic vertex attribute.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glVertexAttrib1fv}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Specify the first component of the universal value of the generic vertex attribute. The second and third
     * components will be set to {@code 0} and the fourth component will be set to {@code 1}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param values A pointer to the first component of the universal value.
     */
    public void setForAll1fv(FloatBuffer values) {
        OOGLES20.backEnd.glVertexAttrib1fv(this.handle, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setForAll1fv(OOGLES20.createFloatBuffer(values, offset));}.</p>
     * 
     * @param values Specifies an array that contains the first component of the universal value.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #setForAll1fv
     */
    public void setForAll1fv(float[] values, int offset) {
        this.setForAll1fv(OOGLES20.createFloatBuffer(values, offset));
    }
    
    /**
     * <p>Specify the universal value of the generic vertex attribute.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glVertexAttrib2f}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Specify the first two components of the universal value of the generic vertex attribute. The third component
     * will be set to {@code 0} and the fourth component will be set to {@code 1}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param x The first component of the universal value.
     * @param y The second component of the universal value.
     */
    public void setForAll2f(float x, float y) {
        OOGLES20.backEnd.glVertexAttrib2f(this.handle, x, y);
    }
    
    /**
     * <p>Specify the universal value of the generic vertex attribute.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glVertexAttrib2fv}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Specify the first two components of the universal value of the generic vertex attribute. The third component
     * will be set to {@code 0} and the fourth component will be set to {@code 1}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param values A pointer to the first two components of the universal value.
     */
    public void setForAll2fv(FloatBuffer values) {
        OOGLES20.backEnd.glVertexAttrib2fv(this.handle, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setForAll2fv(OOGLES20.createFloatBuffer(values, offset));}.</p>
     * 
     * @param values Specifies an array that contains the first two components of the universal value.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #setForAll2fv
     */
    public void setForAll2fv(float[] values, int offset) {
        this.setForAll2fv(OOGLES20.createFloatBuffer(values, offset));
    }
    
    /**
     * <p>Specify the universal value of the generic vertex attribute.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glVertexAttrib3f}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Specify the first three components of the universal value of the generic vertex attribute. The fourth
     * component will be set to {@code 1}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param x The first component of the universal value.
     * @param y The second component of the universal value.
     * @param z The third component of the universal value.
     */
    public void setForAll3f(float x, float y, float z) {
        OOGLES20.backEnd.glVertexAttrib3f(this.handle, x, y, z);
    }
    
    /**
     * <p>Specify the universal value of the generic vertex attribute.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glVertexAttrib3fv}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Specify the first three components of the universal value of the generic vertex attribute. The fourth
     * component will be set to {@code 1}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param values A pointer to the first three components of the universal value.
     */
    public void setForAll3fv(FloatBuffer values) {
        OOGLES20.backEnd.glVertexAttrib3fv(this.handle, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setForAll3fv(OOGLES20.createFloatBuffer(values, offset));}.</p>
     * 
     * @param values Specifies an array that contains the first three components of the universal value.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #setForAll3fv
     */
    public void setForAll3fv(float[] values, int offset) {
        this.setForAll3fv(OOGLES20.createFloatBuffer(values, offset));
    }
    
    /**
     * <p>Specify the universal value of the generic vertex attribute.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glVertexAttrib4f}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Specify the four components of the universal value of the generic vertex attribute.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param x The first component of the universal value.
     * @param y The second component of the universal value.
     * @param z The third component of the universal value.
     * @param w The fourth component of the universal value.
     */
    public void setForAll4f(float x, float y, float z, float w) {
        OOGLES20.backEnd.glVertexAttrib4f(this.handle, x, y, z, w);
    }
    
    /**
     * <p>Specify the universal value of the generic vertex attribute.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glVertexAttrib4fv}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Specify the four components of the universal value of the generic vertex attribute.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param values A pointer to the four components of the universal value.
     */
    public void setForAll4fv(FloatBuffer values) {
        OOGLES20.backEnd.glVertexAttrib4fv(this.handle, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setForAll4fv(OOGLES20.createFloatBuffer(values, offset));}.</p>
     * 
     * @param values Specifies an array that contains the four components of the universal value.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #setForAll4fv
     */
    public void setForAll4fv(float[] values, int offset) {
        this.setForAll4fv(OOGLES20.createFloatBuffer(values, offset));
    }
    
    /**
     * <p>Define an array of generic vertex attribute data.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glVertexAttribPointer}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@code #setBuffer} specifies the location and data format of the array of the generic vertex attribute to use
     * when rendering. {@code size} specifies the number of components per attribute and must be {@code 1}, {@code 2},
     * {@code 3} or {@code 4}. {@code type} specifies the data type of each component and {@code stride} specifies the
     * byte stride from one attribute to the next, allowing vertices and attributes to be packed into a single array or
     * stored in separate arrays. If set to {@code true}, {@code normalized} indicates that values stored in an integer
     * format are to be mapped to the range {@code [-1, 1]} (for signed values) or {@code [0, 1]} (for unsigned values)
     * when they are accessed and converted to floating point. Otherwise, values will be converted to floats directly
     * without normalization.</p>
     * 
     * <p>When a generic vertex attribute array is specified, {@code size}, {@code type}, {@code normalized},
     * {@code stride} and {@code pointer} are saved as client-side state, in addition to the current vertex array buffer
     * object binding.</p>
     * 
     * <p>To enable and disable a generic vertex attribute array, call {@link #enableArray} and {@link #disableArray}.
     * If enabled, the generic vertex attribute array is used when {@link OOGLES20Framebuffer#drawArrays} or {@link
     * OOGLES20Framebuffer#drawElements} is called.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Each generic vertex attribute array is initially disabled and isn't accessed when {@link
     * OOGLES20Framebuffer#drawElements} or {@link OOGLES20Framebuffer#drawArrays} is called.</p>
     * 
     * <p>{@link #setBuffer} is typically implemented on the client side.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if type is not an accepted value. -->
     *     <!-- GL_INVALID_VALUE is generated if index is greater than or equal to GL_MAX_VERTEX_ATTRIBS. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code size} is not {@code 1}, {@code 2}, {@code 3} or
     *     {@code 4}.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code stride} is negative.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param size Specifies the number of components per generic vertex attribute. Must be {@code 1}, {@code 2},
     * {@code 3} or {@code 4}. The initial value is {@code 4}.
     * @param type Specifies the data type of each component in the array. The initial value is
     * {@link OOAttributeClientDataType#FLOAT}.
     * @param normalized Specifies whether fixed-point data values should be normalized {@code true} or converted
     * directly as fixed-point values {@code false} when they are accessed.
     * @param stride Specifies the byte offset between consecutive generic vertex attributes. If {@code stride} is
     * {@code 0}, the generic vertex attributes are understood to be tightly packed in the array. The initial value is
     * {@code 0}.
     * @param buffer Specifies a pointer to the first component of the first generic vertex attribute in the array.
     * 
     * @see OOGLES20Implementation#getMaximumAttributeVectors
     * @see #isArrayEnabled
     * @see #getArraySize
     * @see #getArrayType
     * @see #isArrayNormalized
     * @see #getArrayStride
     * @see #getArrayBufferBinding
     * @see OOGLES20Buffer#getBindedBuffer
     * @see OOGLES20Buffer#bind
     * @see OOGLES20Buffer#unbind
     * @see OOAttribute#disableArray
     * @see OOGLES20Framebuffer#drawArrays
     * @see OOGLES20Framebuffer#drawElements
     * @see OOAttribute#enableArray
     * @see OOAttribute#setForAll1f
     * @see OOAttribute#setForAll2f
     * @see OOAttribute#setForAll3f
     * @see OOAttribute#setForAll4f
     */
    public void setBuffer(int size, OOAttributeClientDataType type, boolean normalized, int stride,
            Buffer buffer) {
        OOGLES20.backEnd.glVertexAttribPointer(this.handle, size, type.getGLConstant(), normalized, stride, buffer);
    }
    
    /**
     * <p>Define an array of generic vertex attribute data.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glVertexAttribPointer}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@code #setBuffer} specifies the location and data format of the array of the generic vertex attribute to use
     * when rendering. {@code size} specifies the number of components per attribute and must be {@code 1}, {@code 2},
     * {@code 3} or {@code 4}. {@code type} specifies the data type of each component and {@code stride} specifies the
     * byte stride from one attribute to the next, allowing vertices and attributes to be packed into a single array or
     * stored in separate arrays. If set to {@code true}, {@code normalized} indicates that values stored in an integer
     * format are to be mapped to the range {@code [-1, 1]} (for signed values) or {@code [0, 1]} (for unsigned values)
     * when they are accessed and converted to floating point. Otherwise, values will be converted to floats directly
     * without normalization.</p>
     * 
     * <p>When a non-{@code null} named buffer object is bound to the {@link OOGLES20#arrayBuffer} target (see {@link
     * OOGLES20Buffer#bind}) while a generic vertex attribute array is specified, {@code offset} represents a byte
     * offset into the buffer object's data store. Also, the buffer object binding ({@link
     * OOGLES20Buffer#getBindedBuffer}) is saved as generic vertex attribute array client-side state ({@link
     * #getArrayBufferBinding}).</p>
     * 
     * <p>When a generic vertex attribute array is specified, {@code size}, {@code type}, {@code normalized},
     * {@code stride} and {@code pointer} are saved as client-side state, in addition to the current vertex array buffer
     * object binding.</p>
     * 
     * <p>To enable and disable a generic vertex attribute array, call {@link #enableArray} and {@link #disableArray}.
     * If enabled, the generic vertex attribute array is used when {@link OOGLES20Framebuffer#drawArrays} or {@link
     * OOGLES20Framebuffer#drawElements} is called.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Each generic vertex attribute array is initially disabled and isn't accessed when {@link
     * OOGLES20Framebuffer#drawElements} or {@link OOGLES20Framebuffer#drawArrays} is called.</p>
     * 
     * <p>{@link #setBuffer} is typically implemented on the client side.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if type is not an accepted value. -->
     *     <!-- GL_INVALID_VALUE is generated if index is greater than or equal to GL_MAX_VERTEX_ATTRIBS. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code size} is not {@code 1}, {@code 2}, {@code 3} or
     *     {@code 4}.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code stride} is negative.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param size Specifies the number of components per generic vertex attribute. Must be {@code 1}, {@code 2},
     * {@code 3} or {@code 4}. The initial value is {@code 4}.
     * @param type Specifies the data type of each component in the array. The initial value is
     * {@code OOAttributeClientDataType#FLOAT}.
     * @param normalized Specifies whether fixed-point data values should be normalized {@code true} or converted
     * directly as fixed-point values {@code false} when they are accessed.
     * @param stride Specifies the byte offset between consecutive generic vertex attributes. If {@code stride} is
     * {@code 0}, the generic vertex attributes are understood to be tightly packed in the array. The initial value is
     * {@code 0}.
     * @param offset Specifies the offset to the first component of the first generic vertex attribute in the array. The
     * initial value is 0.
     * 
     * @see OOGLES20Implementation#getMaximumAttributeVectors
     * @see #isArrayEnabled
     * @see #getArraySize
     * @see #getArrayType
     * @see #isArrayNormalized
     * @see #getArrayStride
     * @see #getArrayBufferBinding
     * @see OOGLES20Buffer#getBindedBuffer
     * @see OOGLES20Buffer#bind
     * @see OOGLES20Buffer#unbind
     * @see OOAttribute#disableArray
     * @see OOGLES20Framebuffer#drawArrays
     * @see OOGLES20Framebuffer#drawElements
     * @see OOAttribute#enableArray
     * @see OOAttribute#setForAll1f
     * @see OOAttribute#setForAll2f
     * @see OOAttribute#setForAll3f
     * @see OOAttribute#setForAll4f
     */
    public void setBuffer(int size, OOAttributeClientDataType type, boolean normalized, int stride, int offset) {
        OOGLES20.backEnd.glVertexAttribPointer(this.handle, size, type.getGLConstant(), normalized, stride, offset);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setBuffer(1, OOAttributeClientDataType.FLOAT, false, 1 * OOGLES20.FLOAT_SIZE, 0);}.</p>
     * 
     * @see #setBuffer
     */
    public void setBuffer1fv() {
        this.setBuffer(1, OOAttributeClientDataType.FLOAT, false, 1 * OOGLES20.FLOAT_SIZE, 0);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setBuffer(1, OOAttributeClientDataType.FLOAT, false, 1 * OOGLES20.FLOAT_SIZE, offset);}.</p>
     * 
     * @param offset Specifies the offset to the first component of the first generic vertex attribute in the array.
     * 
     * @see #setBuffer
     */
    public void setBuffer1fv(int offset) {
        this.setBuffer(1, OOAttributeClientDataType.FLOAT, false, 1 * OOGLES20.FLOAT_SIZE, offset);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setBuffer(2, OOAttributeClientDataType.FLOAT, false, 2 * OOGLES20.FLOAT_SIZE, 0);}.</p>
     * 
     * @see #setBuffer
     */
    public void setBuffer2fv() {
        this.setBuffer(2, OOAttributeClientDataType.FLOAT, false, 2 * OOGLES20.FLOAT_SIZE, 0);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setBuffer(2, OOAttributeClientDataType.FLOAT, false, 2 * OOGLES20.FLOAT_SIZE, offset);}.</p>
     * 
     * @param offset Specifies the offset to the first component of the first generic vertex attribute in the array.
     * 
     * @see #setBuffer
     */
    public void setBuffer2fv(int offset) {
        this.setBuffer(2, OOAttributeClientDataType.FLOAT, false, 2 * OOGLES20.FLOAT_SIZE, offset);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setBuffer(3, OOAttributeClientDataType.FLOAT, false, 3 * OOGLES20.FLOAT_SIZE, 0);}.</p>
     * 
     * @see #setBuffer
     */
    public void setBuffer3fv() {
        this.setBuffer(3, OOAttributeClientDataType.FLOAT, false, 3 * OOGLES20.FLOAT_SIZE, 0);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setBuffer(3, OOAttributeClientDataType.FLOAT, false, 3 * OOGLES20.FLOAT_SIZE, offset);}.</p>
     * 
     * @param offset Specifies the offset to the first component of the first generic vertex attribute in the array.
     * 
     * @see #setBuffer
     */
    public void setBuffer3fv(int offset) {
        this.setBuffer(3, OOAttributeClientDataType.FLOAT, false, 3 * OOGLES20.FLOAT_SIZE, offset);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setBuffer(4, OOAttributeClientDataType.FLOAT, false, 4 * OOGLES20.FLOAT_SIZE, 0);}.</p>
     * 
     * @see #setBuffer
     */
    public void setBuffer4fv() {
        this.setBuffer(4, OOAttributeClientDataType.FLOAT, false, 4 * OOGLES20.FLOAT_SIZE, 0);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setBuffer(4, OOAttributeClientDataType.FLOAT, false, 4 * OOGLES20.FLOAT_SIZE, offset);}.</p>
     * 
     * @param offset Specifies the offset to the first component of the first generic vertex attribute in the array.
     * 
     * @see #setBuffer
     */
    public void setBuffer4fv(int offset) {
        this.setBuffer(4, OOAttributeClientDataType.FLOAT, false, 4 * OOGLES20.FLOAT_SIZE, offset);
    }
    
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(1);
    private static FloatBuffer floatBuffer = OOGLES20.createFloatBuffer(4);
    
    /**
     * <p>Returns {@code true} if the vertex attribute array is enabled and {@code false} if it is disabled. The initial
     * value is {@code false}.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetVertexAttribiv} with argument {@link
     * OpenGLES20#GL_VERTEX_ATTRIB_ARRAY_ENABLED}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns {@code true} if the vertex attribute array is enabled and {@code false} if it is disabled. The initial
     * value is {@code false}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return {@code true} if the vertex attribute array is enabled and {@code false} if it is disabled.
     */
    public boolean isArrayEnabled() {
        OOGLES20.backEnd.glGetVertexAttribiv(this.handle, OpenGLES20.GL_VERTEX_ATTRIB_ARRAY_ENABLED,
                OOAttribute.intBuffer);
        return OOAttribute.intBuffer.get(0) != OpenGLES20.GL_FALSE;
    }
    
    /**
     * <p>Returns the size of the vertex attribute array.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetVertexAttribiv} with argument {@link
     * OpenGLES20#GL_VERTEX_ATTRIB_ARRAY_SIZE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the size of the vertex attribute array. The size is the number of values for each element of the
     * vertex attribute array and it will be {@code 1}, {@code 2}, {@code 3} or {@code 4}. The initial value is
     * {@code 4}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The size of the vertex attribute array.
     */
    public int getArraySize() {
        OOGLES20.backEnd.glGetVertexAttribiv(this.handle, OpenGLES20.GL_VERTEX_ATTRIB_ARRAY_SIZE,
                OOAttribute.intBuffer);
        return OOAttribute.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the array stride for (number of bytes between successive elements in) the vertex attribute array.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetVertexAttribiv} with argument {@link
     * OpenGLES20#GL_VERTEX_ATTRIB_ARRAY_STRIDE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the array stride for (number of bytes between successive elements in) the vertex attribute array. A
     * value of {@code 0} indicates that the array elements are stored sequentially in memory. The initial value is
     * {@code 0}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The array stride for (number of bytes between successive elements in) the vertex attribute array.
     */
    public int getArrayStride() {
        OOGLES20.backEnd.glGetVertexAttribiv(this.handle, OpenGLES20.GL_VERTEX_ATTRIB_ARRAY_STRIDE,
                OOAttribute.intBuffer);
        return OOAttribute.intBuffer.get(0);
    }
    
    /**
     * <p>Returns an enum constant indicating the array type for the vertex attribute array.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetVertexAttribiv} with argument {@link
     * OpenGLES20#GL_VERTEX_ATTRIB_ARRAY_TYPE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an enum constant indicating the array type for the vertex attribute array. The initial value is {@link
     * OOAttributeClientDataType#FLOAT}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return An enum constant indicating the array type for the vertex attribute array.
     */
    public OOAttributeClientDataType getArrayType() {
        OOGLES20.backEnd.glGetVertexAttribiv(this.handle, OpenGLES20.GL_VERTEX_ATTRIB_ARRAY_TYPE,
                OOAttribute.intBuffer);
        return OOAttributeClientDataType.valueOf(OOAttribute.intBuffer.get(0));
    }
    
    /**
     * <p>Returns {@code true} if fixed-point data types for the vertex attribute array are normalized when they are
     * converted to floating point and {@code false} otherwise.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetVertexAttribiv} with argument {@link
     * OpenGLES20#GL_VERTEX_ATTRIB_ARRAY_NORMALIZED}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns {@code true} if fixed-point data types for the vertex attribute array are normalized when they are
     * converted to floating point and {@code false} otherwise. The initial value is {@code false}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return {@code true} if fixed-point data types for the vertex attribute array are normalized when they are
     * converted to floating point and {@code false} otherwise.
     */
    public boolean isArrayNormalized() {
        OOGLES20.backEnd.glGetVertexAttribiv(this.handle, OpenGLES20.GL_VERTEX_ATTRIB_ARRAY_NORMALIZED,
                OOAttribute.intBuffer);
        return OOAttribute.intBuffer.get(0) != OpenGLES20.GL_FALSE;
    }
    
    /**
     * <p>Returns the name of the buffer object currently bound to the binding point corresponding to generic vertex
     * attribute array.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetVertexAttribiv} with argument {@link
     * OpenGLES20#GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the name of the buffer object currently bound to the binding point corresponding to generic vertex
     * attribute array. If no buffer object is bound, {@code null} is returned. The initial value is {@code null}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The name of the buffer object currently bound to the binding point corresponding to generic vertex
     * attribute array.
     */
    public OOBuffer getArrayBufferBinding() {
        OOGLES20.backEnd.glGetVertexAttribiv(this.handle, OpenGLES20.GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING,
                OOAttribute.intBuffer);
        return OOBuffer.getBuffer(OOAttribute.intBuffer.get(0));
    }
    
    /**
     * <p>Returns four values that represent the current value for the generic vertex attribute.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetVertexAttribiv} with argument {@link
     * OpenGLES20#GL_CURRENT_VERTEX_ATTRIB}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns four values that represent the current value for the generic vertex attribute. The initial value is
     * {@code (0, 0, 0, 1)}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return Four values that represent the current value for the generic vertex attribute.
     */
    public float[] getCurrentValue() {
        OOGLES20.backEnd.glGetVertexAttribfv(this.handle, OpenGLES20.GL_CURRENT_VERTEX_ATTRIB,
                OOAttribute.floatBuffer);
        float[] value = new float[4];
        value[0] = OOAttribute.floatBuffer.get(0);
        value[1] = OOAttribute.floatBuffer.get(1);
        value[2] = OOAttribute.floatBuffer.get(2);
        value[3] = OOAttribute.floatBuffer.get(3);
        return value;
    }
}
