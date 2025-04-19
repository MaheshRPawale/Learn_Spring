package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.LibraryService;
import com.example.demo.entity.Book;
import com.example.demo.entity.Library;

@RestController
@RequestMapping("/api/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping
    public ResponseEntity<Library> createLibrary(@RequestBody Map<String, Object> payload) {
        String name = (String) payload.get("name");
        List<String> books = (List<String>) payload.get("books");

        Library library = new Library();
        library.setName(name);

        Library savedLibrary = libraryService.createLibraryWithBooks(library, books);
        return ResponseEntity.ok(savedLibrary);
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getBooks(@PathVariable Long id) {
        return ResponseEntity.ok(libraryService.getBooksInLibrary(id));
    }

    @DeleteMapping("/books/{title}")
    public ResponseEntity<String> deleteBook(@PathVariable String title) {
        libraryService.deleteBookByTitle(title);
        return ResponseEntity.ok("Book deleted: " + title);
    }
}
