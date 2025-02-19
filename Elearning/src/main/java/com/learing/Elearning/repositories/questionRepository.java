/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.learing.Elearning.repositories;

import com.learing.Elearning.entities.Question;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface questionRepository extends JpaRepository<Question,Integer> {
        @Query("SELECT q FROM Question q WHERE q.concept.conceptid = :concept")
        List<Question> findByConcept(@Param("concept") Integer concept);

}
