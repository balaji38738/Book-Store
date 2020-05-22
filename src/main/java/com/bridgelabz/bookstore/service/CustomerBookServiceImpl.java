package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerBookServiceImpl implements ICustomerBookService {
    @Autowired
    public BookRepository bookRepository;

    @Override
    public Page<Book>  getAllBooks(Pageable pageable) {
        return bookRepository.findAllBy(pageable);
    }

    @Override
    public List<Book> searchBooks(String searchKey) {
       List<Book> bookList = new ArrayList<>();
       for (Book book : bookRepository.findAll()) {
           if (book.getAuthor().equalsIgnoreCase(searchKey) || book.getTitle().equalsIgnoreCase(searchKey)) {
               bookList.add(book);
           }
       }
       return bookList;
    }

    @Override
    public Page<Book> sortBooksByPriceAsc(Pageable pageable) {
        return bookRepository.findAllByOrderByPriceAsc(pageable);
    }

}