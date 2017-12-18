package backend;

/**
 * Created by Andrzej on 2017-01-05.
 */
public class Lesson {
    public String ID;
    public String nazwa_zajec;
    public String prowadzacy;
    public String g_rozpoczecia;
    public String g_zakonczenia;
    public String nr_sali;
    public String ilosc_miejsc;
    public String dla_kogo;
    public String dzien;

    public String getDzien() {
        return dzien;
    }

    public void setDzien(String dzien) {
        switch (dzien)
        {
            case "1":{this.dzien="Poniedziałek";}break;
            case "2":{this.dzien="Wtorek";}break;
            case "3":{this.dzien="Środa";}break;
            case "4":{this.dzien="Czwartek";}break;
            case "5":{this.dzien="Piątek";}break;
            case "6":{this.dzien="Sobota";}break;
            case "7":{this.dzien="Niedziela";}break;
            default:{this.dzien="Codziennie";}break;
        }
    }

    public Lesson(String nazwa_zajec, String prowadzacy, String g_rozpoczecia, String g_zakonczenia, String nr_sali, String ilosc_miejsc) {

        this.nazwa_zajec = nazwa_zajec;
        this.prowadzacy = prowadzacy;
        this.g_rozpoczecia = g_rozpoczecia;
        this.g_zakonczenia = g_zakonczenia;
        this.nr_sali = nr_sali;
        this.ilosc_miejsc = ilosc_miejsc;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setDla_kogo(String dla_kogo) {
        this.dla_kogo = dla_kogo;
    }

    public void setNazwa_zajec(String nazwa_zajec) {
        this.nazwa_zajec = nazwa_zajec;
    }

    public void setProwadzacy(String prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public void setG_rozpoczecia(String g_rozpoczecia) {
        this.g_rozpoczecia = g_rozpoczecia;
    }

    public void setG_zakonczenia(String g_zakonczenia) {
        this.g_zakonczenia = g_zakonczenia;
    }

    public void setNr_sali(String nr_sali) {
        this.nr_sali = nr_sali;
    }

    public Lesson() {}

    public void setIlosc_miejsc(String ilosc_miejsc) {
        this.ilosc_miejsc = ilosc_miejsc;
    }

    public String getNazwa_zajec() {
        return nazwa_zajec;
    }

    public String getProwadzacy() {
        return prowadzacy;
    }

    public String getG_rozpoczecia() {
        return g_rozpoczecia;
    }

    public String getG_zakonczenia() {
        return g_zakonczenia;
    }

    public String getNr_sali() {
        return nr_sali;
    }

    public String getIlosc_miejsc() {
        return ilosc_miejsc;
    }

    public String getDla_kogo() {
        return dla_kogo;
    }

    public String getID() {
        return ID;
    }
}
