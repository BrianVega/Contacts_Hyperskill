package gd.hyperskill.contacts.contacts;

import gd.hyperskill.contacts.interfaces.Contact;

public class Person extends Contact {

    private String name;
    private String surname;
    private String birthDate = "[no data]";
    private String gender = "[no data]";

    public Person(){
    }
    public void setName(String name) {this.name = name;}
    public void setSurname(String surname) {this.surname = surname;}
    public void setBirthDate(String birthDate) {this.birthDate = birthDate;}
    public void setGender(String gender) {this.gender = gender;}

    @Override
    public String showInfoDetail() {
        return String.format("Name: %s\n" +
                "Surname: %s\n" +
                "Birth date: %s\n" +
                "Gender: %s\n" +
                "Number: %s\n" +
                "Time created: %s\n" +
                "Time last edit: %s", name, surname, birthDate, gender,
                super.getPhone(), super.getTimeCreated(), super.getTimeLastEdit());
    }

    @Override
    public String[] getAllData() {
        return new String[]{name, surname, super.getPhone()};
    }

    @Override
    public String toString(){
        return name + " " + surname;
    }


}
