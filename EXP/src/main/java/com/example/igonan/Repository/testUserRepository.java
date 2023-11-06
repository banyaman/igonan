package com.example.igonan.Repository;
import java.util.List;

import com.example.igonan.Entity.testUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface testUserRepository extends JpaRepository<testUser,String> {

    @Query("select tu from testUser tu where tu.name LIKE %:name%")
    List<testUser> selectname(@Param("name") String name);
}
