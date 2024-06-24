import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatalogueTest {
	ReadItemCommand readItemCommandMock;
	WriteItemCommand writeItemCommandMock;
	 Catalogue catalogue;

	@BeforeEach
	void setUp() throws Exception {
		readItemCommandMock = mock(ReadItemCommand.class);
		writeItemCommandMock = mock(WriteItemCommand.class);
		catalogue = new Catalogue(readItemCommandMock, writeItemCommandMock);
	}


	@Test 
	public void getAllBooks_ReturnsEmptyBookList_IfNoBooksAreInTheCatalogue(){ 
		 // Arrange
        when(readItemCommandMock.readAll()).thenReturn(List.of());

        // Act
        List<Book> books = catalogue.getAllBooks();

        // Assert
        assertEquals(0, books.size());
	}
	@Test 

	public void getAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled(){ 
				
		catalogue.getAllBooks();
		
		verify(readItemCommandMock, times(1)).readAll();

	} 
	
	@Test 

	public void getAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled(){ 
		 // Arrange
        List<Book> books = new ArrayList<>();
        Book b = new Book();
        books.add(b);
        when(readItemCommandMock.readAll()).thenReturn(books);

        // Act
        List<Book> actual = catalogue.getAllBooks();

        // Assert
        assertEquals(actual, books);

	} 
	
	@Test
	public void addBook_PassesInParameterToInsertItemCommand() {
		Book b = new Book();
		
		catalogue.addBook(b);
		
		verify(writeItemCommandMock).insertItem(b);
	}
	
	@Test
	public void addBooks_CallsInsertItemPassesMultipleBooksToInsertItemBasedOnNumberOfBooksPassedIn() {
		Book b = new Book();
		Book b2 = new Book();
        List<Book> books = new ArrayList<>();
        books.add(b2);
        books.add(b);

		catalogue.addBooks(books);
		
		verify(writeItemCommandMock, times(books.size())).insertItem(any(Book.class));
		
	}
	
	@Test
	public void getBook_CallsGetItemWithISBNPassedInReturnsBook() {
		Book b = new Book("123");
		when(readItemCommandMock.getItem("123")).thenReturn(b);
		
		Book expected = catalogue.getBook("123");
		
		verify(readItemCommandMock, times(1)).getItem("123");
		
		assertEquals(b, expected);
		
	}
	
	@Test
	public void deleteBook_TakesBook_PassesItToDeleteItem() {
		Book b = new Book("123");
		
		catalogue.deleteBook(b);
		
		verify(writeItemCommandMock, times(1)).deleteItem(b);
	}
	
	@Test
	public void deleteAllBooks_CallsReadAllAndDeleteItemForEachBook() {
		Book b = new Book();
		Book b2 = new Book();
        List<Book> books = new ArrayList<>();
        books.add(b2);
        books.add(b);
        when(readItemCommandMock.readAll()).thenReturn(books);
        catalogue.deleteAllBooks();
        verify(writeItemCommandMock, times(books.size())).deleteItem(any(Book.class));
	}
}
