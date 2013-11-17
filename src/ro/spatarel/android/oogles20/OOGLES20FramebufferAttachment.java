package ro.spatarel.android.oogles20;

import java.nio.IntBuffer;

/**
 * <p>Class grouping together the methods managing the {@link OpenGLES20#GL_COLOR_ATTACHMENT0}, {@link
 * OpenGLES20#GL_DEPTH_ATTACHMENT} or {@link OpenGLES20#GL_STENCIL_ATTACHMENT} targets.</p>
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
public class OOGLES20FramebufferAttachment {
    
    private OOFramebufferAttachmentPoint attachment;
    
    OOGLES20FramebufferAttachment(OOFramebufferAttachmentPoint attachment) {
        this.attachment = attachment;
    }
    
    /**
     * <p>Attach a renderbuffer object to a framebuffer object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glFramebufferRenderbuffer}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #attachRenderbuffer} attaches the renderbuffer specified by {@code renderbuffer} as one of the logical
     * buffers of the currently bound framebuffer object. A renderbuffer may not be attached to the default framebuffer
     * object name {@code null}.</p>
     * 
     * <p>If {@code renderbuffer} is not {@code null}, the value of {@link #getObjectType} for the specified attachment
     * point is set to {@link OOFramebufferAttachmentObjectType#RENDERBUFFER} and the value of {@link #getObject} is set
     * to renderbuffer. {@link #getTextureLevel} and {@link #getTextureCubeMapFace} are set to the default values {@code
     * 0} and {@link OOTextureCubeMapFace#POSITIVE_X}, respectively. Any previous attachment of the
     * currently bound framebuffer object is broken.</p>
     * 
     * <p>If {@code renderbuffer} is {@code null}, the current image, if any, is detached. The value of {@link
     * #getObjectType} is set to {@link OOFramebufferAttachmentObjectType#NONE}. The value of {@link #getObject} is set
     * to {@code null}. {@link #getTextureLevel} and {@link #getTextureCubeMapFace} are set to the default values {@code
     * null} and {@link OOTextureCubeMapFace#POSITIVE_X}, respectively.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If a renderbuffer object is deleted while its image is attached to the currently bound framebuffer, then it is
     * as if {@link OOGLES20FramebufferAttachment#attachRenderbuffer} had been called with a {@code renderbuffer} of
     * {@code null} for the attachment point to which this image was attached in the currently bound framebuffer object.
     * In other words, the renderbuffer image is detached from the currently bound framebuffer. Note that the
     * renderbuffer image is specifically not detached from any non-bound framebuffers. Detaching the image from any
     * non-bound framebuffers is the responsibility of the application.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if target is not GL_FRAMEBUFFER. -->
     *     <!-- GL_INVALID_ENUM is generated if renderbuffertarget is not GL_RENDERBUFFER and renderbuffer is not 0. -->
     *     <!-- GL_INVALID_ENUM is generated if attachment is not an accepted attachment point. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the default framebuffer object name {@code null} is
     *     bound.</li>
     *     <!-- GL_INVALID_OPERATION is generated if renderbuffer is neither 0 nor the name of an existing renderbuffer
     *     object. -->
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param renderbuffer Specifies the renderbuffer object that is to be attached.
     * 
     * @see OOGLES20Framebuffer#bind
     * @see OOGLES20Renderbuffer#bind
     * @see OOGLES20Framebuffer#checkStatus
     * @see OOFramebuffer#finalize
     * @see OORenderbuffer#finalize
     * @see #attachTextureImage2D
     * @see OOGLES20Renderbuffer#setStorage
     */
    public void attachRenderbuffer(OORenderbuffer renderbuffer) {
        if (renderbuffer == null) {
            OOGLES20.backEnd.glFramebufferRenderbuffer(OpenGLES20.GL_FRAMEBUFFER, this.attachment.getGLConstant(),
                    OpenGLES20.GL_RENDERBUFFER, 0);
        } else {
            OOGLES20.backEnd.glFramebufferRenderbuffer(OpenGLES20.GL_FRAMEBUFFER, this.attachment.getGLConstant(),
                    OpenGLES20.GL_RENDERBUFFER, renderbuffer.getHandle());
        }
    }
    
    /**
     * <p>Attach a texture image to a framebuffer object.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glFramebufferTexture2D}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #attachTextureImage2D} attaches the texture image specified by {@code texture} as one of the logical
     * buffers of the currently bound framebuffer object.</p>
     * 
     * <p>If {@code texture} is not {@code null}, the value of {@link #getObjectType} for the specified attachment point
     * is set to {@link OOFramebufferAttachmentObjectType#TEXTURE}, the value of {@link #getObject} is set to {@code
     * texture} and the value of {@link #getTextureLevel} is set to {@code 0}. If texture is a cube map texture, the
     * value of {@link #getTextureCubeMapFace} is set to {@code textureTarget}; otherwise it is set to the default value
     * {@link OOTextureCubeMapFace#POSITIVE_X}. Any previous attachment to the logical buffer of the currently bound
     * framebuffer object is broken.</p>
     * 
     * <p>If {@code texture} is {@code null}, the current image, if any, attached to the logical buffer of the currently
     * bound framebuffer object is detached. The value of {@link #getObjectType} is set to {@link
     * OOFramebufferAttachmentObjectType#NONE}. The value of {@link #getObject} is set to {@code null}. {@link
     * #getTextureLevel} and {@link #getTextureCubeMapFace} are set to the default values {@code null} and {@link
     * OOTextureCubeMapFace#POSITIVE_X}, respectively.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Special precautions need to be taken to avoid attaching a texture image to the currently bound framebuffer
     * while the texture object is currently bound and potentially sampled by the current vertex or fragment shader.
     * Doing so could lead to the creation of a "feedback loop" between the writing of pixels by rendering operations
     * and the simultaneous reading of those same pixels when used as texels in the currently bound texture. In this
     * scenario, the framebuffer will be considered framebuffer complete, but the values of fragments rendered while in
     * this state will be undefined. The values of texture samples may be undefined as well.</p>
     * 
     * <p>If a texture object is deleted while its image is attached to the currently bound framebuffer, then it is as
     * if {@link OOGLES20FramebufferAttachment#attachTextureImage2D} had been called with a {@code texture} of
     * {@code null} for the attachment point to which this image was attached in the currently bound framebuffer object.
     * In other words, the texture image is detached from the currently bound framebuffer. Note that the texture image
     * is specifically <i>not</i> detached from any non-bound framebuffers. Detaching the image from any non-bound
     * framebuffers is the responsibility of the application.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if target is not GL_FRAMEBUFFER. -->
     *     <!-- GL_INVALID_ENUM is generated if textarget is not an accepted texture target and texture is not 0. -->
     *     <!-- GL_INVALID_ENUM is generated if attachment is not an accepted attachment point. -->
     *     <!-- GL_INVALID_VALUE is generated if level is not 0 and texture is not 0. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the default framebuffer object name {@code null} is
     *     bound.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code texture} is neither {@code null} nor the name of
     *     an existing texture object.</li>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code texture} is the name of an existing
     *     two-dimensional texture object but {@code textureTarget} is not {@link OOTextureImageTarget#TEXTURE_2D} or if
     *     {@code texture} is the name of an existing cube map texture object but {@code textureTarget} is {@link
     *     OOTextureImageTarget#TEXTURE_2D}.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @param textureTarget Specifies the texture target.
     * @param texture Specifies the texture object whose image is to be attached.
     * 
     * @see OOGLES20Framebuffer#bind
     * @see OOGLES20Texture#bind
     * @see OOGLES20Framebuffer#checkStatus
     * @see OOFramebuffer#finalize
     * @see OOTexture#finalize
     * @see #attachRenderbuffer
     * @see OOGLES20Texture#generateMipmaps
     * @see OOGLES20TextureImage#setImage2D
     */
    public void attachTextureImage2D(OOTextureImageTarget textureTarget, OOTexture texture) {
        if (texture == null) {
            OOGLES20.backEnd.glFramebufferTexture2D(OpenGLES20.GL_FRAMEBUFFER, this.attachment.getGLConstant(),
                    textureTarget.getGLConstant(), 0, 0);
        } else {
            OOGLES20.backEnd.glFramebufferTexture2D(OpenGLES20.GL_FRAMEBUFFER, this.attachment.getGLConstant(),
                    textureTarget.getGLConstant(), texture.getHandle(), 0);
        }
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code attachRenderbuffer(null);}.</p>
     * 
     * @see #attachRenderbuffer
     */
    public void attachNone() {
        this.attachRenderbuffer(null);
    }
    
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(1);
    
    /**
     * <p>Returns the type of object which contains the attached image.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetFramebufferAttachmentParameteriv} with argument {@link
     * OpenGLES20#GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the type of object which contains the attached image. The initial value is {@link
     * OOFramebufferAttachmentObjectType#NONE}.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the default framebuffer object name {@code null} is
     *     bound.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return The type of object which contains the attached image.
     */
    public OOFramebufferAttachmentObjectType getObjectType() {
        OOGLES20.backEnd.glGetFramebufferAttachmentParameteriv(OpenGLES20.GL_FRAMEBUFFER,
                this.attachment.getGLConstant(), OpenGLES20.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE,
                OOGLES20FramebufferAttachment.intBuffer);
        return OOFramebufferAttachmentObjectType.valueOf(OOGLES20FramebufferAttachment.intBuffer.get(0));
    }
    
    /**
     * <p>If the value of {@link #getObjectType} is {@link OOFramebufferAttachmentObjectType#RENDERBUFFER}, returns the
     * name of the renderbuffer object which contains the attached image. If the value of {@link #getObjectType} is
     * {@link OOFramebufferAttachmentObjectType#TEXTURE}, returns the name of the texture object which contains the
     * attached image.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetFramebufferAttachmentParameteriv} with argument {@link
     * OpenGLES20#GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If the value of {@link #getObjectType} is {@link OOFramebufferAttachmentObjectType#RENDERBUFFER}, returns the
     * name of the renderbuffer object which contains the attached image. If the value of {@link #getObjectType} is
     * {@link OOFramebufferAttachmentObjectType#TEXTURE}, returns the name of the texture object which contains the
     * attached image. The initial value is zero.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the default framebuffer object name {@code null} is
     *     bound.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return If the value of {@link #getObjectType} is {@link OOFramebufferAttachmentObjectType#RENDERBUFFER}, returns
     * the name of the renderbuffer object which contains the attached image. If the value of {@link #getObjectType} is
     * {@link OOFramebufferAttachmentObjectType#TEXTURE}, returns the name of the texture object which contains the
     * attached image.
     */
    public OOFramebufferAttachmentObject getObject() {
        OOGLES20.backEnd.glGetFramebufferAttachmentParameteriv(OpenGLES20.GL_FRAMEBUFFER,
                this.attachment.getGLConstant(), OpenGLES20.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME,
                OOGLES20FramebufferAttachment.intBuffer);
        int handle = OOGLES20FramebufferAttachment.intBuffer.get(0);
        if (handle == 0) {
            return null;
        } else if (this.getObjectType() == OOFramebufferAttachmentObjectType.TEXTURE) {
            return OOTexture.getTexture(handle);
        } else {
            return OORenderbuffer.getRenderbuffer(handle);
        }
    }
    
    /**
     * <p>If the value of {@link #getObjectType} is {@link OOFramebufferAttachmentObjectType#TEXTURE}, returns the
     * mipmap level of the texture object which contains the attached image.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetFramebufferAttachmentParameteriv} with argument {@link
     * OpenGLES20#GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If the value of {@link #getObjectType} is {@link OOFramebufferAttachmentObjectType#TEXTURE}, returns the
     * mipmap level of the texture object which contains the attached image. The initial value is zero.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the default framebuffer object name {@code null} is
     *     bound.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return If the value of {@link #getObjectType} is {@link OOFramebufferAttachmentObjectType#TEXTURE}, returns the
     * mipmap level of the texture object which contains the attached image.
     */
    public int getTextureLevel() {
        OOGLES20.backEnd.glGetFramebufferAttachmentParameteriv(OpenGLES20.GL_FRAMEBUFFER,
                this.attachment.getGLConstant(), OpenGLES20.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL,
                OOGLES20FramebufferAttachment.intBuffer);
        return OOGLES20FramebufferAttachment.intBuffer.get(0);
    }
    
    /**
     * <p>If the value of {@link #getObjectType} is {@link OOFramebufferAttachmentObjectType#TEXTURE} and
     * {@link #getObject} is the name of a cube-map texture, returns the cube map face of the cube-map texture object
     * which contains the attached image.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetFramebufferAttachmentParameteriv} with argument {@link
     * OpenGLES20#GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If the value of {@link #getObjectType} is {@link OOFramebufferAttachmentObjectType#TEXTURE} and
     * {@link #getObject} is the name of a cube-map texture, returns the cube map face of the cube-map texture object
     * which contains the attached image. If the attached image is from a texture object but not a cube-map, returns
     * {@code null}. The initial value is {@link OOTextureCubeMapFace#POSITIVE_X}.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if the default framebuffer object name {@code null} is
     *     bound.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @return If the value of {@link #getObjectType} is {@link OOFramebufferAttachmentObjectType#TEXTURE} and {@link
     * #getObject} is the name of a cube-map texture, returns the cube map face of the cube-map texture object which
     * contains the attached image. If the attached image is from a texture object but not a cube-map, returns {@code
     * null}.
     */
    public OOTextureCubeMapFace getTextureCubeMapFace() {
        OOGLES20.backEnd.glGetFramebufferAttachmentParameteriv(OpenGLES20.GL_FRAMEBUFFER,
                this.attachment.getGLConstant(), OpenGLES20.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE,
                OOGLES20FramebufferAttachment.intBuffer);
        return OOTextureCubeMapFace.valueOf(OOGLES20FramebufferAttachment.intBuffer.get(0));
    }
}
