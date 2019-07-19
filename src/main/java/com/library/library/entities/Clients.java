package com.library.library.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Please provide a name")
    private String firstName;

    @Column(name="last_name")
    @NotEmpty(message = "Please provide a last name")
    private String lastName;

    @Column(name="birth_date")
    @DateTimeFormat(pattern = "MM.dd.yy")
    private Date birthDate;

    @Email
    @Column
    @NotEmpty(message = "Please provide a email")
    private String email;

    @Column(name="phone_number")
    @NotEmpty(message = "Please provide a phone number")
    private String phoneNumber;

}
