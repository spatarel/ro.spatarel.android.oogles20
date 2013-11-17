package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible framebuffer attachment points.</p>
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
enum OOFramebufferAttachmentPoint {
    /**
     * <p>The color buffer of an application-created framebuffer object.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_COLOR_ATTACHMENT0} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    COLOR(OpenGLES20.GL_COLOR_ATTACHMENT0),
    
    /**
     * <p>The depth buffer of an application-created framebuffer object.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_DEPTH_ATTACHMENT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    DEPTH(OpenGLES20.GL_DEPTH_ATTACHMENT),
    
    /**
     * <p>The stencil buffer of an application-created framebuffer object.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_STENCIL_ATTACHMENT} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    STENCIL(OpenGLES20.GL_STENCIL_ATTACHMENT);

    private final int glConstant;
    
    OOFramebufferAttachmentPoint(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
