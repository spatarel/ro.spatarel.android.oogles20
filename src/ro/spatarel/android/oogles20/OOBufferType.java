package ro.spatarel.android.oogles20;

enum OOBufferType {
    ARRAY_BUFFER(OpenGLES20.GL_ARRAY_BUFFER),
    ELEMENT_ARRAY_BUFFER(OpenGLES20.GL_ELEMENT_ARRAY_BUFFER);
    
    private final int glConstant;
    
    OOBufferType(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
