package ro.spatarel.android.oogles20;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * <p>Class grouping together the methods managing the rasterization pipeline stage.</p>
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
public class OOGLES20Rasterization {
    
    OOGLES20Rasterization() {
        // There is nothing here.
    }
    
    /**
     * <p>Specify the width of rasterized lines.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glLineWidth}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setLineWidth} specifies the rasterized width of lines.</p>
     * 
     * <p>The actual width is determined by rounding the supplied width to the nearest integer. (If the rounding results
     * in the value {@code 0}, it is as if the line width were {@code 1}.) If <i>|&Delta;x| >= |&Delta;y|</i>, <i>i</i>
     * pixels are filled in each column that is rasterized, where <i>i</i> is the rounded value of {@code width}.
     * Otherwise, <i>i</i> pixels are filled in each row that is rasterized.</p>
     * 
     * <p>There is a range of supported line widths. Only width {@code 1} is guaranteed to be supported; others depend
     * on the implementation. To query the range of supported widths, call {@link
     * OOGLES20Implementation#getAliasedLineWidthsRange}.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>The line width specified by {@link #setLineWidth} is always returned when {@link #getLineWidth} is queried.
     * Clamping and rounding have no effect on the specified value.</p>
     * 
     * <p>Line width may be clamped to an implementation-dependent maximum. Call {@link
     * OOGLES20Implementation#getAliasedLineWidthsRange} to determine the maximum width.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <li>{@link OOError#INVALID_VALUE} is generated if width is less than or equal to {@code 0}.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param width Specifies the width of rasterized lines. The initial value is {@code 1}.
     * 
     * @see #getLineWidth
     * @see OOGLES20Implementation#getAliasedLineWidthsRange
     */
    public void setLineWidth(float width) {
        OOGLES20.backEnd.glLineWidth(width);
    }
    
    /**
     * <p>Define front- and back-facing polygons.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glFrontFace}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>In a scene composed entirely of opaque closed surfaces, back-facing polygons are never visible. Eliminating
     * these invisible polygons has the obvious benefit of speeding up the rendering of the image. To enable and disable
     * elimination of back-facing polygons, call {@link #enableCullFace} and {@link #disableCullFace}.</p>
     * 
     * <p>The projection of a polygon to window coordinates is said to have clockwise winding if an imaginary object
     * following the path from its first vertex, its second vertex and so on, to its last vertex and finally back to
     * its first vertex, moves in a clockwise direction about the interior of the polygon. The polygon's winding is said
     * to be counterclockwise if the imaginary object following the same path moves in a counterclockwise direction
     * about the interior of the polygon. {@link #setFrontFaceWinding} specifies whether polygons with clockwise winding
     * in window coordinates or counterclockwise winding in window coordinates, are taken to be front-facing. Passing
     * {@link OOWinding#COUNTERCLOCKWISE} to {@code mode} selects counterclockwise polygons as front-facing; {@link
     * OOWinding#CLOCKWISE} selects clockwise polygons as front-facing. By default, counterclockwise polygons are
     * taken to be front-facing.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param winding Specifies the orientation of front-facing polygons. The initial value is {@link
     * OOWinding#COUNTERCLOCKWISE}.
     * 
     * @see #getFrontFaceWinding
     * @see #setCullFaceOrientation
     */
    public void setFrontFaceWinding(OOWinding winding) {
        OOGLES20.backEnd.glFrontFace(winding.getGLConstant());
    }
    
    /**
     * <p>If enabled, cull polygons based on their winding in window coordinates.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glEnable} with argument {@link OpenGLES20#GL_CULL_FACE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, cull polygons based on their winding in window coordinates.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #setCullFaceOrientation
     */
    public void enableCullFace() {
        OOGLES20.backEnd.glEnable(OpenGLES20.GL_CULL_FACE);
    }
    
