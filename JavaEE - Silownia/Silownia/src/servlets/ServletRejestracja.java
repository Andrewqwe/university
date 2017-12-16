package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by Andrzej on 2016-12-21.
 */
@WebServlet("/rejestracja")
public class ServletRejestracja extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Uimie = req.getParameter("firstname");
        String Unazwisko = req.getParameter("secondname");
        String Uplec = req.getParameter("gender");
        int Uwiek = Integer.parseInt(req.getParameter("age"));
        String Uemail = req.getParameter("usermail");
        String Uhaslo = req.getParameter("userpass");
        Uplec = "M";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness","root","root");
            Statement st = con.createStatement();
            String post = "INSERT INTO klienci(imie, nazwisko, wiek, plec, typ_karnetu, data_wygasniecia_karnetu, email, haslo) VALUES('"
                    + Uimie +"','" + Unazwisko + "','" + Uwiek + "','" + Uplec + "','" + "F'," + "CURRENT_DATE" + ",'" + Uemail + "','" + Uhaslo + "');";
            System.out.println("OTO POST: " + post);
            st.executeUpdate(post);
            st.close();
            //con.commit(); zmienic autocommit na off zeby dzialalo
            con.close();
            resp.sendRedirect("/");    //TODO: Dodać jakiś komunikat o poprawnym zarejestrowaniu, albo wysłac uzytkownika na strone logowania

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/pages/Rejestracja/register_page.jsp").include(req,resp);

    }
}
