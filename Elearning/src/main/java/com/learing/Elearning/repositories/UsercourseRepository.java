/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.learing.Elearning.repositories;

import com.learing.Elearning.entities.Usercourse;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsercourseRepository extends JpaRepository<Usercourse , Integer>{
        @Query("SELECT u FROM Usercourse u WHERE u.user.userid = :userid")
        List<Usercourse> findByUserid(@Param("userid") Integer userid);
        
        @Query("DELETE FROM Usercourse u WHERE u.usercourseid = :usercourseid")
         void deleteByUsercourseid(@Param("usercourseid") Integer usercourseid);

}
