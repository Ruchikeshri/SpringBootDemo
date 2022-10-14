package com.example.myproj.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Blog1")
public class Blog {
    @Transient
    public static final String SEQUENCE_NAME = "sequence";

    @Id
    private int blogId;
    private String blogTitle;
    private String authorName;
    private String blogContent;
    public Blog(int blogId, String blogTitle, String authorName, String blogContent) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.authorName = authorName;
        this.blogContent = blogContent;
    }

    public Blog() {
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
}
