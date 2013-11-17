package ro.spatarel.android.oogles20;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Map;
import java.util.TreeMap;
import java.util.UnknownFormatConversionException;

/**
 * <p>Class grouping together methods for:</p>
 * 
 * <ul>
 *     <li>defining the back end to be used;</li>
 *     <li>accessing static instances of other library classes;</li>
 *     <li>accessing OpenGL ES special functions;</li>
 *     <li>managing {@link Buffer} objects.</li>
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
public class OOGLES20 {
    
    private OOGLES20() {
        // There is nothing here.
    }
    
    static final int BYTE_SIZE = Byte.SIZE / 8;
    static final int CHAR_SIZE = Character.SIZE / 8;
    static final int DOUBLE_SIZE = Double.SIZE / 8;
    static final int FLOAT_SIZE = Float.SIZE / 8;
    static final int INT_SIZE = Integer.SIZE / 8;
    static final int LONG_SIZE = Long.SIZE / 8;
    static final int SHORT_SIZE = Short.SIZE / 8;
    
    private static final Map<Integer, OOGLES20TextureUnit> textureUnits = new TreeMap<Integer, OOGLES20TextureUnit>();
    
    /**
     * <p>Wrapper for the {@link OpenGLES20#GL_ARRAY_BUFFER} target.</p>
     */
    public static final OOGLES20Buffer arrayBuffer = new OOGLES20Buffer(OOBufferType.ARRAY_BUFFER);
    
    /**
     * <p>Wrapper for the {@link OpenGLES20#GL_ELEMENT_ARRAY_BUFFER} target.</p>
     */
    public static final OOGLES20Buffer elementArrayBuffer = new OOGLES20Buffer(OOBufferType.ELEMENT_ARRAY_BUFFER);
    
    /**
     * <p>Wrapper for the {@link OpenGLES20#GL_FRAMEBUFFER} target.</p>
     */
    public static final OOGLES20Framebuffer framebuffer = new OOGLES20Framebuffer();
    
    /**
     * <p>Wrapper for the {@link OpenGLES20#GL_RENDERBUFFER} target.</p>
     */
    public static final OOGLES20Renderbuffer renderbuffer = new OOGLES20Renderbuffer();
    
    /**
     * Static instance of the {@link OOGLES20PrimitiveProcessing} class.
     */
    public static final OOGLES20PrimitiveProcessing primitiveProcessing = new OOGLES20PrimitiveProcessing();
    
    /**
     * Static instance of the {@link OOGLES20Rasterization} class.
     */
    public static final OOGLES20Rasterization rasterization = new OOGLES20Rasterization();
    
    /**
     * Static instance of the {@link OOGLES20FragmentProcessing} class.
     */
    public static final OOGLES20FragmentProcessing fragmentProcessing = new OOGLES20FragmentProcessing();
    
    /**
     * Static instance of the {@link OOGLES20PixelProcessing} class.
     */
    public static final OOGLES20PixelProcessing pixelProcessing = new OOGLES20PixelProcessing();
    
    /**
     * Static instance of the {@link OOGLES20Implementation} class.
     */
    public static final OOGLES20Implementation implementation = new OOGLES20Implementation();
    
    static OpenGLES20 backEnd = null;
    
    /**
     * <p>Defines the back end to be used by the library.</p>
     * 
     * @param backEnd The back end to be used by the library.
     */
    public static void setBackEnd(OpenGLES20 backEnd) {
        OOGLES20.backEnd = backEnd;
    }
    
    /**
     * <p>Create and return a new empty {@link ByteBuffer} with {@code size} elements.</p>
     * 
     * @param size The number of elements that can be stored in the new {@link ByteBuffer}.
     * 
     * @return A new empty {@link ByteBuffer} with {@code size} elements.
     */
    public static ByteBuffer createByteBuffer(int size) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(size * BYTE_SIZE);
        byteBuffer.order(ByteOrder.nativeOrder());
        
        return byteBuffer;
    }
    
    /**
     * <p>Create and return a new {@link ByteBuffer} containing the data from {@code buffer} with the position set to
     * {@code offset}.</p>
     * 
     * @param buffer The data be stored in the new {@link ByteBuffer}.
     * @param offset The position of the new {@link ByteBuffer}.
     * 
     * @return A new {@link ByteBuffer} containing the data from {@code buffer} with the position set to {@code offset}.
     */
    public static ByteBuffer createByteBuffer(byte[] buffer, int offset) {
        ByteBuffer byteBuffer = createByteBuffer(buffer.length);
        byteBuffer.put(buffer);
        byteBuffer.position(offset);
        
        return byteBuffer;
    }
    
    /**
     * <p>Create and return a new {@link ByteBuffer} containing the data from {@code buffer} with the position set to
     * {@code 0}.</p>
     * 
     * @param buffer The data be stored in the new {@link ByteBuffer}.
     * 
     * @return A new {@link ByteBuffer} containing the data from {@code buffer} with the position set to {@code 0}.
     */
    public static ByteBuffer createByteBuffer(byte[] buffer) {
        return OOGLES20.createByteBuffer(buffer, 0);
    }
    
    /**
     * <p>Create and return a new empty {@link CharBuffer} with {@code size} elements.</p>
     * 
     * @param size The number of elements that can be stored in the new {@link CharBuffer}.
     * 
     * @return A new empty {@link CharBuffer} with {@code size} elements.
     */
    public static CharBuffer createCharBuffer(int size) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(size * CHAR_SIZE);
        byteBuffer.order(ByteOrder.nativeOrder());
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        
        return charBuffer;
    }
    
    /**
     * <p>Create and return a new {@link CharBuffer} containing the data from {@code buffer} with the position set to
     * {@code offset}.</p>
     * 
     * @param buffer The data be stored in the new {@link CharBuffer}.
     * @param offset The position of the new {@link CharBuffer}.
     * 
     * @return A new {@link CharBuffer} containing the data from {@code buffer} with the position set to {@code offset}.
     */
    public static CharBuffer createCharBuffer(char[] buffer, int offset) {
        CharBuffer charBuffer = createCharBuffer(buffer.length);
        charBuffer.put(buffer);
        charBuffer.position(offset);
        
        return charBuffer;
    }
    
    /**
     * <p>Create and return a new {@link CharBuffer} containing the data from {@code buffer} with the position set to
     * {@code 0}.</p>
     * 
     * @param buffer The data be stored in the new {@link CharBuffer}.
     * 
     * @return A new {@link CharBuffer} containing the data from {@code buffer} with the position set to {@code 0}.
     */
    public static CharBuffer createCharBuffer(char[] buffer) {
        return OOGLES20.createCharBuffer(buffer, 0);
    }
    
    /**
     * <p>Create and return a new empty {@link DoubleBuffer} with {@code size} elements.</p>
     * 
     * @param size The number of elements that can be stored in the new {@link DoubleBuffer}.
     * 
     * @return A new empty {@link DoubleBuffer} with {@code size} elements.
     */
    public static DoubleBuffer createDoubleBuffer(int size) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(size * DOUBLE_SIZE);
        byteBuffer.order(ByteOrder.nativeOrder());
        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
        
        return doubleBuffer;
    }
    
    /**
     * <p>Create and return a new {@link DoubleBuffer} containing the data from {@code buffer} with the position set to
     * {@code offset}.</p>
     * 
     * @param buffer The data be stored in the new {@link DoubleBuffer}.
     * @param offset The position of the new {@link DoubleBuffer}.
     * 
     * @return A new {@link DoubleBuffer} containing the data from {@code buffer} with the position set to {@code offset}.
     */
    public static DoubleBuffer createDoubleBuffer(double[] buffer, int offset) {
        DoubleBuffer doubleBuffer = createDoubleBuffer(buffer.length);
        doubleBuffer.put(buffer);
        doubleBuffer.position(offset);
        
        return doubleBuffer;
    }
    
    /**
     * <p>Create and return a new {@link DoubleBuffer} containing the data from {@code buffer} with the position set to
     * {@code 0}.</p>
     * 
     * @param buffer The data be stored in the new {@link DoubleBuffer}.
     * 
     * @return A new {@link DoubleBuffer} containing the data from {@code buffer} with the position set to {@code 0}.
     */
    public static DoubleBuffer createDoubleBuffer(double[] buffer) {
        return OOGLES20.createDoubleBuffer(buffer, 0);
    }
    
    /**
     * <p>Create and return a new empty {@link FloatBuffer} with {@code size} elements.</p>
     * 
     * @param size The number of elements that can be stored in the new {@link FloatBuffer}.
     * 
     * @return A new empty {@link FloatBuffer} with {@code size} elements.
     */
    public static FloatBuffer createFloatBuffer(int size) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(size * FLOAT_SIZE);
        byteBuffer.order(ByteOrder.nativeOrder());
        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
        
        return floatBuffer;
    }
    
    /**
     * <p>Create and return a new {@link FloatBuffer} containing the data from {@code buffer} with the position set to
     * {@code offset}.</p>
     * 
     * @param buffer The data be stored in the new {@link FloatBuffer}.
     * @param offset The position of the new {@link FloatBuffer}.
     * 
     * @return A new {@link FloatBuffer} containing the data from {@code buffer} with the position set to {@code offset}.
     */
    public static FloatBuffer createFloatBuffer(float[] buffer, int offset) {
        FloatBuffer floatBuffer = createFloatBuffer(buffer.length);
        floatBuffer.put(buffer);
        floatBuffer.position(offset);
        
        return floatBuffer;
    }
    
    /**
     * <p>Create and return a new {@link FloatBuffer} containing the data from {@code buffer} with the position set to
     * {@code 0}.</p>
     * 
     * @param buffer The data be stored in the new {@link FloatBuffer}.
     * 
     * @return A new {@link FloatBuffer} containing the data from {@code buffer} with the position set to {@code 0}.
     */
    public static FloatBuffer createFloatBuffer(float[] buffer) {
        return OOGLES20.createFloatBuffer(buffer, 0);
    }
    
    /**
     * <p>Create and return a new empty {@link IntBuffer} with {@code size} elements.</p>
     * 
     * @param size The number of elements that can be stored in the new {@link IntBuffer}.
     * 
     * @return A new empty {@link IntBuffer} with {@code size} elements.
     */
    public static IntBuffer createIntBuffer(int size) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(size * INT_SIZE);
        byteBuffer.order(ByteOrder.nativeOrder());
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        
        return intBuffer;
    }
    
    /**
     * <p>Create and return a new {@link IntBuffer} containing the data from {@code buffer} with the position set to
     * {@code offset}.</p>
     * 
     * @param buffer The data be stored in the new {@link IntBuffer}.
     * @param offset The position of the new {@link IntBuffer}.
     * 
     * @return A new {@link IntBuffer} containing the data from {@code buffer} with the position set to {@code offset}.
     */
    public static IntBuffer createIntBuffer(int[] buffer, int offset) {
        IntBuffer intBuffer = createIntBuffer(buffer.length);
        intBuffer.put(buffer);
        intBuffer.position(offset);
        
        return intBuffer;
    }
    
    /**
     * <p>Create and return a new {@link IntBuffer} containing the data from {@code buffer} with the position set to
     * {@code 0}.</p>
     * 
     * @param buffer The data be stored in the new {@link IntBuffer}.
     * 
     * @return A new {@link IntBuffer} containing the data from {@code buffer} with the position set to {@code 0}.
     */
    public static IntBuffer createIntBuffer(int[] buffer) {
        return OOGLES20.createIntBuffer(buffer, 0);
    }
    
    /**
     * <p>Create and return a new empty {@link LongBuffer} with {@code size} elements.</p>
     * 
     * @param size The number of elements that can be stored in the new {@link LongBuffer}.
     * 
     * @return A new empty {@link LongBuffer} with {@code size} elements.
     */
    public static LongBuffer createLongBuffer(int size) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(size * LONG_SIZE);
        byteBuffer.order(ByteOrder.nativeOrder());
        LongBuffer longBuffer = byteBuffer.asLongBuffer();
        
        return longBuffer;
    }
    
    /**
     * <p>Create and return a new {@link LongBuffer} containing the data from {@code buffer} with the position set to
     * {@code offset}.</p>
     * 
     * @param buffer The data be stored in the new {@link LongBuffer}.
     * @param offset The position of the new {@link LongBuffer}.
     * 
     * @return A new {@link LongBuffer} containing the data from {@code buffer} with the position set to {@code offset}.
     */
    public static LongBuffer createLongBuffer(long[] buffer, int offset) {
        LongBuffer longBuffer = createLongBuffer(buffer.length);
        longBuffer.put(buffer);
        longBuffer.position(offset);
        
        return longBuffer;
    }
    
    /**
     * <p>Create and return a new {@link LongBuffer} containing the data from {@code buffer} with the position set to
     * {@code 0}.</p>
     * 
     * @param buffer The data be stored in the new {@link LongBuffer}.
     * 
     * @return A new {@link LongBuffer} containing the data from {@code buffer} with the position set to {@code 0}.
     */
    public static LongBuffer createLongBuffer(long[] buffer) {
        return OOGLES20.createLongBuffer(buffer, 0);
    }
    
    /**
     * <p>Create and return a new empty {@link ShortBuffer} with {@code size} elements.</p>
     * 
     * @param size The number of elements that can be stored in the new {@link ShortBuffer}.
     * 
     * @return A new empty {@link ShortBuffer} with {@code size} elements.
     */
    public static ShortBuffer createShortBuffer(int size) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(size * SHORT_SIZE);
        byteBuffer.order(ByteOrder.nativeOrder());
        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        
        return shortBuffer;
    }
    
    /**
     * <p>Create and return a new {@link ShortBuffer} containing the data from {@code buffer} with the position set to
     * {@code offset}.</p>
     * 
     * @param buffer The data be stored in the new {@link ShortBuffer}.
     * @param offset The position of the new {@link ShortBuffer}.
     * 
     * @return A new {@link ShortBuffer} containing the data from {@code buffer} with the position set to {@code offset}.
     */
    public static ShortBuffer createShortBuffer(short[] buffer, int offset) {
        ShortBuffer shortBuffer = createShortBuffer(buffer.length);
        shortBuffer.put(buffer);
        shortBuffer.position(offset);
        
        return shortBuffer;
    }
    
    /**
     * <p>Create and return a new {@link ShortBuffer} containing the data from {@code buffer} with the position set to
     * {@code 0}.</p>
     * 
     * @param buffer The data be stored in the new {@link ShortBuffer}.
     * 
     * @return A new {@link ShortBuffer} containing the data from {@code buffer} with the position set to {@code 0}.
     */
    public static ShortBuffer createShortBuffer(short[] buffer) {
        return OOGLES20.createShortBuffer(buffer, 0);
    }
    
    /**
     * <p>Create and return a new {@code byte[]} containing the data from {@code buffer}.</p>
     * 
     * @param buffer The data be stored in the new {@code byte[]}.
     * 
     * @return A new {@code byte[]} containing the data from {@code buffer}.
     */
    public static byte[] extract(ByteBuffer buffer) {
        int size = buffer.limit();
        byte[] answer = new byte[size];
        for (int i = 0; i < size; ++i) {
            answer[i] = buffer.get(i);
        }
        return answer;
    }
    
    /**
     * <p>Create and return a new {@code char[]} containing the data from {@code buffer}.</p>
     * 
     * @param buffer The data be stored in the new {@code char[]}.
     * 
     * @return A new {@code char[]} containing the data from {@code buffer}.
     */
    public static char[] extract(CharBuffer buffer) {
        int size = buffer.limit();
        char[] answer = new char[size];
        for (int i = 0; i < size; ++i) {
            answer[i] = buffer.get(i);
        }
        return answer;
    }
    
    /**
     * <p>Create and return a new {@code double[]} containing the data from {@code buffer}.</p>
     * 
     * @param buffer The data be stored in the new {@code double[]}.
     * 
     * @return A new {@code double[]} containing the data from {@code buffer}.
     */
    public static double[] extract(DoubleBuffer buffer) {
        int size = buffer.limit();
        double[] answer = new double[size];
        for (int i = 0; i < size; ++i) {
            answer[i] = buffer.get(i);
        }
        return answer;
    }
    
    /**
     * <p>Create and return a new {@code float[]} containing the data from {@code buffer}.</p>
     * 
     * @param buffer The data be stored in the new {@code float[]}.
     * 
     * @return A new {@code float[]} containing the data from {@code buffer}.
     */
    public static float[] extract(FloatBuffer buffer) {
        int size = buffer.limit();
        float[] answer = new float[size];
        for (int i = 0; i < size; ++i) {
            answer[i] = buffer.get(i);
        }
        return answer;
    }
    
    /**
     * <p>Create and return a new {@code int[]} containing the data from {@code buffer}.</p>
     * 
     * @param buffer The data be stored in the new {@code int[]}.
     * 
     * @return A new {@code int[]} containing the data from {@code buffer}.
     */
    public static int[] extract(IntBuffer buffer) {
        int size = buffer.limit();
        int[] answer = new int[size];
        for (int i = 0; i < size; ++i) {
            answer[i] = buffer.get(i);
        }
        return answer;
    }
    
    /**
     * <p>Create and return a new {@code long[]} containing the data from {@code buffer}.</p>
     * 
     * @param buffer The data be stored in the new {@code long[]}.
     * 
     * @return A new {@code long[]} containing the data from {@code buffer}.
     */
    public static long[] extract(LongBuffer buffer) {
        int size = buffer.limit();
        long[] answer = new long[size];
        for (int i = 0; i < size; ++i) {
            answer[i] = buffer.get(i);
        }
        return answer;
    }
    
    /**
     * <p>Create and return a new {@code short[]} containing the data from {@code buffer}.</p>
     * 
     * @param buffer The data be stored in the new {@code short[]}.
     * 
     * @return A new {@code short[]} containing the data from {@code buffer}.
     */
    public static short[] extract(ShortBuffer buffer) {
        int size = buffer.limit();
        short[] answer = new short[size];
        for (int i = 0; i < size; ++i) {
            answer[i] = buffer.get(i);
        }
        return answer;
    }
    
    static int getBufferElementarySize(Buffer sampleBuffer) {
        if (sampleBuffer instanceof ByteBuffer) {
            return OOGLES20.BYTE_SIZE;
        } else if (sampleBuffer instanceof CharBuffer) {
            return OOGLES20.CHAR_SIZE;
        } else if (sampleBuffer instanceof DoubleBuffer) {
            return OOGLES20.DOUBLE_SIZE;
        } else if (sampleBuffer instanceof FloatBuffer) {
            return OOGLES20.FLOAT_SIZE;
        } else if (sampleBuffer instanceof IntBuffer) {
            return OOGLES20.INT_SIZE;
        } else if (sampleBuffer instanceof LongBuffer) {
            return OOGLES20.LONG_SIZE;
        } else if (sampleBuffer instanceof ShortBuffer) {
            return OOGLES20.SHORT_SIZE;
        }
        throw new UnknownFormatConversionException("");
    }
    
    /**
     * <p>Return error information.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetError}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #getError} returns the value of the error flag. Each detectable error is assigned an enum constant.
     * When an error occurs, the error flag is set to the appropriate error constant. No other errors are recorded until
     * {@link #getError} is called, the error constant is returned and the flag is reset to {@link OOError#NO_ERROR}.
     * If a call to {@link #getError} returns {@link OOError#NO_ERROR}, there has been no detectable error since the
     * last call to {@link #getError} or since the GL was initialized.</p>
     * 
     * <p>To allow for distributed implementations, there may be several error flags. If any single error flag has
     * recorded an error, the value of that flag is returned and that flag is reset to {@link OOError#NO_ERROR} when
     * {@link #getError} is called. If more than one flag has recorded an error, {@link #getError} returns and clears an
     * arbitrary error flag value. Thus, {@link #getError} should always be called in a loop, until it returns {@link
     * OOError#NO_ERROR}, if all error flags are to be reset.</p>
     * 
     * <p>Initially, all error flags are set to {@link OOError#NO_ERROR}.</p>
     * 
     * <p>When an error flag is set, results of a GL operation are undefined only if {@link OOError#OUT_OF_MEMORY} has
     * occurred. In all other cases, the command generating the error is ignored and has no effect on the GL state or
     * frame buffer contents. If the generating command returns a value, it returns {@code 0} or {@code null}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see OOGLES20Framebuffer#checkStatus
     * @see OOError
     * 
     * @return the value of the error flag
     */
    public static OOError getError() {
        return OOError.valueOf(OOGLES20.backEnd.glGetError());
    }
    
    /**
     * <p>Convenience call; equivalent to:</p>
     * 
     * <p>{@code while(OOGLES20.getError() != OOError.NO_ERROR);}.</p>
     * 
     * @see #getError
     * @see OOError#NO_ERROR
     */
    public static void clearErrors() {
        while(OOGLES20.getError() != OOError.NO_ERROR);
    }
    
    /**
     * <p>Force execution of GL commands in finite time.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glFlush}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Different GL implementations buffer commands in several different locations, including network buffers and the
     * graphics accelerator itself. {@link #flush} empties all of these buffers, causing all issued commands to be
     * executed as quickly as they are accepted by the actual rendering engine. Though this execution may not be
     * completed in any particular time period, it does complete in finite time.</p>
     * 
     * <p>Because any GL program might be executed over a network or on an accelerator that buffers commands, all
     * programs should call {@link #flush} whenever they count on having all of their previously issued commands
     * completed. For example, call {@link #flush} before waiting for user input that depends on the generated image.
     * </p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>{@link #flush} can return at any time. It does not wait until the execution of all previously issued GL
     * commands is complete.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #finish
     */
    public static void flush() {
        OOGLES20.backEnd.glFlush();
    }
    
    /**
     * <p>Block until all GL execution is complete.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glFinish}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #finish} does not return until the effects of all previously called GL commands are complete. Such
     * effects include all changes to GL state, all changes to connection state and all changes to the frame buffer
     * contents.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>{@link #finish} requires a round trip to the server.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @see #flush
     */
    public static void finish() {
        OOGLES20.backEnd.glFinish();
    }
    
    /**
     * Returns a {@link OOGLES20TextureUnit} object managing a specified texture unit.
     * 
     * @param texture The index of the requested texture unit.
     * @return A {@link OOGLES20TextureUnit} object managing a specified texture unit.
     */
    public static OOGLES20TextureUnit textureUnit(int texture) {
        if (!OOGLES20.textureUnits.containsKey(texture)) {
            OOGLES20.textureUnits.put(texture, new OOGLES20TextureUnit(texture));
        }
        return OOGLES20.textureUnits.get(texture);
    }
    
    /**
     * <p>Install a program object as part of current rendering state.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glUseProgram}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #useProgram} installs the program object specified by {@code program} as part of current rendering
     * state. One or more executables are created in a program object by successfully attaching shader objects to it
     * with {@link OOProgram#attachShader}, successfully compiling the shader objects with {@link OOShader#compile} and
     * successfully linking the program object with {@link OOProgram#link}.</p>
     * 
     * <p>A program object will contain executables that will run on the vertex and fragment processors if it contains
     * one or more shader objects of type {@link OOShaderType#VERTEX} and one or more shader objects of type {@link
     * OOShaderType#FRAGMENT} that have all been successfully compiled and linked.</p>
     * 
     * <p>While a program object is in use, applications are free to modify attached shader objects, compile attached
     * shader objects, attach additional shader objects and detach or delete shader objects. None of these operations
     * will affect the executables that are part of the current state. However, relinking the program object that is
     * currently in use will install the program object as part of the current rendering state if the link operation was
     * successful (see {@link OOProgram#link}). If the program object currently in use is relinked unsuccessfully, its
     * link status will be set to {@code false}, but the executables and associated state will remain part of the
     * current state until a subsequent call to {@link #useProgram} removes it from use. After it is
     * removed from use, it cannot be made part of current state until it has been successfully relinked.</p>
     * 
     * <p>If {@code program} is {@code null}, then the current rendering state refers to an invalid program object and
     * the results of vertex and fragment shader execution due to any {@link OOGLES20Framebuffer#drawArrays} or {@link
     * OOGLES20Framebuffer#drawElements} commands are undefined.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Like texture objects and buffer objects, the name space for program objects may be shared across a set of
     * contexts, as long as the server sides of the contexts share the same address space. If the name space is shared
     * across contexts, any attached objects and the data associated with those attached objects are shared as well.</p>
     * 
     * <p>Applications are responsible for providing the synchronization across API calls when objects are accessed from
     * different execution threads.</p>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_VALUE is generated if program is neither 0 nor a value generated by OpenGL. -->
     *     <!-- GL_INVALID_OPERATION is generated if program is not a program object. -->
     *     <li>{@link OOError#INVALID_OPERATION} is generated if {@code program} could not be made part of current
     *     state.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2003-2005 3Dlabs Inc. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see #getCurrentProgram
     * @see OOProgram#getAttachedShaders
     * @see OOProgram#getVectorAttribute
     * @see OOProgram#getInfoLog
     * @see OOProgram#getUniform
     * @see OOProgram#attachShader
     * @see OOShader#compile
     * @see OOProgram#OOProgram
     * @see OOProgram#finalize
     * @see OOProgram#detachShader
     * @see OOProgram#link
     * @see OOProgram#validate
     * 
     * @param program Specifies the handle of the program object whose executables are to be used as part of current
     * rendering state.
     */
    public static void useProgram(OOProgram program) {
        if (program == null) {
            OOGLES20.backEnd.glUseProgram(0);
        } else {
            OOGLES20.backEnd.glUseProgram(program.getHandle());
        }
    }
    
    /**
     * <p>Release resources allocated by the shader compiler.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glReleaseShaderCompiler}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>For implementations that support a shader compiler, {@link #releaseCompiler} frees resources allocated by the
     * shader compiler. This is a hint from the application that additional shader compilations are unlikely to occur,
     * at least for some period of time and that the resources consumed by the shader compiler may be released and put
     * to better use elsewhere.</p>
     * 
     * <p>However, if a call to {@link OOShader#compile} is made after a call to {@link #releaseCompiler}, the shader
     * compiler must be restored to service the compilation request as if {@link #releaseCompiler} had never been
     * called.</p>
     * 
     * <h5>Notes</h5>
     * 
     * <p>Shader compiler support is optional and thus must be queried before use by calling {@link
     * OOGLES20Implementation#isShaderCompilerSupported}. {@link OOShader#setSource}, {@link OOShader#compile}, {@link
     * OOGLES20Implementation#getPrecisionFormat} and {@link #releaseCompiler} will each generate {@link
     * OOError#INVALID_OPERATION} on implementations that do not support a shader compiler. Such implementations instead
     * offer the {@link OOShader#setBinary} alternative for supplying a pre-compiled shader binary.</p>
     * 
     * <h5>Errors</h5>
     *
     * <ul>
     *     <li>{@link OOError#INVALID_OPERATION} is generated if a shader compiler is not supported.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 2008 Khronos Group. Ltd. This material may be distributed subject to the terms and
     * conditions set forth in the Open Publication License, v 1.0, 8 June 1999.
     * <a href="http://opencontent.org/openpub/">http://opencontent.org/openpub/</a>.</p>
     * 
     * @see OOGLES20Implementation#isShaderCompilerSupported
     * @see OOShader#compile
     * @see OOShader#setSource
     */
    public static void releaseCompiler() {
        OOGLES20.backEnd.glReleaseShaderCompiler();
    }
    
    /**
     * <p>Set pixel storage modes.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glPixelStorei}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>{@link #setPixelAlignment} sets pixel storage modes that affect the operation of subsequent {@link
     * OOGLES20Framebuffer#readPixels} as well as the unpacking of texture patterns (see {@link
     * OOGLES20TextureImage#setImage2D} and {@link OOGLES20TextureImage#setSubImage2D}).</p>
     * 
     * <p>{@code storage} is an enum constant indicating the parameter to be set and {@code alignment} is the new
     * value. One storage parameter affects how pixel data is returned to client memory:</p>
     * 
     * <dl>
     *     <dt>{@link OOPixelStorage#PACK_ALIGNMENT}</dt>
     *         <dd>Specifies the alignment requirements for the start of each pixel row in memory. The allowable values
     *         are 1 (byte-alignment), 2 (rows aligned to even-numbered bytes), 4 (word-alignment) and 8 (rows start on
     *         double-word boundaries).</dd>
     * </dl>
     * 
     * <p>The other storage parameter affects how pixel data is read from client memory:</p>
     * 
     * <dl>
     *     <dt>{@link OOPixelStorage#UNPACK_ALIGNMENT}</dt>
     *         <dd>Specifies the alignment requirements for the start of each pixel row in memory. The allowable values
     *         are 1 (byte-alignment), 2 (rows aligned to even-numbered bytes), 4 (word-alignment) and 8 (rows start on
     *         double-word boundaries).</dd>
     * 
     * <p>The following table gives the type, initial value and range of valid values for each storage parameter that
     * can be set with {@link #setPixelAlignment}.</p>
     * 
     * <table border="1">
     *   <tr>
     *     <th>{@code storage}</th>
     *     <th>Type</th>
     *     <th>Initial Value</th>
     *     <th>Valid Range</th>
     *   </tr>
     *   <tr>
     *     <td>{@link OOPixelStorage#PACK_ALIGNMENT}</td>
     *     <td><center>integer</center></td>
     *     <td><center>4</center></td>
     *     <td><center>1, 2, 4 or 8</center></td>
     *   </tr>
     *   <tr>
     *     <td>{@link OOPixelStorage#UNPACK_ALIGNMENT}</td>
     *     <td><center>integer</center></td>
     *     <td><center>4</center></td>
     *     <td><center>1, 2, 4 or 8</center></td>
     *   </tr>
     * </table>
     * 
     * <h5>Errors</h5>
     * 
     * <ul>
     *     <!-- GL_INVALID_ENUM is generated if pname is not an accepted value. -->
     *     <li>{@link OOError#INVALID_VALUE} is generated if alignment is specified as other than 1, 2, 4 or 8.</li>
     * </ul>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param storage Specifies the symbolic name of the parameter to be set. One value affects the packing of pixel
     * data into memory: {@link OOPixelStorage#PACK_ALIGNMENT}. The other affects the unpacking of pixel data
     * <i>from</i> memory: {@link OOPixelStorage#UNPACK_ALIGNMENT}.
     * @param alignment Specifies the value that {@code storage} is set to.
     * 
     * @see #getPixelPackAlignment
     * @see #getPixelUnpackAlignment
     * @see OOGLES20Framebuffer#readPixels
     * @see OOGLES20TextureImage#setImage2D
     * @see OOGLES20TextureImage#setSubImage2D
     */
    public static void setPixelAlignment(OOPixelStorage storage, int alignment) {
        OOGLES20.backEnd.glPixelStorei(storage.getGLConstant(), alignment);
    }
    
    /**
     * <p>Specify the implementation-specific hint for the quality of filtering when generating mipmap images with
     * {@link OOGLES20Texture#generateMipmaps}.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glHint} with argument {@link OpenGLES20#GL_GENERATE_MIPMAP_HINT}</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>The quality of filtering when generating mipmap images with {@link OOGLES20Texture#generateMipmaps} can be
     * controlled with hints. A hint is specified with an enum constant indicating the desired behavior. The initial
     * value is {@link OOHintMode#DONT_CARE}. {@code mode} can be one of the following:</p>
     * 
     * <dl>
     *     <dt>{@link OOHintMode#FASTEST}</dt>
     *         <dd>The most efficient option should be chosen.</dd>
     *     <dt>{@link OOHintMode#NICEST}</dt>
     *         <dd>The most correct or highest quality, option should be chosen.</dd>
     *     <dt>{@link OOHintMode#DONT_CARE}</dt>
     *         <dd>No preference.</dd>
     * </dl>
     * 
     * <h5>Notes</h5>
     * 
     * <p>The interpretation of hints depends on the implementation. Some implementations ignore {@link
     * #setGenerateMipmapHint} settings.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @param mode Specifies an enum constant indicating the desired behavior. The initial value is {@link
     * OOHintMode#DONT_CARE}.
     * 
     * @see OOHintMode
     */
    public static void setGenerateMipmapHint(OOHintMode mode) {
        OOGLES20.backEnd.glHint(OpenGLES20.GL_GENERATE_MIPMAP_HINT, mode.getGLConstant());
    }
    
    private static IntBuffer intBuffer = OOGLES20.createIntBuffer(1);
    
    /**
     * <p>Returns the program object that is currently active or {@code null} if no program object is active.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_CURRENT_PROGRAM}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the program object that is currently active or {@code null} if no program object is active.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The program object that is currently active or {@code null} if no program object is active.
     * 
     * @see #useProgram
     */
    public static OOProgram getCurrentProgram() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_CURRENT_PROGRAM, OOGLES20.intBuffer);
        return OOProgram.getProgram(OOGLES20.intBuffer.get(0));
    }
    
    /**
     * <p>Returns the byte alignment used for writing pixel data to memory.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_PACK_ALIGNMENT}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the byte alignment used for writing pixel data to memory. The initial value is 4.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The byte alignment used for writing pixel data to memory.
     * 
     * @see #setPixelAlignment
     */
    public int getPixelPackAlignment() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_PACK_ALIGNMENT, OOGLES20.intBuffer);
        return OOGLES20.intBuffer.get(0);
    }
    
    /**
     * <p>Returns the byte alignment used for reading pixel data from memory.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_UNPACK_ALIGNMENT}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns the byte alignment used for reading pixel data from memory. The initial value is 4.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return The byte alignment used for reading pixel data from memory.
     * 
     * @see #setPixelAlignment
     */
    public int getPixelUnpackAlignment() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_UNPACK_ALIGNMENT, OOGLES20.intBuffer);
        return OOGLES20.intBuffer.get(0);
    }
    
    /**
     * <p>Returns an enum constant indicating the mode of the mipmap generation filtering hint.</p>
     * 
     * <p>Wrapper for {@link OpenGLES20#glGetIntegerv} with argument {@link OpenGLES20#GL_GENERATE_MIPMAP_HINT}.</p>
     * 
     * <h5>Description</h5>
     * 
     * <p>Returns an enum constant indicating the mode of the mipmap generation filtering hint. The initial value is
     * {@link OOHintMode#DONT_CARE}.</p>
     * 
     * <h5>Copyright</h5>
     * 
     * <p>Copyright &copy; 1991-2006 Silicon Graphics, Inc. This document is licensed under the SGI Free Software B
     * License. For details, see <a href="http://oss.sgi.com/projects/FreeB/">http://oss.sgi.com/projects/FreeB/</a>.
     * </p>
     * 
     * @return An enum constant indicating the mode of the mipmap generation filtering hint.
     * 
     * @see #setGenerateMipmapHint
     */
    public static OOHintMode getGenerateMipmapHint() {
        OOGLES20.backEnd.glGetIntegerv(OpenGLES20.GL_GENERATE_MIPMAP_HINT, OOGLES20.intBuffer);
        return OOHintMode.valueOf(OOGLES20.intBuffer.get(0));
    }
}
