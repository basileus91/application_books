package com.books.data.repository;

import com.books.data.entities.BorrowedBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedBooksRepository extends JpaRepository<BorrowedBooks,Integer> {
}
