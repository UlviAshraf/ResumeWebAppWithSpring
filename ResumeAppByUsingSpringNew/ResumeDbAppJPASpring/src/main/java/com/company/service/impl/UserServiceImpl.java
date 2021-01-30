/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author UlviAshraf
 */
@Transactional
@Service
public class UserServiceImpl implements UserServiceInter {
    @Autowired
    @Qualifier("userDao1")
    UserRepositoryCustom userDao;

    @Override
    public List<User> getAllUser(String name, String surname, Integer nationalityId) {

        return userDao.getAllUser(name, surname, nationalityId);
    }

    //NativeSql
    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }

    @Override
    public boolean update(User u) {
        return userDao.update(u);
    }

    @Override
    public void remove(int id) {
        userDao.remove(id);
    }

    @Override
    public User getById(int userId) {
        return userDao.getById(userId);
    }

    @Override
    public boolean addUser(User u) {
        return userDao.addUser(u);
    }
}
