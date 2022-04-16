package com.bridgelabz;

public class AddressBook {

    public static void main(String[] args) {
        System.out.println("Welcome to IO-AddressBook");
        AddressBookContacts contact = new AddressBookContacts("Arun kumar","R","Earth","Chennai","TN","arun@gmail.com",632406,987654321);
        System.out.println("Contact created for:"+contact.firstName +" "+contact.lastName);
    }
}
