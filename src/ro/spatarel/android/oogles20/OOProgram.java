package ro.spatarel.android.oogles20;

import java.io.UnsupportedEncodingException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Class modeling the program objects.</p>
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
public class OOProgram {
    
    private static final Map<Integer, OOProgram> programs = new TreeMap<Integer, OOProgram>();
    
    static OOProgram getProgram(int handle) {
        return OOProgram.programs.get(handle);
    }
    
    private int handle;
    
    private final int finalHandle;
    
    private Map<String, OOUniform> uniforms = new TreeMap<String, OOUniform>();
    
    private Map<String, OOAttribute> attributes = new TreeMap<String, OOAttribute>();
    
    int getHandle() {
        return this.handle;
    }
    
    /**
     * <p>Create a program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glCreateProgram}</p>
     * 
     * <h5>Description</h5>
     * 
     * {@link #OOProgram} creates an empty program object and returns a non-zero value by which it can be referenced. A
     * program object is an object to which shader objects can be attached. This provides a mechanism to specify the
     * shader objects that will be linked to create a program. It also provides a means for checking the compatibility
     * of the shaders that will be used to create a program (for instance, checking the compatibility between a vertex
     * shader and a fragment shader). When no longer needed as part of a program object, shader objects can be detached.
     * </p>
     * 
     * <p>One or more executables are created in a program object by successfully attaching shader objects to it with
     * {@link #attachShader}, successfully compiling the shader objects with {@link OOShader#compile} and successfully
     * linking the program object with {@link #link}. These executables are made part of current state when {@link
     * OOGLES20#useProgram} is called. Program objects can be deleted by calling {@link #finalize}. The memory
     * associated with the program object will be deleted when it is no longer part of current rendering state for any
     * context.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Like texture objects, the name space for program objects may be shared across a set of contexts, as long as
     * the server sides of the contexts share the same address space. If the name space is shared across contexts, any
     * attached objects and the data associated with those attached objects are shared as well.</p>
     * 
     * <p>Applications are responsible for providing the synchronization across API calls when objects are accessed from
     * different execution threads.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>This function throws an {@link OOErrorOccuredCreatingObjectException} if an error occurs creating the
     *     program object.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see OOGLES20#getCurrentProgram
     * @see #getAttachedShaders
     * @see #getInfoLog
     * @see #getUniform
     * @see #attachShader
     * @see OOShader#OOShader
     * @see #finalize
     * @see #detachShader
     * @see #link
     * @see OOGLES20#useProgram
     * @see #validate
     */
    public OOProgram() {
        this.handle = OOGLES20.backEnd.glCreateProgram();
        this.finalHandle = this.handle;
        if (this.handle == 0) {
            throw new OOErrorOccuredCreatingObjectException();
        }
        OOProgram.programs.put(this.handle, this);
    }
    
    /**
     * <p>Delete a program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDeleteProgram}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #delete} frees the memory and invalidates the name associated with the program object. This command
     * effectively undoes the effects of a call to {@link #OOProgram}.</p>
     * 
     * <p>If a program object is in use as part of current rendering state, it will be flagged for deletion, but it will
     * not be deleted until it is no longer part of current state for any rendering context. If a program object to be
     * deleted has shader objects attached to it, those shader objects will be automatically detached but not deleted
     * unless they have already been flagged for deletion by a previous call to {@link OOShader#delete}.</p>
     * 
     * <p>To determine whether a program object has been flagged for deletion, call {@link #getDeleteStatus}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see OOGLES20#getCurrentProgram
     * @see #getDeleteStatus
     * @see OOShader#OOShader
     * @see #detachShader
     * @see OOGLES20#useProgram
     */
    public void delete() {
        if (this.handle != 0) {
            OOGLES20.backEnd.glDeleteProgram(this.handle);
            OOProgram.programs.remove(this.handle);
            this.handle = 0;
        }
    }
    
    @Override
    protected void finalize() throws Throwable {
        this.delete();
        super.finalize();
    }
    
