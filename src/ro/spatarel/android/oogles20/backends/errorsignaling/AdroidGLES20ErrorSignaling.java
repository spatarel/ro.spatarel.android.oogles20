package ro.spatarel.android.oogles20.backends.errorsignaling;

import ro.spatarel.android.oogles20.OpenGLES20;
import ro.spatarel.android.oogles20.backends.AdroidGLES20Decorator;

/**
 * <p>Decorator for {@link OpenGLES20} raising appropriate exceptions for every generated error.</p>
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
public class AdroidGLES20ErrorSignaling extends AdroidGLES20Decorator {

    /**
     * <p>Creates a decorator for a specified {@link OpenGLES20} object that raises appropriate exceptions for every
     * generated error.</p>
     * 
     * @param base The decorated {@link OpenGLES20} object.
     */
    public AdroidGLES20ErrorSignaling(OpenGLES20 base) {
        super(base);
    }
    
    @Override
    protected void before() {
        // There is nothing here.
    }
    
    @Override
    protected void after() {
        int error;
        while((error = this.base.glGetError()) != OpenGLES20.GL_NO_ERROR) {
            switch (error) {
            case OpenGLES20.GL_INVALID_ENUM:
                throw new OOInvalidEnumException();
            case OpenGLES20.GL_INVALID_VALUE:
                throw new OOInvalidValueException();
            case OpenGLES20.GL_INVALID_OPERATION:
                throw new OOInvalidOperationException();
            case OpenGLES20.GL_INVALID_FRAMEBUFFER_OPERATION:
                throw new OOInvalidFramebufferOperationException();
            case OpenGLES20.GL_OUT_OF_MEMORY:
                throw new OOOutOfMemoryException();
            default:
            }
        }
    }
    
    @Override
    protected void call(String methodName, Object[] arguments) {
        // There is nothing here.
    }
}
