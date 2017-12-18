package servlets;

import backend.Lesson;
import backend.Sala;
import backend.Trener;
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
 * Created by Andrzej on 2017-01-07.
 */
@WebServlet("/AdminPanel")
public class ServletAdminPanel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if ((req.getSession().getAttribute("loggedIn"))!=null) {
            if (((User) req.getSession().getAttribute("loggedIn")).typ_karnetu.equals("A")) {
                if (req.getParameter("button") != null) {
                    String button = req.getParameter("button");
                    if (button.equals("1"))  //Wylogowywanie
                    {
                        req.getSession().invalidate();
                        resp.sendRedirect("/");
                    } else {
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness", "root", "root");
                            Statement st = con.createStatement();
                            ResultSet resultSet;
                            switch (button) {
                                case "2":   //Użytkownicy
                                {
                                    String select = "SELECT * FROM klienci";
                                    resultSet = st.executeQuery(select);
                                    List<User> klienci = new LinkedList<>();
                                    while (resultSet.next()) {
                                        User temp = new User();
                                        String imie = resultSet.getString("imie");
                                        String nazwisko = resultSet.getString("nazwisko");
                                        String wiek = resultSet.getString("wiek");
                                        String plec = resultSet.getString("plec");
                                        String typ = resultSet.getString("typ_karnetu");
                                        String data = resultSet.getString("data_wygasniecia_karnetu");
                                        String mail = resultSet.getString("email");
                                        String id = resultSet.getString("ID");
                                        temp.SetAll(imie, nazwisko, wiek, plec, typ, data, mail, id);
                                        klienci.add(temp);
                                        req.getSession().setAttribute("wyswietl", klienci);
                                    }
                                    break;
                                }
                                case "3":   //Zajęcia
                                {

                                    String select = "SELECT z.*, t.imie, t.nazwisko FROM zajecia z LEFT OUTER JOIN trenerzy t ON z.ID_trenera=t.ID ORDER BY dzien_tygodnia ASC;";
                                    resultSet = st.executeQuery(select);
                                    List<Lesson> zajecia = new LinkedList<>();
                                    while (resultSet.next()) {
                                        Lesson l = new Lesson();
                                        l.setID(resultSet.getString("ID"));
                                        l.setNazwa_zajec(resultSet.getString("nazwa"));
                                        l.setProwadzacy(resultSet.getString("imie")
                                                + " " + resultSet.getString("nazwisko"));
                                        l.setG_rozpoczecia(resultSet.getString("godzina_rozpoczecia"));
                                        l.setG_zakonczenia(resultSet.getString("godzina_zakonczenia"));
                                        l.setNr_sali(resultSet.getString("ID_sali"));
                                        l.setDla_kogo(resultSet.getString("dla_kogo"));
                                        l.setDzien(resultSet.getString("dzien_tygodnia"));
                                        zajecia.add(l);
                                    }
                                    req.getSession().setAttribute("wyswietl", zajecia);
                                    break;
                                }
                                case "4":   //Trenerzy
                                {
                                    String select = "SELECT * FROM trenerzy";
                                    resultSet = st.executeQuery(select);
                                    List<Trener> trenerzy = new LinkedList<>();
                                    while (resultSet.next()) {
                                        Trener t = new Trener();
                                        t.setID(resultSet.getString("ID"));
                                        t.setImie(resultSet.getString("imie"));
                                        t.setNazwisko(resultSet.getString("nazwisko"));
                                        t.setPensja(resultSet.getInt("pensja"));
                                        trenerzy.add(t);
                                    }
                                    req.getSession().setAttribute("wyswietl", trenerzy);
                                    break;
                                }
                                case "5":   //Pomieszczenia
                                {
                                    String select = "SELECT * FROM sale";
                                    resultSet = st.executeQuery(select);
                                    List<Sala> sale = new LinkedList<>();
                                    while (resultSet.next()) {
                                        Sala s = new Sala();
                                        s.setID(resultSet.getString("ID"));
                                        s.setLiczba_miejsc(resultSet.getString("liczba_miejsc"));
                                        s.setTyp(resultSet.getString("typ"));
                                        sale.add(s);
                                    }
                                    req.getSession().setAttribute("wyswietl", sale);
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        resp.setCharacterEncoding("UTF-8");
                        req.getRequestDispatcher("/pages/Panel_administratora/admin_panel.jsp").include(req, resp);
                    }
                } else
                    {
                    resp.setCharacterEncoding("UTF-8");
                    req.getRequestDispatcher("/pages/Panel_administratora/admin_panel.jsp").include(req, resp);
                    }
            } else {
                resp.sendRedirect("/");
            }
        }else
            {
               resp.sendRedirect("/");
            }
    }
}
