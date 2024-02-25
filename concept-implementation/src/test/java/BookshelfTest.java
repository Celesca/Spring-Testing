import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookshelfTest {

    Bookshelf bookshelf;

    @BeforeEach
    void setUp() {
        // Arrange
        bookshelf = new Bookshelf();
    }

    @Test
    @DisplayName("add clean code book into bookshelf, bookshelf should contain clean code book")
    void addCleanCodeIntoBookshelf() {

        // Act 
        bookshelf.addBook(new Book(1, "Clean Code"));
    
        // Assert

        String actual = bookshelf.findBookById(1).title();
        String expected = "Clean Code";
        assertEquals(expected, actual);
    
    }

    // JUnit Exception
    @Test
    @DisplayName("find book by id 2 should throw BookNotFoundException")
    void findBookId2ShouldThrowException() {
        bookshelf.addBook(new Book(1, "Clean Code"));

        assertThrows(BookNotFoundException.class, () -> bookshelf.findBookById(2));
    }

    @Test
    @DisplayName("find book by id 2 should return message book not found")
    void throwBookNotFound() {
        bookshelf.addBook(new Book(1, "Clean Code"));

        var exception = assertThrows(BookNotFoundException.class, () -> bookshelf.findBookById(2));

        String expected = "book not found";
        assertEquals(expected, exception.getMessage());

    }

}