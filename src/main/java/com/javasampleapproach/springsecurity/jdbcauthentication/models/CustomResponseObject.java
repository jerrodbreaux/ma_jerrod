package com.javasampleapproach.springsecurity.jdbcauthentication.models;

public class CustomResponseObject <T> {
    T data;
    String error;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
