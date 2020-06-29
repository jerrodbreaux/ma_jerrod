package com.javasampleapproach.springsecurity.jdbcauthentication.services;

import com.javasampleapproach.springsecurity.jdbcauthentication.mappers.UserMapper;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.Message;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.User;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.UserChats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    //EndPoint 1
    public ArrayList<User> getUsers(){
        return userMapper.getUsers();

    }
    //EndPoint 2
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    //EndPoint 3
    public ArrayList<UserChats> getChatsByUserId(int id) {
        ArrayList<UserChats> chats = userMapper.getChatsByUserId(id);
        for(UserChats chat : chats){
            chat.setPhotoUrl(userMapper.getPhotoUrl(chat.getSenderId()));
            chat.setLastMessage(userMapper.getLastMessage(chat.getChatId()));
        }
        return chats;
    }
    //EndPoint 4
    public ArrayList<Message> getChatDetail(int id, int other_id) {
        int chat_id = userMapper.getChatIdForUserIds(id, other_id);
        return userMapper.getMessagesByChatId(chat_id);
    }

    public User findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }


}
