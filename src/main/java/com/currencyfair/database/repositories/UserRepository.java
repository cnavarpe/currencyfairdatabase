package com.currencyfair.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currencyfair.database.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
