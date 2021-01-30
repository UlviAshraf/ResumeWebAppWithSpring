/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author UlviAshraf
 */
@Repository("countryDao")
@Transactional
public class CountryDaoImpl implements CountryDaoInter {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Country> getAll() {
        String jpgl = "select c from Country c";
        Query query = em.createQuery(jpgl, Country.class);
        return query.getResultList();
    }

    @Override
    public boolean update(Country country) {
        em.merge(country);
        return true;
    }

    @Override
    public boolean remove(int id) {
        Country country = em.find(Country.class, id);
        em.remove(country);
        return true;
    }

    @Override
    public boolean add(Country country) {
        em.persist(country);
        return true;
    }

    @Override
    public Country getById(int id) {
        Country country = em.find(Country.class, id);
        return country;
    }
}
