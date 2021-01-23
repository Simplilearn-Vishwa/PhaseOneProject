package com.lockedme.phase1;

import java.io.File;
import java.util.Arrays;


public class FileRetrieval {

	public void retrieve(String location) {

		File file = new File(location);
		if(file.isFile()) {
		File[] files = file.listFiles();
		System.out.println("Number of files : " + files.length);

		System.out.println("The files in ascending sorting order :");

		Arrays.sort(files);

		for (File eachfile : files) {

			System.out.println(eachfile.getName());
		}
		}else {
			System.out.println("Enter a valid location.");
		}
	}

}
