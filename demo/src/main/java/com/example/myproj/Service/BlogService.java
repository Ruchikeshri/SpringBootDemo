package com.example.myproj.Service;

import java.util.List;

import com.example.myproj.model.Blog;

public interface BlogService {
	
	Blog SaveBlog(Blog blog);
	
	List<Blog> getAllBlogs();
	
	Blog getBlogById(int id);
	
	Blog deleteById(int id);
	
	Blog updateBlog(Blog blog);
	

}
