package com.codegym.task.task25.task2509;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() throws IOException {
        socket.shutdownInput();
        socket.shutdownOutput();
        socket.close();

    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                // Close all resources here using the proper SocketTask method
                // Call the superclass's method in a finally block
                try {
                    socket.shutdownInput();
                    socket.shutdownOutput();
                    socket.close();
                }
                catch (IOException e){}
                finally{
                    super.cancel(true);
                }
                return false;
            }
        };
    }
}