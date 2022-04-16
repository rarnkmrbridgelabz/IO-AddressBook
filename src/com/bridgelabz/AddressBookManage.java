package com.bridgelabz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
public class AddressBookManage {

    private Map<String, AddressBook> nameToAddressBookMap;
    List<AddressBookContacts> valuePrinted = null;
    private int countPerson;
    public AddressBookManage() {
        nameToAddressBookMap = new HashMap<>();
    }
    public void addAddressBook(String addBookName, AddressBook addBook) {
        nameToAddressBookMap.put(addBookName, addBook);
    }
    public boolean createAddBooks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num of address books to create");
        int num = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < num; i++) {
            int serialNo = i + 1;
            System.out.println("Enter the name of add. book num. " + serialNo);
            String aBookName = sc.nextLine();
            AddressBook addBookObj = new AddressBook();
            addBookObj = addBookObj.addressBookOption();
            addAddressBook(aBookName, addBookObj);
        }
        return false;
    }


    public void viewAddBooks() {
        for (int i = 0; i < nameToAddressBookMap.size(); i++) {
            System.out.println(i + "Name of add. book are : " + nameToAddressBookMap);
        }
    }

    // UC 8 find the person by city
    public void findPersonByCity(String cityName)
    {
        nameToAddressBookMap.forEach((key, addresBookValue) -> {
            valuePrinted = addresBookValue.addressContactList.stream()
                    .filter(n -> n.city.equals(cityName))
                    .peek( n -> System.out.println("Person name---"+ n.firstName + " "+ n.lastName))
                    .collect(Collectors.toList());
        });
        countPerson = valuePrinted.size();
    }
    // UC 9 Find  the person by state
    public void findPersonByState(String stateName)
    {
        nameToAddressBookMap.forEach((key, addresBookValue) -> {
            valuePrinted = addresBookValue.addressContactList.stream()
                    .filter(n -> n.state.equals(stateName))
                    .peek( n -> System.out.println("Person name---"+ n.firstName + " "+ n.lastName))
                    .collect(Collectors.toList());

        }); //  counting the persons
        countPerson = valuePrinted.size();
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("welcome and create address books ");
        AddressBookManage addBookManage = new AddressBookManage();
        addBookManage.createAddBooks();
        boolean created = addBookManage.createAddBooks();
        System.out.println("Successfully created address books");
        addBookManage.viewAddBooks();

        if (created)
        {
            System.out.println("Enter 1 to find by City \nEnter 2 to find by State");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch)
            {
                case 1:
                    System.out.println("Enter the name of City: ");
                    String cityName = sc.nextLine();
                    addBookManage.findPersonByCity(cityName);
                    break;

                case 2:
                    System.out.println("Enter the name of State: ");
                    String stateName = sc.nextLine();
                    addBookManage.findPersonByState(stateName);
                    break;
                default:
                    break;
            }
            System.out.println("Number of persons found = " + addBookManage.countPerson);
        }

    }
}
