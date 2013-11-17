package ro.spatarel.android.oogles20;

/**
 * <p>Structure used for storing a color buffer write mask.</p>
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
public class OOColorBufferWriteMask {
    /**
     * <p>The red component flag.</p>
     */
    public boolean red;
    
    /**
     * <p>The green component flag.</p>
     */
    public boolean green;
    
    /**
     * <p>The blue component flag.</p>
     */
    public boolean blue;
    
    /**
     * <p>The alpha component flag.</p>
     */
    public boolean alpha;
    
    /**
     * <p>Create a new {@link OOColorBufferWriteMask} object with the initial value {@code (true, true, true, true)}.
     * </p>
     */
    public OOColorBufferWriteMask() {
        this.red = true;
        this.green = true;
        this.blue = true;
        this.alpha = true;
    }
    
    /**
     * <p>Create a new {@link OOColorBufferWriteMask} object with specified component values.</p>
     * 
     * @param red The red component flag.
     * @param green The green component flag.
     * @param blue The blue component flag.
     * @param alpha The alpha component flag.
     */
    public OOColorBufferWriteMask(boolean red, boolean green, boolean blue, boolean alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }
}
