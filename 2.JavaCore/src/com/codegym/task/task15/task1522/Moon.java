package com.codegym.task.task15.task1522;

class Moon implements Planet{
    private static Moon instance;
    public static Moon getInstance(){
        if ( instance == null ){
            synchronized(Moon.class){
                if ( instance == null ){
                    instance = new Moon();
                }
            }
        }
        return instance;
    }
}