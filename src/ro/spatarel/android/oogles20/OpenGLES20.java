package ro.spatarel.android.oogles20;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * <p>Interface modeling the back end required by the library.</p>
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
public interface OpenGLES20 {
    
    /**
     * Symbolic constant GL_ACTIVE_TEXTURE
     */
    public final int GL_ACTIVE_TEXTURE                               = 0x84E0;
    
    /**
     * Symbolic constant GL_DEPTH_BUFFER_BIT
     */
    public final int GL_DEPTH_BUFFER_BIT                             = 0x00000100;
    
    /**
     * Symbolic constant GL_STENCIL_BUFFER_BIT
     */
    public final int GL_STENCIL_BUFFER_BIT                           = 0x00000400;
    
    /**
     * Symbolic constant GL_COLOR_BUFFER_BIT
     */
    public final int GL_COLOR_BUFFER_BIT                             = 0x00004000;
    
    /**
     * Symbolic constant GL_FALSE
     */
    public final int GL_FALSE                                        = 0;
    
    /**
     * Symbolic constant GL_TRUE
     */
    public final int GL_TRUE                                         = 1;
    
    /**
     * Symbolic constant GL_POINTS
     */
    public final int GL_POINTS                                       = 0x0000;
    
    /**
     * Symbolic constant GL_LINES
     */
    public final int GL_LINES                                        = 0x0001;
    
    /**
     * Symbolic constant GL_LINE_LOOP
     */
    public final int GL_LINE_LOOP                                    = 0x0002;
    
    /**
     * Symbolic constant GL_LINE_STRIP
     */
    public final int GL_LINE_STRIP                                   = 0x0003;
    
    /**
     * Symbolic constant GL_TRIANGLES
     */
    public final int GL_TRIANGLES                                    = 0x0004;
    
    /**
     * Symbolic constant GL_TRIANGLE_STRIP
     */
    public final int GL_TRIANGLE_STRIP                               = 0x0005;
    
    /**
     * Symbolic constant GL_TRIANGLE_FAN
     */
    public final int GL_TRIANGLE_FAN                                 = 0x0006;
    
    /**
     * Symbolic constant GL_ZERO
     */
    public final int GL_ZERO                                         = 0;
    
    /**
     * Symbolic constant GL_ONE
     */
    public final int GL_ONE                                          = 1;
    
    /**
     * Symbolic constant GL_SRC_COLOR
     */
    public final int GL_SRC_COLOR                                    = 0x0300;
    
    /**
     * Symbolic constant GL_ONE_MINUS_SRC_COLOR
     */
    public final int GL_ONE_MINUS_SRC_COLOR                          = 0x0301;
    
    /**
     * Symbolic constant GL_SRC_ALPHA
     */
    public final int GL_SRC_ALPHA                                    = 0x0302;
    
    /**
     * Symbolic constant GL_ONE_MINUS_SRC_ALPHA
     */
    public final int GL_ONE_MINUS_SRC_ALPHA                          = 0x0303;
    
    /**
     * Symbolic constant GL_DST_ALPHA
     */
    public final int GL_DST_ALPHA                                    = 0x0304;
    
    /**
     * Symbolic constant GL_ONE_MINUS_DST_ALPHA
     */
    public final int GL_ONE_MINUS_DST_ALPHA                          = 0x0305;
    
    /**
     * Symbolic constant GL_DST_COLOR
     */
    public final int GL_DST_COLOR                                    = 0x0306;
    
    /**
     * Symbolic constant GL_ONE_MINUS_DST_COLOR
     */
    public final int GL_ONE_MINUS_DST_COLOR                          = 0x0307;
    
    /**
     * Symbolic constant GL_SRC_ALPHA_SATURATE
     */
    public final int GL_SRC_ALPHA_SATURATE                           = 0x0308;
    
    /**
     * Symbolic constant GL_FUNC_ADD
     */
    public final int GL_FUNC_ADD                                     = 0x8006;
    
    /**
     * Symbolic constant GL_BLEND_EQUATION
     */
    public final int GL_BLEND_EQUATION                               = 0x8009;
    
    /**
     * Symbolic constant GL_BLEND_EQUATION_RGB
     */
    public final int GL_BLEND_EQUATION_RGB                           = 0x8009;
    
    /**
     * Symbolic constant GL_BLEND_EQUATION_ALPHA
     */
    public final int GL_BLEND_EQUATION_ALPHA                         = 0x883D;
    
    /**
     * Symbolic constant GL_FUNC_SUBTRACT
     */
    public final int GL_FUNC_SUBTRACT                                = 0x800A;
    
    /**
     * Symbolic constant GL_FUNC_REVERSE_SUBTRACT
     */
    public final int GL_FUNC_REVERSE_SUBTRACT                        = 0x800B;
    
    /**
     * Symbolic constant GL_BLEND_DST_RGB
     */
    public final int GL_BLEND_DST_RGB                                = 0x80C8;
    
    /**
     * Symbolic constant GL_BLEND_SRC_RGB
     */
    public final int GL_BLEND_SRC_RGB                                = 0x80C9;
    
    /**
     * Symbolic constant GL_BLEND_DST_ALPHA
     */
    public final int GL_BLEND_DST_ALPHA                              = 0x80CA;
    
    /**
     * Symbolic constant GL_BLEND_SRC_ALPHA
     */
    public final int GL_BLEND_SRC_ALPHA                              = 0x80CB;
    
    /**
     * Symbolic constant GL_CONSTANT_COLOR
     */
    public final int GL_CONSTANT_COLOR                               = 0x8001;
    
    /**
     * Symbolic constant GL_ONE_MINUS_CONSTANT_COLOR
     */
    public final int GL_ONE_MINUS_CONSTANT_COLOR                     = 0x8002;
    
    /**
     * Symbolic constant GL_CONSTANT_ALPHA
     */
    public final int GL_CONSTANT_ALPHA                               = 0x8003;
    
    /**
     * Symbolic constant GL_ONE_MINUS_CONSTANT_ALPHA
     */
    public final int GL_ONE_MINUS_CONSTANT_ALPHA                     = 0x8004;
    
    /**
     * Symbolic constant GL_BLEND_COLOR
     */
    public final int GL_BLEND_COLOR                                  = 0x8005;
    
    /**
     * Symbolic constant GL_ARRAY_BUFFER
     */
    public final int GL_ARRAY_BUFFER                                 = 0x8892;
    
    /**
     * Symbolic constant GL_ELEMENT_ARRAY_BUFFER
     */
    public final int GL_ELEMENT_ARRAY_BUFFER                         = 0x8893;
    
    /**
     * Symbolic constant GL_ARRAY_BUFFER_BINDING
     */
    public final int GL_ARRAY_BUFFER_BINDING                         = 0x8894;
    
    /**
     * Symbolic constant GL_ELEMENT_ARRAY_BUFFER_BINDING
     */
    public final int GL_ELEMENT_ARRAY_BUFFER_BINDING                 = 0x8895;
    
    /**
     * Symbolic constant GL_STREAM_DRAW
     */
    public final int GL_STREAM_DRAW                                  = 0x88E0;
    
    /**
     * Symbolic constant GL_STATIC_DRAW
     */
    public final int GL_STATIC_DRAW                                  = 0x88E4;
    
    /**
     * Symbolic constant GL_DYNAMIC_DRAW
     */
    public final int GL_DYNAMIC_DRAW                                 = 0x88E8;
    
    /**
     * Symbolic constant GL_BUFFER_SIZE
     */
    public final int GL_BUFFER_SIZE                                  = 0x8764;
    
    /**
     * Symbolic constant GL_BUFFER_USAGE
     */
    public final int GL_BUFFER_USAGE                                 = 0x8765;
    
    /**
     * Symbolic constant GL_CURRENT_VERTEX_ATTRIB
     */
    public final int GL_CURRENT_VERTEX_ATTRIB                        = 0x8626;
    
    /**
     * Symbolic constant GL_FRONT
     */
    public final int GL_FRONT                                        = 0x0404;
    
    /**
     * Symbolic constant GL_BACK
     */
    public final int GL_BACK                                         = 0x0405;
    
    /**
     * Symbolic constant GL_FRONT_AND_BACK
     */
    public final int GL_FRONT_AND_BACK                               = 0x0408;
    
    /**
     * Symbolic constant GL_TEXTURE_2D
     */
    public final int GL_TEXTURE_2D                                   = 0x0DE1;
    
    /**
     * Symbolic constant GL_CULL_FACE
     */
    public final int GL_CULL_FACE                                    = 0x0B44;
    
    /**
     * Symbolic constant GL_BLEND
     */
    public final int GL_BLEND                                        = 0x0BE2;
    
    /**
     * Symbolic constant GL_DITHER
     */
    public final int GL_DITHER                                       = 0x0BD0;
    
    /**
     * Symbolic constant GL_STENCIL_TEST
     */
    public final int GL_STENCIL_TEST                                 = 0x0B90;
    
    /**
     * Symbolic constant GL_DEPTH_TEST
     */
    public final int GL_DEPTH_TEST                                   = 0x0B71;
    
    /**
     * Symbolic constant GL_SCISSOR_TEST
     */
    public final int GL_SCISSOR_TEST                                 = 0x0C11;
    
    /**
     * Symbolic constant GL_POLYGON_OFFSET_FILL
     */
    public final int GL_POLYGON_OFFSET_FILL                          = 0x8037;
    
    /**
     * Symbolic constant GL_SAMPLE_ALPHA_TO_COVERAGE
     */
    public final int GL_SAMPLE_ALPHA_TO_COVERAGE                     = 0x809E;
    
    /**
     * Symbolic constant GL_SAMPLE_COVERAGE
     */
    public final int GL_SAMPLE_COVERAGE                              = 0x80A0;
    
    /**
     * Symbolic constant GL_NO_ERROR
     */
    public final int GL_NO_ERROR                                     = 0;
    
    /**
     * Symbolic constant GL_INVALID_ENUM
     */
    public final int GL_INVALID_ENUM                                 = 0x0500;
    
    /**
     * Symbolic constant GL_INVALID_VALUE
     */
    public final int GL_INVALID_VALUE                                = 0x0501;
    
    /**
     * Symbolic constant GL_INVALID_OPERATION
     */
    public final int GL_INVALID_OPERATION                            = 0x0502;
    
    /**
     * Symbolic constant GL_OUT_OF_MEMORY
     */
    public final int GL_OUT_OF_MEMORY                                = 0x0505;
    
    /**
     * Symbolic constant GL_CW
     */
    public final int GL_CW                                           = 0x0900;
    
    /**
     * Symbolic constant GL_CCW
     */
    public final int GL_CCW                                          = 0x0901;
    
