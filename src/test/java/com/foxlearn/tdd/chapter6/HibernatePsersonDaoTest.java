package com.foxlearn.tdd.chapter6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaochao on 17/10/26.
 */
public class HibernatePsersonDaoTest extends HibernatePersonDaoIntegrationTest{

    private SessionFactory sf;
    private Transaction tx;
    private PersonDao personDao;

    @Before
    public void setUp() throws IOException {
        sf = getSessionFactory();
        tx = sf.getCurrentSession().beginTransaction();
        personDao = new HibernatePersonDao();
        tx.begin();
    }


    @After
    public void tearDown(){
        tx.rollback();
    }


    @Test
    public void testeFindingAllSmiths() {
        List<Person> theSmiths = new ArrayList<>();
        theSmiths.add(new Person("test","Smith"));
        theSmiths.add(new Person("test2", "Smith"));


        List<Person> allPeople  = new ArrayList<>();
        allPeople.addAll(theSmiths);
        allPeople.add(new Person("John", "dow"));

        persist(allPeople);

        Assert.assertEquals(theSmiths,personDao.findByLastName("Simth"));
    }


    private void persist(List objs){
        Session s = sf.getCurrentSession();
        for ( Object o : objs) {
            s.save(o);
        }
        s.flush();
    }
}