    /**
     * <p>Attach a shader object to a program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glAttachShader}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>In order to create an executable, there must be a way to specify the list of things that will be linked
     * together. Program objects provide this mechanism. Shaders that are to be linked together in a program object must
     * first be attached to that program object. {@link #attachShader} attaches the shader object specified by
     * {@code shader} to the program object. This indicates that {@code shader} will be included in link operations that
     * will be performed on the program object.</p>
     * 
     * <p>All operations that can be performed on a shader object are valid whether or not the shader object is attached
     * to a program object. It is permissible to attach a shader object to a program object before source code has been
     * loaded into the shader object or before the shader object has been compiled. Multiple shader objects of the same
     * type may not be attached to a single program object. However, a single shader object may be attached to more than
     * one program object. If a shader object is deleted while it is attached to a program object, it will be flagged
     * for deletion and deletion will not occur until {@link #detachShader} is called to detach it from all program
     * objects to which it is attached.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_VALUE is generated if either program or shader is not a value generated by OpenGL. -->
     *     <!-- GL_INVALID_OPERATION is generated if program is not a program object. -->
     *     <!-- GL_INVALID_OPERATION is generated if shader is not a shader object. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code shader} is already attached to the program
     *     object or if another shader object of the same type as {@code shader} is already attached to the program
     *     object.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param shader Specifies the shader object that is to be attached.
     * 
     * @see #getAttachedShaders
     * @see OOShader#compile
     * @see #detachShader
     * @see #link
     * @see OOShader#setSource
     * @see OOShader#setBinary
     */
    public void attachShader(OOShader shader) {
        OOGLES20.backEnd.glAttachShader(this.handle, shader.getHandle());
    }
    
    /**
     * <p>Detach a shader object from a program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDetachShader}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #detachShader} detaches the shader object specified by {@code shader} from the program object. This
     * command can be used to undo the effect of the command {@link #attachShader}.</p>
     * 
     * <p>If {@code shader} has already been flagged for deletion by a call to {@link OOShader#finalize} and it is not
     * attached to any other program object, it will be deleted after it has been detached.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_VALUE is generated if either program or shader is not a value generated by OpenGL. -->
     *     <!-- GL_INVALID_OPERATION is generated if program is not a program object. -->
     *     <!-- GL_INVALID_OPERATION is generated if shader is not a shader object. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code shader} is not attached to the program object.
     *     </li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param shader Specifies the shader object to be detached.
     * 
     * @see #getAttachedShaders
     * @see OOShader#getDeleteStatus
     * @see #attachShader
     */
    public void detachShader(OOShader shader) {
        OOGLES20.backEnd.glDetachShader(this.handle, shader.getHandle());
    }
    
