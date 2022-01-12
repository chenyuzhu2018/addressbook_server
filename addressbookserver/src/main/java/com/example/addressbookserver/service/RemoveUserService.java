package com.example.addressbookserver.service;

import com.example.addressbookserver.entity.User;

import java.util.List;

public class RemoveUserService {
    public boolean removeUser(int id){
        return PeopleManager.getInstance().deleteUser(id);
    }
}
