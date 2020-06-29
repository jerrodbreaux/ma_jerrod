package com.javasampleapproach.springsecurity.jdbcauthentication.controllers;


import com.javasampleapproach.springsecurity.jdbcauthentication.models.CustomResponseObject;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.Message;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.User;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.UserChats;
import com.javasampleapproach.springsecurity.jdbcauthentication.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping                                                                                 //EndPoint 1
    public CustomResponseObject<ArrayList<User>> getUsers(){
        CustomResponseObject<ArrayList<User>> obj = new CustomResponseObject<>();
        obj.setData(userService.getUsers());
        return obj;
    }

    @GetMapping("/{id}")                                                                        //EndPoint 2
    public CustomResponseObject<User> getUserById(@PathVariable int id){
        CustomResponseObject<User> obj = new CustomResponseObject<>();
        obj.setData(userService.getUserById(id));
        return obj;
    }

    @GetMapping("/{id}/chats")                                                                  //EndPoint 3
    public CustomResponseObject<ArrayList<UserChats>> getUserChatsById(@PathVariable int id){
        CustomResponseObject<ArrayList<UserChats>> obj = new CustomResponseObject<>();
        obj.setData(userService.getChatsByUserId(id));
        return obj;
    }

    @GetMapping("/{id}/chats/{other_id}")                                                       //EndPoint 4
    public CustomResponseObject<ArrayList<Message>> getSpecificChatByUserIds(
            @PathVariable int id,
            @PathVariable int other_id
    ){
        CustomResponseObject<ArrayList<Message>> obj = new CustomResponseObject<>();
        obj.setData(userService.getChatDetail(id, other_id));
        return obj;
    }

}
