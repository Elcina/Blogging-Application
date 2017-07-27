package com.assignment;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.*;

public class BlogSpaces {

    public List<BlogSpace> getBlogSpace() {
        return blogSpace;
    }

    public void setBlogSpace(List<BlogSpace> blogSpace) {
        this.blogSpace = blogSpace;
    }

    @JsonProperty
    List<BlogSpace> blogSpace;


}
