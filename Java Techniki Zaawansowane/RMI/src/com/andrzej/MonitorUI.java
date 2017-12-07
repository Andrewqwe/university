package com.andrzej;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class MonitorUI extends Application {

    public static final CountDownLatch latch = new CountDownLatch(1);
    public Monitor monitor;
    public static MonitorUI monitorUI = null;
    public Button button_on;
    public Button button_off;
    public TextArea monitor_text_view;
    public ICentrala centrala = null;

    public MonitorUI() {
        monitorUI = this;
        monitor = Monitor.getMonitor();
        Monitor.monitorUI = this;
    }

    public static MonitorUI waitForMonitorUI(){
        try{
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return monitorUI;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Monitor.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Monitor");
        primaryStage.show();
    }


    public void button_on_clicked(ActionEvent actionEvent) {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            ICentrala c = (ICentrala) registry.lookup("central");
            //c.zarejestrujMonitor(monitor);
            this.centrala = c;
            monitor.zarejestrujMonitor();
        }catch (Exception e){
            e.printStackTrace();
            //System.err.println("Problem monitora" + e.getMessage());
        }
    }

    public void refresh(){
        if(this.centrala!=null){
            try {
                monitor_text_view.clear();
                ArrayList<Object> bramki = centrala.getAktywneBramki();
                for(Object o : bramki){
                    IBramka b = (IBramka) o;
                    int stat[] = b.getStatystyka();
                    String text = ("Bramka: " + b.getNumer() + " Wejsc: " + stat[0] + " Wyjsc " + stat[1] + "\n");
                    monitor_text_view.appendText(text);
                }
            }catch (Exception e){
                e.printStackTrace();
                //System.err.println("Problem z odswiezaniem: " + e.getMessage());
            }
        }
    }
    public void button_off_clicked(ActionEvent actionEvent) {
        if(this.centrala!=null){
            try {
                centrala.wyrejestrujMonitor();
                monitor_text_view.clear();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
