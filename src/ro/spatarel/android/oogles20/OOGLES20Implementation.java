package ro.spatarel.android.oogles20;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * <p>Class grouping together the methods that allow the querying of the implementation-specific parameters.</p>
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
public class OOGLES20Implementation {
    
    OOGLES20Implementation() {
        // There is nothing here.
    }
    
    private static ByteBuffer byteBuffer = OOGLES20.createByteBuffer(4);
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(2);
    private static FloatBuffer floatBuffer = OOGLES20.createFloatBuffer(2);
    
    /**
     * <p>Returns the company responsible for this GL implementation.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetString} with argument {@link OpenGLES20#GL_VENDOR}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the company responsible for this GL implementation. This name does not change from release to release.
     * </p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The company responsible for this GL implementation.
     */
    public String getVendor() {
        return OOGLES20.backEnd.glGetString(OpenGLES20.GL_VENDOR);
    }
    
    /**
     * <p>Returns the name of the renderer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetString} with argument {@link OpenGLES20#GL_RENDERER}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the name of the renderer. This name is typically specific to a particular configuration of a hardware
     * platform. It does not change from release to release.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The name of the renderer.
     */
    public String getRenderer() {
        return OOGLES20.backEnd.glGetString(OpenGLES20.GL_RENDERER);
    }
    
    /**
     * <p>Returns a version or release number of the form
     * {@code OpenGL<space>ES<space><version number><space><vendor-specific information>}.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetString} with argument {@link OpenGLES20#GL_VERSION}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a version or release number of the form
     * {@code OpenGL<space>ES<space><version number><space><vendor-specific information>}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A version or release number of the form
     * {@code OpenGL<space>ES<space><version number><space><vendor-specific information>}.
     */
    public String getVersion() {
        return OOGLES20.backEnd.glGetString(OpenGLES20.GL_VERSION);
    }
    
    /**
     * <p>Returns a version or release number for the shading language of the form
     * {@code OpenGL<space>ES<space>GLSL<space>ES<space><version number><space><vendor-specific information>}.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetString} with argument {@link OpenGLES20#GL_SHADING_LANGUAGE_VERSION}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a version or release number for the shading language of the form
     * {@code OpenGL<space>ES<space>GLSL<space>ES<space><version number><space><vendor-specific information>}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A version or release number for the shading language of the form
     * {@code OpenGL<space>ES<space>GLSL<space>ES<space><version number><space><vendor-specific information>}.
     */
    public String getShadingLanguageVersion() {
        return OOGLES20.backEnd.glGetString(OpenGLES20.GL_SHADING_LANGUAGE_VERSION);
    }
    
    /**
     * <p>Returns a space-separated list of supported extensions to GL.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetString} with argument {@link OpenGLES20#GL_EXTENSIONS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a space-separated list of supported extensions to GL.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A space-separated list of supported extensions to GL.
     */
    public String getExtensions() {
        return OOGLES20.backEnd.glGetString(OpenGLES20.GL_EXTENSIONS);
    }
    
