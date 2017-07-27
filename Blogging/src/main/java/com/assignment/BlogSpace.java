package com.assignment;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.util.*;


public class BlogSpace {

public BlogSpace(String userName,List<Blog>  blogs){
    this.userName=userName;
    this.blogs=blogs;
}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Id
    String userName;
    @JsonProperty
    List<Blog>  blogs;

    public boolean addBlog(Blog blog){
        return blogs.add(blog);
    }

    public List<Blog> getBlogs(){return blogs;}
}
