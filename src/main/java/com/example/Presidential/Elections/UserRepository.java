package com.example.Presidential.Elections;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
    // Additional query methods can be added here if needed

    
}