package com.books.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role",schema = "public")
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    @Column(name = "role")
    private String role;
}
