package com.jr.level.level32.sandbox.googling.RMIremoteTest;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Animal extends Remote {
    String speak() throws RemoteException;

    String printName() throws RemoteException;
}

