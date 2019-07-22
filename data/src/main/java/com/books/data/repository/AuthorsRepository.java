package com.books.data.repository;

import com.books.data.entities.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Integer> {

}
