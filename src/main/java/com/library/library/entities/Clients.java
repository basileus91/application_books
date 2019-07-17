package com.library.library.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="birth_date")
    private Date birthDate;

    @Email
    @Column
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

}