    /**
     * <p>Link a program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glLinkProgram}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #link} links the program object specified by the program object. Shader objects of type {@link
     * OOShaderType#VERTEX} attached to {@code program} are used to create an executable that will run on the
     * programmable vertex processor. Shader objects of type {@link OOShaderType#FRAGMENT} attached to program are used
     * to create an executable that will run on the programmable fragment processor.</p>
     * 
     * <p>The status of the link operation will be stored as part of the program object's state. This value will be set
     * to {@code true} if the program object was linked without errors and is ready for use and {@code false}
     * otherwise. It can be queried by calling {@link #getLinkStatus}.</p>
     * 
     * <p>As a result of a successful link operation, all active user-defined uniform variables belonging to
     * the program object will be initialized to {@code 0} and each of the program object's active uniform variables
     * will be assigned a location that can be queried by calling {@link #getUniform}. Also, any active user-defined
     * attribute variables that have not been bound to a generic vertex attribute index will be bound to one at this
     * time.</p>
     * 
     * <p>Linking of a program object can fail for a number of reasons as specified in the <i>OpenGL ES Shading Language
     * Specification</i>. The following lists some of the conditions that will cause a link error.</p>
     * 
     * <ul>
     *     <li>A vertex shader and a fragment shader are not both present in the program object.</li>
     *     <li>The number of active attribute variables supported by the implementation has been exceeded.</li>
     *     <li>The storage limit for uniform variables has been exceeded.</li>
     *     <li>The number of active uniform variables supported by the implementation has been exceeded.</li>
     *     <li>The {@code main} function is missing for the vertex shader or the fragment shader.</li>
     *     <li>A varying variable actually used in the fragment shader is not declared in the same way (or is not
     *     declared at all) in the vertex shader.</li>
     *     <li>A reference to a function or variable name is unresolved.</li>
     *     <li>A shared global is declared with two different types or two different initial values.</li>
     *     <li>One or more of the attached shader objects has not been successfully compiled (via {@link
     *     OOShader#compile}) or loaded with a pre-compiled shader binary (via {@link OOShader#setBinary}).</li>
     *     <li>Binding a generic attribute matrix caused some rows of the matrix to fall outside the allowed maximum of
     *     {@link OOGLES20Implementation#getMaximumAttributeVectors}.</li>
     *     <li>Not enough contiguous vertex attribute slots could be found to bind attribute matrices.</li>
     * </ul>
     * 
     * <p>When a program object has been successfully linked, the program object can be made part of current state by
     * calling {@link OOGLES20#useProgram}. Whether or not the link operation was successful, the program object's
     * information log will be overwritten. The information log can be retrieved by calling {@link #getInfoLog}.</p>
     * 
     * <p>{@link #link} will also install the generated executables as part of the current rendering state if the link
     * operation was successful and the specified program object is already currently in use as a result of a previous
     * call to {@link OOGLES20#useProgram}. If the program object currently in use is relinked unsuccessfully, its link
     * status will be set to {@code false}, but the executables and associated state will remain part of the current
     * state until a subsequent call to {@link OOGLES20#useProgram} removes it from use. After it is removed from use,
     * it cannot be made part of current state until it has been successfully relinked.</p>
     * 
     * <p>The program object's information log is updated and the program is generated at the time of the link
     * operation. After the link operation, applications are free to modify attached shader objects, compile attached
     * shader objects, detach shader objects, delete shader objects and attach additional shader objects. None of these
     * operations affects the information log or the program that is part of the program object.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the link operation is unsuccessful, any information about a previous link operation on the program object
     * is lost (i.e., a failed link does not restore the old state of the program object). Certain information can still
     * be retrieved from the program object even after an unsuccessful link operation.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see OOGLES20#getCurrentProgram
     * @see #getAttachedShaders
     * @see #getVectorAttribute
     * @see #getMatrixColumnAttribute
     * @see #getLinkStatus
     * @see #getInfoLog
     * @see #getUniformValueiv
     * @see #getUniformValuefv
     * @see #getUniform
     * @see #attachShader
     * @see OOShader#compile
     * @see OOShader#setBinary
     * @see #OOProgram
     * @see #finalize
     * @see #detachShader
     * @see OOGLES20#useProgram
     * @see #validate
     */
    public void link() {
        this.uniforms.clear();
        this.attributes.clear();
        OOGLES20.backEnd.glLinkProgram(this.handle);
    }
    
    /**
     * <p>Validate a program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glValidateProgram}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #validate} checks to see whether the executables contained in the program object can execute given the
     * current OpenGL state. The information generated by the validation process will be stored in the program object's
     * information log. The validation information may consist of an empty string or it may be a string containing
     * information about how the current program object interacts with the rest of current OpenGL state. This provides a
     * way for OpenGL implementers to convey more information about why the current program is inefficient, suboptimal,
     * failing to execute and so on.</p>
     * 
     * <p>The status of the validation operation will be stored as part of the program object's state. This value will
     * be set to {@code true} if the validation succeeded and {@code false} otherwise. It can be queried by calling
     * {@code #getValidateStatus}. If validation is successful, the program object is guaranteed to execute given the
     * current state. Otherwise, the program object is guaranteed to not execute.</p>
     * 
     * <p>This function is typically useful only during application development. The informational string stored in the
     * information log is completely implementation dependent; therefore, an application should not expect different
     * OpenGL implementations to produce identical information strings.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>This function mimics the validation operation that OpenGL implementations must perform when rendering commands
     * are issued while programmable shaders are part of current state. The error {@link OOError#INVALID_OPERATION} will
     * be generated by {@link OOGLES20Framebuffer#drawArrays} or {@link OOGLES20Framebuffer#drawElements} if any two
     * active samplers in the current program object are of different types, but refer to the same texture image unit.
     * </p>
     * 
     * <p>It may be difficult or cause a performance degradation for applications to catch these errors when rendering
     * commands are issued. Therefore, applications are advised to make calls to {@link #validate} to detect these
     * issues during application development.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see #getValidateStatus
     * @see #getInfoLog
     * @see #link
     * @see OOGLES20#useProgram
     */
    public void validate() {
        OOGLES20.backEnd.glValidateProgram(this.handle);
    }
    
