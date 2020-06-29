package com.javasampleapproach.springsecurity.jdbcauthentication.models;


import java.sql.Date;
import java.text.DateFormat;

public class UserChats {
    String chatName;
    int chatId;
    int senderId;
    //Date dateSent;
    String dateSent;
    String lastMessage;
    String photoUrl;

    //String photoUrl = "https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png";




    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getDateSent() {
        return dateSent;
    }

    public void setDateSent(String dateSent) {
        this.dateSent = dateSent;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