    /**
     * Symbolic constant GL_LINE_WIDTH
     */
    public final int GL_LINE_WIDTH                                   = 0x0B21;
    
    /**
     * Symbolic constant GL_ALIASED_POINT_SIZE_RANGE
     */
    public final int GL_ALIASED_POINT_SIZE_RANGE                     = 0x846D;
    
    /**
     * Symbolic constant GL_ALIASED_LINE_WIDTH_RANGE
     */
    public final int GL_ALIASED_LINE_WIDTH_RANGE                     = 0x846E;
    
    /**
     * Symbolic constant GL_CULL_FACE_MODE
     */
    public final int GL_CULL_FACE_MODE                               = 0x0B45;
    
    /**
     * Symbolic constant GL_FRONT_FACE
     */
    public final int GL_FRONT_FACE                                   = 0x0B46;
    
    /**
     * Symbolic constant GL_DEPTH_RANGE
     */
    public final int GL_DEPTH_RANGE                                  = 0x0B70;
    
    /**
     * Symbolic constant GL_DEPTH_WRITEMASK
     */
    public final int GL_DEPTH_WRITEMASK                              = 0x0B72;
    
    /**
     * Symbolic constant GL_DEPTH_CLEAR_VALUE
     */
    public final int GL_DEPTH_CLEAR_VALUE                            = 0x0B73;
    
    /**
     * Symbolic constant GL_DEPTH_FUNC
     */
    public final int GL_DEPTH_FUNC                                   = 0x0B74;
    
    /**
     * Symbolic constant GL_STENCIL_CLEAR_VALUE
     */
    public final int GL_STENCIL_CLEAR_VALUE                          = 0x0B91;
    
    /**
     * Symbolic constant GL_STENCIL_FUNC
     */
    public final int GL_STENCIL_FUNC                                 = 0x0B92;
    
    /**
     * Symbolic constant GL_STENCIL_FAIL
     */
    public final int GL_STENCIL_FAIL                                 = 0x0B94;
    
    /**
     * Symbolic constant GL_STENCIL_PASS_DEPTH_FAIL
     */
    public final int GL_STENCIL_PASS_DEPTH_FAIL                      = 0x0B95;
    
    /**
     * Symbolic constant GL_STENCIL_PASS_DEPTH_PASS
     */
    public final int GL_STENCIL_PASS_DEPTH_PASS                      = 0x0B96;
    
    /**
     * Symbolic constant GL_STENCIL_REF
     */
    public final int GL_STENCIL_REF                                  = 0x0B97;
    
    /**
     * Symbolic constant GL_STENCIL_VALUE_MASK
     */
    public final int GL_STENCIL_VALUE_MASK                           = 0x0B93;
    
    /**
     * Symbolic constant GL_STENCIL_WRITEMASK
     */
    public final int GL_STENCIL_WRITEMASK                            = 0x0B98;
    
    /**
     * Symbolic constant GL_STENCIL_BACK_FUNC
     */
    public final int GL_STENCIL_BACK_FUNC                            = 0x8800;
    
    /**
     * Symbolic constant GL_STENCIL_BACK_FAIL
     */
    public final int GL_STENCIL_BACK_FAIL                            = 0x8801;
    
    /**
     * Symbolic constant GL_STENCIL_BACK_PASS_DEPTH_FAIL
     */
    public final int GL_STENCIL_BACK_PASS_DEPTH_FAIL                 = 0x8802;
    
    /**
     * Symbolic constant GL_STENCIL_BACK_PASS_DEPTH_PASS
     */
    public final int GL_STENCIL_BACK_PASS_DEPTH_PASS                 = 0x8803;
    
    /**
     * Symbolic constant GL_STENCIL_BACK_REF
     */
    public final int GL_STENCIL_BACK_REF                             = 0x8CA3;
    
    /**
     * Symbolic constant GL_STENCIL_BACK_VALUE_MASK
     */
    public final int GL_STENCIL_BACK_VALUE_MASK                      = 0x8CA4;
    
    /**
     * Symbolic constant GL_STENCIL_BACK_WRITEMASK
     */
    public final int GL_STENCIL_BACK_WRITEMASK                       = 0x8CA5;
    
    /**
     * Symbolic constant GL_VIEWPORT
     */
    public final int GL_VIEWPORT                                     = 0x0BA2;
    
    /**
     * Symbolic constant GL_SCISSOR_BOX
     */
    public final int GL_SCISSOR_BOX                                  = 0x0C10;
    
    /**
     * Symbolic constant GL_COLOR_CLEAR_VALUE
     */
    public final int GL_COLOR_CLEAR_VALUE                            = 0x0C22;
    
    /**
     * Symbolic constant GL_COLOR_WRITEMASK
     */
    public final int GL_COLOR_WRITEMASK                              = 0x0C23;
    
    /**
     * Symbolic constant GL_UNPACK_ALIGNMENT
     */
    public final int GL_UNPACK_ALIGNMENT                             = 0x0CF5;
    
    /**
     * Symbolic constant GL_PACK_ALIGNMENT
     */
    public final int GL_PACK_ALIGNMENT                               = 0x0D05;
    
    /**
     * Symbolic constant GL_MAX_TEXTURE_SIZE
     */
    public final int GL_MAX_TEXTURE_SIZE                             = 0x0D33;
    
    /**
     * Symbolic constant GL_MAX_VIEWPORT_DIMS
     */
    public final int GL_MAX_VIEWPORT_DIMS                            = 0x0D3A;
    
    /**
     * Symbolic constant GL_SUBPIXEL_BITS
     */
    public final int GL_SUBPIXEL_BITS                                = 0x0D50;
    
    /**
     * Symbolic constant GL_RED_BITS
     */
    public final int GL_RED_BITS                                     = 0x0D52;
    
    /**
     * Symbolic constant GL_GREEN_BITS
     */
    public final int GL_GREEN_BITS                                   = 0x0D53;
    
    /**
     * Symbolic constant GL_BLUE_BITS
     */
    public final int GL_BLUE_BITS                                    = 0x0D54;
    
    /**
     * Symbolic constant GL_ALPHA_BITS
     */
    public final int GL_ALPHA_BITS                                   = 0x0D55;
    
    /**
     * Symbolic constant GL_DEPTH_BITS
     */
    public final int GL_DEPTH_BITS                                   = 0x0D56;
    
    /**
     * Symbolic constant GL_STENCIL_BITS
     */
    public final int GL_STENCIL_BITS                                 = 0x0D57;
    
    /**
     * Symbolic constant GL_POLYGON_OFFSET_UNITS
     */
    public final int GL_POLYGON_OFFSET_UNITS                         = 0x2A00;
    
    /**
     * Symbolic constant GL_POLYGON_OFFSET_FACTOR
     */
    public final int GL_POLYGON_OFFSET_FACTOR                        = 0x8038;
    
    /**
     * Symbolic constant GL_TEXTURE_BINDING_2D
     */
    public final int GL_TEXTURE_BINDING_2D                           = 0x8069;
    
    /**
     * Symbolic constant GL_SAMPLE_BUFFERS
     */
    public final int GL_SAMPLE_BUFFERS                               = 0x80A8;
    
    /**
     * Symbolic constant GL_SAMPLES
     */
    public final int GL_SAMPLES                                      = 0x80A9;
    
    /**
     * Symbolic constant GL_SAMPLE_COVERAGE_VALUE
     */
    public final int GL_SAMPLE_COVERAGE_VALUE                        = 0x80AA;
    
    /**
     * Symbolic constant GL_SAMPLE_COVERAGE_INVERT
     */
    public final int GL_SAMPLE_COVERAGE_INVERT                       = 0x80AB;
    
    /**
     * Symbolic constant GL_NUM_COMPRESSED_TEXTURE_FORMATS
     */
    public final int GL_NUM_COMPRESSED_TEXTURE_FORMATS               = 0x86A2;
    
    /**
     * Symbolic constant GL_COMPRESSED_TEXTURE_FORMATS
     */
    public final int GL_COMPRESSED_TEXTURE_FORMATS                   = 0x86A3;
    
    /**
     * Symbolic constant GL_DONT_CARE
     */
    public final int GL_DONT_CARE                                    = 0x1100;
    
    /**
     * Symbolic constant GL_FASTEST
     */
    public final int GL_FASTEST                                      = 0x1101;
    
    /**
     * Symbolic constant GL_NICEST
     */
    public final int GL_NICEST                                       = 0x1102;
    
    /**
     * Symbolic constant GL_GENERATE_MIPMAP_HINT
     */
    public final int GL_GENERATE_MIPMAP_HINT                         = 0x8192;
    
    /**
     * Symbolic constant GL_BYTE
     */
    public final int GL_BYTE                                         = 0x1400;
    
    /**
     * Symbolic constant GL_UNSIGNED_BYTE
     */
    public final int GL_UNSIGNED_BYTE                                = 0x1401;
    
    /**
     * Symbolic constant GL_SHORT
     */
    public final int GL_SHORT                                        = 0x1402;
    
    /**
     * Symbolic constant GL_UNSIGNED_SHORT
     */
    public final int GL_UNSIGNED_SHORT                               = 0x1403;
    
    /**
     * Symbolic constant GL_INT
     */
    public final int GL_INT                                          = 0x1404;
    
    /**
     * Symbolic constant GL_UNSIGNED_INT
     */
    public final int GL_UNSIGNED_INT                                 = 0x1405;
    
    /**
     * Symbolic constant GL_FLOAT
     */
    public final int GL_FLOAT                                        = 0x1406;
    
    /**
     * Symbolic constant GL_FIXED
     */
    public final int GL_FIXED                                        = 0x140C;
    
    /**
     * Symbolic constant GL_DEPTH_COMPONENT
     */
    public final int GL_DEPTH_COMPONENT                              = 0x1902;
    
    /**
     * Symbolic constant GL_ALPHA
     */
    public final int GL_ALPHA                                        = 0x1906;
    
    /**
     * Symbolic constant GL_RGB
     */
    public final int GL_RGB                                          = 0x1907;
    
    /**
     * Symbolic constant GL_RGBA
     */
    public final int GL_RGBA                                         = 0x1908;
    
    /**
     * Symbolic constant GL_LUMINANCE
     */
    public final int GL_LUMINANCE                                    = 0x1909;
    
    /**
     * Symbolic constant GL_LUMINANCE_ALPHA
     */
    public final int GL_LUMINANCE_ALPHA                              = 0x190A;
    
    /**
     * Symbolic constant GL_UNSIGNED_SHORT_4_4_4_4
     */
    public final int GL_UNSIGNED_SHORT_4_4_4_4                       = 0x8033;
    
