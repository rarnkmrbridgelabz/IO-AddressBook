package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    private ArrayList<AddressBookContacts> addressContactList;

    public AddressBook() {
        // Initializing ArrayList
        addressContactList = new ArrayList<AddressBookContacts>();
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

    // Main method
    public static void main(String[] args) {

        System.out.println("Welcome to the Address Book System");
        int ch = 0;
        Scanner sc = new Scanner(System.in);
        // Creating a Object for Main Class
        AddressBook ab = new AddressBook();

        // Checking a Choice with Switch Statement
        while (true) {
            System.out.println("1.Adding Contact \n2.Edit Contact \n3.Exit");
            System.out.println("Enter a Your Choice :");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    AddressBookContacts addressContactDetails = ab.getContactInput();
                    ab.addContact(addressContactDetails);

                    System.out.println("Contact Added Successfully");
                    break;
                case 2:
                    ab.editContact();
                    System.out.println("Contact Updated Successfully");
                    break;

                case 3:
                    System.out.println("you have choosen choice to exit");
                    return;

                default:
                    System.out.println("Please Enter Valid Choice");

            }
        }

    }
}
