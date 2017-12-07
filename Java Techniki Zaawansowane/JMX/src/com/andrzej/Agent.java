package com.andrzej;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

public class Agent {

    public static void main(String[] args) throws Exception {
        System.out.println("Witaj Swiecie!");
        MyEditor editor = new MyEditor();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        editor.setMapping("test");
        editor.setSwap("dziala");
        //registerWithJmxAgent(editor);
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.andrzej:type=MyEditor");
        server.registerMBean(editor, name);
        while (!"exit".equals(input = br.readLine())) {
            System.out.println(editor.calculateText(input));
        }

    }

    public static void registerWithJmxAgent(MyEditor editor) throws Exception {

    }
}