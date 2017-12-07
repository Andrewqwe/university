import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("resources/deleteAll.js"));
        engine.eval(new FileReader("resources/mailRegexCheck.js"));
        engine.eval(new FileReader("resources/clearAndGetWordsArray.js"));
        Invocable invocable = (Invocable) engine;
        while (true) {
            System.out.println("\n========================================\n" +
                    "1.Usun wszystkie wystapienia danej litery w tekscie\n" +
                    "2.Wyczysc niepotrzebne spacje w tekscie i zwroc array ze wszystkimi slowami\n" +
                    "3.Sprawdzenie poprawnosci maili\n4.Wyjscie");
            int wybor = Integer.parseInt(br.readLine());
            switch (wybor) {
                case 1: {
                    BufferedReader reader = new BufferedReader(new FileReader("resources/deleteTest.txt"));
                    String tekst = reader.readLine();
                    System.out.println("Wczytany tekst: " + tekst);
                    System.out.print("Podaj znak ktory chcesz usunac: ");
                    char c = (br.readLine()).charAt(0);
                    String s = (String) invocable.invokeFunction("deleteAll",tekst,c);
                    System.out.println("Wynik operacji: " + s);
                    FileWriter fileWriter = new FileWriter("results/wynik1.txt");
                    fileWriter.write(s);
                    fileWriter.close();
                    break;
                }
                case 2:{
                    BufferedReader reader = new BufferedReader(new FileReader("resources/clearAndGetWordsArray.txt"));
                    String tekst = reader.readLine();
                    System.out.println("Wczytano: " + tekst);
                    ScriptObjectMirror result = (ScriptObjectMirror) invocable.invokeFunction("trimAndSplit",tekst);
                    String tab[] = result.to(String[].class);
                    System.out.println("Wynik: " + Arrays.toString(tab));
                    FileWriter fileWriter = new FileWriter("results/wynik2.txt");
                    for(String s : tab) {
                        fileWriter.write(s + "\n");
                    }
                    fileWriter.close();
                    break;
                }
                case 3:{
                    FileWriter fileWriter = new FileWriter("results/wynik3.txt");
                    BufferedReader reader = new BufferedReader(new FileReader("resources/mailTest.txt"));
                    String line;
                    while((line = reader.readLine())!=null){
                        System.out.print(line);
                        if((Boolean) invocable.invokeFunction("validateEmail", line)){
                            fileWriter.write(line +"\n");
                            System.out.println("    <---- Poprawny");
                        }else{
                            System.out.println();
                        }
                    }
                    System.out.println("Poprawne maile zostaly zapisane do pliku wyniki3.txt");
                    fileWriter.close();
                    break;
                }
                case 4:{
                    return;
                }
            }
        }
    }
}