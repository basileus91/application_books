package com.books.data.services;

import com.books.data.entities.Clients;
import com.books.data.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientsService {

    @Autowired
    private ClientsRepository repo;

    public List<Clients> listAll() {
        return repo.findAll();
    }

    public void save(Clients clients) {
        repo.save(clients);
    }

    public Clients get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
