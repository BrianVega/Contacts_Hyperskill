package gd.hyperskill.contacts.io;

import gd.hyperskill.contacts.enums.*;

import java.util.Optional;
import java.util.Scanner;

public class Inputs {
    final Scanner SCANNER;
    final Validators VALIDATORS;

    public Inputs() {
        SCANNER = new Scanner(System.in);
        VALIDATORS = new Validators();
    }

    public Optional<MainMenuOptions> menuOption() {
        String option = SCANNER.nextLine();
        return VALIDATORS.isValidMenuOption(option)
                ? Optional.of(MainMenuOptions.valueOf(option.toUpperCase()))
                : Optional.empty();
    }

    public Optional<Object> contactMenuOption() {
        String option = SCANNER.nextLine();
        return VALIDATORS.isValidContactMenuOptions(option.toUpperCase())
                ? getContactMenuOption(option)
                : Optional.empty();
    }

    public Optional<Object> searchMenuOption() {
        String option = SCANNER.nextLine();
        return VALIDATORS.isValidActionForSearchOption(option)
                ? getSearchMenuOption(option)
                : Optional.empty();
    }

    public Optional<ContactNumberOptionsMenu> actionsForNumberOption() {
        String option = SCANNER.nextLine();
        return VALIDATORS.isValidActionForNumberOption(option)
                ? Optional.of(ContactNumberOptionsMenu.valueOf(option.toUpperCase()))
                : Optional.empty();
    }

    public Optional<EditPersonMenuOptions> editPersonOption() {
        String option = SCANNER.nextLine();
        return VALIDATORS.isValidEditPersonOption(option)
                ? Optional.of(EditPersonMenuOptions.valueOf(option.toUpperCase()))
                : Optional.empty();
    }

    public Optional<EditOrganizationMenuOptions> editOrganizationOption() {
        String option = SCANNER.nextLine();
        return VALIDATORS.isValidEditOrganizationOption(option)
                ? Optional.of(EditOrganizationMenuOptions.valueOf(option.toUpperCase()))
                : Optional.empty();
    }

    public Optional<Contacts> contactType() {
        String option = SCANNER.nextLine();
        return VALIDATORS.isValidContactType(option)
                ? Optional.of(Contacts.valueOf(option.toUpperCase()))
                : Optional.empty();
    }

    public Optional<String> namePerson() {
        String name = SCANNER.nextLine();
        return VALIDATORS.isValidName(name)
                ? Optional.of(name)
                : Optional.empty();
    }

    public Optional<String> surnamePerson() {
        String name = SCANNER.nextLine();
        return VALIDATORS.isValidName(name)
                ? Optional.of(name)
                : Optional.empty();
    }

    public Optional<String> birthDatePerson() {
        String birthDate = SCANNER.nextLine();
        return VALIDATORS.isValidBirthDate(birthDate)
                ? Optional.of(birthDate)
                : Optional.empty();
    }

    public Optional<String> genderPerson() {
        String gender = SCANNER.nextLine();
        return VALIDATORS.isValidGender(gender)
                ? Optional.of(gender)
                : Optional.empty();
    }

    public Optional<String> phoneNumber() {
        String number = SCANNER.nextLine();
        return VALIDATORS.isValidPhoneNumber(number)
                ? Optional.of(number)
                : Optional.empty();
    }

    public Optional<String> organizationName() {
        String organization = SCANNER.nextLine();
        return VALIDATORS.isValidOrganizationName(organization)
                ? Optional.of(organization)
                : Optional.empty();
    }

    public Optional<String> organizationAddress() {
        String address = SCANNER.nextLine();
        return VALIDATORS.isValidOrganizationAddress(address)
                ? Optional.of(address)
                : Optional.empty();
    }

    public Optional<String> searchQuery() {
        String searchQuery = SCANNER.nextLine();
        return VALIDATORS.isValidSearchQuery(searchQuery)
                ? Optional.of(searchQuery)
                : Optional.empty();
    }

    private Optional<Object> getContactMenuOption(String option) {
        if(option.equalsIgnoreCase(ContactMenuOptions.BACK.name())) {
            return Optional.of(ContactMenuOptions.BACK);
        } else {
            return Optional.of(option);
        }
    }

    private Optional<Object> getSearchMenuOption(String option) {
        if(option.equalsIgnoreCase(SearchMenuOptions.BACK.name())) {
            return Optional.of(SearchMenuOptions.BACK);
        } else if (option.equalsIgnoreCase(SearchMenuOptions.AGAIN.name())) {
            return Optional.of(SearchMenuOptions.AGAIN);
        } else {
            return Optional.of(option);
        }
    }

}
