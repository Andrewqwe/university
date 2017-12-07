package com.andrzej;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.CountDownLatch;

public class MyComponentUI extends Application {

    public static final CountDownLatch latch = new CountDownLatch(1);
    private static MyComponentUI myComponentUI;
    public TextArea textArea;
    public boolean started = false;

    public MyComponentUI() {
        myComponentUI = this;
    }

    public static MyComponentUI waitForMyComponentUI() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myComponentUI;
    }

    public void setRefreshingUtility(MyJNIUtility utility){

        final Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis( 500 ),
                        event -> {
                            String s = "Working set: " + utility.getProcessWorkingSet() / 1024 + "K \n";
                            s += "VM size:     " + utility.getProcessVMSize() / 1024 + "K\n";
                            textArea.setText(s);
                        }
                )
        );
        timeline.setCycleCount( Animation.INDEFINITE );
        timeline.play();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MyJNIUi.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My JNI Demo");
        primaryStage.show();
    }

    public void testMethod(MouseEvent mouseEvent) {
        if(!started) {
            this.setRefreshingUtility(new MyJNIUtility());
            started = true;
        }
    }
}
