package com.andrzej;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMonitor extends Remote {
    void koniecznaAktualizacja() throws RemoteException;
}
