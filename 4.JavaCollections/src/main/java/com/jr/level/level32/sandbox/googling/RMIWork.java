package com.jr.level.level32.sandbox.googling;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIWork {
    //Подготовленный интерфейс
    interface SomeInterface extends Remote{
        void execute() throws RemoteException;
    }

    //Создаем реализацию подготовленного интерфейса
    public static class SomeInterfaceImpl implements SomeInterface{
        @Override
        public void execute() throws RemoteException {
            System.out.println("I am RMI invoke");
        }
    }

    public static Thread SERVER_THREAD = new Thread(()->{
        //Создаем объект для RMI
        SomeInterfaceImpl someI = new SomeInterfaceImpl();
        try {

            //Создаем реестр указывая нужный порт
            Registry registry = LocateRegistry.createRegistry(2099);

            //Подготавливаем объект для регистрации
            Remote stubSomeI = UnicastRemoteObject.exportObject(someI,0);

            //Привязываем RMI объект к уникальной ключевой фразе
            registry.bind("server.SomeInterface",stubSomeI);

        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    });


    public static Thread CLIENT = new Thread(()-> {
        try {
            Registry registry = LocateRegistry.getRegistry(2099);
            SomeInterface someInterface = (SomeInterface) registry.lookup("server.SomeInterface");
            someInterface.execute();

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    });

    public static void main(String[] args) throws InterruptedException {
        SERVER_THREAD.start();
        Thread.sleep(1000);
        CLIENT.start();
    }
}
