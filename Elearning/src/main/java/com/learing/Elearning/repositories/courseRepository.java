
package com.learing.Elearning.repositories;

import com.learing.Elearning.entities.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface courseRepository extends JpaRepository<Course , Integer>{
    
     @Query( "SELECT c FROM Course c WHERE c.category.categoryid = :category")
     List<Course> findByCategory(@Param("category")Integer category);

      @Query("SELECT c FROM Course c WHERE c.points = :points")
      List<Course> findByPoints(@Param("points") Integer points);
      
      @Query("SELECT c FROM Course c WHERE c.courseid = :courseid")
      Course findByCourseid(@Param("courseid") Integer courseid);

      @Query("SELECT c FROM Course c WHERE c.name LIKE LOWER(CONCAT('%', :name, '%'))")
      public List<Course> findByName(@Param("name") String name);
}
