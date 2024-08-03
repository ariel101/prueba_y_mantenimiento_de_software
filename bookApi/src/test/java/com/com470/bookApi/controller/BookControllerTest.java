package com.com470.bookApi.controller;

import com.com470.bookApi.model.Book;
import com.com470.bookApi.model.Review;
import com.com470.bookApi.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookControllerTest {

    private static final int ID = 2;
    private static final String AUTHOR = "Homero";
    private static final int RELEASE = 2000;
    private static final String TITLE = "La Odisea";
    private static final List<Review> REVIEW_LIST = new ArrayList<>();

    Book book;
    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookController bookController;
    @BeforeEach
    void setUp() {

        book = new Book();
        book.setAuthor(AUTHOR);
        book.setId(ID);
        book.setRelease(RELEASE);
        book.setReviews(REVIEW_LIST);
        book.setTitle(TITLE);
    }

    @Test
    void retrieveAllBooks() {
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
        final List<Book> response= bookController.retrieveAllBooks();
        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(response.size(),1);
    }

    @Test
    void retrieveBook() {
        when(bookRepository.findById(ID)).thenReturn(Optional.of(book));

        ResponseEntity<Book> response = bookController.retrieveBook(ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
    }

    @Test
    void retrieveBookNotFound() {
        when(bookRepository.findById(ID)).thenReturn(Optional.empty());

        ResponseEntity<Book> response = bookController.retrieveBook(ID);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void createBook() {
        when(bookRepository.existsById(book.getId())).thenReturn(false);
        when(bookRepository.save(book)).thenReturn(book);

        ResponseEntity<Object> response = bookController.createBook(book);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
    }

    @Test
    void createBookExist() {
        when(bookRepository.existsById(book.getId())).thenReturn(true);

        ResponseEntity<Object> response = bookController.createBook(book);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void deleteBook() {
        when(bookRepository.findById(ID)).thenReturn(Optional.of(book));
        ResponseEntity<Object> response = bookController.deleteBook(ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deleteBookNotFound() {
        when(bookRepository.findById(ID)).thenReturn(Optional.empty());

        ResponseEntity<Object> response = bookController.deleteBook(ID);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}