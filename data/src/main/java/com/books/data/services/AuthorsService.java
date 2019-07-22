package com.books.data.services;

import com.books.data.entities.Authors;
import com.books.data.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorsService {

    @Autowired
    private AuthorsRepository repo;

    public List<Authors> listAll() {
        return repo.findAll();
    }

    public void save(Authors authors) {
        repo.save(authors);
    }

    public Authors get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
