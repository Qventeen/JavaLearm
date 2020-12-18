package com.jr.level.level30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message){
        for(Connection con: connectionMap.values()){
            try {
                con.send(message);
            } catch (IOException e) {
                System.out.println("Сообщение отправить не удалось");
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.writeMessage("Введите порт: ");
        int port = consoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            consoleHelper.writeMessage("Сервер запущен");
            while(true){
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread{
        private Socket socket;

        private Handler (Socket socket){
            super();
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage(
                    String.format("Установле соединение с удаленным адресом %s",
                            socket.getRemoteSocketAddress()
                    )
            );
            final String ERR = "Произошла ошибка при обмене данными с удаленным адресом";
            String userName = "";
            try (Connection connection = new Connection(socket)){

                //Присоеденить нового пользователя
                userName = serverHandshake(connection);

                //Оповестить учасников о новом пользователе
                Server.sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));

                //Оповестить клиента о имеющихся учасниках
                notifyUsers(connection, userName);

                //Запустить главный цикл обработки
                serverMainLoop(connection, userName);

            } catch (IOException e) {
                ConsoleHelper.writeMessage(ERR);
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage(ERR);
            }finally {
                if(!userName.isEmpty()){
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
            }
        }

        //Рукопожатие с клиентом
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            Message message;
            String userName;
            while(true) {
                //Запрос имени пользователя
                connection.send(new Message(MessageType.NAME_REQUEST));

                //Получение ответа
                message = connection.receive();

                //Проверка типа ответа
                if (message.getType() == MessageType.USER_NAME) {
                    userName = message.getData();

                    //Имя не пустое и не содержится в списке пользователей
                    if (!userName.isEmpty() && !connectionMap.containsKey(userName)) {
                        connectionMap.put(userName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        break;
                    }
                }
            }
            return userName;
        }

        //Оповещение клиентов о новом учаснике
        private void notifyUsers(Connection connection, String userName) throws IOException{
            for(String name: connectionMap.keySet()){
                if(!name.equals(userName)){
                    Message message = new Message(MessageType.USER_ADDED,name);
                    connection.send(message);
                }
            }
        }

        //Главный цикл пересылки сообщений
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while(true) {
                Message message = connection.receive();
                if(message.getType()==MessageType.TEXT){
                    String msg = userName + ": " + message.getData();
                    message = new Message(MessageType.TEXT, msg);
                    Server.sendBroadcastMessage(message);
                } else{
                    ConsoleHelper.writeMessage("Ошибка клиентсокого приложения");
                }


            }
        }

    }



}
