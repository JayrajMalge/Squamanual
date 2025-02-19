
package com.learing.Elearning.repositories;

import com.learing.Elearning.entities.Topic;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface topicRepository extends JpaRepository<Topic,Integer> {
    
        @Query("SELECT t FROM Topic t WHERE t.course.courseid = :courseid")
        List<Topic> findByCourseid(Integer courseid);
                

}
