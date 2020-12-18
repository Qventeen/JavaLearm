package com.jr.level.level32.sandbox.googling.RMIremoteTest;


import java.rmi.RemoteException;

public class Dog implements Animal {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String speak() throws RemoteException {
        System.out.println("woof on server");
        return "woof";
    }

    @Override
    public String printName() throws RemoteException {
        String string = "Dog " + name + " ";
        System.out.println(string + "on server");
        return string;
    }
}
