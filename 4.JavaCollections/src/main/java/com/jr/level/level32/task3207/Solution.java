package com.jr.level.level32.task3207;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
К серверу по RMI
*/
public class Solution {
    public static final String UNIC_BINDING_NAME = "double.string";
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //Поток Клиента
            try {
                //Находим в реестре нужный нам удаленный объект
                DoubleString service = (DoubleString) registry.lookup(UNIC_BINDING_NAME);

                //Выполняем удаленный вызов
                String result = service.doubleString("Hello RMI ");

                //Выводим результат в консоль
                System.out.println(result);

            //Перехватить необходимые исключения
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Pretend we're starting an RMI server as the main thread
        Remote stub = null;
        try {
            registry = LocateRegistry.createRegistry(2099);
            final DoubleStringImpl service = new DoubleStringImpl();

            stub = UnicastRemoteObject.exportObject(service, 0);
            registry.bind(UNIC_BINDING_NAME, stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

        // Start the client
        CLIENT_THREAD.start();
        Thread.sleep(100);


    }
}