    /**
     * Symbolic constant GL_UNSIGNED_SHORT_5_5_5_1
     */
    public final int GL_UNSIGNED_SHORT_5_5_5_1                       = 0x8034;
    
    /**
     * Symbolic constant GL_UNSIGNED_SHORT_5_6_5
     */
    public final int GL_UNSIGNED_SHORT_5_6_5                         = 0x8363;
    
    /**
     * Symbolic constant GL_FRAGMENT_SHADER
     */
    public final int GL_FRAGMENT_SHADER                              = 0x8B30;
    
    /**
     * Symbolic constant GL_VERTEX_SHADER
     */
    public final int GL_VERTEX_SHADER                                = 0x8B31;
    
    /**
     * Symbolic constant GL_MAX_VERTEX_ATTRIBS
     */
    public final int GL_MAX_VERTEX_ATTRIBS                           = 0x8869;
    
    /**
     * Symbolic constant GL_MAX_VERTEX_UNIFORM_VECTORS
     */
    public final int GL_MAX_VERTEX_UNIFORM_VECTORS                   = 0x8DFB;
    
    /**
     * Symbolic constant GL_MAX_VARYING_VECTORS
     */
    public final int GL_MAX_VARYING_VECTORS                          = 0x8DFC;
    
    /**
     * Symbolic constant GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS
     */
    public final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS             = 0x8B4D;
    
    /**
     * Symbolic constant GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS
     */
    public final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS               = 0x8B4C;
    
    /**
     * Symbolic constant GL_MAX_TEXTURE_IMAGE_UNITS
     */
    public final int GL_MAX_TEXTURE_IMAGE_UNITS                      = 0x8872;
    
    /**
     * Symbolic constant GL_MAX_FRAGMENT_UNIFORM_VECTORS
     */
    public final int GL_MAX_FRAGMENT_UNIFORM_VECTORS                 = 0x8DFD;
    
    /**
     * Symbolic constant GL_SHADER_TYPE
     */
    public final int GL_SHADER_TYPE                                  = 0x8B4F;
    
    /**
     * Symbolic constant GL_DELETE_STATUS
     */
    public final int GL_DELETE_STATUS                                = 0x8B80;
    
    /**
     * Symbolic constant GL_LINK_STATUS
     */
    public final int GL_LINK_STATUS                                  = 0x8B82;
    
    /**
     * Symbolic constant GL_VALIDATE_STATUS
     */
    public final int GL_VALIDATE_STATUS                              = 0x8B83;
    
    /**
     * Symbolic constant GL_ATTACHED_SHADERS
     */
    public final int GL_ATTACHED_SHADERS                             = 0x8B85;
    
    /**
     * Symbolic constant GL_ACTIVE_UNIFORMS
     */
    public final int GL_ACTIVE_UNIFORMS                              = 0x8B86;
    
    /**
     * Symbolic constant GL_ACTIVE_UNIFORM_MAX_LENGTH
     */
    public final int GL_ACTIVE_UNIFORM_MAX_LENGTH                    = 0x8B87;
    
    /**
     * Symbolic constant GL_ACTIVE_ATTRIBUTES
     */
    public final int GL_ACTIVE_ATTRIBUTES                            = 0x8B89;
    
    /**
     * Symbolic constant GL_ACTIVE_ATTRIBUTE_MAX_LENGTH
     */
    public final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH                  = 0x8B8A;
    
    /**
     * Symbolic constant GL_SHADING_LANGUAGE_VERSION
     */
    public final int GL_SHADING_LANGUAGE_VERSION                     = 0x8B8C;
    
    /**
     * Symbolic constant GL_CURRENT_PROGRAM
     */
    public final int GL_CURRENT_PROGRAM                              = 0x8B8D;
    
    /**
     * Symbolic constant GL_NEVER
     */
    public final int GL_NEVER                                        = 0x0200;
    
    /**
     * Symbolic constant GL_LESS
     */
    public final int GL_LESS                                         = 0x0201;
    
    /**
     * Symbolic constant GL_EQUAL
     */
    public final int GL_EQUAL                                        = 0x0202;
    
    /**
     * Symbolic constant GL_LEQUAL
     */
    public final int GL_LEQUAL                                       = 0x0203;
    
    /**
     * Symbolic constant GL_GREATER
     */
    public final int GL_GREATER                                      = 0x0204;
    
    /**
     * Symbolic constant GL_NOTEQUAL
     */
    public final int GL_NOTEQUAL                                     = 0x0205;
    
    /**
     * Symbolic constant GL_GEQUAL
     */
    public final int GL_GEQUAL                                       = 0x0206;
    
    /**
     * Symbolic constant GL_ALWAYS
     */
    public final int GL_ALWAYS                                       = 0x0207;
    
    /**
     * Symbolic constant GL_KEEP
     */
    public final int GL_KEEP                                         = 0x1E00;
    
    /**
     * Symbolic constant GL_REPLACE
     */
    public final int GL_REPLACE                                      = 0x1E01;
    
    /**
     * Symbolic constant GL_INCR
     */
    public final int GL_INCR                                         = 0x1E02;
    
    /**
     * Symbolic constant GL_DECR
     */
    public final int GL_DECR                                         = 0x1E03;
    
    /**
     * Symbolic constant GL_INVERT
     */
    public final int GL_INVERT                                       = 0x150A;
    
    /**
     * Symbolic constant GL_INCR_WRAP
     */
    public final int GL_INCR_WRAP                                    = 0x8507;
    
    /**
     * Symbolic constant GL_DECR_WRAP
     */
    public final int GL_DECR_WRAP                                    = 0x8508;
    
    /**
     * Symbolic constant GL_VENDOR
     */
    public final int GL_VENDOR                                       = 0x1F00;
    
    /**
     * Symbolic constant GL_RENDERER
     */
    public final int GL_RENDERER                                     = 0x1F01;
    
    /**
     * Symbolic constant GL_VERSION
     */
    public final int GL_VERSION                                      = 0x1F02;
    
    /**
     * Symbolic constant GL_EXTENSIONS
     */
    public final int GL_EXTENSIONS                                   = 0x1F03;
    
    /**
     * Symbolic constant GL_NEAREST
     */
    public final int GL_NEAREST                                      = 0x2600;
    
    /**
     * Symbolic constant GL_LINEAR
     */
    public final int GL_LINEAR                                       = 0x2601;
    
    /**
     * Symbolic constant GL_NEAREST_MIPMAP_NEAREST
     */
    public final int GL_NEAREST_MIPMAP_NEAREST                       = 0x2700;
    
    /**
     * Symbolic constant GL_LINEAR_MIPMAP_NEAREST
     */
    public final int GL_LINEAR_MIPMAP_NEAREST                        = 0x2701;
    
    /**
     * Symbolic constant GL_NEAREST_MIPMAP_LINEAR
     */
    public final int GL_NEAREST_MIPMAP_LINEAR                        = 0x2702;
    
    /**
     * Symbolic constant GL_LINEAR_MIPMAP_LINEAR
     */
    public final int GL_LINEAR_MIPMAP_LINEAR                         = 0x2703;
    
    /**
     * Symbolic constant GL_TEXTURE_MAG_FILTER
     */
    public final int GL_TEXTURE_MAG_FILTER                           = 0x2800;
    
    /**
     * Symbolic constant GL_TEXTURE_MIN_FILTER
     */
    public final int GL_TEXTURE_MIN_FILTER                           = 0x2801;
    
    /**
     * Symbolic constant GL_TEXTURE_WRAP_S
     */
    public final int GL_TEXTURE_WRAP_S                               = 0x2802;
    
    /**
     * Symbolic constant GL_TEXTURE_WRAP_T
     */
    public final int GL_TEXTURE_WRAP_T                               = 0x2803;
    
    /**
     * Symbolic constant GL_TEXTURE
     */
    public final int GL_TEXTURE                                      = 0x1702;
    
    /**
     * Symbolic constant GL_TEXTURE_CUBE_MAP
     */
    public final int GL_TEXTURE_CUBE_MAP                             = 0x8513;
    
    /**
     * Symbolic constant GL_TEXTURE_BINDING_CUBE_MAP
     */
    public final int GL_TEXTURE_BINDING_CUBE_MAP                     = 0x8514;
    
    /**
     * Symbolic constant GL_TEXTURE_CUBE_MAP_POSITIVE_X
     */
    public final int GL_TEXTURE_CUBE_MAP_POSITIVE_X                  = 0x8515;
    
    /**
     * Symbolic constant GL_TEXTURE_CUBE_MAP_NEGATIVE_X
     */
    public final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X                  = 0x8516;
    
    /**
     * Symbolic constant GL_TEXTURE_CUBE_MAP_POSITIVE_Y
     */
    public final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y                  = 0x8517;
    
    /**
     * Symbolic constant GL_TEXTURE_CUBE_MAP_NEGATIVE_Y
     */
    public final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y                  = 0x8518;
    
    /**
     * Symbolic constant GL_TEXTURE_CUBE_MAP_POSITIVE_Z
     */
    public final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z                  = 0x8519;
    
    /**
     * Symbolic constant GL_TEXTURE_CUBE_MAP_NEGATIVE_Z
     */
    public final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z                  = 0x851A;
    
    /**
     * Symbolic constant GL_MAX_CUBE_MAP_TEXTURE_SIZE
     */
    public final int GL_MAX_CUBE_MAP_TEXTURE_SIZE                    = 0x851C;
    
    /**
     * Symbolic constant GL_TEXTURE0
     */
    public final int GL_TEXTURE0                                     = 0x84C0;
    
    /**
     * Symbolic constant GL_TEXTURE1
     */
    public final int GL_TEXTURE1                                     = 0x84C1;
    
    /**
     * Symbolic constant GL_TEXTURE2
     */
    public final int GL_TEXTURE2                                     = 0x84C2;
    
    /**
     * Symbolic constant GL_TEXTURE3
     */
    public final int GL_TEXTURE3                                     = 0x84C3;
    
    /**
     * Symbolic constant GL_TEXTURE4
     */
    public final int GL_TEXTURE4                                     = 0x84C4;
    
    /**
     * Symbolic constant GL_TEXTURE5
     */
    public final int GL_TEXTURE5                                     = 0x84C5;
    
    /**
     * Symbolic constant GL_TEXTURE6
     */
    public final int GL_TEXTURE6                                     = 0x84C6;
    
    /**
     * Symbolic constant GL_TEXTURE7
     */
    public final int GL_TEXTURE7                                     = 0x84C7;
    
    /**
     * Symbolic constant GL_TEXTURE8
     */
    public final int GL_TEXTURE8                                     = 0x84C8;
    
