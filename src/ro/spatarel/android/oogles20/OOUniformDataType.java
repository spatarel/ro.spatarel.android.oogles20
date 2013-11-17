package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible uniform data types.</p>
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
public enum OOUniformDataType {
    /**
     * <p>{@code float} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FLOAT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    FLOAT(OpenGLES20.GL_FLOAT),
    
    /**
     * <p>{@code vec2} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FLOAT_VEC2} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    FLOAT_VEC2(OpenGLES20.GL_FLOAT_VEC2),
    
    /**
     * <p>{@code vec3} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FLOAT_VEC3} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    FLOAT_VEC3(OpenGLES20.GL_FLOAT_VEC3),
    
    /**
     * <p>{@code vec3} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FLOAT_VEC3} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    FLOAT_VEC4(OpenGLES20.GL_FLOAT_VEC4),
    
    /**
     * <p>{@code int} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_INT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    INT(OpenGLES20.GL_INT),
    
    /**
     * <p>{@code ivec2} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_INT_VEC2} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    INT_VEC2(OpenGLES20.GL_INT_VEC2),
    
    /**
     * <p>{@code ivec3} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_INT_VEC3} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    INT_VEC3(OpenGLES20.GL_INT_VEC3),
    
    /**
     * <p>{@code ivec4} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_INT_VEC4} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    INT_VEC4(OpenGLES20.GL_INT_VEC4),
    
    /**
     * <p>{@code bool} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_BOOL} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    BOOL(OpenGLES20.GL_BOOL),
    
    /**
     * <p>{@code bvec2} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_BOOL_VEC2} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    BOOL_VEC2(OpenGLES20.GL_BOOL_VEC2),
    
    /**
     * <p>{@code bvec3} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_BOOL_VEC3} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    BOOL_VEC3(OpenGLES20.GL_BOOL_VEC3),
    
    /**
     * <p>{@code bvec4} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_BOOL_VEC4} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    BOOL_VEC4(OpenGLES20.GL_BOOL_VEC4),
    
    /**
     * <p>{@code mat2} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FLOAT_MAT2} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    FLOAT_MAT2(OpenGLES20.GL_FLOAT_MAT2),
    
    /**
     * <p>{@code mat3} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FLOAT_MAT3} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    FLOAT_MAT3(OpenGLES20.GL_FLOAT_MAT3),
    
    /**
     * <p>{@code mat4} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FLOAT_MAT4} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    FLOAT_MAT4(OpenGLES20.GL_FLOAT_MAT4),
    
    /**
     * <p>{@code sampler2D} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_SAMPLER_2D} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    SAMPLER_2D(OpenGLES20.GL_SAMPLER_2D),
    
    /**
     * <p>{@code samplerCube} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_SAMPLER_CUBE} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    SAMPLER_CUBE(OpenGLES20.GL_SAMPLER_CUBE);
    
    private final int glConstant;
    
    static OOUniformDataType valueOf(int value) {
        for (OOUniformDataType someValue : OOUniformDataType.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    OOUniformDataType(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
