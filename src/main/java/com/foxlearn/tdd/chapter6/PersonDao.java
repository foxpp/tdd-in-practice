package com.foxlearn.tdd.chapter6;

import java.util.List;

/**
 * Created by zhaochao on 17/10/25.
 */
public interface PersonDao {
    List<Person> findByLastName(String lastname);
    void save(Person person);
}
