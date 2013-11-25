package ro.spatarel.android.oogles20.backends;

import java.io.PrintStream;
import java.util.Date;

import android.util.Log;

import ro.spatarel.android.oogles20.OpenGLES20;

/**
 * <p>Decorator for {@link OpenGLES20} logging the execution to a {@link PrintStream} or the {@link Log}.</p>
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
public class AndroidGLES20Logger extends AndroidGLES20Decorator {
    
    private static final String TAG = AndroidGLES20Logger.class.getName();
    
    private final PrintStream stream;
    
    private final long startNanoTime;
    
    /**
     * <p>Creates a decorator for a specified {@link OpenGLES20} object that logs the execution to the {@link Log}.</p>
     * 
     * @param base The decorated {@link OpenGLES20} object.
     */
    public AndroidGLES20Logger(OpenGLES20 base) {
        super(base);
        this.stream = null;
        
        this.output("Logging started at: " + (new Date()).toString());
        this.startNanoTime = System.nanoTime();
    }
    
    /**
     * <p>Creates a decorator for a specified {@link OpenGLES20} object that logs the execution to the {@link
     * PrintStream}.</p>
     * 
     * @param base The decorated {@link OpenGLES20} object.
     * @param stream The {@link PrintStream} that logs the execution
     */
    public AndroidGLES20Logger(OpenGLES20 base, PrintStream stream) {
        super(base);
        this.stream = stream;
        
        this.output("Logging started at: " + (new Date()).toString());
        this.startNanoTime = System.nanoTime();
    }
    
    @Override
    protected void before() {
        // There is nothing here.
    }
    
    @Override
    protected void after() {
        // There is nothing here.
    }
    
    @Override
    protected void call(String methodName, Object[] arguments) {
        StringBuffer log = new StringBuffer();
        log.append("[");
        log.append(System.nanoTime() - this.startNanoTime);
        log.append("] ");
        log.append(methodName);
        log.append("(");
        for (int i = 0; i < arguments.length; ++i) {
            log.append(arguments[i]);
            if (i < arguments.length - 1) {
                log.append(", ");
            }
        }
        log.append(")");
        this.output(log.toString());
    }
    
    private void output(String output) {
        if (this.stream == null) {
            Log.i(TAG, output);
        } else {
            this.stream.println(output);
        }
    }
}
