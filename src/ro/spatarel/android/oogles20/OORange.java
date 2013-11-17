package ro.spatarel.android.oogles20;

/**
 * <p>Structure used for storing a range.</p>
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
public class OORange {
    /**
     * <p>The lower bound of the range.</p>
     */
    public float low;
    
    /**
     * <p>The upper bound of the range.</p>
     */
    public float high;
    
    /**
     * <p>Create a new {@link OORange} object with the initial value {@code (0, 0)}.</p>
     */
    public OORange() {
        this.low = 0;
        this.high = 0;
    }
    
    /**
     * <p>Create a new {@link OORange} object with specified coordinate values.</p>
     * 
     * @param low The lower bound of the range.
     * @param high The upper bound of the range.
     */
    public OORange(float low, float high) {
        this.low = low;
        this.high = high;
    }
}