    /**
     * <p>Return the location of a uniform variable.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetUniformLocation}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #getUniform} returns the location of a specific uniform variable within a program object. {@code name}
     * must be a {@link String} that contains no white space. {@code name} must be an active uniform variable name in
     * the program object that is not a structure, an array of structures or a subcomponent of a vector or a matrix.
     * This function returns {@code -1} if {@code name} does not correspond to an active uniform variable in the program
     * object or if {@code name} starts with the reserved prefix "gl_".</p>
     * 
     * <p>Uniform variables that are structures or arrays of structures may be queried by calling {@link #getUniform}
     * for each field within the structure. The array element operator "[]" and the structure field operator "." may be
     * used in {@code name} in order to select elements within an array or fields within a structure. The result of
     * using these operators is not allowed to be another structure, an array of structures or a subcomponent of a
     * vector or a matrix. Except if the last part of {@code name} indicates a uniform variable array, the location of
     * the first element of an array can be retrieved by using the name of the array or by using the name appended by
     * "[0]".</p>
     * 
     * <p>The actual locations assigned to uniform variables are not known until the program object is linked
     * successfully. After linking has occurred, the command {@link #getUniform} can be used to obtain the location of a
     * uniform variable. After a program object has been linked successfully, the values for uniform variables remain
     * fixed until the next link command occurs. Uniform variable locations and values can only be queried after a link
     * if the link was successful.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_VALUE is generated if program is not a value generated by OpenGL. -->
     *     <!-- GL_INVALID_OPERATION is generated if program is not a program object. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the program object has not been successfully linked.
     *     </li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param name The name of the uniform variable whose location is to be queried.
     * @return The location of a uniform variable.
     * 
     * @see #getUniformsCount
     * @see #getUniformMaximumLength
     * @see #getUniformValueiv
     * @see #getUniformValuefv
     * @see #link
     */
    public OOUniform getUniform(String name) {
        if (!this.uniforms.containsKey(name)) {
            int uniformHandle = OOGLES20.backEnd.glGetUniformLocation(this.handle, name);
            if (uniformHandle == -1) {
                return null;
            }
            this.uniforms.put(name, new OOUniform(uniformHandle));
        }
        return this.uniforms.get(name);
    }
    
    /**
     * <p>Return the location of an attribute variable.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetAttribLocation}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #getVectorAttribute} queries the previously linked program object specified by the program object for
     * the attribute variable specified by {@code name} and returns the index of the generic vertex attribute that is
     * bound to that attribute variable. If {@code name} starts with the reserved prefix "gl_", a value of {@code -1} is
     * returned.</p>
     * 
     * <p>Attribute bindings do not go into effect until {@link #link} is called. After a program object has been linked
     * successfully, the index values for attribute variables remain fixed until the next link command occurs. The
     * attribute values can only be queried after a link if the link was successful. {@link #getVectorAttribute} returns
     * the binding that actually went into effect the last time {@link #link} was called for the specified program
     * object. Attribute bindings that have been specified since the last link operation are not returned by {@link
     * #getVectorAttribute}.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_OPERATION is generated if program is not a value generated by OpenGL. -->
     *     <!-- GL_INVALID_OPERATION is generated if program is not a program object. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the program object has not been successfully linked.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param name The name of the attribute variable whose location is to be queried.
     * @return The location of an attribute variable.
     * 
     * @see #link
     * @see OOAttribute#setBuffer
     */
    public OOAttribute getVectorAttribute(String name) {
        if (!this.attributes.containsKey(name)) {
            int attributeHandle = OOGLES20.backEnd.glGetAttribLocation(this.handle, name);
            this.attributes.put(name, new OOAttribute(attributeHandle));
        }
        return this.attributes.get(name);
    }
    
