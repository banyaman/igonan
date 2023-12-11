package com.example.igonan.Controller;
import java.util.UUID;
import com.example.igonan.Entity.food;
import com.example.igonan.Service.foodService;
import com.example.igonan.Service.imageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class foodController {

    @Autowired
   foodService foodService;

    @Autowired
    imageService imageService;



    @Value("${file.upload-dir}")
    private String imageSaveDir;


    @RequestMapping("/")
    public String mmain( ) {

        return "main";
    }
    @RequestMapping("/main")
    public String main( ) {

        return "main";
    }

    @RequestMapping("/status")
    public String status(Model md,String name) {

        md.addAttribute("foodInfo",foodService.findOnebyName(name).get(0));
        md.addAttribute("image",imageService.selectOneImage(name));

        return "status";
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
    public String joinUser(food f , @RequestParam("img") MultipartFile file){

        if(file.isEmpty()){
            System.out.println("파일 없음");
        }else{
            System.out.println(file.getOriginalFilename());
        }

        foodService.inFood(f);
        try{
            if (!file.isEmpty()) {
                String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\FoodImage\\";
                String fileName = file.getOriginalFilename();
                String imagePath = projectPath+""+fileName;
                //System.out.println("저장 경로 : "+imagePath);
                File existingImage = new File(imagePath);
                if (!existingImage.exists()) {
                    file.transferTo(new File(imagePath));
                }else{
                    System.out.println("이미지가 이미 존재합니다");
                }
                String foodName = f.getName();
                imageService.insertImage(foodName, fileName);
            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("이미지 삽입되지 않음");
        }
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
    imageService.deleteImage(name);
        return "redirect:/main";
    }








}
