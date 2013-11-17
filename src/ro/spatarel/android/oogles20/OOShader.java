package ro.spatarel.android.oogles20;

import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Class modeling the shader objects.</p>
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
public class OOShader {
    
    private static Map<Integer, OOShader> shaders = new TreeMap<Integer, OOShader>();
    
    static OOShader getShader(int handle) {
        return OOShader.shaders.get(handle);
    }
    
    private int handle;
    
    private final int finalHandle;
    
    int getHandle() {
        return this.handle;
    }
    
    /**
     * <p>Create a shader object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glCreateShader}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link OOShader#OOShader} creates an empty shader object and returns a non-zero value by which it can be
     * referenced. A shader object is used to maintain the source code strings that define a shader. {@code type}
     * indicates the type of shader to be created. Two types of shaders are supported. A shader of type {@link
     * OOShaderType#VERTEX} is a shader that is intended to run on the programmable vertex processor. A shader of type
     * {@link OOShaderType#FRAGMENT} is a shader that is intended to run on the programmable fragment processor.</p>
     * 
     * <p>When created, a shader object's {@link #getType} parameter is set to either {@link OOShaderType#VERTEX} or
     * {@link OOShaderType#FRAGMENT}, depending on the value of {@code type}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Like texture objects, the name space for shader objects may be shared across a set of contexts, as long as the
     * server sides of the contexts share the same address space. If the name space is shared across contexts, any
     * attached objects and the data associated with those attached objects are shared as well.</p>
     * 
     * <p>Applications are responsible for providing the synchronization across API calls when objects are accessed from
     * different execution threads.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if shaderType is not an accepted value. -->
     *     <li>This function throws an {@link OOErrorOccuredCreatingObjectException} if an error occurs creating the
     *     shader object.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param type Specifies the type of shader to be created.
     * 
     * @see #getType
     * @see #getDeleteStatus
     * @see #getCompileStatus
     * @see #getInfoLogLength
     * @see #getSourceLength
     * @see #getInfoLog
     * @see #getSource
     * @see OOProgram#attachShader
     * @see #compile
     * @see #finalize
     * @see #setSource
     * @see #setBinary
     */
    public OOShader(OOShaderType type) {
        this.handle = OOGLES20.backEnd.glCreateShader(type.getGLConstant());
        this.finalHandle = this.handle;
        if (this.handle == 0) {
            throw new OOErrorOccuredCreatingObjectException();
        }
        OOShader.shaders.put(this.handle, this);
    }
    
    /**
     * <p>Delete the shader object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDeleteFramebuffers}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #finalize} frees the memory and invalidates the name associated with the shader object. This command
     * effectively undoes the effects of a call to {@link #OOShader}.</p>
     * 
     * <p>If a shader object to be deleted is attached to a program object, it will be flagged for deletion, but it will
     * not be deleted until it is no longer attached to any program object, for any rendering context (i.e., it must be
     * detached from wherever it was attached before it will be deleted).</p>
     * 
     * <p>To determine whether an object has been flagged for deletion, call {@link #getDeleteStatus}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see OOProgram#OOProgram
     * @see #OOShader
     * @see OOProgram#detachShader
     * @see OOGLES20#useProgram
     */
    public void delete() {
        if (this.handle != 0) {
            OOGLES20.backEnd.glDeleteShader(this.handle);
            OOShader.shaders.remove(this.handle);
            this.handle = 0;
        }
    }
    
    @Override
    protected void finalize() throws Throwable {
        this.delete();
        super.finalize();
    }
    