    /**
     * Symbolic constant GL_TEXTURE9
     */
    public final int GL_TEXTURE9                                     = 0x84C9;
    
    /**
     * Symbolic constant GL_TEXTURE10
     */
    public final int GL_TEXTURE10                                    = 0x84CA;
    
    /**
     * Symbolic constant GL_TEXTURE11
     */
    public final int GL_TEXTURE11                                    = 0x84CB;
    
    /**
     * Symbolic constant GL_TEXTURE12
     */
    public final int GL_TEXTURE12                                    = 0x84CC;
    
    /**
     * Symbolic constant GL_TEXTURE13
     */
    public final int GL_TEXTURE13                                    = 0x84CD;
    
    /**
     * Symbolic constant GL_TEXTURE14
     */
    public final int GL_TEXTURE14                                    = 0x84CE;
    
    /**
     * Symbolic constant GL_TEXTURE15
     */
    public final int GL_TEXTURE15                                    = 0x84CF;
    
    /**
     * Symbolic constant GL_TEXTURE16
     */
    public final int GL_TEXTURE16                                    = 0x84D0;
    
    /**
     * Symbolic constant GL_TEXTURE17
     */
    public final int GL_TEXTURE17                                    = 0x84D1;
    
    /**
     * Symbolic constant GL_TEXTURE18
     */
    public final int GL_TEXTURE18                                    = 0x84D2;
    
    /**
     * Symbolic constant GL_TEXTURE19
     */
    public final int GL_TEXTURE19                                    = 0x84D3;
    
    /**
     * Symbolic constant GL_TEXTURE20
     */
    public final int GL_TEXTURE20                                    = 0x84D4;
    
    /**
     * Symbolic constant GL_TEXTURE21
     */
    public final int GL_TEXTURE21                                    = 0x84D5;
    
    /**
     * Symbolic constant GL_TEXTURE22
     */
    public final int GL_TEXTURE22                                    = 0x84D6;
    
    /**
     * Symbolic constant GL_TEXTURE23
     */
    public final int GL_TEXTURE23                                    = 0x84D7;
    
    /**
     * Symbolic constant GL_TEXTURE24
     */
    public final int GL_TEXTURE24                                    = 0x84D8;
    
    /**
     * Symbolic constant GL_TEXTURE25
     */
    public final int GL_TEXTURE25                                    = 0x84D9;
    
    /**
     * Symbolic constant GL_TEXTURE26
     */
    public final int GL_TEXTURE26                                    = 0x84DA;
    
    /**
     * Symbolic constant GL_TEXTURE27
     */
    public final int GL_TEXTURE27                                    = 0x84DB;
    
    /**
     * Symbolic constant GL_TEXTURE28
     */
    public final int GL_TEXTURE28                                    = 0x84DC;
    
    /**
     * Symbolic constant GL_TEXTURE29
     */
    public final int GL_TEXTURE29                                    = 0x84DD;
    
    /**
     * Symbolic constant GL_TEXTURE30
     */
    public final int GL_TEXTURE30                                    = 0x84DE;
    
    /**
     * Symbolic constant GL_TEXTURE31
     */
    public final int GL_TEXTURE31                                    = 0x84DF;
    
    /**
     * Symbolic constant GL_REPEAT
     */
    public final int GL_REPEAT                                       = 0x2901;
    
    /**
     * Symbolic constant GL_CLAMP_TO_EDGE
     */
    public final int GL_CLAMP_TO_EDGE                                = 0x812F;
    
    /**
     * Symbolic constant GL_MIRRORED_REPEAT
     */
    public final int GL_MIRRORED_REPEAT                              = 0x8370;
    
    /**
     * Symbolic constant GL_FLOAT_VEC2
     */
    public final int GL_FLOAT_VEC2                                   = 0x8B50;
    
    /**
     * Symbolic constant GL_FLOAT_VEC3
     */
    public final int GL_FLOAT_VEC3                                   = 0x8B51;
    
    /**
     * Symbolic constant GL_FLOAT_VEC4
     */
    public final int GL_FLOAT_VEC4                                   = 0x8B52;
    
    /**
     * Symbolic constant GL_INT_VEC2
     */
    public final int GL_INT_VEC2                                     = 0x8B53;
    
    /**
     * Symbolic constant GL_INT_VEC3
     */
    public final int GL_INT_VEC3                                     = 0x8B54;
    
    /**
     * Symbolic constant GL_INT_VEC4
     */
    public final int GL_INT_VEC4                                     = 0x8B55;
    
    /**
     * Symbolic constant GL_BOOL
     */
    public final int GL_BOOL                                         = 0x8B56;
    
    /**
     * Symbolic constant GL_BOOL_VEC2
     */
    public final int GL_BOOL_VEC2                                    = 0x8B57;
    
    /**
     * Symbolic constant GL_BOOL_VEC3
     */
    public final int GL_BOOL_VEC3                                    = 0x8B58;
    
    /**
     * Symbolic constant GL_BOOL_VEC4
     */
    public final int GL_BOOL_VEC4                                    = 0x8B59;
    
    /**
     * Symbolic constant GL_FLOAT_MAT2
     */
    public final int GL_FLOAT_MAT2                                   = 0x8B5A;
    
    /**
     * Symbolic constant GL_FLOAT_MAT3
     */
    public final int GL_FLOAT_MAT3                                   = 0x8B5B;
    
    /**
     * Symbolic constant GL_FLOAT_MAT4
     */
    public final int GL_FLOAT_MAT4                                   = 0x8B5C;
    
    /**
     * Symbolic constant GL_SAMPLER_2D
     */
    public final int GL_SAMPLER_2D                                   = 0x8B5E;
    
    /**
     * Symbolic constant GL_SAMPLER_CUBE
     */
    public final int GL_SAMPLER_CUBE                                 = 0x8B60;
    
    /**
     * Symbolic constant GL_VERTEX_ATTRIB_ARRAY_ENABLED
     */
    public final int GL_VERTEX_ATTRIB_ARRAY_ENABLED                  = 0x8622;
    
    /**
     * Symbolic constant GL_VERTEX_ATTRIB_ARRAY_SIZE
     */
    public final int GL_VERTEX_ATTRIB_ARRAY_SIZE                     = 0x8623;
    
    /**
     * Symbolic constant GL_VERTEX_ATTRIB_ARRAY_STRIDE
     */
    public final int GL_VERTEX_ATTRIB_ARRAY_STRIDE                   = 0x8624;
    
    /**
     * Symbolic constant GL_VERTEX_ATTRIB_ARRAY_TYPE
     */
    public final int GL_VERTEX_ATTRIB_ARRAY_TYPE                     = 0x8625;
    
    /**
     * Symbolic constant GL_VERTEX_ATTRIB_ARRAY_NORMALIZED
     */
    public final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED               = 0x886A;
    
    /**
     * Symbolic constant GL_VERTEX_ATTRIB_ARRAY_POINTER
     */
    public final int GL_VERTEX_ATTRIB_ARRAY_POINTER                  = 0x8645;
    
    /**
     * Symbolic constant GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING
     */
    public final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING           = 0x889F;
    
    /**
     * Symbolic constant GL_IMPLEMENTATION_COLOR_READ_TYPE
     */
    public final int GL_IMPLEMENTATION_COLOR_READ_TYPE               = 0x8B9A;
    
    /**
     * Symbolic constant GL_IMPLEMENTATION_COLOR_READ_FORMAT
     */
    public final int GL_IMPLEMENTATION_COLOR_READ_FORMAT             = 0x8B9B;
    
    /**
     * Symbolic constant GL_COMPILE_STATUS
     */
    public final int GL_COMPILE_STATUS                               = 0x8B81;
    
    /**
     * Symbolic constant GL_INFO_LOG_LENGTH
     */
    public final int GL_INFO_LOG_LENGTH                              = 0x8B84;
    
    /**
     * Symbolic constant GL_SHADER_SOURCE_LENGTH
     */
    public final int GL_SHADER_SOURCE_LENGTH                         = 0x8B88;
    
    /**
     * Symbolic constant GL_SHADER_COMPILER
     */
    public final int GL_SHADER_COMPILER                              = 0x8DFA;
    
    /**
     * Symbolic constant GL_SHADER_BINARY_FORMATS
     */
    public final int GL_SHADER_BINARY_FORMATS                        = 0x8DF8;
    
    /**
     * Symbolic constant GL_NUM_SHADER_BINARY_FORMATS
     */
    public final int GL_NUM_SHADER_BINARY_FORMATS                    = 0x8DF9;
    
    /**
     * Symbolic constant GL_LOW_FLOAT
     */
    public final int GL_LOW_FLOAT                                    = 0x8DF0;
    
    /**
     * Symbolic constant GL_MEDIUM_FLOAT
     */
    public final int GL_MEDIUM_FLOAT                                 = 0x8DF1;
    
    /**
     * Symbolic constant GL_HIGH_FLOAT
     */
    public final int GL_HIGH_FLOAT                                   = 0x8DF2;
    
    /**
     * Symbolic constant GL_LOW_INT
     */
    public final int GL_LOW_INT                                      = 0x8DF3;
    
    /**
     * Symbolic constant GL_MEDIUM_INT
     */
    public final int GL_MEDIUM_INT                                   = 0x8DF4;
    
    /**
     * Symbolic constant GL_HIGH_INT
     */
    public final int GL_HIGH_INT                                     = 0x8DF5;
    
    /**
     * Symbolic constant GL_FRAMEBUFFER
     */
    public final int GL_FRAMEBUFFER                                  = 0x8D40;
    
    /**
     * Symbolic constant GL_RENDERBUFFER
     */
    public final int GL_RENDERBUFFER                                 = 0x8D41;
    
    /**
     * Symbolic constant GL_RGBA4
     */
    public final int GL_RGBA4                                        = 0x8056;
    
    /**
     * Symbolic constant GL_RGB5_A1
     */
    public final int GL_RGB5_A1                                      = 0x8057;
    
    /**
     * Symbolic constant GL_RGB565
     */
    public final int GL_RGB565                                       = 0x8D62;
    
    /**
     * Symbolic constant GL_DEPTH_COMPONENT16
     */
    public final int GL_DEPTH_COMPONENT16                            = 0x81A5;
    
    /**
     * Symbolic constant GL_STENCIL_INDEX
     */
    public final int GL_STENCIL_INDEX                                = 0x1901;
    
    /**
     * Symbolic constant GL_STENCIL_INDEX8
     */
    public final int GL_STENCIL_INDEX8                               = 0x8D48;
    
    /**
     * Symbolic constant GL_RENDERBUFFER_WIDTH
     */
    public final int GL_RENDERBUFFER_WIDTH                           = 0x8D42;
    
