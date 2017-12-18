package servlets;

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

//import java.sql.Connection;

@WebServlet("/logowanie")
public class ServletLogowanie extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputMail = req.getParameter("usermail");
        String inputPassword = req.getParameter("userpass");
        //TODO: autoryzacja

        try{
            Class.forName("com.mysql.jdbc.Driver"); //TODO: poszukac lepszego rozwiazania
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness","root","root");
            Statement st = con.createStatement();
            String select = "SELECT * FROM klienci WHERE email = '" + inputMail +"'";
            ResultSet resultSet = st.executeQuery(select);
            if(resultSet.next())
            {
                if(inputPassword.equals(resultSet.getString("haslo"))) {
                    String imie = resultSet.getString("imie");
                    String nazwisko = resultSet.getString("nazwisko");
                    String wiek = resultSet.getString("wiek");
                    String plec = resultSet.getString("plec");
                    String typ = resultSet.getString("typ_karnetu");
                    String data = resultSet.getString("data_wygasniecia_karnetu");
                    String mail = resultSet.getString("email");
                    String id = resultSet.getString("ID");

                    User user = new User();
                    user.SetAll(imie,nazwisko,wiek,plec,typ,data,mail,id);
                    req.getSession().setAttribute("loggedIn",user);
                    //System .out.println("Zalogowano jako : " + imie + " " + nazwisko + " " + wiek + " lat");

                    if(typ.equals("A") || (typ.equals("a")))    //Decyzja czy uzytkownik to admin
                    {
                        resp.sendRedirect("/AdminPanel");
                    }else {
                        resp.sendRedirect("/UserPanel");
                    }
                }else
                    {
                        //System.out.println("Błąd logowania");
                        resp.sendRedirect("/logowanie");
                    }
            }else
                {
                    //System.out.println("Błąd logowania");
                    resp.sendRedirect("/logowanie");
                }
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/logowanie");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

            if((req.getSession().getAttribute("loggedIn"))!=null) {
                if ((((User) req.getSession().getAttribute("loggedIn")).typ_karnetu.equals("A"))) {
                    resp.sendRedirect("/AdminPanel");
                } else {
                    resp.sendRedirect("/UserPanel");
                }
            }else {
                req.getRequestDispatcher("/pages/Logowanie/login_page.jsp").include(req, resp);
            }
    }
    //TODO: zmienic grafike w mobilku
}
