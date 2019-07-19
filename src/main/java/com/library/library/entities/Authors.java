package com.library.library.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Authors {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    @NotEmpty(message = "Please provide a name")
    private String firstName;

    @Column(name="last_name")
    @NotEmpty(message = "Please provide a last name")
    private String lastName;

    @Column
    private String nationality;

}