    /**
     * <p>Returns a value that gives a rough estimate of the largest texture that the GL can handle.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_MAX_TEXTURE_SIZE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a value that gives a rough estimate of the largest texture that the GL can handle. The value must be
     * at least 64.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A value that gives a rough estimate of the largest texture that the GL can handle.
     * 
     * @see OOGLES20TextureImage#setImage2D
     */
    public int getMaximum2DTextureSize() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_MAX_TEXTURE_SIZE, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns a value that gives a rough estimate of the largest cube-map texture that the GL can handle.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_MAX_CUBE_MAP_TEXTURE_SIZE}.
     * </p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a value that gives a rough estimate of the largest cube-map texture that the GL can handle. The value
     * must be at least 16.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A value that gives a rough estimate of the largest cube-map texture that the GL can handle. The value
     * must be at least 16.
     * 
     * @see OOGLES20TextureImage#setImage2D
     */
    public int getMaximumCubeMapTextureSize() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_MAX_CUBE_MAP_TEXTURE_SIZE, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns a value indicating the number of available compressed texture formats.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link
     * OpenGLES20#GL_NUM_COMPRESSED_TEXTURE_FORMATS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a value indicating the number of available compressed texture formats. The minimum value is 0.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A value indicating the number of available compressed texture formats.
     * 
     * @see OOGLES20TextureImage#setCompressedImage2D
     */
    public int getCompressedTextureFormatsCount() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_NUM_COMPRESSED_TEXTURE_FORMATS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns a list of symbolic constants of length {@link #getCompressedTextureFormatsCount} indicating which
     * compressed texture formats are available.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_COMPRESSED_TEXTURE_FORMATS}.
     * </p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a list of symbolic constants of length {@link #getCompressedTextureFormatsCount} indicating which
     * compressed texture formats are available.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A list of symbolic constants of length {@link #getCompressedTextureFormatsCount} indicating which
     * compressed texture formats are available.
     * 
     * @see OOGLES20TextureImage#setCompressedImage2D
     */
    public int[] getCompressedTextureFormats() {
        IntBuffer intBuffer = OOGLES20.createIntBuffer(this.getCompressedTextureFormatsCount());
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_COMPRESSED_TEXTURE_FORMATS, intBuffer);
        return OOGLES20.extract(intBuffer);
    }
    
    /**
     * <p>Returns the maximum number of four-element floating-point, integer or boolean vectors that can be held in
     * uniform variable storage for a vertex shader.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_MAX_VERTEX_UNIFORM_VECTORS}.
     * </p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the maximum number of four-element floating-point, integer or boolean vectors that can be held in
     * uniform variable storage for a vertex shader. The value must be at least 128.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A space-separated list of supported extensions to GL.
     * 
     * @see OOUniform#set1f
     * @see OOUniform#set2f
     * @see OOUniform#set3f
     * @see OOUniform#set4f
     * @see OOUniform#setMatrix2fv
     * @see OOUniform#setMatrix3fv
     * @see OOUniform#setMatrix4fv
     */
    public int getMaximumVertexUniformVectors() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_MAX_VERTEX_UNIFORM_VECTORS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the maximum number of four-element floating-point, integer or boolean vectors that can be held in
     * uniform variable storage for a fragment shader.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_MAX_FRAGMENT_UNIFORM_VECTORS}.
     * </p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the maximum number of four-element floating-point, integer or boolean vectors that can be held in
     * uniform variable storage for a fragment shader. The value must be at least 16.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The maximum number of four-element floating-point, integer or boolean vectors that can be held in
     * uniform variable storage for a fragment shader.
     * 
     * @see OOUniform#set1f
     * @see OOUniform#set2f
     * @see OOUniform#set3f
     * @see OOUniform#set4f
     * @see OOUniform#setMatrix2fv
     * @see OOUniform#setMatrix3fv
     * @see OOUniform#setMatrix4fv
     */
    public int getMaximumFragmentUniformVectors() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_MAX_FRAGMENT_UNIFORM_VECTORS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the maximum number of 4-component generic vertex attributes accessible to a vertex shader.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_MAX_VERTEX_ATTRIBS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the maximum number of 4-component generic vertex attributes accessible to a vertex shader. The value
     * must be at least 8.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A space-separated list of supported extensions to GL.
     * 
     * @see OOAttribute#setForAll1f
     * @see OOAttribute#setForAll2f
     * @see OOAttribute#setForAll3f
     * @see OOAttribute#setForAll4f
     */
    public int getMaximumAttributeVectors() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_MAX_VERTEX_ATTRIBS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the maximum number four-element floating-point vectors available for interpolating varying variables
     * used by vertex and fragment shaders.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_MAX_VARYING_VECTORS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the maximum number four-element floating-point vectors available for interpolating varying variables
     * used by vertex and fragment shaders. Varying variables declared as matrices or arrays will consume multiple
     * interpolators. The value must be at least 8.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The maximum number four-element floating-point vectors available for interpolating varying variables used
     * by vertex and fragment shaders.
     */
    public int getMaximumVaryingVectors() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_MAX_VARYING_VECTORS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the maximum supported texture image units that can be used to access texture maps from the vertex
     * shader and the fragment processor combined.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link
     * OpenGLES20#GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the maximum supported texture image units that can be used to access texture maps from the vertex
     * shader and the fragment processor combined. If both the vertex shader and the fragment processing stage access
     * the same texture image unit, then that counts as using two texture image units against this limit. The value must
     * be at least 8.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The maximum supported texture image units that can be used to access texture maps from the vertex shader
     * and the fragment processor combined.
     * 
     * @see OOGLES20#textureUnit
     */
    public int getMaximumTextureUnits() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS,
                OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the maximum supported texture image units that can be used to access texture maps from the vertex
     * shader.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link
     * OpenGLES20#GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the maximum supported texture image units that can be used to access texture maps from the vertex
     * shader. The value may be 0.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The maximum supported texture image units that can be used to access texture maps from the vertex shader.
     * 
     * @see OOGLES20#textureUnit
     */
    public int getMaximumVertexTextureUnits() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the maximum supported texture image units that can be used to access texture maps from the fragment
     * shader.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_MAX_TEXTURE_IMAGE_UNITS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the maximum supported texture image units that can be used to access texture maps from the fragment
     * shader. The value must be at least 8.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The maximum supported texture image units that can be used to access texture maps from the fragment
     * shader.
     * 
     * @see OOGLES20#textureUnit
     */
    public int getMaximumFragmentTextureUnits() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_MAX_TEXTURE_IMAGE_UNITS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns a value indicating whether a shader compiler is supported.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetBooleanv} with argument {@link OpenGLES20#GL_SHADER_COMPILER}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a value indicating whether a shader compiler is supported. {@code false} indicates that any call to
     * {@link OOShader#setSource}, {@link OOShader#compile} or {@link OOGLES20#releaseCompiler} will result in a {@link
     * OOError#INVALID_OPERATION} error being generated.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A value indicating whether a shader compiler is supported.
     * 
     * @see OOShader#setBinary
     */
    public boolean isShaderCompilerSupported() {
        OOGLES20.backEnd.glGetBooleanv(OpenGLES20.GL_SHADER_COMPILER, OOGLES20Implementation.byteBuffer.asIntBuffer());
        return OOGLES20Implementation.byteBuffer.get(0) != 0;
    }
    
    /**
     * <p>Returns a single integer value indicating the number of available shader binary formats.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_NUM_SHADER_BINARY_FORMATS}.
     * </p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a single integer value indicating the number of available shader binary formats. The minimum value is
     * {@code 0}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A single integer value indicating the number of available shader binary formats.
     * 
     * @see OOShader#setBinary
     */
    public int getShaderBinaryFormatsCount() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_NUM_SHADER_BINARY_FORMATS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns a list of symbolic constants of length {@link #getShaderBinaryFormatsCount} indicating which shader
     * binary formats are available.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_SHADER_BINARY_FORMATS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a list of symbolic constants of length {@link #getShaderBinaryFormatsCount} indicating which shader
     * binary formats are available.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A list of symbolic constants of length {@link #getShaderBinaryFormatsCount} indicating which shader
     * binary formats are available.
     * 
     * @see OOShader#setBinary
     */
    public int[] getShaderBinaryFormats() {
        IntBuffer intBuffer = OOGLES20.createIntBuffer(this.getShaderBinaryFormatsCount());
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_SHADER_BINARY_FORMATS, intBuffer);
        return OOGLES20.extract(intBuffer);
    }
    
    /**
     * <p>Returns the type chosen by the implementation with which pixels may be read from the color buffer of the
     * currently bound framebuffer in conjunction with {@link #getPreferredPixelFormat}.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link
     * OpenGLES20#GL_IMPLEMENTATION_COLOR_READ_TYPE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the type chosen by the implementation with which pixels may be read from the color buffer of the
     * currently bound framebuffer in conjunction with {@link #getPreferredPixelFormat}. In addition to this
     * implementation-dependent format/type pair, format {@link OOPixelFormat#RGBA} in conjunction with type {@link
     * OOPixelDataType#UNSIGNED_BYTE} is always allowed by every implementation, regardless of the currently bound
     * render surface.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The type chosen by the implementation with which pixels may be read from the color buffer of the
     * currently bound framebuffer in conjunction with {@link #getPreferredPixelFormat}.
     * 
     * @see OOGLES20Framebuffer#readPixels
     */
    public int getPreferredPixelDataType() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_IMPLEMENTATION_COLOR_READ_TYPE, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the format chosen by the implementation in which pixels may be read from the color buffer of the
     * currently bound framebuffer in conjunction with {@link #getPreferredPixelDataType}.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link
     * OpenGLES20#GL_IMPLEMENTATION_COLOR_READ_FORMAT}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the format chosen by the implementation in which pixels may be read from the color buffer of the
     * currently bound framebuffer in conjunction with {@link #getPreferredPixelDataType}. In addition to this
     * implementation-dependent format/type pair, format {@link OOPixelFormat#RGBA} in conjunction with type {@link
     * OOPixelDataType#UNSIGNED_BYTE} is always allowed by every implementation, regardless of the currently bound
     * render surface.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The format chosen by the implementation in which pixels may be read from the color buffer of the
     * currently bound framebuffer in conjunction with {@link #getPreferredPixelDataType}.
     * 
     * @see OOGLES20Framebuffer#readPixels
     */
    public int getPreferredPixelFormat() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_IMPLEMENTATION_COLOR_READ_FORMAT,
                OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns a value that indicates the largest renderbuffer width and height that the GL can handle.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_MAX_RENDERBUFFER_SIZE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a value that indicates the largest renderbuffer width and height that the GL can handle. The value
     * must be at least 1.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A value that indicates the largest renderbuffer width and height that the GL can handle.
     * 
     * @see OOGLES20Renderbuffer#setStorage
     */
    public int getMaximumRenderbufferSize() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_MAX_RENDERBUFFER_SIZE, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the number of red bitplanes in the color buffer of the currently bound framebuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_RED_BITS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the number of red bitplanes in the color buffer of the currently bound framebuffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The number of red bitplanes in the color buffer of the currently bound framebuffer.
     */
    public int getColorRedBits() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_RED_BITS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the number of green bitplanes in the color buffer of the currently bound framebuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_GREEN_BITS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the number of green bitplanes in the color buffer of the currently bound framebuffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The number of green bitplanes in the color buffer of the currently bound framebuffer.
     */
    public int getColorGreenBits() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_GREEN_BITS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the number of blue bitplanes in the color buffer of the currently bound framebuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_BLUE_BITS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the number of blue bitplanes in the color buffer of the currently bound framebuffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The number of blue bitplanes in the color buffer of the currently bound framebuffer.
     */
    public int getColorBlueBits() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_BLUE_BITS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the number of alpha bitplanes in the color buffer of the currently bound framebuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_ALPHA_BITS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the number of alpha bitplanes in the color buffer of the currently bound framebuffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The number of alpha bitplanes in the color buffer of the currently bound framebuffer.
     */
    public int getColorAlphaBits() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_ALPHA_BITS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the number of bitplanes in the depth buffer of the currently bound framebuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_DEPTH_BITS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the number of bitplanes in the depth buffer of the currently bound framebuffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The number of bitplanes in the depth buffer of the currently bound framebuffer.
     */
    public int getDepthBits() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_DEPTH_BITS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the number of bitplanes in the stencil buffer of the currently bound framebuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_STENCIL_BITS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the number of bitplanes in the stencil buffer of the currently bound framebuffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The number of bitplanes in the stencil buffer of the currently bound framebuffer.
     */
    public int getStencilBits() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_STENCIL_BITS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the maximum supported width and height of the viewport.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_MAX_VIEWPORT_DIMS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the maximum supported width and height of the viewport. These must be at least as large as the visible
     * dimensions of the display being rendered to.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The maximum supported width and height of the viewport.
     * 
     * @see OOGLES20PrimitiveProcessing#setViewport
     */
    public OORectangle getMaximumViewportDimensions() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_MAX_VIEWPORT_DIMS, OOGLES20Implementation.intBuffer);
        return new OORectangle(
                OOGLES20Implementation.intBuffer.get(0),
                OOGLES20Implementation.intBuffer.get(1));
    }
    
    /**
     * <p>Returns a value indicating the number of sample buffers associated with the currently bound framebuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_SAMPLE_BUFFERS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a value indicating the number of sample buffers associated with the currently bound framebuffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A value indicating the number of sample buffers associated with the currently bound framebuffer.
     * 
     * @see OOGLES20FragmentProcessing#setSampleCoverage
     */
    public int getMultisampleBuffersCount() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_SAMPLE_BUFFERS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns a value indicating the coverage mask size of the currently bound framebuffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_SAMPLES}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a value indicating the coverage mask size of the currently bound framebuffer.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A value indicating the coverage mask size of the currently bound framebuffer.
     * 
     * @see OOGLES20FragmentProcessing#setSampleCoverage
     */
    public int getMultisampleCoverageMaskSize() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_SAMPLES, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns an estimate of the number of bits of subpixel resolution that are used to position rasterized geometry
     * in window coordinates.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_SUBPIXEL_BITS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an estimate of the number of bits of subpixel resolution that are used to position rasterized geometry
     * in window coordinates. The value must be at least {@code 4}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return An estimate of the number of bits of subpixel resolution that are used to position rasterized geometry
     * in window coordinates.
     */
    public int getSubpixelBits() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_SUBPIXEL_BITS, OOGLES20Implementation.intBuffer);
        return OOGLES20Implementation.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the smallest and largest supported sizes for aliased points.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_ALIASED_POINT_SIZE_RANGE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the smallest and largest supported sizes for aliased points. The range must include size 1.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The smallest and largest supported sizes for aliased points.
     */
    public OORange getAliasedPointSizesRange() {
        OOGLES20.backEnd.glGetFloatv(OpenGLES20.GL_ALIASED_POINT_SIZE_RANGE, OOGLES20Implementation.floatBuffer);
        return new OORange(
                OOGLES20Implementation.floatBuffer.get(0),
                OOGLES20Implementation.floatBuffer.get(1));
    }
    
    /**
     * <p>Returns the smallest and largest supported widths for aliased lines.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_ALIASED_LINE_WIDTH_RANGE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the smallest and largest supported widths for aliased lines. The range must include width 1.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The smallest and largest supported widths for aliased lines.
     */
    public OORange getAliasedLineWidthsRange() {
        OOGLES20.backEnd.glGetFloatv(OpenGLES20.GL_ALIASED_LINE_WIDTH_RANGE, OOGLES20Implementation.floatBuffer);
        return new OORange(
                OOGLES20Implementation.floatBuffer.get(0),
                OOGLES20Implementation.floatBuffer.get(1));
    }
    
    private static IntBuffer range = OOGLES20.createIntBuffer(2);
    private static IntBuffer precision = OOGLES20.createIntBuffer(1);
    
    /**
     * <p>Return the range and precision for different shader numeric formats.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetShaderPrecisionFormat}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #getPrecisionFormat} returns range and precision limits for floating-point and integer shader variable
     * formats with low, medium and high precision qualifiers. When <i>minRep</i> and <i>maxRep</i> are the minimum and
     * maximum representable values of the format, <i>floor(log<sub>2</sub>(|minRep|))</i> and
     * <i>floor(log<sub>2</sub>(|maxRep|))</i> are returned in {@code rangeMinimum} and {@code rangeMaximum},
     * respectively.</p>
     * 
     * <p>If the smallest representable value greater than <i>1</i> is <i>1 + &epsilon;</i> then
     * <i>floor(-log<sub>2</sub>(&epsilon;)</i> is returned in {@code precision}. An integer format will have an
     * &epsilon; of {@code 1} and thus will return {@code 0}. Floating-point formats will return values greater than
     * {@code 0}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>The minimum range and precision required for different formats is described in the <i>OpenGL ES Shading
     * Language Specification</i>.</p>
     * 
     * <p>If a high precision floating-point format is not supported for fragment shaders, calling {@link
     * #getPrecisionFormat} with arguments {@link OOShaderType#FRAGMENT} and {@link OOShaderPrecisionType#HIGH_FLOAT}
     * will return {@code 0} for {@code rangeMinimum}, {@code rangeMaximum} and {@code precision}. Support for a high
     * precision floating-point format is mandatory for vertex shaders.</p>
     * 
     * <p>Shader compiler support is optional and thus must be queried before use by calling {@link
     * #isShaderCompilerSupported}. {@link OOShader#setSource}, {@link OOShader#compile}, {@link #getPrecisionFormat}
     * and {@link OOGLES20#releaseCompiler} will each generate {@link OOError#INVALID_OPERATION} on implementations
     * that do not support a shader compiler. Such implementations instead offer the {@link OOShader#setBinary}
     * alternative for supplying a pre-compiled shader binary.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@code OOError#INVALID_OPERATION} is generated if a shader compiler is not supported.</li>
     *     <!-- GL_INVALID_ENUM is generated if shaderType or precisionType is not an accepted value. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param shaderType Specifies the type of shader to query.
     * @param precisionType Specifies the numeric format to query, corresponding to a shader precision qualifier and
     * variable type.
     * @return The <i>log<sub>2</sub></i> of the minimum and maximum representable magnitudes of the format and the
     * <i>log<sub>2</sub></i> of the precision of the format.
     * 
     * @see #isShaderCompilerSupported
     * @see OOShader#compile
     * @see OOShader#setSource
     */
    public OOPrecisionFormat getPrecisionFormat(OOShaderType shaderType, OOShaderPrecisionType precisionType) {
        OOGLES20.backEnd.glGetShaderPrecisionFormat(shaderType.getGLConstant(), precisionType.getGLConstant(),
                OOGLES20Implementation.range, OOGLES20Implementation.precision);
        return new OOPrecisionFormat(
                OOGLES20Implementation.range.get(0),
                OOGLES20Implementation.range.get(1),
                OOGLES20Implementation.precision.get(0));
    }
}
