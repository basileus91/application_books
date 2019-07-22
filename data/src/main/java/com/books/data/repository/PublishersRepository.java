package com.books.data.repository;
import com.books.data.entities.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishersRepository extends JpaRepository<Publishers,Integer> {

}
