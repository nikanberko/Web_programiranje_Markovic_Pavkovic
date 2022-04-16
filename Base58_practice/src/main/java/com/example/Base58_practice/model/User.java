package com.example.Base58_practice.model;

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

    @Column(name= "first_name")
    private String firstName;


    @Column(name = "email")
    private String email;



    public User(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.email = email;

    }




}
