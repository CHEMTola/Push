package edu.PIP.IT.java.FileIO;
/**
 * Create files and write lines of text into them via user input
 */
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/*
 * Precondition: Input name of file you want to create with extension and write lines of text into the file
 * Postcondition: Output file with name you input with lines of text you input
 */
public class FileO {

	public static void main(String[] args) {
		FileO writer = new FileO();
		writer.run();		//Calling method
	}
	
	private void run() {
		//For input
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		//For containing the content of the file
		PrintWriter outputStream = null;
		
		//Prompt to input the name + extension of the file
		System.out.println("Enter the name + extension of the file you want to create: ");
		String fileName = keyboard.nextLine();		//Contain the input name
		
		//To catch exceptions
		try {
			outputStream = new PrintWriter(fileName);
		}	catch(FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);	//Error message
			System.exit(0);
		}
		
		//Prompt line input
		System.out.println ("Enter however many lines of text you want, input 'end' to stop: ");
		//For loop condition
		boolean End = false;
		//To keep count of lines
		int count = 1;
		
		//Loop to get input for every line of text
		while(!End) {
			String line = keyboard.nextLine();
			if(!line.equalsIgnoreCase("end")) {
				outputStream.println(count + ", " + line);		//Write into the file
			}
			else End = true;		//Loop break condition
			count++;				//Increment for line count
		}
		keyboard.close();
		outputStream.close();
		System.out.println("Those lines were written into " + fileName);
	}
}
