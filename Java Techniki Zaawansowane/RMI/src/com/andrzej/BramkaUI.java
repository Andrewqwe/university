package com.andrzej;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.util.concurrent.CountDownLatch;

public class BramkaUI extends Application {
    public Button button_wyrejestruj;
    public Button button_zarejestruj;
    public Button button_wyjscie;
    public Button button_wejscie;
    public Text gate_number_text;
    public Bramka bramka;
    public static final CountDownLatch latch = new CountDownLatch(1);
    public static BramkaUI bramkaUI = null;

    public BramkaUI() {
        bramkaUI = this;
        Bramka.bramkaUI = this;
        bramka = Bramka.getBramka();
    }

    public static BramkaUI waitForBramkaUI(Bramka b){
        try{
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return bramkaUI;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Bramka.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gate");
        primaryStage.show();
    }

    public void button_wejscie_clicked(ActionEvent actionEvent) {
        bramka.dodajWejscie();
    }

    public void button_wyjscie_clicked(ActionEvent actionEvent) {
        bramka.dodajWyjscie();
    }

    public void button_zarejestruj_clicked(ActionEvent actionEvent) {
        try {
            bramka.zarejestrujBramke();
            this.gate_number_text.setText(String.valueOf(bramka.getNumer()));
            enable();
        } catch (Exception e) {
            e.printStackTrace();
            gate_number_text.setText("registration error");
        }
    }

    public void button_wyrejestruj_clicked(ActionEvent actionEvent) {
        try {
            bramka.zamknijBramke();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        gate_number_text.setText("");
        disable();
    }


    public void disable(){
        button_wejscie.setDisable(true);
        button_wyjscie.setDisable(true);
        button_wyrejestruj.setDisable(true);
        button_zarejestruj.setDisable(false);
        gate_number_text.setText("");
    }
    public void enable(){
        button_wejscie.setDisable(false);
        button_wyjscie.setDisable(false);
        button_wyrejestruj.setDisable(false);
        button_zarejestruj.setDisable(true);
    }

}
