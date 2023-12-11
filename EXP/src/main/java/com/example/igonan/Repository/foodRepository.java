package com.example.igonan.Repository;
import java.util.List;
import com.example.igonan.Entity.food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface foodRepository extends JpaRepository<food,String> {
    @Query("select f from food f where f.addr LIKE %:addr%")
    List<food> selectaddr(@Param("addr") String addr);
    @Query("select f from food f where f.name LIKE %:name%")
    List<food> selectone(@Param("name") String name);
    @Query("select f from food f where f.type LIKE %:type%")
    List<food> selecttype(@Param("type") String type);
    @Query("select f from food f where f.recommend LIKE %:recommend%")
    List<food> selectRecommend(@Param("recommend") String recommend);

     @Query("select f from food f where f.name LIKE %:name% or f.addr LIKE %:name% or f.type LIKE %:name% or f.recommend LIKE %:name%")
    List<food> selectForSearchIndexDataReturn(@Param("name") String name);

    //    @Query("select count(*) from food f where f.recommend LIKE %:recommend or f.type like %:recommend")
//    List<food> selectCountRecommendSearch(@Param("recommend") String recommend);





}
