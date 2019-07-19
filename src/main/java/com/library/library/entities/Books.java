package com.library.library.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "book_name")
    @NotEmpty(message = "*Please provide a book name")
    private String bookName;

    @Column(name="publish_date")
//    @DateTimeFormat(pattern = "MM.dd.yyyy")
    private Date publishDate;

    @Column(name="is_edited")
    private boolean isEdited;

    @Column(name="is_borrowed")
    private boolean isBorrowed;

    @Column(name="book_image")
    private String bookImage;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
    @JoinColumn(name = "author_id", nullable = false)
    @NotNull
    private Authors authors;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
    @JoinColumn(name = "publisher_id", nullable = false)
    @NotNull
    private Publishers publishers;


    @Column(name="exemplar_numbers")
    @NotNull(message = "Field cannot be empty")
    private Integer exemplarNumber;

}
