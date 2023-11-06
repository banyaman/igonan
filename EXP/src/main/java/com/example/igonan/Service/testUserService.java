package com.example.igonan.Service;


import com.example.igonan.Entity.testUser;
import com.example.igonan.Repository.testUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class testUserService {

@Autowired
    testUserRepository testUserRepository;


public List<testUser> findAll(){
    return testUserRepository.findAll();
}
public void inLine(testUser tu){
    testUserRepository.save(tu);
}
    public void updateLine(testUser tu){
        testUserRepository.save(tu);
    }
    public  void deleteLine(String name){
        testUserRepository.deleteById(name);
    }
    public List<testUser> testlike(String name){
        return testUserRepository.selectname(name);
    }

}
