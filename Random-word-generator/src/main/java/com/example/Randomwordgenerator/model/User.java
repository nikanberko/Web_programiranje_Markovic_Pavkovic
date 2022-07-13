package com.example.Randomwordgenerator.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name= "users")
@DynamicInsert
@DynamicUpdate
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name= "username")
    private String username;


    @Column(name = "email")
    private String email;


    public User(String username, String email) {
        this.username = username;

        this.email = email;

    }




}
