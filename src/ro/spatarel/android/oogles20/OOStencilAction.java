package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible actions that can be performed on the stencil buffer.</p>
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
public enum OOStencilAction {
    /**
     * <p>Keeps the current value.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_KEEP} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    KEEP(OpenGLES20.GL_KEEP),
    
    /**
     * <p>Sets the stencil buffer value to 0.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_ZERO} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    ZERO(OpenGLES20.GL_ZERO),
    
    /**
     * <p>Sets the stencil buffer value to {@code referenceValue}, as specified by {@link
     * OOGLES20FragmentProcessing#setStencilFunction}.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_REPLACE} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    REPLACE(OpenGLES20.GL_REPLACE),
    
    /**
     * <p>Increments the current stencil buffer value. Clamps to the maximum representable unsigned value.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_INCR} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    INCREMENT(OpenGLES20.GL_INCR),
    
    /**
     * <p>Increments the current stencil buffer value. Wraps stencil buffer value to zero when incrementing the maximum
     * representable unsigned value.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_INCR_WRAP} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    INCREMENT_WRAP(OpenGLES20.GL_INCR_WRAP),
    
    /**
     * <p>Decrements the current stencil buffer value. Clamps to {@code 0}.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_DECR} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    DECREMENT(OpenGLES20.GL_DECR),
    
    /**
     * <p>Decrements the current stencil buffer value. Wraps stencil buffer value to the maximum representable unsigned
     * value when decrementing a stencil buffer value of zero.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_DECR_WRAP} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    DECREMENT_WRAP(OpenGLES20.GL_DECR_WRAP),
    
    /**
     * <p>Bitwise inverts the current stencil buffer value.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_INVERT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    INVERT(OpenGLES20.GL_INVERT);
    
    private final int glConstant;
    
    static OOStencilAction valueOf(int value) {
        for (OOStencilAction someValue : OOStencilAction.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    OOStencilAction(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
