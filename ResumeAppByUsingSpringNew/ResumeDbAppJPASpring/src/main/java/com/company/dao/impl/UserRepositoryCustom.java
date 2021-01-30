/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.User;

import java.util.List;

/**
 * @author UlviAshraf
 */
public interface UserRepositoryCustom {

    public List<User> getAllUser(String name, String surname, Integer nationalityId);

    public User findByEmailAndPassword(String email, String password);

    public boolean update(User u);

    public boolean addUser(User u);

    public void remove(int id);

    public User getById(int userId);

}
