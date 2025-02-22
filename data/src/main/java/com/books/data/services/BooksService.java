package com.books.data.services;

import com.books.data.entities.Books;
import com.books.data.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BooksService {

    @Autowired
    private BooksRepository repo;

    public List<Books> listAll() {
        return repo.findAll();
    }

    public void save(Books books) {
        repo.save(books);
    }

    public Books get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
