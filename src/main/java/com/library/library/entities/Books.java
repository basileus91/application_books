package com.library.library.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Blob;
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
    private Date publishDate;

    @Column(name="is_edited")
    private boolean isEdited;

    @Column(name="is_borrowed")
    private boolean isBorrowed;

    @Column(name="book_image")
    private String bookImage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", nullable = false)
    private Authors authors;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publishers publishers;


    @Column(name="exemplar_numbers")
    @Min(1)
    private Integer exemplarNumber;

}
