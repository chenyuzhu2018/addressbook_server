package com.example.addressbookserver.service;

import com.example.addressbookserver.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PeopleManager {
    private static final PeopleManager instance = new PeopleManager();

    private PeopleManager() {
        userList = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setGender("男");
        user.setName("仲崇涛");
        user.setTelephone(123123123);
        userList.add(user);

        user = new User();
        user.setId(2);
        user.setGender("男");
        user.setName("秦国海");
        user.setTelephone(12312333);
        userList.add(user);
    }

    public static PeopleManager getInstance() {
        return instance;
    }

    public List<User> getUsers() {
        return userList;
    }

    int addUser(User user) {
        boolean seen = false;
        Integer best = null;
        for (User user1 : userList) {
            Integer id = user1.getId();
            if (!seen || id.compareTo(best) > 0) {
                seen = true;
                best = id;
            }
        }
        Integer newId = seen ? best + 1 : 1;
        user.setId(newId);
        userList.add(user);
        return user.getId();
    }
    public boolean deleteUser(int id) {
        for (User user : userList)
        {
            if (user.getId() == id)
            {
                userList.remove(user);
                return true;
            }
        }
        return false;
    }
    private final List<User> userList;
}
