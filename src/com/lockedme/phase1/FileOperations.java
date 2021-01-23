package com.lockedme.phase1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileOperations {

	Scanner sc = new Scanner(System.in);

	// To Add a File
	public void addFile(String rootDir, String fileName) {

		File file = new File(rootDir, fileName);

		FileWriter fileWriter = null;
		try {
			if (file.createNewFile())
				System.out.println("File created!");
			else
				System.out.println("File already exists!");
			fileWriter = new FileWriter(file);
			System.out.println("Enter the contents of the File");
			fileWriter.write(sc.next());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Incorrect file path!");
			e.printStackTrace();
		} finally {
			sc.close();
			try {
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	// To Delete a File

	public void delete(String filePath) {
		Path path = Paths.get(filePath);
		try {
			Files.delete(path);
		} catch (NoSuchFileException exce) {
			System.out.println("There is no file!!");
			exce.printStackTrace();
		} catch (DirectoryNotEmptyException directoryNotEmptyException) {
			directoryNotEmptyException.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// To Search for a file in directory

	public void searchFile(String name, File file) {
		File[] list = file.listFiles();
		if (list != null) {
			for (File fil : list) {
				if (fil.isDirectory()) {
					searchFile(name, fil);
				} else if (name.equalsIgnoreCase(fil.getName())) {
					System.out.println("Location of the file is :");
					System.out.println(fil.getParentFile());
				}
			}
		}
	}
}