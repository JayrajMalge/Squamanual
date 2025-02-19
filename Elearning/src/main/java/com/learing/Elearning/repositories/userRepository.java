
package com.learing.Elearning.repositories;

import com.learing.Elearning.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User,Integer>{
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsername(String username);
    
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(String email);
    
    @Query("SELECT u FROM User u WHERE u.userid = :userid")
    User findByUserid(@Param("userid") Integer userid);
    
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.name = :name, u.email = :email WHERE u.userid = :userid")
    Integer updateByName(@Param("name") String username, @Param("email") String email,@Param("userid") Integer userid);
}
