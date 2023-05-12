package com.example.bookmanagment.services;

import com.example.bookmanagment.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getListOfBook();
    Book insertNewBook(Book newBook);
    Book getBookById(Integer id);

    void deleteById(Integer id);
}
