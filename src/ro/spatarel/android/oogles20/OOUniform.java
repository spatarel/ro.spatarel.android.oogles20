package ro.spatarel.android.oogles20;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * <p>Class modeling the uniforms.</p>
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
public class OOUniform {
    
    private int handle;
    
    OOUniform(int handle) {
        this.handle = handle;
    }
    
    int getHandle() {
        return this.handle;
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform1f}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set1f} modifies the value of a uniform variable or a uniform variable array. {@link #set1f} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code float} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set1f} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code float}, a {@link OOError#INVALID_OPERATION}
     * error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <!-- !!!!!!!!!! <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li> -->
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param x Specifies the first component of the new value to be used for the uniform variable.
     */
    public void set1f(float x) {
        OOGLES20.backEnd.glUniform1f(this.handle, x);
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform1fv}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set1fv} modifies the value of a uniform variable or a uniform variable array. {@link #set1fv} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code float[]} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set1fv} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code float[]}, a {@link OOError#INVALID_OPERATION}
     * error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li>
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies a pointer to an array of {@code count} values that will be used to update the specified
     * uniform variable.
     */
    public void set1fv(int count, FloatBuffer values) {
        OOGLES20.backEnd.glUniform1fv(this.handle, count, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code set1fv(count, OOGLES20.createFloatBuffer(values, offset));}.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies an array that will be used to update the specified uniform variable.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #set1fv
     */
    public void set1fv(int count, float[] values, int offset) {
        this.set1fv(count, OOGLES20.createFloatBuffer(values, offset));
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform1i}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set1i} modifies the value of a uniform variable or a uniform variable array. {@link #set1i} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code int}, {@code bool} or {@code sampler} uniform variable.
     * </p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set1i} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code int}, {@code bool} or {@code sampler}, a
     * {@link OOError#INVALID_OPERATION} error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <!-- !!!!!!!!!! <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li> -->
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param x Specifies the first component of the new value to be used for the uniform variable.
     */
    public void set1i(int x) {
        OOGLES20.backEnd.glUniform1i(this.handle, x);
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform1iv}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set1iv} modifies the value of a uniform variable or a uniform variable array. {@link #set1iv} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code int[]}, {@code bool[]} or {@code sampler[]} uniform
     * variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set1iv} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code int[]}, {@code bool[]} or {@code sampler[]},
     * a {@link OOError#INVALID_OPERATION} error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li>
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies a pointer to an array of {@code count} values that will be used to update the specified
     * uniform variable.
     */
    public void set1iv(int count, IntBuffer values) {
        OOGLES20.backEnd.glUniform1iv(this.handle, count, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code set1iv(count, OOGLES20.createIntBuffer(values, offset));}.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies an array that will be used to update the specified uniform variable.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #set1iv
     */
    public void set1iv(int count, int[] values, int offset) {
        this.set1iv(count, OOGLES20.createIntBuffer(values, offset));
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform2f}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set2f} modifies the value of a uniform variable or a uniform variable array. {@link #set2f} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code vec2} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set2f} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code vec2}, a {@link OOError#INVALID_OPERATION}
     * error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <!-- !!!!!!!!!! <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li> -->
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param x Specifies the first component of the new value to be used for the uniform variable.
     * @param y Specifies the second component of the new value to be used for the uniform variable.
     */
    public void set2f(float x, float y) {
        OOGLES20.backEnd.glUniform2f(this.handle, x, y);
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform2fv}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set2fv} modifies the value of a uniform variable or a uniform variable array. {@link #set2fv} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code vec2[]} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set2fv} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code vec2[]}, a {@link OOError#INVALID_OPERATION}
     * error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li>
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies a pointer to an array of {@code count} values that will be used to update the specified
     * uniform variable.
     */
    public void set2fv(int count, FloatBuffer values) {
        OOGLES20.backEnd.glUniform2fv(this.handle, count, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code set2fv(count, OOGLES20.createFloatBuffer(values, offset));}.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies an array that will be used to update the specified uniform variable.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #set2fv
     */
    public void set2fv(int count, float[] values, int offset) {
        this.set2fv(count, OOGLES20.createFloatBuffer(values, offset));
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform2i}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set2i} modifies the value of a uniform variable or a uniform variable array. {@link #set2i} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code ivec2} or {@code bvec2} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set2i} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code ivec2} or {@code bvec2}, a {@link
     * OOError#INVALID_OPERATION} error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <!-- !!!!!!!!!! <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li> -->
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param x Specifies the first component of the new value to be used for the uniform variable.
     * @param y Specifies the second component of the new value to be used for the uniform variable.
     */
    public void set2i(int x, int y) {
        OOGLES20.backEnd.glUniform2i(this.handle, x, y);
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform2iv}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set2iv} modifies the value of a uniform variable or a uniform variable array. {@link #set2iv} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code ivec2[]} or {@code bvec2[]} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set2iv} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code ivec2[]} or {@code bvec2[]}, a {@link
     * OOError#INVALID_OPERATION} error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li>
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies a pointer to an array of {@code count} values that will be used to update the specified
     * uniform variable.
     */
    public void set2iv(int count, IntBuffer values) {
        OOGLES20.backEnd.glUniform2iv(this.handle, count, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code set2iv(count, OOGLES20.createIntBuffer(values, offset));}.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies an array that will be used to update the specified uniform variable.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #set2iv
     */
    public void set2iv(int count, int[] values, int offset) {
        this.set2iv(count, OOGLES20.createIntBuffer(values, offset));
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform3f}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set3f} modifies the value of a uniform variable or a uniform variable array. {@link #set3f} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code vec3} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set3f} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code vec3}, a {@link OOError#INVALID_OPERATION}
     * error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <!-- !!!!!!!!!! <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li> -->
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param x Specifies the first component of the new value to be used for the uniform variable.
     * @param y Specifies the second component of the new value to be used for the uniform variable.
     * @param z Specifies the third component of the new value to be used for the uniform variable.
     */
   public void set3f(float x, float y, float z) {
        OOGLES20.backEnd.glUniform3f(this.handle, x, y, z);
    }
    
   /**
    * <p>Specify the value of the uniform variable for the current program object.</p>
    * 
    * <p>Wrapper for {@link OpenGLES20#glUniform3fv}.</p>
    * 
    * <h5>Description</h5>
    * 
    * <p>{@link #set3fv} modifies the value of a uniform variable or a uniform variable array. {@link #set3fv} operates
    * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
    * 
    * <p>This command is used to change the value of a {@code vec3[]} uniform variable.</p>
    * 
    * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
    * is linked successfully. They retain the values assigned to them by a call to {@link #set3fv} until the next
    * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
    * 
    * <h5>Notes</h5>
    * 
    * <p>If the uniform variable as defined in the shader is not a {@code vec3[]}, a {@link OOError#INVALID_OPERATION}
    * error will be generated and the uniform variable will remain unchanged.</p>
    * 
    * <h5>Errors</h5>
    * 
    * <ul>
    *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
    *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
    *     match the size indicated by the glUniform command. -->
    *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
    *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
    *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
    *     of these. -->
    *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
    *     object and location is not equal to -1. -->
    *     <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li>
    *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
    *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
    *     an array variable. -->
    *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
    *     glUniform1i and glUniform1iv. -->
    * </ul>
    * 
    * <h5>Copyright</h5>
    * 
    * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
    * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
    * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
    * 
    * @param count Specifies the number of elements that are to be modified.
    * @param values Specifies a pointer to an array of {@code count} values that will be used to update the specified
    * uniform variable.
    */
    public void set3fv(int count, FloatBuffer values) {
        OOGLES20.backEnd.glUniform3fv(this.handle, count, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code set3fv(count, OOGLES20.createFloatBuffer(values, offset));}.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies an array that will be used to update the specified uniform variable.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #set3fv
     */
    public void set3fv(int count, float[] values, int offset) {
        this.set3fv(count, OOGLES20.createFloatBuffer(values, offset));
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform3i}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set3i} modifies the value of a uniform variable or a uniform variable array. {@link #set3i} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code ivec3} or {@code bvec3} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set3i} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code ivec3} or {@code bvec3}, a {@link
     * OOError#INVALID_OPERATION} error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <!-- !!!!!!!!!! <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li> -->
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param x Specifies the first component of the new value to be used for the uniform variable.
     * @param y Specifies the second component of the new value to be used for the uniform variable.
     * @param z Specifies the third component of the new value to be used for the uniform variable.
     */
    public void set3i(int x, int y, int z) {
        OOGLES20.backEnd.glUniform3i(this.handle, x, y, z);
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform3iv}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set3iv} modifies the value of a uniform variable or a uniform variable array. {@link #set3iv} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code ivec3[]} or {@code bvec3[]} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set3iv} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code ivec3[]} or {@code bvec3[]}, a {@link
     * OOError#INVALID_OPERATION} error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li>
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies a pointer to an array of {@code count} values that will be used to update the specified
     * uniform variable.
     */
    public void set3iv(int count, IntBuffer values) {
        OOGLES20.backEnd.glUniform3iv(this.handle, count, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code set3iv(count, OOGLES20.createIntBuffer(values, offset));}.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies an array that will be used to update the specified uniform variable.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #set3iv
     */
    public void set3iv(int count, int[] values, int offset) {
        this.set3iv(count, OOGLES20.createIntBuffer(values, offset));
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform4f}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set4f} modifies the value of a uniform variable or a uniform variable array. {@link #set4f} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code vec4} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set4f} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code vec4}, a {@link OOError#INVALID_OPERATION}
     * error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <!-- !!!!!!!!!! <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li> -->
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param x Specifies the first component of the new value to be used for the uniform variable.
     * @param y Specifies the second component of the new value to be used for the uniform variable.
     * @param z Specifies the third component of the new value to be used for the uniform variable.
     * @param w Specifies the fourth component of the new value to be used for the uniform variable.
     */
    public void set4f(float x, float y, float z, float w) {
        OOGLES20.backEnd.glUniform4f(this.handle, x, y, z, w);
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform4fv}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set4fv} modifies the value of a uniform variable or a uniform variable array. {@link #set4fv} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code vec4[]} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set4fv} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code vec4[]}, a {@link OOError#INVALID_OPERATION}
     * error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li>
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies a pointer to an array of {@code count} values that will be used to update the specified
     * uniform variable.
     */
    public void set4fv(int count, FloatBuffer values) {
        OOGLES20.backEnd.glUniform4fv(this.handle, count, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code set4fv(count, OOGLES20.createFloatBuffer(values, offset));}.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies an array that will be used to update the specified uniform variable.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #set4fv
     */
    public void set4fv(int count, float[] values, int offset) {
        this.set4fv(count, OOGLES20.createFloatBuffer(values, offset));
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform4i}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set4i} modifies the value of a uniform variable or a uniform variable array. {@link #set4i} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code ivec4} or {@code bvec4} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set4i} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code ivec4} or {@code bvec4}, a {@link
     * OOError#INVALID_OPERATION} error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <!-- !!!!!!!!!! <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li> -->
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param x Specifies the first component of the new value to be used for the uniform variable.
     * @param y Specifies the second component of the new value to be used for the uniform variable.
     * @param z Specifies the third component of the new value to be used for the uniform variable.
     * @param w Specifies the fourth component of the new value to be used for the uniform variable.
     */
    public void set4i(int x, int y, int z, int w) {
        OOGLES20.backEnd.glUniform4i(this.handle, x, y, z, w);
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniform4iv}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #set4iv} modifies the value of a uniform variable or a uniform variable array. {@link #set4iv} operates
     * on the program object that was made part of current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code ivec4[]} or {@code bvec4[]} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #set4iv} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code ivec4[]} or {@code bvec4[]}, a {@link
     * OOError#INVALID_OPERATION} error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li>
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <!-- GL_INVALID_OPERATION is generated if count is greater than 1 and the indicated uniform variable is not
     *     an array variable. -->
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies a pointer to an array of {@code count} values that will be used to update the specified
     * uniform variable.
     */
    public void set4iv(int count, IntBuffer values) {
        OOGLES20.backEnd.glUniform4iv(this.handle, count, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code set4iv(count, OOGLES20.createIntBuffer(values, offset));}.</p>
     * 
     * @param count Specifies the number of elements that are to be modified.
     * @param values Specifies an array that will be used to update the specified uniform variable.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #set4iv
     */
    public void set4iv(int count, int[] values, int offset) {
        this.set4iv(count, OOGLES20.createIntBuffer(values, offset));
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniformMatrix2fv}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setMatrix2fv} modifies the value of a matrix or an array of matrices. Each matrix is assumed to be
     * supplied in column major order. The {@code count} argument indicates the number of matrices to be passed. A count
     * of {@code 1} should be used if modifying the value of a single matrix and a count greater than {@code 1} can be
     * used to modify an array of matrices. {@link #setMatrix2fv} operates on the program object that was made part of
     * current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code mat2} or {@code mat2[]} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #setMatrix2fv} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code mat2} or {@code mat2[]}, a {@link
     * OOError#INVALID_OPERATION} error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li>
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code count} is greater than {@code 1} and the
     *     indicated uniform variable is not an array variable.</li>
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param count Specifies the number of matrices that are to be modified. This should be {@code 1} if the targeted
     * uniform variable is not an array of matrices and {@code 1} or more if it is an array of matrices.
     * @param values Specifies a pointer to an array of {@code count} values that will be used to update the specified
     * uniform variable.
     */
    public void setMatrix2fv(int count, FloatBuffer values) {
        OOGLES20.backEnd.glUniformMatrix2fv(this.handle, count, false, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setMatrix2fv(count, OOGLES20.createFloatBuffer(values, offset));}.</p>
     * 
     * @param count Specifies the number of matrices that are to be modified. This should be {@code 1} if the targeted
     * uniform variable is not an array of matrices and {@code 1} or more if it is an array of matrices.
     * @param values Specifies an array that will be used to update the specified uniform variable.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #setMatrix2fv
     */
    public void setMatrix2fv(int count, float[] values, int offset) {
        this.setMatrix2fv(count, OOGLES20.createFloatBuffer(values, offset));
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniformMatrix3fv}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setMatrix3fv} modifies the value of a matrix or an array of matrices. Each matrix is assumed to be
     * supplied in column major order. The {@code count} argument indicates the number of matrices to be passed. A count
     * of {@code 1} should be used if modifying the value of a single matrix and a count greater than {@code 1} can be
     * used to modify an array of matrices. {@link #setMatrix3fv} operates on the program object that was made part of
     * current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code mat3} or {@code mat3[]} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #setMatrix3fv} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code mat3} or {@code mat3[]}, a {@link
     * OOError#INVALID_OPERATION} error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li>
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code count} is greater than {@code 1} and the
     *     indicated uniform variable is not an array variable.</li>
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param count Specifies the number of matrices that are to be modified. This should be {@code 1} if the targeted
     * uniform variable is not an array of matrices and {@code 1} or more if it is an array of matrices.
     * @param values Specifies a pointer to an array of {@code count} values that will be used to update the specified
     * uniform variable.
     */
    public void setMatrix3fv(int count, FloatBuffer values) {
        OOGLES20.backEnd.glUniformMatrix3fv(this.handle, count, false, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setMatrix3fv(count, OOGLES20.createFloatBuffer(values, offset));}.</p>
     * 
     * @param count Specifies the number of matrices that are to be modified. This should be {@code 1} if the targeted
     * uniform variable is not an array of matrices and {@code 1} or more if it is an array of matrices.
     * @param values Specifies an array that will be used to update the specified uniform variable.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #setMatrix3fv
     */
    public void setMatrix3fv(int count, float[] values, int offset) {
        this.setMatrix3fv(count, OOGLES20.createFloatBuffer(values, offset));
    }
    
    /**
     * <p>Specify the value of the uniform variable for the current program object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUniformMatrix4fv}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setMatrix4fv} modifies the value of a matrix or an array of matrices. Each matrix is assumed to be
     * supplied in column major order. The {@code count} argument indicates the number of matrices to be passed. A count
     * of {@code 1} should be used if modifying the value of a single matrix and a count greater than {@code 1} can be
     * used to modify an array of matrices. {@link #setMatrix4fv} operates on the program object that was made part of
     * current state by calling {@link OOGLES20#useProgram}.</p>
     * 
     * <p>This command is used to change the value of a {@code mat4} or {@code mat4[]} uniform variable.</p>
     * 
     * <p>All active uniform variables defined in a program object are initialized to {@code 0} when the program object
     * is linked successfully. They retain the values assigned to them by a call to {@link #setMatrix4fv} until the next
     * successful link operation occurs on the program object, when they are once again initialized to {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If the uniform variable as defined in the shader is not a {@code mat4} or {@code mat4[]}, a {@link
     * OOError#INVALID_OPERATION} error will be generated and the uniform variable will remain unchanged.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if there is no current program object.</li>
     *     <!-- GL_INVALID_OPERATION is generated if the size of the uniform variable declared in the shader does not
     *     match the size indicated by the glUniform command. -->
     *     <!-- GL_INVALID_OPERATION is generated if one of the integer variants of this function is used to load a
     *     uniform variable of type float, vec2, vec3, vec4 or an array of these or if one of the floating-point
     *     variants of this function is used to load a uniform variable of type int, ivec2, ivec3 or ivec4 or an array
     *     of these. -->
     *     <!-- GL_INVALID_OPERATION is generated if location is an invalid uniform location for the current program
     *     object and location is not equal to -1. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code count} is less than 0.</li>
     *     <!-- GL_INVALID_VALUE is generated if transpose is not GL_FALSE. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code count} is greater than {@code 1} and the
     *     indicated uniform variable is not an array variable.</li>
     *     <!-- !!!!!!!!!! GL_INVALID_OPERATION is generated if a sampler is loaded using a command other than
     *     glUniform1i and glUniform1iv. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param count Specifies the number of matrices that are to be modified. This should be {@code 1} if the targeted
     * uniform variable is not an array of matrices and {@code 1} or more if it is an array of matrices.
     * @param values Specifies a pointer to an array of {@code count} values that will be used to update the specified
     * uniform variable.
     */
    public void setMatrix4fv(int count, FloatBuffer values) {
        OOGLES20.backEnd.glUniformMatrix4fv(this.handle, count, false, values);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setMatrix4fv(count, OOGLES20.createFloatBuffer(values, offset));}.</p>
     * 
     * @param count Specifies the number of matrices that are to be modified. This should be {@code 1} if the targeted
     * uniform variable is not an array of matrices and {@code 1} or more if it is an array of matrices.
     * @param values Specifies an array that will be used to update the specified uniform variable.
     * @param offset Specifies an offset in the array where the data starts.
     * 
     * @see #setMatrix4fv
     */
    public void setMatrix4fv(int count, float[] values, int offset) {
        OOGLES20.backEnd.glUniformMatrix4fv(this.handle, count, false, OOGLES20.createFloatBuffer(values, offset));
    }
}
