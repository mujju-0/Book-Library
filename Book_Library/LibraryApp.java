package Book_Library;

import java.util.Scanner;

public class LibraryApp {
	static Scanner sc = new Scanner(System.in);
	static Library library = new Library();
	
	
	public static void main(String[] args) {
		library.CurrentBooks(); //3 Initialize with some books
//		Members member = new Members();
		
//		Adding members in library
		int check;
		System.out.println("if you visite our library then you should register your name");
		System.out.println("To Enter member => 1. or Exit => 2.");
		check = sc.nextInt();
		sc.nextLine();
		switch(check) {
			case 1:
				library.addMember();
				break;
			case 2:
				return;
		}

		
		int choice;
		do {
			System.out.println("\n1. Add a Book");
			System.out.println("2. Display Available Books");
			System.out.println("3. Display Borrowed Books");
			System.out.println("4. Borrow a Book");
			System.out.println("5. Return a Book");
			System.out.println("6. Add Another Member and Display Members");
			System.out.println("7. Exit\n");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine(); // Consume newline
			
			switch (choice) {
//			1. Add a Book
				case 1:
					library.addBooks();
					break;
				case 2:
//			2. Display Available Books
					library.displayCurrrentBooks();
					break;
				case 3:
//			3. Display Borrowed Books
					
					library.BorrowedBooks();
					break;
				case 4:
//			4. Borrow a Book
					library.GetBook();
					break;
				case 5:
//			5. Return a Book
					library.ReturnBook();
					break;
				case 6:
//			6. Add Member and Display Members
					library.addMember();
					break;
				case 7:
//			7. Exit
					System.out.println("Exiting program...");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		} while (choice < 7);
		
		sc.close();
	}
}
