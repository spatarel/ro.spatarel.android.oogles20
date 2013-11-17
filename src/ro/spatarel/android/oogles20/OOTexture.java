package ro.spatarel.android.oogles20;

import java.nio.IntBuffer;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Class modeling the texture names.</p>
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
public class OOTexture implements OOFramebufferAttachmentObject {
    
    private static final Map<Integer, OOTexture> textures = new TreeMap<Integer, OOTexture>();
    
    static OOTexture getTexture(int handle) {
        return OOTexture.textures.get(handle);
    }
    
    private int handle;
    
    int getHandle() {
        return this.handle;
    }
    
    /**
     * <p>Generate a texture name.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGenRenderbuffers}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Generate a texture name.</p>
     * 
     * <p>The generated texture has no dimensionality; it assumes the dimensionality of the texture target to which they
     * are first bound.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see OOGLES20Texture#bind
     * @see OOGLES20Texture#unbind
     * @see OOGLES20Framebuffer#copyToTextureImage2D
     * @see #finalize
     * @see OOGLES20TextureImage#setImage2D
     */
    public OOTexture() {
        IntBuffer handles = OOGLES20.createIntBuffer(1);
        OOGLES20.backEnd.glGenTextures(1, handles);
        if (handles.get(0) == 0) {
            throw new OOErrorOccuredCreatingObjectException();
        }
        this.handle = handles.get(0);
        OOTexture.textures.put(this.handle, this);
    }
    
    /**
     * <p>Delete the texture name.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDeleteTextures}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Delete the texture name.</p>
     * 
     * <p>After a texture is deleted, it has no contents or dimensionality. If a texture that is currently bound is
     * deleted, the binding reverts to {@code null} (the default texture).</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see OOGLES20Texture#bind
     * @see OOGLES20Texture#unbind
     * @see OOTexture#OOTexture
     */
    public void delete() {
        if (this.handle != 0) {
            IntBuffer handles = OOGLES20.createIntBuffer(new int[] { this.handle });
            OOGLES20.backEnd.glDeleteTextures(1, handles);
            OOTexture.textures.remove(this.handle);
            this.handle = 0;
        }
    }
    
    @Override
    protected void finalize() throws Throwable {
        this.delete();
        super.finalize();
    }
}
