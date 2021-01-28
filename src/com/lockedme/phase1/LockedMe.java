package com.lockedme.phase1;

import java.io.File;
import java.util.Scanner;

public class LockedMe {

	public static void main(String[] args) {
		System.out.println("Welcome To LockedMe.com");
		System.out.println("***************************************************");
		System.out.println("Developed by A.vishwaprem");
		System.out.println("Senior Software Engineer@Simplilearn");
		System.out.println("***************************************************");

		
		FileRetrieval read = new FileRetrieval();
		FileOperations ops = new FileOperations();

		Scanner sc = new Scanner(System.in);

		boolean selection = true;

		while (selection) {

			showMenu();
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Please enter the location :");
				read.retrieve(sc.next());
				break;
			case 2:
				showFileOperationsMenu();
				int ch = 0;
				ch = sc.nextInt();
				if (ch == 1) {
					System.out.println("Please enter the root directory");
					String rootDir = sc.next();
					System.out.println("Please enter the file Name");
					String fileName = sc.next();
					ops.addFile(rootDir, fileName);

				} else if (ch == 2) {
					System.out.println("Please enter the file location which is to be deleted :");
					String location = sc.next();
					ops.delete(location);

				} else if (ch == 3) {
					System.out.println("Enter the file to be searched.. ");
					String name = sc.next();
					System.out.println("Enter the directory where to search ");
					String directory = sc.next();
					ops.searchFile(name, new File(directory));
				} else if (ch == 4) {
					continue;
				}
				break;
			case 3:
				selection = false;
				break;
			default:
				System.out.println("Please choose only from the options in menu");
				break;

			}

		}
		sc.close();
	}

	public static void showMenu() {

		System.out.println("Please select from the following " + "\n" + "" + "press : " + "\n"
				+ "1.Return the current file names in ascending order" + "\n" + "2.File operations  " + "\n" +

				"3.Close the Application");
	}

	public static void showFileOperationsMenu() {

		System.out.println("Please select from the following " + "\n" + "Press :" + "\n"
				+ "1.Add a file to the existing directory list" + "\n"
				+ "2.Delete a specified file from the existing directory list" + "\n"
				+ "3.Search a specified file from the main directory " + "\n" + "4.navigate back to the main context");
	}

}
