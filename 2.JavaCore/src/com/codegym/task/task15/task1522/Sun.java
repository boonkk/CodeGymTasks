package com.codegym.task.task15.task1522;

class Sun implements Planet{
    private static Sun instance;
    public static Sun getInstance(){
        if ( instance == null ){
            synchronized(Sun.class){
                if ( instance == null ){
                    instance = new Sun();
                }
            }
        }
        return instance;
    }
}
