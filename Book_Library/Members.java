package Book_Library;

public class Members {
	private String name;
	private int id;
	private String borrowedBooks[] = new String[100]; //It indicates how many books can borrow a user
	int count = 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void getBorrowedBooks() {

		for(int i = 0; i<count; i++) {
			System.out.print(" Title: "+borrowedBooks[i]+" ");
			}
	}
	public void setBorrowedBooks(String borrowedBooks) {
		this.borrowedBooks[count] = borrowedBooks;
		count++;
	}
}
