package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByLibraryId(Long libraryId);
	  void deleteByTitle(String title);
	

}
