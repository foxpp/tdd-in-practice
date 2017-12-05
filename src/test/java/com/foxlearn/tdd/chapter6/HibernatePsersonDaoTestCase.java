package com.foxlearn.tdd.chapter6;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;

/**
 * Created by zhaochao on 17/10/25.
 */
public class HibernatePsersonDaoTestCase {

    private SessionFactory factory;
    private Session session;
    private Query query;

    @Before
    public void setUp(){
        factory = createMock(SessionFactory.class);
        session = createMock(Session.class);
        query = createMock(Query.class);
    }



    @Test
    public void testFindByLastname(){
        String hql = "from Person p where p.lastname = :lastname";
        String lastname = "fox";


        List<Person> theFoxs = new ArrayList<>();
        theFoxs.add(new Person("111", lastname));
        theFoxs.add(new Person("122", lastname));
        theFoxs.add(new Person("123", lastname));


        expect(factory.getCurrentSession()).andReturn(session);
        expect(session.createQuery(hql)).andReturn(query);
        expect(query.setParameter("lastname", lastname)).andReturn(query);

        expect(query.list()).andReturn(theFoxs);


        replay(factory, session, query);

        HibernatePersonDao dao = new HibernatePersonDao();

        dao.setSessionFactory(factory);
        Assert.assertEquals(theFoxs, dao.findByLastName(lastname));

        verify(factory,session,query);

    }

}
