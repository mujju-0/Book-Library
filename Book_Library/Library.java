package Book_Library;

import java.util.Scanner;

public class Library {
	
	Scanner sc = new Scanner(System.in);
	private BookData[] books = new BookData[10]; // Holds books
	private Members[] members = new Members[10]; // Holds members
	private int bookCount = 7; // Current number of books
	private int memberCount = 0; // Current number of members
	
	// Initialize some books in the library
	void initializeBooks() {
		String titles[] = {"a", "b", "c", "d", "e", "f", "g"};
		String authors[] = {"sohel", "sohel.j", "javed", "adnna", "pasha", "chicha", "gunda"};
		String isbns[] = {"12-21", "32-1", "123", "098", "343", "423", "780"};
		String statuses[] = {"available", "unavailable", "available", "available", "unavailable", "available", "available"};
		
		for (int i = 0; i < bookCount; i++) {
			books[i] = new BookData();
			books[i].setTitle(titles[i]);
			books[i].setAuthor(authors[i]);
			books[i].setIsbn(isbns[i]);
			books[i].setStatus(statuses[i]);
		}
	}
	
	// Add a new book to the library
	void addBook() {
		if (bookCount >= books.length) {
			System.out.println("Library is full! Cannot add more books.");
			return;
		}
		
		BookData newBook = new BookData();
		System.out.println("Enter book title: ");
		newBook.setTitle(sc.nextLine());
		System.out.println("Enter book author: ");
		newBook.setAuthor(sc.nextLine());
		System.out.println("Enter book ISBN: ");
		newBook.setIsbn(sc.nextLine());
		newBook.setStatus("available");
		
		books[bookCount++] = newBook;
		System.out.println("Book added successfully!");
	}
	
	// Display all available books
	void displayAvailableBooks() {
		System.out.println("Available Books:");
		for (int i = 0; i < bookCount; i++) {
			if (books[i].getStatus().equalsIgnoreCase("available")) {
				System.out.println("Title: " + books[i].getTitle() + ", Author: " + books[i].getAuthor());
			}
		}
	}
	
	// Display all borrowed books
	void displayBorrowedBooks() {
		System.out.println("Borrowed Books:");
		for (int i = 0; i < bookCount; i++) {
			if (books[i].getStatus().equalsIgnoreCase("unavailable")) {
				System.out.println("Title: " + books[i].getTitle() + ", Author: " + books[i].getAuthor());
			}
		}
	}
	
	// Allow a member to borrow a book if available
	void borrowBook(String title, Members member) {
		for (int i = 0; i < bookCount; i++) {
			if (books[i].getTitle().equalsIgnoreCase(title) && books[i].getStatus().equalsIgnoreCase("available")) {
				books[i].setStatus("unavailable");
				member.setBorrowedBooks(books[i].getTitle());
				System.out.println(member.getName() + " has borrowed " + books[i].getTitle());
				return;
			}
		}
		System.out.println("Book is unavailable or does not exist.");
	}
	
	// Allow a member to return a book
	void returnBook(String title, Members member) {
		for (int i = 0; i < bookCount; i++) {
			if (books[i].getTitle().equalsIgnoreCase(title) && books[i].getStatus().equalsIgnoreCase("unavailable")) {
				books[i].setStatus("available");
				member.setBorrowedBooks(null);
				System.out.println(member.getName() + " has returned " + books[i].getTitle());
				return;
			}
		}
		System.out.println("Book was not borrowed.");
	}
}
