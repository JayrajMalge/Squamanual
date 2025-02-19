
package com.learing.Elearning.repositories;

import com.learing.Elearning.entities.Faquestions;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQuestionRepository extends JpaRepository<Faquestions , Integer> {
         @Query("SELECT f FROM Faquestions f WHERE f.user.userid = :userid")
         List<Faquestions> findByUser(@Param("userid") Integer userid);

         @Query(value = "SELECT * FROM faquestions GROUP BY question" ,nativeQuery = true)
          List<Faquestions> findAllGropuByQuestion();
          
          @Modifying
          @Transactional
          @Query("UPDATE Faquestions f SET f.answer = :answer WHERE f.question = :question")
          Integer updateByQuestion(@Param("question") String question, @Param("answer") String answer);


}
