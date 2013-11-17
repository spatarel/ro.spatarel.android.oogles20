package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible depth test functions.</p>
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
public enum OODepthTestFunction {
    /**
     * <p>Always passes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_ALWAYS} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    ALWAYS(OpenGLES20.GL_ALWAYS),
    
    /**
     * <p>Never passes.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_NEVER} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    NEVER(OpenGLES20.GL_NEVER),
    
    /**
     * <p>Passes if the incoming depth value is less than the stored depth value.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_LESS} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    LESS(OpenGLES20.GL_LESS),
    
    /**
     * <p>Passes if the incoming depth value is less than or equal to the stored depth value.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_LEQUAL} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    LESS_OR_EQUAL(OpenGLES20.GL_LEQUAL),
    
    /**
     * <p>Passes if the incoming depth value is greater than the stored depth value.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_GREATER} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    GREATER(OpenGLES20.GL_GREATER),
    
    /**
     * <p>Passes if the incoming depth value is greater than or equal to the stored depth value.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_GEQUAL} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    GREATER_OR_EQUAL(OpenGLES20.GL_GEQUAL),
    
    /**
     * <p>Passes if the incoming depth value is equal to the stored depth value.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_EQUAL} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    EQUAL(OpenGLES20.GL_EQUAL),
    
    /**
     * <p>Passes if the incoming depth value is not equal to the stored depth value.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_NOTEQUAL} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    NOT_EQUAL(OpenGLES20.GL_NOTEQUAL);
    
    private final int glConstant;
    
    static OODepthTestFunction valueOf(int value) {
        for (OODepthTestFunction someValue : OODepthTestFunction.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    OODepthTestFunction(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
