package com.books.data.services;

import com.books.data.entities.Publishers;
import com.books.data.repository.PublishersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PublishersService {

    @Autowired
    private PublishersRepository repo;

    public List<Publishers> listAll() {
        return repo.findAll();
    }

    public void save(Publishers publishers) {
        repo.save(publishers);
    }

    public Publishers get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
