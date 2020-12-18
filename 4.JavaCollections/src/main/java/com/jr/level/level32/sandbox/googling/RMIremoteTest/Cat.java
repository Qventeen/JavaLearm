package com.jr.level.level32.sandbox.googling.RMIremoteTest;


import java.rmi.RemoteException;

public class Cat implements Animal {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String speak() throws RemoteException {
        System.out.println("meow on server");
        return "meow";
    }

    @Override
    public String printName() throws RemoteException {
        String string = "Cat " + name + " ";
        System.out.println(string + "on server");
        return string;
    }
}
