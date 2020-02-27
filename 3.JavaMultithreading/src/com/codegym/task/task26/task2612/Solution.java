package com.codegym.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
The whole world is a comedy

*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
       if(!lock.tryLock())
        actionIfLockIsBusy();
       else{
           try{
               actionIfLockIsFree();
           }finally{
               lock.unlock();
           }
       }
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}