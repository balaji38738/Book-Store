package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.IntStream;

@Service
public class AdminBookServiceImpl implements IAdminBookService {
    @Autowired
    public BookRepository bookRepository;

    @Override
    public void saveBookData() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/books_data.csv"));
            bufferedReader.readLine();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Book book = new Book();
                book.setId(Long.parseLong(data[0]));
                book.setAuthor(data[1]);
                book.setTitle(data[2]);
                book.setImage(data[3]);
                book.setPrice(Integer.parseInt(data[4]));
                IntStream.range(6, data.length - 1).forEach(column -> data[5] += "," + data[column]);
                book.setDescription(data[5]);
                bookRepository.save(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
