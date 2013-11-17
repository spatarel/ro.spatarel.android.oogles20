package ro.spatarel.android.oogles20;

import java.nio.Buffer;

import android.graphics.Bitmap;
import android.opengl.GLUtils;

/**
 * <p>Class grouping together the methods managing the {@link OpenGLES20#GL_TEXTURE_2D}, {@link
 * OpenGLES20#GL_TEXTURE_CUBE_MAP_POSITIVE_X}, OpenGLES20#GL_TEXTURE_CUBE_MAP_NEGATIVE_X}, {@link
 * OpenGLES20#GL_TEXTURE_CUBE_MAP_POSITIVE_Y}, OpenGLES20#GL_TEXTURE_CUBE_MAP_NEGATIVE_Y}, {@link
 * OpenGLES20#GL_TEXTURE_CUBE_MAP_POSITIVE_Z} or OpenGLES20#GL_TEXTURE_CUBE_MAP_NEGATIVE_Z} targets on a certain texture
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
public class OOGLES20TextureImage {
    
    private final int textureUnit;
    private final OOTextureImageTarget target;
    
    int getTextureUnit() {
        return this.textureUnit;
    }
    
    OOTextureImageTarget getTarget() {
        return this.target;
    }
    
    OOGLES20TextureImage(int textureUnit, OOTextureImageTarget target) {
        this.textureUnit = textureUnit;
        this.target = target;
    }
    
    /**
     * <p>Specify a two-dimensional texture image.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glTexImage2D}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Texturing maps a portion of a specified texture image onto each graphical primitive for which texturing is
     * active. Texturing is active when the current fragment shader or vertex shader makes use of built-in texture
     * lookup functions.</p>
     * 
     * <p>To define texture images, call {@link #setImage2D}. The arguments describe the parameters of the texture
     * image, such as height, width, level-of-detail number and format. The last three arguments describe how the image
     * is represented in memory.</p>
     * 
     * <p>Data is read from data as a sequence of unsigned bytes or shorts, depending on {@code type}. When {@code type}
     * is {@link OOPixelDataType#UNSIGNED_BYTE}, each of the bytes is interpreted as one color component. When {@code
     * type} is one of {@link OOPixelDataType#UNSIGNED_SHORT_5_6_5}, {@link OOPixelDataType#UNSIGNED_SHORT_4_4_4_4}
     * or {@link OOPixelDataType#UNSIGNED_SHORT_5_5_5_1}, each unsigned short value is interpreted as containing all the
     * components for a single texel, with the color components arranged according to format. Color components are
     * treated as groups of one, two, three or four values, again based on {@code format}. Groups of components are
     * referred to as texels.</p>
     * 
     * <p><i>width × height</i> texels are read from memory, starting at location {@code data}. By default, these texels
     * are taken from adjacent memory locations, except that after all {@code width} texels are read, the read pointer
     * is advanced to the next four-byte boundary. The four-byte row alignment is specified by {@link
     * OOGLES20#setPixelAlignment} with argument {@link OOGLES20#getPixelUnpackAlignment} and it can be set to one,
     * two, four or eight bytes.</p>
     * 
     * <p>The first element corresponds to the lower left corner of the texture image. Subsequent elements progress
     * left-to-right through the remaining texels in the lowest row of the texture image and then in successively
     * higher rows of the texture image. The final element corresponds to the upper right corner of the texture image.
     * </p>
     * 
     * <p>{@code format} determines the composition of each element in data. It can assume one of these symbolic values:
     * </p>
     * 
     * <dl>
     *     <dt>{@link OOTexelFormat#ALPHA}</dt>
     *         <dd>Each element is a single alpha component. The GL converts it to floating point and assembles it into
     *         an RGBA element by attaching {@code 0} for red, green and blue. Each component is then clamped to the
     *         range {@code [0, 1]}.</dd>
     *     <dt>{@link OOTexelFormat#RGB}</dt>
     *         <dd>Each element is an RGB triple. The GL converts it to floating point and assembles it into an RGBA
     *         element by attaching {@code 1} for alpha. Each component is then clamped to the range {@code [0, 1]}.
     *         </dd>
     *     <dt>{@link OOTexelFormat#RGBA}</dt>
     *         <dd>Each element contains all four components. The GL converts it to floating point, then each component
     *         is clamped to the range {@code [0, 1]}.</dd>
     *     <dt>{@link OOTexelFormat#LUMINANCE}</dt>
     *         <dd>Each element is a single luminance value. The GL converts it to floating point, then assembles it
     *         into an RGBA element by replicating the luminance value three times for red, green and blue and
     *         attaching {@code 1} for alpha. Each component is then clamped to the range {@code [0, 1]}.</dd>
     *     <dt>{@link OOTexelFormat#LUMINANCE_ALPHA}</dt>
     *         <dd>Each element is a luminance/alpha pair. The GL converts it to floating point, then assembles it into
     *         an RGBA element by replicating the luminance value three times for red, green and blue. Each component
     *         is then clamped to the range {@code [0, 1]}.</dd>
     * </dl>
     * 
     * <p>Color components are converted to floating point based on the {@code type}. When {@code type} is {@link
     * OOPixelDataType#UNSIGNED_BYTE}, each component is divided by <i>2<sup>8</sup> - 1</i>. When {@code type} is
     * {@link OOPixelDataType#UNSIGNED_SHORT_5_6_5}, {@link OOPixelDataType#UNSIGNED_SHORT_4_4_4_4} or {@link
     * OOPixelDataType#UNSIGNED_SHORT_5_5_5_1}, each component is divided by <i>2<sup>N</sup> - 1</i>, where <i>N</i> is
     * the number of bits in the bitfield.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>No conversion between formats is supported during texture image processing. {@code type} may be used as a hint
     * to specify how much precision is desired, but a GL implementation may choose to store the texture array at any
     * internal resolution it chooses.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if target is not GL_TEXTURE_2D, GL_TEXTURE_CUBE_MAP_POSITIVE_X,
     *     GL_TEXTURE_CUBE_MAP_NEGATIVE_X, GL_TEXTURE_CUBE_MAP_POSITIVE_Y, GL_TEXTURE_CUBE_MAP_NEGATIVE_Y,
     *     GL_TEXTURE_CUBE_MAP_POSITIVE_Z or GL_TEXTURE_CUBE_MAP_NEGATIVE_Z. -->
     *     <!-- GL_INVALID_ENUM is generated if format is not an accepted format. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code target} is one of the six cube map 2D image targets
     *     and the width and height parameters are not equal.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code level} is less than {@code 0}.</li>
     *     <li>{@link OOError#INVALID_VALUE} may be generated if {@code level} is greater than
     *     <i>log<sub>2</sub>max</i>, where <i>max</i> is the returned value of {@link
     *     OOGLES20Implementation#getMaximum2DTextureSize} when the target is {@link OOGLES20TextureUnit#tex2D} or
     *     {@link OOGLES20Implementation#getMaximumCubeMapTextureSize} when target is {@link
     *     OOGLES20TextureUnit#texCubeMap}.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code format} is not an accepted format.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code width} or {@code height} is less than {@code 0} or
     *     greater than {@link OOGLES20Implementation#getMaximum2DTextureSize} when target is {@link
     *     OOGLES20TextureUnit#tex2D} or {@link OOGLES20Implementation#getMaximumCubeMapTextureSize} when target is
     *     {@link OOGLES20TextureUnit#texCubeMap}.</li>
     *     <!-- GL_INVALID_VALUE is generated if border is not 0. -->
     *     <!-- GL_INVALID_OPERATION is generated if format does not match internalformat.-->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code type} is {@link
     *     OOPixelDataType#UNSIGNED_SHORT_5_6_5} and {@code format} is not {@link OOTexelFormat#RGB}.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code type} is {@link
     *     OOPixelDataType#UNSIGNED_SHORT_4_4_4_4} or {@link OOPixelDataType#UNSIGNED_SHORT_5_5_5_1} and {@code format}
     *     is not {@link OOTexelFormat#RGBA}.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param level Specifies the level-of-detail number. Level {@code 0} is the base image level. Level <i>n</i> is the
     * <i>n</i>th mipmap reduction image.
     * @param format Specifies the internal format of the texture.
     * @param width Specifies the width of the texture image. All implementations support 2D texture images that are at
     * least 64 texels wide and cube-mapped texture images that are at least 16 texels wide.
     * @param height Specifies the height of the texture image. All implementations support 2D texture images that are
     * at least 64 texels high and cube-mapped texture images that are at least 16 texels high.
     * @param type Specifies the data type of the texel data.
     * @param data Specifies a pointer to the image data in memory.
     * 
     * @see OOGLES20Implementation#getMaximum2DTextureSize
     * @see OOGLES20Implementation#getMaximumCubeMapTextureSize
     * @see #setCompressedImage2D
     * @see #setCompressedSubImage2D
     * @see OOGLES20Framebuffer#copyToTextureImage2D
     * @see OOGLES20Framebuffer#copyToTextureSubImage2D
     * @see OOGLES20#setPixelAlignment
     * @see #setSubImage2D
     */
    public void setImage2D(int level, OOTexelFormat format, int width, int height, OOPixelDataType type,
            Buffer data) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        OOGLES20.backEnd.glTexImage2D(this.target.getGLConstant(), level, format.getGLConstant(), width, height, 0,
                format.getGLConstant(), type.getGLConstant(), data);
    }
    
    /**
     * <p>Specify a two-dimensional texture image.</p>
     * 
     * <p>Wrapper for {@link GLUtils#texImage2D}.</p>
     * 
     * @param level Specifies the level-of-detail number. Level {@code 0} is the base image level. Level <i>n</i> is the
     * <i>n</i>th mipmap reduction image.
     * @param bitmap Specifies the bitmap image
     */
    public void setImage2D(int level, Bitmap bitmap) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        GLUtils.texImage2D(this.target.getGLConstant(), level, bitmap, 0);
    }
    
    /**
     * <p>Specify a two-dimensional texture image.</p>
     * 
     * <p>Wrapper for {@link GLUtils#texImage2D}.</p>
     * 
     * @param level Specifies the level-of-detail number. Level {@code 0} is the base image level. Level <i>n</i> is the
     * <i>n</i>th mipmap reduction image.
     * @param format Specifies the internal format of the texture.
     * @param bitmap Specifies the bitmap image
     * @param type Specifies the data type of the pixel data.
     */
    public void setImage2D(int level, OOTexelFormat format, Bitmap bitmap, OOPixelDataType type) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        GLUtils.texImage2D(this.target.getGLConstant(), level, format.getGLConstant(), bitmap,
                type.getGLConstant(), 0);
    }
    
    /**
     * <p>Specify a two-dimensional texture image.</p>
     * 
     * <p>Wrapper for {@link GLUtils#texImage2D}.</p>
     * 
     * @param level Specifies the level-of-detail number. Level {@code 0} is the base image level. Level <i>n</i> is the
     * <i>n</i>th mipmap reduction image.
     * @param format Specifies the internal format of the texture.
     * @param bitmap Specifies the bitmap image
     */
    public void setImage2D(int level, OOTexelFormat format, Bitmap bitmap) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        GLUtils.texImage2D(this.target.getGLConstant(), level, format.getGLConstant(), bitmap, 0);
    }
    
    /**
     * <p>Specify a two-dimensional texture subimage.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glTexSubImage2D}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Texturing maps a portion of a specified texture image onto each graphical primitive for which texturing is
     * active. Texturing is active when the current fragment shader or vertex shader makes use of built-in texture
     * lookup functions.</p>
     * 
     * <p>{@link #setSubImage2D} redefines a contiguous subregion of an existing two-dimensional texture image. The
     * texels referenced by {@code data} replace the portion of the existing texture array with x indices
     * {@code xOffset} and <i>xOffset + width - 1</i>, inclusive and y indices {@code yOffset} and
     * <i>yOffset + height - 1</i>, inclusive. This region may not include any texels outside the range of the texture
     * array as it was originally specified. It is not an error to specify a subtexture with zero width or height, but
     * such a specification has no effect.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Storage parameter {@link OOGLES20#getPixelUnpackAlignment}, set by {@link OOGLES20#setPixelAlignment}, affects
     * the way that data is read out of client memory. See {OOGLES20#setPixelAlignment} for a description.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if target is not GL_TEXTURE_2D, GL_TEXTURE_CUBE_MAP_POSITIVE_X,
     *     GL_TEXTURE_CUBE_MAP_NEGATIVE_X, GL_TEXTURE_CUBE_MAP_POSITIVE_Y, GL_TEXTURE_CUBE_MAP_NEGATIVE_Y,
     *     GL_TEXTURE_CUBE_MAP_POSITIVE_Z or GL_TEXTURE_CUBE_MAP_NEGATIVE_Z. -->
     *     <!-- GL_INVALID_ENUM is generated if format or type is not an accepted value. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code level} is less than {@code 0}.</li>
     *     <li>{@link OOError#INVALID_VALUE} may be generated if {@code level} is greater than
     *     <i>log<sub>2</sub>max</i>, where <i>max</i> is the returned value of {@link
     *     OOGLES20Implementation#getMaximum2DTextureSize}.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if <i>xOffset < 0</i>, <i>xOffset + width > w</i>,
     *     <i>yOffset < 0</i> or <i>yOffset + height > h</i>, where <i>w</i> is the width and <i>h</i> is the height of
     *     the texture image being modified.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code width} or {@code height} is less than {@code 0}.
     *     </li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the texture array has not been defined by a previous
     *     {@link #setImage2D} or {@link OOGLES20Framebuffer#copyToTextureImage2D} operation whose {@code format}
     *     matches the format of {@link #setSubImage2D}.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code type} is {@link
     *     OOPixelDataType#UNSIGNED_SHORT_5_6_5} and {@code format} is not {@link OOTexelFormat#RGB}.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code type} is {@link
     *     OOPixelDataType#UNSIGNED_SHORT_4_4_4_4} or {@link OOPixelDataType#UNSIGNED_SHORT_5_5_5_1} and {@code format}
     *     is not {@link OOTexelFormat#RGBA}.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param level Specifies the level-of-detail number. Level {@code 0} is the base image level. Level <i>n</i> is the
     * <i>n</i>th mipmap reduction image.
     * @param xOffset Specifies a texel offset in the x direction within the texture array.
     * @param yOffset Specifies a texel offset in the y direction within the texture array.
     * @param width Specifies the width of the texture subimage.
     * @param height Specifies the height of the texture subimage.
     * @param format Specifies the internal format of the texture.
     * @param type Specifies the data type of the pixel data.
     * @param data Specifies a pointer to the image data in memory.
     * 
     * @see OOGLES20Implementation#getMaximum2DTextureSize
     * @see OOGLES20Implementation#getMaximumCubeMapTextureSize
     * @see #setCompressedImage2D
     * @see #setCompressedSubImage2D
     * @see OOGLES20Framebuffer#copyToTextureImage2D
     * @see OOGLES20Framebuffer#copyToTextureSubImage2D
     * @see OOGLES20#setPixelAlignment
     * @see #setImage2D
     */
    public void setSubImage2D(int level, int xOffset, int yOffset, int width, int height, OOTexelFormat format,
            OOPixelDataType type, Buffer data) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        OOGLES20.backEnd.glTexSubImage2D(this.target.getGLConstant(), level, xOffset, yOffset, width, height,
                format.getGLConstant(), type.getGLConstant(), data);
    }
    
    /**
     * <p>Specify a two-dimensional texture subimage.</p>
     * 
     * <p>Wrapper for {@link GLUtils#texSubImage2D}.</p>
     * 
     * @param level Specifies the level-of-detail number. Level {@code 0} is the base image level. Level <i>n</i> is the
     * <i>n</i>th mipmap reduction image.
     * @param xOffset Specifies a texel offset in the x direction within the texture array.
     * @param yOffset Specifies a texel offset in the y direction within the texture array.
     * @param bitmap Specifies the bitmap image
     */
    public void setSubImage2D(int level, int xOffset, int yOffset, Bitmap bitmap) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        GLUtils.texSubImage2D(this.target.getGLConstant(), level, xOffset, yOffset, bitmap);
    }
    
    /**
     * <p>Specify a two-dimensional texture subimage.</p>
     * 
     * <p>Wrapper for {@link GLUtils#texSubImage2D}.</p>
     * 
     * @param level Specifies the level-of-detail number. Level {@code 0} is the base image level. Level <i>n</i> is the
     * <i>n</i>th mipmap reduction image.
     * @param xOffset Specifies a texel offset in the x direction within the texture array.
     * @param yOffset Specifies a texel offset in the y direction within the texture array.
     * @param bitmap Specifies the bitmap image
     * @param format Specifies the internal format of the texture.
     * @param type Specifies the data type of the pixel data.
     */
    public void setSubImage2D(int level, int xOffset, int yOffset, Bitmap bitmap, OOTexelFormat format,
            OOPixelDataType type) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        GLUtils.texSubImage2D(this.target.getGLConstant(), level, xOffset, yOffset, bitmap,
                format.getGLConstant(), type.getGLConstant());
    }
    
    /**
     * <p>Specify a two-dimensional texture image in a compressed format.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glCompressedTexImage2D}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Texturing maps a portion of a specified texture image onto each graphical primitive for which texturing is
     * active. Texturing is active when the current fragment shader or vertex shader makes use of built-in texture
     * lookup functions.</p>
     * 
     * <p>{@link #setCompressedImage2D} defines a two-dimensional texture image or cube-map texture image using
     * compressed image data from client memory. The texture image is decoded according to the extension specification
     * defining the specified {@code format}. OpenGL ES defines no specific compressed texture formats, but does provide
     * a mechanism to obtain symbolic constants for such formats provided by extensions. The number of compressed
     * texture formats supported can be obtained by querying the value of {@link
     * OOGLES20Implementation#getCompressedTextureFormatsCount}. The list of specific compressed texture formats
     * supported can be obtained by querying the value of {@link OOGLES20Implementation#getCompressedTextureFormats}.
     * </p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>A GL implementation may choose to store the texture array at any internal resolution it chooses.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if target is not GL_TEXTURE_2D, GL_TEXTURE_CUBE_MAP_POSITIVE_X,
     *     GL_TEXTURE_CUBE_MAP_NEGATIVE_X, GL_TEXTURE_CUBE_MAP_POSITIVE_Y, GL_TEXTURE_CUBE_MAP_NEGATIVE_Y,
     *     GL_TEXTURE_CUBE_MAP_POSITIVE_Z or GL_TEXTURE_CUBE_MAP_NEGATIVE_Z. -->
     *     <li>{@link OOError#INVALID_ENUM} is generated if {@code format} is not a supported format returned in {@link
     *     OOGLES20Implementation#getCompressedTextureFormats}.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code level} is less than {@code 0}.</li>
     *     <li>{@link OOError#INVALID_VALUE} may be generated if {@code level} is greater than
     *     <i>log<sub>2</sub>max</i>, where <i>max</i> is the returned value of {@link
     *     OOGLES20Implementation#getMaximum2DTextureSize} when the target is {@link OOGLES20TextureUnit#tex2D} or
     *     {@link OOGLES20Implementation#getMaximumCubeMapTextureSize} when target is {@link
     *     OOGLES20TextureUnit#texCubeMap}.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code width} or {@code height} is less than {@code 0} or
     *     greater than {@link OOGLES20Implementation#getMaximum2DTextureSize} when the target is {@link
     *     OOGLES20TextureUnit#tex2D} or {@link OOGLES20Implementation#getMaximumCubeMapTextureSize} when target is
     *     {@link OOGLES20TextureUnit#texCubeMap}.</li>
     *     <!-- GL_INVALID_VALUE is generated if border is not 0. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code imageSize} is not consistent with the format,
     *     dimensions and contents of the specified compressed image data.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if parameter combinations are not supported by the
     *     specific compressed internal format as specified in the specific texture compression extension.</li>
     *     <li>Undefined results, including abnormal program termination, are generated if {@code data} is not encoded
     *     in a manner consistent with the extension specification defining the internal compression format.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param level Specifies the level-of-detail number. Level {@code 0} is the base image level. Level <i>n</i> is the
     * <i>n</i>th mipmap reduction image.
     * @param format Specifies the format of the compressed image data stored at address data.
     * @param width Specifies the width of the texture image. All implementations support 2D texture images that are at
     * least 64 texels wide and cube-mapped texture images that are at least 16 texels wide.
     * @param height Specifies the height of the texture image. All implementations support 2D texture images that are
     * at least 64 texels high and cube-mapped texture images that are at least 16 texels high.
     * @param imageSize Specifies the number of unsigned bytes of image data starting at the address specified by data.
     * @param data Specifies a pointer to the compressed image data in memory.
     * 
     * @see OOGLES20Implementation#getCompressedTextureFormatsCount
     * @see OOGLES20Implementation#getCompressedTextureFormats
     * @see OOGLES20Implementation#getMaximum2DTextureSize
     * @see OOGLES20Implementation#getMaximumCubeMapTextureSize
     * @see #setCompressedSubImage2D
     * @see OOGLES20Framebuffer#copyToTextureImage2D
     * @see OOGLES20Framebuffer#copyToTextureSubImage2D
     * @see #setImage2D
     * @see #setSubImage2D
     */
    public void setCompressedImage2D(int level, int format, int width, int height, int imageSize, Buffer data) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        OOGLES20.backEnd.glCompressedTexImage2D(this.target.getGLConstant(), level, format, width, height, 0,
                imageSize, data);
    }
    
    /**
     * <p>Specify a two-dimensional texture subimage in a compressed format.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glCompressedTexSubImage2D}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Texturing maps a portion of a specified texture image onto each graphical primitive for which texturing is
     * active. Texturing is active when the current fragment shader or vertex shader makes use of built-in texture
     * lookup functions.</p>
     * 
     * <p>{@link #setCompressedSubImage2D} redefines a contiguous subregion of an existing two-dimensional texture
     * image. The texels referenced by {@code data} replace the portion of the existing texture array with x indices
     * {@code xOffset} and <i>xOffset + width - 1</i> and the y indices {@code yOffset} and
     * <i>yOffset + height - 1</i>, inclusive. This region may not include any texels outside the range of the texture
     * array as it was originally specified. It is not an error to specify a subtexture with width of {@code 0}, but
     * such a specification has no effect.</p>
     * 
     * <p>{@code format} must be the same extension-specified compressed-texture format previously specified by {@link
     * #setCompressedImage2D}.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if target is not GL_TEXTURE_2D, GL_TEXTURE_CUBE_MAP_POSITIVE_X,
     *     GL_TEXTURE_CUBE_MAP_NEGATIVE_X, GL_TEXTURE_CUBE_MAP_POSITIVE_Y, GL_TEXTURE_CUBE_MAP_NEGATIVE_Y,
     *     GL_TEXTURE_CUBE_MAP_POSITIVE_Z or GL_TEXTURE_CUBE_MAP_NEGATIVE_Z. -->
     *     <li>{@link OOError#INVALID_ENUM} is generated if {@code format} is not a supported format returned in {@link
     *     OOGLES20Implementation#getCompressedTextureFormats}.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code level} is less than {@code 0}.</li>
     *     <li>{@link OOError#INVALID_VALUE} may be generated if {@code level} is greater than
     *     <i>log<sub>2</sub>max</i>, where <i>max</i> is the returned value of {@link
     *     OOGLES20Implementation#getMaximum2DTextureSize} when the target is {@link OOGLES20TextureUnit#tex2D} or
     *     {@link OOGLES20Implementation#getMaximumCubeMapTextureSize} when target is {@link
     *     OOGLES20TextureUnit#texCubeMap}.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if <i>xOffset < 0</i>, <i>(xOffset + width) > w</i>,
     *     <i>yOffset < 0</i> or <i>(yOffset + height) > h</i>, where <i>w</i> is the width and <i>h</i> is the height
     *     of the texture image being modified.</li>
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code width} or {@code height} is less than
     *     {@code 0}.</li>
     *     <!-- GL_INVALID_VALUE is generated if border is not 0. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if {@code imageSize} is not consistent with the format,
     *     dimensions and contents of the specified compressed image data.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the texture array has not been defined by a previous
     *     {@link #setCompressedImage2D} operation whose {@code format} matches the {@code format} of {@link
     *     #setCompressedSubImage2D}.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if parameter combinations are not supported by the
     *     specific compressed internal format as specified in the specific texture compression extension.</li>
     *     <li>Undefined results, including abnormal program termination, are generated if {@code data} is not encoded
     *     in a manner consistent with the extension specification defining the internal compression format.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param level Specifies the level-of-detail number. Level {@code 0} is the base image level. Level <i>n</i> is the
     * <i>n</i>th mipmap reduction image.
     * @param xOffset Specifies a texel offset in the x direction within the texture array.
     * @param yOffset Specifies a texel offset in the y direction within the texture array.
     * @param width Specifies the width of the texture subimage.
     * @param height Specifies the height of the texture subimage.
     * @param format Specifies the format of the compressed image data stored at address {@code data}.
     * @param imageSize Specifies the number of unsigned bytes of image data starting at the address specified by
     * {@code data}.
     * @param data Specifies a pointer to the compressed image data in memory.
     * 
     * @see OOGLES20Implementation#getCompressedTextureFormatsCount
     * @see OOGLES20Implementation#getCompressedTextureFormats
     * @see OOGLES20Implementation#getMaximum2DTextureSize
     * @see OOGLES20Implementation#getMaximumCubeMapTextureSize
     * @see #setCompressedImage2D
     * @see OOGLES20Framebuffer#copyToTextureImage2D
     * @see OOGLES20Framebuffer#copyToTextureSubImage2D
     * @see #setImage2D
     * @see #setSubImage2D
     */
    public void setCompressedSubImage2D(int level, int xOffset, int yOffset, int width, int height, int format,
            int imageSize, Buffer data) {
        OOGLES20.backEnd.glActiveTexture(OpenGLES20.GL_TEXTURE0 + this.textureUnit);
        OOGLES20.backEnd.glCompressedTexSubImage2D(this.target.getGLConstant(), level, xOffset, yOffset, width, height,
                format, imageSize, data);
    }
}
