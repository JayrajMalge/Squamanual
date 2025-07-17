
package com.learing.Elearning.controllers;


import com.learing.Elearning.EmailService;
import com.learing.Elearning.entities.Concept;
import com.learing.Elearning.entities.Course;
import com.learing.Elearning.entities.Faquestions;
import com.learing.Elearning.entities.Question;
import com.learing.Elearning.entities.Reviews;
import com.learing.Elearning.entities.Test;
import com.learing.Elearning.entities.Topic;
import com.learing.Elearning.entities.User;
import com.learing.Elearning.entities.Usercourse;
import com.learing.Elearning.entities.Wishcourse;
import com.learing.Elearning.repositories.FAQuestionRepository;
import com.learing.Elearning.repositories.ReviewRespository;
import com.learing.Elearning.repositories.TestRepository;
import com.learing.Elearning.repositories.UsercourseRepository;
import com.learing.Elearning.repositories.categoryRepository;
import com.learing.Elearning.repositories.conceptRepository;
import com.learing.Elearning.repositories.courseRepository;
import com.learing.Elearning.repositories.questionRepository;
import com.learing.Elearning.repositories.topicRepository;
import com.learing.Elearning.repositories.userRepository;
import com.learing.Elearning.repositories.wishCourseRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
    
    @Autowired
    private userRepository users; 
    
    @Autowired
    private categoryRepository categories;
    
    @Autowired 
    private courseRepository courses;
    
    @Autowired 
    private wishCourseRepository wishcourses; 
    
    
    @Autowired 
    private UsercourseRepository usercourses;
    
    @Autowired
    private topicRepository topics;
    
    @Autowired 
    private conceptRepository concepts;
    
    @Autowired
    private ReviewRespository reviews;
    
    @Autowired
    private questionRepository questions;
    
    @Autowired 
    private TestRepository tests;
    
    @Autowired
    private FAQuestionRepository faquestions;
    
    @Autowired
    private EmailService emailService;
    
    @GetMapping("/getalluser")
    public List<User> All_user(){
        return users.findAll();
    }
           
    @GetMapping("/home")
    public String getView(){
        return "view";
    }
    
    @GetMapping("/getallcourses")
    public List<Course> getallcourses(){
        return courses.findAll();
    }
    @GetMapping("/categories/{category}")
    public List<Course> getCategories(@PathVariable("category") Integer category)
    {
         return courses.findByCategory(category);
    }
    
    @GetMapping("/wishlistedcoursefromuserid/{userid}")
    public List<Wishcourse> getwishlistedcoursefromuserid(@PathVariable("userid") Integer userid)
    {
        return wishcourses.findByUser(userid);
    }
    
    
    @GetMapping("/userfromusername/{username}")
    public User getuserbyusername(@PathVariable("username") String username)
    { 
       return users.findByUsername(username);
    }
    
    @GetMapping("/userfromemail/{email}")
    public User getuserfromemail(@PathVariable("email") String email){
        User user = users.findByEmail(email);
        return users.findByEmail(email);
    }    
    
    /*@PostMapping(value = "/addcourseintowishlist", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Wishcourse addcourseintowishlist(@RequestBody Wishcourse course)
    {
        this.wishcourses.save(course);
        return course;
    }
    */
    @PostMapping(value = "/addcourseintowishlist" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Wishcourse> addcourseintowishlist(@RequestBody Wishcourse course)
    {
        this.wishcourses.save(course);
        return ResponseEntity.ok(course);
    }
  
   @GetMapping("/trendingcourse/{points}")
    public List<Course> getTreadingcourse(@PathVariable("points") Integer points)
    {
        return courses.findByPoints(points);
    }

    @GetMapping("/check/:courseid/:userid")
    public Wishcourse checkwishlistedornot(@PathVariable("courseid") Integer courseid , @PathVariable("userid") Integer userid)
    {
        return wishcourses.findByCourseAndUser(courseid, userid);
    }
    
    @PostMapping(value = "/addtomylearning", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usercourse sendtomylearning(@RequestBody Usercourse usercourse)
    {
        Integer userid = usercourse.getUser().getUserid();
        Integer courseid = usercourse.getCourse().getCourseid();
        User user = users.findByUserid(userid);
        Course course = courses.findByCourseid(courseid);
        String email = user.getEmail(); 
        Integer wish = wishcourses.deleteByUserAndCourse(userid, courseid);
        emailService.sendEmail(email, "Course Enrolling","You are sucessfully enrolled course "+usercourse.getCourse().getName()+"\nsubscription end date is "+usercourse.getSubscriptionend());
        usercourses.save(usercourse);
        return usercourse;
    }
    
    @GetMapping("/usercoursefromuserid/{userid}")
    public ResponseEntity<List<Usercourse>> getusercoursesfromuserid(@PathVariable("userid") Integer userid)
    {
        return ResponseEntity.ok(usercourses.findByUserid(userid));
    }
    
    @GetMapping("/gettopicsfromcourseid/{courseid}")
    public List<Topic> gettopicfromtopics(@PathVariable("courseid") Integer courseid)
    {
        return topics.findByCourseid(courseid);
    }
    
    @GetMapping("/conceptsfromtopicid/{topicid}")
    public List<Concept> getconcepts(@PathVariable("topicid") Integer topicid)
    {
        return concepts.findByTopicid(topicid);
    }      
    
    @DeleteMapping("/removecoursefromwishlist/{wishcourseid}")
    public void removecoursefromwishlist(@PathVariable("wishcourseid") Integer wishcourseid){
         wishcourses.deleteByWishcourseid(wishcourseid);
    }
    
    @PostMapping("/addcourseintodatabase")
    public Course addintocoursedatabase(@RequestBody Course course)
    {
        Course co = courses.save(course);
        return co;
    }
    
    @PostMapping("/addtopics")
    public Topic addtopicintodatabase(@RequestBody Topic topic)
    {
             Topic topictoadd = topics.save(topic);
             return topictoadd;
    }
       
    @PostMapping("/addconcepts")
    public Concept addconcepts(@RequestBody Concept concept)
    {
             Concept concepttoadd = concepts.save(concept);
             return concepttoadd;
    }
    
    @PostMapping("/addreview")
    public Reviews addreviews(@RequestBody Reviews review){
        Reviews revie = reviews.save(review);
        return revie;
    }
    
    @PostMapping("/updatenameandemail")
    public void updatenameandemail(@RequestBody User user)
    {
         users.updateByName(user.getName(),user.getEmail(),user.getUserid());
    }
        
    @DeleteMapping("/subcriptionenddateofcourse/{usercourseid}")
    public void removecoursefromusercourse(@PathVariable("usercourseid") Integer usercourseid)
    {
        usercourses.deleteByUsercourseid(usercourseid);
    }
     
    @GetMapping("/getquestionfromconcept/{concept}")
    public List<Question> getquestionfromconcept(@PathVariable("concept") Integer Concept){
        return questions.findByConcept(Concept);
    }
    
    @PostMapping(value = "/addtestcompletion",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Test addtestcompletion(@RequestBody Test completedtest)
    {
        Test test= tests.save(completedtest);
        return test;
    }
    
    @GetMapping("/getreviews")
    public List<Reviews> getreviews()
    {
        return reviews.findAll();
    }
    
    @GetMapping("/getreviewbyuserandcourse/{userid}/{courseid}")
    public List<Reviews> getreviewbyuserandcourse(@PathVariable("userid") Integer userid,@PathVariable("courseid") Integer courseid)
    {
        return reviews.findByUserandCourse(userid, courseid);
    }
    
    @GetMapping("/getfaqquestionbyuserid/{userid}")
    public List<Faquestions> getfaqbyuserid(@PathVariable("userid") Integer userid) 
    {
        return faquestions.findByUser(userid);
    }
    
    @PostMapping("/addfaquestion")
    public void  addfaquestion(@RequestBody Faquestions question)
    {
        faquestions.save(question);
    }
    
    @GetMapping("/getfaqquestion")
    public List<Faquestions> getallfaqbyuserid() 
    {
        return faquestions.findAll();
    }
    
    @GetMapping("/getgroupbyfaqquestion ")
    public List<Faquestions> getallgroupbyfaqbyuserid() 
    {
        return faquestions.findAllGropuByQuestion();
    }
    
    @PutMapping("/updateanswer")
    public Integer updateanswer(@RequestBody Faquestions faq)
    {
        return faquestions.updateByQuestion(faq.getQuestion(),faq.getAnswer());
    }
    
    @GetMapping("/getcoursefromcourseid/{courseid}")
    public Course getcoursefromcourseid(@PathVariable("courseid") Integer courseid) 
    {
        return courses.findByCourseid(courseid);
    }
    
    @PostMapping("/addquestion")
    public Question addquestion(@RequestBody Question question)
    {
        Question addedquestion = questions.save(question);
        return addedquestion;
    }
    
    @PostMapping("/createnewusergooglelogin")
    public User createnewusergooglelogin(@RequestBody User us){
        User alus = this.users.findByEmail(us.getEmail());
        if(alus!=null){
            return alus;
        }
        return this.users.save(us);
    }

    
}
