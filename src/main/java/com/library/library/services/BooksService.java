package com.library.library.services;

import com.library.library.entities.Books;
import com.library.library.repository.BooksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
