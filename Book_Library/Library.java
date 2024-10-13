package Book_Library;

import java.util.Scanner;

public class Library {
	

	
	static Scanner sc = new Scanner(System.in);
	private BookData[] books = new BookData[10];
	static private Members[] members = new Members[10];
	static int Bookcount = 6;
	static int Membercount = 0;
//	Assienging our books
	void CurrentBooks() 
	{
	String titles[] = {"a", "b", "c", "d", "e", "f", "g"};
	String authors[] = {"sohel", "sohel.j", "javed", "adnna", "pasha", "chicha", "gunda"};
	String isbns[] = {"12-21", "32-1", "123", "098", "343", "423", "780"};
	String statuses[] = {"available", "available", "available", "available", "available", "available", "available"};
	
	for(int i = 0; i<=Bookcount;i++) 
		{
			books[i] = new BookData();
			books[i].setTitle(titles[i]);
			books[i].setAuthor(authors[i]);
			books[i].setIsbn(isbns[i]);
			books[i].setStatus(statuses[i]);

		}
	}
	
//	it store available books & we access it by using getter methods 
	void displayCurrrentBooks() {
		System.out.println("These are availabe books");
		for(int i = 0; i<=Bookcount;i++) 
		{
//			books[i] = new BookData(); it return null
			System.out.println("Title: " +books[i].getTitle()+
						" Author: "+books[i].getAuthor()+
						" Isbn: "+books[i].getIsbn()+
						" Status: "+books[i].getStatus());	
			
		}
	}
	
//	Member/user can add it's books
	void addBooks() 
	{
				if(Bookcount>books.length-1) {
			System.out.println("No more space");
			return;
		}
		System.out.println("Enter your name:");
		String member = sc.nextLine();
		for(int j = 0; j<=Membercount; j++) 
		{
			if(member.equalsIgnoreCase(members[j].getName())) 
			{
		Bookcount++;
		books[Bookcount] = new BookData();
		System.out.println("Enter title: ");
		books[Bookcount].setTitle(sc.nextLine());
		System.out.println("Enter Author name: ");
		books[Bookcount].setAuthor(sc.nextLine());		
		System.out.println("Enter ISBN no.: ");
		books[Bookcount].setIsbn(sc.nextLine());		
		System.out.println("Enter Status : ");
		books[Bookcount].setStatus(sc.nextLine());

		return;
			}
			}
		System.out.println("member not found");
		return;
	}
	
//	adding member in our library
	void addMember() 
	{
		
		
		members[Membercount] = new Members();
		System.out.println("Enter your name");
		members[Membercount].setName(sc.nextLine());
		System.out.println("Enter your Id");
		members[Membercount].setId(sc.nextInt());
		sc.nextLine();
		System.out.println("Only with this information you can Enter our Library\n");
		System.out.println("Name: "+members[Membercount].getName()+" Id: "+members[Membercount].getId()+"\n\n");
		++Membercount;
		
	}
//	Only user can get books(here user can borrow(get) books)
	void GetBook() 
	{
		String title, member;
		
		System.out.println("Enter your name first");
		member = sc.nextLine();
		
		for(int j = 0; j<Membercount; j++) 
		{
			if(member.equalsIgnoreCase(members[j].getName())) 
			{
				System.out.println("you can borrow a Book\n");
				System.out.println("Enter Book title");
				title = sc.nextLine();
				for(int i = 0; i<=Bookcount; i++) 
				{
					if(title.equalsIgnoreCase(books[i].getTitle()) && books[i].getStatus().equalsIgnoreCase("available")) 
					{
						books[i].setStatus("unavailable");
						members[j].setBorrowedBooks(books[i].getTitle());
						System.out.println("title: "+books[i].getTitle()+" User name: "+members[j].getName());
//						System.out.println("title: "+members[j].getBorrowedBooks()+" User name: "+members[j].getName());
//						Membercount++;
						return;
					}
					else {
						System.out.println("false");
					}

				}
				System.out.println("book is not available");
				return;
		
			
			}

		}
		System.out.println("user is not found");
		return;
	}
	
//	here we are showing how many books borrowed & who borrowed
	void BorrowedBooks() 
	{
		System.out.println("Below are borrowed books");
		for(int i = 0; i<Membercount; i++) 
		{
			System.out.print(" User name: "+members[i].getName());
			members[i].getBorrowedBooks();
			System.out.println();
		}
	}
//	user should return borrowed books 
	void ReturnBook() 
	{
		System.out.println("Which book you wanna return:");
		String title, member;
		System.out.println("Enter your name first");
		member = sc.nextLine();
		
		for(int j = 0; j<=Membercount; j++) 
		{
			if(member.equalsIgnoreCase(members[j].getName())) 
			{
				System.out.println("Enter book name");
				
				title = sc.nextLine();
				for(int i = 0; i<books.length;i++) {
					if(books[i].getTitle().equalsIgnoreCase(title) && books[i].getStatus().equalsIgnoreCase("unavailable")) {
						members[j].setBorrowedBooks(null);
						books[i].setStatus("available");
						System.out.println("Thanks for returning book");
						return;
					}
				}
				System.out.println("book is not found");
				return;
			}
		}
		System.out.println("member is not registerd");
	}
	
}
