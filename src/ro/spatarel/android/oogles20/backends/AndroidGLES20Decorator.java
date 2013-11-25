package ro.spatarel.android.oogles20.backends;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import ro.spatarel.android.oogles20.OpenGLES20;

/**
 * <p>Abstract class implementing the {@link OpenGLES20}; the partial implementation is the Decorator component of the
 * decorator pattern. The decorator is calling the following abstract methods:</p>
 * 
 * <ul>
 *     <li>{@link #call} before the execution of every {@link OpenGLES20} method call;</li>
 *     <li>{@link #before} before the execution of every {@link OpenGLES20} method call;</li>
 *     <li>{@link #after} after the execution of every {@link OpenGLES20} method call.</li>
 * </ul>
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
public abstract class AndroidGLES20Decorator implements OpenGLES20 {
    /**
     * <p>Instance of the decorated {@link OpenGLES20} object.</p>
     */
    protected final OpenGLES20 base;
    
    /**
     * <p>Abstract method called before the execution of every {@link OpenGLES20} method call.</p>
     */
    protected abstract void before();
    
    /**
     * <p>Abstract method called after the execution of every {@link OpenGLES20} method call.</p>
     */
    protected abstract void after();
    
    /**
     * <p>Abstract method called before the execution of every {@link OpenGLES20} method call.</p>
     * 
     * @param methodName the name of the method called
     * @param arguments the arguments used to call the method
     */
    protected abstract void call(String methodName, Object[] arguments);
    
    /**
     * <p>Creates a generic decorator for a specified {@link OpenGLES20} object.</p>
     * 
     * @param base The decorated {@link OpenGLES20} object.
     */
    protected AndroidGLES20Decorator(OpenGLES20 base) {
        this.base = base;
    }
    
    @Override
    public void glActiveTexture(int texture) {
        this.call("glActiveTexture", new Object[] {texture});
        this.before();
        this.base.glActiveTexture(texture);
        this.after();
    }

    @Override
    public void glAttachShader(int program, int shader) {
        this.call("glAttachShader", new Object[] {program, shader});
        this.before();
        this.base.glAttachShader(program, shader);
        this.after();
    }

    @Override
    public void glBindAttribLocation(int program, int index, String name) {
        this.call("glBindAttribLocation", new Object[] {program, index, name});
        this.before();
        this.base.glBindAttribLocation(program, index, name);
        this.after();
    }

    @Override
    public void glBindBuffer(int target, int buffer) {
        this.call("glBindBuffer", new Object[] {target, buffer});
        this.before();
        this.base.glBindBuffer(target, buffer);
        this.after();
    }

    @Override
    public void glBindFramebuffer(int target, int framebuffer) {
        this.call("glBindFramebuffer", new Object[] {target, framebuffer});
        this.before();
        this.base.glBindFramebuffer(target, framebuffer);
        this.after();
    }

    @Override
    public void glBindRenderbuffer(int target, int renderbuffer) {
        this.call("glBindRenderbuffer", new Object[] {target, renderbuffer});
        this.before();
        this.base.glBindRenderbuffer(target, renderbuffer);
        this.after();
    }

    @Override
    public void glBindTexture(int target, int texture) {
        this.call("glBindTexture", new Object[] {target, texture});
        this.before();
        this.base.glBindTexture(target, texture);
        this.after();
    }

    @Override
    public void glBlendColor(float red, float green, float blue, float alpha) {
        this.call("glBlendColor", new Object[] {red, green, blue, alpha});
        this.before();
        this.base.glBlendColor(red, green, blue, alpha);
        this.after();
    }

    @Override
    public void glBlendEquation(int mode) {
        this.call("glBlendEquation", new Object[] {mode});
        this.before();
        this.base.glBlendEquation(mode);
        this.after();
    }

    @Override
    public void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
        this.call("glBlendEquationSeparate", new Object[] {modeRGB, modeAlpha});
        this.before();
        this.base.glBlendEquationSeparate(modeRGB, modeAlpha);
        this.after();
    }

    @Override
    public void glBlendFunc(int sfactor, int dfactor) {
        this.call("glBlendFunc", new Object[] {sfactor, dfactor});
        this.before();
        this.base.glBlendFunc(sfactor, dfactor);
        this.after();
    }

    @Override
    public void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
        this.call("glBlendFuncSeparate", new Object[] {srcRGB, dstRGB, srcAlpha, dstAlpha});
        this.before();
        this.base.glBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
        this.after();
    }

    @Override
    public void glBufferData(int target, int size, Buffer data, int usage) {
        this.call("glBufferData", new Object[] {target, size, data, usage});
        this.before();
        this.base.glBufferData(target, size, data, usage);
        this.after();
    }

    @Override
    public void glBufferSubData(int target, int offset, int size, Buffer data) {
        this.call("glBufferSubData", new Object[] {target, offset, size, data});
        this.before();
        this.base.glBufferSubData(target, offset, size, data);
        this.after();
    }

    @Override
    public int glCheckFramebufferStatus(int target) {
        this.call("glCheckFramebufferStatus", new Object[] {target});
        this.before();
        int answer = this.base.glCheckFramebufferStatus(target);
        this.after();
        return answer;
    }

    @Override
    public void glClear(int mask) {
        this.call("glClear", new Object[] {mask});
        this.before();
        this.base.glClear(mask);
        this.after();
    }

    @Override
    public void glClearColor(float red, float green, float blue, float alpha) {
        this.call("glClearColor", new Object[] {red, green, blue, alpha});
        this.before();
        this.base.glClearColor(red, green, blue, alpha);
        this.after();
    }

    @Override
    public void glClearDepthf(float depth) {
        this.call("glClearDepthf", new Object[] {depth});
        this.before();
        this.base.glClearDepthf(depth);
        this.after();
    }

    @Override
    public void glClearStencil(int s) {
        this.call("glClearStencil", new Object[] {s});
        this.before();
        this.base.glClearStencil(s);
        this.after();
    }

    @Override
    public void glColorMask(boolean red, boolean green, boolean blue, boolean alpha) {
        this.call("glColorMask", new Object[] {red, green, blue, alpha});
        this.before();
        this.base.glColorMask(red, green, blue, alpha);
        this.after();
    }

    @Override
    public void glCompileShader(int shader) {
        this.call("glCompileShader", new Object[] {shader});
        this.before();
        this.base.glCompileShader(shader);
        this.after();
    }

    @Override
    public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, Buffer data) {
        this.call("glCompressedTexImage2D", new Object[] {target, level, internalformat, width, height, border, imageSize, data});
        this.before();
        this.base.glCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data);
        this.after();
    }

    @Override
    public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Buffer data) {
        this.call("glCompressedTexSubImage2D", new Object[] {target, level, xoffset, yoffset, width, height, format, imageSize, data});
        this.before();
        this.base.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data);
        this.after();
    }

    @Override
    public void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border) {
        this.call("glCopyTexImage2D", new Object[] {target, level, internalformat, x, y, width, height, border});
        this.before();
        this.base.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border);
        this.after();
    }

    @Override
    public void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
        this.call("glCopyTexSubImage2D", new Object[] {target, level, xoffset, yoffset, x, y, width, height});
        this.before();
        this.base.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
        this.after();
    }

    @Override
    public int glCreateProgram() {
        this.call("glCreateProgram", new Object[] {});
        this.before();
        int answer = this.base.glCreateProgram();
        this.after();
        return answer;
    }

    @Override
    public int glCreateShader(int type) {
        this.call("glCreateShader", new Object[] {type});
        this.before();
        int answer = this.base.glCreateShader(type);
        this.after();
        return answer;
    }

    @Override
    public void glCullFace(int mode) {
        this.call("glCullFace", new Object[] {mode});
        this.before();
        this.base.glCullFace(mode);
        this.after();
    }

    @Override
    public void glDeleteBuffers(int n, IntBuffer buffers) {
        this.call("glDeleteBuffers", new Object[] {n, buffers});
        this.before();
        this.base.glDeleteBuffers(n, buffers);
        this.after();
    }

    @Override
    public void glDeleteFramebuffers(int n, IntBuffer framebuffers) {
        this.call("glDeleteFramebuffers", new Object[] {n, framebuffers});
        this.before();
        this.base.glDeleteFramebuffers(n, framebuffers);
        this.after();
    }

    @Override
    public void glDeleteProgram(int program) {
        this.call("glDeleteProgram", new Object[] {program});
        this.before();
        this.base.glDeleteProgram(program);
        this.after();
    }

    @Override
    public void glDeleteRenderbuffers(int n, IntBuffer renderbuffers) {
        this.call("glDeleteRenderbuffers", new Object[] {n, renderbuffers});
        this.before();
        this.base.glDeleteRenderbuffers(n, renderbuffers);
        this.after();
    }

    @Override
    public void glDeleteShader(int shader) {
        this.call("glDeleteShader", new Object[] {shader});
        this.before();
        this.base.glDeleteShader(shader);
        this.after();
    }

    @Override
    public void glDeleteTextures(int n, IntBuffer textures) {
        this.call("glDeleteTextures", new Object[] {n, textures});
        this.before();
        this.base.glDeleteTextures(n, textures);
        this.after();
    }

    @Override
    public void glDepthFunc(int func) {
        this.call("glDepthFunc", new Object[] {func});
        this.before();
        this.base.glDepthFunc(func);
        this.after();
    }

    @Override
    public void glDepthMask(boolean flag) {
        this.call("glDepthMask", new Object[] {flag});
        this.before();
        this.base.glDepthMask(flag);
        this.after();
    }

    @Override
    public void glDepthRangef(float zNear, float zFar) {
        this.call("glDepthRangef", new Object[] {zNear, zFar});
        this.before();
        this.base.glDepthRangef(zNear, zFar);
        this.after();
    }

    @Override
    public void glDetachShader(int program, int shader) {
        this.call("glDetachShader", new Object[] {program, shader});
        this.before();
        this.base.glDetachShader(program, shader);
        this.after();
    }

    @Override
    public void glDisable(int cap) {
        this.call("glDisable", new Object[] {cap});
        this.before();
        this.base.glDisable(cap);
        this.after();
    }

    @Override
    public void glDisableVertexAttribArray(int index) {
        this.call("glDisableVertexAttribArray", new Object[] {index});
        this.before();
        this.base.glDisableVertexAttribArray(index);
        this.after();
    }

    @Override
    public void glDrawArrays(int mode, int first, int count) {
        this.call("glDrawArrays", new Object[] {mode, first, count});
        this.before();
        this.base.glDrawArrays(mode, first, count);
        this.after();
    }

    @Override
    public void glDrawElements(int mode, int count, int type, int offset) {
        this.call("glDrawElements", new Object[] {mode, count, type, offset});
        this.before();
        this.base.glDrawElements(mode, count, type, offset);
        this.after();
    }

    @Override
    public void glDrawElements(int mode, int count, int type, Buffer indices) {
        this.call("glDrawElements", new Object[] {mode, count, type, indices});
        this.before();
        this.base.glDrawElements(mode, count, type, indices);
        this.after();
    }

    @Override
    public void glEnable(int cap) {
        this.call("glEnable", new Object[] {cap});
        this.before();
        this.base.glEnable(cap);
        this.after();
    }

    @Override
    public void glEnableVertexAttribArray(int index) {
        this.call("glEnableVertexAttribArray", new Object[] {index});
        this.before();
        this.base.glEnableVertexAttribArray(index);
        this.after();
    }

    @Override
    public void glFinish() {
        this.call("glFinish", new Object[] {});
        this.before();
        this.base.glFinish();
        this.after();
    }

    @Override
    public void glFlush() {
        this.call("glFlush", new Object[] {});
        this.before();
        this.base.glFlush();
        this.after();
    }

    @Override
    public void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
        this.call("glFramebufferRenderbuffer", new Object[] {target, attachment, renderbuffertarget, renderbuffer});
        this.before();
        this.base.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
        this.after();
    }

    @Override
    public void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
        this.call("glFramebufferTexture2D", new Object[] {target, attachment, textarget, texture, level});
        this.before();
        this.base.glFramebufferTexture2D(target, attachment, textarget, texture, level);
        this.after();
    }

    @Override
    public void glFrontFace(int mode) {
        this.call("glFrontFace", new Object[] {mode});
        this.before();
        this.base.glFrontFace(mode);
        this.after();
    }

    @Override
    public void glGenBuffers(int n, IntBuffer buffers) {
        this.call("glGenBuffers", new Object[] {n, buffers});
        this.before();
        this.base.glGenBuffers(n, buffers);
        this.after();
    }

    @Override
    public void glGenerateMipmap(int target) {
        this.call("glGenerateMipmap", new Object[] {target});
        this.before();
        this.base.glGenerateMipmap(target);
        this.after();
    }

    @Override
    public void glGenFramebuffers(int n, IntBuffer framebuffers) {
        this.call("glGenFramebuffers", new Object[] {n, framebuffers});
        this.before();
        this.base.glGenFramebuffers(n, framebuffers);
        this.after();
    }

    @Override
    public void glGenRenderbuffers(int n, IntBuffer renderbuffers) {
        this.call("glGenRenderbuffers", new Object[] {n, renderbuffers});
        this.before();
        this.base.glGenRenderbuffers(n, renderbuffers);
        this.after();
    }

    @Override
    public void glGenTextures(int n, IntBuffer textures) {
        this.call("glGenTextures", new Object[] {n, textures});
        this.before();
        this.base.glGenTextures(n, textures);
        this.after();
    }

    @Override
    public void glGetActiveAttrib(int program, int index, int bufsize, int[] length, int lengthOffset, int[] size, int sizeOffset, int[] type, int typeOffset, byte[] name, int nameOffset) {
        this.call("glGetActiveAttrib", new Object[] {program, index, bufsize, length, lengthOffset, size, sizeOffset, type, typeOffset, name, nameOffset});
        this.before();
        this.base.glGetActiveAttrib(program, index, bufsize, length, lengthOffset, size, sizeOffset, type, typeOffset, name, nameOffset);
        this.after();
    }

    @Override
    public void glGetActiveUniform(int program, int index, int bufsize, int[] length, int lengthOffset, int[] size, int sizeOffset, int[] type, int typeOffset, byte[] name, int nameOffset) {
        this.call("glGetActiveUniform", new Object[] {program, index, bufsize, length, lengthOffset, size, sizeOffset, type, typeOffset, name, nameOffset});
        this.before();
        this.base.glGetActiveUniform(program, index, bufsize, length, lengthOffset, size, sizeOffset, type, typeOffset, name, nameOffset);
        this.after();
    }

    @Override
    public void glGetAttachedShaders(int program, int maxcount, IntBuffer count, IntBuffer shaders) {
        this.call("glGetAttachedShaders", new Object[] {program, maxcount, count, shaders});
        this.before();
        this.base.glGetAttachedShaders(program, maxcount, count, shaders);
        this.after();
    }

    @Override
    public int glGetAttribLocation(int program, String name) {
        this.call("glGetAttribLocation", new Object[] {program, name});
        this.before();
        int answer = this.base.glGetAttribLocation(program, name);
        this.after();
        return answer;
    }

    @Override
    public void glGetBooleanv(int pname, IntBuffer params) {
        this.call("glGetBooleanv", new Object[] {pname, params});
        this.before();
        this.base.glGetBooleanv(pname, params);
        this.after();
    }

    @Override
    public void glGetBufferParameteriv(int target, int pname, IntBuffer params) {
        this.call("glGetBufferParameteriv", new Object[] {target, pname, params});
        this.before();
        this.base.glGetBufferParameteriv(target, pname, params);
        this.after();
    }

    @Override
    public int glGetError() {
        this.call("glGetError", new Object[] {});
        this.before();
        int answer = this.base.glGetError();
        this.after();
        return answer;
    }

    @Override
    public void glGetFloatv(int pname, FloatBuffer params) {
        this.call("glGetFloatv", new Object[] {pname, params});
        this.before();
        this.base.glGetFloatv(pname, params);
        this.after();
    }

    @Override
    public void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, IntBuffer params) {
        this.call("glGetFramebufferAttachmentParameteriv", new Object[] {target, attachment, pname, params});
        this.before();
        this.base.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
        this.after();
    }

    @Override
    public void glGetIntegerv(int pname, IntBuffer params) {
        this.call("glGetIntegerv", new Object[] {pname, params});
        this.before();
        this.base.glGetIntegerv(pname, params);
        this.after();
    }

    @Override
    public void glGetProgramiv(int program, int pname, IntBuffer params) {
        this.call("glGetProgramiv", new Object[] {program, pname, params});
        this.before();
        this.base.glGetProgramiv(program, pname, params);
        this.after();
    }

    @Override
    public String glGetProgramInfoLog(int program) {
        this.call("glGetProgramInfoLog", new Object[] {program});
        this.before();
        String answer = this.base.glGetProgramInfoLog(program);
        this.after();
        return answer;
    }

    @Override
    public void glGetRenderbufferParameteriv(int target, int pname, IntBuffer params) {
        this.call("glGetRenderbufferParameteriv", new Object[] {target, pname, params});
        this.before();
        this.base.glGetRenderbufferParameteriv(target, pname, params);
        this.after();
    }

    @Override
    public void glGetShaderiv(int shader, int pname, IntBuffer params) {
        this.call("glGetShaderiv", new Object[] {shader, pname, params});
        this.before();
        this.base.glGetShaderiv(shader, pname, params);
        this.after();
    }

    @Override
    public String glGetShaderInfoLog(int shader) {
        this.call("glGetShaderInfoLog", new Object[] {shader});
        this.before();
        String answer = this.base.glGetShaderInfoLog(shader);
        this.after();
        return answer;
    }

    @Override
    public void glGetShaderPrecisionFormat(int shadertype, int precisiontype, IntBuffer range, IntBuffer precision) {
        this.call("glGetShaderPrecisionFormat", new Object[] {shadertype, precisiontype, range, precision});
        this.before();
        this.base.glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
        this.after();
    }

    @Override
    public void glGetShaderSource(int shader, int bufsize, int[] length, int lengthOffset, byte[] source, int sourceOffset) {
        this.call("glGetShaderSource", new Object[] {shader, bufsize, length, lengthOffset, source, sourceOffset});
        this.before();
        this.base.glGetShaderSource(shader, bufsize, length, lengthOffset, source, sourceOffset);
        this.after();
    }

    @Override
    public String glGetString(int name) {
        this.call("glGetString", new Object[] {name});
        this.before();
        String answer = this.base.glGetString(name);
        this.after();
        return answer;
    }

    @Override
    public void glGetTexParameterfv(int target, int pname, FloatBuffer params) {
        this.call("glGetTexParameterfv", new Object[] {target, pname, params});
        this.before();
        this.base.glGetTexParameterfv(target, pname, params);
        this.after();
    }

    @Override
    public void glGetTexParameteriv(int target, int pname, IntBuffer params) {
        this.call("glGetTexParameteriv", new Object[] {target, pname, params});
        this.before();
        this.base.glGetTexParameteriv(target, pname, params);
        this.after();
    }

    @Override
    public void glGetUniformfv(int program, int location, FloatBuffer params) {
        this.call("glGetUniformfv", new Object[] {program, location, params});
        this.before();
        this.base.glGetUniformfv(program, location, params);
        this.after();
    }

    @Override
    public void glGetUniformiv(int program, int location, IntBuffer params) {
        this.call("glGetUniformiv", new Object[] {program, location, params});
        this.before();
        this.base.glGetUniformiv(program, location, params);
        this.after();
    }

    @Override
    public int glGetUniformLocation(int program, String name) {
        this.call("glGetUniformLocation", new Object[] {program, name});
        this.before();
        int answer = this.base.glGetUniformLocation(program, name);
        this.after();
        return answer;
    }

    @Override
    public void glGetVertexAttribfv(int index, int pname, FloatBuffer params) {
        this.call("glGetVertexAttribfv", new Object[] {index, pname, params});
        this.before();
        this.base.glGetVertexAttribfv(index, pname, params);
        this.after();
    }

    @Override
    public void glGetVertexAttribiv(int index, int pname, IntBuffer params) {
        this.call("glGetVertexAttribiv", new Object[] {index, pname, params});
        this.before();
        this.base.glGetVertexAttribiv(index, pname, params);
        this.after();
    }

    @Override
    public void glHint(int target, int mode) {
        this.call("glHint", new Object[] {target, mode});
        this.before();
        this.base.glHint(target, mode);
        this.after();
    }

    @Override
    public boolean glIsBuffer(int buffer) {
        this.call("glIsBuffer", new Object[] {buffer});
        this.before();
        boolean answer = this.base.glIsBuffer(buffer);
        this.after();
        return answer;
    }

    @Override
    public boolean glIsEnabled(int cap) {
        this.call("glIsEnabled", new Object[] {cap});
        this.before();
        boolean answer = this.base.glIsEnabled(cap);
        this.after();
        return answer;
    }

    @Override
    public boolean glIsFramebuffer(int framebuffer) {
        this.call("glIsFramebuffer", new Object[] {framebuffer});
        this.before();
        boolean answer = this.base.glIsFramebuffer(framebuffer);
        this.after();
        return answer;
    }

    @Override
    public boolean glIsProgram(int program) {
        this.call("glIsProgram", new Object[] {program});
        this.before();
        boolean answer = this.base.glIsProgram(program);
        this.after();
        return answer;
    }

    @Override
    public boolean glIsRenderbuffer(int renderbuffer) {
        this.call("glIsRenderbuffer", new Object[] {renderbuffer});
        this.before();
        boolean answer = this.base.glIsRenderbuffer(renderbuffer);
        this.after();
        return answer;
    }

    @Override
    public boolean glIsShader(int shader) {
        this.call("glIsShader", new Object[] {shader});
        this.before();
        boolean answer = this.base.glIsShader(shader);
        this.after();
        return answer;
    }

    @Override
    public boolean glIsTexture(int texture) {
        this.call("glIsTexture", new Object[] {texture});
        this.before();
        boolean answer = this.base.glIsTexture(texture);
        this.after();
        return answer;
    }

    @Override
    public void glLineWidth(float width) {
        this.call("glLineWidth", new Object[] {width});
        this.before();
        this.base.glLineWidth(width);
        this.after();
    }

    @Override
    public void glLinkProgram(int program) {
        this.call("glLinkProgram", new Object[] {program});
        this.before();
        this.base.glLinkProgram(program);
        this.after();
    }

    @Override
    public void glPixelStorei(int pname, int param) {
        this.call("glPixelStorei", new Object[] {pname, param});
        this.before();
        this.base.glPixelStorei(pname, param);
        this.after();
    }

    @Override
    public void glPolygonOffset(float factor, float units) {
        this.call("glPolygonOffset", new Object[] {factor, units});
        this.before();
        this.base.glPolygonOffset(factor, units);
        this.after();
    }

    @Override
    public void glReadPixels(int x, int y, int width, int height, int format, int type, Buffer pixels) {
        this.call("glReadPixels", new Object[] {x, y, width, height, format, type, pixels});
        this.before();
        this.base.glReadPixels(x, y, width, height, format, type, pixels);
        this.after();
    }

    @Override
    public void glReleaseShaderCompiler() {
        this.call("glReleaseShaderCompiler", new Object[] {});
        this.before();
        this.base.glReleaseShaderCompiler();
        this.after();
    }

    @Override
    public void glRenderbufferStorage(int target, int internalformat, int width, int height) {
        this.call("glRenderbufferStorage", new Object[] {target, internalformat, width, height});
        this.before();
        this.base.glRenderbufferStorage(target, internalformat, width, height);
        this.after();
    }

    @Override
    public void glSampleCoverage(float value, boolean invert) {
        this.call("glSampleCoverage", new Object[] {value, invert});
        this.before();
        this.base.glSampleCoverage(value, invert);
        this.after();
    }

    @Override
    public void glScissor(int x, int y, int width, int height) {
        this.call("glScissor", new Object[] {x, y, width, height});
        this.before();
        this.base.glScissor(x, y, width, height);
        this.after();
    }

    @Override
    public void glShaderBinary(int n, IntBuffer shaders, int binaryformat, Buffer binary, int length) {
        this.call("glShaderBinary", new Object[] {n, shaders, binaryformat, binary, length});
        this.before();
        this.base.glShaderBinary(n, shaders, binaryformat, binary, length);
        this.after();
    }

    @Override
    public void glShaderSource(int shader, String string) {
        this.call("glShaderSource", new Object[] {shader, string});
        this.before();
        this.base.glShaderSource(shader, string);
        this.after();
    }

    @Override
    public void glStencilFunc(int func, int ref, int mask) {
        this.call("glStencilFunc", new Object[] {func, ref, mask});
        this.before();
        this.base.glStencilFunc(func, ref, mask);
        this.after();
    }

    @Override
    public void glStencilFuncSeparate(int face, int func, int ref, int mask) {
        this.call("glStencilFuncSeparate", new Object[] {face, func, ref, mask});
        this.before();
        this.base.glStencilFuncSeparate(face, func, ref, mask);
        this.after();
    }

    @Override
    public void glStencilMask(int mask) {
        this.call("glStencilMask", new Object[] {mask});
        this.before();
        this.base.glStencilMask(mask);
        this.after();
    }

    @Override
    public void glStencilMaskSeparate(int face, int mask) {
        this.call("glStencilMaskSeparate", new Object[] {face, mask});
        this.before();
        this.base.glStencilMaskSeparate(face, mask);
        this.after();
    }

    @Override
    public void glStencilOp(int fail, int zfail, int zpass) {
        this.call("glStencilOp", new Object[] {fail, zfail, zpass});
        this.before();
        this.base.glStencilOp(fail, zfail, zpass);
        this.after();
    }

    @Override
    public void glStencilOpSeparate(int face, int fail, int zfail, int zpass) {
        this.call("glStencilOpSeparate", new Object[] {face, fail, zfail, zpass});
        this.before();
        this.base.glStencilOpSeparate(face, fail, zfail, zpass);
        this.after();
    }

    @Override
    public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, Buffer pixels) {
        this.call("glTexImage2D", new Object[] {target, level, internalformat, width, height, border, format, type, pixels});
        this.before();
        this.base.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
        this.after();
    }

    @Override
    public void glTexParameterf(int target, int pname, float param) {
        this.call("glTexParameterf", new Object[] {target, pname, param});
        this.before();
        this.base.glTexParameterf(target, pname, param);
        this.after();
    }

    @Override
    public void glTexParameterfv(int target, int pname, FloatBuffer params) {
        this.call("glTexParameterfv", new Object[] {target, pname, params});
        this.before();
        this.base.glTexParameterfv(target, pname, params);
        this.after();
    }

    @Override
    public void glTexParameteri(int target, int pname, int param) {
        this.call("glTexParameteri", new Object[] {target, pname, param});
        this.before();
        this.base.glTexParameteri(target, pname, param);
        this.after();
    }

    @Override
    public void glTexParameteriv(int target, int pname, IntBuffer params) {
        this.call("glTexParameteriv", new Object[] {target, pname, params});
        this.before();
        this.base.glTexParameteriv(target, pname, params);
        this.after();
    }

    @Override
    public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, Buffer pixels) {
        this.call("glTexSubImage2D", new Object[] {target, level, xoffset, yoffset, width, height, format, type, pixels});
        this.before();
        this.base.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
        this.after();
    }

    @Override
    public void glUniform1f(int location, float x) {
        this.call("glUniform1f", new Object[] {location, x});
        this.before();
        this.base.glUniform1f(location, x);
        this.after();
    }

    @Override
    public void glUniform1fv(int location, int count, FloatBuffer v) {
        this.call("glUniform1fv", new Object[] {location, count, v});
        this.before();
        this.base.glUniform1fv(location, count, v);
        this.after();
    }

    @Override
    public void glUniform1i(int location, int x) {
        this.call("glUniform1i", new Object[] {location, x});
        this.before();
        this.base.glUniform1i(location, x);
        this.after();
    }

    @Override
    public void glUniform1iv(int location, int count, IntBuffer v) {
        this.call("glUniform1iv", new Object[] {location, count, v});
        this.before();
        this.base.glUniform1iv(location, count, v);
        this.after();
    }

    @Override
    public void glUniform2f(int location, float x, float y) {
        this.call("glUniform2f", new Object[] {location, x, y});
        this.before();
        this.base.glUniform2f(location, x, y);
        this.after();
    }

    @Override
    public void glUniform2fv(int location, int count, FloatBuffer v) {
        this.call("glUniform2fv", new Object[] {location, count, v});
        this.before();
        this.base.glUniform2fv(location, count, v);
        this.after();
    }

    @Override
    public void glUniform2i(int location, int x, int y) {
        this.call("glUniform2i", new Object[] {location, x, y});
        this.before();
        this.base.glUniform2i(location, x, y);
        this.after();
    }

    @Override
    public void glUniform2iv(int location, int count, IntBuffer v) {
        this.call("glUniform2iv", new Object[] {location, count, v});
        this.before();
        this.base.glUniform2iv(location, count, v);
        this.after();
    }

    @Override
    public void glUniform3f(int location, float x, float y, float z) {
        this.call("glUniform3f", new Object[] {location, x, y, z});
        this.before();
        this.base.glUniform3f(location, x, y, z);
        this.after();
    }

    @Override
    public void glUniform3fv(int location, int count, FloatBuffer v) {
        this.call("glUniform3fv", new Object[] {location, count, v});
        this.before();
        this.base.glUniform3fv(location, count, v);
        this.after();
    }

    @Override
    public void glUniform3i(int location, int x, int y, int z) {
        this.call("glUniform3i", new Object[] {location, x, y, z});
        this.before();
        this.base.glUniform3i(location, x, y, z);
        this.after();
    }

    @Override
    public void glUniform3iv(int location, int count, IntBuffer v) {
        this.call("glUniform3iv", new Object[] {location, count, v});
        this.before();
        this.base.glUniform3iv(location, count, v);
        this.after();
    }

    @Override
    public void glUniform4f(int location, float x, float y, float z, float w) {
        this.call("glUniform4f", new Object[] {location, x, y, z, w});
        this.before();
        this.base.glUniform4f(location, x, y, z, w);
        this.after();
    }

    @Override
    public void glUniform4fv(int location, int count, FloatBuffer v) {
        this.call("glUniform4fv", new Object[] {location, count, v});
        this.before();
        this.base.glUniform4fv(location, count, v);
        this.after();
    }

    @Override
    public void glUniform4i(int location, int x, int y, int z, int w) {
        this.call("glUniform4i", new Object[] {location, x, y, z, w});
        this.before();
        this.base.glUniform4i(location, x, y, z, w);
        this.after();
    }

    @Override
    public void glUniform4iv(int location, int count, IntBuffer v) {
        this.call("glUniform4iv", new Object[] {location, count, v});
        this.before();
        this.base.glUniform4iv(location, count, v);
        this.after();
    }

    @Override
    public void glUniformMatrix2fv(int location, int count, boolean transpose, FloatBuffer value) {
        this.call("glUniformMatrix2fv", new Object[] {location, count, transpose, value});
        this.before();
        this.base.glUniformMatrix2fv(location, count, transpose, value);
        this.after();
    }

    @Override
    public void glUniformMatrix3fv(int location, int count, boolean transpose, FloatBuffer value) {
        this.call("glUniformMatrix3fv", new Object[] {location, count, transpose, value});
        this.before();
        this.base.glUniformMatrix3fv(location, count, transpose, value);
        this.after();
    }

    @Override
    public void glUniformMatrix4fv(int location, int count, boolean transpose, FloatBuffer value) {
        this.call("glUniformMatrix4fv", new Object[] {location, count, transpose, value});
        this.before();
        this.base.glUniformMatrix4fv(location, count, transpose, value);
        this.after();
    }

    @Override
    public void glUseProgram(int program) {
        this.call("glUseProgram", new Object[] {program});
        this.before();
        this.base.glUseProgram(program);
        this.after();
    }

    @Override
    public void glValidateProgram(int program) {
        this.call("glValidateProgram", new Object[] {program});
        this.before();
        this.base.glValidateProgram(program);
        this.after();
    }

    @Override
    public void glVertexAttrib1f(int indx, float x) {
        this.call("glVertexAttrib1f", new Object[] {indx, x});
        this.before();
        this.base.glVertexAttrib1f(indx, x);
        this.after();
    }

    @Override
    public void glVertexAttrib1fv(int indx, FloatBuffer values) {
        this.call("glVertexAttrib1fv", new Object[] {indx, values});
        this.before();
        this.base.glVertexAttrib1fv(indx, values);
        this.after();
    }

    @Override
    public void glVertexAttrib2f(int indx, float x, float y) {
        this.call("glVertexAttrib2f", new Object[] {indx, x, y});
        this.before();
        this.base.glVertexAttrib2f(indx, x, y);
        this.after();
    }

    @Override
    public void glVertexAttrib2fv(int indx, FloatBuffer values) {
        this.call("glVertexAttrib2fv", new Object[] {indx, values});
        this.before();
        this.base.glVertexAttrib2fv(indx, values);
        this.after();
    }

    @Override
    public void glVertexAttrib3f(int indx, float x, float y, float z) {
        this.call("glVertexAttrib3f", new Object[] {indx, x, y, z});
        this.before();
        this.base.glVertexAttrib3f(indx, x, y, z);
        this.after();
    }

    @Override
    public void glVertexAttrib3fv(int indx, FloatBuffer values) {
        this.call("glVertexAttrib3fv", new Object[] {indx, values});
        this.before();
        this.base.glVertexAttrib3fv(indx, values);
        this.after();
    }

    @Override
    public void glVertexAttrib4f(int indx, float x, float y, float z, float w) {
        this.call("glVertexAttrib4f", new Object[] {indx, x, y, z, w});
        this.before();
        this.base.glVertexAttrib4f(indx, x, y, z, w);
        this.after();
    }

    @Override
    public void glVertexAttrib4fv(int indx, FloatBuffer values) {
        this.call("glVertexAttrib4fv", new Object[] {indx, values});
        this.before();
        this.base.glVertexAttrib4fv(indx, values);
        this.after();
    }

    @Override
    public void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, int offset) {
        this.call("glVertexAttribPointer", new Object[] {indx, size, type, normalized, stride, offset});
        this.before();
        this.base.glVertexAttribPointer(indx, size, type, normalized, stride, offset);
        this.after();
    }

    @Override
    public void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, Buffer ptr) {
        this.call("glVertexAttribPointer", new Object[] {indx, size, type, normalized, stride, ptr});
        this.before();
        this.base.glVertexAttribPointer(indx, size, type, normalized, stride, ptr);
        this.after();
    }

    @Override
    public void glViewport(int x, int y, int width, int height) {
        this.call("glViewport", new Object[] {x, y, width, height});
        this.before();
        this.base.glViewport(x, y, width, height);
        this.after();
    }
}
