package com.example.addressbookserver.Controller;

import com.example.addressbookserver.entity.User;
import com.example.addressbookserver.service.GetPeopleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GetPeopleController {

    @RequestMapping("/getPepples")
    public List<User> getPeople(){
//        List<User> users = new ArrayList<>();
//        User user = new User();
//        user.setId(1);
//        user.setGender("男");
//        user.setName("仲崇涛");
//        user.setTelephone(123123123);
//        users.add(user);
//
//        user = new User();
//        user.setId(2);
//        user.setGender("男");
//        user.setName("秦国海");
//        user.setTelephone(12312333);
//        users.add(user);
        GetPeopleService getPeopleService = new GetPeopleService();
        return getPeopleService.getUsers();
    }
}