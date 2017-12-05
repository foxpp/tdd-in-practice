package com.foxlearn.tdd.chapter5;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaochao on 17/10/25.
 */
public class FakeAuthService implements AuthService {

    Map<String, String> users = new HashMap<>();

    public void addUser(String username, String pwd) {

        users.put(username, pwd);
    }

    @Override
    public boolean isValidLogin(String username, String password) {
        if(users.containsKey(username)){
            return users.get(username).equals(password);
        }
        return false;
    }
}
