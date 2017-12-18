package servlets;

import backend.Lesson;
import backend.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrzej on 2017-01-05.
 */
@WebServlet("/UserPanel")
public class ServletUserPanel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("wylogoj")!=null)
        {
            req.getSession().invalidate();
            resp.sendRedirect("/");
        }
        else {
            String button = req.getParameter("zapis");
            if (!button.isEmpty()) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver"); //TODO: poszukac lepszego rozwiazania
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness", "root", "root");
                        Statement st = con.createStatement();
                        String select = "SELECT * FROM zapisani WHERE Klienci_ID ="
                                + ((User) req.getSession().getAttribute("loggedIn")).id + " AND Zajecia_ID = "
                                + button;
                        ResultSet resultSet = st.executeQuery(select);
                        if (resultSet.next()) {
                            //System.out.println("Wypisano z zajec o id = " + button);
                            String delete = "DELETE FROM zapisani WHERE Klienci_ID ="
                                    + ((User) req.getSession().getAttribute("loggedIn")).id + " AND Zajecia_ID = "
                                    + button + ";";
                            //System.out.println("Wykonano zapytanie : " + delete);
                            st.execute(delete);
                        } else {
                            //System.out.println("Zapisano na zajęcia o id = " + button);
                            String insert = "INSERT INTO Zapisani (Zajecia_ID, Klienci_ID) VALUES (" + button + "," + ((User) req.getSession().getAttribute("loggedIn")).id + ");";
                            //System.out.println("Wykonano zapytanie : " + insert);
                            st.execute(insert);
                        }
                        st.close();
                        con.close();

                        resp.sendRedirect("/UserPanel");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                super.doPost(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("loggedIn")!=null) {
            resp.setCharacterEncoding("UTF-8");
            List<Lesson> lekcje = new LinkedList<>();
            List<Integer> zapisany = new LinkedList<>();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness", "root", "root");
                Statement st = con.createStatement();
                String post = "SELECT z1.dla_kogo, z1.ID, t.imie, t.nazwisko, z1.nazwa,z1.dzien_tygodnia, z1.godzina_rozpoczecia, z1.godzina_zakonczenia, z1.ID_sali, s.liczba_miejsc, s.liczba_miejsc - COUNT(z2.Zajecia_ID) as wolne_miejsca FROM Zajecia z1\n" +
                        "INNER JOIN Trenerzy t ON z1.ID_trenera=t.ID\n" +
                        "LEFT OUTER JOIN Zapisani z2 ON z2.Zajecia_ID=z1.ID\n" +
                        "INNER JOIN Sale s ON s.ID=z1.ID_sali\n" +
                        "GROUP BY z1.ID HAVING dla_kogo ='" + ((User) req.getSession().getAttribute("loggedIn")).plec + "';";
                ResultSet resultSet = st.executeQuery(post);
                while(resultSet.next())
                {
                    Lesson l = new Lesson();
                    l.setNazwa_zajec(resultSet.getString("nazwa"));
                    l.setG_rozpoczecia(resultSet.getString("godzina_rozpoczecia"));
                    l.setG_zakonczenia(resultSet.getString("godzina_zakonczenia"));
                    l.setIlosc_miejsc(resultSet.getString("wolne_miejsca"));
                    l.setProwadzacy(resultSet.getString("imie")+ " " +resultSet.getString("nazwisko"));
                    l.setNr_sali(resultSet.getString("ID_sali"));
                    l.setDla_kogo(resultSet.getString("dla_kogo"));
                    l.setID(resultSet.getString("ID"));
                    l.setDzien(resultSet.getString("dzien_tygodnia"));
                    lekcje.add(l);
                }
                String zapytanie= "SELECT * From zapisani WHERE Klienci_ID =" + ((User) req.getSession().getAttribute("loggedIn")).id + ";";
                ResultSet resultSet2 = st.executeQuery(zapytanie);
                while(resultSet2.next())
                {
                    zapisany.add(Integer.parseInt(resultSet2.getString("Zajecia_ID")));
                }
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            zapisany.contains(5);
            req.setAttribute("lekcje", lekcje);
            req.setAttribute("zapisany",zapisany);
            req.getRequestDispatcher("/pages/Panel_uzytkownika/user_panel.jsp").include(req, resp);
        }else{resp.sendRedirect("/logowanie");};
    }
}
