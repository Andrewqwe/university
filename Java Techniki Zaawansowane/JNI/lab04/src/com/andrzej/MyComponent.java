package com.andrzej;

import javafx.application.Application;

public class MyComponent {
    private static MyComponentUI componentUI;

    public static void main(String[] args) throws Exception {
        System.loadLibrary("MyUtility");
        System.out.println("DLL loaded");
        MyJNIUtility utility = new MyJNIUtility();
        try{
            new Thread(() -> Application.launch(MyComponentUI.class)).start();
            componentUI = MyComponentUI.waitForMyComponentUI();
            Thread.sleep(5000);
            componentUI.setRefreshingUtility(utility);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
