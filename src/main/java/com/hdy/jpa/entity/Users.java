package com.hdy.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Users {
    private @Id @GeneratedValue
    Long id;
    private String lastName;
    private String firstName;

    public Users(String lastName, String firstName){
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
