package com.codegym.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    Thread.State lastState;
    State state;
    @Override
    public void run() {
        lastState = thread.getState();
        System.out.println(lastState);
        while (true) {
            state = thread.getState();

            if( !state.equals(lastState) )
                System.out.println(state);

            if( state.equals(State.TERMINATED) ) {
                this.interrupt();
                break;
            }
            lastState=state;
        }
    }
}
