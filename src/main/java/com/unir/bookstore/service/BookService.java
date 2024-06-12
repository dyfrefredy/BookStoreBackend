package com.unir.bookstore.service;

import com.unir.bookstore.data.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
}