package com.foxlearn.tdd.chapter6;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhaochao on 17/10/26.
 */
public class HibernatePersonDaoIntegrationTest {

    SessionFactory getSessionFactory() throws IOException {
        return createConfiguration().buildSessionFactory();
    }


    Configuration createConfiguration() throws IOException {
        Configuration cfg = loadProductionConfiguration();
        loadTestConfigInto(cfg, "hibernate.test.properties");
        return cfg;

    }

    Configuration loadProductionConfiguration(){
        return new Configuration().configure();
    }

    private void loadTestConfigInto(Configuration cfg, String path) throws IOException {
        Properties properties = loadPropertiesFrom(path);
        cfg.setProperties(properties);
    }


    Properties loadPropertiesFrom(String path) throws IOException {
        InputStream stream = getClass().getResourceAsStream(path);
        Assert.assertNotNull("Resouces not found: " + path, stream);
        Properties properties = new Properties();
        properties.load(stream);
        stream.close();
        return properties;
    }


}
