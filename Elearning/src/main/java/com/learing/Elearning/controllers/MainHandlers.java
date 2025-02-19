
package com.learing.Elearning.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller 
public class MainHandlers {
   
    @GetMapping(value = {"/look", "/{path:[^\\.]*}"}) 
    public String redirect() {
        return "forward:/index.html"; 
    }   
}
