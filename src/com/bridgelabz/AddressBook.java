package com.bridgelabz;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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

    // UC11 Sorted Name by Alphabetically Order
    public void viewSortedByNames() {
        List<AddressBookContacts> sortedDetails = addressContactList.stream()
                .sorted(Comparator.comparing(n -> n.toString())).peek(n -> System.out.println(n))
                .collect(Collectors.toList());
    }

    // UC12 Sorted Name by Alphabetically Order with City Name
    public void viewSortedByCity() {
        List<AddressBookContacts> sortedDetailsByCity = addressContactList.stream()
                .sorted((ab1, ab2) -> ab1.getCity().compareTo(ab2.getCity()))
                .peek(addBook -> System.out.println(addBook)).collect(Collectors.toList());
    }

    // UC12 Sorted Name by Alphabetically Order with State Name
    public void viewSortedByState() {
        List<AddressBookContacts> sortedDetailsByCity = addressContactList.stream()
                .sorted((ab1, ab2) -> ab1.getState().compareTo(ab2.getState()))
                .peek(addBook -> System.out.println(addBook)).collect(Collectors.toList());
    }

    // Method to create addressbook uc-6
    public AddressBook addressBookOption() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the address book system. Choose your option");		System.out.println("------------------------------------------------------");
        AddressBook addBook = new AddressBook();
        boolean runLoop = true;
        while (runLoop) {
            System.out.println(
                    "Press 1 for adding contact\n Press:2 to edit a contact\n Press:3 to delete a contact\n press:4 to sort by name\n press:5 to sort by city\n press:6 to sort by state\n press:7 write from file \n press:8 readfromfile \n press 9  to exit");
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
                    System.out.println("---- sort by name ---");
                    addBook.viewSortedByNames();
                    break;
                case 5:
                    System.out.println("---- sort by city ---");
                    addBook.viewSortedByCity();
                    break;
                case 6:
                    System.out.println("---- sort by State ---");
                    addBook.viewSortedByState();
                    break;
                case 7:
                    System.out.println("---- write from File  ---");
                    addBook.writeToFile(addressContactList);
                    break;
                case 8:
                    System.out.println("---- Read from File ---");
                    addBook.readFromFile();
                    break;

                case 9:
                    System.out.println("exit");
                    runLoop = false;
                    break;

                default:
                    System.out.println("No correct option chosen");

            }
        }
        return addBook;
    }

    private void readFromFile() {
        // TODO Auto-generated method stub

    }

    private void writeToFile(ArrayList<AddressBookContacts> addressContactList2) {
        // TODO Auto-generated method stub

    }
}
