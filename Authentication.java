package com.LockedmeApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import com.Serializable.User1;
import com.Serializable.Users;

public class Authentication {

	// input data
	private static Scanner keyboard;
	private static Scanner input;
	private static Scanner lockerInput;

	// output data
	private static PrintWriter output;
	private static PrintWriter lockerOutput;

	private static Users users;
	private static User1 userCredentials;

	public static void main(String[] args) {
		initApp();
		welcomeScreen();
		signInOptions();
	}

	public static void initApp() {
		File dbFile = new File("database.txt");
		File lockerFile = new File("lockerfile.txt");

		try {
			boolean createFile = dbFile.createNewFile();
			boolean createFile1 = lockerFile.createNewFile();
			input = new Scanner(dbFile);
			lockerInput = new Scanner(lockerFile);
			keyboard = new Scanner(System.in);
			output = new PrintWriter(new FileWriter(dbFile, true));
			lockerOutput = new PrintWriter(new FileWriter(lockerFile, true));

			users = new Users();
			userCredentials = new User1();
			if ( createFile1) {
				System.out.println(" ");
				System.out.println("New Database initialization done");
				System.out.println(" ");
			} else {
				System.out.println(" ");
				System.out.println(". . . Database loading done");
				System.out.println(" ");
			}

		} catch (IOException e) {
			System.out.println("Error - DB File  / Locker File not found ");
		}
	}

	public static void welcomeScreen() {
		System.out.println(" ");
		System.out.println(" - - > WelCome to LockedMe.com < - - ");
		System.out.println(" ");
	}

	public static void signInOptions() {
		while(true) {
		System.out.println(" ");
		System.out.println("Select an Action");
		System.out.println("  1.Registration");
		System.out.println("  2.Login");
		System.out.println("  3.Delete");
		System.out.println("  4.search");
		System.out.println("  5.logout");
		System.out.println(" ");
		int option = keyboard.nextInt();
		switch (option) {
		case 1:
			registerUser();
			break;
		case 2:
			loginUser();
			break;
		case 3:
			 deleteUser();
			 break;
		case 4:
			searchUser();
			break;
		case 5:
			  logout();
			  break;
		default:
			System.out.println("Selected option is invalid, Please choose 1 or 2");
			signInOptions();
			break;
		}
		}
		
	}

	private static void registerUser() {
		System.out.println(" ");
		System.out.println(" > Welcome to User Registration	< ");
		System.out.println(" ");
		System.out.println(" Enter Username: ");

		String userName = keyboard.next();
		users.setUserName(userName);
		System.out.println(" ");
		System.out.println(" Enter Password: ");
		String password = keyboard.next();
		users.setPassword(password);
		output.println(users.getUserName());
		output.println(users.getPassword());
		System.out.println(" ");
		System.out.println("User Registration successful, please try logging in");
		output.close();
	}

	private static void loginUser() {
		System.out.println(" ");
		System.out.println(" > Welcome to User Login < ");
		System.out.println(" ");
		System.out.println(" Enter Username: ");
		String inputUserName = keyboard.next();
		boolean found = false;
		while (input.hasNext() && !found) {
			if (input.next().equals(inputUserName)) {
				System.out.println(" ");
				System.out.println(" Enter Password: ");
				String password = keyboard.next();
				if (input.next().equals(password));
				{
					System.out.println(" ");
					System.out.println("Authentication Successful");
					found = true;
					lockerOption(inputUserName);
				}
			}
		}
		if (!found) {
			System.out.println("Please Enter correct UserName / Password");
		}

	}

	public static void storeCredentials(String loggedInUserName) {

		
		System.out.println(" ");
		System.out.println("Enter Username: ");
		String userName = keyboard.next();
		userCredentials.setUserName(userName);
		System.out.println(" ");
		System.out.println("Enter Password: ");
		String password = keyboard.next();
		userCredentials.setPassword(password);
		// print credentials to the lockerFile
		lockerOutput.println(userCredentials.getUserName());
		lockerOutput.println(userCredentials.getPassword());
		System.out.println(" ");
		System.out.println("Credentials Stored Successfully");
		lockerOutput.close();
	}


	public static void lockerOption(String inputUserName) {
		System.out.println(" ");
		System.out.println("Select an Action");
		System.out.println("  1.Store Credentials");
		System.out.println(" ");
		int option = keyboard.nextInt();
		switch (option) {
		case 1:
			storeCredentials(inputUserName);
			break;
		default:
			System.out.println("Selected option is invalid ,Please choose 1");
			break;
		}

		lockerInput.close();
		}
	private static void deleteUser()
	{
		
	 System.out.println(" ");
    System.out.println(" Enter Username: ");
    String inputUserName = keyboard.next();
    boolean found=false;
   	try {
     		Files.deleteIfExists(Paths.get("lockerOutput/"+inputUserName+".txt"));
     	}
     	catch(FileNotFoundException e) {
     		System.out.println("FileNotFound");
     	}
     	catch(IOException e)
     	{
     		System.out.println("Invalid Permissions");
     	}                                            
     	System.out.println("File Not Found");
	}
	private static void searchUser()
	{
		
		System.out.println(" ");
    System.out.println(" Enter Username: ");
    String inputUserName = keyboard.next();
    boolean found=false;
    while (input.hasNext() && !found) {
		if (input.next().equals(inputUserName)) {
                   break;
		} else {
			System.out.println("Operation UnSuccessfull");
		}
		}
         System.out.println("Operation Sucessfull");
	
	}
	public static void logout() {
		keyboard.close(); 	
		}
	}



