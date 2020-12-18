package com.jr.level.level30.task3008.client;

import com.jr.level.level30.task3008.Connection;
import com.jr.level.level30.task3008.ConsoleHelper;
import com.jr.level.level30.task3008.Message;
import com.jr.level.level30.task3008.MessageType;
import java.io.IOException;
import java.net.Socket;


public class Client {
    private volatile boolean clientConnected = false;
    protected Connection connection;

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Введите адрес сервера для подключения: ");
        String ip = ConsoleHelper.readString();
        return ip;
    }
    protected int getServerPort(){
        ConsoleHelper.writeMessage("Введите порт подключения к серверу: ");
        int port = ConsoleHelper.readInt();
        return port;
    }
    protected String getUserName(){
        ConsoleHelper.writeMessage("Имя пользователя: ");
        String userName = ConsoleHelper.readString();
        return userName;
    }
    protected boolean shouldSendTextFromConsole(){
        return true;
    }
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }
    protected void sendTextMessage(String text){
        try {
            Message message = new Message(MessageType.TEXT, text);
            this.connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Произошла ошибка во время отправки сообщения.");
            this.clientConnected = false;
        }
    }
    public void run(){
        final String strtrue = "Соединение установлено.\nДля выхода наберите команду 'exit'";
        final String strfalse = "Произошла ошибка во время работы клиента.";
        String text;
        SocketThread sc = getSocketThread();
        sc.setDaemon(true);
        sc.start();
        synchronized(this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(!clientConnected)
            ConsoleHelper.writeMessage(strfalse);
        else {
            ConsoleHelper.writeMessage(strtrue);
            do{
                text = ConsoleHelper.readString();
                if("exit".equals(text)) {
                    break;
                }
                if(shouldSendTextFromConsole()){
                    sendTextMessage(text);
                }
            } while(clientConnected);
        }
    }

    public static void main(String[] args){
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {
        @Override
        public void run(){
            String address = getServerAddress();
            int port = getServerPort();

            try {
                connection = new Connection(new Socket(address, port));
                clientHandshake();
                clientMainLoop();

            } catch (ClassNotFoundException | IOException e ) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while(true){
                Message message = connection.receive();
                if(MessageType.NAME_REQUEST == message.getType()){
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else if(MessageType.NAME_ACCEPTED == message.getType()){
                    notifyConnectionStatusChanged(true);
                    return;
                } else
                    throw new IOException("Unexpected MessageType");

            }

        }
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while(true) {
                Message message = connection.receive();
                if (MessageType.TEXT == message.getType()) {
                    processIncomingMessage(message.getData());
                } else if (MessageType.USER_ADDED == message.getType()) {
                    informAboutAddingNewUser(message.getData());
                } else if (MessageType.USER_REMOVED == message.getType()) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");

                }
            }
        }

        //Обработка входящих сообщений
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName){
            String format = "Учасник %s присоеденился к чату";
            ConsoleHelper.writeMessage(String.format(format,userName));
        }
        protected void informAboutDeletingNewUser(String userName){
            String format = "Учасник %s покинул чат";
            ConsoleHelper.writeMessage(String.format(format,userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized(Client.this){
                Client.this.notify();
            }
        }


    }
}