    /**
     * <p>Return the location of an attribute variable.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetAttribLocation}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #getVectorAttribute} queries the previously linked program object specified by the program object for
     * the matrix attribute variable specified by {@code name} and returns the index of the generic vertex attribute
     * that is bound to that attribute variable. If {@code name} starts with the reserved prefix "gl_", a value of
     * {@code -1} is returned.</p>
     * 
     * <p>Attribute bindings do not go into effect until {@link #link} is called. After a program object has been linked
     * successfully, the index values for attribute variables remain fixed until the next link command occurs. The
     * attribute values can only be queried after a link if the link was successful. {@link #getVectorAttribute} returns
     * the binding that actually went into effect the last time {@link #link} was called for the specified program
     * object. Attribute bindings that have been specified since the last link operation are not returned by {@link
     * #getVectorAttribute}.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_OPERATION is generated if program is not a value generated by OpenGL. -->
     *     <!-- GL_INVALID_OPERATION is generated if program is not a program object. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the program object has not been successfully linked.
     *     </li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param name The name of the matrix attribute variable whose location is to be queried.
     * @param column The index of the column matrix.
     * @return The location of a column matrix attribute variable.
     * 
     * @see #link
     * @see OOAttribute#setBuffer
     */
    public OOAttribute getMatrixColumnAttribute(String name, int column) {
        String fullName = name + "." + column;
        if (!this.attributes.containsKey(fullName)) {
            int attributeHandle = OOGLES20.backEnd.glGetAttribLocation(this.handle, name) + column;
            this.attributes.put(fullName, new OOAttribute(attributeHandle));
        }
        return this.attributes.get(fullName);
    }
    
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(1);
    
    /**
     * <p>Returns {@code true} if the program object is currently flagged for deletion and {@code false} otherwise.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetProgramiv} with argument {@link OpenGLES20#GL_DELETE_STATUS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns {@code true} if the program object is currently flagged for deletion and {@code false} otherwise.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return {@code true} if the program object is currently flagged for deletion and {@code false} otherwise.
     */
    public boolean getDeleteStatus() {
        OOGLES20.backEnd.glGetProgramiv(this.finalHandle, OpenGLES20.GL_DELETE_STATUS, OOProgram.intBuffer);
        return OOBoolean.getBool(OOProgram.intBuffer.get(0));
    }
    
    /**
     * <p>Returns {@code true} if the last link operation on the program object was successful and {@code false}
     * otherwise.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetProgramiv} with argument {@link OpenGLES20#GL_LINK_STATUS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns {@code true} if the last link operation on the program object was successful and {@code false}
     * otherwise.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return {@code true} if the last link operation on the program object was successful and {@code false} otherwise.
     */
    public boolean getLinkStatus() {
        OOGLES20.backEnd.glGetProgramiv(this.handle, OpenGLES20.GL_LINK_STATUS, OOProgram.intBuffer);
        return OOBoolean.getBool(OOProgram.intBuffer.get(0));
    }
    
    /**
     * <p>Returns {@code true} if the last validation operation on the program object was successful and {@code false}
     * otherwise.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetProgramiv} with argument {@link OpenGLES20#GL_VALIDATE_STATUS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns {@code true} if the last validation operation on the program object was successful and {@code false}
     * otherwise.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return {@code true} if the last validation operation on the program object was successful and {@code false}
     * otherwise.
     */
    public boolean getValidateStatus() {
        OOGLES20.backEnd.glGetProgramiv(this.handle, OpenGLES20.GL_VALIDATE_STATUS, OOProgram.intBuffer);
        return OOBoolean.getBool(OOProgram.intBuffer.get(0));
    }
    
    /**
     * <p>Returns the number of characters in the information log for the program object including the null termination
     * character.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetProgramiv} with argument {@link OpenGLES20#GL_INFO_LOG_LENGTH}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the number of characters in the information log for the program object including the null termination
     * character (i.e., the size of the character buffer required to store the information log). If the program object
     * has no information log, a value of {@code 0} is returned.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The number of characters in the information log for the program object including the null termination
     * character.
     */
    public int getInfoLogLength() {
        OOGLES20.backEnd.glGetProgramiv(this.handle, OpenGLES20.GL_INFO_LOG_LENGTH, OOProgram.intBuffer);
        return OOProgram.intBuffer.get(0);
    }
    
