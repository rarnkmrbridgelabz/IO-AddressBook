package com.bridgelabz;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AddressBookFileIOService {
    public static String FILE_ADDRESS_BOOK = "address-book-file";

    //method to write file
    public void writeToFile(ArrayList <AddressBookContacts> contactList) throws IOException {
        Path filePath = Paths.get(FILE_ADDRESS_BOOK + ".txt");
        if (Files.notExists(filePath))
            Files.createFile(filePath);
        StringBuffer addressBookBuffer = new StringBuffer();
        contactList.forEach(book -> {
            String bookDataString = book.toString().concat("\n");
            addressBookBuffer.append(bookDataString);
        });
        //using try catch block
        try {
            Files.write(filePath, addressBookBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // method to read from the file
    public void readFromFile() throws IOException {
        Path filePath = Paths.get(FILE_ADDRESS_BOOK+ ".txt");
        try {
            System.out.println("The contact details in addressbook : ");
            Files.lines(filePath).map(line -> line.trim()).forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
