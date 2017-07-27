package com.assignment;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface BlogRepository extends MongoRepository<Blog,String>{

}