    /**
     * <p>Specify whether front- or back-facing facets can be culled.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glCullFace}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setCullFaceOrientation} specifies whether front- or back-facing facets are culled (as specified by
     * {@code orientation}) when facet culling is enabled. Facet culling is initially disabled. To enable and disable
     * facet culling, call {@link #enableCullFace} and {@link #disableCullFace}. Facets include triangles,
     * quadrilaterals, polygons and rectangles.</p>
     * 
     * <p>{@link #setFrontFaceWinding} specifies which of the clockwise and counterclockwise facets are front-facing and
     * back-facing.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>If {@code mode} is {@link OOPrimitiveOrientation#FRONT_AND_BACK}, no facets are drawn, but other primitives
     * such as points and lines are drawn.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param orientation Specifies whether front- or back-facing facets are candidates for culling. The initial value
     * is {@link OOPrimitiveOrientation#BACK}.
     * 
     * @see #isCullFaceEnabled
     * @see #getCullFaceOrientation
     * @see #enableCullFace
     * @see #setFrontFaceWinding
     */
    public void setCullFaceOrientation(OOPrimitiveOrientation orientation) {
        OOGLES20.backEnd.glCullFace(orientation.getGLConstant());
    }
    
    /**
     * <p>If enabled, cull polygons based on their winding in window coordinates.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDisable} with argument {@link OpenGLES20#GL_CULL_FACE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, cull polygons based on their winding in window coordinates.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #setCullFaceOrientation
     */
    public void disableCullFace() {
        OOGLES20.backEnd.glDisable(OpenGLES20.GL_CULL_FACE);
    }
    
    /**
     * <p>If enabled, an offset is added to depth values of a polygon's fragments produced by rasterization.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glEnable} with argument {@link OpenGLES20#GL_POLYGON_OFFSET_FILL}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, an offset is added to depth values of a polygon's fragments produced by rasterization.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #setPolygonOffset
     */
    public void enablePolygonOffset() {
        OOGLES20.backEnd.glEnable(OpenGLES20.GL_POLYGON_OFFSET_FILL);
    }
    
    /**
     * <p>Set the scale and units used to calculate depth values.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glPolygonOffset}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>When {@link #enablePolygonOffset} is enabled, each fragment's <i>depth</i> value will be offset after it
     * is interpolated from the <i>depth</i> values of the appropriate vertices. The value of the offset is
     * <i>factor × DZ + r × units</i>, where <i>DZ</i> is a measurement of the change in depth relative to the screen
     * area of the polygon and <i>r</i> is the smallest value that is guaranteed to produce a resolvable offset for a
     * given implementation. The offset is added before the depth test is performed and before the value is written into
     * the depth buffer.</p>
     * 
     * <p>{@link #setPolygonOffset} is useful for rendering hidden-line images, for applying decals to surfaces and for
     * rendering solids with highlighted edges.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param factor Specifies a scale factor that is used to create a variable depth offset for each polygon. The
     * initial value is {@code 0}.
     * @param units Is multiplied by an implementation-specific value to create a constant depth offset. The initial
     * value is {@code 0}.
     * 
     * @see OOGLES20Rasterization#isPolygonOffsetEnabled
     * @see #getPolygonOffsetFactor
     * @see #getPolygonOffsetUnits
     * @see OOGLES20FragmentProcessing#setDepthTestFunction
     * @see OOGLES20Rasterization#enablePolygonOffset
     */
    public void setPolygonOffset(float factor, float units) {
        OOGLES20.backEnd.glPolygonOffset(factor, units);
    }
    
    /**
     * <p>If enabled, an offset is added to depth values of a polygon's fragments produced by rasterization.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glDisable} with argument {@link OpenGLES20#GL_POLYGON_OFFSET_FILL}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, an offset is added to depth values of a polygon's fragments produced by rasterization.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #setPolygonOffset
     */
    public void disablePolygonOffset() {
        OOGLES20.backEnd.glDisable(OpenGLES20.GL_POLYGON_OFFSET_FILL);
    }
    
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(1);
    private static FloatBuffer floatBuffer = OOGLES20.createFloatBuffer(1);
    
    /**
     * <p>Returns the line width as specified with {@link #setLineWidth}.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetFloatv} with argument {@link OpenGLES20#GL_LINE_WIDTH}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the line width as specified with {@link #setLineWidth}. The initial value is {@code 1}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The line width as specified with {@link #setLineWidth}.
     * 
     * @see #setFrontFaceWinding
     */
    public float getLineWidth() {
        OOGLES20.backEnd.glGetFloatv(OpenGLES20.GL_LINE_WIDTH, OOGLES20Rasterization.floatBuffer);
        return OOGLES20Rasterization.floatBuffer.get(0);
    }
    
