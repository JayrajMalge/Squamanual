
package com.learing.Elearning.repositories;

import com.learing.Elearning.entities.Reviews;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRespository extends JpaRepository<Reviews , Integer>{
        @Query("SELECT r FROM Reviews r WHERE r.user.userid = :userid AND r.course.courseid = :courseid")
        public List<Reviews> findByUserandCourse(@Param("userid") Integer userid,@Param("courseid") Integer courseid); 

}
