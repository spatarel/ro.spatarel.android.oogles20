package ro.spatarel.android.oogles20;

import java.nio.IntBuffer;

/**
 * <p>Class grouping together the methods managing the {@link OpenGLES20#GL_TEXTURE_2D} target on a certain texture
 * unit.</p>
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
public class OOGLES20Texture2D extends OOGLES20Texture {
    /**
     * <p>Wrapper for the {@link OpenGLES20#GL_TEXTURE_2D} target.</p>
     */
    public final OOGLES20TextureImage tex2D;
    
    OOGLES20Texture2D(int texture, OOTextureTarget target) {
        super(texture, target);
        this.tex2D = new OOGLES20TextureImage(texture, OOTextureImageTarget.TEXTURE_2D);
    }
    
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(1);
    
    /**
     * <p>Returns the name of the texture currently bound to the target for the active multitexture unit.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_TEXTURE_BINDING_2D}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the name of the texture currently bound to the target for the active multitexture unit. The initial
     * value is {@code null}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The name of the texture currently bound to the target for the active multitexture unit.
     * 
     * @see OOGLES20Texture#bind
     */
    public OOTexture getBindedTexture() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_TEXTURE_BINDING_2D, OOGLES20Texture2D.intBuffer);
        return OOTexture.getTexture(OOGLES20Texture2D.intBuffer.get(0));
    }
}
