package com.example.igonan.Service;



import com.example.igonan.Entity.food;
import com.example.igonan.Repository.foodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class foodService {

  @Autowired
   private foodRepository foodRepository;

    public List<food> findAll(){
        return foodRepository.findAll(Sort.by(Sort.Direction.DESC,"uptime") );
    }
    public List<food> findAllbyName( ){

        return foodRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
    public List<food> findOnebyName(String name){
        return foodRepository.selectone(name);
    }
    public void inFood(food f){

        foodRepository.save(f);
    }
    public void updateFood(food f){
        foodRepository.save(f);
    }
    public  void deleteFood(String name){
        foodRepository.deleteById(name);
    }
    public List<food> findaddr(String addr){

        return foodRepository.selectaddr(addr);
    }
    public  List<food> findForType(String type){
        return foodRepository.selecttype(type);
    }
    public  List<food> findRecommend(String name){
        return foodRepository.selectRecommend(name);
    }

    public List<food> findSearchData(String name){
        return  foodRepository.selectForSearchIndexDataReturn(name);
    }


}
