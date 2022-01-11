package com.example.addressbookserver.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private int telephone;
    private String gender;
    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int nTelephone) {
        this.telephone = nTelephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
};
@RestController
public class GetPeopleController {

    @RequestMapping("/")
    public List<User> getPeople(){
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setGender("男");
        user.setUsername("仲崇涛");
        user.setTelephone(123123123);
        users.add(user);

        user = new User();
        user.setGender("男");
        user.setUsername("秦国海");
        user.setTelephone(12312333);
        users.add(user);
        return users;
    }
}