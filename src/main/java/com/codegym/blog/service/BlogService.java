package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.BlogCategoryName;

import java.util.List;

public interface BlogService extends GeneralService<Blog> {
    BlogCategoryName findById(long id);
    List<BlogCategoryName> findAllWithCategory();
}
