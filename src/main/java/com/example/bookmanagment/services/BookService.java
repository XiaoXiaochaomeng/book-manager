package com.example.bookmanagment.services;

import com.example.bookmanagment.entity.Book;
import com.example.bookmanagment.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getListOfBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book insertNewBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }
}
