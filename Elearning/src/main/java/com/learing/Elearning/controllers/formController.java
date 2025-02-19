
package com.learing.Elearning.controllers;

import com.learing.Elearning.EmailService;
import com.learing.Elearning.entities.Category;
import com.learing.Elearning.entities.Course;
import com.learing.Elearning.entities.User;
import com.learing.Elearning.repositories.categoryRepository;
import com.learing.Elearning.repositories.courseRepository;
import com.learing.Elearning.repositories.userRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class formController {
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private userRepository users;
    
    @Autowired
    private categoryRepository categories;
    
    @Autowired 
    private courseRepository courses;
    
    @GetMapping("/sendOTPtoemail/{email}")
    public ResponseEntity<Boolean> SendOTP(@PathVariable("email") String email){
        User check = users.findByEmail(email);
        if(check!=null){
            SecureRandom random = new SecureRandom();
            int otp = 100000 + random.nextInt(900000);
            emailService.sendEmail(email, "OTP From Elearning ", otp+" don't share this OTP");
            String OTP =Integer.toString(otp);
             emailService.generateOtp(email, OTP);
             return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);        
    } 
    
    @PostMapping( "/emailverfication")
    public ResponseEntity<User> verfity(@RequestParam String email,@RequestParam String otp)
    {
       
       if(this.emailService.verifyOtp(email, otp)){
            User olduser = users.findByEmail(email);
            if(olduser!=null){
                return ResponseEntity.ok(olduser);
            }
       }
       return ResponseEntity.ok(null);
    }
         
    /*@PostMapping("/setnewuserpassword")
    public User setnewuserpassword(@RequestBody User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPasswordhashsalted(passwordEncoder.encode(user.getPasswordhashsalted()));
        return users.save(user);
    }*/
    
   @GetMapping("/getallcategories")
   public List<Category>  getallcategories(){
      return  this.categories.findAll();
   }
   
   @GetMapping("/getcoursesbyname/{name}")
   public List<Course>  getcoursesbyname(@PathVariable("name") String name){
      return  this.courses.findByName(name);
   }
}

