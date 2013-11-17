package ro.spatarel.android.oogles20;

/**
 * <p>Structure used for storing a color.</p>
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
public class OOColor {
    /**
     * <p>The red component of the color.</p>
     */
    public float red;
    
    /**
     * <p>The green component of the color.</p>
     */
    public float green;
    
    /**
     * <p>The blue component of the color.</p>
     */
    public float blue;
    
    /**
     * <p>The alpha component of the color.</p>
     */
    public float alpha;
    
    /**
     * <p>Create a new {@link OOColor} object with the initial value {@code (0, 0, 0, 0)}.</p>
     */
    public OOColor() {
        this.red = 0.0f;
        this.green = 0.0f;
        this.blue = 0.0f;
        this.alpha = 0.0f;
    }
    
    /**
     * <p>Create a new {@link OOColor} object with specified component values.</p>
     * 
     * @param red The red component of the color.
     * @param green The green component of the color.
     * @param blue The blue component of the color.
     * @param alpha The alpha component of the color.
     */
    public OOColor(float red, float green, float blue, float alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }
}
