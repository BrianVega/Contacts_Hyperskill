package gd.hyperskill.contacts.io;

import gd.hyperskill.contacts.enums.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Validators {
    final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$"); //^[a-zA-Z]\w*$
    final Pattern GENDER_PATTERN = Pattern.compile("^[mf]$");
    final Pattern FIRST_GROUP_PHONE_PATTERN = Pattern.compile("\\+?\\([^\\W_]+\\)([- ][^\\W_]{2,})*");
    final Pattern SECOND_GROUP_PHONE_PATTERN = Pattern.compile("\\+?[^\\W_]+([- ]\\([^\\W_]{2,}\\))*([- ][^\\W_]{2,})*");
    final Pattern CONTACT_MENU_OPTIONS_PATTERN = Pattern.compile("^([0-9]+|back)$");
    final Pattern SEARCH_MENU_OPTIONS_PATTERN = Pattern.compile("^[0-9]+$|^back$|^again$");

    final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    boolean isValidMenuOption(String option) {
        return Arrays.stream(MainMenuOptions.values())
                .map(Enum::name)
                .anyMatch(name -> name.equals(option.trim().toUpperCase()));
    }

    boolean isValidContactType(String type) {
        return Arrays.stream(Contacts.values())
                .map(Enum::name)
                .anyMatch(name -> name.equals(type.trim().toUpperCase()));
    }

    boolean isValidActionForNumberOption(String option) {
        return Arrays.stream(ContactNumberOptionsMenu.values())
                .map(Enum::name)
                .anyMatch(name -> name.equals(option.trim().toUpperCase()));
    }

    boolean isValidEditPersonOption(String option) {
        return Arrays.stream(EditPersonMenuOptions.values())
                .map(Enum::name)
                .anyMatch(name -> name.equals(option.trim().toUpperCase()));
    }

    boolean isValidEditOrganizationOption(String option) {
        return Arrays.stream(EditOrganizationMenuOptions.values())
                .map(Enum::name)
                .anyMatch(name -> name.equals(option.trim().toUpperCase()));
    }

    boolean isValidName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }

    boolean isValidBirthDate(String birthDate) {
        return DATE_FORMAT.toPattern().matches(birthDate);
    }

    /* Hyperskill does not provide any concrete validation requirements about the following input */
    boolean isValidOrganizationName(String organizationName) {
        return containsSomething(organizationName);
    }

    /* Hyperskill does not provide any concrete validation requirements about the following input */
    boolean isValidOrganizationAddress(String organizationAddress) {
        return containsSomething(organizationAddress);
    }

    boolean isValidGender(String gender) {
        return GENDER_PATTERN.matcher(gender.trim()
                .toLowerCase())
                .matches();
    }

    boolean isValidPhoneNumber(String number) {
        return FIRST_GROUP_PHONE_PATTERN.matcher(number).matches()
                || SECOND_GROUP_PHONE_PATTERN.matcher(number).matches();
    }

    boolean isValidContactMenuOptions(String option) {
        return CONTACT_MENU_OPTIONS_PATTERN.matcher(option).matches();
    }

    boolean isValidActionForSearchOption(String option) {
        return SEARCH_MENU_OPTIONS_PATTERN.matcher(option).matches();
    }

    boolean isValidSearchQuery(String searchQuery) {
        return containsSomething(searchQuery);
    }

    private boolean containsSomething(String input) {
        return input != null && !input.isEmpty();
    }
}
