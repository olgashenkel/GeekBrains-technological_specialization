package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBooks() {
        Book book1 = new Book(1L, "Book One", "Author One", 2000);
        Book book2 = new Book(2L, "Book Two", "Author Two", 2005);

        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        List<Book> books = bookService.getAllBooks();

        assertNotNull(books);
        assertEquals(2, books.size());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void testGetBookById_Found() {
        Book book = new Book(1L, "Book One", "Author One", 2000);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Optional<Book> foundBook = bookService.getBookById(1L);

        assertTrue(foundBook.isPresent());
        assertEquals("Book One", foundBook.get().getTitle());
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void testGetBookById_NotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Book> foundBook = bookService.getBookById(1L);

        assertFalse(foundBook.isPresent());
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void testAddBook() {
        Book book = new Book(null, "Book One", "Author One", 2000);
        when(bookRepository.save(book)).thenReturn(new Book(1L, "Book One", "Author One", 2000));

        Book savedBook = bookService.addBook(book);

        assertNotNull(savedBook);
        assertEquals(1L, savedBook.getId());
        assertEquals("Book One", savedBook.getTitle());
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testUpdateBook_Found() {
        Book existingBook = new Book(1L, "Book One", "Author One", 2000);
        Book updatedBook = new Book(null, "Updated Title", "Updated Author", 2020);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(existingBook));
        when(bookRepository.save(existingBook)).thenReturn(existingBook);

        Book result = bookService.updateBook(1L, updatedBook);

        assertNotNull(result);
        assertEquals("Updated Title", result.getTitle());
        assertEquals("Updated Author", result.getAuthor());
        assertEquals(2020, result.getPublicationYear());
        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, times(1)).save(existingBook);
    }

    @Test
    void testUpdateBook_NotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                bookService.updateBook(1L, new Book(null, "Updated Title", "Updated Author", 2020)));

        assertEquals("Book not found", exception.getMessage());
        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, times(0)).save(any(Book.class));
    }

    @Test
    void testDeleteBook() {
        doNothing().when(bookRepository).deleteById(1L);

        bookService.deleteBook(1L);

        verify(bookRepository, times(1)).deleteById(1L);
    }
}
