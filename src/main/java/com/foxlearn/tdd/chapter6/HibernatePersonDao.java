package com.foxlearn.tdd.chapter6;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import java.util.List;

/**
 * Created by zhaochao on 17/10/25.
 */
public class HibernatePersonDao implements PersonDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Person> findByLastName(String lastname) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Person p where p.lastname = :lastname";
        Query query = session.createQuery(hql);
        query.setParameter("lastname",lastname);
        return query.list();
    }

    @Override
    public void save(Person person) {

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(person);
        tx.commit();
    }
}
