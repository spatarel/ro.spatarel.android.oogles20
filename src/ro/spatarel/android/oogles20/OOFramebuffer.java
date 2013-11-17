package ro.spatarel.android.oogles20;

import java.nio.IntBuffer;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Class modeling the framebuffer object names.</p>
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
public class OOFramebuffer {
    
    private static final Map<Integer, OOFramebuffer> framebuffers = new TreeMap<Integer, OOFramebuffer>();
    
    static OOFramebuffer getFramebuffer(int handle) {
        return OOFramebuffer.framebuffers.get(handle);
    }
    
    private int handle;
    
    /**
     * <p>Generate a framebuffer object name.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGenFramebuffers}</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see OOGLES20Framebuffer#bind
     * @see OOGLES20Framebuffer#bindDefault
     * @see #finalize
     */
    public OOFramebuffer() {
        IntBuffer handles = OOGLES20.createIntBuffer(1);
        OOGLES20.backEnd.glGenFramebuffers(1, handles);
        if (handles.get(0) == 0) {
            throw new OOErrorOccuredCreatingObjectException();
        }
        this.handle = handles.get(0);
        OOFramebuffer.framebuffers.put(this.handle, this);
    }
    
    int getHandle() {
        return this.handle;
    }
    
    @Override
    protected void finalize() throws Throwable {
        this.delete();
        super.finalize();
    }
    
    /**
     * <p>Delete the framebuffer object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDeleteFramebuffers}</p>
     * 
     * <p>After a framebuffer object is deleted, it has no attachments. If a framebuffer object that is currently bound
     * is deleted, the binding reverts to {@code null} (the window-system-provided framebuffer).</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see OOGLES20Buffer#bind
     * @see OOGLES20Buffer#unbind
     * @see OOBuffer#OOBuffer
     */
    public void delete() {
        if (this.handle != 0) {
            IntBuffer handles = OOGLES20.createIntBuffer(new int[] { this.handle });
            OOGLES20.backEnd.glDeleteFramebuffers(1, handles);
            OOFramebuffer.framebuffers.remove(this.handle);
            this.handle = 0;
        }
    }
}
