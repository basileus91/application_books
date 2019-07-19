package com.library.library.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = "publishers")
public class Publishers {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="publisher_name")
    @NotEmpty(message = "Please provide a publisher name")
    private String publisherName;

    @Column
    private String address;

}
