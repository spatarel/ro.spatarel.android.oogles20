package ro.spatarel.android.oogles20;

import java.nio.IntBuffer;

/**
 * <p>Class grouping together the methods managing the {@link OpenGLES20#GL_TEXTURE_2D} or {@link
 * OpenGLES20#GL_TEXTURE_CUBE_MAP} target on a certain texture unit.</p>
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
public class OOGLES20Texture {
    private final int textureUnit;
    private final OOTextureTarget target;
    
    OOGLES20Texture(int textureUnit, OOTextureTarget target) {
        this.textureUnit = textureUnit;
        this.target = target;
    }
    
    /**
     * <p>Bind a named texture to a texturing target.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glBindTexture}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #bind} lets you create or use a named texture. Calling {@link #bind} with {@code texture} set to the
     * name of the new texture binds the texture name to the target of the current active texture unit. When a texture
     * is bound to a target, the previous binding for that target is automatically broken.</p>
     * 
     * <p>The {@code null} value is reserved to represent the default texture for each texture target. Texture names and
     * the corresponding texture contents are local to the shared object space of the current GL rendering context.</p>
     * 
     * <p>You may use {@link OOTexture#OOTexture} to generate a new texture name.</p>
     * 
     * <p>When a texture is first bound, it assumes the specified target: A texture first bound to {@link
     * OOGLES20TextureUnit#tex2D} becomes a two-dimensional texture and a texture first bound to {@link
     * OOGLES20TextureUnit#texCubeMap} becomes a cube-mapped texture. The state of a two-dimensional texture immediately
     * after it is first bound is equivalent to the state of the default {@link OOGLES20TextureUnit#tex2D} at GL
     * initialization and similarly for cube-mapped textures.</p>
     * 
     * <p>While a texture is bound, GL operations on the target to which it is bound affect the bound texture and
     * queries of the target to which it is bound return state from the bound texture. In effect, the texture targets
     * become aliases for the textures currently bound to them and the texture name {@code null} refers to the default
     * textures that were bound to them at initialization.</p>
     * 
     * <p>A texture binding created with {@link #bind} remains active until a different texture is bound to the same
     * target or until the bound texture is deleted with {@link OOTexture#finalize}.</p>
     * 
     * <p>Once created, a named texture may be re-bound to its same original target as often as needed. It is usually
     * much faster to use {@link #bind} to bind an existing named texture to one of the texture targets than it is to
     * reload the texture image using {@link OOGLES20TextureImage#setImage2D}.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if target is not one of the allowable values. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code texture} was previously created with a target
     *     that doesn't match that of the target.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param texture Specifies the name of a texture.
     * 
     * @see OOGLES20Texture2D#getBindedTexture
     * @see OOGLES20TextureCubeMap#getBindedTexture
     * @see OOTexture#finalize
     * @see OOTexture#OOTexture
     * @see OOGLES20TextureImage#setImage2D
     */
    public void bind(OOTexture texture) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        if (texture == null) {
            OOGLES20.backEnd.glBindTexture(this.target.getGLConstant(), 0);
        } else {
            OOGLES20.backEnd.glBindTexture(this.target.getGLConstant(), texture.getHandle());
        }
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code bind(null)}.</p>
     * 
     * @see #bind
     */
    public void unbind() {
        this.bind(null);
    }
    
    /**
     * <p>Generate a complete set of mipmaps for a texture object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGenerateMipmap}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link OOGLES20Texture#generateMipmaps} computes a complete set of mipmap arrays derived from the {@code 0}
     * level array. Array levels up to and including the {@code 1x1} dimension texture image are replaced with the
     * derived arrays, regardless of previous contents. The {@code 0} level texture image is left unchanged.</p>
     * 
     * <p>The internal formats of the derived mipmap arrays all match those of the {@code 0} level texture image. The
     * dimensions of the derived arrays are computed by halving the width and height of the {@code 0} level texture
     * image, then in turn halving the dimensions of each array level until the {@code 1x1} dimension texture image is
     * reached.</p>
     * 
     * <p>The contents of the derived arrays are computed by repeated filtered reduction of the {@code 0} level array.
     * No particular filter algorithm is required, though a box filter is recommended. {@link
     * OOGLES20#setGenerateMipmapHint} may be called to express a preference for speed or quality of filtering.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if target is not GL_TEXTURE_2D or GL_TEXTURE_CUBE_MAP. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the texture bound is a cube map, but its six faces do
     *     not share identical widths, heights, formats and types.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if either the width or height of the {@code 0} level array
     *     is not a power of two.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the {@code 0} level array is stored in a compressed
     *     internal format.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see #bind
     * @see OOGLES20FramebufferAttachment#attachTextureImage2D
     * @see OOGLES20#setGenerateMipmapHint
     * @see OOGLES20TextureImage#setImage2D
     */
    public void generateMipmaps() {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        OOGLES20.backEnd.glGenerateMipmap(this.target.getGLConstant());
    }
    
    /**
     * <p>Sets the texture minifying function.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glTexParameteri} with argument {@link OpenGLES20#GL_TEXTURE_MAG_FILTER}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Texture mapping is a technique that applies an image onto an object's surface as if the image were a decal or
     * cellophane shrink-wrap. The image is created in texture space, with an <i>(s, t)</i> coordinate system. A texture
     * is a two-dimensional or cube-mapped image and a set of parameters that determine how samples are derived from the
     * image.</p>
     * 
     * <p>The texture minifying function is used whenever the pixel being textured maps to an area greater than one
     * texture element. There are six defined minifying functions. Two of them use the nearest one or nearest four
     * texture elements to compute the texture value. The other four use mipmaps.</p>
     * 
     * <p>A mipmap is an ordered set of arrays representing the same image at progressively lower resolutions. If the
     * texture has dimensions <i>w × h</i>, there are <i>floor(log<sub>2</sub>(max(w, h))) + 1</i> mipmap levels. The
     * first mipmap level is the original texture, with dimensions <i>w × h</i>. Each subsequent mipmap level has
     * dimensions <i>max(1, floor(<sup>w</sup>&frasl;<sub>2<sup>i</sup></sub>)) ×
     * max(1, floor(<sup>h</sup>&frasl;<sub>2<sup>i</sup></sub>))</i>, where <i>i</i> is the mipmap level, until the
     * final mipmap is reached, which has dimension {@code 1 × 1}.</p>
     * 
     * <p>To define the mipmap levels, call {@link OOGLES20TextureImage#setImage2D}, {@link
     * OOGLES20TextureImage#setCompressedImage2D} or {@link OOGLES20Framebuffer#copyToTextureImage2D} with the
     * <i>level</i> argument indicating the order of the mipmaps. Level <i>0</i> is the original texture; level
     * <i>floor(log<sub>2</sub>(max(w, h)))</i> is the final {@code 1 × 1} mipmap.</p>
     * 
     * <p>{@code minificationFilter} supplies a function for minifying the texture as one of the following:</p>
     * 
     * <dl>
     *     <dt>{@link OOTextureMinificationFilter#NEAREST}</dt>
     *         <dd>Returns the value of the texture element that is nearest (in Manhattan distance) to the center of the
     *         pixel being textured.</dd>
     *     <dt>{@link OOTextureMinificationFilter#LINEAR}</dt>
     *         <dd>Returns the weighted average of the four texture elements that are closest to the center of the pixel
     *         being textured.</dd>
     *     <dt>{@link OOTextureMinificationFilter#NEAREST_MIPMAP_NEAREST}</dt>
     *         <dd>Chooses the mipmap that most closely matches the size of the pixel being textured and uses the
     *         {@link OOTextureMinificationFilter#NEAREST} criterion (the texture element nearest to the center of the
     *         pixel) to produce a texture value.</dd>
     *     <dt>{@link OOTextureMinificationFilter#LINEAR_MIPMAP_NEAREST}</dt>
     *         <dd>Chooses the mipmap that most closely matches the size of the pixel being textured and uses the
     *         {@link OOTextureMinificationFilter#LINEAR} criterion (a weighted average of the four texture elements
     *         that are closest to the center of the pixel) to produce a texture value.</dd>
     *     <dt>{@link OOTextureMinificationFilter#NEAREST_MIPMAP_LINEAR}</dt>
     *         <dd>Chooses the two mipmaps that most closely match the size of the pixel being textured and uses the
     *         {@link OOTextureMinificationFilter#NEAREST} criterion (the texture element nearest to the center of the
     *         pixel) to produce a texture value from each mipmap. The final texture value is a weighted average of
     *         those two values.</dd>
     *     <dt>{@link OOTextureMinificationFilter#LINEAR_MIPMAP_LINEAR}</dt>
     *         <dd>Chooses the two mipmaps that most closely match the size of the pixel being textured and uses the
     *         {@link OOTextureMinificationFilter#LINEAR} criterion (a weighted average of the four texture elements
     *         that are closest to the center of the pixel) to produce a texture value from each mipmap. The final
     *         texture value is a weighted average of those two values.</dd>
     * </dl>
     * 
     * <p>As more texture elements are sampled in the minification process, fewer aliasing artifacts will be apparent.
     * While the {@link OOTextureMinificationFilter#NEAREST} and {@link OOTextureMinificationFilter#LINEAR} minification
     * functions can be faster than the other four, they sample only one or four texture elements to determine the
     * texture value of the pixel being rendered and can produce moire patterns or ragged transitions. The initial value
     * of {@link #getMinificationFilter} is {@link OOTextureMinificationFilter#NEAREST_MIPMAP_LINEAR}.
     * 
     * <h5>Notes</h5>
     * 
     * <p>Suppose that a texture is accessed from a fragment shader or vertex shader and has set {@link
     * #getMinificationFilter} to one of the functions that requires mipmaps. If either the dimensions of the texture
     * images currently defined (with previous calls to {@link OOGLES20TextureImage#setImage2D}, {@link
     * OOGLES20TextureImage#setCompressedImage2D} or {@link OOGLES20Framebuffer#copyToTextureImage2D}) do not follow the
     * proper sequence for mipmaps (described above) or there are fewer texture images defined than are needed or the
     * set of texture images were defined with different formats or types, then the texture image unit will return
     * {@code (R, G, B, A) = (0, 0, 0, 1)}.</p>
     * 
     * <p>Similarly, if the width or height of a texture image are not powers of two and either the {@link
     * #getMinificationFilter} is set to one of the functions that requires mipmaps or the {@link #getWrapS} or {@link
     * #getWrapT} is not set to {@link OOTextureWrapMode#CLAMP_TO_EDGE}, then the texture image unit will return
     * {@code (R, G, B, A) = (0, 0, 0, 1)}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param minificationFilter Supplies the texture minifying function.
     */
    public void setMinificationFilter(OOTextureMinificationFilter minificationFilter) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        OOGLES20.backEnd.glTexParameteri(this.target.getGLConstant(), OpenGLES20.GL_TEXTURE_MIN_FILTER,
                minificationFilter.getGLConstant());
    }
    
    /**
     * <p>Sets the texture magnification function.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glTexParameteri} with argument {@link OpenGLES20#GL_TEXTURE_MAG_FILTER}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Texture mapping is a technique that applies an image onto an object's surface as if the image were a decal or
     * cellophane shrink-wrap. The image is created in texture space, with an <i>(s, t)</i> coordinate system. A texture
     * is a two-dimensional or cube-mapped image and a set of parameters that determine how samples are derived from the
     * image.</p>
     * 
     * <p>The texture magnification function is used when the pixel being textured maps to an area less than or equal to
     * one texture element. It sets the texture magnification function to either {@link
     * OOTextureMagnificationFilter#NEAREST} or {@link OOTextureMagnificationFilter#LINEAR} (see below). {@link
     * OOTextureMagnificationFilter#NEAREST} is generally faster than {@link OOTextureMagnificationFilter#LINEAR}, but
     * it can produce textured images with sharper edges because the transition between texture elements is not as
     * smooth. The initial value of {@link #getMagnificationFilter} is {@link OOTextureMagnificationFilter#LINEAR}.</p>
     * 
     * <dl>
     *     <dt>{@link OOTextureMagnificationFilter#NEAREST}</dt>
     *         <dd>Returns the value of the texture element that is nearest (in Manhattan distance) to the center of the
     *         pixel being textured.</dd>
     *     <dt>{@link OOTextureMagnificationFilter#LINEAR}</dt>
     *         <dd>Returns the weighted average of the four texture elements that are closest to the center of the pixel
     *         being textured.</dd>
     * </dl>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Suppose that a texture is accessed from a fragment shader or vertex shader and has set {@link
     * #getMinificationFilter} to one of the functions that requires mipmaps. If either the dimensions of the texture
     * images currently defined (with previous calls to {@link OOGLES20TextureImage#setImage2D}, {@link
     * OOGLES20TextureImage#setCompressedImage2D} or {@link OOGLES20Framebuffer#copyToTextureImage2D}) do not follow the
     * proper sequence for mipmaps (described above) or there are fewer texture images defined than are needed or the
     * set of texture images were defined with different formats or types, then the texture image unit will return
     * {@code (R, G, B, A) = (0, 0, 0, 1)}.</p>
     * 
     * <p>Similarly, if the width or height of a texture image are not powers of two and either the {@link
     * #getMinificationFilter} is set to one of the functions that requires mipmaps or the {@link #getWrapS} or {@link
     * #getWrapT} is not set to {@link OOTextureWrapMode#CLAMP_TO_EDGE}, then the texture image unit will return
     * {@code (R, G, B, A) = (0, 0, 0, 1)}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param magnificationFilter Supplies the texture magnification function.
     */
    public void setMagnificationFilter(OOTextureMagnificationFilter magnificationFilter) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        OOGLES20.backEnd.glTexParameteri(this.target.getGLConstant(), OpenGLES20.GL_TEXTURE_MAG_FILTER,
                magnificationFilter.getGLConstant());
    }
    
    /**
     * <p>Sets the wrap parameter for texture coordinate <i>s</i>.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glTexParameteri} with argument {@link OpenGLES20#GL_TEXTURE_MAG_FILTER}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Texture mapping is a technique that applies an image onto an object's surface as if the image were a decal or
     * cellophane shrink-wrap. The image is created in texture space, with an <i>(s, t)</i> coordinate system. A texture
     * is a two-dimensional or cube-mapped image and a set of parameters that determine how samples are derived from the
     * image.</p>
     * 
     * <p>Sets the wrap parameter for texture coordinate <i>s</i> to either {@link OOTextureWrapMode#CLAMP_TO_EDGE},
     * {@link OOTextureWrapMode#MIRRORED_REPEAT} or {@link OOTextureWrapMode#REPEAT}. {@link
     * OOTextureWrapMode#CLAMP_TO_EDGE} causes <i>s</i> coordinates to be clamped to the range
     * <i>[<sup>1</sup>&frasl;<sub>2N</sub>, 1 - <sup>1</sup>&frasl;<sub>2N</sub>]</i>, where <i>N</i> is the size of
     * the texture in the direction of clamping. {@link OOTextureWrapMode#REPEAT} causes the integer part of the
     * <i>s</i> coordinate to be ignored; the GL uses only the fractional part, thereby creating a repeating pattern.
     * {@link OOTextureWrapMode#MIRRORED_REPEAT} causes the <i>s</i> coordinate to be set to the fractional part of the
     * texture coordinate if the integer part of <i>s</i> is even; if the integer part of <i>s</i> is odd, then the
     * <i>s</i> texture coordinate is set to <i>1 - frac(s)</i>, where <i>frac(s)</i> represents the fractional part of
     * <i>s</i>. Initially, {@link #getWrapS} is set to {@link OOTextureWrapMode#REPEAT}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Suppose that a texture is accessed from a fragment shader or vertex shader and has set {@link
     * #getMinificationFilter} to one of the functions that requires mipmaps. If either the dimensions of the texture
     * images currently defined (with previous calls to {@link OOGLES20TextureImage#setImage2D}, {@link
     * OOGLES20TextureImage#setCompressedImage2D} or {@link OOGLES20Framebuffer#copyToTextureImage2D}) do not follow the
     * proper sequence for mipmaps (described above) or there are fewer texture images defined than are needed or the
     * set of texture images were defined with different formats or types, then the texture image unit will return
     * {@code (R, G, B, A) = (0, 0, 0, 1)}.</p>
     * 
     * <p>Similarly, if the width or height of a texture image are not powers of two and either the {@link
     * #getMinificationFilter} is set to one of the functions that requires mipmaps or the {@link #getWrapS} or {@link
     * #getWrapT} is not set to {@link OOTextureWrapMode#CLAMP_TO_EDGE}, then the texture image unit will return
     * {@code (R, G, B, A) = (0, 0, 0, 1)}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param wrapS Supplies the wrap parameter for texture coordinate <i>s</i>
     */
    public void setWrapS(OOTextureWrapMode wrapS) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        OOGLES20.backEnd.glTexParameteri(this.target.getGLConstant(), OpenGLES20.GL_TEXTURE_WRAP_S,
                wrapS.getGLConstant());
    }
    
    /**
     * <p>Sets the wrap parameter for texture coordinate <i>t</i>.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glTexParameteri} with argument {@link OpenGLES20#GL_TEXTURE_MAG_FILTER}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Texture mapping is a technique that applies an image onto an object's surface as if the image were a decal or
     * cellophane shrink-wrap. The image is created in texture space, with an <i>(s, t)</i> coordinate system. A texture
     * is a two-dimensional or cube-mapped image and a set of parameters that determine how samples are derived from the
     * image.</p>
     * 
     * <p>Sets the wrap parameter for texture coordinate <i>t</i> to either {@link OOTextureWrapMode#CLAMP_TO_EDGE},
     * {@link OOTextureWrapMode#MIRRORED_REPEAT} or {@link OOTextureWrapMode#REPEAT}. {@link
     * OOTextureWrapMode#CLAMP_TO_EDGE} causes <i>t</i> coordinates to be clamped to the range
     * <i>[<sup>1</sup>&frasl;<sub>2N</sub>, 1 - <sup>1</sup>&frasl;<sub>2N</sub>]</i>, where <i>N</i> is the size of
     * the texture in the direction of clamping. {@link OOTextureWrapMode#REPEAT} causes the integer part of the
     * <i>t</i> coordinate to be ignored; the GL uses only the fractional part, thereby creating a repeating pattern.
     * {@link OOTextureWrapMode#MIRRORED_REPEAT} causes the <i>t</i> coordinate to be set to the fractional part of the
     * texture coordinate if the integer part of <i>t</i> is even; if the integer part of <i>t</i> is odd, then the
     * <i>t</i> texture coordinate is set to <i>1 - frac(t)</i>, where <i>frac(t)</i> represents the fractional part of
     * <i>t</i>. Initially, {@link #getWrapT} is set to {@link OOTextureWrapMode#REPEAT}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Suppose that a texture is accessed from a fragment shader or vertex shader and has set {@link
     * #getMinificationFilter} to one of the functions that requires mipmaps. If either the dimensions of the texture
     * images currently defined (with previous calls to {@link OOGLES20TextureImage#setImage2D}, {@link
     * OOGLES20TextureImage#setCompressedImage2D} or {@link OOGLES20Framebuffer#copyToTextureImage2D}) do not follow the
     * proper sequence for mipmaps (described above) or there are fewer texture images defined than are needed or the
     * set of texture images were defined with different formats or types, then the texture image unit will return
     * {@code (R, G, B, A) = (0, 0, 0, 1)}.</p>
     * 
     * <p>Similarly, if the width or height of a texture image are not powers of two and either the {@link
     * #getMinificationFilter} is set to one of the functions that requires mipmaps or the {@link #getWrapS} or {@link
     * #getWrapT} is not set to {@link OOTextureWrapMode#CLAMP_TO_EDGE}, then the texture image unit will return
     * {@code (R, G, B, A) = (0, 0, 0, 1)}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param wrapT Supplies the wrap parameter for texture coordinate <i>t</i>
     */
    public void setWrapT(OOTextureWrapMode wrapT) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        OOGLES20.backEnd.glTexParameteri(this.target.getGLConstant(), OpenGLES20.GL_TEXTURE_WRAP_T,
                wrapT.getGLConstant());
    }
    
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(1);
    
    /**
     * <p>Returns the texture minification filter, an enum constant.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetTexParameteriv} with argument {@link OpenGLES20#GL_TEXTURE_MIN_FILTER}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the texture minification filter, an enum constant. The initial value is {@link
     * OOTextureMinificationFilter#NEAREST_MIPMAP_LINEAR}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The texture minification filter, an enum constant.
     */
    public OOTextureMinificationFilter getMinificationFilter() {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        OOGLES20.backEnd.glGetTexParameteriv(this.target.getGLConstant(), OpenGLES20.GL_TEXTURE_MIN_FILTER,
                OOGLES20Texture.intBuffer);
        return OOTextureMinificationFilter.valueOf(OOGLES20Texture.intBuffer.get(0));
    }
    
    /**
     * <p>Returns the texture magnification filter, an enum constant.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetTexParameteriv} with argument {@link OpenGLES20#GL_TEXTURE_MAG_FILTER}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the texture magnification filter, an enum constant. The initial value is {@link
     * OOTextureMagnificationFilter#LINEAR}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The texture magnification filter, an enum constant.
     */
    public OOTextureMagnificationFilter getMagnificationFilter() {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        OOGLES20.backEnd.glGetTexParameteriv(this.target.getGLConstant(), OpenGLES20.GL_TEXTURE_MAG_FILTER,
                OOGLES20Texture.intBuffer);
        return OOTextureMagnificationFilter.valueOf(OOGLES20Texture.intBuffer.get(0));
    }
    
    /**
     * <p>Returns the wrapping function for texture coordinate <i>s</i>, an enum constant.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetTexParameteriv} with argument {@link OpenGLES20#GL_TEXTURE_WRAP_S}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the wrapping function for texture coordinate <i>s</i>, an enum constant. The initial value is
     * {@link OOTextureWrapMode#REPEAT}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The wrapping function for texture coordinate <i>s</i>, an enum constant.
     */
    public OOTextureWrapMode getWrapS() {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        OOGLES20.backEnd.glGetTexParameteriv(this.target.getGLConstant(), OpenGLES20.GL_TEXTURE_WRAP_S,
                OOGLES20Texture.intBuffer);
        return OOTextureWrapMode.valueOf(OOGLES20Texture.intBuffer.get(0));
    }
    
    /**
     * <p>Returns the wrapping function for texture coordinate <i>t</i>, an enum constant.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetTexParameteriv} with argument {@link OpenGLES20#GL_TEXTURE_WRAP_T}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the wrapping function for texture coordinate <i>t</i>, an enum constant. The initial value is
     * {@link OOTextureWrapMode#REPEAT}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The wrapping function for texture coordinate <i>t</i>, an enum constant.
     */
    public OOTextureWrapMode getWrapT() {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        OOGLES20.backEnd.glGetTexParameteriv(this.target.getGLConstant(), OpenGLES20.GL_TEXTURE_WRAP_T,
                OOGLES20Texture.intBuffer);
        return OOTextureWrapMode.valueOf(OOGLES20Texture.intBuffer.get(0));
    }
}
