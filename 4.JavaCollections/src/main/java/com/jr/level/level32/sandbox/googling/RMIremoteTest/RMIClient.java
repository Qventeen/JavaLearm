package com.jr.level.level32.sandbox.googling.RMIremoteTest;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        //Для предоставления возможности подключатся к серверу RMI
        //на удаленной машине необходимо установить менеджер безопасности
        if(System.getSecurityManager() == null)
           System.setSecurityManager(new SecurityManager());

        ArrayList<Animal> animals = new ArrayList<>();
        Registry registry = LocateRegistry.getRegistry("localhost", 5000);

        for (String nameStub : registry.list()) {
            animals.add((Animal) registry.lookup(nameStub));
        }

        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        while (!"exit".equals(tmp)) {

            switch (tmp) {
                case "1":
                    System.out.println(animals.get(0).printName());
                    System.out.println(animals.get(0).speak());
                    break;
                default:
                    System.out.println(animals.get(1).printName());
                    System.out.println(animals.get(1).speak());
                                }
            tmp = scanner.nextLine();
        }
    }
}
