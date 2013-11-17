package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible types of an attribute variable.</p>
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
public enum OOAttributeDataType {
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
    FLOAT(OpenGLES20.GL_FLOAT, 1 * Float.SIZE / 8),
    
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
    FLOAT_VEC2(OpenGLES20.GL_FLOAT_VEC2, 2 * Float.SIZE / 8),
    
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
    FLOAT_VEC3(OpenGLES20.GL_FLOAT_VEC3, 3 * Float.SIZE / 8),
    
    /**
     * <p>{@code vec4} data type.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FLOAT_VEC4} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    FLOAT_VEC4(OpenGLES20.GL_FLOAT_VEC4, 4 * Float.SIZE / 8),
    
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
    FLOAT_MAT2(OpenGLES20.GL_FLOAT_MAT2, 2 * 2 * Float.SIZE / 8),
    
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
    FLOAT_MAT3(OpenGLES20.GL_FLOAT_MAT3, 3 * 3 * Float.SIZE / 8),
    
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
    FLOAT_MAT4(OpenGLES20.GL_FLOAT_MAT4, 4 * 4 * Float.SIZE / 8);
    
    private final int glConstant;
    private final int size;
    
    static OOAttributeDataType valueOf(int value) {
        for (OOAttributeDataType someValue : OOAttributeDataType.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    /**
     * <p>Returns the size of the data type in bytes.</p>
     * 
     * @return The size of the data type in bytes.
     */
    public int getSize() {
        return this.size;
    }
    
    OOAttributeDataType(int value, int size) {
        this.glConstant = value;
        this.size = size;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