    /**
     * <p>Replace the source code in a shader object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glShaderSource}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>For implementations that support a shader compiler, {@link #setSource} sets the source code in the shader to
     * the source code in the strings specified by {@code sourceCode}. Any source code previously stored in the shader
     * object is completely replaced. The source code strings are not scanned or parsed at this time; they are simply
     * copied into the specified shader object.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Shader compiler support is optional and thus must be queried before use by calling {@link
     * OOGLES20Implementation#isShaderCompilerSupported}, {@link #compile}, {@link
     * OOGLES20Implementation#getPrecisionFormat} and {@link OOGLES20#releaseCompiler} will each generate {@link
     * OOError#INVALID_OPERATION} on implementations that do not support a shader compiler. Such implementations instead
     * offer the {@link #setBinary} alternative for supplying a pre-compiled shader binary.</p>
     * 
     * <p>OpenGL copies the shader source code strings when {@link #setSource} is called, so an application may free its
     * copy of the source code strings immediately after the function returns.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <h5>Errors</h5>
     *
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if a shader compiler is not supported.</li>
     *     <!-- GL_INVALID_VALUE is generated if shader is not a value generated by OpenGL. -->
     *     <!-- GL_INVALID_OPERATION is generated if shader is not a shader object. -->
     *     <!-- GL_INVALID_VALUE is generated if count is less than 0. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param sourceCode The source code to be loaded into the shader.
     * 
     * @see OOGLES20Implementation#isShaderCompilerSupported
     * @see #getSourceLength
     * @see #getSource
     * @see #compile
     * @see OOGLES20Implementation#getPrecisionFormat
     * @see #OOShader
     * @see #finalize
     */
    public void setSource(String sourceCode) {
        OOGLES20.backEnd.glShaderSource(this.handle, sourceCode);
    }
    
    /**
     * <p>Compile a shader object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glCompileShader}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>For implementations that support a shader compiler, {@link #compile} compiles the source code strings that
     * have been stored in the shader object.</p>
     * 
     * <p>The compilation status will be stored as part of the shader object's state. This value will be set to
     * {@code true} if the shader was compiled without errors and is ready for use and {@code false} otherwise. It can
     * be queried by calling {@link #getCompileStatus}.</p>
     * 
     * <p>Compilation of a shader can fail for a number of reasons as specified by the <i>OpenGL ES Shading Language
     * Specification</i>. Whether or not the compilation was successful, information about the compilation can be
     * obtained from the shader object's information log by calling {@link #getInfoLog}.
     * 
     * <h5>Notes</h5>
     * 
     * <p>Shader compiler support is optional and thus must be queried before use by calling {@link
     * OOGLES20Implementation#isShaderCompilerSupported}. {@link #setSource}, {@link #compile}, {@link
     * OOGLES20Implementation#getPrecisionFormat} and {@link OOGLES20#releaseCompiler} will each generate {@link
     * OOError#INVALID_OPERATION} on implementations that do not support a shader compiler. Such implementations instead
     * offer the {@link #setBinary} alternative for supplying a pre-compiled shader binary.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if a shader compiler is not supported.</li>
     *     <!-- GL_INVALID_VALUE is generated if shader is not a value generated by OpenGL. -->
     *     <!-- GL_INVALID_OPERATION is generated if shader is not a shader object. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see OOGLES20Implementation#isShaderCompilerSupported
     * @see #getInfoLog
     * @see #getCompileStatus
     * @see #OOShader
     * @see OOProgram#link
     * @see OOGLES20#releaseCompiler
     * @see #setSource
     * @see OOGLES20Implementation#getPrecisionFormat
     */
    public void compile() {
        OOGLES20.backEnd.glCompileShader(this.handle);
    }
    
