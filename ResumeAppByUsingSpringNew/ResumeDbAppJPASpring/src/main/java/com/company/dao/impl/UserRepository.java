package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
    public User findByName(String name);

    public User findByNameAndSurname(String name, String surname);

    @Query(value = "select u from User u where email=:email")
    User findByEmail(String email);
}
