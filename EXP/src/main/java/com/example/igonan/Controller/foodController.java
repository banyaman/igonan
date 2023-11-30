package com.example.igonan.Controller;

import com.example.igonan.Entity.food;
import com.example.igonan.Service.foodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class foodController {

    @Autowired
   foodService foodService;

    @RequestMapping("/")
    public String mmain( ) {

        return "main";
    }
    @RequestMapping("/main")
    public String main( ) {

        return "main";
    }
    @RequestMapping("/login")
    public String login( ) {

        return "login";
    }
    @RequestMapping("/logon")
    public String logon(HttpSession hs, String pw){
        if(pw.equals("9999")){
            System.out.println("admin login");
            hs.setAttribute("admin","loggedOn");
            return "redirect:/main";
        }
        return "redirect:/login";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession hs) {
        hs.removeAttribute("admin");
        System.out.println("admin logout");
        return "redirect:/main";
    }



    @ResponseBody
    @RequestMapping(value = "/sortbydate")
    public List<food> allUserReturn() {
        return foodService.findAll();
    }
    @ResponseBody
    @RequestMapping(value = "/sortbyid")
    public List<food> allUserReturnbyId( ) {
        return foodService.findAllbyName();
    }


    @ResponseBody
    @RequestMapping(value = "/findname")
    public List<food> findname(String name) {
        return foodService.findOnebyName(name);
    }
    @ResponseBody
    @RequestMapping(value = "/findaddr")
    public List<food> addrlike(String addr) {
        return foodService.findaddr(addr);
    }
    @ResponseBody
    @RequestMapping(value = "/findtype")
    public List<food> typelike(String type) {
        return foodService.findForType(type);

    }
    @ResponseBody
    @RequestMapping(value = "/findrecom")
    public List<food> findRecommend(String name) {
        return foodService.findRecommend(name);

    }
    @ResponseBody
    @RequestMapping(value = "/searchAll")
    public List<food> searchAll(String name) {
        return foodService.findSearchData(name);

    }

    @RequestMapping("/insert")
    public String insertForm(){
        return "insert";
    }

    @RequestMapping("/foodInsert")
    public String joinUser(food f){
        foodService.inFood(f);
        return "redirect:/main";
    }


    @RequestMapping("/update")
    public String updateUserForm(){
        return "";
    }

    @RequestMapping("/updateFood")
    public String updateUser(food f){
        foodService.updateFood(f);
        return "redirect:/main";
    }
    @RequestMapping("/deleteFood")
    public String deleteUser(String name){
        foodService.deleteFood(name);
        return "redirect:/main";
    }








}
