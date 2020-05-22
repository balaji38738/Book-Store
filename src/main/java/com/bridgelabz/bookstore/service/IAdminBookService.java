package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.model.Book;

public interface IAdminBookService {
    void saveBookData();
    public Book addBook(Book book);

}
