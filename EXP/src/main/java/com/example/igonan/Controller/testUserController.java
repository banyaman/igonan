package com.example.igonan.Controller;
import com.example.igonan.Entity.testUser;

import com.example.igonan.Service.testUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.message.callback.PrivateKeyCallback;
import javax.validation.Valid;
import java.util.List;

@Controller
public class testUserController {

    @Autowired
    testUserService testUserService;
/*
    @RequestMapping("/")
    public String mmain( ) {

        return "main";
    }
    @RequestMapping("/main")
    public String main( ) {

        return "main";
    }

    @ResponseBody
    @RequestMapping(value = "/usersreturn")
    public List<testUser> allUserReturn() {
        return testUserService.findAll();

    }

    @RequestMapping(value = "/users")
    public String allUser() {
        return "testUsers";

    }

    @ResponseBody
    @RequestMapping(value = "/asd")
    public List<testUser> testlike(String name) {
        return testUserService.testlike(name);

    }

    @RequestMapping("/join")
    public String joinUserForm(){
        return "index";
    }

    @RequestMapping("/joinInsert")
        public String joinUser(testUser tu){
        testUserService.inLine(tu);
        return "redirect:/users";
    }

    @RequestMapping("/update")
    public String updateUserForm(Model model){
        return "index";
    }

    @RequestMapping("/updateUser")
    public String updateUser(testUser tu){
        testUserService.updateLine(tu);
        return "redirect:/users";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(String name){
        testUserService.deleteLine(name);
        return "redirect:/users";
    }


*/
}
