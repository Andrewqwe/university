package backend;

import java.util.ArrayList;

/**
 * Created by Andrzej on 2016-12-01.
 */
public class Storage {

    public class worker
    {
        private String name;
        private String phone;

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    private ArrayList<worker> magazyn=new ArrayList<>();

    public void add(String name,String phone)
    {
        worker temp=new worker();
        temp.setName(name);
        temp.setPhone(phone);
        this.magazyn.add(temp);
    }

    public ArrayList<worker> getMagazyn() {
        return magazyn;
    }
}
