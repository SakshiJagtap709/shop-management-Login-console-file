package Shop_Management_Login;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import ProductManagement.ProductManagement;
import UserManagement.UserManagement;

public class MainApplication_Login {

	
	public static void main(String[] args) throws IOException 
	{
		 Scanner scan = new Scanner(System.in);
		 
		 boolean canIKeepRunningTheProgram = true;
		 
		 System.out.println("**********Welcome To Shop Management*************");
		 
		 System.out.println("\n");
		 System.out.println("Enter login name: ");
		 String login = scan.nextLine();
		 System.out.println("Enter password: ");
		 String password = scan.nextLine();
		 
		 if(!UserManagement.validateUserandPassword(login, password))
		 {
			 System.out.println("!!!! Login Failed !!!!  Closing the Application");
			 return;
		 }
		
		 
		 while (canIKeepRunningTheProgram == true) {
			 
			 System.out.println("*********WELCOME TO SHOP MANAGEMENT***************");
				System.out.println("\n");
				System.out.println("WHAT WOULD YOU LIKE TO DO..?");
				System.out.println("1.Product Management");
				System.out.println("2.User Management");
				System.out.println("3.Quit");
				
				int optionSelectedByUser = scan.nextInt();
				
				if (optionSelectedByUser == 1)
				{
					ProductManagement.ProductManagement();
				}
				else if (optionSelectedByUser == 2)
				{
					UserManagement.UserManagment();
				}
				else if(optionSelectedByUser == 3)
				{
					break;
				}
		 }
		 	
		 }
		
}












