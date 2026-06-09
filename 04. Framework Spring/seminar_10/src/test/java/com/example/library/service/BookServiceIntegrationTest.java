package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class BookServiceIntegrationTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testAddAndRetrieveBooks() {
        bookRepository.deleteAll();

        Book book = new Book(null, "Integration Test Book", "Test Author", 2022);
        Book savedBook = bookService.addBook(book);

        assertNotNull(savedBook.getId());
        assertEquals("Integration Test Book", savedBook.getTitle());

        List<Book> books = bookService.getAllBooks();
        assertEquals(1, books.size());
        assertEquals("Integration Test Book", books.get(0).getTitle());
    }
}
