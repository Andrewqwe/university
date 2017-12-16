package com.andrzej;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBramka extends Remote {
    public int[] getStatystyka() throws RemoteException;
    boolean zamknijBramke() throws RemoteException;
    int getNumer() throws RemoteException;
}
