package ro.spatarel.android.oogles20;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * <p>Class grouping together the methods managing the primitive processing pipeline stage.</p>
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
public class OOGLES20PrimitiveProcessing {
    
    OOGLES20PrimitiveProcessing() {
        // There is nothing here.
    }
    
    /**
     * <p>Set the viewport.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glViewport}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setViewport} specifies the affine transformation of <i>x</i> and <i>y</i> from normalized device
     * coordinates to window coordinates. Let <i>(x<sub>nd</sub>, y<sub>nd</sub>)</i> be normalized device coordinates.
     * Then the window coordinates <i>(x<sub>w</sub>, y<sub>w</sub>)</i> are computed as follows:</p>
     * 
     * <p><i>x<sub>w</sub> = (x<sub>nd</sub> + 1)(<sup>width</sup>&frasl;<sub>2</sub>) + x</i></p>
     * 
     * <p><i>y<sub>w</sub> = (y<sub>nd</sub> + 1)(<sup>height</sup>&frasl;<sub>2</sub>) + y</i></p>
     * 
     * <p>Viewport width and height are silently clamped to a range that depends on the implementation. To query this
     * range, call {@link OOGLES20Implementation#getMaximumViewportDimensions}.
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_VALUE} is generated if either width or height is negative.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param x Specify <i>x</i> coordinate of the lower left corner of the viewport rectangle, in pixels. The initial
     * value is {@code 0}.
     * @param y Specify <i>y</i> coordinate of the lower left corner of the viewport rectangle, in pixels. The initial
     * value is {@code 0}.
     * @param width Specify the width of the viewport. When a GL context is first attached to a window, {@code width} is
     * set to the width of that window.
     * @param height Specify the height of the viewport. When a GL context is first attached to a window, {@code height}
     * is set to the height of that window.
     * 
     * @see #getViewport
     * @see OOGLES20Implementation#getMaximumViewportDimensions
     * @see #setDepthRange
     */
    public void setViewport(int x, int y, int width, int height) {
        OOGLES20.backEnd.glViewport(x, y, width, height);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setDepthRange(newDepthRange.zNear, newDepthRange.zFar);}.</p>
     * 
     * @param viewport Specify the lower left corner, the width and the height of the viewport rectangle, in pixels.
     * 
     * @see #setViewport
     */
    public void setViewport(OORegion viewport) {
        this.setViewport(viewport.x, viewport.y, viewport.width, viewport.height);
    }
    
    /**
     * <p>Specify mapping of depth values from normalized device coordinates to window coordinates.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDepthRangef}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>After clipping and division by <i>w</i>, depth coordinates range from {@code -1} to {@code 1}, corresponding
     * to the near and far clipping planes. {@link #setDepthRange} specifies a linear mapping of the normalized depth
     * coordinates in this range to window depth coordinates. Regardless of the actual depth buffer implementation,
     * window coordinate depth values are treated as though they range from {@code 0} through {@code 1} (like color
     * components). Thus, the values accepted by {@link #setDepthRange} are both clamped to this range before they are
     * accepted.</p>
     * 
     * <p>The setting of {@code (0, 1)} maps the near plane to {@code 0} and the far plane to {@code 1}. With this
     * mapping, the depth buffer range is fully utilized.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>It is not necessary that {@code zNear} be less than {@code zFar}. Reverse mappings such as <i>zNear = 1</i>
     * and <i>zFar = 0</i> are acceptable.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param zNear Specifies the mapping of the near clipping plane to window coordinates. The initial value is
     * {@code 0}.
     * @param zFar Specifies the mapping of the far clipping plane to window coordinates. The initial value is
     * {@code 1}.
     * 
     * @see #getDepthRange
     * @see OOGLES20FragmentProcessing#setDepthTestFunction
     * @see OOGLES20Rasterization#setPolygonOffset
     * @see #setViewport
     */
    public void setDepthRange(float zNear, float zFar) {
        OOGLES20.backEnd.glDepthRangef(zNear, zFar);
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code setDepthRange(newDepthRange.zNear, newDepthRange.zFar);}.</p>
     * 
     * @param depthRange Specifies the mapping of the near and far clipping planes to window coordinates. The initial
     * value is {@code (0, 1)}.
     * 
     * @see #setDepthRange
     */
    public void setDepthRange(OODepthRange depthRange) {
        this.setDepthRange(depthRange.zNear, depthRange.zFar);
    }
    
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(4);
    private static FloatBuffer floatBuffer = OOGLES20.createFloatBuffer(2);
    
    /**
     * <p>Returns a {@link OORegion}: the {@code x} and {@code y} window coordinates of the viewport and its
     * {@code width} and {@code height}.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_VIEWPORT}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a {@link OORegion}: the {@code x} and {@code y} window coordinates of the viewport and its
     * {@code width} and {@code height}. Initially the {@code x} and {@code y} window coordinates are both set to
     * {@code 0} and the {@code width} and {@code height} are set to the width and height of the window into which the
     * GL will do its rendering.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A {@link OORegion}: the {@code x} and {@code y} window coordinates of the viewport and its {@code width}
     * and {@code height}.
     * 
     * @see #setViewport
     */
    public OORegion getViewport() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_VIEWPORT, OOGLES20PrimitiveProcessing.intBuffer);
        return new OORegion(
                OOGLES20PrimitiveProcessing.intBuffer.get(0),
                OOGLES20PrimitiveProcessing.intBuffer.get(1),
                OOGLES20PrimitiveProcessing.intBuffer.get(2),
                OOGLES20PrimitiveProcessing.intBuffer.get(3));
    }
    
    /**
     * <p>Returns a {@link OODepthRange}: the near and far mapping limits for the depth buffer.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetFloatv} with argument {@link OpenGLES20#GL_DEPTH_RANGE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a {@link OODepthRange}: the near and far mapping limits for the depth buffer. The initial value is
     * {@code (0, 1)}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A {@link OODepthRange}: the near and far mapping limits for the depth buffer.
     * 
     * @see #setDepthRange
     */
    public OODepthRange getDepthRange() {
        OOGLES20.backEnd.glGetFloatv(OpenGLES20.GL_DEPTH_RANGE, OOGLES20PrimitiveProcessing.floatBuffer);
        return new OODepthRange(
                OOGLES20PrimitiveProcessing.floatBuffer.get(0),
                OOGLES20PrimitiveProcessing.floatBuffer.get(1));
    }
}
