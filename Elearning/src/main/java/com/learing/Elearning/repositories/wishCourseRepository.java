
package com.learing.Elearning.repositories;

import com.learing.Elearning.entities.Wishcourse;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface wishCourseRepository extends JpaRepository<Wishcourse , Integer>{
    
    @Query("SELECT w FROM Wishcourse w WHERE w.wishcourseid = :wishcourseid")
    public Wishcourse findByWishcourseid(@Param("wishcourseid") Integer wishcourseid); 
    
    @Query("SELECT w FROM Wishcourse w WHERE w.user.userid = :userid")
    public List<Wishcourse> findByUser(@Param("userid") Integer userid);
    
    @Query("SELECT w FROM Wishcourse w WHERE w.course.courseid = :courseid AND w.user.userid = :userid")
    public Wishcourse findByCourseAndUser(@Param("courseid") Integer courseid,@Param("userid") Integer userid);
    
    @Transactional
    @Modifying
    @Query("DELETE FROM Wishcourse w WHERE w.user.userid = :userId AND w.course.courseid = :courseId")
    public Integer deleteByUserAndCourse(@Param("userId") Integer userId, @Param("courseId") Integer courseId);

     @Transactional
     @Modifying
     @Query("DELETE  FROM Wishcourse w WHERE w.wishcourseid = :wishcourseid")
     public Integer deleteByWishcourseid(@Param("wishcourseid") Integer wishcourseid);
                   
}
