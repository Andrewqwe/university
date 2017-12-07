public class Visit {
    private String pesel_pacjenta;
    private int doc_id;
    private String date;
    private String hour;
    private String room;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPesel_pacjenta() {
        return pesel_pacjenta;
    }

    public void setPesel_pacjenta(String pesel_pacjenta) {
        this.pesel_pacjenta = pesel_pacjenta;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Wizyta{ " +
                "pesel_pacjenta='" + pesel_pacjenta + '\'' +
                ", doc_id=" + doc_id +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", room='" + room + '\'' +
                " }";
    }
}
