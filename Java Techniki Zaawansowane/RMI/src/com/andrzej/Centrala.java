package com.andrzej;

import javafx.application.Application;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;

public class Centrala implements ICentrala {
    public static Centrala centrala;
    public ArrayList<Object> bramki = new ArrayList<>();
    public IMonitor monitor = null;
    private static int i=0;

    public Centrala() {
        centrala = this;
    }

    public static Centrala getCentrala() {
        return centrala;
    }

    @Override
    public int zarejestruj(Object bramka) throws RemoteException {
        check();
        if (bramki.contains(bramka)){
            System.err.println("Juz jest");
            return (((Bramka)bramki.get(bramki.indexOf(bramka))).getNumer());
        } else {
            System.err.println("rejestracja nowej bramki");
            bramki.add(bramka);
            return i++;
        }
        /*if (bramka instanceof IBramka) {
            if (((IBramka) bramka).getNumer() != 0) {
                return ((IBramka) bramka).getNumer();
            }
        }*/
    }

    @Override
    public boolean wyrejestruj(Object bramka) throws RemoteException {
        System.err.println("wyrejestrowsanie");
        if(bramki.contains(bramka)) {
            bramki.remove(bramka);
            IBramka b = (IBramka) bramka;
            b.zamknijBramke();
            if (monitor != null) {
                monitor.koniecznaAktualizacja();
            }
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Object> getAktywneBramki() throws RemoteException {
        System.err.println("pobranie bramek");
        return bramki;
    }

    @Override
    public void zarejestrujMonitor(Object o) {
        System.err.println("rejestracja monitora");
        monitor = (IMonitor) o;
    }

    @Override
    public void wyrejestrujMonitor() {
        monitor = null;
    }

    @Override
    public IMonitor getMonitor() throws RemoteException {
        return monitor;
    }

    public void check(){
        for(Object o : centrala.bramki) {
            IBramka bramka = (IBramka) o;
            try {
                bramka.getNumer();
            } catch (Exception e) {
                centrala.bramki.remove(centrala.bramki.indexOf(o));
            }
        }
    }
    public static void main(String[] args) {
        try {
            Centrala c = new Centrala();

            ICentrala i = (ICentrala) UnicastRemoteObject.exportObject(c, 1099);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("central", i);
            System.out.println(Arrays.toString(registry.list()));

            new Thread(() -> Application.launch(CentralaUI.class)).start();
            CentralaUI centralaUI = CentralaUI.waitForCentralaUI();
            System.err.println("Centrala gotowa");
        } catch (Exception e) {
            System.err.println("Problem centrali: " + e.toString());
            e.printStackTrace();
        }
    }
}
