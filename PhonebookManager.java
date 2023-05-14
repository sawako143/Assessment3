package Assessment3;

import java.io.*;
import java.util.*;

public class PhonebookManager {

    public void loadRecords(String pathName, ArrayList<Record> records) {
        try {
            Scanner sf = new Scanner(new File(pathName));
            int lineNumber = 1; // Track the line number for validation errors

            while (sf.hasNextLine()) {
                String name = sf.nextLine();
                String birthday = sf.nextLine();
                String phoneNumber = sf.nextLine();
                String address = sf.nextLine();

                // Validate the fields
                if (name.isEmpty() || birthday.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()) {
                    System.out.println("Invalid record at line " + lineNumber + ". Skipping...");
                    continue;
                }

                Record record = new Record();
                record.setName(name);
                record.setBirthday(birthday);
                record.setPhoneNumber(phoneNumber);
                record.setAddress(address);
                records.add(record);

                lineNumber += 4; // Increment line number by 4 for each record
            }
            sf.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the file!");
            e.printStackTrace();
        }
    }

    // Create a new record and add it to the phonebook
    public void createRecord(ArrayList<Record> records, Record newRecord) {
        records.add(newRecord);
    }

    // Read and display all records in the phonebook
    public void displayRecords(ArrayList<Record> records) {
        for (Record record : records) {
            System.out.println(record);
        }
    }

    // Update an existing record in the phonebook
    public void updateRecord(ArrayList<Record> records, int index, Record updatedRecord) {
        if (index >= 0 && index < records.size()) {
            records.set(index, updatedRecord);
        } else {
            System.out.println("Invalid index!");
        }
    }

    // Delete a record from the phonebook
    public void deleteRecord(ArrayList<Record> records, int index) {
        if (index >= 0 && index < records.size()) {
            records.remove(index);
        } else {
            System.out.println("Invalid index!");
        }
    }
}