    /**
     * <p>Return the information log for the program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetProgramInfoLog}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #getInfoLog} returns the information log for the specified program object. The information log for a
     * program object is modified when the program object is linked or validated. The string that is returned will be
     * null terminated.</p>
     * 
     * <p>The information log for a program object is either an empty string or a string containing information about
     * the last link operation or a string containing information about the last validation operation. It may contain
     * diagnostic messages, warning messages and other information. When a program object is created, its information
     * log will be a string of length {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>The information log for a program object is the OpenGL implementer's primary mechanism for conveying
     * information about linking and validating. Therefore, the information log can be helpful to application developers
     * during the development process, even when these operations are successful. Application developers should not
     * expect different OpenGL implementations to produce identical information logs.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The information log for the program object.
     * 
     * @see #getInfoLogLength
     * @see OOShader#compile
     * @see OOShader#getInfoLog
     * @see #link
     * @see #validate
     */
    public String getInfoLog() {
        return OOGLES20.backEnd.glGetProgramInfoLog(this.handle);
    }
    
    /**
     * <p>Returns the number of shader objects attached to the program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetProgramiv} with argument {@link OpenGLES20#GL_ATTACHED_SHADERS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the number of shader objects attached to the program object.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The number of shader objects attached to the program object.
     */
    public int getAttachedShadersCount() {
        OOGLES20.backEnd.glGetProgramiv(this.handle, OpenGLES20.GL_ATTACHED_SHADERS, OOProgram.intBuffer);
        return OOProgram.intBuffer.get(0);
    }
    
    /**
     * <p>Return the handles of the shader objects attached to a program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetAttachedShaders}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #getAttachedShaders} returns the names of the shader objects attached to the program object.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The handles of the shader objects attached to a program object.
     * 
     * @see #getAttachedShadersCount
     * @see #attachShader
     * @see #detachShader
     */
    public List<OOShader> getAttachedShaders() {
        IntBuffer count = OOGLES20.createIntBuffer(1);
        int shadersCount = this.getAttachedShadersCount();
        IntBuffer shaderHandles = OOGLES20.createIntBuffer(shadersCount);
        OOGLES20.backEnd.glGetAttachedShaders(this.handle, shadersCount, count, shaderHandles);
        List<OOShader> answer = new ArrayList<OOShader>();
        int i;
        for (i = 0; i < count.get(0); ++i) {
            answer.add(OOShader.getShader(shaderHandles.get(i)));
        }
        return answer;
    }
    
