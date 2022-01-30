package com.example.myproj.Controller;

import java.util.List;

import com.example.myproj.Service.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproj.Service.BlogService;
import com.example.myproj.model.Blog;

@RestController
@RequestMapping(value="/api/v1/")
public class BlogController {
	
	
	private BlogService blogService;
	@Autowired
	private SequenceGenerator sequenceGenerator;
	
	@Autowired
	public BlogController(BlogService blogService,SequenceGenerator sequenceGenerator)
	{
		this.blogService=blogService;
	}
	@PostMapping("blog")
	public  ResponseEntity<Blog> SaveBlog(@RequestBody Blog blog)
	{
		blog.setBlogId((int) sequenceGenerator.generateBlogSequence(Blog.SEQUENCE_NAME));
//		Blog SavedBlog=blogService.SaveBlog(blog);

		return new ResponseEntity<>(blogService.SaveBlog(blog),HttpStatus.OK);
	}

	@GetMapping("blogs")
	public ResponseEntity<List<Blog>> getBlogs()
	{
		return new ResponseEntity<List<Blog>>((List<Blog>) blogService.getAllBlogs(),HttpStatus.OK);
	}
	
	@PutMapping("blog")
	public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog)
	{
		return new ResponseEntity<Blog>(blogService.updateBlog(blog), HttpStatus.OK);
	}
	
	@GetMapping("blog/{BlogId}")
	public ResponseEntity<Blog> getBlogId(@PathVariable("BlogId") int blogId )
	{
		return new ResponseEntity<Blog>(blogService.getBlogById(blogId),HttpStatus.OK);
	}
	@DeleteMapping("blog/{BlogId}")
	public ResponseEntity<Blog> DeleteId(@PathVariable("BlogId") int blogId)
	{
		return new ResponseEntity<Blog>(blogService.deleteById(blogId),HttpStatus.OK);
	}
}

