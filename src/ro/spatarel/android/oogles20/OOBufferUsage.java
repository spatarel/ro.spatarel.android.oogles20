package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible ways of buffer usages.</p>
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
public enum OOBufferUsage {
    /**
     * <p>The data store contents will be modified once and used at most a few times.</p>
     * 
     * <p>The data store contents are modified by the application and used as the source for GL drawing and image
     * specification commands.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_STREAM_DRAW} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2005 Addison-Wesley. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    STREAM_DRAW(OpenGLES20.GL_STREAM_DRAW),
    
    /**
     * <p>The data store contents will be modified once and used many times.</p>
     * 
     * <p>The data store contents are modified by the application and used as the source for GL drawing and image
     * specification commands.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_STATIC_DRAW} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2005 Addison-Wesley. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    STATIC_DRAW(OpenGLES20.GL_STATIC_DRAW),
    
    /**
     * <p>The data store contents will be modified repeatedly and used many times.</p>
     * 
     * <p>The data store contents are modified by the application and used as the source for GL drawing and image
     * specification commands.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_DYNAMIC_DRAW} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2005 Addison-Wesley. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     */
    DYNAMIC_DRAW(OpenGLES20.GL_DYNAMIC_DRAW);
    
    private final int glConstant;
    
    static OOBufferUsage valueOf(int value) {
        for (OOBufferUsage someValue : OOBufferUsage.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    OOBufferUsage(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
