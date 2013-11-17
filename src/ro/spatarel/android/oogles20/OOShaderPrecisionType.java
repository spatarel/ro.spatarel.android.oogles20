package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible types of shader precision levels.</p>
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
public enum OOShaderPrecisionType {
    /**
     * <p>{@code precision lowp float;} precision statement.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_LOW_FLOAT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    LOW_FLOAT(OpenGLES20.GL_LOW_FLOAT),
    
    /**
     * <p>{@code precision mediump float;} precision statement.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_MEDIUM_FLOAT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    MEDIUM_FLOAT(OpenGLES20.GL_MEDIUM_FLOAT), 
    
    /**
     * <p>{@code precision highp float;} precision statement.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_HIGH_FLOAT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    HIGH_FLOAT(OpenGLES20.GL_HIGH_FLOAT),
    
    /**
     * <p>{@code precision lowp int;} precision statement.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_LOW_INT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    LOW_INT(OpenGLES20.GL_LOW_INT), 
    
    /**
     * <p>{@code precision mediump int;} precision statement.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_MEDIUM_INT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    MEDIUM_INT(OpenGLES20.GL_MEDIUM_INT),
    
    /**
     * <p>{@code precision highp int;} precision statement.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_HIGH_INT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    HIGH_INT(OpenGLES20.GL_HIGH_INT);
    
    private final int glConstant;
    
    OOShaderPrecisionType(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
