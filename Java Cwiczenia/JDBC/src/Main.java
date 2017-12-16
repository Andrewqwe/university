import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
    public static Database database = new Database();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Witaj w programie elektronicznej rejestracji pacjentow");
        System.out.println("Nacisnij enter aby polaczyc sie z baza danych");
        while(true) {
            br.readLine();
            try {
                database.connect();
                break;
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Problem z polaczeniem\nNacisnij enter aby sprobowac ponownie");
            }
        }
        System.out.println("\n");
        boolean exit=false;
        while(!exit) {
            System.out.print("\n==================================================\n" +
                    "Co chcesz zrobić ?\n1.Dodac nowego pacjenta\n2.Dodac lekarza\n" +
                    "3.Dodac nowa wizyte\n4.Wyswietlic wszystkie wizyty\n5.Wyswietlic wizyty danego pacjenta\n" +
                    "6.Wyjsc z programu\nWybor: ");
            int choice = Integer.parseInt(br.readLine());
            switch (choice){
                case 1:{
                    User u = creatingUserDialog();
                    if(u!=null) {
                        database.sendUserToDatabase(u);
                    }
                    break;
                }
                case 2:{
                    Doctor d = creatingDoctorDialog();
                    if(d!=null){
                        database.sendDoctorToDatabase(d);
                    }
                    break;
                }
                case 3:{
                    Visit v = creatingVisitDialog();
                    database.sendVisitToDatabase(v);
                    break;
                }
                case 4:{
                    for(Visit v : database.getAllVisits()){
                        System.out.println(v);
                    }
                    break;
                }
                case 5:{
                    System.out.println("Podaj pesel");
                    for(Visit v : database.getAllVisits(br.readLine())){
                        System.out.println(v);
                    }
                    break;
                }
                case 6:{
                    exit=true;
                    break;
                }
            }
        }
        database.closeConnection();
    }

    public static User creatingUserDialog(){
        try {
            User user = new User();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\nImie:");
            user.setName(br.readLine());
            System.out.print("Nazwisko: ");
            user.setSurname(br.readLine());
            System.out.print("Wiek:");
            user.setAge(Integer.parseInt(br.readLine()));
            System.out.print("Pesel: ");
            user.setPesel(br.readLine());
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Doctor creatingDoctorDialog(){
        try {
            Doctor doctor = new Doctor();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\nImie:");
            doctor.setName(br.readLine());
            System.out.print("Nazwisko: ");
            doctor.setSurname(br.readLine());
            return doctor;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Visit creatingVisitDialog(){
        try {
            Visit visit = new Visit();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Podaj pesel pacjenta: ");
            User user = database.getUserFromDatabase(br.readLine());
            if(user!=null) {
                visit.setPesel_pacjenta(user.getPesel());
            }else{
                System.err.println("Brak pacjenta w bazie danych");
                throw new Exception();
            }
            System.out.println("Dostepni lekarze: ");
            for(Doctor d : database.getDoctorsList()){
                System.out.println(d);
            }
            System.out.print("Wprowadz id lekarza: ");
            visit.setDoc_id(Integer.parseInt(br.readLine()));
            System.out.print("Podaj nr pokoju: ");
            visit.setRoom(br.readLine());
            System.out.print("Podaj date w formacie dd-mm-yyyy: ");
            visit.setDate(br.readLine());
            System.out.print("Podaj godzine np 12:30: ");
            visit.setHour(br.readLine());
            return visit;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
