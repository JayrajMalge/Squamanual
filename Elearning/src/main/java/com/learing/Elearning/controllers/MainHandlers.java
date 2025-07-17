
package com.learing.Elearning.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin(origins = "http://localhost:4200")
@Controller 
public class MainHandlers {
   
    @GetMapping("/look")
    public String forward() {
        return "index";
    }
    
    /*@GetMapping("/")
    public String loginredirect() {
        return "index"; 
    }   */

    @RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect(@PathVariable String path) {
        return "forward:/index.html";
    }
}
