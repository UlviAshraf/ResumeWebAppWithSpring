/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;

import com.company.entity.EmploymentHistory;

import java.util.List;

import com.company.dao.inter.EmploymentHistoryDaoInter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author UlviAshraf
 */
@Repository
public class EmploymentHistoryDaoImpl implements EmploymentHistoryDaoInter {
    @PersistenceContext
    EntityManager em;
    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        String jpgl = "select e from EmploymentHistory e where e.user.id=:id";
        Query query = em.createQuery(jpgl, EmploymentHistory.class);
        query.setParameter("id", userId);
        return query.getResultList();
    }
}