    /**
     * <p>Returns the number of active uniform variables for the program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetProgramiv} with argument {@link OpenGLES20#GL_ACTIVE_UNIFORMS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the number of active uniform variables for the program object.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The number of active uniform variables for the program object.
     */
    public int getUniformsCount() {
        OOGLES20.backEnd.glGetProgramiv(this.handle, OpenGLES20.GL_ACTIVE_UNIFORMS, OOProgram.intBuffer);
        return OOProgram.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the length of the longest active uniform variable name for the program object, including the null
     * termination character.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetProgramiv} with argument {@link OpenGLES20#GL_ACTIVE_UNIFORM_MAX_LENGTH}.
     * </p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the length of the longest active uniform variable name for the program object, including the null
     * termination character (i.e., the size of the character buffer required to store the longest uniform variable
     * name). If no active uniform variables exist, {@code 0} is returned.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The length of the longest active uniform variable name for the program object, including the null
     * termination character.
     */
    public int getUniformMaximumLength() {
        OOGLES20.backEnd.glGetProgramiv(this.handle, OpenGLES20.GL_ACTIVE_UNIFORM_MAX_LENGTH, OOProgram.intBuffer);
        return OOProgram.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the number of active attribute variables for the program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetProgramiv} with argument {@link OpenGLES20#GL_ACTIVE_ATTRIBUTES}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the number of active attribute variables for the program object.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The number of active attribute variables for the program object.
     */
    public int getAttributesCount() {
        OOGLES20.backEnd.glGetProgramiv(this.handle, OpenGLES20.GL_ACTIVE_ATTRIBUTES, OOProgram.intBuffer);
        return OOProgram.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the length of the longest active attribute name for the program object, including the null termination
     * character.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetProgramiv} with argument {@link OpenGLES20#GL_ACTIVE_ATTRIBUTE_MAX_LENGTH}.
     * </p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the length of the longest active attribute name for the program object, including the null termination
     * character (i.e., the size of the character buffer required to store the longest attribute name). If no active
     * attributes exist, {@code 0} is returned.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The length of the longest active attribute name for the program object, including the null termination
     * character.
     */
    public int getAttributeMaximumLength() {
        OOGLES20.backEnd.glGetProgramiv(this.handle, OpenGLES20.GL_ACTIVE_ATTRIBUTE_MAX_LENGTH, OOProgram.intBuffer);
        return OOProgram.intBuffer.get(0);
    }
    
    /**
     * <p>Return the value of a uniform variable.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetUniformfv}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #getUniformValueiv} returns the value(s) of the specified uniform variable. The type of the uniform
     * variable specified by {@code name} determines the number of values returned. If the uniform variable is defined
     * in the shader as a {@code boolean}, {@code int} or {@code float}, a single value will be returned. If it is
     * defined as a {@code vec2}, {@code ivec2} or {@code bvec2}, two values will be returned. If it is defined as a
     * {@code vec3}, {@code ivec3} or {@code bvec3}, three values will be returned and so on. To query values stored in
     * uniform variables declared as arrays, call {@link #getUniformValuefv} for each element of the array. To query
     * values stored in uniform variables declared as structures, call {@link #getUniformValueiv} for each field in the
     * structure. The values for uniform variables declared as a matrix will be returned in column major order.</p>
     * 
     * <p>The locations assigned to uniform variables are not known until the program object is linked. After linking
     * has occurred, the command {@link #getUniform} can be used to obtain the location of a uniform variable. This
     * location value can then be passed to {@link #getUniformValuefv} in order to query the current value of the
     * uniform variable. After a program object has been linked successfully, the index values for uniform variables
     * remain fixed until the next link command occurs. The uniform variable values can only be queried after a link if
     * the link was successful.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_VALUE is generated if program is not a value generated by OpenGL. -->
     *     <!-- GL_INVALID_OPERATION is generated if program is not a program object. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the program object has not been successfully linked.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code name} does not correspond to a valid uniform
     *     variable name for the program object.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param name The name of the attribute variable whose location is to be queried.
     * @return The value of a uniform variable.
     * 
     * @see #getUniformsCount
     * @see #getUniformMaximumLength
     * @see #getUniform
     * @see #OOProgram
     * @see #link
     */
    public float[] getUniformValuefv(String name) {
        int location = this.getUniform(name).getHandle();
        FloatBuffer answer = OOGLES20.createFloatBuffer(this.getUniformSize(name));
        OOGLES20.backEnd.glGetUniformfv(this.handle, location, answer);
        return OOGLES20.extract(answer);
    }
    
    /**
     * <p>Return the value of a uniform variable.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetUniformiv}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #getUniformValueiv} returns the value(s) of the specified uniform variable. The type of the uniform
     * variable specified by {@code name} determines the number of values returned. If the uniform variable is defined
     * in the shader as a {@code boolean}, {@code int} or {@code float}, a single value will be returned. If it is
     * defined as a {@code vec2}, {@code ivec2} or {@code bvec2}, two values will be returned. If it is defined as a
     * {@code vec3}, {@code ivec3} or {@code bvec3}, three values will be returned and so on. To query values stored in
     * uniform variables declared as arrays, call {@link #getUniformValueiv} for each element of the array. To query
     * values stored in uniform variables declared as structures, call {@link #getUniformValueiv} for each field in the
     * structure. The values for uniform variables declared as a matrix will be returned in column major order.</p>
     * 
     * <p>The locations assigned to uniform variables are not known until the program object is linked. After linking
     * has occurred, the command {@link #getUniform} can be used to obtain the location of a uniform variable. This
     * location value can then be passed to {@link #getUniformValueiv} in order to query the current value of the
     * uniform variable. After a program object has been linked successfully, the index values for uniform variables
     * remain fixed until the next link command occurs. The uniform variable values can only be queried after a link if
     * the link was successful.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_VALUE is generated if program is not a value generated by OpenGL. -->
     *     <!-- GL_INVALID_OPERATION is generated if program is not a program object. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the program object has not been successfully linked.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code name} does not correspond to a valid uniform
     *     variable name for the program object.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param name The name of the attribute variable whose location is to be queried.
     * @return The value of a uniform variable.
     * 
     * @see #getUniformsCount
     * @see #getUniformMaximumLength
     * @see #getUniform
     * @see #OOProgram
     * @see #link
     */
    public int[] getUniformValueiv(String name) {
        int location = this.getUniform(name).getHandle();
        IntBuffer answer = OOGLES20.createIntBuffer(this.getUniformSize(name));
        OOGLES20.backEnd.glGetUniformiv(this.handle, location, answer);
        return OOGLES20.extract(answer);
    }
    
    private static int[] length = new int[1];
    private static int[] size = new int[1];
    private static int[] type = new int[1];
    private static byte[] name;
    
    private void getUniformProperties(String name) {
        int bufsize = this.getUniformMaximumLength();
        OOProgram.name = new byte[bufsize];
        OOGLES20.backEnd.glGetActiveUniform(this.handle, this.getUniform(name).getHandle(), bufsize,
                OOProgram.length, 0, OOProgram.size, 0, OOProgram.type, 0, OOProgram.name, 0);
    }
    
    /**
     * <p>Returns the size of the uniform variable.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetActiveUniform}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the size of the uniform variable. Uniform variables other than arrays will have a size of {@code 1}.
     * Structures and arrays of structures will be reduced as described earlier, such that each of the names returned
     * will be a data type in the earlier list. If this reduction results in an array, the size returned will be as
     * described for uniform arrays; otherwise, the size returned will be {@code 1}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param name The name of the uniform variable whose size is to be queried.
     * 
     * @return The size of the uniform variable.
     */
    public int getUniformSize(String name) {
        this.getUniformProperties(name);
        return OOProgram.size[0];
    }
    
    /**
     * <p>Returns the uniform variable's data type.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetActiveUniform}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the uniform variable's data type.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param name The name of the uniform variable whose type is to be queried.
     * 
     * @return The uniform variable's data type.
     */
    public OOUniformDataType getUniformType(String name) {
        this.getUniformProperties(name);
        return OOUniformDataType.valueOf(OOProgram.type[0]);
    }
    
    /**
     * <p>Returns the name of the uniform variable.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetActiveUniform}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the name of the uniform variable.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param name The name of the uniform variable whose name is to be queried.
     * 
     * @return The name of the uniform variable.
     */
    public String getUniformName(String name) {
        this.getUniformProperties(name);
        try {
            return new String(OOProgram.name, 0, OOProgram.name.length - 1, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
    
    private void getAttributeProperties(String name) {
        int bufsize = this.getAttributeMaximumLength();
        OOProgram.name = new byte[bufsize];
        OOGLES20.backEnd.glGetActiveAttrib(this.handle, this.getVectorAttribute(name).getHandle(), bufsize,
                OOProgram.length, 0, OOProgram.size, 0, OOProgram.type, 0, OOProgram.name, 0);
    }
    
    /**
     * <p>Returns the size of the attribute, in units of the type returned by {@link #getAttributeType}.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetActiveUniform}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the size of the attribute, in units of the type returned by {@link #getAttributeType}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param name The name of the attribute variable whose size is to be queried.
     * 
     * @return The size of the attribute, in units of the type returned by {@link #getAttributeType}.
     */
    public int getAttributeSize(String name) {
        this.getAttributeProperties(name);
        return OOProgram.size[0];
    }
    
    /**
     * <p>Returns the attribute variable's data type.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetActiveUniform}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the attribute variable's data type.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param name The name of the attribute variable whose data type is to be queried.
     * 
     * @return The attribute variable's data type.
     */
    public OOAttributeDataType getAttributeType(String name) {
        this.getAttributeProperties(name);
        return OOAttributeDataType.valueOf(OOProgram.type[0]);
    }
    
    /**
     * <p>Returns the name of the attribute variable.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetActiveUniform}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the name of the attribute variable.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param name The name of the attribute variable whose name is to be queried.
     * 
     * @return The name of the attribute variable.
     */
    public String getAttributeName(String name) {
        this.getAttributeProperties(name);
        try {
            return new String(OOProgram.name, 0, OOProgram.name.length - 1, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
