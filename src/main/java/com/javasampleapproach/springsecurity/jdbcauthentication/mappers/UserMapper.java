package com.javasampleapproach.springsecurity.jdbcauthentication.mappers;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Message;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.User;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.UserChats;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface UserMapper {

    String SELECT_ALL_USERS = "select * from user";                            //EndPoint 1
    String GET_USER_BY_ID = "select * from user where userId = #{id}";         //EndPoint 2

    //EndPoint 3
    String GET_CHAT_LIST = "select distinct(c.chatTitle) as chatName, c.id as chatId, " +
            "m.userId as senderId " +
            "from chats c " +
            "join messages m " +
            "on m.chatId = c.id " +
            "join userschats uc " +
            "on uc.chatId = c.id " +
            "where uc.userId = #{id} " +
            "and m.userId != #{id} " +
            "group by chatId, senderId " +
            "order by m.dateSent asc";

    String GET_CHAT_ID_FOR_USERS = "select uc.chatId " +
            "from userschats uc " +
            "where uc.userId = #{arg0} " +
            "or uc.userId = #{arg1} " +
            "group by uc.chatId " +
            "order by count(uc.chatId) desc " +
            "limit 1";

    String GET_MESSAGES_BY_CHAT_ID = "select m.id, m.message, m.dateSent, " +
            "m.chatId, m.userId as senderId, c.chatTitle " +
            "from messages m " +
            "join chats c " +
            "on m.chatId = c.id " +
            "where m.chatId = #{chat_id} " +
            "order by m.dateSent asc";

    String FIND_USER_BY_EMAIL = "select * from user where email = #{email}";

    String GET_PHOTO_URL = "select photoUrl from user where userId = #{senderId}";

    String GET_LAST_MESSAGE = "select message from messages where chatId = #{chatId} " +
            "order by dateSent desc " +
            "limit 1";





    @Select(SELECT_ALL_USERS)                                                  //EndPoint 1
    public ArrayList<User> getUsers();

    @Select(GET_USER_BY_ID)                                                    //EndPoint 2
    public User getUserById(int id);

    @Select(GET_CHAT_LIST)                                                     //EndPoint 3
    public ArrayList<UserChats> getChatsByUserId(int id);

    @Select(GET_CHAT_ID_FOR_USERS)                                             //EndPoint 4a
    public int getChatIdForUserIds(int id, int other_id);

    @Select(GET_MESSAGES_BY_CHAT_ID)                                           //EndPoint 4b
    public ArrayList<Message> getMessagesByChatId(int chat_id);

    @Select(FIND_USER_BY_EMAIL)                                                //Login EP
    User findUserByEmail(String email);

    @Select(GET_PHOTO_URL)
    String getPhotoUrl(int senderId);

    @Select(GET_LAST_MESSAGE)
    String getLastMessage(int chatId);
}
