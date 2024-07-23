# Contacts

## Table of Contents

- [Description](#description)
- [Project Structure](#project-structure)
  - [Package `gd.hyperskill.contacts`](#package-gdhyperskillcontacts)
  - [Package `gd.hyperskill.contacts.contacts`](#package-gdhyperskillcontactscontacts)
  - [Package `gd.hyperskill.contacts.enums`](#package-gdhyperskillcontactsenums)
  - [Package `gd.hyperskill.contacts.interfaces`](#package-gdhyperskillcontactsinterfaces)
  - [Package `gd.hyperskill.contacts.io`](#package-gdhyperskillcontactsio)
  - [Package `gd.hyperskill.contacts.ui`](#package-gdhyperskillcontactsui)
- [Usage](#usage)
  - [Starting the Game](#starting-the-game)
  - [Example steps for adding a person contact](#example-steps-for-adding-a-person-contact)
  - [Example steps for listing all data of a contact](#example-steps-for-listing-all-data-of-a-contact)
  - [Example steps for editing the data of a contact](#example-steps-for-editing-the-data-of-a-contact)
  - [Example of wrong inputs](#example-of-wrong-inputs)
  - [Default values](#default-values)
  - [Exiting the directory](#exiting-the-directory)
- [Requirements](#requirements)

## Description

This project simulates the creation and management of a directory of contacts. The game runs in the console, offering an interactive and user-friendly experience.

## Project Structure

The project is organized into the following packages and classes:

### Package `gd.hyperskill.contacts`

- **Main:** Application starting point. It instantiates the *PhoneBook* class and starts the application UI.
- **Phonebook:** The contacts directory itself. It serves as a bridge between the UI and the data storage.

### Package `gd.hyperskill.contacts.contacts`

- **Organization:** Data structure for organizational contacts.
- **Person:** Data structure for individual contacts.

### Package `gd.hyperskill.contacts.enums`

- **ContactMenuOptions:** Menu options for contact operations after listing contacts.
- **ContactNumberOptionsMenu:** Menu options for contact operations after selecting a record.
- **Contacts:** Types of contacts that can be stored.
- **EditOrganizationMenuOptions:** Edit options for organizations.
- **EditPersonMenuOptions:** Edit options for individuals.
- **MainMenuOptions:** Menu options for the main UI.
- **SearchMenuOptions:** Menu options for contact operations after searching.

### Package `gd.hyperskill.contacts.interfaces`

- **Contact:** Abstract representation of a contact.

### Package `gd.hyperskill.contacts.io`

- **Inputs:** Handles keyboard inputs.
- **Outputs:** Manages all print statements.
- **Validators:** Validates inputs based on requirements.

### Package `gd.hyperskill.contacts.ui`

- **UserInterface:** Bridges user interaction with application functionality.

## Usage

### Starting the Game

1. Run the `Main` class.
2. Follow the instructions in the console to add a new contact, list all contacts, search for a contact, count all contacts, or exit the application.

#### Example steps for adding a person contact

Note that the characters `> ` represent user keyboard input.

```bash
    [menu] Enter action (add, list, search, count, exit): > add
    Enter the type (person, organization): > person
    Enter the name: > Brian
    Enter the surname: > Vega
    Enter the birth date: > 2001-01-21
    Enter the gender (M, F): > M
    Enter the number: > 3414205938
    The record added.
```

#### Example steps for list all the data of a contact.
  ```bash
      [menu] Enter action (add, list, search, count, exit): list
      1. Brian Vega
      [list] Enter action ([number], back): 1
      Name: Brian
      Surname: Vega
      Birth date: 2001-01-21
      Gender: M
      Number: 3414205938
      Time created: 2024-07-23T17:12
      Time last edit: 2024-07-23T17:12
  ```

#### Example steps for edit the data of a contact.
  ```bash
    [record] Enter action (edit, delete, menu): edit
    Select a field (name, surname, number): number
    Enter number: 456
    The record updated.
    Name: Brian
    Surname: Vega
    Birth date: 2001-01-21
    Gender: M
    Number: 456
    Time created: 2024-07-23T17:22
    Time last edit: 2024-07-23T17:23
  ```
#### Example of wrong inputs
  ```bash
    [record] Enter action (edit, delete, menu): hello
    Invalid action.
```
```bash
    [menu] Enter action (add, list, search, count, exit): test
    Invalid action.
```
#### default values
In case of a wrong user input like the ones showed below, the default value stored in the `Birth date` and in the `gender` fields is by default `[no data]`
```bash
    [menu] Enter action (add, list, search, count, exit): add
    Enter the type (person, organization): person
    Enter the name: test
    Enter the surname: test
    Enter the birth date: test
    Bad birth date!
    Enter the gender (M, F): test
    Bad gender!
    Enter the number: 1
    The record added.
    
    [menu] Enter action (add, list, search, count, exit): list
    1. test test
    [list] Enter action ([number], back): 1
    Name: test
    Surname: test
    Birth date: [no data]
    Gender: [no data]
    Number: 1
    Time created: 2024-07-23T17:29
    Time last edit: 2024-07-23T17:29
```

### Exiting the directory

Enter the command `exit` to exit the game.

## Requirements

- Java 17 or higher
- IDE or text editor of your choice
