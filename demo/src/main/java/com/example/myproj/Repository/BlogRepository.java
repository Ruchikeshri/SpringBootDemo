package com.example.myproj.Repository;

import com.example.myproj.model.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog,Integer>{

}
