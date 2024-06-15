package com.unir.bookstore.service.impl;

import com.unir.bookstore.data.entity.Book;
import com.unir.bookstore.data.repository.BookRepository;
import com.unir.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    
    @Override
    public Book update(Long id, Book book) {
        Optional<Book> optionalLibro = bookRepository.findById(id);
        if (!optionalLibro.isPresent()) {
            throw new RuntimeException("El libro con id " + id + " no encontrado");
        }

        Book libroExistente = optionalLibro.get();
        libroExistente.setTitle(book.getTitle());
        libroExistente.setAuthor(book.getAuthor());
        libroExistente.setPrice(book.getPrice());

        return bookRepository.save(libroExistente);
    }
}
