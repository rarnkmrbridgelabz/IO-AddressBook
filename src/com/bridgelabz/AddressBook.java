package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {

    ArrayList<AddressBookContacts> addressContactList;
    Map<String, AddressBookContacts> nameToContactDetailsMap;

    public AddressBook() {
        // Initializing ArrayList
        addressContactList = new ArrayList<AddressBookContacts>();
        nameToContactDetailsMap = new HashMap<>();
    }

    public void addContact(AddressBookContacts createPerson) {
        System.out.println("Adding a New Contact of: " + createPerson.firstName);
        addressContactList.add(createPerson);
    }

    // using Method and Edit with Switch Statement
    public void editContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name of Contact to Edit it");
        String contactName = sc.nextLine();
        AddressBookContacts editContact = addressContactList.get(contactName.indexOf(contactName));
        if (editContact.getFirstName().equals(contactName)) {

            System.out.println("Which Details You Would Like To Edit ?");
            System.out.println("Press - 1 for First Name \nPress - 2 for Last Name \n"
                    + "Press - 3 for Address \nPress - 4 for City \nPress - 5 for State \nPress - 6 for Zip \n"
                    + "Press - 7 for Phone No. \nPress - 8 for Email");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter New First Name");
                    sc.nextLine();
                    String fName = sc.nextLine();
                    editContact.setFirstName(fName);
                    System.out.println("Update a Sucessfully " + fName);
                    break;

                case 2:
                    System.out.println("Enter New Last Name");
                    sc.nextLine();
                    String lName = sc.nextLine();
                    editContact.setLastName(lName);
                    System.out.println("Update a Sucessfully " + lName);
                    break;

                case 3:
                    System.out.println("Enter New Address");
                    sc.nextLine();
                    String address = sc.nextLine();
                    editContact.setAddress(address);
                    System.out.println("Update a Sucessfully " + address);
                    break;

                case 4:
                    System.out.println("Enter New City");
                    sc.nextLine();
                    String city = sc.nextLine();
                    editContact.setCity(city);
                    System.out.println("Update a Sucessfully " + city);
                    break;

                case 5:
                    System.out.println("Enter New State");
                    sc.nextLine();
                    String state = sc.nextLine();
                    editContact.setState(state);
                    System.out.println("Update a Sucessfully " + state);
                    break;

                case 6:
                    System.out.println("Enter New Zip");
                    long zip = sc.nextLong();
                    editContact.setZip(zip);
                    System.out.println("Update a Sucessfully " + zip);
                    break;

                case 7:
                    System.out.println("Enter New Phone Number");
                    long phoneNo = sc.nextLong();
                    editContact.setPhoneNo(phoneNo);
                    System.out.println("Update a Sucessfully " + phoneNo);
                    break;

                case 8:
                    System.out.println("Enter New Email");
                    sc.nextLine();
                    String email = sc.nextLine();
                    editContact.setEmail(email);
                    System.out.println("Update a Sucessfully " + email);
                    break;

                default:
                    System.out.println("you have not choosen vaild option");
                    return;

            }
        } else {
            System.out.println("No such contact");
        }
    }

    // Getting Input from User
    public AddressBookContacts getContactInput() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your First Name:");
        String fName = sc.nextLine();
        System.out.println("Enter your Last Name:");
        String lName = sc.nextLine();
        System.out.println("Enter your Address:");
        String address = sc.nextLine();
        System.out.println("Enter your City:");
        String city = sc.nextLine();
        System.out.println("Enter your State:");
        String state = sc.nextLine();
        System.out.println("Enter your Zip:");
        long zip = sc.nextLong();
        System.out.println("Enter your Phone No:");
        long phoneNo = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter your Email:");
        String email = sc.nextLine();

        AddressBookContacts contact = new AddressBookContacts(fName, lName, address, city, state, email, zip, phoneNo);
        return contact;
    }

    // Creating a Method and Deleting Contact with Using First Name
    public void deleteContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name of Contact to Delete it");
        String cName = sc.nextLine();
        AddressBookContacts editContact = addressContactList.get(cName.indexOf(cName));
        if (editContact.getFirstName().equals(cName)) {

            addressContactList.remove(editContact);
        } else {
            System.out.println("No such Contact to Delete");
        }
    }

    // Method to create addressbook uc-6
    public AddressBook addressBookOption() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the address book system. Choose your option");
        AddressBook addBook = new AddressBook();
        boolean runLoop = true;
        while (runLoop) {
            System.out.println(
                    "Press 1 for adding contact\nPress:2 to edit a contact\nPress:3 to delete a contact\n press 4 to exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("---- Add contact details ---- ");
                    AddressBookContacts contactPerson = addBook.getContactInput();
                    addBook.addContact(contactPerson);
                    System.out.println("Contact added for " + contactPerson.firstName + " " + contactPerson.lastName);
                    break;

                case 2:
                    System.out.println("---- Editing contacts---");
                    addBook.editContact();
                    break;

                case 3:
                    System.out.println("---- Delete a contact---");
                    addBook.deleteContact();
                    break;

                case 4:
                    System.out.println("exit");
                    runLoop = false;
                    break;

                default:
                    System.out.println("No correct option chosen");

            }
        }
        return addBook;
    }
}
