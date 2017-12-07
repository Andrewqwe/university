import java.sql.*;
import java.util.ArrayList;

public class Database {

    // JDBC driver name and database URL
    private static final String DB_URL = "jdbc:mysql://localhost/lab5";
    //private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection conn = null;

    public void connect() throws SQLException { // laczy z baza danych i tworzy statement
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected !");
    }

    public void closeConnection(){
        if(conn!=null){
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendUserToDatabase(User user){
        try {
            String sql = "insert into users (pesel,name,surname,age) values (?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,user.getPesel());
            statement.setString(2,user.getName());
            statement.setString(3,user.getSurname());
            statement.setInt(4,user.getAge());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void sendVisitToDatabase(Visit v) {
        try {
            String sql = "insert into visits (pesel,id_doktora,date,hour,room) values (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,v.getPesel_pacjenta());
            statement.setInt(2,v.getDoc_id());
            statement.setString(3,v.getDate());
            statement.setString(4,v.getHour());
            statement.setString(5,v.getRoom());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void sendDoctorToDatabase(Doctor doctor) {
        try {
            String sql = "insert into doctors (name,surname) values (?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,doctor.getName());
            statement.setString(2,doctor.getSurname());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserFromDatabase(String pesel) {
        try {
            User u = new User();
            String sql = "select * from users WHERE pesel LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,pesel);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            u.setName(resultSet.getString("name"));
            u.setSurname(resultSet.getString("surname"));
            u.setPesel(resultSet.getString("pesel"));
            u.setAge(resultSet.getInt("age"));
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Doctor> getDoctorsList(){
        ArrayList<Doctor> doctors = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            String sql = "select * from doctors;";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Doctor doctor = new Doctor();
                doctor.setName(resultSet.getString("name"));
                doctor.setSurname(resultSet.getString("surname"));
                doctor.setId(resultSet.getInt("id"));
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctors;
    }

    public ArrayList<Visit> getAllVisits() {
        ArrayList<Visit> visits = new ArrayList<>();

        try {
            Statement statement = conn.createStatement();
            String sql = "select * from visits;";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Visit visit = new Visit();
                visit.setPesel_pacjenta(resultSet.getString("pesel"));
                visit.setDate(resultSet.getString("date"));
                visit.setDoc_id(resultSet.getInt("id_doktora"));
                visit.setHour(resultSet.getString("hour"));
                visit.setRoom(resultSet.getString("room"));
                visits.add(visit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return visits;
    }

    public ArrayList<Visit> getAllVisits(String s) {
        ArrayList<Visit> visits = new ArrayList<>();

        try {
            String sql = "select * from visits where pesel LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,s);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Visit visit = new Visit();
                visit.setDate(resultSet.getString("date"));
                visit.setPesel_pacjenta(resultSet.getString("pesel"));
                visit.setDoc_id(resultSet.getInt("id_doktora"));
                visit.setHour(resultSet.getString("hour"));
                visit.setRoom(resultSet.getString("room"));
                visits.add(visit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return visits;
    }
}