    /**
     * <p>Returns an enum constant indicating whether clockwise or counterclockwise polygon winding is treated as
     * front-facing.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_FRONT_FACE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an enum constant indicating whether clockwise or counterclockwise polygon winding is treated as
     * front-facing. The initial value is {@link OOWinding#COUNTERCLOCKWISE}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return An enum constant indicating whether clockwise or counterclockwise polygon winding is treated as
     * front-facing.
     * 
     * @see #setFrontFaceWinding
     */
    public OOWinding getFrontFaceWinding() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_FRONT_FACE, OOGLES20Rasterization.intBuffer);
        return OOWinding.valueOf(OOGLES20Rasterization.intBuffer.get(0));
    }
    
    /**
     * <p>Returns whether a capability is enabled.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glIsEnabled} with argument {@link OpenGLES20#GL_CULL_FACE}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, cull polygons based on their winding in window coordinates.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return Whether a capability is enabled.
     * 
     * @see #setCullFaceOrientation
     */
    public boolean isCullFaceEnabled() {
        return OOGLES20.backEnd.glIsEnabled(OpenGLES20.GL_CULL_FACE);
    }
    
    /**
     * <p>Returns an enum constant indicating which polygon faces are to be culled.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_BLEND_DST_RGB}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an enum constant indicating which polygon faces are to be culled. The initial value is {@link
     * OOPrimitiveOrientation#BACK}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return An enum constant indicating which polygon faces are to be culled.
     * 
     * @see #setCullFaceOrientation
     */
    public OOPrimitiveOrientation getCullFaceOrientation() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_CULL_FACE_MODE, OOGLES20Rasterization.intBuffer);
        return OOPrimitiveOrientation.valueOf(OOGLES20Rasterization.intBuffer.get(0));
    }
    
    /**
     * <p>Returns whether a capability is enabled.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glIsEnabled} with argument {@link OpenGLES20#GL_POLYGON_OFFSET_FILL}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>If enabled, an offset is added to depth values of a polygon's fragments produced by rasterization.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return Whether a capability is enabled.
     * 
     * @see #setPolygonOffset
     */
    public boolean isPolygonOffsetEnabled() {
        return OOGLES20.backEnd.glIsEnabled(OpenGLES20.GL_POLYGON_OFFSET_FILL);
    }
    
    /**
     * <p>Returns the scaling factor used to determine the variable offset that is added to the depth value of each
     * fragment generated when a polygon is rasterized.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetFloatv} with argument {@link OpenGLES20#GL_POLYGON_OFFSET_FACTOR}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the scaling factor used to determine the variable offset that is added to the depth value of each
     * fragment generated when a polygon is rasterized. The initial value is {@code 0}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The scaling factor used to determine the variable offset that is added to the depth value of each
     * fragment generated when a polygon is rasterized.
     * 
     * @see #setPolygonOffset
     */
    public float getPolygonOffsetFactor() {
        OOGLES20.backEnd.glGetFloatv(OpenGLES20.GL_POLYGON_OFFSET_FACTOR, OOGLES20Rasterization.floatBuffer);
        return OOGLES20Rasterization.floatBuffer.get(0);
    }
    
    /**
     * <p>Returns a value that is multiplied by an implementation-specific value and then added to the depth value of
     * each fragment generated when a polygon is rasterized.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetFloatv} with argument {@link OpenGLES20#GL_POLYGON_OFFSET_UNITS}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns a value that is multiplied by an implementation-specific value and then added to the depth value of
     * each fragment generated when a polygon is rasterized. The initial value is {@code 0}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return A value that is multiplied by an implementation-specific value and then added to the depth value of each
     * fragment generated when a polygon is rasterized.
     * 
     * @see #setPolygonOffset
     */
    public float getPolygonOffsetUnits() {
        OOGLES20.backEnd.glGetFloatv(OpenGLES20.GL_POLYGON_OFFSET_UNITS, OOGLES20Rasterization.floatBuffer);
        return OOGLES20Rasterization.floatBuffer.get(0);
    }
}
