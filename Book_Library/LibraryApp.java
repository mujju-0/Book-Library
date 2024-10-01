package Book_Library;

import java.util.Scanner;

public class LibraryApp {
	static Scanner sc = new Scanner(System.in);
	static Library library = new Library();
	
	public static void main(String[] args) {
		library.initializeBooks(); // Initialize with some books
		
		int choice;
		do {
			System.out.println("\n1. Add a Book");
			System.out.println("2. Display Available Books");
			System.out.println("3. Display Borrowed Books");
			System.out.println("4. Borrow a Book");
			System.out.println("5. Return a Book");
			System.out.println("6. Add Member and Display Members");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine(); // Consume newline
			
			switch (choice) {
//			1. Add a Book
				case 1:
					library.addBook();
					break;
				case 2:
//			2. Display Available Books
					library.displayAvailableBooks();
					break;
				case 3:
//			3. Display Borrowed Books
					library.displayBorrowedBooks();
					break;
				case 4:
//			4. Borrow a Book
					System.out.print("Enter the book title to borrow: ");
					String bookTitle = sc.nextLine();
					Members member = new Members();
					System.out.print("Enter your name: ");
					member.setName(sc.nextLine());
					System.out.print("Enter your ID: ");
					member.setId(sc.nextInt());
					sc.nextLine(); // Consume newline
					library.borrowBook(bookTitle, member);
					break;
				case 5:
//			5. Return a Book
					System.out.print("Enter the book title to return: ");
					String returnTitle = sc.nextLine();
					Members returningMember = new Members();
					System.out.print("Enter your name: ");
					returningMember.setName(sc.nextLine());
					System.out.print("Enter your ID: ");
					returningMember.setId(sc.nextInt());
					sc.nextLine(); // Consume newline
					library.returnBook(returnTitle, returningMember);
					break;
				case 6:
//			6. Add Member and Display Members
					Members newMember = new Members();
					System.out.print("Enter member name: ");
					newMember.setName(sc.nextLine());
					System.out.print("Enter member ID: ");
					newMember.setId(sc.nextInt());
					sc.nextLine(); // Consume newline
					System.out.println("Member added: " + newMember.getName() + ", ID: " + newMember.getId());
					break;
				case 7:
//			7. Exit
					System.out.println("Exiting program...");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 7);
		
		sc.close();
	}
}
