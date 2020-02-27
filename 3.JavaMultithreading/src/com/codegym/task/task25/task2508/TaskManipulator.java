package com.codegym.task.task25.task2508;

public class TaskManipulator implements Runnable,CustomThreadManipulator {
    @Override
    public void run() {

        try {

            while (!Thread.interrupted()) {

                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            }

        } catch (Exception e) {

        }


    }
    Thread myThread = new Thread();
    @Override
    public void start(String threadName){
        myThread = new Thread(new TaskManipulator(), threadName);
        myThread.start();
    }
    @Override
    public void stop(){
        myThread.interrupt();
    }
}


