/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author UlviAshraf
 */
@Repository
@Transactional
public class SkillDaoImpl implements SkillDaoInter {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Skill> getAll() {
        String jpgl = "select s from Skill s";
        Query query = em.createQuery(jpgl, Skill.class);
        return query.getResultList();
    }

    @Override
    public boolean update(Skill skill) {
        em.merge(skill);
        return true;
    }

    @Override
    public void add(Skill skill) {
        em.persist(skill);
    }

    @Override
    public boolean remove(int id) {
        Skill skill = em.find(Skill.class, id);
        em.remove(skill);
        return true;
    }

    @Override
    public Skill getById(int id) {
        Skill skill = em.find(Skill.class, id);
        return skill;
    }
}
