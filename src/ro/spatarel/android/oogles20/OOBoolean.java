package ro.spatarel.android.oogles20;

enum OOBoolean {
    TRUE(OpenGLES20.GL_TRUE),
    FALSE(OpenGLES20.GL_FALSE);
    
    private final int glConstant;
    
    static OOBoolean valueOf(int value) {
        for (OOBoolean someValue : OOBoolean.values()) {
            if (someValue.getGLConstant() == value) {
                return someValue;
            }
        }
        return null;
    }
    
    static boolean getBool(int value) {
        return value == OpenGLES20.GL_TRUE;
    }
    
    OOBoolean(int value) {
        this.glConstant = value;
    }
    
    int getGLConstant() {
        return this.glConstant;
    }
}
