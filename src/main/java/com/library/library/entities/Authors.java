package com.library.library.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Authors {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column
    private String nationality;

    public Authors(){}

    public Authors(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

}
