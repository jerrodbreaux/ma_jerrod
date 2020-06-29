package com.javasampleapproach.springsecurity.jdbcauthentication.controllers;


import com.javasampleapproach.springsecurity.jdbcauthentication.exceptions.CustomException;


import com.javasampleapproach.springsecurity.jdbcauthentication.models.User;
import com.javasampleapproach.springsecurity.jdbcauthentication.services.UserService;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller

public class WebController {

   @Autowired
   UserService userService;

    @RequestMapping(value="/")
    public String home(){

        return "home";
    }
   
//    @RequestMapping(value="/user")
//    public String user(Authentication authentication){
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        System.out.println("User has authorities: " + userDetails.getAuthorities());
//
//        return "user";
//    }

    @RequestMapping("/admin/index")
    public String getMainPage(Authentication authentication, Model model){
        int user_id = userService.findUserByEmail(authentication.getName()).getUserId();
        model.addAttribute("user_id", user_id);

        return "admin/index";
    }
  

    @RequestMapping(value="/test")
    public String test(Model model) throws CustomException {

        throw new CustomException("jerrod");

    }

    @RequestMapping(value="/test2")
    public String test2(Model model) throws Exception {

        throw new Exception("jerrod");

    }
   

   
    @RequestMapping(value="/403")
    public String Error403(){

        return "403";
    }

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }
}
