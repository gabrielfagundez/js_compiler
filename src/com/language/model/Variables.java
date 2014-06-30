package com.language.model;

// Clase Singleton que almacena las variables.
public class Variables {
	private static Variables INSTANCE = null;

    private Variables() {}

    private synchronized static void createInstance() {
    	if (INSTANCE == null) { 
            INSTANCE = new Variables();
        }
    }

    public static Variables getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }

}
