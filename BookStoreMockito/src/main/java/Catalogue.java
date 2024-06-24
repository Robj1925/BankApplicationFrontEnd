import java.util.ArrayList;
import java.util.List;

public class Catalogue {
	private List<Book> books;
	private ReadItemCommand readItemCommand;
	private WriteItemCommand writeItemCommand;
	
	public Catalogue(ReadItemCommand readItemCommand) {
		super();
		this.books = new ArrayList<>();
		this.readItemCommand = readItemCommand;
	}
	
	public Catalogue(ReadItemCommand readItemCommand, WriteItemCommand writeItemCommand) {
		super();
		this.books = new ArrayList<>();
		this.readItemCommand = readItemCommand;
		this.writeItemCommand = writeItemCommand;
	}

	public Catalogue(WriteItemCommand writeItemCommand) {
		super();
		this.books = new ArrayList<>();
		this.writeItemCommand = writeItemCommand;
	}

	public Catalogue() {
		super();
		this.books = new ArrayList<>();
	}
	public void addBook(Book b) {
		writeItemCommand.insertItem(b);
		
	}


	public List<Book> getAllBooks() {
		return readItemCommand.readAll();
	}
	public void addBooks(List<Book> books) {
		for(Book b : books) {
			writeItemCommand.insertItem(b);
		}
	}
	public Book getBook(String ISBN) {
		return readItemCommand.getItem(ISBN);
	}
	
	public void deleteBook(Book book) {
		writeItemCommand.deleteItem(book);
	}
	public void deleteAllBooks() {
		for (Book b : readItemCommand.readAll()) {
			writeItemCommand.deleteItem(b);
		}
	}

}
