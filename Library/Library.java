public class Library {
	// Add the missing implementation to this class

	String address;
	int totalBooks = 0;
	Book[] storedBooks = new Book[10];

	public Library(String realAddress) {
		address = realAddress;
	}

	void addBook(Book newBook) {
		if (totalBooks < 10) {
			storedBooks[totalBooks] = new Book(newBook.title);
			totalBooks++;
		} else {
			System.out.println("Library is full");
		}
	}

	public void printAddress() {
		System.out.println(address);
	}

	void borrowBook(String bookName) {

		for (int j = 0; j < totalBooks; j++) {
			if ((bookName.equals(storedBooks[j].title)) && (storedBooks[j].borrowed == false)) {
				storedBooks[j].borrowed = true;
				System.out.println("You successfully borrowed " + storedBooks[j].title);
				return;
			} else if ((bookName.equals(storedBooks[j].title)) && (storedBooks[j].borrowed == true)) {
				System.out.println("Sorry, this book is already borrowed.");
				return;
			}
		}

		System.out.println("Sorry, this book is not in our catalog.");
		return;
	}

	void printAvailableBooks() {
		if (totalBooks > 0) {
			for (int i = 0; i < totalBooks; i++) {
				if (storedBooks[i].borrowed == false) {
					System.out.println(storedBooks[i].title);
				}
			}
		} else {
			System.out.println("No book in catalog");
		}
	}

	void returnBook(String bookName) {
		if (totalBooks > 0) {
			for (int i = 0; i < totalBooks; i++) {
				if (storedBooks[i].title.equals(bookName) && (storedBooks[i].borrowed == true)) {
					System.out.println("You successfully returned " + storedBooks[i].title);
					storedBooks[i].borrowed = false;
				}
			}
		}
	}

	private static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}

	public static void main(String[] args) {
		// Create two libraries
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");

		// Add four books to the first library
		firstLibrary.addBook(new Book("The Da Vinci Code"));
		firstLibrary.addBook(new Book("Le Petit Prince"));
		firstLibrary.addBook(new Book("A Tale of Two Cities"));
		firstLibrary.addBook(new Book("The Lord of the Rings"));

		// Print opening hours and the addresses
		System.out.println("Library hours:");
		printOpeningHours();
		System.out.println();

		System.out.println("Library addresses:");
		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();

		// Try to borrow The Lords of the Rings from both libraries
		System.out.println("Borrowing The Lord of the Rings:");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();

		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
	}
}
