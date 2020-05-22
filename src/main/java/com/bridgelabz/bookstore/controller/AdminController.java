package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.service.IAdminBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/book-store/admin")
public class AdminController extends CustomerBookController {
    @Autowired
    IAdminBookService adminBookService;

    @GetMapping("")
    public String saveDataInDb() {
        adminBookService.saveBookData();
        return "Data saved";
    }
    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody Book book){
        return new ResponseEntity(adminBookService.addBook(book), HttpStatus.OK);
    }
    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file")MultipartFile multipartFile){
        File convertFile = new File("/home/rageshwari/Downloads/book.csv" + multipartFile.getOriginalFilename());
        try {
            convertFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try (FileOutputStream fout = new FileOutputStream(convertFile)){
//            fout.write(multipartFile.getBytes());
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
       return "File Uploaded Sucessfully";
    }

}
