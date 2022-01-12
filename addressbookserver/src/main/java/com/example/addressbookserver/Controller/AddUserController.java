package com.example.addressbookserver.Controller;

import com.example.addressbookserver.entity.User;
import com.example.addressbookserver.service.AddPeopleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddUserController {

    @PostMapping("/addPeople")
    int addUser(@RequestBody User user){
        AddPeopleService service = new AddPeopleService();
        return service.addUser(user);
    }
}
