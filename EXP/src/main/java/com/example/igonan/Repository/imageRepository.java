package com.example.igonan.Repository;

import java.util.List;


import com.example.igonan.Entity.image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface imageRepository extends JpaRepository<image,String> {

    @Query("select i from image i where i.foodName = :name")
    image selectOneImage(@Param("name") String name);




}
