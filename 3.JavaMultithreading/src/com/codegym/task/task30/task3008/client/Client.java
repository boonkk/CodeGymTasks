package com.codegym.task.task30.task3008.client;

import com.codegym.task.task30.task3008.Connection;
import com.codegym.task.task30.task3008.ConsoleHelper;
import com.codegym.task.task30.task3008.Message;
import com.codegym.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() {
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        return ConsoleHelper.readInt();
    }

    protected String getUserName() throws IOException, ClassNotFoundException {
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }
    protected void sendTextMessage(String text) {
        try {
            Message m = new Message(MessageType.TEXT,text);
            connection.send(m);
        } catch (IOException e) {
            clientConnected=false;
        }
    }
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                wait();
            }
            
            } catch (InterruptedException e) {
        }
        if(clientConnected == true) {
            ConsoleHelper.writeMessage("Connection established. To exit, enter 'exit'.");
        }else {
            ConsoleHelper.writeMessage("An error occurred while working with the client.");
        }
        while(clientConnected==true) {
            String message = ConsoleHelper.readString();
            if(message.equals("exit")) {
                break;
                //clientConnected = false;
                //System.exit(0);
            }
            if(shouldSendTextFromConsole()==true)
                sendTextMessage(message);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " has joined the chat.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " has left the chat.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) { Client.this.notify(); }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message m = connection.receive();
                if (m.getType() == MessageType.NAME_REQUEST)
                    connection.send(new Message(MessageType.USER_NAME,getUserName()));
                else if (m.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else throw new IOException("Unexpected MessageType");
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while(true) {
                Message m = connection.receive();
                if(m.getType()==MessageType.TEXT)
                    processIncomingMessage(m.getData());
                else if (m.getType() == MessageType.USER_ADDED)
                    informAboutAddingNewUser(m.getData());
                else if (m.getType() == MessageType.USER_REMOVED)
                    informAboutDeletingNewUser(m.getData());
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run() {
            try {
                Socket socket = new Socket(getServerAddress(),getServerPort());
                new Socket();
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();

            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }
}