    /**
     * Symbolic constant GL_RENDERBUFFER_HEIGHT
     */
    public final int GL_RENDERBUFFER_HEIGHT                          = 0x8D43;
    
    /**
     * Symbolic constant GL_RENDERBUFFER_INTERNAL_FORMAT
     */
    public final int GL_RENDERBUFFER_INTERNAL_FORMAT                 = 0x8D44;
    
    /**
     * Symbolic constant GL_RENDERBUFFER_RED_SIZE
     */
    public final int GL_RENDERBUFFER_RED_SIZE                        = 0x8D50;
    
    /**
     * Symbolic constant GL_RENDERBUFFER_GREEN_SIZE
     */
    public final int GL_RENDERBUFFER_GREEN_SIZE                      = 0x8D51;
    
    /**
     * Symbolic constant GL_RENDERBUFFER_BLUE_SIZE
     */
    public final int GL_RENDERBUFFER_BLUE_SIZE                       = 0x8D52;
    
    /**
     * Symbolic constant GL_RENDERBUFFER_ALPHA_SIZE
     */
    public final int GL_RENDERBUFFER_ALPHA_SIZE                      = 0x8D53;
    
    /**
     * Symbolic constant GL_RENDERBUFFER_DEPTH_SIZE
     */
    public final int GL_RENDERBUFFER_DEPTH_SIZE                      = 0x8D54;
    
    /**
     * Symbolic constant GL_RENDERBUFFER_STENCIL_SIZE
     */
    public final int GL_RENDERBUFFER_STENCIL_SIZE                    = 0x8D55;
    
    /**
     * Symbolic constant GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE
     */
    public final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE           = 0x8CD0;
    
    /**
     * Symbolic constant GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME
     */
    public final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME           = 0x8CD1;
    
    /**
     * Symbolic constant GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL
     */
    public final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL         = 0x8CD2;
    
    /**
     * Symbolic constant GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE
     */
    public final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 0x8CD3;
    
    /**
     * Symbolic constant GL_COLOR_ATTACHMENT0
     */
    public final int GL_COLOR_ATTACHMENT0                            = 0x8CE0;
    
    /**
     * Symbolic constant GL_DEPTH_ATTACHMENT
     */
    public final int GL_DEPTH_ATTACHMENT                             = 0x8D00;
    
    /**
     * Symbolic constant GL_STENCIL_ATTACHMENT
     */
    public final int GL_STENCIL_ATTACHMENT                           = 0x8D20;
    
    /**
     * Symbolic constant GL_NONE
     */
    public final int GL_NONE                                         = 0;
    
    /**
     * Symbolic constant GL_FRAMEBUFFER_COMPLETE
     */
    public final int GL_FRAMEBUFFER_COMPLETE                         = 0x8CD5;
    
    /**
     * Symbolic constant GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT
     */
    public final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT            = 0x8CD6;
    
    /**
     * Symbolic constant GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT
     */
    public final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT    = 0x8CD7;
    
    /**
     * Symbolic constant GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS
     */
    public final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS            = 0x8CD9;
    
    /**
     * Symbolic constant GL_FRAMEBUFFER_UNSUPPORTED
     */
    public final int GL_FRAMEBUFFER_UNSUPPORTED                      = 0x8CDD;
    
    /**
     * Symbolic constant GL_FRAMEBUFFER_BINDING
     */
    public final int GL_FRAMEBUFFER_BINDING                          = 0x8CA6;
    
    /**
     * Symbolic constant GL_RENDERBUFFER_BINDING
     */
    public final int GL_RENDERBUFFER_BINDING                         = 0x8CA7;
    
    /**
     * Symbolic constant GL_MAX_RENDERBUFFER_SIZE
     */
    public final int GL_MAX_RENDERBUFFER_SIZE                        = 0x84E8;
    
    /**
     * Symbolic constant GL_INVALID_FRAMEBUFFER_OPERATION
     */
    public final int GL_INVALID_FRAMEBUFFER_OPERATION                = 0x0506;
    
    /**
     * C function void glActiveTexture(GLenum texture)
     * 
     * @param texture GLenum texture
     */
    public void glActiveTexture(int texture);
    
    /**
     * C function void glAttachShader(GLuint program, GLuint shader)
     * 
     * @param program GLuint program
     * @param shader GLuint shader
     */
    public void glAttachShader(int program, int shader);
    
    /**
     * C function void glBindAttribLocation(GLuint program, GLuint index, const char *name)
     * 
     * @param program GLuint program
     * @param index GLuint index
     * @param name const char *name
     */
    public void glBindAttribLocation(int program, int index, String name);
    
    /**
     * C function void glBindBuffer(GLenum target, GLuint buffer)
     * 
     * @param target GLenum target
     * @param buffer GLuint buffer
     */
    public void glBindBuffer(int target, int buffer);
    
    /**
     * C function void glBindFramebuffer(GLenum target, GLuint framebuffer)
     * 
     * @param target GLenum target
     * @param framebuffer GLuint framebuffer
     */
    public void glBindFramebuffer(int target, int framebuffer);
    
    /**
     * C function void glBindRenderbuffer(GLenum target, GLuint renderbuffer)
     * 
     * @param target GLenum target
     * @param renderbuffer GLuint renderbuffer
     */
    public void glBindRenderbuffer(int target, int renderbuffer);
    
    /**
     * C function void glBindTexture(GLenum target, GLuint texture)
     * 
     * @param target GLenum target
     * @param texture GLuint texture
     */
    public void glBindTexture(int target, int texture);
    
    /**
     * C function void glBlendColor(GLclampf red, GLclampf green, GLclampf blue, GLclampf alpha)
     * 
     * @param red GLclampf red
     * @param green GLclampf green
     * @param blue GLclampf blue
     * @param alpha GLclampf alpha
     */
    public void glBlendColor(float red, float green, float blue, float alpha);
    
    /**
     * C function void glBlendEquation(GLenum mode)
     * 
     * @param mode GLenum mode
     */
    public void glBlendEquation(int mode);
    
    /**
     * C function void glBlendEquationSeparate(GLenum modeRGB, GLenum modeAlpha)
     * 
     * @param modeRGB GLenum modeRGB
     * @param modeAlpha GLenum modeAlpha
     */
    public void glBlendEquationSeparate(int modeRGB, int modeAlpha);
    
    /**
     * C function void glBlendFunc(GLenum sfactor, GLenum dfactor)
     * 
     * @param sfactor GLenum sfactor
     * @param dfactor GLenum dfactor
     */
    public void glBlendFunc(int sfactor, int dfactor);
    
