package com.assignment;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface BlogSpaceRespository extends MongoRepository<BlogSpace,String> {
}
