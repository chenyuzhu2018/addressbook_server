package com.example.addressbookserver.Controller;

import com.example.addressbookserver.service.RemoveUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoveUserController {

    @RequestMapping("/removePepple/{id}")
    boolean removeUser(@PathVariable String id){
        RemoveUserService removeUserService = new RemoveUserService();
        int nId = Integer.parseInt(id);
        return removeUserService.removeUser(nId);
    }

}
