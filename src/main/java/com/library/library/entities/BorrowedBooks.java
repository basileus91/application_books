package com.library.library.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name="borrowed_books")
public class BorrowedBooks {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="borrowed_date")
    private Date borrowedDate;

    @Column(name="returned_date")
    private Date returnedDate;

    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
    @JoinColumn(name = "book_id", nullable = false)
    private Books books;

    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
    @JoinColumn(name = "client_id", nullable = false)
    private Clients clients;
}
