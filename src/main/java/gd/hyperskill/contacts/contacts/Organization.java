package gd.hyperskill.contacts.contacts;

import gd.hyperskill.contacts.interfaces.Contact;

public class Organization extends Contact {
    private String name;
    private String address;

    public Organization() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String showInfoDetail(){
        return String.format("Organization name: %s\n" +
                "Address: %s\n" +
                "Number: %s\n" +
                "Time created: %s\n" +
                "Time last edit: %s", name, address, super.getPhone(),
                super.getTimeCreated(), super.getTimeLastEdit());
    }

    @Override
    public String[] getAllData() {
        return new String[]{name, address, super.getPhone()};
    }

    @Override
    public String toString() {
        return name;
    }
}
