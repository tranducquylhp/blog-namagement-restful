package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.BlogCategoryName;
import com.codegym.blog.model.Category;
import com.codegym.blog.repository.BlogRepository;
import com.codegym.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<BlogCategoryName> findAllWithCategory() {

        List<Blog> blogs =  findAll();
        List<BlogCategoryName> blogCategoryNames = getBlogCategoryNames(blogs);
        return blogCategoryNames;
    }

    private List<BlogCategoryName> getBlogCategoryNames(List<Blog> blogs) {
        List<BlogCategoryName> blogCategoryNames = new ArrayList<>();
        for (int i=0; i<blogs.size(); i++){
            Blog blog = blogs.get(i);
            blogCategoryNames.add(new BlogCategoryName(blog.getId(),blog.getTitle(),blog.getDescription(), blog.getContent(), blog.getDateCreate(), blog.getCategory().getName()));
        }
        return blogCategoryNames;
    }

    @Override
    public BlogCategoryName findById(long id) {
        Blog blog = blogRepository.findById(id);
        return new BlogCategoryName(blog.getId(),blog.getTitle(),blog.getDescription(), blog.getContent(), blog.getDateCreate(), blog.getCategory().getName());
    }


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
}
