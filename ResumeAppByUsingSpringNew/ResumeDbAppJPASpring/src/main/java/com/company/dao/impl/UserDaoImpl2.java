/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author UlviAshraf
 */
@Repository(value = "userDao2")
public class UserDaoImpl2 implements UserRepositoryCustom {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAllUser(String name, String surname, Integer nationalityId) {
        String jpql = "select u from User u where 1=1";
        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname ";
        }
        if (nationalityId != null) {
            jpql += " and u.nationality_id=:nId ";
        }
        Query query = em.createQuery(jpql, User.class);
        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (nationalityId != null) {
            query.setParameter("nId", nationalityId);
        }
        List<User> list = query.getResultList();
        return list;
    }
    //JPQL
//    @Override
//    public User findByEmailAndPassword(String email, String password) {
//        Query query = em.createQuery("select u from User u where u.email=:email and u.password=:password", User.class);
//        query.setParameter("email", email);
//        query.setParameter("password", password);
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            User user = list.get(0);
//            return user;
//        }
//        return null;
//    }
    //CriteriaBuilder
//    @Override
//    public User findByEmailAndPassword(String email, String password) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> q = cb.createQuery(User.class);
//        Root<User> root = q.from(User.class);
//        q.where(cb.equal(root.get("email"), email), cb.equal(root.get("password"), password));
//        Query query = em.createQuery(q);
//      List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            User user = list.get(0);
//            return user;
//        }
//        return null;
//    }

    //NamedQuery
//    @Override
//    public User findByEmailAndPassword(String email, String password) {
//        Query query = em.createNamedQuery("User.findByEmailAndPassword", User.class);
//        query.setParameter("email", email);
//        query.setParameter("password", password);
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            User user = list.get(0);
//            return user;
//        }
//        return null;
//    }

    //NativeSql
    @Override
    public User findByEmailAndPassword(String email, String password) {
        Query query = em.createNativeQuery("select * from user where email=? and password=?", User.class);
        query.setParameter(1, email);
        query.setParameter(2, password);
        List<User> list = query.getResultList();
        if (list.size() == 1) {
            User user = list.get(0);
            return user;
        }
        return null;
    }

    @Override
    public boolean update(User u) {
        em.merge(u);
        return true;
    }

    @Override
    public void remove(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Override
    public User getById(int userId) {
        User user = em.find(User.class, userId);
        return user;
    }

    @Override
    public boolean addUser(User u) {
        em.persist(u);
        return true;
    }
}
