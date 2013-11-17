package ro.spatarel.android.oogles20;

/**
 * <p>The list of all possible draw primitives.</p>
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
public enum OODrawPrimitive {
    /**
     * <p>A series of individual points.</p>
     * 
     * <p>Each vertex defines a separate point.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_POINTS} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    POINTS(OpenGLES20.GL_POINTS),
    
    /**
     * <p>Individual line segments, each specified by a pair of vertices. The first two vertices passed define the first
     * segment, with subsequent pairs of vertices each defining one more segment. If the number of specified vertices is
     * odd, then the last one is ignored. The required state is the same as for line strips but it is used differently:
     * a processed vertex holding the first endpoint of the current segment and a boolean flag indicating whether the
     * current vertex is odd or even (a segment start or end).</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_LINES} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    LINES(OpenGLES20.GL_LINES),
    
    /**
     * <p>A series of one or more connected line segments.</p>
     * 
     * <p>At least two vertices must be provided. In this case, the first vertex specifies the first segment’s start
     * point while the second vertex specifies the first segment’s endpoint and the second segment’s start point. In
     * general, the <i>i</i>th vertex (for <i>i > 1</i>) specifies the beginning of the <i>i</i>th segment and the end
     * of the <i>i - 1</i>th. The last vertex specifies the end of the last segment. If only one vertex is specified,
     * then no primitive is generated.</p>
     * 
     * <p>The required state consists of the processed vertex produced from the preceding vertex that was passed (so
     * that a line segment can be generated from it to the current vertex) and a boolean flag indicating if the current
     * vertex is the first vertex.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_LINE_STRIP} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    LINE_STRIP(OpenGLES20.GL_LINE_STRIP),
    
    /**
     * <p>Line loops.</p>
     * 
     * <p>Loops are the same as line strips ({@link OODrawPrimitive#LINE_STRIP}) except that a final segment is added
     * from the final specified vertex to the first vertex.</p>
     * 
     * <p>The required state consists of the processed first vertex, in addition to the state required for line strips.
     * </p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_LINE_LOOP} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    LINE_LOOP(OpenGLES20.GL_LINE_LOOP),
    
    /**
     * <p>Separate triangles.</p>
     * 
     * <p>In this case, The <i>3i + 1</i>st, <i>3i + 2</i>nd and <i>3i + 3</i>rd vertices (in that order) determine a
     * triangle for each <i>i = 0, 1, ..., n - 1</i>, where there are <i>3n + k</i> vertices drawn. <i>k</i> is either
     * <i>0</i>, <i>1</i> or <i>2</i>; if <i>k</i> is not <i>0</i>, the final <i>k</i> vertices are ignored. For each
     * triangle, vertex A is vertex <i>3i</i> and vertex B is vertex <i>3i + 1</i>. Otherwise, separate triangles are
     * the same as a triangle strip.</p>
     * 
     * <p>The order of the vertices in a triangle generated from a triangle strip, triangle fan or separate triangles is
     * significant in polygon rasterization and fragment shading.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_TRIANGLES} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    TRIANGLES(OpenGLES20.GL_TRIANGLES),
    
    /**
     * <p>A triangle strip is a series of triangles connected along shared edges, specified by giving a series of
     * defining vertices. In this case, the first three vertices define the first triangle (and their order is
     * significant). Each subsequent vertex defines a new triangle using that point along with two vertices from the
     * previous triangle. If fewer than three vertices are specified, no primitives are produced.</p>
     * 
     * <p>The required state to support triangle strips consists of a flag indicating if the first triangle has been
     * completed, two stored processed vertices, (called vertex A and vertex B) and a one bit pointer indicating which
     * stored vertex will be replaced with the next vertex. The pointer is initialized to point to vertex A. Each
     * successive vertex toggles the pointer. Therefore, the first vertex is stored as vertex A, the second stored as
     * vertex B, the third stored as vertex A and so on. Any vertex after the second one sent forms a triangle from
     * vertex A, vertex B and the current vertex (in that order).</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_TRIANGLE_STRIP} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    TRIANGLE_STRIP(OpenGLES20.GL_TRIANGLE_STRIP),
    
    /**
     * <p>A triangle fan is the same as a triangle strip with one exception: each vertex after the first always replaces
     * vertex B of the two stored vertices.</p>
     * 
     * <p>Reference to the {@link OpenGLES20#GL_TRIANGLE_FAN} symbolic constant.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     */
    TRIANGLE_FAN(OpenGLES20.GL_TRIANGLE_FAN);

    private final int glConstant;
    
    OODrawPrimitive(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
