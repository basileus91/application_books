package com.books.data.services;

import com.books.data.entities.BorrowedBooks;
import com.books.data.repository.BorrowedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BorrowedBooksService {

    @Autowired
    private BorrowedBooksRepository repo;

    public List<BorrowedBooks> listAll() {
        return repo.findAll();
    }

    public void save(BorrowedBooks borrowedBooks) {
        repo.save(borrowedBooks);
    }

    public BorrowedBooks get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
