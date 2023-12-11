package com.example.igonan.Service;

import com.example.igonan.Entity.image;
import com.example.igonan.Repository.imageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class imageService {

    @Autowired
    private imageRepository imagerepository;

    public void insertImage(String foodName, String imagePath){

        image im = new image();
        im.setFoodName(foodName);
        im.setImagePath(imagePath);
        imagerepository.save(im);
    }
    public String selectOneImage(String name){

        image asd = imagerepository.selectOneImage(name);
        if(asd == null || asd.getImagePath() == null) {
            return "";
        }
        return asd.getImagePath();
    }
    public void deleteImage(String name){

        if(!selectOneImage(name).isEmpty()) {
            imagerepository.deleteById(name);
        }
    }

}
