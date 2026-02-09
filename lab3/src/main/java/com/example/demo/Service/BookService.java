package com.example.demo.Service;

import com.example.demo.Model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private Long nextId = 1L;

    public BookService() {
        addBook(new Book(null, "Spring Boot", "Huy Cuong"));
        addBook(new Book(null, "Spring Boot V2", "Anh"));
        addBook(new Book(null, "Java Core", "Minh"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    public void updateBook(Book updatedBook) {
        getBookById(updatedBook.getId()).ifPresent(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        });
    }

    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
