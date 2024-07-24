package gd.hyperskill.contacts.io;

import gd.hyperskill.contacts.interfaces.Contact;

public class Outputs {

    public void menuMsg() {
        System.out.print("\n[menu] Enter action (add, list, search, count, exit): ");
    }

    public void invalidOptionMsg() {
        System.out.println("Invalid action.");
    }

    public void contactTypeMenu() {
        System.out.print("Enter the type (person, organization): ");
    }

    public void enterName() {
        System.out.print("Enter the name: ");
    }

    public void enterSurname() {
        System.out.print("Enter the surname: ");
    }

    public void enterBirthDate() {
        System.out.print("Enter the birth date: ");
    }

    public void badBirthDate() {
        System.out.println("The date is invalid. Please enter a date in the format YYYY-MM-DD.");
    }

    public void enterGender() {
        System.out.print("Enter the gender (M, F): ");
    }

    public void badGender(){
        System.out.println("The date is invalid. Please enter one of the following options: M, F");
    }

    public void enterPhoneNumber() {
        System.out.print("Enter the number: ");
    }

    public void badPhoneNumber(){
        System.out.println("Wrong number format!");
    }

    public void enterOrganizationName() {
        System.out.print("Enter the organization name: ");
    }

    public void enterOrganizationAddress() {
        System.out.print("Enter the address: ");
    }

    public void recordAdded() {
        System.out.println("The record added.");
    }

    public void contactActionsMenu() {
        System.out.print("[list] Enter action ([number], back): ");
    }

    public void actionsForNumberOptionMenu() {
        System.out.print("\n[record] Enter action (edit, delete, menu): ");
    }

    public void actionsForSearchOptionMenu() {
        System.out.print("\n[search] Enter action ([number], back, again): ");
    }

    public void fieldsForEditPerson() {
        System.out.print("Select a field (name, surname, number): ");
    }

    public void fieldsForEditOrganization() {
        System.out.print("Select a field (name, address, number): ");
    }

    public void enterEditField(String filedName) {
        System.out.print("Enter " + filedName.toLowerCase() + ": ");
    }

    public void enterSearchQuery() {
        System.out.print("Enter search query: ");
    }

    public void recordUpdated() {
        System.out.println("The record updated.");
    }

    public void invalidField() {
        System.out.println("Invalid field.");
    }

    public void recordRemoved() {
        System.out.println("The record removed!");
    }

    public void noRecordsTo(String action) {
        System.out.println("No records to " + action + "!");
    }

    public void foundRecords(int resultSize) {
        System.out.printf("Found %d results: \n", resultSize);
    }

    public void notFoundRecords() {
        System.out.println("Not found results");
    }

    public void singleRecord(Contact record) {
        System.out.println(record.showInfoDetail());
    }

    public void listedRecord(int index, String contactName) {
        System.out.println(index + ". " + contactName);
    }

    public void hasRecords(int resultSize){
        System.out.println("The Phone Book has " + resultSize + " records.");
    }

    public void farewell() {
        System.out.println("\nBye!");
    }
}
