package com.assignment;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
    @Autowired
    BlogControllerImpl blogController;
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/blogspace/create", method = RequestMethod.POST)
    public BlogSpaceResponse createBlogSpace(@RequestBody Account account){
        return blogController.createBlogSpace(account);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/blogspace/{name}/blog/create", method = RequestMethod.POST)
    public BlogSpaceResponse createBlogSpace(@PathVariable(value="name") String name, @RequestBody BlogRequest request){
        return blogController.createBlog(name,request);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/blogspace/{name}", method = RequestMethod.GET)
    public BlogResponse createBlogSpace(@PathVariable(value="name") String name){
        return blogController.getBlogs(name);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/blogspace", method = RequestMethod.GET)
    public BlogSpaces createBlogSpace(){
        return blogController.getAllBlogs();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/blogspace/{name}/blog/{blogId}/comment", method = RequestMethod.POST)
    public BlogSpaceResponse addComment(@PathVariable(value="name") String name,@PathVariable(value="blogId") String blogId, @RequestBody CommentRequest request){
        return blogController.addComment(name,blogId,request);
    }
}
