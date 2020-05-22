package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.service.ICustomerBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/book-store")
public class CustomerBookController {
    @Autowired
    ICustomerBookService customerBookService;

    @GetMapping("/home")
    public Page<Book> allBooks(Pageable pageable) {
        return this.customerBookService.getAllBooks(pageable);
    }

    @GetMapping("/search-books")
    public ResponseEntity<List<Book>> searchBooks(@RequestBody String searchKey) {
        return new ResponseEntity<>(customerBookService.searchBooks(searchKey), HttpStatus.OK);
    }

    @GetMapping("/sort/price-asc")
    public Page<Book> sortBooksByPriceAsc(Pageable pageable) {
        return this.customerBookService.sortBooksByPriceAsc(pageable);
    }

}
