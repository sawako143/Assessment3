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
//			System.out.println(records);
			sf.close();
		} catch (FileNotFoundException e) {
			// Auto-generated catch block
			System.out.println("Couldn't found the file!");
			e.printStackTrace();
		}
//		see the saved records
		Record record = records.get(1);
//		System.out.println(record);

	}

	public void loadQuery(ArrayList<Record> records) {

		String que;
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------------Please enter the query:---------------");
		que = sc.nextLine();

		// seperate the query one by one word
		ArrayList<String> word = new ArrayList<>();
		String[] words = que.trim().split("[;\\s+;]");
		for (int i = 0; i < words.length; i++) {
			word.add(words[i]);
		}
		// remove character such as space
		for (int i = 0; i < word.size(); i++) {
			if (word.get(i).equals("")) {
				word.remove(word.get(i));
			}
		}

//		add name Jimmy; birthday 09-09-1990; phone 88884444; address 9001 Chester Crescent
		if (word.get(0).equals("add")) {

//			save query value in new value
			String name = word.get(2);
			String birthday = word.get(4);
			String phoneNumber = word.get(6);
			String add1 = word.get(8);
			String add2 = word.get(9);
			String add3 = word.get(10);
			String address = add1.concat(" ").concat(add2).concat(" ").concat(add3);

			boolean found = false;
			int index = 0;
//			find if the record exist already by name and birthday
			for (int i = 0; i < records.size(); i++) {
				if ((records.get(i).getName().equals(name)) && (records.get(i).getBirthday().equals(birthday))) {
					found = true;
					index = i;
				}
			}
			if (found == true) {
				records.get(index).setPhoneNumber(phoneNumber);
				records.get(index).setAddress(address);
				System.out.println("------------------Record updated!-----------------");

			} else {
				Record newRecord = new Record(name, birthday, phoneNumber, address);
				records.add(newRecord);
				System.out.println("------------------New record added!-----------------");
			}
			System.out.println(records);

//			delete name Jimmy; birthday 09-09-1990;
//			delete method
		} else if (word.get(0).equals("delete")) {
			// check if query has only name or with the birthday

			String name = word.get(2);

			if (word.contains("birthday") == false) {
				for (int i = 0; i < records.size(); i++) {
					if (records.get(i).getName().equals(name)) {
						records.remove(i);
						System.out.println("------------------Record deleted1!-----------------");
						System.out.println(records);
					}
				}
			} else {
				String birthday = word.get(4);
				for (int i = 0; i < records.size(); i++) {
					if (records.get(i).getName().equals(name) && (records.get(i).getBirthday().equals(birthday))) {
						records.remove(i);
						System.out.println("------------------Record deleted!-----------------");
						System.out.println(records);
					}
				}
			}

		}
//		else if (word.get(0).equals("query")) {
//		name birthday phoneNumber
//			String name = word.get(2);
//			String birthday = word.get(4);
//			String phoneNumber = word.get(6);
//			ArrayList<String> list = new ArrayList<>();
//			if(word.contains("name")) {
//				for(int i=0;i<records.size();i++) {
//					if (records.get(i).getName().equals(name)) {
//						
//					}
//				}
//			}
//		}

	}
}