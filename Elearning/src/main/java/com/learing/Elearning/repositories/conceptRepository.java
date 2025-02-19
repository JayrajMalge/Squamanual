
package com.learing.Elearning.repositories;

import com.learing.Elearning.entities.Concept;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface conceptRepository extends JpaRepository<Concept , Integer>{
        @Query("SELECT c FROM Concept c WHERE c.topic.topicid = :topicid")
        List<Concept> findByTopicid(Integer topicid);

}
