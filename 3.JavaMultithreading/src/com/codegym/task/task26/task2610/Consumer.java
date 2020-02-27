package com.codegym.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue=queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                String s = (String) queue.take();
                System.out.println(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
