
package com.learing.Elearning.repositories;

import com.learing.Elearning.entities.Category;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface categoryRepository extends JpaRepository<Category , String>{
     public List<Category> findByName(String name);
}