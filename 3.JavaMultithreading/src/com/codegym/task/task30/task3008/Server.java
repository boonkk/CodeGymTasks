package com.codegym.task.task30.task3008;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;


        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message messageReceived = new Message(MessageType.TEXT);
            String userName = null;
            do {
                do {
                    connection.send(new Message(MessageType.NAME_REQUEST));
                    messageReceived = connection.receive();
                } while (messageReceived.getType() != MessageType.USER_NAME);
                userName = messageReceived.getData();
            } while(userName.equals("") || connectionMap.containsKey(userName));

            connectionMap.put(userName, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));

            return userName;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for(Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if(!entry.getKey().equals(userName))
                connection.send(new Message(MessageType.USER_ADDED,entry.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while(true) {
                Message messageReceived = connection.receive();
                if( messageReceived.getType() == MessageType.TEXT ) {
                    Message m = new Message(MessageType.TEXT, userName + ": " + messageReceived.getData());
                    sendBroadcastMessage(m);
                } else {
                    ConsoleHelper.writeMessage("Wrong message type.");
                }
            }
        }

        public void run() {
            ConsoleHelper.writeMessage("Connection established: " + socket.getRemoteSocketAddress());
            String name="";
            Connection connection = null;
            try {
                connection = new Connection(socket);
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,name));
                notifyUsers(connection,name);
                serverMainLoop(connection,name);
                connectionMap.remove(name);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,name));
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Error occured while connecting with: " + socket.getRemoteSocketAddress());
                    if(!name.equals("")) {
                        connectionMap.remove(name);
                        sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
                    }

            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Error occured while connecting with: " + socket.getRemoteSocketAddress());
                    if(!name.equals("")) {
                        connectionMap.remove(name);
                        sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
                    }
            }
        ConsoleHelper.writeMessage("Connection with address has been closed: " + socket.getRemoteSocketAddress());
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for(Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Dear " + entry.getValue() + ", your message couldn't have been send:(");
            }

        }
    }
    public static void main(String[] args) throws IOException {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket=null;
        try {
             serverSocket = new ServerSocket(port);
            System.out.println("Server is running");
            while(true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
                continue;
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            serverSocket.close();
        }

    }
}
