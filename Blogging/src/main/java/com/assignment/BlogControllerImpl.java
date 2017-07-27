package com.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.*;
import java.security.SecureRandom;


@Component
public class BlogControllerImpl  {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BlogSpaceRespository blogSpaceRespository;

    public BlogSpaceResponse createBlogSpace(String name, String password){
      //  Account
        Account account =  accountRepository.findOne(name);
        BlogSpaceResponse response = new BlogSpaceResponse();
        if(account ==null){
            account = new Account(name,password);
            accountRepository.save(account);
            BlogSpace blogSpace = new BlogSpace(name,new LinkedList<>());
            blogSpaceRespository.save(blogSpace);
            response.setStatus("SUCCESS");
            response.setMessage("Account account created!");
        }else{
            if(account.getPassword().equals(password)){
                response.setStatus("SUCCESS");
                response.setMessage("Account with this name and password already registered!");
            }else{
                throw new ResourceNotFound("UserNamePassword");
            }
        }



        return response;
    }

    public BlogSpaceResponse createBlog(String userName, BlogRequest request){
        BlogSpace blogSpace = blogSpaceRespository.findOne(userName);
        BlogSpaceResponse response = new BlogSpaceResponse();
        if(blogSpace!=null){
            SecureRandom random = new SecureRandom();
            String blogId =new BigInteger(130, random).toString(32);
            Blog blog = new Blog(blogId,request.getTitle(), request.getBlogDescription());
            blogSpace.addBlog(blog);
            blogSpaceRespository.save(blogSpace);
            response.setStatus("SUCCESS");
            response.setMessage("Successfully added new blog to the blog space!");
        }else{
            throw new ResourceNotFound("blogSpace:"+userName);
        }

        return response;
    }

    public BlogResponse getBlogs(String userName){
        BlogSpace blogSpace = blogSpaceRespository.findOne(userName);
        BlogResponse response = new BlogResponse();
        if(blogSpace!=null){
            response.setUsernaame(userName);
            response.setBlogSpace(blogSpace);
            response.setStatus("SUCCESS");
            response.setMessage("Successfully retrieved blogs from blog space!");
        }else{
            throw new ResourceNotFound("blogSpace:"+userName);
        }


        return response;
    }

    public BlogSpaces getAllBlogs(){
        List<BlogSpace> blogSpace = blogSpaceRespository.findAll();
       BlogSpaces blogSpaces = new BlogSpaces();

        if(blogSpace!=null){
            blogSpaces.setBlogSpace(blogSpace);
        }else{
            throw new ResourceNotFound("blogSpace:");
        }


        return blogSpaces;
    }

    public BlogSpaceResponse addComment(String userName,String blogId, CommentRequest request){
        BlogSpace blogSpace = blogSpaceRespository.findOne(userName);
        BlogSpaceResponse response = new BlogSpaceResponse();
        if(blogSpace!=null){
            List<Blog> blogs = blogSpace.getBlogs();
            Blog blog = null;
            for (Blog x:blogs) {
                if((x.getBlogId()!=null&&x.getBlogId().equals(blogId))){
                    blog=x;
                    break;
                }

            }
            if(blog==null){
                throw new ResourceNotFound("blog:"+blogId);
            }

            blog.addComment(request);


            blogSpaceRespository.save(blogSpace);
            response.setStatus("SUCCESS");
            response.setMessage("Successfully added comment to  blog !");
        }else{
            throw new ResourceNotFound("blogSpace:"+userName);
        }

        return response;
    }
}