    /**
     * C function void glBlendFuncSeparate(GLenum srcRGB, GLenum dstRGB, GLenum srcAlpha, GLenum dstAlpha)
     * 
     * @param srcRGB GLenum srcRGB
     * @param dstRGB GLenum dstRGB
     * @param srcAlpha GLenum srcAlpha
     * @param dstAlpha GLenum dstAlpha
     */
    public void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);
    
    /**
     * C function void glBufferData(GLenum target, GLsizeiptr size, const GLvoid *data, GLenum usage)
     * 
     * @param target GLenum target
     * @param size GLsizeiptr size
     * @param data const GLvoid *data
     * @param usage GLenum usage
     */
    public void glBufferData(int target, int size, Buffer data, int usage);
    
    /**
     * C function void glBufferSubData(GLenum target, GLintptr offset, GLsizeiptr size, const GLvoid *data)
     * 
     * @param target GLenum target
     * @param offset GLintptr offset
     * @param size GLsizeiptr size
     * @param data const GLvoid *data
     */
    public void glBufferSubData(int target, int offset, int size, Buffer data);
    
    /**
     * C function GLenum glCheckFramebufferStatus(GLenum target)
     * 
     * @param target GLenum target
     * @return GLenum
     */
    public int glCheckFramebufferStatus(int target);
    
    /**
     * C function void glClear(GLbitfield mask)
     * 
     * @param mask GLbitfield mask
     */
    public void glClear(int mask);
    
    /**
     * C function void glClearColor(GLclampf red, GLclampf green, GLclampf blue, GLclampf alpha)
     * 
     * @param red GLclampf red
     * @param green GLclampf green
     * @param blue GLclampf blue
     * @param alpha GLclampf alpha
     */
    public void glClearColor(float red, float green, float blue, float alpha);
    
    /**
     * C function void glClearDepthf(GLclampf depth)
     * 
     * @param depth GLclampf depth
     */
    public void glClearDepthf(float depth);
    
    /**
     * C function void glClearStencil(GLint s)
     * 
     * @param s GLint s
     */
    public void glClearStencil(int s);
    
    /**
     * C function void glColorMask(GLboolean red, GLboolean green, GLboolean blue, GLboolean alpha)
     * 
     * @param red GLboolean red
     * @param green GLboolean green
     * @param blue GLboolean blue
     * @param alpha GLboolean alpha
     */
    public void glColorMask(boolean red, boolean green, boolean blue, boolean alpha);
    
    /**
     * C function void glCompileShader(GLuint shader)
     * 
     * @param shader GLuint shader
     */
    public void glCompileShader(int shader);
    
    /**
     * C function void glCompressedTexImage2D(GLenum target, GLint level, GLenum internalformat, GLsizei width,
     * GLsizei height, GLint border, GLsizei imageSize, const GLvoid *data)
     * 
     * @param target GLenum target
     * @param level GLint level
     * @param internalformat GLenum internalformat
     * @param width GLsizei width
     * @param height GLsizei height
     * @param border GLint border
     * @param imageSize GLsizei imageSize
     * @param data const GLvoid *data
     */
    public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border,
            int imageSize, Buffer data);
    
    /**
     * C function void glCompressedTexSubImage2D(GLenum target, GLint level, GLint xoffset, GLint yoffset,
     * GLsizei width, GLsizei height, GLenum format, GLsizei imageSize, const GLvoid *data)
     * 
     * @param target GLenum target
     * @param level GLint level
     * @param xoffset GLint xoffset
     * @param yoffset GLint yoffset
     * @param width GLsizei width
     * @param height GLsizei height
     * @param format GLenum format
     * @param imageSize GLsizei imageSize
     * @param data const GLvoid *data
     */
    public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height,
            int format, int imageSize, Buffer data);
    
    /**
     * C function void glCopyTexImage2D(GLenum target, GLint level, GLenum internalformat, GLint x, GLint y,
     * GLsizei width, GLsizei height, GLint border)
     * 
     * @param target GLenum target
     * @param level GLint level
     * @param internalformat GLenum internalformat
     * @param x GLint x
     * @param y GLint y
     * @param width GLsizei width
     * @param height GLsizei height
     * @param border GLint border
     */
    public void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height,
            int border);
    
    /**
     * C function void glCopyTexSubImage2D(GLenum target, GLint level, GLint xoffset, GLint yoffset, GLint x, GLint y,
     * GLsizei width, GLsizei height)
     * 
     * @param target GLenum target
     * @param level GLint level
     * @param xoffset GLint xoffset
     * @param yoffset GLint yoffset
     * @param x GLint x
     * @param y GLint y
     * @param width GLsizei width
     * @param height GLsizei height
     */
    public void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width,
            int height);
    
    /**
     * C function GLuint glCreateProgram(void)
     * 
     * @return GLuint
     */
    public int glCreateProgram();
    
    /**
     * C function GLuint glCreateShader(GLenum type)
     * 
     * @param type GLenum type
     * @return GLuint
     */
    public int glCreateShader(int type);
    
    /**
     * C function void glCullFace(GLenum mode)
     * 
     * @param mode GLenum mode
     */
    public void glCullFace(int mode);
    
    /**
     * C function void glDeleteBuffers(GLsizei n, const GLuint *buffers)
     * 
     * @param n GLsizei n
     * @param buffers const GLuint *buffers
     */
    public void glDeleteBuffers(int n, IntBuffer buffers);
    
    /**
     * C function void glDeleteFramebuffers(GLsizei n, const GLuint *framebuffers)
     * 
     * @param n GLsizei n
     * @param framebuffers const GLuint *framebuffers
     */
    public void glDeleteFramebuffers(int n, IntBuffer framebuffers);
    
    /**
     * C function void glDeleteProgram(GLuint program)
     * 
     * @param program GLuint program
     */
    public void glDeleteProgram(int program);
    
    /**
     * C function void glDeleteRenderbuffers(GLsizei n, const GLuint *renderbuffers)
     * 
     * @param n GLsizei n
     * @param renderbuffers const GLuint *renderbuffers
     */
    public void glDeleteRenderbuffers(int n, IntBuffer renderbuffers);
    
    /**
     * C function void glDeleteShader(GLuint shader)
     * 
     * @param shader GLuint shader
     */
    public void glDeleteShader(int shader);
    
    /**
     * C function void glDeleteTextures(GLsizei n, const GLuint *textures)
     * 
     * @param n GLsizei n
     * @param textures const GLuint *textures
     */
    public void glDeleteTextures(int n, IntBuffer textures);
    
    /**
     * C function void glDepthFunc(GLenum func)
     * 
     * @param func GLenum func
     */
    public void glDepthFunc(int func);
    
    /**
     * C function void glDepthMask(GLboolean flag)
     * 
     * @param flag GLboolean flag
     */
    public void glDepthMask(boolean flag);
    
    /**
     * C function void glDepthRangef(GLclampf zNear, GLclampf zFar)
     * 
     * @param zNear GLclampf zNear
     * @param zFar GLclampf zFar
     */
    public void glDepthRangef(float zNear, float zFar);
    
    /**
     * C function void glDetachShader(GLuint program, GLuint shader)
     * 
     * @param program GLuint program
     * @param shader GLuint shader
     */
    public void glDetachShader(int program, int shader);
    
    /**
     * C function void glDisable(GLenum cap)
     * 
     * @param cap GLenum cap
     */
    public void glDisable(int cap);
    
    /**
     * C function void glDisableVertexAttribArray(GLuint index)
     * 
     * @param index GLuint index
     */
    public void glDisableVertexAttribArray(int index);
    
    /**
     * C function void glDrawArrays(GLenum mode, GLint first, GLsizei count)
     * 
     * @param mode GLenum mode
     * @param first GLint first
     * @param count GLsizei count
     */
    public void glDrawArrays(int mode, int first, int count);
    
    /**
     * C function void glDrawElements(GLenum mode, GLsizei count, GLenum type, GLint offset)
     * 
     * @param mode GLenum mode
     * @param count GLsizei count
     * @param type GLenum type
     * @param offset GLint offset
     */
    public void glDrawElements(int mode, int count, int type, int offset);
    
    /**
     * C function void glDrawElements(GLenum mode, GLsizei count, GLenum type, const GLvoid *indices)
     * 
     * @param mode GLenum mode
     * @param count GLsizei count
     * @param type GLenum type
     * @param indices const GLvoid *indices
     */
    public void glDrawElements(int mode, int count, int type, Buffer indices);
    
    /**
     * C function void glEnable(GLenum cap)
     * 
     * @param cap GLenum cap
     */
    public void glEnable(int cap);
    
    /**
     * C function void glEnableVertexAttribArray(GLuint index)
     * 
     * @param index GLuint index
     */
    public void glEnableVertexAttribArray(int index);
    
    /**
     * C function void glFinish(void)
     */
    public void glFinish();
    
    /**
     * C function void glFlush(void)
     */
    public void glFlush();
    
    /**
     * C function void glFramebufferRenderbuffer(GLenum target, GLenum attachment, GLenum renderbuffertarget,
     * GLuint renderbuffer)
     * 
     * @param target GLenum target
     * @param attachment GLenum attachment
     * @param renderbuffertarget GLenum renderbuffertarget
     * @param renderbuffer GLuint renderbuffer
     */
    public void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer);
    
    /**
     * C function void glFramebufferTexture2D(GLenum target, GLenum attachment, GLenum textarget, GLuint texture,
     * GLint level)
     * 
     * @param target GLenum target
     * @param attachment GLenum attachment
     * @param textarget GLenum textarget
     * @param texture GLuint texture
     * @param level GLint level
     */
    public void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level);
    
    /**
     * C function void glFrontFace(GLenum mode)
     * 
     * @param mode GLenum mode
     */
    public void glFrontFace(int mode);
    
    /**
     * C function void glGenBuffers(GLsizei n, GLuint *buffers)
     * 
     * @param n GLsizei n
     * @param buffers GLuint *buffers
     */
    public void glGenBuffers(int n, IntBuffer buffers);
    
    /**
     * C function void glGenerateMipmap(GLenum target)
     * 
     * @param target GLenum target
     */
    public void glGenerateMipmap(int target);
    
    /**
     * C function void glGenFramebuffers(GLsizei n, GLuint *framebuffers)
     * 
     * @param n GLsizei n
     * @param framebuffers GLuint *framebuffers
     */
    public void glGenFramebuffers(int n, IntBuffer framebuffers);
    
    /**
     * C function void glGenRenderbuffers(GLsizei n, GLuint *renderbuffers)
     * 
     * @param n GLsizei n
     * @param renderbuffers GLuint *renderbuffers
     */
    public void glGenRenderbuffers(int n, IntBuffer renderbuffers);
    
    /**
     * C function void glGenTextures(GLsizei n, GLuint *textures)
     * 
     * @param n GLsizei n
     * @param textures GLuint *textures
     */
    public void glGenTextures(int n, IntBuffer textures);
    
    /**
     * C function void glGetActiveAttrib(GLuint program, GLuint index, GLsizei bufsize, GLsizei *length, GLint *size,
     * GLenum *type, char *name)
     * 
     * @param program GLuint program
     * @param index GLuint index
     * @param bufsize GLsizei bufsize
     * @param length GLsizei *length
     * @param lengthOffset GLsizei *length
     * @param size GLint *size
     * @param sizeOffset GLint *size
     * @param type GLenum *type
     * @param typeOffset GLenum *type
     * @param name char *name
     * @param nameOffset char *name
     */
    public void glGetActiveAttrib(int program, int index, int bufsize, int[] length, int lengthOffset, int[] size,
            int sizeOffset, int[] type, int typeOffset, byte[] name, int nameOffset);
    
    /**
     * C function void glGetActiveUniform(GLuint program, GLuint index, GLsizei bufsize, GLsizei *length, GLint *size,
     * GLenum *type, char *name)
     * 
     * @param program GLuint program
     * @param index GLuint index
     * @param bufsize GLsizei bufsize
     * @param length GLsizei *length
     * @param lengthOffset GLsizei *length
     * @param size GLint *size
     * @param sizeOffset GLint *size
     * @param type GLenum *type
     * @param typeOffset GLenum *type
     * @param name char *name
     * @param nameOffset char *name
     */
    public void glGetActiveUniform(int program, int index, int bufsize, int[] length, int lengthOffset, int[] size,
            int sizeOffset, int[] type, int typeOffset, byte[] name, int nameOffset);
    
    /**
     * C function void glGetAttachedShaders(GLuint program, GLsizei maxcount, GLsizei *count, GLuint *shaders)
     * 
     * @param program GLuint program
     * @param maxcount GLsizei maxcount
     * @param count GLsizei *count
     * @param shaders GLuint *shaders
     */
    public void glGetAttachedShaders(int program, int maxcount, IntBuffer count, IntBuffer shaders);
    
    /**
     * C function int glGetAttribLocation(GLuint program, const char *name)
     * 
     * @param program GLuint program
     * @param name const char *name
     * @return int
     */
    public int glGetAttribLocation(int program, String name);
    
    /**
     * C function void glGetBooleanv(GLenum pname, GLboolean *params)
     * 
     * @param pname GLenum pname
     * @param params GLboolean *params
     */
    public void glGetBooleanv(int pname, IntBuffer params);
    
    /**
     * C function void glGetBufferParameteriv(GLenum target, GLenum pname, GLint *params)
     * 
     * @param target GLenum target
     * @param pname GLenum pname
     * @param params GLint *params
     */
    public void glGetBufferParameteriv(int target, int pname, IntBuffer params);
    
    /**
     * C function GLenum glGetError(void)
     * 
     * @return GLenum
     */
    public int glGetError();
    
    /**
     * C function void glGetFloatv(GLenum pname, GLfloat *params)
     * 
     * @param pname GLenum pname
     * @param params GLfloat *params
     */
    public void glGetFloatv(int pname, FloatBuffer params);
    
    /**
     * C function void glGetFramebufferAttachmentParameteriv(GLenum target, GLenum attachment, GLenum pname,
     * GLint *params)
     * 
     * @param target GLenum target
     * @param attachment GLenum attachment
     * @param pname GLenum pname
     * @param params GLint *params
     */
    public void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, IntBuffer params);
    
    /**
     * C function void glGetIntegerv(GLenum pname, GLint *params)
     * 
     * @param pname GLenum pname
     * @param params GLint *params
     */
    public void glGetIntegerv(int pname, IntBuffer params);
    
    /**
     * C function void glGetProgramiv(GLuint program, GLenum pname, GLint *params)
     * 
     * @param program GLuint program
     * @param pname GLenum pname
     * @param params GLint *params
     */
    public void glGetProgramiv(int program, int pname, IntBuffer params);
    
    /**
     * C function void glGetProgramInfoLog(GLuint program, GLsizei maxLength, GLsizei *length, GLchar *infoLog);
     * 
     * @param program GLuint program
     * @return GLchar *infoLog
     */
    public String glGetProgramInfoLog(int program);
    
    /**
     * C function void glGetRenderbufferParameteriv(GLenum target, GLenum pname, GLint *params)
     * 
     * @param target GLenum target
     * @param pname GLenum pname
     * @param params GLint *params
     */
    public void glGetRenderbufferParameteriv(int target, int pname, IntBuffer params);
    
    /**
     * C function void glGetShaderiv(GLuint shader, GLenum pname, GLint *params)
     * 
     * @param shader GLuint shader
     * @param pname GLenum pname
     * @param params GLint *params
     */
    public void glGetShaderiv(int shader, int pname, IntBuffer params);
    
    /**
     * C function void glGetShaderInfoLog(GLuint shader, GLsizei maxLength, GLsizei *length, GLchar *infoLog);
     * 
     * @param shader GLuint shader
     * @return GLchar *infoLog
     */
    public String glGetShaderInfoLog(int shader);
    
    /**
     * C function void glGetShaderPrecisionFormat(GLenum shadertype, GLenum precisiontype, GLint *range,
     * GLint *precision)
     * 
     * @param shadertype GLenum shadertype
     * @param precisiontype GLenum precisiontype
     * @param range GLint *range
     * @param precision GLint *precision
     */
    public void glGetShaderPrecisionFormat(int shadertype, int precisiontype, IntBuffer range, IntBuffer precision);
    
    /**
     * C function void glGetShaderSource(GLuint shader, GLsizei bufsize, GLsizei *length, char *source)
     * 
     * @param shader GLuint shader
     * @param bufsize GLsizei bufsize
     * @param length GLsizei *length
     * @param lengthOffset GLsizei *length
     * @param source char *source
     * @param sourceOffset char *source
     */
    public void glGetShaderSource(int shader, int bufsize, int[] length, int lengthOffset, byte[] source,
            int sourceOffset);
    
    /**
     * C function const GLubyte *glGetString(GLenum name)
     * 
     * @param name GLenum name
     * @return GLubyte *
     */
    public String glGetString(int name);
    
    /**
     * C function void glGetTexParameterfv(GLenum target, GLenum pname, GLfloat *params)
     * 
     * @param target GLenum target
     * @param pname GLenum pname
     * @param params GLfloat *params
     */
    public void glGetTexParameterfv(int target, int pname, FloatBuffer params);
    
    /**
     * C function void glGetTexParameteriv(GLenum target, GLenum pname, GLint *params)
     * 
     * @param target GLenum target
     * @param pname GLenum pname
     * @param params GLint *params
     */
    public void glGetTexParameteriv(int target, int pname, IntBuffer params);
    
    /**
     * C function void glGetUniformfv(GLuint program, GLint location, GLfloat *params)
     * 
     * @param program GLuint program
     * @param location GLint location
     * @param params GLfloat *params
     */
    public void glGetUniformfv(int program, int location, FloatBuffer params);
    
    /**
     * C function void glGetUniformiv(GLuint program, GLint location, GLint *params)
     * 
     * @param program GLuint program
     * @param location GLint location
     * @param params GLint *params
     */
    public void glGetUniformiv(int program, int location, IntBuffer params);
    
    /**
     * C function int glGetUniformLocation(GLuint program, const char *name)
     * 
     * @param program GLuint program
     * @param name const char *name
     * @return int
     */
    public int glGetUniformLocation(int program, String name);
    
    /**
     * C function void glGetVertexAttribfv(GLuint index, GLenum pname, GLfloat *params)
     * 
     * @param index GLuint index
     * @param pname GLenum pname
     * @param params GLfloat *params
     */
    public void glGetVertexAttribfv(int index, int pname, FloatBuffer params);
    
    /**
     * C function void glGetVertexAttribiv(GLuint index, GLenum pname, GLint *params)
     * 
     * @param index GLuint index
     * @param pname GLenum pname
     * @param params GLint *params
     */
    public void glGetVertexAttribiv(int index, int pname, IntBuffer params);
    
    /**
     * C function void glHint(GLenum target, GLenum mode)
     * 
     * @param target GLenum target
     * @param mode GLenum mode
     */
    public void glHint(int target, int mode);
    
    /**
     * C function GLboolean glIsBuffer(GLuint buffer)
     * 
     * @param buffer GLuint buffer
     * @return GLboolean
     */
    public boolean glIsBuffer(int buffer);
    
    /**
     * C function GLboolean glIsEnabled(GLenum cap)
     * 
     * @param cap GLenum cap
     * @return GLboolean
     */
    public boolean glIsEnabled(int cap);
    
    /**
     * C function GLboolean glIsFramebuffer(GLuint framebuffer)
     * 
     * @param framebuffer GLuint framebuffer
     * @return GLboolean
     */
    public boolean glIsFramebuffer(int framebuffer);
    
    /**
     * C function GLboolean glIsProgram(GLuint program)
     * 
     * @param program GLuint program
     * @return GLboolean
     */
    public boolean glIsProgram(int program);
    
    /**
     * C function GLboolean glIsRenderbuffer(GLuint renderbuffer)
     * 
     * @param renderbuffer GLuint renderbuffer
     * @return GLboolean
     */
    public boolean glIsRenderbuffer(int renderbuffer);
    
    /**
     * C function GLboolean glIsShader(GLuint shader)
     * 
     * @param shader GLuint shader
     * @return GLboolean
     */
    public boolean glIsShader(int shader);
    
    /**
     * C function GLboolean glIsTexture(GLuint texture)
     * 
     * @param texture GLuint texture
     * @return GLboolean
     */
    public boolean glIsTexture(int texture);
    
    /**
     * C function void glLineWidth(GLfloat width)
     * 
     * @param width GLfloat width
     */
    public void glLineWidth(float width);
    
    /**
     * C function void glLinkProgram(GLuint program)
     * 
     * @param program GLuint program
     */
    public void glLinkProgram(int program);
    
    /**
     * C function void glPixelStorei(GLenum pname, GLint param)
     * 
     * @param pname GLenum pname
     * @param param GLint param
     */
    public void glPixelStorei(int pname, int param);
    
    /**
     * C function void glPolygonOffset(GLfloat factor, GLfloat units)
     * 
     * @param factor GLfloat factor
     * @param units GLfloat units
     */
    public void glPolygonOffset(float factor, float units);
    
    /**
     * C function void glReadPixels(GLint x, GLint y, GLsizei width, GLsizei height, GLenum format, GLenum type,
     * GLvoid *pixels)
     * 
     * @param x GLint x
     * @param y GLint y
     * @param width GLsizei width
     * @param height GLsizei height
     * @param format GLenum format
     * @param type GLenum type
     * @param pixels GLvoid *pixels
     */
    public void glReadPixels(int x, int y, int width, int height, int format, int type, Buffer pixels);
    
    /**
     * C function void glReleaseShaderCompiler(void)
     */
    public void glReleaseShaderCompiler();
    
    /**
     * C function void glRenderbufferStorage(GLenum target, GLenum internalformat, GLsizei width, GLsizei height)
     * 
     * @param target GLenum target
     * @param internalformat GLenum internalformat
     * @param width GLsizei width
     * @param height GLsizei height
     */
    public void glRenderbufferStorage(int target, int internalformat, int width, int height);
    
    /**
     * C function void glSampleCoverage(GLclampf value, GLboolean invert)
     * 
     * @param value GLclampf value
     * @param invert GLboolean invert
     */
    public void glSampleCoverage(float value, boolean invert);
    
    /**
     * C function void glScissor(GLint x, GLint y, GLsizei width, GLsizei height)
     * @param x GLint x
     * @param y GLint y
     * @param width GLsizei width
     * @param height GLsizei height
     */
    public void glScissor(int x, int y, int width, int height);
    
    /**
     * C function void glShaderBinary(GLsizei n, const GLuint *shaders, GLenum binaryformat, const GLvoid *binary,
     * GLsizei length)
     * 
     * @param n GLsizei n
     * @param shaders const GLuint *shaders
     * @param binaryformat GLenum binaryformat
     * @param binary const GLvoid *binary
     * @param length GLsizei length
     */
    public void glShaderBinary(int n, IntBuffer shaders, int binaryformat, Buffer binary, int length);
    
    /**
     * C function void glShaderSource(GLuint shader, GLsizei count, const GLchar **string, const GLint *length)
     * 
     * @param shader GLuint shader
     * @param string const GLchar **string
     */
    public void glShaderSource(int shader, String string);
    
    /**
     * C function void glStencilFunc(GLenum func, GLint ref, GLuint mask)
     * 
     * @param func GLenum func
     * @param ref GLint ref
     * @param mask GLuint mask
     */
    public void glStencilFunc(int func, int ref, int mask);
    
    /**
     * C function void glStencilFuncSeparate(GLenum face, GLenum func, GLint ref, GLuint mask)
     * 
     * @param face GLenum face
     * @param func GLenum func
     * @param ref GLint ref
     * @param mask GLuint mask
     */
    public void glStencilFuncSeparate(int face, int func, int ref, int mask);
    
    /**
     * C function void glStencilMask(GLuint mask)
     * 
     * @param mask GLuint mask
     */
    public void glStencilMask(int mask);
    
    /**
     * C function void glStencilMaskSeparate(GLenum face, GLuint mask)
     * 
     * @param face GLenum face
     * @param mask GLuint mask
     */
    public void glStencilMaskSeparate(int face, int mask);
    
    /**
     * C function void glStencilOp(GLenum fail, GLenum zfail, GLenum zpass)
     * 
     * @param fail GLenum fail
     * @param zfail GLenum zfail
     * @param zpass GLenum zpass
     */
    public void glStencilOp(int fail, int zfail, int zpass);
    
    /**
     * C function void glStencilOpSeparate(GLenum face, GLenum fail, GLenum zfail, GLenum zpass)
     * 
     * @param face GLenum face
     * @param fail GLenum fail
     * @param zfail GLenum zfail
     * @param zpass GLenum zpass
     */
    public void glStencilOpSeparate(int face, int fail, int zfail, int zpass);
    
    /**
     * C function void glTexImage2D(GLenum target, GLint level, GLint internalformat, GLsizei width, GLsizei height,
     * GLint border, GLenum format, GLenum type, const GLvoid *pixels)
     * 
     * @param target GLenum target
     * @param level GLint level
     * @param internalformat GLint internalformat
     * @param width GLsizei width
     * @param height GLsizei height
     * @param border GLint border
     * @param format GLenum format
     * @param type GLenum type
     * @param pixels const GLvoid *pixels
     */
    public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format,
            int type, Buffer pixels);
    
    /**
     * C function void glTexParameterf(GLenum target, GLenum pname, GLfloat param)
     * 
     * @param target GLenum target
     * @param pname GLenum pname
     * @param param GLfloat param
     */
    public void glTexParameterf(int target, int pname, float param);
    
    /**
     * C function void glTexParameterfv(GLenum target, GLenum pname, const GLfloat *params)
     * 
     * @param target GLenum target
     * @param pname GLenum pname
     * @param params const GLfloat *params
     */
    public void glTexParameterfv(int target, int pname, FloatBuffer params);
    
    /**
     * C function void glTexParameteri(GLenum target, GLenum pname, GLint param)
     * 
     * @param target GLenum target
     * @param pname GLenum pname
     * @param param GLint param
     */
    public void glTexParameteri(int target, int pname, int param);
    
    /**
     * C function void glTexParameteriv(GLenum target, GLenum pname, const GLint *params)
     * 
     * @param target GLenum target
     * @param pname GLenum pname
     * @param params const GLint *params
     */
    public void glTexParameteriv(int target, int pname, IntBuffer params);
    
    /**
     * C function void glTexSubImage2D(GLenum target, GLint level, GLint xoffset, GLint yoffset, GLsizei width,
     * GLsizei height, GLenum format, GLenum type, const GLvoid *pixels)
     * 
     * @param target GLenum target
     * @param level GLint level
     * @param xoffset GLint xoffset
     * @param yoffset GLint yoffset
     * @param width GLsizei width
     * @param height GLsizei height
     * @param format GLenum format
     * @param type GLenum type
     * @param pixels const GLvoid *pixels
     */
    public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format,
            int type, Buffer pixels);
    
    /**
     * C function void glUniform1f(GLint location, GLfloat x)
     * 
     * @param location GLint location
     * @param x GLfloat x
     */
    public void glUniform1f(int location, float x);
    
    /**
     * C function void glUniform1fv(GLint location, GLsizei count, const GLfloat *v)
     * 
     * @param location GLint location
     * @param count GLsizei count
     * @param v const GLfloat *v
     */
    public void glUniform1fv(int location, int count, FloatBuffer v);
    
    /**
     * C function void glUniform1i(GLint location, GLint x)
     * 
     * @param location GLint location
     * @param x GLint x
     */
    public void glUniform1i(int location, int x);
    
    /**
     * C function void glUniform1iv(GLint location, GLsizei count, const GLint *v)
     * 
     * @param location GLint location
     * @param count GLsizei count
     * @param v const GLint *v
     */
    public void glUniform1iv(int location, int count, IntBuffer v);
    
    /**
     * C function void glUniform2f(GLint location, GLfloat x, GLfloat y)
     * 
     * @param location GLint location
     * @param x GLfloat x
     * @param y GLfloat y
     */
    public void glUniform2f(int location, float x, float y);
    
    /**
     * C function void glUniform2fv(GLint location, GLsizei count, const GLfloat *v)
     * 
     * @param location GLint location
     * @param count GLsizei count
     * @param v const GLfloat *v
     */
    public void glUniform2fv(int location, int count, FloatBuffer v);
    
    /**
     * C function void glUniform2i(GLint location, GLint x, GLint y)
     * 
     * @param location GLint location
     * @param x GLint x
     * @param y GLint y
     */
    public void glUniform2i(int location, int x, int y);
    
    /**
     * C function void glUniform2iv(GLint location, GLsizei count, const GLint *v)
     * 
     * @param location GLint location
     * @param count GLsizei count
     * @param v const GLint *v
     */
    public void glUniform2iv(int location, int count, IntBuffer v);
    
    /**
     * C function void glUniform3f(GLint location, GLfloat x, GLfloat y, GLfloat z)
     * 
     * @param location GLint location
     * @param x GLfloat x
     * @param y GLfloat y
     * @param z GLfloat z
     */
    public void glUniform3f(int location, float x, float y, float z);
    
    /**
     * C function void glUniform3fv(GLint location, GLsizei count, const GLfloat *v)
     * 
     * @param location GLint location
     * @param count GLsizei count
     * @param v const GLfloat *v
     */
    public void glUniform3fv(int location, int count, FloatBuffer v);
    
    /**
     * C function void glUniform3i(GLint location, GLint x, GLint y, GLint z)
     * 
     * @param location GLint location
     * @param x GLint x
     * @param y GLint y
     * @param z GLint z
     */
    public void glUniform3i(int location, int x, int y, int z);
    
    /**
     * C function void glUniform3iv(GLint location, GLsizei count, const GLint *v)
     * 
     * @param location GLint location
     * @param count GLsizei count
     * @param v const GLint *v
     */
    public void glUniform3iv(int location, int count, IntBuffer v);
    
    /**
     * C function void glUniform4f(GLint location, GLfloat x, GLfloat y, GLfloat z, GLfloat w)
     * 
     * @param location GLint location
     * @param x GLfloat x
     * @param y GLfloat y
     * @param z GLfloat z
     * @param w GLfloat w
     */
    public void glUniform4f(int location, float x, float y, float z, float w);
    
    /**
     * C function void glUniform4fv(GLint location, GLsizei count, const GLfloat *v)
     * 
     * @param location GLint location
     * @param count GLsizei count
     * @param v const GLfloat *v
     */
    public void glUniform4fv(int location, int count, FloatBuffer v);
    
    /**
     * C function void glUniform4i(GLint location, GLint x, GLint y, GLint z, GLint w)
     * 
     * @param location GLint location
     * @param x GLint x
     * @param y GLint y
     * @param z GLint z
     * @param w GLint w
     */
    public void glUniform4i(int location, int x, int y, int z, int w);
    
    /**
     * C function void glUniform4iv(GLint location, GLsizei count, const GLint *v)
     * 
     * @param location GLint location
     * @param count GLsizei count
     * @param v const GLint *v
     */
    public void glUniform4iv(int location, int count, IntBuffer v);
    
    /**
     * C function void glUniformMatrix2fv(GLint location, GLsizei count, GLboolean transpose, const GLfloat *value)
     * 
     * @param location GLint location
     * @param count GLsizei count
     * @param transpose GLboolean transpose
     * @param value const GLfloat *value
     */
    public void glUniformMatrix2fv(int location, int count, boolean transpose, FloatBuffer value);
    
    /**
     * C function void glUniformMatrix3fv(GLint location, GLsizei count, GLboolean transpose, const GLfloat *value)
     * 
     * @param location GLint location
     * @param count GLsizei count
     * @param transpose GLboolean transpose
     * @param value const GLfloat *value
     */
    public void glUniformMatrix3fv(int location, int count, boolean transpose, FloatBuffer value);
    
    /**
     * C function void glUniformMatrix4fv(GLint location, GLsizei count, GLboolean transpose, const GLfloat *value)
     * 
     * @param location GLint location
     * @param count GLsizei count
     * @param transpose GLboolean transpose
     * @param value const GLfloat *value
     */
    public void glUniformMatrix4fv(int location, int count, boolean transpose, FloatBuffer value);
    
    /**
     * C function void glUseProgram(GLuint program)
     * 
     * @param program GLuint program
     */
    public void glUseProgram(int program);
    
    /**
     * C function void glValidateProgram(GLuint program)
     * 
     * @param program GLuint program
     */
    public void glValidateProgram(int program);
    
    /**
     * C function void glVertexAttrib1f(GLuint indx, GLfloat x)
     * 
     * @param indx GLuint indx
     * @param x GLfloat x
     */
    public void glVertexAttrib1f(int indx, float x);
    
    /**
     * C function void glVertexAttrib1fv(GLuint indx, const GLfloat *values)
     * 
     * @param indx GLuint indx
     * @param values const GLfloat *values
     */
    public void glVertexAttrib1fv(int indx, FloatBuffer values);
    
    /**
     * C function void glVertexAttrib2f(GLuint indx, GLfloat x, GLfloat y)
     * 
     * @param indx GLuint indx
     * @param x GLfloat x
     * @param y GLfloat y
     */
    public void glVertexAttrib2f(int indx, float x, float y);
    
    /**
     * C function void glVertexAttrib2fv(GLuint indx, const GLfloat *values)
     * 
     * @param indx GLuint indx
     * @param values const GLfloat *values
     */
    public void glVertexAttrib2fv(int indx, FloatBuffer values);
    
    /**
     * C function void glVertexAttrib3f(GLuint indx, GLfloat x, GLfloat y, GLfloat z)
     * 
     * @param indx GLuint indx
     * @param x GLfloat x
     * @param y GLfloat y
     * @param z GLfloat z
     */
    public void glVertexAttrib3f(int indx, float x, float y, float z);
    
    /**
     * C function void glVertexAttrib3fv(GLuint indx, const GLfloat *values)
     * 
     * @param indx GLuint indx
     * @param values const GLfloat *values
     */
    public void glVertexAttrib3fv(int indx, FloatBuffer values);
    
    /**
     * C function void glVertexAttrib4f(GLuint indx, GLfloat x, GLfloat y, GLfloat z, GLfloat w)
     * 
     * @param indx GLuint indx
     * @param x GLfloat x
     * @param y GLfloat y
     * @param z GLfloat z
     * @param w GLfloat w
     */
    public void glVertexAttrib4f(int indx, float x, float y, float z, float w);
    
    /**
     * C function void glVertexAttrib4fv(GLuint indx, const GLfloat *values)
     * 
     * @param indx GLuint indx
     * @param values const GLfloat *values
     */
    public void glVertexAttrib4fv(int indx, FloatBuffer values);
    
    /**
     * C function void glVertexAttribPointer(GLuint indx, GLint size, GLenum type, GLboolean normalized, GLsizei stride,
     * GLint offset)
     * 
     * @param indx GLuint indx
     * @param size GLint size
     * @param type GLenum type
     * @param normalized GLboolean normalized
     * @param stride GLsizei stride
     * @param offset GLint offset
     */
    public void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, int offset);
    
    /**
     * C function void glVertexAttribPointer(GLuint indx, GLint size, GLenum type, GLboolean normalized, GLsizei stride,
     * const GLvoid *ptr)
     * 
     * @param indx GLuint indx
     * @param size GLint size
     * @param type GLenum type
     * @param normalized GLboolean normalized
     * @param stride GLsizei stride
     * @param ptr const GLvoid *ptr
     */
    public void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, Buffer ptr);
    
    /**
     * C function void glViewport(GLint x, GLint y, GLsizei width, GLsizei height)
     * 
     * @param x GLint x
     * @param y GLint y
     * @param width GLsizei width
     * @param height GLsizei height
     */
    public void glViewport(int x, int y, int width, int height);
}
