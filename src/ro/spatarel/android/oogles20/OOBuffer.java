package ro.spatarel.android.oogles20;

import java.nio.IntBuffer;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Class modeling the buffer object names.</p>
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
public class OOBuffer {
    
    private static final Map<Integer, OOBuffer> buffers = new TreeMap<Integer, OOBuffer>();
    
    static OOBuffer getBuffer(int handle) {
        return OOBuffer.buffers.get(handle);
    }
    
    private int handle;
    
    int getHandle() {
        return this.handle;
    }
    
    /**
     * <p>Generate a buffer object name.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGenBuffers}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Generate a buffer object name.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2005 Addison-Wesley. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see OOGLES20Buffer#bind
     * @see OOGLES20Buffer#unbind
     * @see #finalize
     */
    public OOBuffer() {
        IntBuffer handles = OOGLES20.createIntBuffer(1);
        OOGLES20.backEnd.glGenBuffers(1, handles);
        if (handles.get(0) == 0) {
            throw new OOErrorOccuredCreatingObjectException();
        }
        this.handle = handles.get(0);
        OOBuffer.buffers.put(this.handle, this);
    }
    
    /**
     * <p>Delete the buffer object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDeleteBuffers}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Delete the buffer object.</p>
     * 
     * <p>After a buffer object is deleted, it has no contents. If a buffer object that is currently bound is deleted,
     * the binding reverts to {@code null} (the absence of any buffer object, which reverts to client memory usage).</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2005 Addison-Wesley. This material may be distributed subject to the terms and conditions set
     * forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see OOGLES20Buffer#bind
     * @see OOGLES20Buffer#unbind
     * @see #OOBuffer
     */
    public void delete() {
        if (this.handle != 0) {
            IntBuffer handles = OOGLES20.createIntBuffer(new int[] { this.handle });
            OOGLES20.backEnd.glDeleteBuffers(1, handles);
            OOBuffer.buffers.remove(this.handle);
            this.handle = 0;
        }
    }
    
    @Override
    protected void finalize() throws Throwable {
        this.delete();
        super.finalize();
    }
}
