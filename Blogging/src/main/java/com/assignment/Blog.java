package com.assignment;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Blog {
    public Blog(String blogId,String title, String blogDescription){
        this.blogDescription=blogDescription;
        this.blogId=blogId;
        this.title=title;
    }



    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }

    String blogDescription;

    @JsonProperty
    List<CommentRequest> comments = new LinkedList<>();

    public boolean addComment(CommentRequest commentRequest){
        return comments.add(commentRequest);

    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    String blogId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title;


}
