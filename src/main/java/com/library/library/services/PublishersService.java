package com.library.library.services;

import com.library.library.entities.Publishers;
import com.library.library.repository.PublishersRepository;
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
