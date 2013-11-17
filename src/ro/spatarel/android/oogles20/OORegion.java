package ro.spatarel.android.oogles20;

/**
 * <p>Structure used for storing a region.</p>
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
public class OORegion {
    /**
     * <p>The <i>x</i> coordinate of the lower left corner of the region.</p>
     */
    public int x;
    
    /**
     * <p>The <i>y</i> coordinate of the lower left corner of the region.</p>
     */
    public int y;
    
    /**
     * <p>The width dimension of the region.</p>
     */
    public int width;
    
    /**
     * <p>The height dimension of the region.</p>
     */
    public int height;
    
    /**
     * <p>Create a new {@link OORegion} object with the initial value {@code (0, 0, 0, 0)}.</p>
     */
    public OORegion() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }
    
    /**
     * <p>Create a new {@link OORegion} object with specified values.</p>
     * 
     * @param x The <i>x</i> coordinate of the lower left corner of the region.
     * @param y The <i>y</i> coordinate of the lower left corner of the region.
     * @param width The width dimension of the region.
     * @param height The height dimension of the region.
     */
    public OORegion(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
