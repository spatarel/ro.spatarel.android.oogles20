package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible framebuffer states.</p>
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
public enum OOFramebufferState {
    /**
     * <p>The framebuffer is complete.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FRAMEBUFFER_COMPLETE} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    COMPLETE(OpenGLES20.GL_FRAMEBUFFER_COMPLETE),
    
    /**
     * <p>Not all framebuffer attachment points are framebuffer attachment complete. This means that at least one
     * attachment point with a renderbuffer or texture attached has its attached object no longer in existence or has an
     * attached image with a width or height of zero or the color attachment point has a non-color-renderable image
     * attached or the depth attachment point has a non-depth-renderable image attached or the stencil attachment
     * point has a non-stencil-renderable image attached.</p>
     * 
     * <p>Color-renderable formats include {@link OORenderbufferFormat#RGBA4}, {@link OORenderbufferFormat#RGB5_A1} and
     * {@link OORenderbufferFormat#RGB565}. {@link OORenderbufferFormat#DEPTH_COMPONENT16} is the only depth-renderable
     * format. {@link OORenderbufferFormat#STENCIL_INDEX8} is the only stencil-renderable format.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    INCOMPLETE_ATTACHMENT(OpenGLES20.GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT),
    
    /**
     * <p>Not all attached images have the same width and height.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    INCOMPLETE_DIMENSIONS(OpenGLES20.GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS),
    
    /**
     * <p>No images are attached to the framebuffer.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    INCOMPLETE_MISSING_ATTACHMENT(OpenGLES20.GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT),
    
    /**
     * <p>The combination of internal formats of the attached images violates an implementation-dependent set of
     * restrictions.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_FRAMEBUFFER_UNSUPPORTED} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    UNSUPPORTED(OpenGLES20.GL_FRAMEBUFFER_UNSUPPORTED);
    
    private final int glConstant;
    
    static OOFramebufferState valueOf(int value) {
        for (OOFramebufferState someValue : OOFramebufferState.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    OOFramebufferState(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