    /**
     * <p>Load a precompiled shader binary.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glShaderBinary}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>For implementations that support them, {@link #setBinary} loads precompiled shader binaries. {@code binary}
     * points to precompiled binary shader code in client memory and {@code binaryFormat} denotes the format of the
     * pre-compiled code.</p>
     * 
     * <p>The binary image is decoded according to the extension specification defining the specified
     * {@code binaryFormat}. OpenGL ES defines no specific binary formats, but does provide a mechanism to obtain
     * symbolic constants for such formats provided by extensions. The number of shader binary formats supported can be
     * obtained by querying the value of {@link OOGLES20Implementation#getShaderBinaryFormatsCount}. The list of
     * specific binary formats supported can be obtained by querying the value of {@link
     * OOGLES20Implementation#getShaderBinaryFormats}.</p>
     * 
     * <p>If {@link #setBinary} fails, the old state of shader objects for which the binary was being loaded will not be
     * restored.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Shader binary support is optional and thus must be queried before use by calling {@link
     * OOGLES20Implementation#getShaderBinaryFormatsCount} and {@link OOGLES20Implementation#getShaderBinaryFormats}.
     * {@link #setBinary} generates {@link OOError#INVALID_OPERATION} on implementations that do not support any shader
     * binary formats. Such implementations instead offer the {@link #setSource} alternative for supplying OpenGL ES
     * Shading Language shader source for compilation.</p>
     * 
     * <p>If shader binary formats are supported, then an implementation may require that an optimized pair of vertex
     * and fragment shader binaries that were compiled together to be specified to {@link OOProgram#link}. Not
     * specifying an optimized pair my cause {@link OOProgram#link} to fail. Such a restriction, if it exists, will be
     * documented in the extension specification defining {@code binaryFormat}.</p>
     * 
     * <p>OpenGL copies the shader binary data when {@link #setBinary} is called, so an application may free its copy of
     * the data immediately after the function returns.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_ENUM} is generated if {@code binaryFormat} is not a supported format returned in
     *     {@link OOGLES20Implementation#getShaderBinaryFormats}.</li>
     *     <!-- GL_INVALID_VALUE is generated if any value in shaders is not a value generated by OpenGL. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if the format of the data pointed to by binary does not match
     *     {@code binaryFormat}.</li>
     *     <!-- GL_INVALID_VALUE is generated if n or length is negative. -->
     *     <!-- GL_INVALID_OPERATION is generated if any value in shaders is not a shader object or if there is more
     *     than one vertex shader object handle or more than one fragment shader object handle in shaders. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param binaryFormat Specifies the shader binary format.
     * @param binary Specifies a pointer to the shader binary data in client memory.
     * @param length Specifies the length of the shader binary data in bytes.
     * 
     * @see OOGLES20Implementation#getShaderBinaryFormatsCount
     * @see OOGLES20Implementation#getShaderBinaryFormats
     * @see #OOShader
     * @see #finalize
     * @see OOProgram#link
     */
    public void setBinary(int binaryFormat, Buffer binary, int length) {
        IntBuffer intBuffer = OOGLES20.createIntBuffer(new int[] { this.handle });
        OOGLES20.backEnd.glShaderBinary(1, intBuffer, binaryFormat, binary, length);
    }
    
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(1);
    
    /**
     * <p>Returns {@link OOShaderType#VERTEX} if shader is a vertex shader object and {@link OOShaderType#FRAGMENT} if
     * the shader is a fragment shader object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetShaderiv} with argument {@link OpenGLES20#GL_SHADER_TYPE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns {@link OOShaderType#VERTEX} if shader is a vertex shader object and {@link OOShaderType#FRAGMENT} if
     * the shader is a fragment shader object.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return {@link OOShaderType#VERTEX} if shader is a vertex shader object and {@link OOShaderType#FRAGMENT} if the
     * shader is a fragment shader object.
     */
    public OOShaderType getType() {
        OOGLES20.backEnd.glGetShaderiv(this.handle, OpenGLES20.GL_SHADER_TYPE, OOShader.intBuffer);
        return OOShaderType.valueOf(OOShader.intBuffer.get(0));
    }
    
    /**
     * <p>Returns {@code true} if the shader is currently flagged for deletion and {@code false} otherwise.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetShaderiv} with argument {@link OpenGLES20#GL_DELETE_STATUS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns {@code true} if the shader is currently flagged for deletion and {@code false} otherwise.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return {@code true} if the shader is currently flagged for deletion and {@code false} otherwise.
     */
    public boolean getDeleteStatus() {
        OOGLES20.backEnd.glGetShaderiv(this.finalHandle, OpenGLES20.GL_DELETE_STATUS, OOShader.intBuffer);
        return OOBoolean.getBool(OOShader.intBuffer.get(0));
    }
    
