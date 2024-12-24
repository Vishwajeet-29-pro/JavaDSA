package org.practice.dsa.design_pattern.singleton_pattern;

public class Logger {
    private static Logger instance;

    private Logger(){}

    public static Logger getInstance(){
        if (instance == null){
            synchronized (Logger.class){
                if (instance == null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log message: "+message);
    }
}
