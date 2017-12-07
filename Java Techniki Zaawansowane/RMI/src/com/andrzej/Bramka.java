package com.andrzej;

import javafx.application.Application;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Bramka extends UnicastRemoteObject implements IBramka {

    private int numer;
    private static Bramka bramka;
    public static BramkaUI bramkaUI;
    private IMonitor monitor;

    static Bramka getBramka() {
        return bramka;
    }

    private int[] statystyki = new int[2];

    public Bramka() throws Exception{
            bramka = this;
    }

    @Override
    public int[] getStatystyka() throws RemoteException {
        return statystyki;
    }

    @Override
    public boolean zamknijBramke() throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            ICentrala c = (ICentrala) registry.lookup("central");
            c.wyrejestruj(this);
            bramkaUI.disable();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getNumer() throws RemoteException {
        return numer;
    }

    public static void main(String[] args) {
        try {
            Bramka b = new Bramka();
            new Thread(() -> Application.launch(BramkaUI.class)).start();
            BramkaUI bramkaUI = BramkaUI.waitForBramkaUI(b);
        }catch (Exception e){e.printStackTrace();}
    }


    //prywatne metody ktore beda pod guzikami bramki
    public void dodajWejscie(){
        System.err.println("dodano wejscie");
        statystyki[0]++;
        if(monitor!=null){
            try {
                monitor.koniecznaAktualizacja();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
    public void dodajWyjscie(){
        System.err.println("dodano wyjscie");
        statystyki[1]++;
        if(monitor!=null){
            try {
                monitor.koniecznaAktualizacja();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void zarejestrujBramke()throws Exception{
            Registry registry = LocateRegistry.getRegistry(1099);
            ICentrala c = (ICentrala) registry.lookup("central");
            this.numer = c.zarejestruj(this);
            monitor = c.getMonitor();
            if(monitor!=null){monitor.koniecznaAktualizacja();}
            System.err.println("Moj nr to: " + getNumer());
            //gate_number_text.setText(String.valueOf(numer));
    }
}
