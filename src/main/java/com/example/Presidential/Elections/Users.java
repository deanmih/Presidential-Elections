package com.example.Presidential.Elections;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "users") // Maps this entity to the "users" table
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user") // Maps to the "user" column in the database
    private String username;

    @Column(name = "password") // Maps to the "password" column in the database
    private String password;

    @Column(name = "bio") // Maps to the "bio" column in the database
    private String bio;

    @Column(name = "competes")
    private boolean competes;

    @Column(name = "nrvotes")
    private int nrvotes;

    @Column(name = "voted")
    private boolean voted;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isCompetes() { 
        return competes; 
    }

    public void setCompetes(boolean competes) { 
        this.competes = competes; 
    }

    public int getNrvotes() { 
        return nrvotes; 
    }

    public void setNrvotes(int nrvotes) { 
        this.nrvotes = nrvotes; 
    }

    public boolean isVoted() { 
        return voted; 
    }

    public void setVoted(boolean voted) { 
        this.voted = voted; 
    }

}