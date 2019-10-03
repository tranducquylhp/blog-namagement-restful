package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.BlogCategoryName;
import com.codegym.blog.model.Category;

import java.util.List;

public interface BlogRepository extends GeneralRepository<Blog> {
    Blog findById(long id);

}
