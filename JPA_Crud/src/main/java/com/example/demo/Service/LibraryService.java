package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Library;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LibraryRepository;

import jakarta.transaction.Transactional;
@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepo;
    @Autowired
    private BookRepository bookRepo;

    @Transactional
    public Library createLibraryWithBooks(Library library, List<String> bookTitles) {
        for (String title : bookTitles) {
            Book book = new Book();
            book.setTitle(title);
            book.setLibrary(library);
            library.getBooks().add(book);
        }
        return libraryRepo.save(library); // Saves both Library and Books
    }

    public List<Book> getBooksInLibrary(Long libraryId) {
        return bookRepo.findByLibraryId(libraryId);
    }

    @Transactional
    public void deleteBookByTitle(String title) {
        bookRepo.deleteByTitle(title);
    }
}

















