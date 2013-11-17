package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible errors.</p>
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
public enum OOError {
    /**
     * <p>No error has been recorded. The value of this symbolic constant is guaranteed to be 0.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_NO_ERROR} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    NO_ERROR(OpenGLES20.GL_NO_ERROR),
    
    /**
     * <p>An unacceptable value is specified for an enumerated argument. The offending command is ignored and has no
     * other side effect than to set the error flag.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_INVALID_ENUM} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    INVALID_ENUM(OpenGLES20.GL_INVALID_ENUM),
    
    /**
     * <p>A numeric argument is out of range. The offending command is ignored and has no other side effect than to set
     * the error flag.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_INVALID_VALUE} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    INVALID_VALUE(OpenGLES20.GL_INVALID_VALUE),
    
    /**
     * <p>The specified operation is not allowed in the current state. The offending command is ignored and has no other
     * side effect than to set the error flag.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_INVALID_OPERATION} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    INVALID_OPERATION(OpenGLES20.GL_INVALID_OPERATION),
    
    /**
     * The command is trying to render to or read from the framebuffer while the currently bound framebuffer is not
     * framebuffer complete (i.e. the return value from {@link OOGLES20Framebuffer#checkStatus()} is not {@link
     * OOFramebufferState#COMPLETE}. The offending command is ignored and has no other side effect than to set the
     * error flag.
     * 
     * <p>Reference to the {@link OpenGLES20#GL_INVALID_FRAMEBUFFER_OPERATION} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    INVALID_FRAMEBUFFER_OPERATION(OpenGLES20.GL_INVALID_FRAMEBUFFER_OPERATION),
    
    /**
     * There is not enough memory left to execute the command. The state of the GL is undefined, except for the state of
     * the error flags, after this error is recorded.
     * 
     * <p>Reference to the {@link OpenGLES20#GL_OUT_OF_MEMORY} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    OUT_OF_MEMORY(OpenGLES20.GL_OUT_OF_MEMORY);
    
    private final int glConstant;
    
    static OOError valueOf(int value) {
        for (OOError someValue : OOError.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    OOError(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
