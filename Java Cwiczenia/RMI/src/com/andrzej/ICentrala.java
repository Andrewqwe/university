package com.andrzej;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Rejestrowanie i wyrejestrowywanie bramek w systemie
 */
public interface ICentrala extends Remote {
    int zarejestruj(Object bramka) throws RemoteException;
    boolean wyrejestruj(Object bramka) throws RemoteException;
    ArrayList<Object> getAktywneBramki() throws RemoteException;
    void zarejestrujMonitor(Object o) throws RemoteException;
    void wyrejestrujMonitor() throws RemoteException;
    IMonitor getMonitor() throws RemoteException;
}
