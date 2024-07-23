package gd.hyperskill.contacts.interfaces;


import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class Contact {
    public static int currentRegister;
    private int registerNumber;
    private String phone;
    private String timeCreated;
    private String timeLastEdit;

   public Contact() {
       registerNumber = ++currentRegister;

       String now = getNow();
       this.timeCreated = now;
       this.timeLastEdit = now;
   }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public int getRegisterNumber() { return registerNumber; }

    public String getTimeCreated() { return timeCreated; }
    public String getTimeLastEdit() { return timeLastEdit; }
    public void logEdit() { this.timeLastEdit = getNow(); }

    private String getNow() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        return formatter.format(new Date());
    }

    public abstract String showInfoDetail();
    public abstract String[] getAllData();

}
