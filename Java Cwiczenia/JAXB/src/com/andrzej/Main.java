package com.andrzej;

import com.andrzej.daneAdresowe.DaneAdresoweType;
import com.andrzej.zyczenia.ZyczeniaType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        DaneAdresoweType dane = daneAdresoweXMLtoJava("src/com/andrzej/daneAdresowe/daneAdresowe.xml");
        ZyczeniaType zyczenia = zyczeniaXMLtoJava("src/com/andrzej/zyczenia/zyczenia.xml");
        //TODO: Change to relative path
        boolean flag = true;
        while (flag){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(dane);
            System.out.println(zyczenia);
            System.out.println("1.Edytuj dane adresowe\n2.Edytuj zyczenia\n3.Zapisz dane adresowe w resources" +
                    "\n4.Zapisz zyczenia w resources\n5.Generuj html");
            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1: {
                    System.out.println("1.Imie\n2.Nazwisko\n3.Miasto\n4.Adres");
                    choice = Integer.parseInt(br.readLine());
                    if (choice == 1) {
                        System.out.print("Imie: ");
                        dane.setImie(br.readLine());
                    } else if (choice == 2) {
                        System.out.print("Nazwisko: ");
                        dane.setNazwisko(br.readLine());
                    } else if (choice == 3) {
                        System.out.print("Miasto: ");
                        dane.setMiasto(br.readLine());
                    } else if (choice == 4) {
                        System.out.print("Adres: ");
                        dane.setAdres(br.readLine());
                    }
                }
                break;
                case 2: {
                    System.out.println("1.Tytul\n2.Tresc");
                    choice = Integer.parseInt(br.readLine());
                    if (choice == 1) {
                        zyczenia.setTytul(br.readLine());
                    } else if (choice == 2) {
                        zyczenia.setTresc(br.readLine());
                    }
                }
                break;
                case 3: {
                    javaToDaneAdresoweXML("src/com/andrzej/resources/dane.xml",dane);
                }
                break;
                case 4: {
                    javaToZyczeniaXML("src/com/andrzej/resources/zycz.xml",zyczenia);
                }
                break;
                case 5: {
                    TransformerFactory factory = TransformerFactory.newInstance();
                    Source source = new StreamSource("src/com/andrzej/styles/style.xsl");
                    String outputFile ="Card.html";
                    OutputStream outputStream = new FileOutputStream(outputFile);
                    Transformer transformer = factory.newTransformer(source);
                    transformer.transform(source, new StreamResult(outputStream));
                }
                break;
            }
        }

    }


    public static DaneAdresoweType daneAdresoweXMLtoJava(String dir) throws Exception {
        File file = new File(dir);
        JAXBContext jaxbContext = JAXBContext.newInstance(DaneAdresoweType.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (DaneAdresoweType)unmarshaller.unmarshal(file);
    }

    public static void javaToDaneAdresoweXML(String dir,DaneAdresoweType dane) throws Exception{
        File file = new File(dir);
        JAXBContext jaxbContext = JAXBContext.newInstance(DaneAdresoweType.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(dane,file);
    }

    public static ZyczeniaType zyczeniaXMLtoJava(String dir) throws Exception {
        File file = new File(dir);
        JAXBContext jaxbContext = JAXBContext.newInstance(ZyczeniaType.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (ZyczeniaType)unmarshaller.unmarshal(file);
    }

    public static void javaToZyczeniaXML(String dir,ZyczeniaType zyczenia) throws Exception{
        File file = new File(dir);
        JAXBContext jaxbContext = JAXBContext.newInstance(ZyczeniaType.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(zyczenia,file);
    }

}
