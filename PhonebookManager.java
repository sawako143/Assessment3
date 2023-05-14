package Assessment3;

import java.io.*;
import java.util.*;

public class PhonebookManager {

	// read phonebook text file using scanner class and save into arraylist
	public void loadRecords(String pathName, ArrayList<Record> records) {

		try {
			Scanner sf = new Scanner(new File(pathName));
			while (sf.hasNextLine()) {
//				records.add(sf.nextLine());
				Record record = new Record();
				record.setName(sf.nextLine());
				record.setBirthday(sf.nextLine());
				record.setPhoneNumber(sf.nextLine());
				record.setAddress(sf.nextLine());
				records.add(record);
			}
			sf.close();
		} catch (FileNotFoundException e) {
			// Auto-generated catch block
			System.out.println("Couldn't found the file!");
			e.printStackTrace();
		}
//		see the saved records
		Record record = records.get(3);
		System.out.println(record);

	}
}
