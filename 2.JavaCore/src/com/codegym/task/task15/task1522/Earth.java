package com.codegym.task.task15.task1522;

class Earth implements Planet{
    private static Earth instance;
    public static Earth getInstance(){
        if ( instance == null ){
            synchronized(Earth.class){
                if ( instance == null ){
                    instance = new Earth();
                }
            }
        }
        return instance;
    }
}