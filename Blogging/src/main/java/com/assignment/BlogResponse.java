package com.assignment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;


public class BlogResponse {
String usernaame;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String status;

    public String getUsernaame() {
        return usernaame;
    }

    public void setUsernaame(String usernaame) {
        this.usernaame = usernaame;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    String message;

    public BlogSpace getBlogSpace() {
        return blogSpace;
    }

    public void setBlogSpace(BlogSpace blogSpace) {
        this.blogSpace = blogSpace;
    }

    @JsonProperty
    BlogSpace blogSpace;
}
