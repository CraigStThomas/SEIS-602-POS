package login;

import java.util.Scanner;

public class user {

	public user() {
		// Creating username and password
	}

	public static void main(String[] args) {
		
		    String Username;
		    String Password;

		    System.out.println("Welcome to the Point-of-Sale Registration System:");
		    @SuppressWarnings("resource")
			Scanner input1 = new Scanner(System.in);
		    System.out.println("Enter Username : ");
		    Username = input1.next();

		    @SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
		    System.out.println("Enter Password : ");
		    Password = input.next();

		    if (Username.equals(Username) && Password.equals(Password)) {

		        System.out.println("You are logged in!");
		    }

		    else if (Username.equals(Username)) {
		        System.out.println("Invalid Password!");
		    } else if (Password.equals(Password)) {
		        System.out.println("Invalid Username!");
		    } else {
		        System.out.println("Invalid Username & Password! Please re-enter your Username & Password.");
		    }

	}

}

