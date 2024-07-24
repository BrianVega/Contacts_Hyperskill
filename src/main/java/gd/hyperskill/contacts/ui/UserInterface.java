package gd.hyperskill.contacts.ui;

import gd.hyperskill.contacts.enums.*;
import gd.hyperskill.contacts.io.Inputs;
import gd.hyperskill.contacts.io.Outputs;
import gd.hyperskill.contacts.interfaces.Contact;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UserInterface {
    private final Inputs INPUTS;
    private final Outputs OUTPUTS;

    public UserInterface() {
        INPUTS = new Inputs();
        OUTPUTS = new Outputs();
    }

    public MainMenuOptions getMenuOption() {
        try {
            return INPUTS.menuOption().orElseThrow();
        } catch (NoSuchElementException e) {
            return MainMenuOptions.INVALID;
        }
    }

    public Contacts getContactType() {
        try {
            return INPUTS.contactType().orElseThrow();
        } catch (NoSuchElementException e) {
            return Contacts.INVALID;
        }
    }

    public Object getContactMenuOption() {
        try {
            return INPUTS.contactMenuOption().orElseThrow();
        } catch (NoSuchElementException e) {
            return Contacts.INVALID;
        }
    }

    public Object getSearchMenuOption() {
        try {
            return INPUTS.searchMenuOption().orElseThrow();
        } catch (NoSuchElementException e) {
            return SearchMenuOptions.INVALID;
        }
    }

    public ContactNumberOptionsMenu getActionsForNumberOption() {
        try {
            return INPUTS.actionsForNumberOption().orElseThrow();
        } catch (NoSuchElementException e) {
            return ContactNumberOptionsMenu.INVALID;
        }
    }

    public EditPersonMenuOptions getEditPersonMenuOption() {
        try {
            return INPUTS.editPersonOption().orElseThrow();
        } catch (NoSuchElementException e) {
            return EditPersonMenuOptions.INVALID;
        }
    }

    public EditOrganizationMenuOptions getEditOrganizationMenuOption() {
        try {
            return INPUTS.editOrganizationOption().orElseThrow();
        } catch (NoSuchElementException e) {
            return EditOrganizationMenuOptions.INVALID;
        }
    }

    public String getsSearchQuery() {
        try {
            return INPUTS.searchQuery().orElseThrow();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public Optional<String> getUserName() {
        return INPUTS.namePerson();
    }

    public Optional<String> getSurname() {
        return INPUTS.surnamePerson();
    }

    public Optional<String> getBirthDate() {
        return INPUTS.birthDatePerson();
    }

    public Optional<String> getGender() {
        return INPUTS.genderPerson();
    }

    public Optional<String> getPhoneNumber() {
        return INPUTS.phoneNumber();
    }

    public Optional<String> getOrganizationName() {
        return INPUTS.organizationName();
    }

    public Optional<String> getOrganizationAddress() {
        return INPUTS.organizationAddress();
    }

    // OUTPUTS
    public void printMenu() {
        OUTPUTS.menuMsg();
    }

    public void printInvalidOption() {
        OUTPUTS.invalidOptionMsg();
    }

    public void printFarewell() {
        OUTPUTS.farewell();
    }

    public void printContactTypeMenu() {
        OUTPUTS.contactTypeMenu();
    }

    public void printEnterName() {
        OUTPUTS.enterName();
    }

    public void printEnterSurname() {
        OUTPUTS.enterSurname();
    }

    public void printEnterBirthDate() {
        OUTPUTS.enterBirthDate();
    }

    public void printEnterGender() {
        OUTPUTS.enterGender();
    }

    public void printEnterPhoneNumber() {
        OUTPUTS.enterPhoneNumber();
    }

    public void printBadBirthDate() {
        OUTPUTS.badBirthDate();
    }

    public void printBadGender() {
        OUTPUTS.badGender();
    }

    public void printBadPhoneNumber() {
        OUTPUTS.badPhoneNumber();
    }

    public void printOrganizationName() {
        OUTPUTS.enterOrganizationName();
    }

    public void printOrganizationAddress() {
        OUTPUTS.enterOrganizationAddress();
    }

    public void printContactActionsMenu() {
        OUTPUTS.contactActionsMenu();
    }

    public void printRecordAdded() {
        OUTPUTS.recordAdded();
    }

    public void printSingleRecord(Contact record) {
        OUTPUTS.singleRecord(record);
    }

    public void printHasRecords(int resultSize) {
        OUTPUTS.hasRecords(resultSize);
    }

    public void printActionsForNumberOptionMenu() {
        OUTPUTS.actionsForNumberOptionMenu();
    }

    public void printFieldsForEditPerson() {
        OUTPUTS.fieldsForEditPerson();
    }

    public void printFieldsForEditOrganization() {
        OUTPUTS.fieldsForEditOrganization();
    }

    public void printEnterEditField(String fieldName) {
        OUTPUTS.enterEditField(fieldName);
    }

    public void printRecordUpdated() {
        OUTPUTS.recordUpdated();
    }

    public void printRecordRemoved() {
        OUTPUTS.recordRemoved();
    }

    public void printInvalidField() {
        OUTPUTS.invalidField();
    }

    public void printNoRecordsTo(String action) {
        OUTPUTS.noRecordsTo(action);
    }

    public void printEnterSearchQuery() {
        OUTPUTS.enterSearchQuery();
    }

    public void printFoundRecords(int resultSize) {
        OUTPUTS.foundRecords(resultSize);
    }

    public void printNotFoundRecords() {
        OUTPUTS.notFoundRecords();
    }

    public void printActionsForSearchOptionMenu() {
        OUTPUTS.actionsForSearchOptionMenu();
    }

    public void printPhoneBookRecords(List<Contact> phoneBookRecords) {
        for(int index = 0; index < phoneBookRecords.size(); index++) {
            Contact contact = phoneBookRecords.get(index);
            System.out.println((index + 1) + ". " + contact.toString());
        }
    }
}
