package com.learing.Elearning;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
    http.authorizeHttpRequests(registry->{
               registry.requestMatchers("/user","/conceptsfromtopicid/{topicid}","/getalluser","/manualLogin","/categories/{category}",
                       "/wishlistedcoursefromuserid/{userid}","/userfromusername/{username}","/getallcategories",
                       "/userfromemail/{email}","/userfromemail/{email}","/trendingcourse/{points}",
                       "/check/:courseid/:userid","/addtomylearning","/usercoursefromuserid/{userid}",
                       "/gettopicsfromcourseid/{courseid}","/addtomylearning","/manualLogin","/addcourseintowishlist",
                       "/removecoursefromwishlist/{wishcourseid}","/addcourseintodatabase","/addtopics","/addconcepts",
                       "/addreview","/updatenameandemail", "/adminlogin","/subcriptionenddateofcourse/{usercourseid}",
                       "/getquestionfromconcept/{concept}","/addtestcompletion","/getreviews","/sign","/authlogin",
                       "/getreviewbyuserandcourse/{userid}/{courseid}","/auth/login","/getfaqquestionbyuserid/{userid}",
                       "/getfaqquestion","/addfaquestion","/getgroupbyfaqquestion","/updateanswer","/getcoursefromcourseid/{courseid}",
                       "/addquestion","/getallcourses","/alalal","/sendOTPtoemail/{email}","/emailverfication","/setnewuserpassword",
                       "/getcoursesbyname/{name}","/","/look","/getcoursesbyname","/createnewusergooglelogin"
               ).permitAll();
               registry.anyRequest().authenticated();
        })
         .csrf().disable();
       return   http.build();
    }
    
   @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200/") 
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}


