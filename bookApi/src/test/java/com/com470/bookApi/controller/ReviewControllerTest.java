package com.com470.bookApi.controller;

import com.com470.bookApi.model.Book;
import com.com470.bookApi.model.Review;
import com.com470.bookApi.repository.BookRepository;
import com.com470.bookApi.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReviewControllerTest {
    private static final int BOOK_ID = 1;
    private static final int REVIEW_ID = 2;
    private static final String DESCRIPTION = "Great book!";

    private Book book;
    private Review review;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewController reviewController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        book = new Book();
        book.setId(BOOK_ID);
        book.setAuthor("Author");
        book.setTitle("Title");
        book.setRelease(2021);
        book.setReviews(new ArrayList<>());

        review = new Review();
        review.setId(REVIEW_ID);
        review.setDescription(DESCRIPTION);
        review.setBook(book);

        book.getReviews().add(review);
    }

    @Test
    void retrieveAllReviews() {
        when(bookRepository.findById(BOOK_ID)).thenReturn(Optional.of(book));

        ResponseEntity<List<Review>> response = reviewController.retrieveAllReviews(BOOK_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
        assertEquals(1, response.getBody().size());
        assertEquals(review, response.getBody().get(0));
    }

    @Test
    void retrieveAllReviewsBookNotFound() {
        when(bookRepository.findById(BOOK_ID)).thenReturn(Optional.empty());

        ResponseEntity<List<Review>> response = reviewController.retrieveAllReviews(BOOK_ID);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void createReview() {
        when(bookRepository.findById(BOOK_ID)).thenReturn(Optional.of(book));
        when(reviewRepository.save(review)).thenReturn(review);

        ResponseEntity<Object> response = reviewController.createReview(BOOK_ID, review);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(review, response.getBody());
    }

    @Test
    void createReviewBookNotFound() {
        when(bookRepository.findById(BOOK_ID)).thenReturn(Optional.empty());

        ResponseEntity<Object> response = reviewController.createReview(BOOK_ID, review);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }
}