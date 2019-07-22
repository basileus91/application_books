package com.books.data.repository;

import com.books.data.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Clients,Integer> {

}
