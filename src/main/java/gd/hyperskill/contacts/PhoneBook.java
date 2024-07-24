package gd.hyperskill.contacts;

import gd.hyperskill.contacts.enums.*;
import gd.hyperskill.contacts.interfaces.Contact;
import gd.hyperskill.contacts.contacts.Organization;
import gd.hyperskill.contacts.contacts.Person;
import gd.hyperskill.contacts.ui.UserInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhoneBook {
    final UserInterface UI;
    private final List<Contact> PHONE_BOOK;

    PhoneBook() {
        UI = new UserInterface();
        PHONE_BOOK = new ArrayList<>();
    }

    public void mainMenu() {
        MainMenuOptions menuOption;

        do {
            UI.printMenu();
            menuOption = UI.getMenuOption();
            switch (menuOption) {
                case ADD -> addContact();
                case LIST -> listContactsActionsMenu();
                case SEARCH -> searchContacts(menuOption.name());
                case COUNT -> countContacts();
                case EXIT -> exit();
                case INVALID -> UI.printInvalidOption();
            }
        } while (!menuOption.equals(MainMenuOptions.EXIT));
    }

    private void listContactsActionsMenu() {
        UI.printPhoneBookRecords(PHONE_BOOK);
        UI.printContactActionsMenu();
        Object auxSelectedOption = UI.getContactMenuOption();// UI.getContactMenuOption();
        ContactMenuOptions selectedOption = getContactMenuOptionFrom(auxSelectedOption);
        String contactIndex = auxSelectedOption.toString();

        switch (selectedOption) {
            case NUMBER -> actionsForNumberOptionMenu(contactIndex);
            case BACK -> {}
            case INVALID -> UI.printInvalidOption();
        }
    }

    private boolean actionSearchContactMenu() {
        UI.printActionsForSearchOptionMenu();
        Object auxSelectedOption = UI.getSearchMenuOption();
        SearchMenuOptions selectedOption = getSearchMenuOptionFrom(auxSelectedOption);
        String contactIndex = auxSelectedOption.toString();
        switch (selectedOption) {
            case NUMBER -> actionsForNumberOptionMenu(contactIndex);
            case BACK -> {}
            case AGAIN -> {
                return true;
            }
            case INVALID -> UI.printInvalidOption();
        }
        return false;
    }

    private void actionsForNumberOptionMenu(String contactIndex) {
        int selectedIndex = getPhoneBookIndex(contactIndex);
        showContactDetail(selectedIndex);
        Contact contact = PHONE_BOOK.get(selectedIndex);
        ContactNumberOptionsMenu option;
        do {
            UI.printActionsForNumberOptionMenu();
            option = UI.getActionsForNumberOption();
            switch (option) {
                case EDIT -> mainEditContacts(contact);
                case DELETE -> removeContacts(contact);
                case MENU -> { return; }
                case INVALID -> UI.printInvalidOption();
            }
        } while (true);

    }

    private void editPerson(Person selectedContact) {
        UI.printFieldsForEditPerson();
        EditPersonMenuOptions selectedField = UI.getEditPersonMenuOption();
        UI.printEnterEditField(selectedField.name());
        switch (selectedField) {
            case NAME -> editNamePerson(selectedContact);
            case SURNAME -> editSurnamePerson(selectedContact);
            case BIRTHDATE -> editBirthDatePerson(selectedContact);
            case GENDER -> editGenderPerson(selectedContact);
            case NUMBER -> editNumberPerson(selectedContact);
            case INVALID -> {
                UI.printInvalidOption();
                return;
            }
        }
        UI.printRecordUpdated();
    }

    private void editOrganization(Organization selectedContact) {
        UI.printFieldsForEditOrganization();
        EditOrganizationMenuOptions selectedField = UI.getEditOrganizationMenuOption();
        UI.printEnterEditField(selectedField.name());
        switch (selectedField) {
            case NAME -> editNameOrganization(selectedContact);
            case ADDRESS -> editAddressOrganization(selectedContact);
            case NUMBER -> editNumberOrganization(selectedContact);
            default -> {
                UI.printInvalidField();
                return;
            }
            case INVALID -> UI.printInvalidOption();
        }
        UI.printRecordUpdated();
    }

    private ContactMenuOptions getContactMenuOptionFrom(Object auxSelectedOption ) {
        if (auxSelectedOption.equals(ContactMenuOptions.BACK)) {
            return ContactMenuOptions.BACK;
        } else {
            return ContactMenuOptions.NUMBER;
        }
    }

    private SearchMenuOptions getSearchMenuOptionFrom(Object auxSelectedOption ) {
        if (auxSelectedOption.equals(SearchMenuOptions.AGAIN)) {
            return SearchMenuOptions.AGAIN;
        } else if (auxSelectedOption.equals(SearchMenuOptions.BACK)) {
            return SearchMenuOptions.BACK;
        } else {
            return SearchMenuOptions.NUMBER;
        }
    }

    private void editNamePerson(Person selectedContact) {
        UI.getUserName().ifPresent(selectedContact::setName);
    }
    private void editSurnamePerson(Person selectedContact) {
        UI.getSurname().ifPresent(selectedContact::setSurname);
    }
    private void editBirthDatePerson(Person selectedContact) {
        UI.getBirthDate().ifPresent(selectedContact::setBirthDate);
    }
    private void editGenderPerson(Person selectedContact) {
        UI.getGender().ifPresent(selectedContact::setGender);
    }
    private void editNumberPerson(Person selectedContact) {
        UI.getPhoneNumber().ifPresent(selectedContact::setPhone);
    }

    private void editNameOrganization(Organization selectedContact) {
        UI.getOrganizationName().ifPresent(selectedContact::setName);
    }
    private void editAddressOrganization(Organization selectedContact) {
        UI.getOrganizationAddress().ifPresent(selectedContact::setAddress);
    }
    private void editNumberOrganization(Organization selectedContact) {
        UI.getPhoneNumber().ifPresent(selectedContact::setPhone);
    }

    private Person registerContactPerson() {
        Person newPerson = new Person();

        UI.printEnterName();
        UI.getUserName().ifPresent(newPerson::setName);

        UI.printEnterSurname();
        UI.getSurname().ifPresent(newPerson::setSurname);

        UI.printEnterBirthDate();
        UI.getBirthDate()
                .ifPresentOrElse(newPerson::setBirthDate
                , UI::printBadBirthDate);

        UI.printEnterGender();
        UI.getGender().ifPresentOrElse(newPerson::setGender
                , UI::printBadGender);

        UI.printEnterPhoneNumber();
        UI.getPhoneNumber().ifPresentOrElse(newPerson::setPhone
                , UI::printBadPhoneNumber);

        return newPerson;
    }

    private Organization registerContacOrganization() {
        Organization newOrganization = new Organization();

        UI.printOrganizationName();
        UI.getOrganizationName().ifPresent(newOrganization::setName);

        UI.printOrganizationAddress();
        UI.getOrganizationAddress().ifPresent(newOrganization::setAddress);

        UI.printEnterPhoneNumber();
        UI.getPhoneNumber().ifPresent(newOrganization::setPhone);

        return newOrganization;
    }

    private void removeContacts(Contact contact) {
        PHONE_BOOK.remove(contact);
        UI.printRecordRemoved();
    }

    private void showContactDetail(int selectedIndex) {
        Contact selectedContact = PHONE_BOOK.get(selectedIndex);
        UI.printSingleRecord(selectedContact);
    }

    private int getPhoneBookIndex(String auxSelectedContactIndex) {
        int selectedContactIndex = Integer.parseInt(auxSelectedContactIndex);

        for(int listIndex = 0; listIndex < PHONE_BOOK.size(); listIndex++) {
            Contact contact = PHONE_BOOK.get(listIndex);
            if(contact.getRegisterNumber() == selectedContactIndex) {
                return listIndex;
            }
        }
        return selectedContactIndex;
    }

    private void mainEditContacts(Contact contact) {
        editContact(contact);
        UI.printSingleRecord(contact);
    }

    private void editContact(Contact selectedContact) {
        if (selectedContact.getClass() == Person.class) {
            editPerson((Person) selectedContact);
        }else {
            editOrganization((Organization) selectedContact);
        }
        selectedContact.logEdit();
    }

    private Contacts getContactType() {
        UI.printContactTypeMenu();
        return UI.getContactType();
    }

    private List<Contact> getAllCoincidences(String searchQuery) {
        Set<Contact> coincidencesSet = new HashSet<>();
        for(Contact contact : this.PHONE_BOOK){
            for(String data : contact.getAllData()){
                if(data.toLowerCase().contains(searchQuery)){
                    coincidencesSet.add(contact);
                }
            }
        }
        return new ArrayList<>(coincidencesSet);
    }

    private void addContact() {
        Contact newContact = null;
        Contacts contactType = getContactType();

        switch (contactType) {
            case PERSON -> newContact = registerContactPerson();
            case ORGANIZATION -> newContact = registerContacOrganization();
            case INVALID -> UI.printInvalidOption();
        }

        PHONE_BOOK.add(newContact);
        UI.printRecordAdded();
    }

    private void searchContacts(String action) {
        if(!this.hasRecords()) {
            UI.printNoRecordsTo(action);
            return;
        }
        boolean again = false;
        do{
            UI.printEnterSearchQuery();

            String searchQuery = UI.getsSearchQuery();
            List<Contact> searchQueryResult = getAllCoincidences(searchQuery);
            int resultSize = searchQueryResult.size();
            if(resultSize == 0) {
                UI.printNotFoundRecords();
                return;
            }
            UI.printFoundRecords(resultSize);
            UI.printPhoneBookRecords(searchQueryResult);

            again = actionSearchContactMenu();
        } while (again);

    }

    private boolean hasRecords() {
        return !this.PHONE_BOOK.isEmpty();
    }

    private void countContacts() {
        UI.printHasRecords(this.PHONE_BOOK.size());
    }

    private void exit() {
        UI.printFarewell();
    }
}
