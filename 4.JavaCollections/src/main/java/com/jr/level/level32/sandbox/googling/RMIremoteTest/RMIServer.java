package com.jr.level.level32.sandbox.googling.RMIremoteTest;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {

    public static void main(String[] args) {
        //Подготавливаем политику безопасности
        //Для предоставления возможности подключатся к серверу RMI
        //на удаленной машине необходимо установить менеджер безопасности
        if(System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());


        //Создаем объекты для удаленного доступа
        Animal dog = new Dog("Rigik");
        Animal cat = new Cat("Murka");

        try {
            //Експортируем создаем заглушки из наших объектов
            Animal stubDog = (Animal) UnicastRemoteObject.exportObject(dog,0);
            Animal stubCat = (Animal) UnicastRemoteObject.exportObject(cat, 0);

            //Выполняем програмній запуск rmiregistry  на локальной машине

            Registry registry = LocateRegistry.createRegistry(5000);
            //Привязываем наши stubs (заглушки) к нашему реестру
            registry.rebind("DogService", stubDog);
            registry.rebind("CatService", stubCat);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
