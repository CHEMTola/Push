package edu.PIP.IT.java.FileIO;
/**
 * Read Excel and Text files, and print it out the content of the file
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/*
 * Precondition: Input Excel or Text file (name + extension) to read
 * Postcondition: Output the content of the file out on the console
 */
public class FileI {

	public static void main(String[] args) {
		FileI reader = new FileI();
		reader.run();		//Calling method
	}
	
	private void run() {
		//For input
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		//For containing the content of the file
		Scanner inputStream = null;
		
		//Prompt to input the name + extension of the file
		System.out.println("Enter the name + extension of the file you want to open: ");
		String fileName = keyboard.nextLine();		//Contain the input name
		
		//To catch exceptions
		try {
			System.out.println("The file " + fileName + " contains the following:\n");
			inputStream = new Scanner(new File(fileName));
		}	catch(FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);	//Error message
			System.exit(0);
		}
		
		//Loop to iterate through all the lines of content in the file
		while(inputStream.hasNextLine()) {
			String Line = inputStream.nextLine();	//Get one line
			System.out.println(Line);				//Print the line
		}
		keyboard.close();
		inputStream.close();
	}
}
