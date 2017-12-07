package com.andrzej;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.concurrent.CountDownLatch;

public class CentralaUI extends Application {

    public TextArea table_gates;
    public Button button_delete_gate;
    public static final CountDownLatch latch = new CountDownLatch(1);
    public Centrala centrala;
    public static CentralaUI centralaUI = null;
    public Button button_refresh;
    public TextField text_field_ID_selection;

    public static CentralaUI waitForCentralaUI(){
        try{
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return centralaUI;
    }

    public CentralaUI(){
        centralaUI = this;
        centrala = Centrala.getCentrala();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Centrala.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Central");
        primaryStage.show();
    }

    public void delete_gate_button_clicked(ActionEvent actionEvent) {
        int selection = Integer.parseInt(text_field_ID_selection.getText());
        try {
            for (Object o : centrala.bramki) {
                IBramka bramka = (IBramka) o;
                if (bramka.getNumer() == selection) {
                    centrala.wyrejestruj(o);
                    break;
                }
            }
        }catch (Exception e){
            System.err.println("Problem z usuwaniem");
            e.printStackTrace();
        }
        //table_gates.setText("LOL");
    }
    public void refresh(){
        table_gates.clear();
        for(Object o : centrala.bramki) {
            IBramka bramka = (IBramka) o;
            int number = 0;
            try {
                number = bramka.getNumer();
                table_gates.appendText("ID - " + number + "\n");
            } catch (Exception e) {
                centrala.bramki.remove(centrala.bramki.indexOf(o));
            }
        }
        if(centrala.monitor!=null){
            table_gates.appendText("Monitor - online");
        }else{
            table_gates.appendText("Monitor - offline");
        }
    }

    public void button_refresh_button_clicked(ActionEvent actionEvent) {
        refresh();
        refresh();
    }
}
