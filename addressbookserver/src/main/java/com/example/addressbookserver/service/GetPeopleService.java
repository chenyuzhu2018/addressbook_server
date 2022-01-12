package com.example.addressbookserver.service;

import com.example.addressbookserver.entity.User;
import java.util.List;

public class GetPeopleService {
    public List<User> getUsers(){
        return PeopleManager.getInstance().getUsers();
    }
}
