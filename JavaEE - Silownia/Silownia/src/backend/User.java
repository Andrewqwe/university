package backend;

import java.io.Serializable;

/**
 * Created by Andrzej on 2017-01-04.
 */
public class User implements Serializable{
    public String id = null;
    public String imie = null;
    public String nazwisko = null;
    public String wiek = null;
    public String plec = null;
    public String typ_karnetu = null;
    public String data = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setWiek(String wiek) {
        this.wiek = wiek;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public void setTyp_karnetu(String typ_karnetu) {
        this.typ_karnetu = typ_karnetu;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getWiek() {
        return wiek;
    }

    public String getPlec() {
        return plec;
    }

    public String getTyp_karnetu() {
        return typ_karnetu;
    }

    public String getData() {
        return data;
    }

    public String getMail() {
        return mail;
    }

    public String mail = null;

    public void SetAll(String i,String n,String w,String p,String t,String d,String m,String nr_id)
    {
        imie=i;
        nazwisko=n;
        wiek=w;
        plec = p;
        typ_karnetu = t;
        data = d;
        mail = m;
        id=nr_id;
    }
}