    /**
     * <p>For implementations that support a shader compiler, returns the length of the concatenation of the source
     * strings that make up the shader source for the shader, including the null termination character.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetShaderiv} with argument {@link OpenGLES20#GL_SHADER_SOURCE_LENGTH}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>For implementations that support a shader compiler, returns the length of the concatenation of the source
     * strings that make up the shader source for the shader, including the null termination character (i.e., the size
     * of the character buffer required to store the shader source). If no source code exists, {@code 0} is returned.
     * </p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return For implementations that support a shader compiler, the length of the concatenation of the source strings
     * that make up the shader source for the shader, including the null termination character.
     */
    public int getSourceLength() {
        OOGLES20.backEnd.glGetShaderiv(this.handle, OpenGLES20.GL_SHADER_SOURCE_LENGTH, OOShader.intBuffer);
        return OOShader.intBuffer.get(0);
    }
    
    /**
     * <p>Return the source code string from a shader object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetShaderSource}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #getSource} returns the concatenation of the source code strings from the shader object. The source
     * code strings for a shader object are the result of a previous call to {@link #setSource}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The source code string from a shader object.
     * 
     * @see #getSourceLength
     * @see #OOShader
     * @see #setSource
     */
    public String getSource() {
        int bufsize = this.getSourceLength();
        int[] length = new int[1];
        byte[] source = new byte[bufsize];
        OOGLES20.backEnd.glGetShaderSource(this.handle, bufsize, length, 0, source, 0);
        try {
            return new String(source, 0, length[0], "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
    
    /**
     * <p>For implementations that support a shader compiler, returns {@code true} if the last compile operation on
     * the shader was successful and {@code false} otherwise.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetShaderiv} with argument {@link OpenGLES20#GL_COMPILE_STATUS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>For implementations that support a shader compiler, returns {@code true} if the last compile operation on
     * the shader was successful and {@code false} otherwise.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return For implementations that support a shader compiler, {@code true} if the last compile operation on the
     * shader was successful and {@code false} otherwise.
     */
    public boolean getCompileStatus() {
        OOGLES20.backEnd.glGetShaderiv(this.handle, OpenGLES20.GL_COMPILE_STATUS, OOShader.intBuffer);
        return OOBoolean.getBool(OOShader.intBuffer.get(0));
    }
    
    /**
     * <p>For implementations that support a shader compiler, returns the number of characters in the information log
     * for the shader including the null termination character.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetShaderiv} with argument {@link OpenGLES20#GL_INFO_LOG_LENGTH}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>For implementations that support a shader compiler, returns the number of characters in the information log
     * for the shader including the null termination character (i.e., the size of the character buffer required to store
     * the information log). If the shader has no information log, a value of {@code 0} is returned.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return For implementations that support a shader compiler, the number of characters in the information log for
     * the shader including the null termination character.
     */
    public int getInfoLogLength() {
        OOGLES20.backEnd.glGetShaderiv(this.handle, OpenGLES20.GL_INFO_LOG_LENGTH, OOShader.intBuffer);
        return OOShader.intBuffer.get(0);
    }
    
    /**
     * <p>Return the information log for a shader object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetShaderInfoLog}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #getInfoLog} returns the information log for the specified shader object. The information log for a
     * shader object is modified when the shader is compiled.</p>
     * 
     * <p>The information log for a shader object is a string that may contain diagnostic messages, warning messages
     * and other information about the last compile operation. When a shader object is created, its information log will
     * be a string of length 0.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>The information log for a shader object is the OpenGL implementer's primary mechanism for conveying
     * information about the compilation process. Therefore, the information log can be helpful to application
     * developers during the development process, even when compilation is successful. Application developers should not
     * expect different OpenGL implementations to produce identical information logs.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The information log for a shader object.
     * 
     * @see #getInfoLogLength
     * @see #compile
     * @see OOProgram#getInfoLog
     * @see OOProgram#link
     * @see OOProgram#validate
     */
    public String getInfoLog() {
        return OOGLES20.backEnd.glGetShaderInfoLog(this.handle);
    }
}
