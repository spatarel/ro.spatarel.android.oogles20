package ro.spatarel.android.oogles20;

/**
 * <p>Structure used for storing a depth range.</p>
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
public class OODepthRange {
    /**
     * <p>The near clipping plane <i>z</i> coordinate.</p>
     */
    public float zNear;
    
    /**
     * <p>The far clipping plane <i>z</i> coordinate.</p>
     */
    public float zFar;
    
    /**
     * <p>Create a new {@link OODepthRange} object with the initial value {@code (0, 1)}.</p>
     */
    public OODepthRange() {
        this.zNear = 0;
        this.zFar = 1;
    }
    
    /**
     * <p>Create a new {@link OODepthRange} object with specified coordinate values.</p>
     * 
     * @param zNear The near clipping plane <i>z</i> coordinate.
     * @param zFar The far clipping plane <i>z</i> coordinate.
     */
    public OODepthRange(float zNear, float zFar) {
        this.zNear = zNear;
        this.zFar = zFar;
    }
}
