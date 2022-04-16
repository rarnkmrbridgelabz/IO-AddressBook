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
            System.out.println("1.Adding Contact \n2.Exit");
            System.out.println("Enter a Your Choice :");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    AddressBookContacts addressContactDetails = ab.getContactInput();
                    ab.addContact(addressContactDetails);

                    System.out.println("Contact Added Successfully");
                    break;

                case 2:
                    System.out.println("you have choosen choice to exit");
                    return;

                default:
                    System.out.println("Please Enter Valid Choice");

            }
        }

    }
}
