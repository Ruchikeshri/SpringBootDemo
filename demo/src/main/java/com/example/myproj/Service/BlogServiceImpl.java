package com.example.myproj.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myproj.Repository.BlogRepository;
import com.example.myproj.model.Blog;

@Service
public class BlogServiceImpl implements BlogService{
	
	private BlogRepository blogRepository;
	
	@Autowired
	public BlogServiceImpl(BlogRepository blogRepository)
	{
		this.blogRepository=blogRepository;
	}

	@Override
	public Blog SaveBlog(Blog blog) {
		// TODO Auto-generated method stub
		
		Blog SavedBlog = blogRepository.save(blog);
		
				return SavedBlog;
	}

	@Override
	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		
		return(List<Blog>) blogRepository.findAll();
		
	}

	@Override
	public Blog getBlogById(int id) {
		// TODO Auto-generated method stub
//		Blog blog = null;
//		Optional optional =blogRepository.findById(id);
//		if(optional.isPresent()) {
		Blog	blog = blogRepository.findById(id).get();
//		}
		return blog;

//		System.out.println("Helloooooooooooooooooooooo"+blogRepository.findById(id).get());
//		return blog;
//		return null;
	}

	@Override
	public Blog deleteById(int id) {
		// TODO Auto-generated method stub
	Blog blog=null;
		Optional optional = blogRepository.findById(id);
		if(optional.isPresent())
		{
			blog = blogRepository.findById(id).get();
			blogRepository.deleteById(id);
		}

		return blog;
	}

	@Override
	public Blog updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		
		Blog UpdatedBlog= null;
		Blog ActualBlog = getBlogById(blog.getBlogId());
		ActualBlog.setAuthorName(blog.getAuthorName());
		UpdatedBlog=   blogRepository.save(ActualBlog);
		return UpdatedBlog;
	}
	
	
}
