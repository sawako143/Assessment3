package Assessment3;

import java.io.*;
import java.util.*;

public class PhoneBook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean conti = true;
		// creating array list and setting the path
		ArrayList<Record> records = new ArrayList<>();
		String recordsFile = "C:\\\\Users\\\\Lenovo\\\\Documents\\\\lesson\\\\CL711 programming&algorithm\\\\eclipse\\\\ICT711\\\\src\\\\Assessment3\\\\PhoneBookFile.txt";

		// object creation, pass the path and record into child class
		PhonebookManager phonebookManager = new PhonebookManager();
		phonebookManager.loadRecords(recordsFile, records);
		phonebookManager.loadQuery(records);

		
		while (conti == true) {
			System.out.println("Do you want to continue? y/n");
			String co = sc.nextLine();
			if (co.equals("y")) {
				phonebookManager.loadQuery(records);
				conti = true;
			} else {
				System.out.println("----------------Thank you! See you again!---------------");
				System.exit(0);
			}
		}
	}

}
//read the Query and check if the reccord exists
//		ArrayList<String> listTemp = new ArrayList<String>();
//		System.out.println("Please enter the query!");
//		Scanner sq = new Scanner(System.in);
//
//		String temp = "QUERY name nomi";
//
//		boolean isln = list.containsAll();
//		System.out.println(isln);