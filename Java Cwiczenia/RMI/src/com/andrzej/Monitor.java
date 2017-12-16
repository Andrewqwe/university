package com.andrzej;

import javafx.application.Application;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Monitor extends UnicastRemoteObject implements IMonitor {
    public static Monitor monitor;
    public static MonitorUI monitorUI;

    @Override
    public void koniecznaAktualizacja() throws RemoteException {
        monitorUI.refresh();
    }

    public Monitor() throws RemoteException{
        monitor = this;
    }

    public void zarejestrujMonitor(){
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            ICentrala c = (ICentrala) registry.lookup("central");
            c.zarejestrujMonitor(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Monitor getMonitor() {
        return monitor;
    }

    public static void main(String[] args) {
        try {
            Monitor m = new Monitor();
            new Thread(() -> Application.launch(MonitorUI.class)).start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
