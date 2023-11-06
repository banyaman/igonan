package com.example.igonan.Controller;

import com.example.igonan.Entity.testUser;
import com.example.igonan.Service.testUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class dataReturnTrackBack {

    @Autowired
    private testUserService testUserService;

    @RequestMapping(value = "/usersReturn", method = {RequestMethod.POST})
    public List<testUser> allUser() {
        return testUserService.findAll();

    }

}