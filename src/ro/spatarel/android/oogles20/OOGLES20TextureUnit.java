package ro.spatarel.android.oogles20;

/**
 * <p>Class grouping together the methods managing a certain texture unit.</p>
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
public class OOGLES20TextureUnit {
    /**
     * <p>Wrapper for the {@link OpenGLES20#GL_TEXTURE_2D} target.</p>
     */
    public final OOGLES20Texture2D tex2D;
    
    /**
     * <p>Wrapper for the {@link OpenGLES20#GL_TEXTURE_CUBE_MAP} target.</p>
     */
    public final OOGLES20TextureCubeMap texCubeMap;
    
    OOGLES20TextureUnit(int texture) {
        this.tex2D = new OOGLES20Texture2D(texture, OOTextureTarget.TEXTURE_2D);
        this.texCubeMap = new OOGLES20TextureCubeMap(texture, OOTextureTarget.TEXTURE_CUBE_MAP);
    }
}
