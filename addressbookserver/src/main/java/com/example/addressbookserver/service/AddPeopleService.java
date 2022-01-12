package com.example.addressbookserver.service;

import com.example.addressbookserver.entity.User;

public class AddPeopleService {
    public int addUser(User user){
        return PeopleManager.getInstance().addUser(user);
    }
}
