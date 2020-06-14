package controller;

import java.sql.SQLException;
import java.util.Scanner;

import dao.BookDao;

public class UserMenu {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int choice =10;
		Scanner sc = new Scanner(System.in);
		BookDao dao =new BookDao();
		while(choice!=0) {
			System.out.println("Please 1 to use the application or 2 to exit:");
			choice = sc.nextInt();	
			if(choice == 1) {
			System.out.println("Please enter any number as given below");
			System.out.println("Please enter 1 to display all book");
			System.out.println("Please enter 2 to insert the book dynamically");
			System.out.println("Please enter 3 to update a book");
			System.out.println("Please enter 4 to delete a book");
			System.out.println("Please enter 0 to exit");
			switch(choice) {
			case 1:{
				dao.display();
			}break;
			case 2:{
				dao.insertDynamically();
			}
			break;
			case 3:{
				dao.update();
			}
			break;
			case 4:{
				dao.delete();
			}
			break;
			default:{
				System.out.println("Please enter any number between 1 and 4");
				break;
			}
			
			}
			}
			else {
				System.out.println("Thanks for using the Application,You can exit:");
				System.exit(0);
				

			}



		}

	}

}
