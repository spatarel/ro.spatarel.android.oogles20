package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible renderbuffer formats.</p>
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
public enum OORenderbufferFormat {
    /**
     * <p>4 red bits, 4 green bits, 4 blue bits and 4 alpha bits.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_RGBA4} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    RGBA4(OpenGLES20.GL_RGBA4),
    
    /**
     * <p>5 red bits, 6 green bits and 5 blue bits.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_RGB565} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    RGB565(OpenGLES20.GL_RGB565),
    
    /**
     * <p>5 red bits, 5 green bits, 5 blue bits and 1 alpha bit.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_RGB5_A1} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    RGB5_A1(OpenGLES20.GL_RGB5_A1),
    
    /**
     * <p>16 depth bits.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_DEPTH_COMPONENT16} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    DEPTH_COMPONENT16(OpenGLES20.GL_DEPTH_COMPONENT16),
    
    /**
     * <p>8 stencil bits.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_STENCIL_INDEX8} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    STENCIL_INDEX8(OpenGLES20.GL_STENCIL_INDEX8);
    
    private final int glConstant;
    
    static OORenderbufferFormat valueOf(int value) {
        for (OORenderbufferFormat someValue : OORenderbufferFormat.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    OORenderbufferFormat(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
